package  ma.sir.ecom.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.ecom.bean.core.BalanceSheetStatus;
import ma.sir.ecom.bean.history.BalanceSheetStatusHistory;
import ma.sir.ecom.dao.criteria.core.BalanceSheetStatusCriteria;
import ma.sir.ecom.dao.criteria.history.BalanceSheetStatusHistoryCriteria;
import ma.sir.ecom.service.facade.admin.BalanceSheetStatusAdminService;
import ma.sir.ecom.ws.converter.BalanceSheetStatusConverter;
import ma.sir.ecom.ws.dto.BalanceSheetStatusDto;
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

@Api("Manages balanceSheetStatus services")
@RestController
@RequestMapping("/api/admin/balanceSheetStatus/")
public class BalanceSheetStatusRestAdmin  extends AbstractController<BalanceSheetStatus, BalanceSheetStatusDto, BalanceSheetStatusHistory, BalanceSheetStatusCriteria, BalanceSheetStatusHistoryCriteria, BalanceSheetStatusAdminService, BalanceSheetStatusConverter> {



    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody BalanceSheetStatusDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one balanceSheetStatus")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple balanceSheetStatuss")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all balanceSheetStatuss")
    @GetMapping("")
    public ResponseEntity<List<BalanceSheetStatusDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all balanceSheetStatuss")
    @GetMapping("optimized")
    public ResponseEntity<List<BalanceSheetStatusDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a balanceSheetStatus by id")
    @GetMapping("id/{id}")
    public ResponseEntity<BalanceSheetStatusDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  balanceSheetStatus")
    @PostMapping("")
    public ResponseEntity<BalanceSheetStatusDto> save(@RequestBody BalanceSheetStatusDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  balanceSheetStatus")
    @PutMapping("")
    public ResponseEntity<BalanceSheetStatusDto> update(@RequestBody BalanceSheetStatusDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of balanceSheetStatus")
    @PostMapping("multiple")
    public ResponseEntity<List<BalanceSheetStatusDto>> delete(@RequestBody List<BalanceSheetStatusDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified balanceSheetStatus")
    @DeleteMapping("")
    public ResponseEntity<BalanceSheetStatusDto> delete(@RequestBody BalanceSheetStatusDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified balanceSheetStatus")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple balanceSheetStatuss by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("Finds balanceSheetStatuss by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<BalanceSheetStatusDto>> findByCriteria(@RequestBody BalanceSheetStatusCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated balanceSheetStatuss by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody BalanceSheetStatusCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports balanceSheetStatuss by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody BalanceSheetStatusCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets balanceSheetStatus data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody BalanceSheetStatusCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets balanceSheetStatus history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets balanceSheetStatus paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody BalanceSheetStatusHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports balanceSheetStatus history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody BalanceSheetStatusHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets balanceSheetStatus history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody BalanceSheetStatusHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public BalanceSheetStatusRestAdmin (BalanceSheetStatusAdminService service, BalanceSheetStatusConverter converter) {
        super(service, converter);
    }


}