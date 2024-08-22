package com.shark.test.Controller;

import com.shark.test.DTO.SupplierDetailDTO;
import com.shark.test.Facade.SupplierDetailFacade;
import com.shark.test.Utility.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shark")
public class SupplierDetailController {

    @Autowired
    private SupplierDetailFacade supplierDetailFacade;

    @RequestMapping(value = "supply/detail", method = {RequestMethod.POST, RequestMethod.PUT})
    public ResponseDTO saveUpdateSupplyDetail(@RequestBody SupplierDetailDTO supplierDetailDTO) {
        supplierDetailFacade.saveOrUpdateSupplierDetail(supplierDetailDTO);
        return new ResponseDTO(Boolean.TRUE, supplierDetailDTO, "Supplier Detail saved successfully");
    }

    @RequestMapping(value = "supply/detail/{uuid}", method = RequestMethod.GET)
    public ResponseDTO getSupplyDetail(@PathVariable String uuid) {
        return new ResponseDTO(Boolean.TRUE, supplierDetailFacade.getSupplierDetail
                (uuid), "Supplier Detail saved successfully");
    }

    @RequestMapping(value = "supply/detail/custom/search", method = RequestMethod.GET)
    public ResponseDTO searchSupplyDetail(@RequestParam(value = "id", required = false) String id,
                                          @RequestParam(value = "location", required = false) String location,
                                          @RequestParam(value = "natureOfBusiness", required = false) String natureOfBusiness,
                                          @RequestParam(value = "manufacturerProcess", required = false) String manufacturingProcess,
                                          @RequestParam(value = "limit", required = false) String limit) {
        return new ResponseDTO(Boolean.TRUE, supplierDetailFacade.searchSupplierDetail(id, location,
                natureOfBusiness, manufacturingProcess, limit), "Supplier Detail saved successfully");
    }
}
