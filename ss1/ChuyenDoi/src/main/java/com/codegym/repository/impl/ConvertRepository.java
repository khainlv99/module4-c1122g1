package com.codegym.repository.impl;

import com.codegym.repository.IConvertRepository;

public class ConvertRepository implements IConvertRepository {

    @Override
    public double chuyenDoi(double usa) {
        double vietNam = usa * 23521;
        return vietNam;
    }
}
