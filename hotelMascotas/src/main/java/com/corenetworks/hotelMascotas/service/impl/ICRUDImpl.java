package com.corenetworks.hotelMascotas.service.impl;

import com.corenetworks.hotelMascotas.repository.IGenericoRepositorio;
import com.corenetworks.hotelMascotas.service.ICRUD;

import java.util.List;

public  abstract   class ICRUDImpl<T,ID> implements ICRUD<T,ID> {

    protected abstract IGenericoRepositorio<T,ID> getRepo() ;
    @Override
    public List<T> consultarTodos() throws Exception {
        return getRepo().findAll();
    }

    @Override
    public T consultarUno(ID id) throws Exception {
        return getRepo().findById(id).orElse(null);
    }

    @Override
    public T insertar(T t) throws Exception {
        return getRepo().save(t);
    }

    @Override
    public T modificar(T t) throws Exception {
        return getRepo().save(t);
    }

    @Override
    public void eliminar(ID id) throws Exception {
        getRepo().deleteById(id);


    }




}
