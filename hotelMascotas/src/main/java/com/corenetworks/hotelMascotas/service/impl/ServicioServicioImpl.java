package com.corenetworks.hotelMascotas.service.impl;

import com.corenetworks.hotelMascotas.modelo.Servicio;
import com.corenetworks.hotelMascotas.repository.IGenericoRepositorio;
import com.corenetworks.hotelMascotas.repository.IServicioRepositorio;
import com.corenetworks.hotelMascotas.service.IServicioServicio;
import org.springframework.beans.factory.annotation.Autowired;

public class ServicioServicioImpl extends ICRUDImpl<Servicio,Integer>implements IServicioServicio {
    @Autowired
    private IServicioRepositorio repo;
    @Override
    protected IGenericoRepositorio<Servicio, Integer> getRepo() {
        return repo;
    }
}
