package com.corenetworks.hotelMascotas.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="detalles_facturas")
public class DetalleFactura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDetalleFactura;
    @Column(length = 60,nullable = false)

    private String concepto;
    @Column(nullable = false)
    private double precio;
//    @ManyToOne
//    @JoinColumn(name = "idReserva",nullable = false,foreignKey = @ForeignKey(name = "FK_reservas_detalles_facturas"))
//    private Reserva reserva;
//    @OneToOne
//    @JoinColumn(name = "idFactura",nullable = false,foreignKey = @ForeignKey(name = "FK_facturas_detalles_facturas"))
//    private Factura factura;
//    @ManyToOne
//    @JoinColumn(name = "idServicio",nullable = false,foreignKey = @ForeignKey(name = "FK_servios_detalles_facturas"))
//    private Servicio servicio;



}