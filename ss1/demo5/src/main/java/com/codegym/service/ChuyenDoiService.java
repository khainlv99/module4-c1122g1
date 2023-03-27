package com.codegym.service;

import com.codegym.repository.ChuyenDoiRepository;
import com.codegym.repository.IChuyenDoiRepository;

public class ChuyenDoiService implements IChuyenDoiService{
    IChuyenDoiRepository iChuyenDoiRepository = new ChuyenDoiRepository();
    @Override
    public double chuyenDoi(double doLa) {
        return iChuyenDoiRepository.chuyenDoi(doLa);
    }
}
