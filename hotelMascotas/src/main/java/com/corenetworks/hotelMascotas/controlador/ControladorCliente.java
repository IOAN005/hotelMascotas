package com.corenetworks.hotelMascotas.controlador;

import com.corenetworks.hotelMascotas.dto.ClienteDTO;
import com.corenetworks.hotelMascotas.excepciones.ExcepcionPersonalizadaNoEncontrado;
import com.corenetworks.hotelMascotas.modelo.Cliente;
import com.corenetworks.hotelMascotas.service.IClienteServicio;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ControladorCliente {
    @Autowired
    private IClienteServicio servicio;

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> consultarTodos() throws Exception {
        List<Cliente> clientesBBDD = servicio.consultarTodos();
        List<ClienteDTO> clienteDTO = new ArrayList<>();
        for (Cliente elemento : clientesBBDD
        ) {
            clienteDTO.add(new ClienteDTO().castClienteDto(elemento));
        }
        return new ResponseEntity<>(clienteDTO, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<ClienteDTO> insertarCliente(@Valid @RequestBody ClienteDTO c) throws Exception {
        System.out.println(c.toString());
        Cliente c1 = c.castCliente();
        c1=servicio.insertar(c1);
        return new ResponseEntity<>(c.castClienteDto(c1) ,HttpStatus.CREATED);
    }
//    @PostMapping
//    public ResponseEntity<EmpleadoDTO> crearEmpleado(@Valid @RequestBody EmpleadoDTO e) {
//        System.out.println(e.toString());
//        Empleado e1 = e.castEmpleado();
//        e1 = service.crear(e1);
//        return new ResponseEntity<>(e.castEmpleadoDto(e1), HttpStatus.CREATED);
//
//    }
    @PutMapping
    public ResponseEntity<ClienteDTO>modificarClilente(@Valid @RequestBody ClienteDTO c) throws Exception {
        Cliente c1 = servicio.consultarUno(c.getIdCliente());
        if (c1== null) {
            throw new ExcepcionPersonalizadaNoEncontrado("Cliente no encontrado con ID" + c1.getIdCliente());
        }
        c1=servicio.modificar(c.castCliente());
        return new ResponseEntity<>(c.castClienteDto(c1),HttpStatus.OK);
    }
//    @PutMapping
//    public ResponseEntity<EmpleadoDTO> modificarEmpleado(@Valid @RequestBody EmpleadoDTO e) {
//        System.out.println(e.toString());
//        Empleado e1=service.consultarUno(e.getIdEmpleado());
//        if(e1==null){
//            throw new ExcepcionPersonalizadaNoEncontrado("Empleado no Encontrado ->" +e.getIdEmpleado());
//        }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO>consultarUno(@PathVariable(name = "id") Integer id) throws Exception {
        Cliente c1= servicio.consultarUno(id);
        if (c1== null) {
            throw new ExcepcionPersonalizadaNoEncontrado("Cliente no encontrado con ID" + id);
        }

        return new ResponseEntity<>(new ClienteDTO().castClienteDto(c1),HttpStatus.OK);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable (name="id")Integer id)throws Exception {
        Cliente c1 = servicio.consultarUno(id);
        if (c1 == null) {
            throw new ExcepcionPersonalizadaNoEncontrado("Cliente no encontrado con ID " + id);
        }
        servicio.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    }




