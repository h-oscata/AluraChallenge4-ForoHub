package com.alura.ForoHub.domain.curso;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cursos")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nombre no puede ser vacio")
    private String name;

    @NotBlank(message = "Categoria no puede ser vacia")
    private String category;

    public Curso(String name, String category) {
        this.name = name;
        this.category = category;
    }

}
