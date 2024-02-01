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
@Table(name="reservas")

public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idReserva;
    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;


    @OneToMany(mappedBy = "reserva")
    private List<Habitacion> habitaciones;

    @OneToMany(mappedBy = "reserva")
    private List<Mascota> mascotas;

    @OneToMany(mappedBy = "cliente")
    private List<Cliente> cliente;


}
