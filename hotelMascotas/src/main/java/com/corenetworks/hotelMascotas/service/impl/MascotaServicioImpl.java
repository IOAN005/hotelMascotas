package com.corenetworks.hotelMascotas.service.impl;

import com.corenetworks.hotelMascotas.dto.MascotaDTO;
import com.corenetworks.hotelMascotas.modelo.Mascota;
import com.corenetworks.hotelMascotas.repository.IGenericoRepositorio;
import com.corenetworks.hotelMascotas.repository.IMascotaRepositorio;
import com.corenetworks.hotelMascotas.service.IMascotaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MascotaServicioImpl extends ICRUDImpl<Mascota,Integer>implements IMascotaServicio {
    @Autowired
    private IMascotaRepositorio repo;
    @Override
    protected IGenericoRepositorio<Mascota, Integer> getRepo() {
        return repo;
    }

    @Override
    public Integer insert1(MascotaDTO m) {

        return repo.inserta1(m.getEdad(),m.getNombre(),m.getRaza(),m.getTamano(),m.getTipoHabitacion(),m.getIdCliente());
    }
}
