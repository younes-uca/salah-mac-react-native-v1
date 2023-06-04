package  ma.sir.ecom.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.ecom.bean.core.Supplier;
import ma.sir.ecom.bean.history.SupplierHistory;
import ma.sir.ecom.dao.criteria.core.SupplierCriteria;
import ma.sir.ecom.dao.criteria.history.SupplierHistoryCriteria;
import ma.sir.ecom.service.facade.admin.SupplierAdminService;
import ma.sir.ecom.ws.converter.SupplierConverter;
import ma.sir.ecom.ws.dto.SupplierDto;
import ma.sir.ecom.zynerator.controller.AbstractController;
import ma.sir.ecom.zynerator.dto.AuditEntityDto;
import ma.sir.ecom.zynerator.util.PaginatedList;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import ma.sir.ecom.zynerator.process.Result;

import org.springframework.http.HttpEntity;

import org.springframework.web.multipart.MultipartFile;
import ma.sir.ecom.zynerator.dto.FileTempDto;

@Api("Manages supplier services")
@RestController
@RequestMapping("/api/admin/supplier/")
public class SupplierRestAdmin  extends AbstractController<Supplier, SupplierDto, SupplierHistory, SupplierCriteria, SupplierHistoryCriteria, SupplierAdminService, SupplierConverter> {



    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody SupplierDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one supplier")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple suppliers")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all suppliers")
    @GetMapping("")
    public ResponseEntity<List<SupplierDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all suppliers")
    @GetMapping("optimized")
    public ResponseEntity<List<SupplierDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a supplier by id")
    @GetMapping("id/{id}")
    public ResponseEntity<SupplierDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  supplier")
    @PostMapping("")
    public ResponseEntity<SupplierDto> save(@RequestBody SupplierDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  supplier")
    @PutMapping("")
    public ResponseEntity<SupplierDto> update(@RequestBody SupplierDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of supplier")
    @PostMapping("multiple")
    public ResponseEntity<List<SupplierDto>> delete(@RequestBody List<SupplierDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified supplier")
    @DeleteMapping("")
    public ResponseEntity<SupplierDto> delete(@RequestBody SupplierDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified supplier")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple suppliers by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("Finds suppliers by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<SupplierDto>> findByCriteria(@RequestBody SupplierCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated suppliers by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody SupplierCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports suppliers by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody SupplierCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets supplier data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody SupplierCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets supplier history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets supplier paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody SupplierHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports supplier history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody SupplierHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets supplier history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody SupplierHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public SupplierRestAdmin (SupplierAdminService service, SupplierConverter converter) {
        super(service, converter);
    }


}