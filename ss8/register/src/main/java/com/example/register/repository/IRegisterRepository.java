package com.example.register.repository;

import com.example.register.model.Register;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IRegisterRepository extends PagingAndSortingRepository<Register,Integer> {
}
