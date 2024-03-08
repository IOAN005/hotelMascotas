package com.corenetworks.hotelMascotas.controlador;

import com.corenetworks.hotelMascotas.dto.ReservaDTO;
import com.corenetworks.hotelMascotas.excepciones.ExcepcionPersonalizadaNoEncontrado;
import com.corenetworks.hotelMascotas.modelo.Reserva;
import com.corenetworks.hotelMascotas.service.IReservaServicio;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/reservas")

    public class ControladorReserva {


        @Autowired
        private IReservaServicio servicio;

        @GetMapping
        public ResponseEntity<List<ReservaDTO>> consultarTodos() throws Exception {
            List<Reserva>reservasBBDD=servicio.consultarTodos();
            List<ReservaDTO>reservaDTO=new ArrayList<>();
            for (Reserva elemento:reservasBBDD
                 ) {
                reservaDTO.add(new ReservaDTO().castReservaDTO(elemento));
            }
            return new ResponseEntity<>(reservaDTO, HttpStatus.OK);
        }

        @PostMapping
        public ResponseEntity<Integer> insertarREserva(@Valid  @RequestBody ReservaDTO r)throws Exception {

            Integer i=servicio.insert1(r);
            return new ResponseEntity<>(i, HttpStatus.CREATED);
        }

        @GetMapping("/{id}")
        public ResponseEntity<ReservaDTO> consultarUno( @PathVariable(name="id") Integer id)throws Exception {
            Reserva r1 = servicio.consultarUno(id);
            if (r1 == null) {
                throw new ExcepcionPersonalizadaNoEncontrado("Reserva no encontrada con ID " + id);
            }
            return new ResponseEntity<>(new ReservaDTO().castReservaDTO(r1), HttpStatus.OK);
        }

        @PutMapping
        public ResponseEntity<Integer> modificarReserva(@Valid @RequestBody ReservaDTO r)throws  Exception {
            Integer i=servicio.insert1(r);
            if (i==null) {
                throw new ExcepcionPersonalizadaNoEncontrado("Reserva no encontrada" +r.getIdReserva());
            }
            return new ResponseEntity<>(i, HttpStatus.OK);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> eliminar(@PathVariable (name="id")Integer id)throws Exception {
            Reserva r1 = servicio.consultarUno(id);
            if (r1 == null) {
                throw new ExcepcionPersonalizadaNoEncontrado("Reserva no encontrada con ID " + id);
            }
            servicio.eliminar(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        }
    @GetMapping("/{f1}/{f2}")
    public ResponseEntity<List<ReservaDTO>> obtenerReservas(@PathVariable ("f1") LocalDate f1,
                                                            @PathVariable("f2")LocalDate f2)
            throws Exception{
        List<Reserva> reservasBBDD = servicio.obtenerReservas(f1, f2);
        List<ReservaDTO> reservasDto= new ArrayList<>();
        for(Reserva elemento:
                reservasBBDD){
            ReservaDTO eDto = new ReservaDTO();
            reservasDto.add(eDto.castReservaDTO(elemento));
        }
        return new ResponseEntity<>(reservasDto, HttpStatus.OK);
    }
    }

