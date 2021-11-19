package com.proyecto.integracion.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Persona {
    private Integer id;
    private String nombre;
    private String apellido;
    private String direccion;
    private String dni;
    private String fechaNacimiento;
    private String estadoCivil;
    private String departamento;
    private String provincia;
    private String distrito;
    private String sexo;
}
