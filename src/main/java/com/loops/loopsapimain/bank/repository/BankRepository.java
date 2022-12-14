package com.loops.loopsapimain.bank.repository;

import com.loops.loopsapimain.bank.entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BankRepository extends JpaRepository<Bank, Long> {



    Bank findByBankVA(Long bankVA);

}
