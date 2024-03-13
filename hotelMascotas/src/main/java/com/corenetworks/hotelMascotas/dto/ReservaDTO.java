package com.corenetworks.hotelMascotas.dto;

import com.corenetworks.hotelMascotas.modelo.Habitacion;
import com.corenetworks.hotelMascotas.modelo.Mascota;
import com.corenetworks.hotelMascotas.modelo.Reserva;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservaDTO {
    private int idReserva;

    private LocalDate fechaEntrada;

    private LocalDate fechaSalida;

   @Min(1)
   @Max(40)
    private double precioR;
    private int idMascota;
    private int idHabitacion;
    private int cantidadNoches;


public Reserva castReserva(){
    Reserva r1=new Reserva();
    Habitacion h1= new Habitacion();
    Mascota m1= new Mascota();

    r1.setIdReserva(idReserva);
    r1.setFechaEntrada(fechaEntrada);
    r1.setFechaSalida(fechaSalida);
    r1.setPrecioR(precioR);
    r1.setCantidadNoches(cantidadNoches);
    h1.setIdHabitacion(idHabitacion);
    m1.setIdMascota(idMascota);
    r1.setMascota(m1);
    r1.setHabitacion(h1);

    return r1;
}
public ReservaDTO castReservaDTO(Reserva r){
    idReserva=r.getIdReserva();
    fechaEntrada=r.getFechaEntrada();
    fechaSalida=r.getFechaSalida();
    precioR=r.getPrecioR();
    cantidadNoches=r.getCantidadNoches();
    idHabitacion=r.getHabitacion().getIdHabitacion();
    idMascota= r.getMascota().getIdMascota();

    return this;

}

}
