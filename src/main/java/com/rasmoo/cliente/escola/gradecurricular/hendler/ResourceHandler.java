package com.rasmoo.cliente.escola.gradecurricular.hendler;

import com.rasmoo.cliente.escola.gradecurricular.exception.MateriaException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.rasmoo.cliente.escola.gradecurricular.model.ErroResponse;
import com.rasmoo.cliente.escola.gradecurricular.model.ErroResponse.ErroResponseBuilder;

@ControllerAdvice
public class ResourceHandler {

    @ExceptionHandler(MateriaException.class)
    public ResponseEntity<ErroResponse> handlerMateriaException(MateriaException m){
        ErroResponseBuilder erro = ErroResponse.builder();
        erro.httpStatus(m.getHttpStatus().value());
        erro.mensagem(m.getMessage());
        erro.timeStamp(System.currentTimeMillis());
        return ResponseEntity.status(m.getHttpStatus()).body(erro.build());
    }
}
