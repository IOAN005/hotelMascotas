package com.corenetworks.hotelMascotas.service;

import com.corenetworks.hotelMascotas.dto.ReservaDTO;
import com.corenetworks.hotelMascotas.modelo.Reserva;

import java.time.LocalDate;
import java.util.List;

public interface IReservaServicio extends ICRUD<Reserva,Integer>{
    public Integer insert1(ReservaDTO r);
    Integer actualizaR(ReservaDTO r);
    List<Reserva> obtenerReservas(LocalDate f1, LocalDate f2);

}
