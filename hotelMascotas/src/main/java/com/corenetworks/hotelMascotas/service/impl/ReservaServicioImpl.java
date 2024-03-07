package com.corenetworks.hotelMascotas.service.impl;

import com.corenetworks.hotelMascotas.dto.ReservaDTO;
import com.corenetworks.hotelMascotas.modelo.Reserva;
import com.corenetworks.hotelMascotas.repository.IGenericoRepositorio;
import com.corenetworks.hotelMascotas.repository.IReservaRepositorio;
import com.corenetworks.hotelMascotas.service.IReservaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservaServicioImpl extends ICRUDImpl<Reserva,Integer> implements IReservaServicio {
    @Autowired
    private IReservaRepositorio repo;

    @Override
    protected IGenericoRepositorio<Reserva, Integer> getRepo() {
        return repo;


    }

    @Override
    public Integer insert1(ReservaDTO r) {
        return repo.insertar1(r.getFechaEntrada(),r.getFechaSalida(),r.getPrecio(),r.getIdMascota(),r.getIdHabitacion());
    }
}