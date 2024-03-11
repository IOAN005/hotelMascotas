package com.corenetworks.hotelMascotas.dto;

import com.corenetworks.hotelMascotas.modelo.Servicio;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServicioDTO {

        private int idServicio;
        @NotEmpty
        private String concepto;

        @Min(5)
        @Max(50)
        private double precioS;

        private String imagen;

        private String descripcion;
        private int cantidad;



        public Servicio castServicio(){
            Servicio s1=new Servicio();
            s1.setIdServicio(idServicio);
            s1.setConcepto(concepto);
            s1.setPrecioS(precioS);
            s1.setImagen(imagen);
            s1.setDescripcion(descripcion);
            s1.setCantidad(cantidad);


            return s1;

        }
        public ServicioDTO castServicioDTO(Servicio s){
            idServicio=s.getIdServicio();
            concepto=s.getConcepto();
            precioS=s.getPrecioS();
            imagen=s.getImagen();
            descripcion=s.getDescripcion();
            cantidad=s.getCantidad();
            return  this;
        }
    }


