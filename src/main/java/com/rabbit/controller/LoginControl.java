package com.rabbit.controller;

import java.util.Collections;

import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rabbit.vm.JWTToken;
import com.rabbit.vm.LoginVM;

@RestController
@RequestMapping("/login")
public class LoginControl {

	public final static String AUTHORIZATION_HEADER = "Authorization";

	@GetMapping("/aa")
	public ResponseEntity<?> authorize(LoginVM loginVM, HttpServletResponse response) {

		try {
			String jwt = "test";
			response.addHeader(AUTHORIZATION_HEADER, "Bearer " + jwt);
			return ResponseEntity.ok(new JWTToken(jwt));
		} catch (Exception exception) {
			return new ResponseEntity<>(
					Collections.singletonMap("AuthenticationException", exception.getLocalizedMessage()),
					HttpStatus.UNAUTHORIZED);
		}
	}
}