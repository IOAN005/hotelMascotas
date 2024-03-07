package com.corenetworks.hotelMascotas.service;

import com.corenetworks.hotelMascotas.dto.ReservaDTO;
import com.corenetworks.hotelMascotas.modelo.Reserva;

public interface IReservaServicio extends ICRUD<Reserva,Integer>{
    public Integer insert1(ReservaDTO r);
}
