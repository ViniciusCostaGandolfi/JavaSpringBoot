package medi.voll.api.infra.exception;



import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandlerError {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> catchErro404() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public  ResponseEntity<Object> catchErro400(MethodArgumentNotValidException exception) {
        var erros = exception.getFieldErrors()
            .stream()
            .map(errorField -> new ErrorValidationDTO(errorField))
            .toList();
        return ResponseEntity.badRequest().body(erros);
    }


    private record ErrorValidationDTO(String field, String errorMessage) {

        public ErrorValidationDTO(FieldError fieldError) {
            this(fieldError.getField(), fieldError.getDefaultMessage());
        }

    }

}
