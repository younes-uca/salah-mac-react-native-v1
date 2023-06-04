package  ma.sir.ecom.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.ecom.bean.core.AccountingAccount;
import ma.sir.ecom.bean.history.AccountingAccountHistory;
import ma.sir.ecom.dao.criteria.core.AccountingAccountCriteria;
import ma.sir.ecom.dao.criteria.history.AccountingAccountHistoryCriteria;
import ma.sir.ecom.service.facade.admin.AccountingAccountAdminService;
import ma.sir.ecom.ws.converter.AccountingAccountConverter;
import ma.sir.ecom.ws.dto.AccountingAccountDto;
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

@Api("Manages accountingAccount services")
@RestController
@RequestMapping("/api/admin/accountingAccount/")
public class AccountingAccountRestAdmin  extends AbstractController<AccountingAccount, AccountingAccountDto, AccountingAccountHistory, AccountingAccountCriteria, AccountingAccountHistoryCriteria, AccountingAccountAdminService, AccountingAccountConverter> {



    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody AccountingAccountDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one accountingAccount")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple accountingAccounts")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all accountingAccounts")
    @GetMapping("")
    public ResponseEntity<List<AccountingAccountDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all accountingAccounts")
    @GetMapping("optimized")
    public ResponseEntity<List<AccountingAccountDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a accountingAccount by id")
    @GetMapping("id/{id}")
    public ResponseEntity<AccountingAccountDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  accountingAccount")
    @PostMapping("")
    public ResponseEntity<AccountingAccountDto> save(@RequestBody AccountingAccountDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  accountingAccount")
    @PutMapping("")
    public ResponseEntity<AccountingAccountDto> update(@RequestBody AccountingAccountDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of accountingAccount")
    @PostMapping("multiple")
    public ResponseEntity<List<AccountingAccountDto>> delete(@RequestBody List<AccountingAccountDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified accountingAccount")
    @DeleteMapping("")
    public ResponseEntity<AccountingAccountDto> delete(@RequestBody AccountingAccountDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified accountingAccount")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple accountingAccounts by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("find by subAccountingClass id")
    @GetMapping("subAccountingClass/id/{id}")
    public List<AccountingAccount> findBySubAccountingClassId(@PathVariable Long id){
        return service.findBySubAccountingClassId(id);
    }
    @ApiOperation("delete by subAccountingClass id")
    @DeleteMapping("subAccountingClass/id/{id}")
    public int deleteBySubAccountingClassId(@PathVariable Long id){
        return service.deleteBySubAccountingClassId(id);
    }
    @ApiOperation("Finds accountingAccounts by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<AccountingAccountDto>> findByCriteria(@RequestBody AccountingAccountCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated accountingAccounts by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody AccountingAccountCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports accountingAccounts by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody AccountingAccountCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets accountingAccount data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody AccountingAccountCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets accountingAccount history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets accountingAccount paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody AccountingAccountHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports accountingAccount history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody AccountingAccountHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets accountingAccount history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody AccountingAccountHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public AccountingAccountRestAdmin (AccountingAccountAdminService service, AccountingAccountConverter converter) {
        super(service, converter);
    }


}