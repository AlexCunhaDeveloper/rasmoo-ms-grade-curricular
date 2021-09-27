package com.rasmoo.cliente.escola.gradecurricular.service;

import com.rasmoo.cliente.escola.gradecurricular.entity.MateriaEntity;
import com.rasmoo.cliente.escola.gradecurricular.exception.MateriaException;
import com.rasmoo.cliente.escola.gradecurricular.repository.IMateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MateriaService implements IMateriaService {

    @Autowired
    private IMateriaRepository materiaRepository;

    @Override
    public Boolean atualizar(MateriaEntity materia) {
        try {

            Optional<MateriaEntity> materiaOptional = this.materiaRepository.findById(materia.getId());
            if(materiaOptional.isPresent()){
                MateriaEntity materiaEntityAtualizar = materiaOptional.get();

                materiaEntityAtualizar.setNome(materia.getNome());
                materiaEntityAtualizar.setCodigo(materia.getCodigo());
                materiaEntityAtualizar.setHoras(materia.getHoras());
                materiaEntityAtualizar.setFrequencia(materia.getFrequencia());
                this.materiaRepository.save(materiaEntityAtualizar);
                return true;
            }

            return false;
        }catch (Exception e){
            return false;

        }
    }

    @Override
    public Boolean excluir(Long id) {
        try {
            this.consultar(id);
            this.materiaRepository.deleteById(id);
            return true;
        }
        catch (MateriaException m){
            throw m;
        }
        catch (Exception e){
            throw e;
        }
    }

    @Override
    public List<MateriaEntity> listar(){
        try{
           return this.materiaRepository.findAll();

        }

        catch (Exception e){
            return new ArrayList<>();
        }
    }

    @Override
    public MateriaEntity consultar(Long id){
        try {

            Optional<MateriaEntity> materiaOptional = this.materiaRepository.findById(id);
            if(materiaOptional.isPresent()){
                return materiaOptional.get();
            }
            throw new MateriaException("Materia não encontrada", HttpStatus.NOT_FOUND);
        }
        catch (MateriaException m){
            throw m;
        }

        catch (Exception e){
            throw new MateriaException("Error interno identificado. Contate o suporte", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
