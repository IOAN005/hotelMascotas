package com.corenetworks.hotelMascotas.service.impl;

import com.corenetworks.hotelMascotas.modelo.Cliente;
import com.corenetworks.hotelMascotas.repository.IClienteRepositorio;
import com.corenetworks.hotelMascotas.repository.IGenericoRepositorio;
import com.corenetworks.hotelMascotas.service.IClienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServicioImpl extends ICRUDImpl<Cliente,Integer> implements IClienteServicio {
    @Autowired
    private IClienteRepositorio repo;
    @Override
    protected IGenericoRepositorio<Cliente, Integer> getRepo() {

        return repo;
    }
}
