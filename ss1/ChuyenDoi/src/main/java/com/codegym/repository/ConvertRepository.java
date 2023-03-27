package com.codegym.repository;

public class ConvertRepository implements IConvertRepository {

    @Override
    public double chuyenDoi(double usa) {
        double vietNam = usa * 23521;
        return vietNam;
    }
}
