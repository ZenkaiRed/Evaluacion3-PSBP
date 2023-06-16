package com.example.evaluacion3.services;

import com.example.evaluacion3.model.Usuario;
import com.example.evaluacion3.repositories.IBaseRepository;
import com.example.evaluacion3.repositories.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService extends BaseService<Usuario, Integer> implements IUsuarioService{

    @Autowired
    private IUsuarioRepository usuarioRepository;

    public UsuarioService(IBaseRepository<Usuario, Integer> baseRepository) {
        super(baseRepository);
    }
}
