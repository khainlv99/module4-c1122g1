package com.codegym.service.impl;

import com.codegym.repository.impl.ConvertRepository;
import com.codegym.repository.IConvertRepository;
import com.codegym.service.IConvertService;

public class ConvertService implements IConvertService {
    @Override
    public double convert(double usd) {
        double vietNam = usd * 23521;
        return vietNam;
    }
}
