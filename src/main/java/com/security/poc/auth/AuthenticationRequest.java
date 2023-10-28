package com.security.poc.auth;

/**
 * @author by Danyal
 * @classname AuthenticationRequest
 * @Date 28/10/2023 2:07 am
 */

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class AuthenticationRequest {

  private String email;
  String password;
}
