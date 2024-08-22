package com.shark.test.Utility;

import com.shark.test.DTO.SupplierDetailDTO;
import com.shark.test.Enums.ApplicationEnums;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomSQL {

    @Autowired
    @Lazy
    private EntityManager entityManager;

    public List<SupplierDetailDTO> searchSupplierDetail(String id, String location, String natureOfBusiness, String manufacturingProcess, String limit) {

        StringBuilder q = new StringBuilder("SELECT uuid, company_name, location, website, business_nature, manufacturer_process " +
                "from supplier_detail where 1=1");
        if (id != null) {
            q.append(" and id = :id");
        }
        if (location != null) {
            q.append(" and location = :location");
        }
        if (natureOfBusiness != null) {
            q.append(" and business_nature = :business_nature");
        }
        if (manufacturingProcess != null) {
            q.append(" and manufacturer_process = :manufacturer_process");
        }

        if (limit != null) {
            q.append(" limit :limit");
        }

        Query query = entityManager.createNativeQuery(q.toString());
        if (id != null) {
            query.setParameter("id", Long.parseLong(id));
        }
        if (location != null) {
            query.setParameter("location", location);
        }
        if (natureOfBusiness != null) {
            query.setParameter("business_nature", natureOfBusiness);
        }
        if (manufacturingProcess != null) {
            query.setParameter("manufacturer_process", manufacturingProcess);
        }
        if (limit != null) {
            query.setParameter("limit", Integer.parseInt(limit));
        }

        List<Object[]> list = query.getResultList();
        List<SupplierDetailDTO> supplierDetailDTOS = new ArrayList<>();
        for (Object[] object : list) {
            SupplierDetailDTO supplierDetailDTO = new SupplierDetailDTO();
            supplierDetailDTO.setUuid((String) object[0]);
            supplierDetailDTO.setCompanyName((String) object[1]);
            supplierDetailDTO.setLocation((String) object[2]);
            supplierDetailDTO.setWebsite((String) object[3]);
            supplierDetailDTO.setBusinessNature(ApplicationEnums.BusinessNature.valueOf((String) object[4]));
            supplierDetailDTO.setManufacturerProcess(ApplicationEnums.ManufacturerProcess.valueOf((String) object[5]));
            supplierDetailDTOS.add(supplierDetailDTO);
        }

        return supplierDetailDTOS;
    }

}
