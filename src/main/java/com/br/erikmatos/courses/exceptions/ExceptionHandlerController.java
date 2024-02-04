package com.br.erikmatos.courses.exceptions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

@ControllerAdvice
public class ExceptionHandlerController {

    private MessageSource messageSource;

    public ExceptionHandlerController(MessageSource message) {
        this.messageSource = message;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorMessageDTO>> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException e) {

        List<ErrorMessageDTO> dto = new ArrayList<>();

        e.getBindingResult().getFieldErrors().forEach(err -> {
            String message = messageSource.getMessage(err, LocaleContextHolder.getLocale());
            ErrorMessageDTO error = new ErrorMessageDTO(message, err.getField());
            dto.add(error);
        });

        return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorMessageDTO> handleMethodArgumentTypeMismatchException(
            MethodArgumentTypeMismatchException e) {

        String paramName = e.getName();
        String requiredType = e.getRequiredType() != null ? e.getRequiredType().getSimpleName() : "desconhecido";
        String message = "Parâmetro '" + paramName + "' deve ser do tipo " + requiredType;
        ErrorMessageDTO error = new ErrorMessageDTO(message, paramName);

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorMessageDTO> handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        if (e.getCause() instanceof InvalidFormatException) {
            InvalidFormatException invalidFormatException = (InvalidFormatException) e.getCause();
            String paramName = invalidFormatException.getPath().get(0).getFieldName();
            String requiredType = invalidFormatException.getTargetType().getSimpleName();
            String enumValues = getEnumValues(invalidFormatException.getTargetType());
            String message = "Erro de desserialização para o campo '" + paramName +
                    "'. Deve ser do tipo " + requiredType + ". Valores aceitos: " + enumValues;
            ErrorMessageDTO error = new ErrorMessageDTO(message, paramName);
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }

        String message = "Erro na desserialização: " + e.getMostSpecificCause().getMessage();
        ErrorMessageDTO error = new ErrorMessageDTO(message, "desconhecido");
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    private String getEnumValues(Class<?> enumType) {
        if (enumType.isEnum()) {
            StringBuilder values = new StringBuilder();
            Object[] enumConstants = enumType.getEnumConstants();
            for (Object constant : enumConstants) {
                values.append(constant).append(", ");
            }
            return values.substring(0, values.length() - 2);
        }
        return "";
    }
}
