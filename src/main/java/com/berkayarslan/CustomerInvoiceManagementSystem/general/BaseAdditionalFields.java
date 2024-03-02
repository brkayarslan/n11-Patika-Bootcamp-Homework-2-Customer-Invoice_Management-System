package com.berkayarslan.CustomerInvoiceManagementSystem.general;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * createdAt, createdBy, updatedAt, updatedBy
 * @author bahadirmemis
 */
@Embeddable
@Getter
@Setter
public class BaseAdditionalFields {

  private LocalDateTime createDate;
  private LocalDateTime updateDate;
  private Long creatorId;
  private Long updaterId;
}
