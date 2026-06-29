package com.hotel.reservas.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.dao.DataIntegrityViolationException;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Este método captura específicamente errores cuando faltan datos obligatorios o hay duplicados
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Map<String, String>> handleDataIntegrity(DataIntegrityViolationException ex) {
        Map<String, String> response = new HashMap<>();
        
        // Obtenemos el mensaje de la excepción original
        String message = ex.getRootCause() != null ? ex.getRootCause().getMessage() : ex.getMessage();
        
        response.put("error", "Información importante");
        
        // Lógica: Si el error contiene la palabra 'numero_documento', lanzamos el mensaje personalizado
        if (message != null && message.contains("numero_documento")) {
            response.put("message", "Ya contamos con un registro asociado a este documento. Si necesitas realizar algún cambio, por favor contáctanos.");
        } else {
            response.put("message", "No pudimos completar tu solicitud. Por favor, revisa que los datos sean correctos.");
        }
        
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }
}