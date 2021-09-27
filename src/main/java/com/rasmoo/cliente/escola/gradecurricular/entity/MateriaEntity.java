package com.rasmoo.cliente.escola.gradecurricular.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_materia")
@Data
@NoArgsConstructor
public class MateriaEntity implements Serializable {
    private static final long serialVersionUID = -51452515215245l;

    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name= "increment",strategy = "increment")
    private Long id;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @Column(name ="nome")
    private String nome;
    @Column(name = "hrs")
    private int horas;
    @Column(name = "cod")
    private String codigo;
    @Column(name = "freq")
    private int frequencia;
}
