package com.corenetworks.hotelMascotas.controlador;


import com.corenetworks.hotelMascotas.dto.ServicioDTO;
import com.corenetworks.hotelMascotas.excepciones.ExcepcionPersonalizadaNoEncontrado;
import com.corenetworks.hotelMascotas.modelo.Servicio;
import com.corenetworks.hotelMascotas.service.IServicioServicio;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/servicios")


public class ControladorServicio {


    @Autowired
    private IServicioServicio servicio;

    @GetMapping
    public ResponseEntity<List<ServicioDTO>> consultarTodos() throws Exception {
        List<Servicio>serviciosBBDD=servicio.consultarTodos();
        List<ServicioDTO>servicioDTO=new ArrayList<>();
        for (Servicio elemento:serviciosBBDD
             ) {
            servicioDTO.add(new ServicioDTO().castServicioDTO(elemento));
        }

        return new ResponseEntity<>(servicioDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ServicioDTO> insertarServicio(@Valid @RequestBody ServicioDTO s)throws Exception {
        Servicio s1 = s.castServicio();
        s1=servicio.insertar(s1);
        return new ResponseEntity<>(s.castServicioDTO(s1), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServicioDTO> consultarUno( @PathVariable(name="id") Integer id)throws Exception {
        Servicio s1 = servicio.consultarUno(id);
        if (s1 == null) {
            throw new ExcepcionPersonalizadaNoEncontrado("Servicio no encontrado con ID " + id);
        }
        return new ResponseEntity<>(new ServicioDTO().castServicioDTO(s1), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<ServicioDTO> modificarServicio(@Valid @RequestBody ServicioDTO s)throws  Exception {
        Servicio s1= servicio.consultarUno(s.getIdServicio());
        if (s1==null) {
            throw new ExcepcionPersonalizadaNoEncontrado("Servicio no encontrado" +s.getIdServicio());
        }
        s1=servicio.modificar(s.castServicio());
        return new ResponseEntity<>(s.castServicioDTO(s1), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable (name="id")Integer id)throws Exception {
        Servicio s1 = servicio.consultarUno(id);
        if (s1 == null) {
            throw new ExcepcionPersonalizadaNoEncontrado("Servicio no encontrado con ID " + id);
        }
        servicio.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }


}