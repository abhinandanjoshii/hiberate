package org.consoleadmin;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class ContracterDetails {

    @Id
    private int cId;
    private String companyName;
    private String coveredAreaName;
    private int paymentAmount;
    @ManyToOne
    private Contracter contracter;

    public int getcId() {
        return cId;
    }

    public Contracter getContracter() {
        return contracter;
    }

    public void setContracter(Contracter contracter) {
        this.contracter = contracter;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCoveredAreaName() {
        return coveredAreaName;
    }

    public void setCoveredAreaName(String coveredAreaName) {
        this.coveredAreaName = coveredAreaName;
    }

    public int getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(int paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    @Override
    public String toString() {
        return "ContracterDetails{" +
                "cId=" + cId +
                ", companyName='" + companyName + '\'' +
                ", coveredAreaName='" + coveredAreaName + '\'' +
                ", paymentAmount=" + paymentAmount +
                '}';
    }
}
