package com.corenetworks.hotelMascotas.dto;

import com.corenetworks.hotelMascotas.modelo.DetalleFactura;
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
    @Min(1)
    @Max(250)
    private double precioDF;
    @NotNull
    private LocalDate fechaFactura;

    public DetalleFactura castDetalleFactura(){

        DetalleFactura dF1= new DetalleFactura();
        dF1.setIdDetalleFactura(idDetalleFactura);
        dF1.setConcepto(concepto);
        dF1.setPrecioDF(precioDF);
        dF1.setFechaFactura(fechaFactura);
        return dF1;
    }
    public DetalleFacturaDTO castDetalleFacturaDto(DetalleFactura dF){
        idDetalleFactura=getIdDetalleFactura();
        concepto=getConcepto();
        precioDF=getPrecioDF();
        fechaFactura=getFechaFactura();
        return this;

    }

}
