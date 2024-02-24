package com.corenetworks.hotelMascotas.service.impl;

import com.corenetworks.hotelMascotas.modelo.DetalleFactura;
import com.corenetworks.hotelMascotas.repository.IDetalleFacturaRepositorio;
import com.corenetworks.hotelMascotas.repository.IGenericoRepositorio;
import com.corenetworks.hotelMascotas.service.IDetallesFacturaServicio;
import org.springframework.beans.factory.annotation.Autowired;

public class DetalleFacturaServicioImpl extends ICRUDImpl <DetalleFactura,Integer> implements IDetallesFacturaServicio {
    @Autowired
    private IDetalleFacturaRepositorio repo;
    @Override
    protected IGenericoRepositorio<DetalleFactura, Integer> getRepo() {
        return repo;
    }
}
