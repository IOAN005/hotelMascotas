package com.corenetworks.hotelMascotas.service.impl;

import com.corenetworks.hotelMascotas.modelo.Reserva;
import com.corenetworks.hotelMascotas.repository.IGenericoRepositorio;
import com.corenetworks.hotelMascotas.repository.IReservaRepositorio;
import com.corenetworks.hotelMascotas.service.IReservaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReservaServicioImpl extends ICRUDImpl<Reserva,Integer> implements IReservaServicio {
    @Autowired
    private IReservaRepositorio repo;



        private List<LocalDate> fechasNoDisponibles;

        public void FechaNoDisponible() {
            fechasNoDisponibles = new ArrayList<>();
            // Agregar fechas no disponibles predefinidas
            // Puedes modificar o extender esto según tus necesidades
            fechasNoDisponibles.add(LocalDate.of(2024, 3, 10));
            fechasNoDisponibles.add(LocalDate.of(2024, 3, 15));
            fechasNoDisponibles.add(LocalDate.of(2024, 3, 20));
        }

        public boolean fechaDisponible(LocalDate fecha) {
            return fechasNoDisponibles.contains(fecha);
        }


    @Override
    protected IGenericoRepositorio<Reserva, Integer> getRepo() {
        return repo;
    }
}
