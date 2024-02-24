package com.corenetworks.hotelMascotas.service.impl;

import com.corenetworks.hotelMascotas.modelo.Mascota;
import com.corenetworks.hotelMascotas.repository.IGenericoRepositorio;
import com.corenetworks.hotelMascotas.repository.IMascotaRepositorio;
import com.corenetworks.hotelMascotas.service.IMascotaServicio;
import org.springframework.beans.factory.annotation.Autowired;

public class MascotaServicioImpl extends ICRUDImpl<Mascota,Integer>implements IMascotaServicio {
    @Autowired
    private IMascotaRepositorio repo;
    @Override
    protected IGenericoRepositorio<Mascota, Integer> getRepo() {
        return repo;
    }
}
