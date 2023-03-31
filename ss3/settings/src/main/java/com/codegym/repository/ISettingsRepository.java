package com.codegym.repository;

import com.codegym.model.Settings;

public interface ISettingsRepository {
    String[] languages();

    Integer[] pageSizes();
}
