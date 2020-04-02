package com.aimbra.sied.business.services;

import com.aimbra.sied.domain.entities.InfoEntity;
import com.aimbra.sied.infra.repositories.InfoRepository;
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

    public InfoEntity save(InfoEntity entity) {
        return repository.save(entity);
    }

}
