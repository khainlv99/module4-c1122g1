package com.codegym.repository;

public class ChuyenDoiRepository implements IChuyenDoiRepository{

    @Override
    public double chuyenDoi(double doLa) {
        double vietNam = doLa*23521;
        return vietNam;
    }
}
