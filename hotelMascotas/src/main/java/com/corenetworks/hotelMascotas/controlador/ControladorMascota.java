package com.corenetworks.hotelMascotas.controlador;

import com.corenetworks.hotelMascotas.dto.MascotaDTO;
import com.corenetworks.hotelMascotas.excepciones.ExcepcionPersonalizadaNoEncontrado;
import com.corenetworks.hotelMascotas.modelo.Mascota;
import com.corenetworks.hotelMascotas.service.IMascotaServicio;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/mascotas")

public class ControladorMascota {


        @Autowired
        private IMascotaServicio servicio;

        @GetMapping
        public ResponseEntity<List<MascotaDTO>> consultarTodos() throws Exception {
            List<Mascota>mascotasBBDD=servicio.consultarTodos();
            List<MascotaDTO>mascotaDTO=new ArrayList<>();
            for (Mascota elemento:mascotasBBDD
                 ) {
                mascotaDTO.add(new MascotaDTO().castMascotaDTO(elemento));
            }
            return new ResponseEntity<>(mascotaDTO, HttpStatus.OK);
        }

        @PostMapping
        public ResponseEntity<MascotaDTO> insertarMascota(@Valid @RequestBody MascotaDTO m)throws Exception {
            Mascota m1 = m.castMascota();
            m1=servicio.insertar(m1);
            return new ResponseEntity<>(m.castMascotaDTO(m1), HttpStatus.CREATED);

        }

        @GetMapping("/{id}")
        public ResponseEntity<MascotaDTO> consultarUno( @PathVariable(name="id") Integer id)throws Exception {
            Mascota m1 = servicio.consultarUno(id);
            if (m1 == null) {
                throw new ExcepcionPersonalizadaNoEncontrado("Mascota no encontrada con ID " + id);
            }
            return new ResponseEntity<>(new MascotaDTO().castMascotaDTO(m1), HttpStatus.OK);
        }

        @PutMapping
        public ResponseEntity<MascotaDTO> modificarMascota(@Valid @RequestBody MascotaDTO m)throws  Exception {
            System.out.println(m.toString());
           Mascota m1 = servicio.consultarUno(m.getIdMascota());


            if (m1==null) {
                throw new ExcepcionPersonalizadaNoEncontrado("Mascota no encontrada" +m.getIdMascota());
            }
            m1=servicio.modificar(m.castMascota());
            return new ResponseEntity<>(m.castMascotaDTO(m1), HttpStatus.OK);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> eliminar(@PathVariable(name ="id")Integer id)throws Exception {
            Mascota m1 = servicio.consultarUno(id);
            if (m1 == null) {
                throw new ExcepcionPersonalizadaNoEncontrado("recurso no encontrado con ID " + id);
            }
            servicio.eliminar(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

