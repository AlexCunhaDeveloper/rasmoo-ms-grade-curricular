package com.rasmoo.cliente.escola.gradecurricular.service;

import com.rasmoo.cliente.escola.gradecurricular.entity.MateriaEntity;

import java.time.LocalDate;
import java.util.List;

public interface IMateriaService {
    public Boolean atualizar(final MateriaEntity materia);

    public Boolean excluir(final Long id);

    public List<MateriaEntity> listar();

    public MateriaEntity consultar(Long id);
}
