package com.proyecto.integracion.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Equifax {
    private Integer id;
    private String nombres;
    private String apellidos;
    private String dni;
    private String ocupacion;
    private String nacionalidad;
    private List<DatosConsulta> datosConsulta;

    public Equifax() {
        this.datosConsulta = new ArrayList<>();
    }
}
