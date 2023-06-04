package  ma.sir.ecom.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.ecom.bean.core.BalanceSheet;
import ma.sir.ecom.bean.history.BalanceSheetHistory;
import ma.sir.ecom.dao.criteria.core.BalanceSheetCriteria;
import ma.sir.ecom.dao.criteria.history.BalanceSheetHistoryCriteria;
import ma.sir.ecom.service.facade.admin.BalanceSheetAdminService;
import ma.sir.ecom.ws.converter.BalanceSheetConverter;
import ma.sir.ecom.ws.dto.BalanceSheetDto;
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

@Api("Manages balanceSheet services")
@RestController
@RequestMapping("/api/admin/balanceSheet/")
public class BalanceSheetRestAdmin  extends AbstractController<BalanceSheet, BalanceSheetDto, BalanceSheetHistory, BalanceSheetCriteria, BalanceSheetHistoryCriteria, BalanceSheetAdminService, BalanceSheetConverter> {


    @ApiOperation("Import excel")
    @PostMapping("import-excel")
    public ResponseEntity<List<BalanceSheet>> importExcel(@RequestParam("file") MultipartFile file){
        return super.importExcel(file);
    }

    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody BalanceSheetDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one balanceSheet")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple balanceSheets")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all balanceSheets")
    @GetMapping("")
    public ResponseEntity<List<BalanceSheetDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all balanceSheets")
    @GetMapping("optimized")
    public ResponseEntity<List<BalanceSheetDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a balanceSheet by id")
    @GetMapping("id/{id}")
    public ResponseEntity<BalanceSheetDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  balanceSheet")
    @PostMapping("")
    public ResponseEntity<BalanceSheetDto> save(@RequestBody BalanceSheetDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  balanceSheet")
    @PutMapping("")
    public ResponseEntity<BalanceSheetDto> update(@RequestBody BalanceSheetDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of balanceSheet")
    @PostMapping("multiple")
    public ResponseEntity<List<BalanceSheetDto>> delete(@RequestBody List<BalanceSheetDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified balanceSheet")
    @DeleteMapping("")
    public ResponseEntity<BalanceSheetDto> delete(@RequestBody BalanceSheetDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified balanceSheet")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple balanceSheets by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("find by company id")
    @GetMapping("company/id/{id}")
    public List<BalanceSheet> findByCompanyId(@PathVariable Long id){
        return service.findByCompanyId(id);
    }
    @ApiOperation("delete by company id")
    @DeleteMapping("company/id/{id}")
    public int deleteByCompanyId(@PathVariable Long id){
        return service.deleteByCompanyId(id);
    }
    @ApiOperation("find by balanceSheetStatus id")
    @GetMapping("balanceSheetStatus/id/{id}")
    public List<BalanceSheet> findByBalanceSheetStatusId(@PathVariable Long id){
        return service.findByBalanceSheetStatusId(id);
    }
    @ApiOperation("delete by balanceSheetStatus id")
    @DeleteMapping("balanceSheetStatus/id/{id}")
    public int deleteByBalanceSheetStatusId(@PathVariable Long id){
        return service.deleteByBalanceSheetStatusId(id);
    }
    @ApiOperation("Finds balanceSheets by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<BalanceSheetDto>> findByCriteria(@RequestBody BalanceSheetCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated balanceSheets by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody BalanceSheetCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports balanceSheets by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody BalanceSheetCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets balanceSheet data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody BalanceSheetCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets balanceSheet history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets balanceSheet paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody BalanceSheetHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports balanceSheet history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody BalanceSheetHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets balanceSheet history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody BalanceSheetHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public BalanceSheetRestAdmin (BalanceSheetAdminService service, BalanceSheetConverter converter) {
        super(service, converter);
    }


}