package com.corenetworks.hotelMascotas.dto;

import com.corenetworks.hotelMascotas.modelo.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetalleFacturaDTO {
    private int idDetalleFactura;
    @NotEmpty
    private String concepto;
    @NotNull
    private LocalDate fechaFactura;
    @Min(1)
    @Max(250)
    private double precioDF;



    private Factura factura;
    private Reserva reserva;
    private Servicio servicio;
    public DetalleFactura castDetalleFactura(){

        DetalleFactura dF1= new DetalleFactura();
        dF1.setIdDetalleFactura(idDetalleFactura);
        dF1.setConcepto(concepto);
        dF1.setPrecioDF(precioDF);
        dF1.setFechaFactura(fechaFactura);
        dF1.setFactura(factura);
        dF1.setReserva(reserva);
        dF1.setServicio(servicio);

        return dF1;
    }
    public DetalleFacturaDTO castDetalleFacturaDto(DetalleFactura dF){
        idDetalleFactura= dF.getIdDetalleFactura();
        concepto= dF.getConcepto();
        precioDF= dF.getPrecioDF();
        fechaFactura= dF.getFechaFactura();

        factura= dF.getFactura();
        reserva= dF.getReserva();
        servicio= dF.getServicio();
        return this;

    }

}
