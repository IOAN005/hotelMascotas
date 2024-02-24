package com.corenetworks.hotelMascotas.controlador;

import com.corenetworks.hotelMascotas.excepciones.ExcepcionPersonalizadaNoEncontrado;
import com.corenetworks.hotelMascotas.modelo.Mascota;
import com.corenetworks.hotelMascotas.service.IMascotaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mascotas")

public class ControladorMascota {


        @Autowired
        private IMascotaServicio servicio;

        @GetMapping
        public ResponseEntity<List<Mascota>> consultarTodos() throws Exception {
            return new ResponseEntity<>(servicio.consultarTodos(), HttpStatus.OK);
        }

        @PostMapping
        public ResponseEntity<Mascota> insertar(@RequestBody Mascota m)throws Exception {
            Mascota m1 = servicio.insertar(m);
            return new ResponseEntity<>(m1, HttpStatus.CREATED);
        }

        @GetMapping("/{id}")
        public ResponseEntity<Mascota> consultarUno(@PathVariable("id") int id)throws Exception {
            Mascota m1 = servicio.consultarUno(id);
            if (m1 == null) {
                throw new ExcepcionPersonalizadaNoEncontrado("recurso no encontrado con ID " + id);
            }
            return new ResponseEntity<>(m1, HttpStatus.OK);
        }

        @PutMapping
        public ResponseEntity<Mascota> modificar(@RequestBody Mascota m)throws  Exception {
            Mascota m1 = servicio.consultarUno(m.getIdMascota());
            if (m1==null) {
                throw new ExcepcionPersonalizadaNoEncontrado("recurso no encontrado" +m.getIdMascota());
            }
            return new ResponseEntity<>(servicio.modificar(m), HttpStatus.OK);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> eliminar(@PathVariable ("id")int id)throws Exception {
            Mascota m1 = servicio.consultarUno(id);
            if (m1 == null) {
                throw new ExcepcionPersonalizadaNoEncontrado("recurso no encontrado con ID " + id);
            }
            servicio.eliminar(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        }
    }

