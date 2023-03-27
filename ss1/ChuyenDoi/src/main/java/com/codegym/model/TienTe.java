package com.codegym.model;

public class TienTe {
    private Double doLa;
    private Double vietNam;

    public TienTe() {
    }

    public TienTe(Double doLa, Double vietNam) {
        this.doLa = doLa;
        this.vietNam = vietNam;
    }

    public Double getDoLa() {
        return doLa;
    }

    public void setDoLa(Double doLa) {
        this.doLa = doLa;
    }

    public Double getVietNam() {
        return vietNam;
    }

    @Override
    public String toString() {
        return "TienTe{" +
                "doLa=" + doLa +
                ", vietNam=" + vietNam +
                '}';
    }

    public void setVietNam(Double vietNam) {
        this.vietNam = vietNam;
    }
}
