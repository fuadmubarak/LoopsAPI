package com.loops.loopsapimain.history.controller;

import com.loops.loopsapimain.exception.DataNotFoundException;
import com.loops.loopsapimain.history.entity.History;
import com.loops.loopsapimain.history.repository.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.DateTimeException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/loops/api/history")
public class HistoryController {

    @Autowired
    HistoryRepository historyRepository;

    @PostMapping("/history")
    public History addNewHistoryData(@Valid @RequestBody History history){

        return historyRepository.save(history);

    }


    @GetMapping("/history")
    public List<History> findAllHistoryData(){

        return historyRepository.findAll();

    }


    @GetMapping("/history/find/{ref}")
    public List<History> findHistoryDataByReference(@PathVariable(value = "ref") String historyReference){

        return historyRepository.findByHistoryReference(historyReference);

    }


    @GetMapping("/history/{id}")
    public ResponseEntity<History> findHistoryDataById(@PathVariable(value = "id") Long historyId) throws DataNotFoundException{

        History history = historyRepository.findById(historyId)
                .orElseThrow(() -> new DataNotFoundException("History Dengan NIP: "+historyId+", Tidak Ditemukan"));

        return ResponseEntity.ok().body(history);

    }


    @PutMapping("/history/{id}")
    public ResponseEntity<History> updateHistoryData(@PathVariable(value = "id")Long historyId, @Valid @RequestBody History historyDetails) throws DataNotFoundException {

        History history = historyRepository.findById(historyId)
                .orElseThrow(() -> new DataNotFoundException("History Dengan ID"+ historyId +"Tidak Ditemukan"));

        history.setHistoryCompany(historyDetails.getHistoryCompany());
        history.setHistoryName(historyDetails.getHistoryName());
        history.setHistoryReference(historyDetails.getHistoryReference());
        history.setHistoryDescription(historyDetails.getHistoryDescription());
        history.setHistoryBills(historyDetails.getHistoryBills());
//        history.setHistoryCreated(historyDetails.getHistoryCreated());

        History updateHistory = historyRepository.save(history);

        return ResponseEntity.ok().body(updateHistory);

    }


    @DeleteMapping("/history/{id}")
    public Map<String, Boolean> deleteHistoryData(@PathVariable(value = "id") Long historyId) throws DataNotFoundException{

        History history = historyRepository.findById(historyId)
                .orElseThrow(() -> new DataNotFoundException("History Dengan ID"+ historyId +"Tidak Ditemukan"));

        historyRepository.delete(history);
        Map<String, Boolean> response = new HashMap<>();
        response.put("History Deleted", Boolean.TRUE);

        return response;

    }

}
