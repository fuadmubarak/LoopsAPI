package com.loops.loopsapimain.bank.controller;

import com.loops.loopsapimain.bank.dto.DTOBank;
import com.loops.loopsapimain.bank.entity.Bank;
import com.loops.loopsapimain.bank.repository.BankRepository;
import com.loops.loopsapimain.bank.service.BankService;
import com.loops.loopsapimain.common.APIResponse;
import com.loops.loopsapimain.exception.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/loops/api/bank")
public class BankController {

    @Autowired
    BankRepository bankRepository;
    @Autowired
    BankService bankService;

    @PostMapping("/bank/request")
    public ResponseEntity<APIResponse> checkBankVA(@Valid @RequestBody DTOBank dtoBank){

        APIResponse apiResponse = bankService.checkVA(dtoBank);

        return ResponseEntity
                .status(apiResponse.getStatus())
                .body(apiResponse);

    }

    @PostMapping("/bank")
    public Bank addNewBankData(@Valid @RequestBody Bank bank){

        return bankRepository.save(bank);

    }

    @GetMapping("/bank/find/{va}")
    public ResponseEntity<Bank> getBankDataByVA(@PathVariable(name = "va") Long bankVA){

        Bank bank = bankRepository.findByBankVA(bankVA);

        return ResponseEntity.ok().body(bank);

    }

    @GetMapping("/bank")
    List<Bank> getAllBankData(){

        return bankRepository.findAll();

    }

    @PutMapping("/bank/{id}")
    ResponseEntity<Bank> updateBankData(@PathVariable(value = "id") Long bankId, @Valid @RequestBody Bank bankDetails) throws DataNotFoundException {

        Bank bank = bankRepository.findById(bankId)
                .orElseThrow(() -> new DataNotFoundException("Data Bank Dengan ID: "+bankId+", Tidak Ditemukan"));

        bank.setBankName(bankDetails.getBankName());
        bank.setBankVA(bankDetails.getBankVA());
        bank.setBankCSName(bankDetails.getBankCSName());
        bank.setBankBalance(bankDetails.getBankBalance());

        Bank updatedBank = bankRepository.save(bank);
        return ResponseEntity.ok(updatedBank);

    }

}
