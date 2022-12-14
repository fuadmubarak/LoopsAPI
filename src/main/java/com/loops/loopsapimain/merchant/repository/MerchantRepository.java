package com.loops.loopsapimain.merchant.repository;

import com.loops.loopsapimain.merchant.entity.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MerchantRepository extends JpaRepository<Merchant, Long> {

    List<Merchant> findByMerchNoPel(Long merchNoPel);

    Merchant findOneByMerchNoPel(Long merchNoPel);
}
