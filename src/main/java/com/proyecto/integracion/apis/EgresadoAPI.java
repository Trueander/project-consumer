package com.proyecto.integracion.apis;

import com.proyecto.integracion.models.Egresado;
import com.proyecto.integracion.models.Persona;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EgresadoAPI {

    private static final String URL_API_CRM= "https://gruporojo-programacion2.herokuapp.com";

    private RestTemplate restTemplate;

    public EgresadoAPI(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<?> buscarEgresado(Integer dni) {
        ResponseEntity<Egresado>  persona = restTemplate.getForEntity(URL_API_CRM+"/api/Egresado/"+dni, Egresado.class);
        return new ResponseEntity<>(persona.getBody() , HttpStatus.OK);
    }

    public ResponseEntity<?> crearEgresado(Egresado egresado) {

        ResponseEntity<Integer> egresadoCreado = restTemplate
                .postForEntity(URL_API_CRM+"/api/Egresado/?nombres="
                        +egresado.getNombres()+
                        "&apellidos="+egresado.getApellidos()+
                        "&dni="+egresado.getDni()+
                        "&fecha="+egresado.getFecha()+
                        "&grados="+egresado.getGrados()+
                        "&instituto="+egresado.getInstituto()+
                        "&modalidad="+egresado.getModalidad(),egresado, Integer.class);



        System.out.println(egresadoCreado.getBody());
        return new ResponseEntity<>(egresadoCreado.getBody() ,HttpStatus.CREATED);
    }

}
