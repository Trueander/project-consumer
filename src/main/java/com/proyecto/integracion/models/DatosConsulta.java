package com.proyecto.integracion.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DatosConsulta {
    private Integer id;
    private String fecha;
    private Integer deuda;
    private String entidad;
    private Integer diasVencidas;
    private Integer calificacion;
}
