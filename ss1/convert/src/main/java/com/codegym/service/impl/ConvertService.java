package com.codegym.service.impl;

import com.codegym.repository.impl.ConvertRepository;
import com.codegym.repository.IConvertRepository;
import com.codegym.service.IConvertService;

public class ConvertService implements IConvertService {
    private IConvertRepository iConvertRepository = new ConvertRepository();
    @Override
    public double convert(double usa) {
        return iConvertRepository.convert(usa);
    }
}
