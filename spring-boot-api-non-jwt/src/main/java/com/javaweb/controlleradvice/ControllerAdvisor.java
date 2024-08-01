package com.javaweb.controlleradvice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.javaweb.customexception.FieldRequiredException;
import com.javaweb.dto.ErrorResponseDTO;

@ControllerAdvice
public class ControllerAdvisor {
	@ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<Object> handleArithmeticException(ArithmeticException ex) {

		ErrorResponseDTO errorRespDTO = new ErrorResponseDTO();
		errorRespDTO.setError(ex.getMessage());
		List<String> details = new ArrayList<String>();
		String detail1 = "Lỗi phép chia cho 0 !!!";
		details.add(detail1);
		errorRespDTO.setDetail(details);

        return new ResponseEntity<>(errorRespDTO, HttpStatus.INTERNAL_SERVER_ERROR);
    }
	
	@ExceptionHandler(FieldRequiredException.class)
    public ResponseEntity<Object> handleFieldRequiredException(FieldRequiredException ex) {

		ErrorResponseDTO errorRespDTO = new ErrorResponseDTO();
		errorRespDTO.setError(ex.getMessage());
		List<String> details = new ArrayList<String>();
		String detail1 = "Tên tòa nhà và số tầng hầm không được thiếu";
		details.add(detail1);
		errorRespDTO.setDetail(details);

        return new ResponseEntity<>(errorRespDTO, HttpStatus.BAD_REQUEST);
    }
}


















