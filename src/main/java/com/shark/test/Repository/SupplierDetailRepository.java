package com.shark.test.Repository;

import com.shark.test.Entity.SupplierDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierDetailRepository extends JpaRepository<SupplierDetail, Long> {

    SupplierDetail findByUuid(String uuid);
}
