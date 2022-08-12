package com.jwt_react_jwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwt_react_jwt.model.User;
import com.jwt_react_jwt.payload.request.LoginRequest;
import com.jwt_react_jwt.payload.request.SignupRequest;
import com.jwt_react_jwt.payload.response.JwtResponse;
import com.jwt_react_jwt.payload.response.MessageResponse;
import com.jwt_react_jwt.repository.UserRepository;
import com.jwt_react_jwt.security.jwt.JwtUtils;
import com.jwt_react_jwt.security.service.UserDetailsImpl;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private AuthenticationManager authenticationmanager;
	
	@Autowired
	private JwtUtils jwtUtils;
	
	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@RequestBody SignupRequest signupRequest){
		if(userRepository.existsByUsername(signupRequest.getUsername())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken"));
		}
		if(userRepository.existsByEmail(signupRequest.getEmail())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already taken"));
		}
		User user = new User(signupRequest.getUsername(),signupRequest.getEmail(),encoder.encode(signupRequest.getPassword()));
		user.setRole("ROLE_USER");
		userRepository.save(user);
		return ResponseEntity.ok(new MessageResponse("회원가입 성공"));
	}
	
	@PostMapping("/signin")
	public ResponseEntity<?> authenticationUser(@RequestBody LoginRequest loginRequest){
		Authentication authentication 
			= authenticationmanager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		UserDetailsImpl userDetailsImpl = (UserDetailsImpl)authentication.getPrincipal();
		return ResponseEntity.ok(new JwtResponse(
				jwt, userDetailsImpl.getId(), userDetailsImpl.getUsername(), userDetailsImpl.getEmail(), userDetailsImpl.getRole()));
	}

}
