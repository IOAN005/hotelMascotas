package com.corenetworks.hotelMascotas.controlador;

import com.corenetworks.hotelMascotas.excepciones.ExcepcionPersonalizadaNoEncontrado;
import com.corenetworks.hotelMascotas.modelo.Cliente;
import com.corenetworks.hotelMascotas.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/clientes")
public class ControladorCliente {
    @Autowired
    private IClienteService servicio;
    @PostMapping
    public ResponseEntity<Cliente> insertar(@RequestBody Cliente c) throws Exception {
        Cliente c1 = servicio.insertar(c);
        if (c1 == null) {
            throw new ExcepcionPersonalizadaNoEncontrado("Producto no encontrado con ID" + c.getIdCliente());
        }
        return new ResponseEntity<>(c1, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> consultarTodos() throws Exception {
        return new ResponseEntity<>(servicio.consultarTodos(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente>consultarUno(@PathVariable(name = "id") int id) throws Exception {
        Cliente c1 = servicio.consultarUno(id);
        if (c1== null) {
            throw new ExcepcionPersonalizadaNoEncontrado("Producto no encontrado con ID" + id);
        }
        return new ResponseEntity<>(servicio.consultarUno(id),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> eliminar(@PathVariable(name = "id") int id) throws Exception {
        Cliente c1= servicio.consultarUno(id);
        if (c1== null) {
            throw new ExcepcionPersonalizadaNoEncontrado("Producto no encontrado con ID" + id);
        }
        servicio.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }



}
