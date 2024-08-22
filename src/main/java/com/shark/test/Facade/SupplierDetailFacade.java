package com.shark.test.Facade;

import com.shark.test.DTO.SupplierDetailDTO;
import com.shark.test.Entity.SupplierDetail;
import com.shark.test.Service.SupplierDetailService;
import com.shark.test.Utility.CustomSQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SupplierDetailFacade {

    @Autowired
    private SupplierDetailService supplierDetailService;

    @Autowired
    private CustomSQL customSQL;

    public void saveOrUpdateSupplierDetail(SupplierDetailDTO supplierDetailDTO) {
        SupplierDetail supplierDetail;
        if(supplierDetailDTO.getUuid() == null || supplierDetailDTO.getUuid().isEmpty()) {
            supplierDetail = new SupplierDetail();
            supplierDetailDTO.setUuid(supplierDetail.getUuid());
        } else {
            supplierDetail = supplierDetailService.findByUuid(supplierDetailDTO.getUuid());
        }
        if(supplierDetail == null){
            throw new RuntimeException("Supplier not found");
        }
        supplierDetail.update(supplierDetailDTO);
        supplierDetailService.save(supplierDetail);
    }

    public SupplierDetailDTO getSupplierDetail(String uuid) {
        SupplierDetail supplierDetail = supplierDetailService.findByUuid(uuid);
        if(supplierDetail == null){
            throw new RuntimeException("Supplier not found");
        }
        return new SupplierDetailDTO(supplierDetail);
    }

    public List<SupplierDetailDTO> searchSupplierDetail(String id, String location, String natureOfBusiness, String manufacturingProcess,
                                                  String limit) {

        return customSQL.searchSupplierDetail(id, location, natureOfBusiness, manufacturingProcess, limit);
    }
}
