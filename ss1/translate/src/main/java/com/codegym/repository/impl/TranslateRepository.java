package com.codegym.repository.impl;

import com.codegym.repository.ITranslateRepository;

public class TranslateRepository implements ITranslateRepository {
    private String arr[] = {"Một","Hai","Ba","Bốn","Năm"};
    private String arr1[] = {"One","Two","Three","Four","Five"};


    @Override
    public String translate(String name) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].equals(name)){
                return arr1[i];
            }
        }
        return name;
    }
}
