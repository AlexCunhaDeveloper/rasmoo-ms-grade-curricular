package com.rasmoo.cliente.escola.gradecurricular.controller;

import com.rasmoo.cliente.escola.gradecurricular.repository.IMateriaRepository;
import com.rasmoo.cliente.escola.gradecurricular.service.IMateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.rasmoo.cliente.escola.gradecurricular.entity.MateriaEntity;

import java.util.List;

@RestController
@RequestMapping("/materias")
public class MateriaController {

    @Autowired
    private IMateriaRepository materiaRepository;

    @Autowired
    private IMateriaService materiaService;


    @GetMapping
    public ResponseEntity <List<MateriaEntity>> listarMaterias(){
        return ResponseEntity.status(HttpStatus.OK).body(this.materiaService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity <MateriaEntity> consultaMateria(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(this.materiaService.consultar(id));
    }

    @PostMapping
    public ResponseEntity <Boolean> CadastrarMaterias(@RequestBody MateriaEntity materia){
        try {
            this.materiaRepository.save(materia);
        return ResponseEntity.status(HttpStatus.CREATED).body(true);

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.OK).body(false);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> excluirMateria(@PathVariable Long id){

            return ResponseEntity.status(HttpStatus.OK).body(this.materiaService.excluir(id));

    }

    @PutMapping
    public ResponseEntity<Boolean> atualizarMateria(@RequestBody MateriaEntity materia){

            return ResponseEntity.status(HttpStatus.OK).body(this.materiaService.atualizar(materia));


    }

}
