package com.example.evaluacion3.services;

import com.example.evaluacion3.model.Orden;
import com.example.evaluacion3.repositories.IBaseRepository;
import com.example.evaluacion3.repositories.IOrdenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrdenService extends BaseService<Orden, Integer> implements IOrdenService{

    @Autowired
    private IOrdenRepository ordenRepository;

    public OrdenService(IBaseRepository<Orden, Integer> baseRepository) {
        super(baseRepository);
    }
}