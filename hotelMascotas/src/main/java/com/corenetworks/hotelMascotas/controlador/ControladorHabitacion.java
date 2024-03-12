package com.corenetworks.hotelMascotas.controlador;


import com.corenetworks.hotelMascotas.dto.HabitacionDTO;
import com.corenetworks.hotelMascotas.excepciones.ExcepcionPersonalizadaNoEncontrado;
import com.corenetworks.hotelMascotas.modelo.Habitacion;
import com.corenetworks.hotelMascotas.service.IHabitacionServicio;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
    @RequestMapping("/habitaciones")
    public class ControladorHabitacion {
        @Autowired
        private IHabitacionServicio servicio;

        @GetMapping
        public ResponseEntity<List<HabitacionDTO>> consultarTodos() throws Exception {
            List<Habitacion>habitacionsBBDD=servicio.consultarTodos();
            List<HabitacionDTO>habitacionDTO=new ArrayList<>();
            for (Habitacion elemento:habitacionsBBDD
                 ) {
                habitacionDTO.add(new HabitacionDTO().castHabitacionDto(elemento));
            }
            return new ResponseEntity<>(habitacionDTO, HttpStatus.OK);
        }

        @PostMapping
        public ResponseEntity<HabitacionDTO> insertarHabitacion(@Valid @RequestBody HabitacionDTO h)throws Exception {

            Habitacion h1 = h.castHabitacion();
            h1=servicio.insertar(h1);
            return new ResponseEntity<>(h.castHabitacionDto(h1), HttpStatus.CREATED);
        }

        @GetMapping("/{id}")
        public ResponseEntity<HabitacionDTO> consultarUno(@PathVariable(name="id") Integer id)throws Exception {
            Habitacion h1 = servicio.consultarUno(id);
            if (h1 == null) {
                throw new ExcepcionPersonalizadaNoEncontrado("Habitacion no encontrada con ID " + id);
            }
            return new ResponseEntity<>(new HabitacionDTO().castHabitacionDto(h1), HttpStatus.OK);
        }

        @PutMapping
        public ResponseEntity<HabitacionDTO> modificarHabitacion(@Valid @RequestBody HabitacionDTO h)throws  Exception {
            Habitacion h1 = servicio.consultarUno(h.getIdHabitacion());
            if (h1==null) {
                throw new ExcepcionPersonalizadaNoEncontrado("Habitacion no encontrado" +h.getIdHabitacion());
            }
            h1=servicio.modificar(h.castHabitacion());
            return new ResponseEntity<>(h.castHabitacionDto(h1), HttpStatus.OK);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> eliminar(@PathVariable(name="id")Integer id)throws Exception {
            Habitacion h1 = servicio.consultarUno(id);
            if (h1 == null) {
                throw new ExcepcionPersonalizadaNoEncontrado("recurso no encontrado con ID " + id);
            }
            servicio.eliminar(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        }
    }

