package com.loops.loopsapimain.merchant.service;

import com.loops.loopsapimain.common.APIResponse;
import com.loops.loopsapimain.merchant.dto.DTOCheckMerchant;
import com.loops.loopsapimain.merchant.entity.Merchant;
import com.loops.loopsapimain.merchant.repository.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckMerchantService {

    @Autowired
    MerchantRepository merchantRepository;

    public APIResponse check(DTOCheckMerchant dtoCheckMerchant){

        APIResponse apiResponse = new APIResponse();

        Merchant merchant = merchantRepository.findOneByMerchNoPel(dtoCheckMerchant.getMerchNoPel());

        if (merchant == null){
            apiResponse.setData("No Pel Tidak Ada");
        }else {
            apiResponse.setData("Check Success");
        }

        return apiResponse;

    }


}
