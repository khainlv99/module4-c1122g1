package com.codegym.repository.impl;

import com.codegym.repository.ITranslateRepository;

public class TranslateRepository implements ITranslateRepository {
    private String arrEng[] = {"Một","Hai","Ba","Bốn","Năm"};
    private String arrViet[] = {"One","Two","Three","Four","Five"};


    @Override
    public String translate(String name) {
        for (int i = 0; i < arrEng.length; i++) {
            if(arrEng[i].equals(name)){
                return arrViet[i];
            }
        }
        return name;
    }
}
