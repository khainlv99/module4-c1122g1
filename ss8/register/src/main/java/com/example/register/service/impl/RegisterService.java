package com.example.register.service.impl;

import com.example.register.dto.RegisterDTO;
import com.example.register.model.Register;
import com.example.register.repository.IRegisterRepository;
import com.example.register.service.IRegisterService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisterService implements IRegisterService {

    private final IRegisterRepository repository;

    public RegisterService(IRegisterRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Register> findAll() {
        return (List<Register>) repository.findAll();
    }

    @Override
    public void create(RegisterDTO registerDTO) {
        Register register = new Register();
        BeanUtils.copyProperties(registerDTO, register);
        repository.save(register);
    }
}
