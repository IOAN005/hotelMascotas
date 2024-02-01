package com.corenetworks.hotelMascotas.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "servicios")
public class Servicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idServicio;
    private String concepto;
    private double precio;
//    @ManyToOne
//    @JoinColumn(name = "idDetalleFactura",nullable = false,foreignKey = @ForeignKey(name = "FK_detalles_facturas_servicios"))
//    private DetalleFactura detalleFactura;

}
