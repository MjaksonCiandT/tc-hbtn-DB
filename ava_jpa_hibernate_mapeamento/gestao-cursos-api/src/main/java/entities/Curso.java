package org.example.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Curso")
public class Curso implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeCompleto;
    private String sigla;

    public Curso() {
    }

    public Curso(Long id, String nomeCompleto, String sigla) {
        this.id = id;
        this.nomeCompleto = nomeCompleto;
        this.sigla = sigla;
    }

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor ;

    @OneToOne(mappedBy = "Curso")
    private MaterialCurso material;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
}
