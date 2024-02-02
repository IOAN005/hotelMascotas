package com.corenetworks.hotelMascotas.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCliente;
    @Column(length = 60,nullable = false)

    private String nombre;
    @Column(length = 60,nullable = false)
    private String direccion;
    @Column(length = 9)
    private String telefono;
//
//    @ManyToOne
//    @JoinColumn(name = "id_reserva", nullable = false, foreignKey = @ForeignKey(name = "FK_cliente_reserva"))
//    private Reserva reserva;
    //
}
