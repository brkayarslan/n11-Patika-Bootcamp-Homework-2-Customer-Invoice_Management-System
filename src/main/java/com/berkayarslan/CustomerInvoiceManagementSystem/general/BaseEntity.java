package com.berkayarslan.CustomerInvoiceManagementSystem.general;

import jakarta.persistence.Embedded;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntity implements BaseModel{

    @Embedded
    private BaseAdditionalFields baseAdditinalFields;
}
