package com.security.poc.entity;

import jakarta.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * @author by Danyal
 * @classname BaseEntity
 * @Date 28/10/2023 8:00 pm
 */

@Data
@MappedSuperclass
public class BaseEntity implements Serializable {

  public Date createdAt;

  public Date updatedAt;
}
