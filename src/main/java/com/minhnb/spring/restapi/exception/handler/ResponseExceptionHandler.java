package com.minhnb.spring.restapi.exception.handler;

import com.minhnb.spring.restapi.exception.ApiException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

//    @ExceptionHandler(ApiException.class)
//    public final ResponseDto<String> handleAllExceptions(ApiException e) {
//
//        return new ResponseDto<>("", e.getStatusDto());
//    }

    @ExceptionHandler(ApiException.class)
    public final ResponseEntity<Object> handleAllExceptions(ApiException e, WebRequest request) {

        return new ResponseEntity<>(e.getStatusDto(), e.getStatusDto().getHttpStatus());
    }

//    @ExceptionHandler(value = {IllegalArgumentException.class, IllegalStateException.class})
//    protected ResponseEntity<Object> handleConflict(
//            RuntimeException ex, WebRequest request) {
//        String bodyOfResponse = "This should be application specific";
//        return handleExceptionInternal(ex, bodyOfResponse,
//                new HttpHeaders(), HttpStatus.CONFLICT, request);
//    }
//
//    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
//                                                                  HttpHeaders headers,
//                                                                  HttpStatus status,
//                                                                  WebRequest request) {
//        String error = "Malformed JSON request";
//        return buildResponseEntity(new ApiError(HttpStatus.BAD_REQUEST, error, ex));
//    }

//    @Override
//    protected ResponseEntity<Object> handleMethodArgumentNotValid(
//            MethodArgumentNotValidException ex,
//            HttpHeaders headers,
//            HttpStatus status,
//            WebRequest request) {
//
//        List<String> errors = new ArrayList<String>();
//
//        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
//            errors.add(error.getField() + ": " + error.getDefaultMessage());
//        }
//
//        for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
//            errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
//        }
//
//        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), errors);
//
//        return handleExceptionInternal(ex, errorResponse, headers, errorResponse.getStatus(), request);
//    }
//
//    @Override
//    protected ResponseEntity<Object> handleMissingServletRequestParameter(
//            MissingServletRequestParameterException ex,
//            HttpHeaders headers,
//            HttpStatus status,
//            WebRequest request) {
//
//        String error = ex.getParameterName() + " parameter is missing";
//
//        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), error);
//
//        return new ResponseEntity<Object>(errorResponse, new HttpHeaders(), errorResponse.getStatus());
//    }
//
//    @ExceptionHandler({MethodArgumentTypeMismatchException.class})
//    public ResponseEntity<Object> handleMethodArgumentTypeMismatch(
//            MethodArgumentTypeMismatchException ex, WebRequest request) {
//
//        String error = ex.getName() + " should be of type " + ex.getRequiredType().getName();
//
//        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), error);
//
//        return new ResponseEntity<Object>(errorResponse, new HttpHeaders(), errorResponse.getStatus());
//    }
//
//    @Override
//    protected ResponseEntity<Object> handleNoHandlerFoundException(
//            NoHandlerFoundException ex,
//            HttpHeaders headers,
//            HttpStatus status,
//            WebRequest request) {
//
//        String error = "No handler found for " + ex.getHttpMethod() + " " + ex.getRequestURL();
//
//        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND, ex.getLocalizedMessage(), error);
//
//        return new ResponseEntity<Object>(errorResponse, new HttpHeaders(), errorResponse.getStatus());
//    }
//
//    @Override
//    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(
//            HttpRequestMethodNotSupportedException ex,
//            HttpHeaders headers,
//            HttpStatus status,
//            WebRequest request) {
//
//        StringBuilder builder = new StringBuilder();
//
//        builder.append(ex.getMethod());
//        builder.append(" method is not supported for this request. Supported methods are ");
//        ex.getSupportedHttpMethods().forEach(httpMethod -> builder.append(httpMethod + " "));
//
//        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.METHOD_NOT_ALLOWED, ex.getLocalizedMessage(), builder.toString());
//
//        return new ResponseEntity<Object>(errorResponse, new HttpHeaders(), errorResponse.getStatus());
//    }

}
