package com.prueba.civa.prueba_api.dto;

import com.prueba.civa.prueba_api.entidades.MarcaBus;

public class BusDTO {
    private Long id;
    private String numeroBus;
    private String placa;
    private String fechaCreacion;
    private String caracteristicas;
    private MarcaBusDTO marca;
    private boolean activo;

    public BusDTO() {
    }

    public BusDTO(Long id, String numeroBus, String placa, String fechaCreacion, String caracteristicas, MarcaBusDTO marca, boolean activo) {
        this.id = id;
        this.numeroBus = numeroBus;
        this.placa = placa;
        this.fechaCreacion = fechaCreacion;
        this.caracteristicas = caracteristicas;
        this.marca = marca;
        this.activo = activo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroBus() {
        return numeroBus;
    }

    public void setNumeroBus(String numeroBus) {
        this.numeroBus = numeroBus;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public MarcaBusDTO getMarca() {
        return marca;
    }

    public void setMarca(MarcaBusDTO marca) {
        this.marca = marca;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
