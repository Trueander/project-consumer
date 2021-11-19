package com.proyecto.integracion.apis;

import com.proyecto.integracion.models.Alumno;
import com.proyecto.integracion.models.DatosConsulta;
import com.proyecto.integracion.models.Equifax;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class EquifaxAPI {

    private static final String URL_API_CRM= "https://app-equifax.herokuapp.com";

    private RestTemplate restTemplate;

    public EquifaxAPI(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public ResponseEntity<?> getClientes() {
        Map<String, Object> response = new HashMap<>();
        ResponseEntity<DatosConsulta[]> clientes = restTemplate.getForEntity(URL_API_CRM+"/api/equifax/datosConsulta", DatosConsulta[].class);

        return new ResponseEntity<>(clientes.getBody(), HttpStatus.OK);
    }

    public ResponseEntity<?> buscarCliente(String dni) {
        ResponseEntity<Equifax>  cliente = restTemplate.getForEntity(URL_API_CRM+"/api/equifax/"+dni, Equifax.class);
        return new ResponseEntity<>(cliente.getBody() ,HttpStatus.OK);
    }

    public ResponseEntity<?> crearCliente(Equifax equifax) {

        ResponseEntity<String> clienteCreado = restTemplate.postForEntity(URL_API_CRM+"/api/equifax/", equifax, String.class);
        System.out.println(clienteCreado.getBody());
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
