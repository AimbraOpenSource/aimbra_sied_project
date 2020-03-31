package com.aimbra.sied.domain.services;

import com.aimbra.sied.domain.entities.InfoEntity;
import com.aimbra.sied.domain.repositories.InfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfoService {

    @Autowired
    private InfoRepository repository;

    public List<InfoEntity> findAll() {
        List<InfoEntity> all = repository.findAll();
        return all;
    }

}
