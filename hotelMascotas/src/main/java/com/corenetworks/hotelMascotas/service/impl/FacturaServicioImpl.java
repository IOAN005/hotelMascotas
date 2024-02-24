package com.corenetworks.hotelMascotas.service.impl;

import com.corenetworks.hotelMascotas.modelo.Factura;
import com.corenetworks.hotelMascotas.repository.IFacturaRepositorio;
import com.corenetworks.hotelMascotas.repository.IGenericoRepositorio;
import com.corenetworks.hotelMascotas.service.IFacturaServicio;
import org.springframework.beans.factory.annotation.Autowired;

public class FacturaServicioImpl extends ICRUDImpl<Factura,Integer> implements IFacturaServicio {
    @Autowired
    private IFacturaRepositorio repo;
    @Override
    protected IGenericoRepositorio<Factura, Integer> getRepo() {
        return repo;
    }
}
