package com.codegym.model;

public class Currency {
    private Double usa;
    private Double vietNam;

    public Currency() {
    }

    public Currency(Double usa, Double vietNam) {
        this.usa = usa;
        this.vietNam = vietNam;
    }

    public Double getusa() {
        return usa;
    }

    public void setusa(Double usa) {
        this.usa = usa;
    }

    public Double getVietNam() {
        return vietNam;
    }

    @Override
    public String toString() {
        return "TienTe{" +
                "usa=" + usa +
                ", vietNam=" + vietNam +
                '}';
    }

    public void setVietNam(Double vietNam) {
        this.vietNam = vietNam;
    }
}
