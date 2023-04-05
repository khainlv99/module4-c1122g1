package com.example.register.service;

import com.example.register.dto.RegisterDTO;
import com.example.register.model.Register;

import java.util.List;

public interface IRegisterService {
    List<Register> findAll();
    void create(RegisterDTO register);
}
