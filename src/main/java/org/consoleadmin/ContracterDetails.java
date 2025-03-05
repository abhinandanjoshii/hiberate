package org.consoleadmin;

import jakarta.persistence.Embeddable;

@Embeddable
public class ContracterDetails {

    private String companyName;
    private String coveredAreaName;
    private int paymentAmount;

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
                "companyName='" + companyName + '\'' +
                ", coveredAreaName='" + coveredAreaName + '\'' +
                ", paymentAmount=" + paymentAmount +
                '}';
    }
}
