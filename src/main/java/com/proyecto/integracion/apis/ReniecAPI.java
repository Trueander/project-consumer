package com.proyecto.integracion.apis;

import com.proyecto.integracion.models.Equifax;
import com.proyecto.integracion.models.Persona;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ReniecAPI {

    private static final String URL_API_CRM= "https://reniec-api-progra.herokuapp.com";

    private RestTemplate restTemplate;

    public ReniecAPI(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<?> buscarPersona(String dni) {
        ResponseEntity<Persona>  persona = restTemplate.getForEntity(URL_API_CRM+"/api/persona/"+dni, Persona.class);
        return new ResponseEntity<>(persona.getBody() ,HttpStatus.OK);
    }

    public ResponseEntity<?> crearPersona(Persona persona) {
        ResponseEntity<String> personaCreada = restTemplate.postForEntity(URL_API_CRM+"/api/persona/", persona, String.class);
        return new ResponseEntity<>(personaCreada.getBody() ,HttpStatus.CREATED);
    }

    public ResponseEntity<?> actualizarPersona(String dni ,Persona persona) {
        restTemplate.put(URL_API_CRM+"/api/persona/"+dni, persona, dni);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}
