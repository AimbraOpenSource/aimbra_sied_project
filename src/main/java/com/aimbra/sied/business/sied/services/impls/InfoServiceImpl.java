package com.aimbra.sied.business.sied.services.impls;


import com.aimbra.sied.domain.sied.entities.InfoEntity;
import com.aimbra.sied.infra.repositories.InfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfoServiceImpl {

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
