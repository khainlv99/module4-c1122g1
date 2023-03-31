package com.codegym.repository.impl;

import com.codegym.model.Settings;
import com.codegym.repository.ISettingsRepository;
import org.springframework.stereotype.Repository;


@Repository
public class SettingsRepository implements ISettingsRepository {
    @Override
    public String[] languages() {
        return new String[]{"English", "Vietnamese", "Japanese", "Chinese"};
    }

    @Override
    public Integer[] pageSizes() {
        return new Integer[]{5, 10, 15, 25, 50, 100};
    }
}
