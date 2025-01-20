package com.alura.ForoHub.service.curso;

import com.alura.ForoHub.domain.curso.Curso;
import com.alura.ForoHub.repository.curso.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    // Obtener todos los cursos
    public List<Curso> getAllCursos() {
        return cursoRepository.findAll();
    }

    // Obtener curso por ID
    public Optional<Curso> getCursoById(Long id) {
        return cursoRepository.findById(id);
    }

    // Crear curso
    public Curso createCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    // Actualizar curso
    public Curso updateCurso(Long id, Curso cursoDetails) {
        Optional<Curso> curso = cursoRepository.findById(id);
        if (curso.isPresent()) {
            Curso existingCurso = curso.get();
            existingCurso.setName(cursoDetails.getName());
            existingCurso.setCategory(cursoDetails.getCategory());
            return cursoRepository.save(existingCurso);
        }
        return null;
    }

    // Eliminar curso
    public void deleteCurso(Long id) {
        cursoRepository.deleteById(id);
    }
}
