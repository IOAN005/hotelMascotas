package com.corenetworks.hotelMascotas.dto;

import com.corenetworks.hotelMascotas.modelo.Factura;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor

public class FacturaDto {
    private int idFactura;

    public Factura castFactura(){

        Factura f1= new Factura();
        f1.setIdFactura(idFactura);

        return f1;
    }
    public FacturaDto castFacturaDto(Factura f){
        idFactura=f.getIdFactura();
        return this;

    }


}
