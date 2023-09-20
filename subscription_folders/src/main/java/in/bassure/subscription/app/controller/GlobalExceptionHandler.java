package in.bassure.subscription.app.controller;

import in.bassure.subscription.app.config.AppConfig;
import in.bassure.subscription.app.model.Body;
import in.bassure.subscription.app.model.Header;
import in.bassure.subscription.app.model.ResponseEntity;
import java.util.List;

import in.bassure.subscription.app.model.exception.DataNotFoundException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity methodArgumentNotValidException(MethodArgumentNotValidException exception) {

        //creating header for error response with error code
        Header header = Header.builder().code(AppConfig.getFIELD_VALIDATE()).build();
        //get all errors 
        List<ObjectError> errorlist = exception.getAllErrors();
        //assign error to variable
        String errorDetails = errorlist.get(errorlist.size() - 1).getDefaultMessage();
        //create body for error response with error message
        Body body = Body.builder().error(errorDetails).build();

        return ResponseEntity
                .builder()
                .header(header)
                .body(body)
                .build();

    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity httpMessageNotReadableExceptionHandler() {
        return ResponseEntity
                .builder()
                .header(Header.builder().code(AppConfig.getFIELD_VALIDATE()).build())
                .body(Body.builder().error( AppConfig.getFIELD_VALIDATE_MESSAGE()).build())
                .build();
    }

    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity dataNotFoundException() {
        return ResponseEntity
                .builder()
                .header(Header.builder().code(AppConfig.getNO_DATA()).build())
                .body(Body.builder().error(AppConfig.getNO_DATA_MESSAGE()).build())
                .build();
    }

}
