package  ma.sir.ecom.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.ecom.bean.core.AccountingOperation;
import ma.sir.ecom.bean.history.AccountingOperationHistory;
import ma.sir.ecom.dao.criteria.core.AccountingOperationCriteria;
import ma.sir.ecom.dao.criteria.history.AccountingOperationHistoryCriteria;
import ma.sir.ecom.service.facade.admin.AccountingOperationAdminService;
import ma.sir.ecom.ws.converter.AccountingOperationConverter;
import ma.sir.ecom.ws.dto.AccountingOperationDto;
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

@Api("Manages accountingOperation services")
@RestController
@RequestMapping("/api/admin/accountingOperation/")
public class AccountingOperationRestAdmin  extends AbstractController<AccountingOperation, AccountingOperationDto, AccountingOperationHistory, AccountingOperationCriteria, AccountingOperationHistoryCriteria, AccountingOperationAdminService, AccountingOperationConverter> {


    @ApiOperation("Import excel")
    @PostMapping("import-excel")
    public ResponseEntity<List<AccountingOperation>> importExcel(@RequestParam("file") MultipartFile file){
        return super.importExcel(file);
    }

    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody AccountingOperationDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one accountingOperation")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple accountingOperations")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all accountingOperations")
    @GetMapping("")
    public ResponseEntity<List<AccountingOperationDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all accountingOperations")
    @GetMapping("optimized")
    public ResponseEntity<List<AccountingOperationDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a accountingOperation by id")
    @GetMapping("id/{id}")
    public ResponseEntity<AccountingOperationDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  accountingOperation")
    @PostMapping("")
    public ResponseEntity<AccountingOperationDto> save(@RequestBody AccountingOperationDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  accountingOperation")
    @PutMapping("")
    public ResponseEntity<AccountingOperationDto> update(@RequestBody AccountingOperationDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of accountingOperation")
    @PostMapping("multiple")
    public ResponseEntity<List<AccountingOperationDto>> delete(@RequestBody List<AccountingOperationDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified accountingOperation")
    @DeleteMapping("")
    public ResponseEntity<AccountingOperationDto> delete(@RequestBody AccountingOperationDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified accountingOperation")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple accountingOperations by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("find by company id")
    @GetMapping("company/id/{id}")
    public List<AccountingOperation> findByCompanyId(@PathVariable Long id){
        return service.findByCompanyId(id);
    }
    @ApiOperation("delete by company id")
    @DeleteMapping("company/id/{id}")
    public int deleteByCompanyId(@PathVariable Long id){
        return service.deleteByCompanyId(id);
    }
    @ApiOperation("find by accountingAccount id")
    @GetMapping("accountingAccount/id/{id}")
    public List<AccountingOperation> findByAccountingAccountId(@PathVariable Long id){
        return service.findByAccountingAccountId(id);
    }
    @ApiOperation("delete by accountingAccount id")
    @DeleteMapping("accountingAccount/id/{id}")
    public int deleteByAccountingAccountId(@PathVariable Long id){
        return service.deleteByAccountingAccountId(id);
    }
    @ApiOperation("find by accountingOperationType id")
    @GetMapping("accountingOperationType/id/{id}")
    public List<AccountingOperation> findByAccountingOperationTypeId(@PathVariable Long id){
        return service.findByAccountingOperationTypeId(id);
    }
    @ApiOperation("delete by accountingOperationType id")
    @DeleteMapping("accountingOperationType/id/{id}")
    public int deleteByAccountingOperationTypeId(@PathVariable Long id){
        return service.deleteByAccountingOperationTypeId(id);
    }
    @ApiOperation("find by accountingOperationStatus id")
    @GetMapping("accountingOperationStatus/id/{id}")
    public List<AccountingOperation> findByAccountingOperationStatusId(@PathVariable Long id){
        return service.findByAccountingOperationStatusId(id);
    }
    @ApiOperation("delete by accountingOperationStatus id")
    @DeleteMapping("accountingOperationStatus/id/{id}")
    public int deleteByAccountingOperationStatusId(@PathVariable Long id){
        return service.deleteByAccountingOperationStatusId(id);
    }
    @ApiOperation("Finds accountingOperations by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<AccountingOperationDto>> findByCriteria(@RequestBody AccountingOperationCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated accountingOperations by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody AccountingOperationCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports accountingOperations by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody AccountingOperationCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets accountingOperation data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody AccountingOperationCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets accountingOperation history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets accountingOperation paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody AccountingOperationHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports accountingOperation history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody AccountingOperationHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets accountingOperation history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody AccountingOperationHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public AccountingOperationRestAdmin (AccountingOperationAdminService service, AccountingOperationConverter converter) {
        super(service, converter);
    }


}