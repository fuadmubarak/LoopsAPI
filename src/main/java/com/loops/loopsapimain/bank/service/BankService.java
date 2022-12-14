package com.loops.loopsapimain.bank.service;

import com.loops.loopsapimain.bank.dto.DTOBank;
import com.loops.loopsapimain.bank.entity.Bank;
import com.loops.loopsapimain.bank.repository.BankRepository;
import com.loops.loopsapimain.common.APIResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankService {

    @Autowired
    BankRepository bankRepository;

    public APIResponse checkVA(DTOBank dtoBank){

        APIResponse apiResponse = new APIResponse();

        Bank bank = bankRepository.findByBankVA(dtoBank.getBankVA());

        if (bank == null){
            apiResponse.setData("No Bank Virtual Account Detected!!!");
        }else {
            apiResponse.setData("Bank Virtual Account Checked");
        }

        return apiResponse;

    }

}
