package com.security.poc.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author by Danyal
 * @classname RegisterRequest
 * @Date 28/10/2023 2:16 am
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

  private String firstName;
  private String lastName;
  private String email;
  private String password;

}
