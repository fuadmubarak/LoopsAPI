package com.loops.loopsapimain.merchant.controller;

import com.loops.loopsapimain.common.APIResponse;
import com.loops.loopsapimain.exception.DataNotFoundException;
import com.loops.loopsapimain.merchant.dto.DTOCheckMerchant;
import com.loops.loopsapimain.merchant.entity.Merchant;
import com.loops.loopsapimain.merchant.repository.MerchantRepository;
import com.loops.loopsapimain.merchant.service.CheckMerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("loops/api/merchant")
public class MerchantController {

    @Autowired
    MerchantRepository merchantRepository;
    @Autowired
    CheckMerchantService checkMerchantService;

    //YANG DIPAKAI DI APLIKASI HANYA GET BY NOMOR PELANGGAN SAMA POST REQUEST
    //UNTUK NGECEK APAKAH NOMOR PELANGGAN ITU ADA DI DB NYA.
    //SISANYA ITU UNTUK NGEBANTU BIKIN DUMMYNYA AJA LEWAT POSTMAN
    //KAN "CERITANYA" INI KITA NGAMBIL API BPJS, PLN, DLL. TAPI KITA BUAT
    //DUMMY SENDIRI

    //INI DIPAKAI DI APLIKASI
    //UNTUK DAPATKAN DATA BEDASARKAN NOMOR PELANGGAN
    @GetMapping("/merch/find/{nopel}")
    public List<Merchant> getMerchByNoPel(@PathVariable(value = "nopel") Long merchNoPel){

        return merchantRepository.findByMerchNoPel(merchNoPel);

    }

    //POST REQUEST UNTUK NYARI TAHU KALAU ADA ATAU TIDAK NOMOR PELANGGANNYA
    @PostMapping("/merch/check")
    public ResponseEntity<APIResponse> checkMerchNoPel(@Valid @RequestBody DTOCheckMerchant dtoCheckMerchant){

        APIResponse apiResponse = checkMerchantService.check(dtoCheckMerchant);

        return ResponseEntity
                .status(apiResponse.getStatus())
                .body(apiResponse);

    }

//======================================================================================================================

    //DARI BAGIAN SINI KEBAWAH HANYA UNTUK MEMBANTU MEMASUKKAN / MENCARI / MEN UPDATE / DAN MEN DELETE DATA YANG ADA

//======================================================================================================================

    // BUAT MASUKIN DATA MERCHANT (INI MASUKINNYA MANUAL EMANG KARENA "CERITANYA" API EXTERNAL)
    @PostMapping("/merch")
    public Merchant addMerchantData(@Valid @RequestBody Merchant merchant){

        return merchantRepository.save(merchant);

    }


    // NGAMBIL SEMUA DATA MERCHANT YANG ADA
    @GetMapping("/merch")
    public List<Merchant> getAllMerchantData(){

        return merchantRepository.findAll();

    }


    // AMBIL DATA MERCHANT SESUAI DENGAN ID NYA
    @GetMapping("/merch/{id}")
    public ResponseEntity<Merchant> getMerchantById(@PathVariable(value = "id") Long merchId) throws DataNotFoundException {

        Merchant merchant = merchantRepository.findById(merchId)
                .orElseThrow(() -> new DataNotFoundException("Merchant Dengan ID :" + merchId + "Tidak Ada"));

        return ResponseEntity.ok().body(merchant);

    }


    // INI BUAT DELETE DATA YANG ADA SESUAI DENGAN ID (SAMA DELETENYA JUGA LEWAT POSTMAN SOALNYA INI API EXTERNAL "CERITANYA")
    @DeleteMapping("/merch/{id}")
    public Map<String, Boolean> deleteMerchantById(@PathVariable(value = "id") Long merchId) throws DataNotFoundException{

        Merchant merchant = merchantRepository.findById(merchId)
                .orElseThrow(() -> new DataNotFoundException("Merchant Dengan ID :" + merchId + "Tidak Ada"));

        merchantRepository.delete(merchant);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Merchant Deleted!", Boolean.TRUE);

        return response;

    }


    // INI UNTUK UPDATE DATA MERCHANT YANG UDAH ADA (KALO MAU DI UPDATE ATAU ADA YANG SALAH) ** (MANUAL UPDATE LEWAT POSTMAN KARENA API EXTERNAL "CERITANYA")
    @PutMapping("/merch/{id}")
    public ResponseEntity<Merchant> updateMerchantData(@PathVariable(value = "id") Long merchId,@RequestBody @Valid Merchant merchDetails) throws DataNotFoundException{

        Merchant merchant = merchantRepository.findById(merchId)
                .orElseThrow(() -> new DataNotFoundException("Merchant Dengan ID :" + merchId + "Tidak Ada"));

        merchant.setMerchNoPel(merchDetails.getMerchNoPel());
        merchant.setMerchName(merchDetails.getMerchName());
        merchant.setMerchCostumerName(merchDetails.getMerchCostumerName());
        merchant.setMerchBill(merchDetails.getMerchBill());


        Merchant updatedMerch = merchantRepository.save(merchant);
        return ResponseEntity.ok(updatedMerch);

    }


}
