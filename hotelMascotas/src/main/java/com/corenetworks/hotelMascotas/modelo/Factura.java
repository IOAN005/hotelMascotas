package com.corenetworks.hotelMascotas.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "facturas")
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFactura;
//    @OneToOne
//    @JoinColumn(name = "idReserva",nullable = false,foreignKey = @ForeignKey(name = "FK_reservas_facturas"))
//    private Reserva reserva;
//    @OneToOne
//    @JoinColumn(name ="idDetalleFactura" ,nullable = false,foreignKey = @ForeignKey(name = "FK_detalles_facturas_facturas"))
//    private DetalleFactura detalleFactura;
//    @OneToOne
//    @JoinColumn(name = "idClientes",nullable = false,foreignKey =@ForeignKey(name = "FK_clientes_facturas") )
//    private Cliente cliente;





}
