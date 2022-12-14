package com.loops.loopsapimain.history.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "history")
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long historyId;
    @Column(name = "history_name")
    private String historyName;
    @Column(name = "history_company")
    private String historyCompany;
    @Column(name = "history_reference")
    private String historyReference;
    @Column(name = "history_description")
    private String historyDescription;
    @Column(name = "history_bills")
    private Long historyBills;
    @Column(name = "history_created")
    private Date historyCreated = new Date(System.currentTimeMillis());

    public History() {
    }

    public History(Long historyId, String historyName, String historyCompany, String historyReference, String historyDescription, Long historyBills, Date historyCreated) {
        this.historyId = historyId;
        this.historyName = historyName;
        this.historyCompany = historyCompany;
        this.historyReference = historyReference;
        this.historyDescription = historyDescription;
        this.historyBills = historyBills;
        this.historyCreated = historyCreated;
    }

    public Long getHistoryId() {
        return historyId;
    }

    public void setHistoryId(Long historyId) {
        this.historyId = historyId;
    }

    public String getHistoryName() {
        return historyName;
    }

    public void setHistoryName(String historyName) {
        this.historyName = historyName;
    }

    public String getHistoryCompany() {
        return historyCompany;
    }

    public void setHistoryCompany(String historyCompany) {
        this.historyCompany = historyCompany;
    }

    public String getHistoryReference() {
        return historyReference;
    }

    public void setHistoryReference(String historyReference) {
        this.historyReference = historyReference;
    }

    public String getHistoryDescription() {
        return historyDescription;
    }

    public void setHistoryDescription(String historyDescription) {
        this.historyDescription = historyDescription;
    }

    public Long getHistoryBills() {
        return historyBills;
    }

    public void setHistoryBills(Long historyBills) {
        this.historyBills = historyBills;
    }

    public Date getHistoryCreated() {
        return historyCreated;
    }

    public void setHistoryCreated(Date historyCreated) {
        this.historyCreated = historyCreated;
    }

}
