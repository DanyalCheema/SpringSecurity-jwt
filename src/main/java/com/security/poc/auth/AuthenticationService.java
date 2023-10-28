package com.security.poc.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.security.poc.config.JwtService;
import com.security.poc.user.Role;
import com.security.poc.user.User;
import com.security.poc.user.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author by Danyal
 * @classname AuthenticationService
 * @Date 28/10/2023 2:20 am
 */

@Service
@RequiredArgsConstructor
public class AuthenticationService {

  private final UserRepository repository;
  private final PasswordEncoder passwordEncoder;
  private final JwtService jwtService;
  private final AuthenticationManager authenticationManager;

  public AuthenticationResponse register(RegisterRequest request) {
    var user = User.builder()
      .firstName(request.getFirstName())
      .lastName(request.getLastName())
      .email(request.getEmail())
      .password(passwordEncoder.encode(request.getPassword()))
      .role(Role.USER)
      .build();
    var savedUser = repository.save(user);
    var jwtToken = jwtService.generateToken(user);
    var refreshToken = jwtService.generateRefreshToken(user);
    return AuthenticationResponse.builder()
      .accessToken(jwtToken)
      .refreshToken(refreshToken)
      .build();
  }

  public AuthenticationResponse authenticate(AuthenticationRequest request) {
    authenticationManager.authenticate(
      new UsernamePasswordAuthenticationToken(
        request.getEmail(),
        request.getPassword()
      )
    );
    var user = repository.findByEmail(request.getEmail())
      .orElseThrow();
    var jwtToken = jwtService.generateToken(user);
    var refreshToken = jwtService.generateRefreshToken(user);
    return AuthenticationResponse.builder()
      .accessToken(jwtToken)
      .refreshToken(refreshToken)
      .build();
  }

  public void refreshToken(
    HttpServletRequest request,
    HttpServletResponse response
  ) throws IOException {
    final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
    final String refreshToken;
    final String userEmail;
    if (authHeader == null ||!authHeader.startsWith("Bearer ")) {
      return;
    }
    refreshToken = authHeader.substring(7);
    userEmail = jwtService.extractUsername(refreshToken);
    if (userEmail != null) {
      var user = this.repository.findByEmail(userEmail)
        .orElseThrow();
      if (jwtService.isTokenValid(refreshToken, user)) {
        var accessToken = jwtService.generateToken(user);
        var authResponse = AuthenticationResponse.builder()
          .accessToken(accessToken)
          .refreshToken(refreshToken)
          .build();
        new ObjectMapper().writeValue(response.getOutputStream(), authResponse);
      }
    }
  }

}
