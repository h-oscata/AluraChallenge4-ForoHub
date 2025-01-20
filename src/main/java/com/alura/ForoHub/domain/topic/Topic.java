package com.alura.ForoHub.domain.topic;

import com.alura.ForoHub.domain.curso.Curso;
import com.alura.ForoHub.domain.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Entity
@Table(name = "topics")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Titulo no puede ser vacio")
    @Size(min = 5, max = 255, message = "Titulo debe ser de entre 2 y 255 caracteres")
    private String title;

    @NotBlank(message = "Mensaje no puede ser vacio")
    @Size(min = 5, max = 255, message = "Mensaje debe ser de entre 2 y 255 caracteres")
    private String message;

    @Column(name = "dateCreated")
    private Date dateCreated;

    @Enumerated(EnumType.STRING)
    private TopicStatus status;

    @ManyToOne
    @JoinColumn(name = "curso_id", nullable = false)
    private Curso curso;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Topic(String title, String message, Date dateCreated, TopicStatus status, Curso curso, User user) {
        this.title = title;
        this.message = message;
        this.dateCreated = dateCreated;
        this.status = status;
        this.curso = curso;
        this.user = user;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public TopicStatus getStatus() {
        return status;
    }

    public void setStatus(TopicStatus status) {
        this.status = status;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
