package com.proyecto.integracion.controllers;

import com.proyecto.integracion.apis.CrmAPI;
import com.proyecto.integracion.models.Alumno;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api/v1")
public class CrmController {

    private final CrmAPI crmAPI;

    public CrmController(CrmAPI crmAPI) {
        this.crmAPI = crmAPI;
    }

    @GetMapping("/alumnos/{dni}")
    public ResponseEntity<?> getAlumno(@PathVariable String dni) {
        Map<String, Object> response = new HashMap<>();
        ResponseEntity<?> respuesta = crmAPI.getAlumno(dni);

        try {
            response.put("response", respuesta.getBody());
        }catch (HttpStatusCodeException e) {
            response.put("mensaje", "Error: Se ha producido un error al intentar consumir el servicio del CRM listar");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

    @PostMapping("/alumnos")
    public ResponseEntity<?> postAlumno(@RequestBody Alumno alumno) {
        crmAPI.saveAlumno(alumno);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/alumnos/{id}")
    public ResponseEntity<?> eliminarAlumno(@PathVariable String id) {
        crmAPI.eliminarAlumno(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/alumnos")
    @ResponseBody
    public ResponseEntity<?> getAlumnosXD() {
        return new ResponseEntity<>(crmAPI.getAlumnos().getBody(), HttpStatus.OK) ;
    }

}
