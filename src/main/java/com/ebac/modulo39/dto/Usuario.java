package com.ebac.modulo39.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;
    private String nombre;
    private int edad;
    @OneToMany(mappedBy= "usuario", cascade = CascadeType.ALL)
    @JsonManagedReference //parte administrada de la relacion
    private List<Telefono> telefonos = new ArrayList<>();

}
