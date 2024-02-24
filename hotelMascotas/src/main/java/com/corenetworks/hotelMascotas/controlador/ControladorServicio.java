package com.corenetworks.hotelMascotas.controlador;


import com.corenetworks.hotelMascotas.excepciones.ExcepcionPersonalizadaNoEncontrado;
import com.corenetworks.hotelMascotas.modelo.Servicio;
import com.corenetworks.hotelMascotas.service.IServicioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servicios")


public class ControladorServicio {


    @Autowired
    private IServicioServicio servicio;

    @GetMapping
    public ResponseEntity<List<Servicio>> consultarTodos() throws Exception {
        return new ResponseEntity<>(servicio.consultarTodos(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Servicio> insertar(@RequestBody Servicio s)throws Exception {
        Servicio s1 = servicio.insertar(s);
        return new ResponseEntity<>(s1, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Servicio> consultarUno(@PathVariable("id") int id)throws Exception {
        Servicio s1 = servicio.consultarUno(id);
        if (s1 == null) {
            throw new ExcepcionPersonalizadaNoEncontrado("recurso no encontrado con ID " + id);
        }
        return new ResponseEntity<>(s1, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Servicio> modificar(@RequestBody Servicio s)throws  Exception {
        Servicio s1= servicio.consultarUno(s.getIdServicio());
        if (s1==null) {
            throw new ExcepcionPersonalizadaNoEncontrado("recurso no encontrado" +s.getIdServicio());
        }
        return new ResponseEntity<>(servicio.modificar(s), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable ("id")int id)throws Exception {
        Servicio s1 = servicio.consultarUno(id);
        if (s1 == null) {
            throw new ExcepcionPersonalizadaNoEncontrado("recurso no encontrado con ID " + id);
        }
        servicio.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }


}