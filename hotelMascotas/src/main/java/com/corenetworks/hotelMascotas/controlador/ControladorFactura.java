package com.corenetworks.hotelMascotas.controlador;


import com.corenetworks.hotelMascotas.dto.FacturaDTO;
import com.corenetworks.hotelMascotas.excepciones.ExcepcionPersonalizadaNoEncontrado;
import com.corenetworks.hotelMascotas.modelo.Factura;
import com.corenetworks.hotelMascotas.service.IFacturaServicio;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/facturas")
 public class ControladorFactura{
     @Autowired
    private IFacturaServicio servicio;

    @GetMapping
    public ResponseEntity<List<FacturaDTO>> consultarTodos() throws Exception {
        List<Factura>facturasBBDD=servicio.consultarTodos();
        List<FacturaDTO>facturaDTO=new ArrayList<>();
        for (Factura elemento:facturasBBDD
             ) {
           facturaDTO.add(new FacturaDTO().castFacturaDto(elemento));
        }
        return new ResponseEntity<>(facturaDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<FacturaDTO> insertarFactura(@Valid @RequestBody FacturaDTO f)throws Exception {
        Factura f1 = f.castFactura();
        f1=servicio.insertar(f1);
        return new ResponseEntity<>(f.castFacturaDto(f1), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FacturaDTO> consultarUno(@Valid @PathVariable(name="id") Integer id)throws Exception {
        Factura f1 = servicio.consultarUno(id);
        if (f1 == null) {
            throw new ExcepcionPersonalizadaNoEncontrado("Factura no encontrada con ID " + id);
        }
        return new ResponseEntity<>(new FacturaDTO().castFacturaDto(f1), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<FacturaDTO> modificarFactura(@Valid @RequestBody FacturaDTO f)throws  Exception {
        Factura f1 = servicio.consultarUno(f.getIdFactura());
        if (f1==null) {
            throw new ExcepcionPersonalizadaNoEncontrado("Factura no encontrada" +f.getIdFactura());
        }
        f1=servicio.modificar(f.castFactura());
        return new ResponseEntity<>(f.castFacturaDto(f1), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable (name="id")Integer id)throws Exception {
        Factura f1 = servicio.consultarUno(id);
        if (f1 == null) {
            throw new ExcepcionPersonalizadaNoEncontrado("recurso no encontrado con ID " + id);
        }
        servicio.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}

