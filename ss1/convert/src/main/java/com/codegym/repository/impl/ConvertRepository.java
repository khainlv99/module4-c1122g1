package com.codegym.repository.impl;

import com.codegym.repository.IConvertRepository;

public class ConvertRepository implements IConvertRepository {

    @Override
    public double convert(double usa) {
        double vietNam = usa * 23521;
        return vietNam;
    }
}
