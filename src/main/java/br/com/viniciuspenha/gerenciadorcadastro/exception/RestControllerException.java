package br.com.viniciuspenha.gerenciadorcadastro.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestControllerAdvice(basePackages = "br.com.viniciuspenha.gerenciadorcadastro.api")
public class RestControllerException {

    private ApiError getApiError(String message, HttpStatus httpStatus, HttpServletRequest req) {
        return new ApiError.ApiErrorBuilder()
                .status(httpStatus.value())
                .error(httpStatus.getReasonPhrase())
                .message(message)
                .path(req.getRequestURI()).build();
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiError handleUnexpectedException(HttpServletRequest req, Throwable ex) {
        log.error("RestControllerException.handleUnexpectedException - " + ex.getMessage());
        return this.getApiError("Um erro inesperado aconteceu", HttpStatus.INTERNAL_SERVER_ERROR, req);
    }

    @ExceptionHandler(ModeloNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiError handleModeloNotFoundException(HttpServletRequest req, Throwable ex) {
        log.error("RestControllerException.handleModeloNotFoundException - " + ex.getMessage());
        return this.getApiError(ex.getMessage(), HttpStatus.NOT_FOUND, req);
    }
}