package com.codegym.model;

public class Currency {
    private Double usd;
    private Double vietNam;

    public Currency() {
    }

    public Currency(Double usd, Double vietNam) {
        this.usd = usd;
        this.vietNam = vietNam;
    }

    public Double getusd() {
        return usd;
    }

    public void setusd(Double usd) {
        this.usd = usd;
    }

    public Double getVietNam() {
        return vietNam;
    }

    @Override
    public String toString() {
        return "TienTe{" +
                "usd=" + usd +
                ", vietNam=" + vietNam +
                '}';
    }

    public void setVietNam(Double vietNam) {
        this.vietNam = vietNam;
    }
}
