package  ma.sir.ecom.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.ecom.bean.core.ValidationAccountant;
import ma.sir.ecom.bean.history.ValidationAccountantHistory;
import ma.sir.ecom.dao.criteria.core.ValidationAccountantCriteria;
import ma.sir.ecom.dao.criteria.history.ValidationAccountantHistoryCriteria;
import ma.sir.ecom.service.facade.admin.ValidationAccountantAdminService;
import ma.sir.ecom.ws.converter.ValidationAccountantConverter;
import ma.sir.ecom.ws.dto.ValidationAccountantDto;
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

@Api("Manages validationAccountant services")
@RestController
@RequestMapping("/api/admin/validationAccountant/")
public class ValidationAccountantRestAdmin  extends AbstractController<ValidationAccountant, ValidationAccountantDto, ValidationAccountantHistory, ValidationAccountantCriteria, ValidationAccountantHistoryCriteria, ValidationAccountantAdminService, ValidationAccountantConverter> {



    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody ValidationAccountantDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one validationAccountant")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple validationAccountants")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all validationAccountants")
    @GetMapping("")
    public ResponseEntity<List<ValidationAccountantDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all validationAccountants")
    @GetMapping("optimized")
    public ResponseEntity<List<ValidationAccountantDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a validationAccountant by id")
    @GetMapping("id/{id}")
    public ResponseEntity<ValidationAccountantDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  validationAccountant")
    @PostMapping("")
    public ResponseEntity<ValidationAccountantDto> save(@RequestBody ValidationAccountantDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  validationAccountant")
    @PutMapping("")
    public ResponseEntity<ValidationAccountantDto> update(@RequestBody ValidationAccountantDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of validationAccountant")
    @PostMapping("multiple")
    public ResponseEntity<List<ValidationAccountantDto>> delete(@RequestBody List<ValidationAccountantDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified validationAccountant")
    @DeleteMapping("")
    public ResponseEntity<ValidationAccountantDto> delete(@RequestBody ValidationAccountantDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified validationAccountant")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple validationAccountants by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("Finds validationAccountants by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<ValidationAccountantDto>> findByCriteria(@RequestBody ValidationAccountantCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated validationAccountants by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody ValidationAccountantCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports validationAccountants by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody ValidationAccountantCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets validationAccountant data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody ValidationAccountantCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets validationAccountant history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets validationAccountant paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody ValidationAccountantHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports validationAccountant history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody ValidationAccountantHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets validationAccountant history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody ValidationAccountantHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public ValidationAccountantRestAdmin (ValidationAccountantAdminService service, ValidationAccountantConverter converter) {
        super(service, converter);
    }


}