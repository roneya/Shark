package com.shark.test.Entity;

import com.shark.test.DTO.SupplierDetailDTO;
import com.shark.test.Enums.ApplicationEnums;
import com.shark.test.Utility.SupplyDetailUtility;
import jakarta.persistence.*;
import lombok.*;

import java.util.Base64;
import java.util.concurrent.ThreadLocalRandom;

@Entity
@Table
@Getter
@Setter
public class SupplierDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String uuid;

    private String companyName;

    private String location;

    private String website;

    @Enumerated(EnumType.STRING)
    private ApplicationEnums.BusinessNature businessNature;

    @Enumerated(EnumType.STRING)
    private ApplicationEnums.ManufacturerProcess manufacturerProcess;

    public SupplierDetail() {
        this.uuid = SupplyDetailUtility.uuidGenerator();
    }

    public void update(SupplierDetailDTO supplierDetailDTO){
        this.companyName = supplierDetailDTO.getCompanyName();
        this.location = supplierDetailDTO.getLocation();
        this.website = supplierDetailDTO.getWebsite();
        this.businessNature = supplierDetailDTO.getBusinessNature();
        this.manufacturerProcess = supplierDetailDTO.getManufacturerProcess();
    }
}
