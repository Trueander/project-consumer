package com.proyecto.integracion.controllers;

import com.proyecto.integracion.apis.ReniecAPI;
import com.proyecto.integracion.models.Equifax;
import com.proyecto.integracion.models.Persona;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api/v1")
public class ReniecController {

    private final ReniecAPI reniecAPI;

    public ReniecController(ReniecAPI reniecAPI) {
        this.reniecAPI = reniecAPI;
    }

    @GetMapping("/personas/{dni}")
    public ResponseEntity<?> buscarPersona(@PathVariable String dni) {
        return new ResponseEntity<>(reniecAPI.buscarPersona(dni).getBody(), HttpStatus.OK);
    }

    @PostMapping("/personas")
    public ResponseEntity<?> crearPersona(@RequestBody Persona persona) {
        reniecAPI.crearPersona(persona);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/personas/{dni}")
    public ResponseEntity<?> actualizarPersona(@PathVariable String dni ,@RequestBody Persona persona) {
        reniecAPI.actualizarPersona(dni, persona);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
