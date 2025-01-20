package com.alura.ForoHub.repository.curso;

import com.alura.ForoHub.domain.curso.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
