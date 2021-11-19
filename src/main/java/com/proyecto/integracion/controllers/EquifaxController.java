package com.proyecto.integracion.controllers;

import com.proyecto.integracion.apis.EquifaxAPI;
import com.proyecto.integracion.models.Alumno;
import com.proyecto.integracion.models.DatosConsulta;
import com.proyecto.integracion.models.Equifax;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api/v1")
public class EquifaxController {

    private final EquifaxAPI equifaxAPI;

    public EquifaxController(EquifaxAPI equifaxAPI) {
        this.equifaxAPI = equifaxAPI;
    }

    @GetMapping("/clientes")
    public ResponseEntity<?> listaClientes() {
        return new ResponseEntity<>(equifaxAPI.getClientes().getBody(), HttpStatus.OK);
    }

    @PostMapping("/clientes")
    public ResponseEntity<?> crearCliente(@RequestBody Equifax equifax) {

        equifaxAPI.crearCliente(equifax);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/clientes/{dni}")
    public ResponseEntity<?> buscarCliente(@PathVariable String dni) {
        return new ResponseEntity<>(equifaxAPI.buscarCliente(dni).getBody(), HttpStatus.OK);
    }

}
