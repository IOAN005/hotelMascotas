package com.corenetworks.hotelMascotas.service.impl;

import com.corenetworks.hotelMascotas.modelo.Habitacion;
import com.corenetworks.hotelMascotas.repository.IGenericoRepositorio;
import com.corenetworks.hotelMascotas.repository.IHabitacionRepositorio;
import com.corenetworks.hotelMascotas.service.IHabitacionServicio;
import org.springframework.beans.factory.annotation.Autowired;

public class HabitacionServicioImpl extends ICRUDImpl<Habitacion,Integer> implements IHabitacionServicio {
    @Autowired
    private IHabitacionRepositorio repo;
    @Override
    protected IGenericoRepositorio<Habitacion, Integer> getRepo() {
        return repo;
    }
}
