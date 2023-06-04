package  ma.sir.ecom.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.ecom.bean.core.CreditNotePurchaseStatus;
import ma.sir.ecom.bean.history.CreditNotePurchaseStatusHistory;
import ma.sir.ecom.dao.criteria.core.CreditNotePurchaseStatusCriteria;
import ma.sir.ecom.dao.criteria.history.CreditNotePurchaseStatusHistoryCriteria;
import ma.sir.ecom.service.facade.admin.CreditNotePurchaseStatusAdminService;
import ma.sir.ecom.ws.converter.CreditNotePurchaseStatusConverter;
import ma.sir.ecom.ws.dto.CreditNotePurchaseStatusDto;
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

@Api("Manages creditNotePurchaseStatus services")
@RestController
@RequestMapping("/api/admin/creditNotePurchaseStatus/")
public class CreditNotePurchaseStatusRestAdmin  extends AbstractController<CreditNotePurchaseStatus, CreditNotePurchaseStatusDto, CreditNotePurchaseStatusHistory, CreditNotePurchaseStatusCriteria, CreditNotePurchaseStatusHistoryCriteria, CreditNotePurchaseStatusAdminService, CreditNotePurchaseStatusConverter> {



    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody CreditNotePurchaseStatusDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one creditNotePurchaseStatus")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple creditNotePurchaseStatuss")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all creditNotePurchaseStatuss")
    @GetMapping("")
    public ResponseEntity<List<CreditNotePurchaseStatusDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all creditNotePurchaseStatuss")
    @GetMapping("optimized")
    public ResponseEntity<List<CreditNotePurchaseStatusDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a creditNotePurchaseStatus by id")
    @GetMapping("id/{id}")
    public ResponseEntity<CreditNotePurchaseStatusDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  creditNotePurchaseStatus")
    @PostMapping("")
    public ResponseEntity<CreditNotePurchaseStatusDto> save(@RequestBody CreditNotePurchaseStatusDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  creditNotePurchaseStatus")
    @PutMapping("")
    public ResponseEntity<CreditNotePurchaseStatusDto> update(@RequestBody CreditNotePurchaseStatusDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of creditNotePurchaseStatus")
    @PostMapping("multiple")
    public ResponseEntity<List<CreditNotePurchaseStatusDto>> delete(@RequestBody List<CreditNotePurchaseStatusDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified creditNotePurchaseStatus")
    @DeleteMapping("")
    public ResponseEntity<CreditNotePurchaseStatusDto> delete(@RequestBody CreditNotePurchaseStatusDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified creditNotePurchaseStatus")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple creditNotePurchaseStatuss by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("Finds creditNotePurchaseStatuss by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<CreditNotePurchaseStatusDto>> findByCriteria(@RequestBody CreditNotePurchaseStatusCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated creditNotePurchaseStatuss by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody CreditNotePurchaseStatusCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports creditNotePurchaseStatuss by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody CreditNotePurchaseStatusCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets creditNotePurchaseStatus data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody CreditNotePurchaseStatusCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets creditNotePurchaseStatus history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets creditNotePurchaseStatus paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody CreditNotePurchaseStatusHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports creditNotePurchaseStatus history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody CreditNotePurchaseStatusHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets creditNotePurchaseStatus history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody CreditNotePurchaseStatusHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public CreditNotePurchaseStatusRestAdmin (CreditNotePurchaseStatusAdminService service, CreditNotePurchaseStatusConverter converter) {
        super(service, converter);
    }


}