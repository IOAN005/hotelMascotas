package com.corenetworks.hotelMascotas.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="reservas_mascotas_habitaciones")
@IdClass(ReservaPK.class)
public class Reserva {
    @Id
    private int idReserva;
    @Id
    private Mascota mascota;
    @Id
    private Habitacion habitacion;
    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;
    private double precio;




}
