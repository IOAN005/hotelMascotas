package com.corenetworks.hotelMascotas.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="reservas_mascotas_habitaciones")
@IdClass(ReservaPK.class)
public class Reserva {
    private int idReserva;
    @Id
    private Mascota mascota;
    @Id
    private Habitacion habitacion;
    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;
    private double precio;




}
