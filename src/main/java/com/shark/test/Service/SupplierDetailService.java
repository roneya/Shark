package com.shark.test.Service;

import com.shark.test.Entity.SupplierDetail;
import com.shark.test.Repository.SupplierDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierDetailService {

    @Autowired
    @Lazy
    private SupplierDetailRepository supplierDetailRepository;

    public void save(SupplierDetail supplierDetail){
        supplierDetailRepository.save(supplierDetail);
    }
    public SupplierDetail findByUuid(String uuid){
        return supplierDetailRepository.findByUuid(uuid);
    }
}
