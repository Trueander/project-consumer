package com.proyecto.integracion.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Egresado {
    private Integer idEgresado;
    private String nombres;
    private String apellidos;
    private Integer dni;
    private String fecha;
    private String grados;
    private String instituto;
    private String modalidad;

}
