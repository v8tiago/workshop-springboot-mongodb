package com.tiagoarruda.workshopmongo.resources;

import com.tiagoarruda.workshopmongo.resources.exception.StandartError;
import com.tiagoarruda.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandartError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request)
    {
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandartError err = new StandartError(System.currentTimeMillis(), status.value(), "Não encontrado",e.getMessage(), request.getRequestURI());

        return ResponseEntity.status(status).body(err);
    }
}
