package com.academia.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_curso_horario")
public class CursoHorario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_curso_horario")
    private Integer idCursoHorario;

    @ManyToOne
    @JoinColumn(name = "id_curso", nullable = false)
    private Curso curso;

    @ManyToOne
    @JoinColumn(name = "id_horario", nullable = false)
    private Horario horario;

    @Column(name = "vacantes", nullable = false)
    private Integer vacantes;

    @Column(name = "estado", nullable = false)
    private String estado;

	public CursoHorario() {
		super();
	}

	public Integer getIdCursoHorario() {
		return idCursoHorario;
	}

	public void setIdCursoHorario(Integer idCursoHorario) {
		this.idCursoHorario = idCursoHorario;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}

	public Integer getVacantes() {
		return vacantes;
	}

	public void setVacantes(Integer vacantes) {
		this.vacantes = vacantes;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
    
    

}
