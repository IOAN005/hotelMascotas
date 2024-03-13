package com.corenetworks.hotelMascotas.dto;

import com.corenetworks.hotelMascotas.modelo.Cliente;
import com.corenetworks.hotelMascotas.modelo.Mascota;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MascotaDTO {

    private int idMascota;
    @NotNull
    @Size(min=3,max=69)
    private String nombre;
    @NotNull
    private String raza;
    @NotNull
    private int edad;
    @NotNull
    private String tamano;
    @NotNull
    private String tipoHabitacion;
    private int idCliente;

    public Mascota castMascota(){
        Mascota m1=new Mascota();
        Cliente c1= new Cliente();
        m1.setIdMascota(idMascota);
        m1.setNombre(nombre);
        m1.setEdad(edad);
        m1.setRaza(raza);
        m1.setTamano(tamano);
        m1.setTipoHabitacion(tipoHabitacion);
        c1.setIdCliente(idCliente);
        m1.setCliente(c1);

        return m1;
    }
    public MascotaDTO castMascotaDTO(Mascota m){
        idMascota=m.getIdMascota();
        nombre=m.getNombre();
        edad=m.getEdad();
        raza=m.getRaza();
        tamano=m.getTamano();
        tipoHabitacion=m.getTipoHabitacion();
        idCliente=m.getCliente().getIdCliente();

        return this;


    }

}
