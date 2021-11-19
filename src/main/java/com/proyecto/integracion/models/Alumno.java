package com.proyecto.integracion.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Alumno implements Serializable {
    private String id;
    private String nombre;
    private String apellidos;
    private String dni;
    private String carrera;
    private String celular;
    private String email;
    private String sexo;
    private String fechaCum;

}
