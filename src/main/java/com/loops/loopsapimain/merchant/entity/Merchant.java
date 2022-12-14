package com.loops.loopsapimain.merchant.entity;

import javax.persistence.*;

@Entity
@Table(name = "merchant")
public class Merchant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long merchId;
    @Column(name = "merch_no_pel", nullable = false)
    private Long merchNoPel;
    @Column(name = "merch_name", nullable = false)
    private String merchName;
    @Column(name = "merch_costumer_name", nullable = false)
    private String merchCostumerName;
    @Column(name = "merch_bill", nullable = false)
    private Long merchBill;

    public Merchant() {
    }

    public Merchant(Long merchId, Long merchNoPel, String merchCostumerName, String merchName, Long merchBill) {
        this.merchId = merchId;
        this.merchNoPel = merchNoPel;
        this.merchName = merchName;
        this.merchCostumerName = merchCostumerName;
        this.merchBill = merchBill;
    }

    public Long getMerchId() {
        return merchId;
    }

    public void setMerchId(Long merchId) {
        this.merchId = merchId;
    }

    public Long getMerchNoPel() {
        return merchNoPel;
    }

    public void setMerchNoPel(Long merchNoPel) {
        this.merchNoPel = merchNoPel;
    }


    public String getMerchName() {
        return merchName;
    }

    public void setMerchName(String merchName) {
        this.merchName = merchName;
    }

    public String getMerchCostumerName() {
        return merchCostumerName;
    }

    public void setMerchCostumerName(String merchCostumerName) {
        this.merchCostumerName = merchCostumerName;
    }

    public Long getMerchBill() {
        return merchBill;
    }

    public void setMerchBill(Long merchBill) {
        this.merchBill = merchBill;
    }
}
