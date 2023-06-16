package com.example.evaluacion3.services;

import com.example.evaluacion3.model.Platillo;
import com.example.evaluacion3.repositories.IBaseRepository;
import com.example.evaluacion3.repositories.IPlatilloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlatilloService extends BaseService<Platillo, Integer> implements IPlatilloService{

    @Autowired
    private IPlatilloRepository platilloRepository;

    public PlatilloService(IBaseRepository<Platillo, Integer> baseRepository) {
        super(baseRepository);
    }
}
