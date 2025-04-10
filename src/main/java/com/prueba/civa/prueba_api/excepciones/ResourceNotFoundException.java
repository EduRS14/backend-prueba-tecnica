package com.prueba.civa.prueba_api.excepciones;

import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(value=org.springframework.http.HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    private String nombreRecurso;
    private String nombreCampo;
    private long valorCampo;

    public ResourceNotFoundException(String nombreRecurso, String nombreCampo, long valorCampo) {
        super(String.format("El %s con el campo '%s' con un valor = %d no fue encontrado", nombreRecurso, nombreCampo, valorCampo));
        this.nombreRecurso = nombreRecurso;
        this.nombreCampo = nombreCampo;
        this.valorCampo = valorCampo;
    }

    public String getNombreRecurso() {
        return nombreRecurso;
    }

    public void setNombreRecurso(String nombreRecurso) {
        this.nombreRecurso = nombreRecurso;
    }

    public String getNombreCampo() {
        return nombreCampo;
    }

    public void setNombreCampo(String nombreCampo) {
        this.nombreCampo = nombreCampo;
    }

    public long getValorCampo() {
        return valorCampo;
    }

    public void setValorCampo(long valorCampo) {
        this.valorCampo = valorCampo;
    }
}
