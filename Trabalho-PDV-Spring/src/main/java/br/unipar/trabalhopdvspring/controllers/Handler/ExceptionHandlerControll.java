package br.unipar.trabalhopdvspring.controllers.Handler;

import br.unipar.trabalhopdvspring.exceptions.ApiException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ExceptionHandlerControll {


        @ExceptionHandler(Exception.class)
        @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
        //Determina o status através de annotations
        public ApiException handleException(Exception e) {
            return new ApiException(e.getMessage());
        }

        @ExceptionHandler(MethodArgumentNotValidException.class)
        public ResponseEntity<ApiException> handleMethodArgumentNotValidException(
                MethodArgumentNotValidException e) {

            List<String> errors = new ArrayList<>();

            for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
                errors.add(fieldError.getField() + ": " +
                        fieldError.getDefaultMessage());
            }

            ApiException apiException = new ApiException(errors);

            return ResponseEntity.badRequest().body(apiException);
        }

    }

