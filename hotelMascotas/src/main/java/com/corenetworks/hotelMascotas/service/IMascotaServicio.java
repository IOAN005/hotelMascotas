package com.corenetworks.hotelMascotas.service;

import com.corenetworks.hotelMascotas.dto.MascotaDTO;
import com.corenetworks.hotelMascotas.modelo.Mascota;

public interface IMascotaServicio extends ICRUD<Mascota,Integer>{
    public Integer insert1(MascotaDTO m);
}
