package com.codegym.service;

import com.codegym.repository.ConvertRepository;
import com.codegym.repository.IConvertRepository;

public class ConvertService implements IConvertService {
    IConvertRepository iConvertRepository = new ConvertRepository();
    @Override
    public double chuyenDoi(double usa) {
        return iConvertRepository.chuyenDoi(usa);
    }
}
