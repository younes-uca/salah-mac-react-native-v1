package  ma.sir.ecom.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.ecom.bean.core.AccountingOperationStatus;
import ma.sir.ecom.bean.history.AccountingOperationStatusHistory;
import ma.sir.ecom.dao.criteria.core.AccountingOperationStatusCriteria;
import ma.sir.ecom.dao.criteria.history.AccountingOperationStatusHistoryCriteria;
import ma.sir.ecom.service.facade.admin.AccountingOperationStatusAdminService;
import ma.sir.ecom.ws.converter.AccountingOperationStatusConverter;
import ma.sir.ecom.ws.dto.AccountingOperationStatusDto;
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

@Api("Manages accountingOperationStatus services")
@RestController
@RequestMapping("/api/admin/accountingOperationStatus/")
public class AccountingOperationStatusRestAdmin  extends AbstractController<AccountingOperationStatus, AccountingOperationStatusDto, AccountingOperationStatusHistory, AccountingOperationStatusCriteria, AccountingOperationStatusHistoryCriteria, AccountingOperationStatusAdminService, AccountingOperationStatusConverter> {



    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody AccountingOperationStatusDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one accountingOperationStatus")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple accountingOperationStatuss")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all accountingOperationStatuss")
    @GetMapping("")
    public ResponseEntity<List<AccountingOperationStatusDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all accountingOperationStatuss")
    @GetMapping("optimized")
    public ResponseEntity<List<AccountingOperationStatusDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a accountingOperationStatus by id")
    @GetMapping("id/{id}")
    public ResponseEntity<AccountingOperationStatusDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  accountingOperationStatus")
    @PostMapping("")
    public ResponseEntity<AccountingOperationStatusDto> save(@RequestBody AccountingOperationStatusDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  accountingOperationStatus")
    @PutMapping("")
    public ResponseEntity<AccountingOperationStatusDto> update(@RequestBody AccountingOperationStatusDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of accountingOperationStatus")
    @PostMapping("multiple")
    public ResponseEntity<List<AccountingOperationStatusDto>> delete(@RequestBody List<AccountingOperationStatusDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified accountingOperationStatus")
    @DeleteMapping("")
    public ResponseEntity<AccountingOperationStatusDto> delete(@RequestBody AccountingOperationStatusDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified accountingOperationStatus")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple accountingOperationStatuss by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("Finds accountingOperationStatuss by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<AccountingOperationStatusDto>> findByCriteria(@RequestBody AccountingOperationStatusCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated accountingOperationStatuss by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody AccountingOperationStatusCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports accountingOperationStatuss by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody AccountingOperationStatusCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets accountingOperationStatus data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody AccountingOperationStatusCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets accountingOperationStatus history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets accountingOperationStatus paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody AccountingOperationStatusHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports accountingOperationStatus history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody AccountingOperationStatusHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets accountingOperationStatus history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody AccountingOperationStatusHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public AccountingOperationStatusRestAdmin (AccountingOperationStatusAdminService service, AccountingOperationStatusConverter converter) {
        super(service, converter);
    }


}