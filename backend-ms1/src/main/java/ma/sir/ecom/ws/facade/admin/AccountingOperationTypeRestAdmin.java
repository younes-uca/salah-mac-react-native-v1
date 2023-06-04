package  ma.sir.ecom.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.ecom.bean.core.AccountingOperationType;
import ma.sir.ecom.bean.history.AccountingOperationTypeHistory;
import ma.sir.ecom.dao.criteria.core.AccountingOperationTypeCriteria;
import ma.sir.ecom.dao.criteria.history.AccountingOperationTypeHistoryCriteria;
import ma.sir.ecom.service.facade.admin.AccountingOperationTypeAdminService;
import ma.sir.ecom.ws.converter.AccountingOperationTypeConverter;
import ma.sir.ecom.ws.dto.AccountingOperationTypeDto;
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

@Api("Manages accountingOperationType services")
@RestController
@RequestMapping("/api/admin/accountingOperationType/")
public class AccountingOperationTypeRestAdmin  extends AbstractController<AccountingOperationType, AccountingOperationTypeDto, AccountingOperationTypeHistory, AccountingOperationTypeCriteria, AccountingOperationTypeHistoryCriteria, AccountingOperationTypeAdminService, AccountingOperationTypeConverter> {



    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody AccountingOperationTypeDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one accountingOperationType")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple accountingOperationTypes")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all accountingOperationTypes")
    @GetMapping("")
    public ResponseEntity<List<AccountingOperationTypeDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all accountingOperationTypes")
    @GetMapping("optimized")
    public ResponseEntity<List<AccountingOperationTypeDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a accountingOperationType by id")
    @GetMapping("id/{id}")
    public ResponseEntity<AccountingOperationTypeDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  accountingOperationType")
    @PostMapping("")
    public ResponseEntity<AccountingOperationTypeDto> save(@RequestBody AccountingOperationTypeDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  accountingOperationType")
    @PutMapping("")
    public ResponseEntity<AccountingOperationTypeDto> update(@RequestBody AccountingOperationTypeDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of accountingOperationType")
    @PostMapping("multiple")
    public ResponseEntity<List<AccountingOperationTypeDto>> delete(@RequestBody List<AccountingOperationTypeDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified accountingOperationType")
    @DeleteMapping("")
    public ResponseEntity<AccountingOperationTypeDto> delete(@RequestBody AccountingOperationTypeDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified accountingOperationType")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple accountingOperationTypes by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("Finds accountingOperationTypes by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<AccountingOperationTypeDto>> findByCriteria(@RequestBody AccountingOperationTypeCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated accountingOperationTypes by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody AccountingOperationTypeCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports accountingOperationTypes by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody AccountingOperationTypeCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets accountingOperationType data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody AccountingOperationTypeCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets accountingOperationType history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets accountingOperationType paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody AccountingOperationTypeHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports accountingOperationType history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody AccountingOperationTypeHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets accountingOperationType history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody AccountingOperationTypeHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public AccountingOperationTypeRestAdmin (AccountingOperationTypeAdminService service, AccountingOperationTypeConverter converter) {
        super(service, converter);
    }


}