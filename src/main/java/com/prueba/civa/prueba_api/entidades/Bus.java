package com.prueba.civa.prueba_api.entidades;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "buses", uniqueConstraints = {@UniqueConstraint(columnNames = {"numero_bus", "placa"})})
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero_bus", nullable = false)
    private int numeroBus;

    @Column(name = "placa", nullable = false)
    private String placa;

    @Column(name = "fecha_creacion", updatable = false)
    private LocalDate fechaCreacion;

    @Column(name = "caracteristicas", nullable = false)
    private String caracteristicas;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "marca_id", nullable = false)
    private MarcaBus marca;

    @Column(name = "activo", nullable = false)
    private boolean activo;

    public Bus() {
    }

    public Bus(Long id, int numeroBus, String placa, String caracteristicas, MarcaBus marca, boolean activo) {
        this.id = id;
        this.numeroBus = numeroBus;
        this.placa = placa;
        this.caracteristicas = caracteristicas;
        this.marca = marca;
        this.activo = activo;
    }

    @PrePersist
    protected void onCreate() {
        this.fechaCreacion = LocalDate.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumeroBus() {
        return numeroBus;
    }

    public void setNumeroBus(int numeroBus) {
        this.numeroBus = numeroBus;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public MarcaBus getMarca() {
        return marca;
    }

    public void setMarca(MarcaBus marca) {
        this.marca = marca;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
