package in.bassure.subscription.app.controller;

import in.bassure.subscription.app.config.AppConfig;
import in.bassure.subscription.app.model.Body;
import in.bassure.subscription.app.model.Header;
import in.bassure.subscription.app.model.ResponseEntity;
import java.util.List;
import java.util.logging.Logger;

import in.bassure.subscription.app.model.exception.DataNotFoundException;
import org.springframework.dao.DataAccessException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    static final Logger logger = Logger.getLogger(GlobalExceptionHandler.class.getName());

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity methodArgumentNotValidException(MethodArgumentNotValidException exception) {
        List<ObjectError> errorlist = exception.getAllErrors();

        return ResponseEntity
                .builder()
                .header(Header.builder().code(AppConfig.getFIELD_VALIDATE()).build())
                .body(Body.builder().error(errorlist.get(errorlist.size() - 1).getDefaultMessage()).build())
                .build();
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity httpMessageNotReadableExceptionHandler() {
        return ResponseEntity
                .builder()
                .header(Header.builder().code(AppConfig.getFIELD_VALIDATE()).build())
                .body(Body.builder().error(AppConfig.getFIELD_VALIDATE_MESSAGE()).build())
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

    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity dataAccessException(DataAccessException dataAccessException) {
        logger.severe(dataAccessException.getMessage());
        dataAccessException.printStackTrace();

        return ResponseEntity
                .builder()
                .header(Header.builder().code(AppConfig.getSERVER_ERROR()).build())
                .body(Body.builder().error(AppConfig.getSERVER_ERROR_MESSAGE()).build())
                .build();
    }

}
