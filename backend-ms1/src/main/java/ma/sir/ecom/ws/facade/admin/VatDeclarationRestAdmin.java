package  ma.sir.ecom.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.ecom.bean.core.VatDeclaration;
import ma.sir.ecom.bean.history.VatDeclarationHistory;
import ma.sir.ecom.dao.criteria.core.VatDeclarationCriteria;
import ma.sir.ecom.dao.criteria.history.VatDeclarationHistoryCriteria;
import ma.sir.ecom.service.facade.admin.VatDeclarationAdminService;
import ma.sir.ecom.ws.converter.VatDeclarationConverter;
import ma.sir.ecom.ws.dto.VatDeclarationDto;
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

@Api("Manages vatDeclaration services")
@RestController
@RequestMapping("/api/admin/vatDeclaration/")
public class VatDeclarationRestAdmin  extends AbstractController<VatDeclaration, VatDeclarationDto, VatDeclarationHistory, VatDeclarationCriteria, VatDeclarationHistoryCriteria, VatDeclarationAdminService, VatDeclarationConverter> {



    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody VatDeclarationDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one vatDeclaration")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple vatDeclarations")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all vatDeclarations")
    @GetMapping("")
    public ResponseEntity<List<VatDeclarationDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all vatDeclarations")
    @GetMapping("optimized")
    public ResponseEntity<List<VatDeclarationDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a vatDeclaration by id")
    @GetMapping("id/{id}")
    public ResponseEntity<VatDeclarationDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  vatDeclaration")
    @PostMapping("")
    public ResponseEntity<VatDeclarationDto> save(@RequestBody VatDeclarationDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  vatDeclaration")
    @PutMapping("")
    public ResponseEntity<VatDeclarationDto> update(@RequestBody VatDeclarationDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of vatDeclaration")
    @PostMapping("multiple")
    public ResponseEntity<List<VatDeclarationDto>> delete(@RequestBody List<VatDeclarationDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified vatDeclaration")
    @DeleteMapping("")
    public ResponseEntity<VatDeclarationDto> delete(@RequestBody VatDeclarationDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified vatDeclaration")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple vatDeclarations by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("find by company id")
    @GetMapping("company/id/{id}")
    public List<VatDeclaration> findByCompanyId(@PathVariable Long id){
        return service.findByCompanyId(id);
    }
    @ApiOperation("delete by company id")
    @DeleteMapping("company/id/{id}")
    public int deleteByCompanyId(@PathVariable Long id){
        return service.deleteByCompanyId(id);
    }
    @ApiOperation("find by latePaymentRate id")
    @GetMapping("latePaymentRate/id/{id}")
    public List<VatDeclaration> findByLatePaymentRateId(@PathVariable Long id){
        return service.findByLatePaymentRateId(id);
    }
    @ApiOperation("delete by latePaymentRate id")
    @DeleteMapping("latePaymentRate/id/{id}")
    public int deleteByLatePaymentRateId(@PathVariable Long id){
        return service.deleteByLatePaymentRateId(id);
    }
    @ApiOperation("find by handlingAccountant id")
    @GetMapping("handlingAccountant/id/{id}")
    public List<VatDeclaration> findByHandlingAccountantId(@PathVariable Long id){
        return service.findByHandlingAccountantId(id);
    }
    @ApiOperation("delete by handlingAccountant id")
    @DeleteMapping("handlingAccountant/id/{id}")
    public int deleteByHandlingAccountantId(@PathVariable Long id){
        return service.deleteByHandlingAccountantId(id);
    }
    @ApiOperation("find by validationAccountant id")
    @GetMapping("validationAccountant/id/{id}")
    public List<VatDeclaration> findByValidationAccountantId(@PathVariable Long id){
        return service.findByValidationAccountantId(id);
    }
    @ApiOperation("delete by validationAccountant id")
    @DeleteMapping("validationAccountant/id/{id}")
    public int deleteByValidationAccountantId(@PathVariable Long id){
        return service.deleteByValidationAccountantId(id);
    }
    @ApiOperation("Finds vatDeclarations by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<VatDeclarationDto>> findByCriteria(@RequestBody VatDeclarationCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated vatDeclarations by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody VatDeclarationCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports vatDeclarations by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody VatDeclarationCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets vatDeclaration data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody VatDeclarationCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets vatDeclaration history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets vatDeclaration paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody VatDeclarationHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports vatDeclaration history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody VatDeclarationHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets vatDeclaration history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody VatDeclarationHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public VatDeclarationRestAdmin (VatDeclarationAdminService service, VatDeclarationConverter converter) {
        super(service, converter);
    }


}