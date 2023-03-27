package com.codegym.service.impl;

import com.codegym.repository.ITranslateRepository;
import com.codegym.repository.impl.TranslateRepository;
import com.codegym.service.ITranslateService;

public class TranslateService implements ITranslateService {
    ITranslateRepository iTranslateRepository = new TranslateRepository();
    @Override
    public String translate(String name) {
        return iTranslateRepository.translate(name);
    }
}
