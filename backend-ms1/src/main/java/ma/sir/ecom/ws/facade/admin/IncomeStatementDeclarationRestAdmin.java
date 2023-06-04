package  ma.sir.ecom.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.ecom.bean.core.IncomeStatementDeclaration;
import ma.sir.ecom.bean.history.IncomeStatementDeclarationHistory;
import ma.sir.ecom.dao.criteria.core.IncomeStatementDeclarationCriteria;
import ma.sir.ecom.dao.criteria.history.IncomeStatementDeclarationHistoryCriteria;
import ma.sir.ecom.service.facade.admin.IncomeStatementDeclarationAdminService;
import ma.sir.ecom.ws.converter.IncomeStatementDeclarationConverter;
import ma.sir.ecom.ws.dto.IncomeStatementDeclarationDto;
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

@Api("Manages incomeStatementDeclaration services")
@RestController
@RequestMapping("/api/admin/incomeStatementDeclaration/")
public class IncomeStatementDeclarationRestAdmin  extends AbstractController<IncomeStatementDeclaration, IncomeStatementDeclarationDto, IncomeStatementDeclarationHistory, IncomeStatementDeclarationCriteria, IncomeStatementDeclarationHistoryCriteria, IncomeStatementDeclarationAdminService, IncomeStatementDeclarationConverter> {



    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody IncomeStatementDeclarationDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one incomeStatementDeclaration")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple incomeStatementDeclarations")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all incomeStatementDeclarations")
    @GetMapping("")
    public ResponseEntity<List<IncomeStatementDeclarationDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all incomeStatementDeclarations")
    @GetMapping("optimized")
    public ResponseEntity<List<IncomeStatementDeclarationDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a incomeStatementDeclaration by id")
    @GetMapping("id/{id}")
    public ResponseEntity<IncomeStatementDeclarationDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  incomeStatementDeclaration")
    @PostMapping("")
    public ResponseEntity<IncomeStatementDeclarationDto> save(@RequestBody IncomeStatementDeclarationDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  incomeStatementDeclaration")
    @PutMapping("")
    public ResponseEntity<IncomeStatementDeclarationDto> update(@RequestBody IncomeStatementDeclarationDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of incomeStatementDeclaration")
    @PostMapping("multiple")
    public ResponseEntity<List<IncomeStatementDeclarationDto>> delete(@RequestBody List<IncomeStatementDeclarationDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified incomeStatementDeclaration")
    @DeleteMapping("")
    public ResponseEntity<IncomeStatementDeclarationDto> delete(@RequestBody IncomeStatementDeclarationDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified incomeStatementDeclaration")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple incomeStatementDeclarations by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("find by company id")
    @GetMapping("company/id/{id}")
    public List<IncomeStatementDeclaration> findByCompanyId(@PathVariable Long id){
        return service.findByCompanyId(id);
    }
    @ApiOperation("delete by company id")
    @DeleteMapping("company/id/{id}")
    public int deleteByCompanyId(@PathVariable Long id){
        return service.deleteByCompanyId(id);
    }
    @ApiOperation("find by corporateTaxRate id")
    @GetMapping("corporateTaxRate/id/{id}")
    public List<IncomeStatementDeclaration> findByCorporateTaxRateId(@PathVariable Long id){
        return service.findByCorporateTaxRateId(id);
    }
    @ApiOperation("delete by corporateTaxRate id")
    @DeleteMapping("corporateTaxRate/id/{id}")
    public int deleteByCorporateTaxRateId(@PathVariable Long id){
        return service.deleteByCorporateTaxRateId(id);
    }
    @ApiOperation("find by handlingAccountant id")
    @GetMapping("handlingAccountant/id/{id}")
    public List<IncomeStatementDeclaration> findByHandlingAccountantId(@PathVariable Long id){
        return service.findByHandlingAccountantId(id);
    }
    @ApiOperation("delete by handlingAccountant id")
    @DeleteMapping("handlingAccountant/id/{id}")
    public int deleteByHandlingAccountantId(@PathVariable Long id){
        return service.deleteByHandlingAccountantId(id);
    }
    @ApiOperation("find by validationAccountant id")
    @GetMapping("validationAccountant/id/{id}")
    public List<IncomeStatementDeclaration> findByValidationAccountantId(@PathVariable Long id){
        return service.findByValidationAccountantId(id);
    }
    @ApiOperation("delete by validationAccountant id")
    @DeleteMapping("validationAccountant/id/{id}")
    public int deleteByValidationAccountantId(@PathVariable Long id){
        return service.deleteByValidationAccountantId(id);
    }
    @ApiOperation("Finds incomeStatementDeclarations by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<IncomeStatementDeclarationDto>> findByCriteria(@RequestBody IncomeStatementDeclarationCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated incomeStatementDeclarations by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody IncomeStatementDeclarationCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports incomeStatementDeclarations by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody IncomeStatementDeclarationCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets incomeStatementDeclaration data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody IncomeStatementDeclarationCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets incomeStatementDeclaration history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets incomeStatementDeclaration paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody IncomeStatementDeclarationHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports incomeStatementDeclaration history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody IncomeStatementDeclarationHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets incomeStatementDeclaration history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody IncomeStatementDeclarationHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public IncomeStatementDeclarationRestAdmin (IncomeStatementDeclarationAdminService service, IncomeStatementDeclarationConverter converter) {
        super(service, converter);
    }


}