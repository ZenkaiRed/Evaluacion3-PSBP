package com.example.evaluacion3.services;

import com.example.evaluacion3.model.Base;

import java.io.Serializable;
import java.util.List;

public interface IBaseService<E extends Base, ID extends Serializable> {

    List<E> findAll() throws Exception;

    E findById(ID id) throws Exception;

    E save(E entity) throws Exception;

    E update(ID id, E entity) throws Exception;

    boolean delete(ID id) throws Exception;

}
