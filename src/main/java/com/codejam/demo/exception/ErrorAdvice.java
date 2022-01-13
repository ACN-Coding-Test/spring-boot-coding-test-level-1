package com.codejam.demo.exception;

import com.codejam.demo.constant.ErrorCodes;
import com.codejam.demo.dto.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ErrorAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleDataNotFoundException(DataNotFoundException ex) {

        ErrorResponseDto errorResponseDto = ErrorResponseDto.builder()
                .errorCode(ErrorCodes.LS001)
                .message(ex.getMessage())
                .variable(ex.getVariable()).build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponseDto);

    }

    @ExceptionHandler(ExternalCallException.class)
    public ResponseEntity<ErrorResponseDto> handleExternalCallException(ExternalCallException ex) {

        ErrorResponseDto errorResponseDto = ErrorResponseDto.builder()
                .errorCode(ErrorCodes.LS002)
                .message(ex.getMessage())
                .variable(ex.getVariable()).build();

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponseDto);

    }

    @ExceptionHandler(GeneralException.class)
    public ResponseEntity<ErrorResponseDto> handleGeneralException(GeneralException ex) {

        ErrorResponseDto errorResponseDto = ErrorResponseDto.builder()
                .errorCode(ErrorCodes.LS003)
                .message(ex.getMessage())
                .variable(ex.getVariable()).build();

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponseDto);

    }

}
