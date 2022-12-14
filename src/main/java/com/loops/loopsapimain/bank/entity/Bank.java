package com.loops.loopsapimain.bank.entity;

import javax.persistence.*;

@Entity
@Table(name = "bank")
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bankId;
    @Column(name = "bank_name" )
    private String bankName;
    @Column(name = "bank_va" )
    private Long bankVA;
    @Column(name = "bank_csname" )
    private String BankCSName;
    @Column(name = "bank_balance" )
    private Long bankBalance;


    public Bank() {
    }

    public Bank(Long bankId, String bankName, Long bankVA, String bankCSName, Long bankBalance) {
        this.bankId = bankId;
        this.bankName = bankName;
        this.bankVA = bankVA;
        this.BankCSName = bankCSName;
        this.bankBalance = bankBalance;
    }

    public Long getBankId() {
        return bankId;
    }

    public void setBankId(Long bankId) {
        this.bankId = bankId;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public Long getBankVA() {
        return bankVA;
    }

    public void setBankVA(Long bankVA) {
        this.bankVA = bankVA;
    }

    public String getBankCSName() {
        return BankCSName;
    }

    public void setBankCSName(String bankCSName) {
        BankCSName = bankCSName;
    }

    public Long getBankBalance() {
        return bankBalance;
    }

    public void setBankBalance(Long bankBalance) {
        this.bankBalance = bankBalance;
    }

}
