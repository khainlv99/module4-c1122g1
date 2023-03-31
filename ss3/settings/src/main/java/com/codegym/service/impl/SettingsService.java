package com.codegym.service.impl;

import com.codegym.model.Settings;
import com.codegym.repository.ISettingsRepository;
import com.codegym.repository.impl.SettingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SettingsService implements ISettingsRepository {
    private final ISettingsRepository repository;

    public SettingsService(ISettingsRepository repository) {
        this.repository = repository;
    }

    @Override
    public String[] languages() {
        return repository.languages();
    }

    @Override
    public Integer[] pageSizes() {
        return repository.pageSizes();
    }
}
