package com.corenetworks.hotelMascotas.service;

import com.corenetworks.hotelMascotas.modelo.Cliente;
import com.corenetworks.hotelMascotas.repository.IClienteRepository;
import com.corenetworks.hotelMascotas.repository.IGenericoRepositori;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServicioImpl extends ICRUDImpl <Cliente,Integer>implements IClienteService{
    @Autowired
    private IClienteRepository repo;
    @Override
    protected IGenericoRepositori<Cliente, Integer> getRepo() {
        return repo;
    }
}
