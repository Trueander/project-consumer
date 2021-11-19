package com.proyecto.integracion.apis;

import com.proyecto.integracion.models.Alumno;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CrmAPI {

    private static final String URL_API_CRM="https://appi-crm.herokuapp.com";
    private RestTemplate restTemplate;

    public CrmAPI(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<?> saveAlumno(Alumno alumno) {

        ResponseEntity<String> responseEntity = restTemplate.postForEntity(URL_API_CRM+"/api/Alumnos/", alumno, String.class);
        System.out.println(responseEntity.getBody());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public void eliminarAlumno(String id) {
        restTemplate.delete(URL_API_CRM+"/api/Alumnos/alumnos/"+id);
    }



    public ResponseEntity<?> getAlumnos() {
        Map<String, Object> response = new HashMap<>();
        ResponseEntity<String> alumnosResponse = restTemplate.getForEntity(URL_API_CRM+"/api/Alumnos/", String.class);
//        ResponseEntity<Alumno[]> responseEntity = restTemplate.getForEntity(URL_API_CRM+"/api/Alumnos/", Alumno[].class);
        String body = alumnosResponse.getBody();
        System.out.println(body);
        response.put("alumnos", body);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public ResponseEntity<?> getAlumno(String dni) {
        Map<String, Object> response = new HashMap<>();

        Alumno alumno = new Alumno();

        try {
            ResponseEntity<Alumno> responseEntity = restTemplate
                    .getForEntity(URL_API_CRM+"/api/Alumnos/"+dni, Alumno.class);

            alumno.setId(responseEntity.getBody().getId());
            alumno.setNombre(responseEntity.getBody().getNombre());
            alumno.setApellidos(responseEntity.getBody().getApellidos());
            alumno.setCelular(responseEntity.getBody().getCelular());
            alumno.setCarrera(responseEntity.getBody().getCarrera());
            alumno.setEmail(responseEntity.getBody().getEmail());
            alumno.setFechaCum(responseEntity.getBody().getFechaCum());
            alumno.setSexo(responseEntity.getBody().getSexo());
            alumno.setDni(responseEntity.getBody().getDni());

        }catch (HttpStatusCodeException e) {
            response.put("mensaje", "Error: Se ha producido un error al intentar consumir el servicio del CRM");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

        response.put("alumno", alumno);
        return new ResponseEntity<>(response , HttpStatus.OK);
    }

}
