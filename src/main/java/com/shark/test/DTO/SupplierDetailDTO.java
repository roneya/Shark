package com.shark.test.DTO;

import com.shark.test.Entity.SupplierDetail;
import com.shark.test.Enums.ApplicationEnums;
import lombok.Data;

@Data
public class SupplierDetailDTO {

    private String uuid;

    private String companyName;

    private String location;

    private String website;

    private ApplicationEnums.BusinessNature businessNature;

    private ApplicationEnums.ManufacturerProcess manufacturerProcess;

    public SupplierDetailDTO() {
    }

    public SupplierDetailDTO(SupplierDetail supplierDetail) {
        this.uuid = supplierDetail.getUuid();
        this.companyName = supplierDetail.getCompanyName();
        this.location = supplierDetail.getLocation();
        this.website = supplierDetail.getWebsite();
        this.businessNature = supplierDetail.getBusinessNature();
    }
}
