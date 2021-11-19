package com.proyecto.integracion.controllers;

import com.proyecto.integracion.apis.EgresadoAPI;
import com.proyecto.integracion.apis.ReniecAPI;
import com.proyecto.integracion.models.Egresado;
import com.proyecto.integracion.models.Persona;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api/v1")
public class EgresadoController {

    private final EgresadoAPI egresadoAPI;

    public EgresadoController(EgresadoAPI egresadoAPI) {
        this.egresadoAPI = egresadoAPI;
    }

    @GetMapping("/egresados/{dni}")
    public ResponseEntity<?> buscarEgresado(@PathVariable String dni) {
        return new ResponseEntity<>(egresadoAPI.buscarEgresado(Integer.parseInt(dni)).getBody(), HttpStatus.OK);
    }

    @PostMapping("/egresados")
    public ResponseEntity<?> crearEgresado(@RequestBody Egresado egresado) {
        return new ResponseEntity<>(egresadoAPI.crearEgresado(egresado).getBody(), HttpStatus.OK);
    }

}
