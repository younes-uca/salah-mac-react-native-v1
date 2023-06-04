package  ma.sir.ecom.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.ecom.bean.core.PurchasePaymentStatus;
import ma.sir.ecom.bean.history.PurchasePaymentStatusHistory;
import ma.sir.ecom.dao.criteria.core.PurchasePaymentStatusCriteria;
import ma.sir.ecom.dao.criteria.history.PurchasePaymentStatusHistoryCriteria;
import ma.sir.ecom.service.facade.admin.PurchasePaymentStatusAdminService;
import ma.sir.ecom.ws.converter.PurchasePaymentStatusConverter;
import ma.sir.ecom.ws.dto.PurchasePaymentStatusDto;
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

@Api("Manages purchasePaymentStatus services")
@RestController
@RequestMapping("/api/admin/purchasePaymentStatus/")
public class PurchasePaymentStatusRestAdmin  extends AbstractController<PurchasePaymentStatus, PurchasePaymentStatusDto, PurchasePaymentStatusHistory, PurchasePaymentStatusCriteria, PurchasePaymentStatusHistoryCriteria, PurchasePaymentStatusAdminService, PurchasePaymentStatusConverter> {



    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody PurchasePaymentStatusDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one purchasePaymentStatus")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple purchasePaymentStatuss")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all purchasePaymentStatuss")
    @GetMapping("")
    public ResponseEntity<List<PurchasePaymentStatusDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all purchasePaymentStatuss")
    @GetMapping("optimized")
    public ResponseEntity<List<PurchasePaymentStatusDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a purchasePaymentStatus by id")
    @GetMapping("id/{id}")
    public ResponseEntity<PurchasePaymentStatusDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  purchasePaymentStatus")
    @PostMapping("")
    public ResponseEntity<PurchasePaymentStatusDto> save(@RequestBody PurchasePaymentStatusDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  purchasePaymentStatus")
    @PutMapping("")
    public ResponseEntity<PurchasePaymentStatusDto> update(@RequestBody PurchasePaymentStatusDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of purchasePaymentStatus")
    @PostMapping("multiple")
    public ResponseEntity<List<PurchasePaymentStatusDto>> delete(@RequestBody List<PurchasePaymentStatusDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified purchasePaymentStatus")
    @DeleteMapping("")
    public ResponseEntity<PurchasePaymentStatusDto> delete(@RequestBody PurchasePaymentStatusDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified purchasePaymentStatus")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple purchasePaymentStatuss by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("Finds purchasePaymentStatuss by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<PurchasePaymentStatusDto>> findByCriteria(@RequestBody PurchasePaymentStatusCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated purchasePaymentStatuss by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody PurchasePaymentStatusCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports purchasePaymentStatuss by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody PurchasePaymentStatusCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets purchasePaymentStatus data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody PurchasePaymentStatusCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets purchasePaymentStatus history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets purchasePaymentStatus paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody PurchasePaymentStatusHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports purchasePaymentStatus history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody PurchasePaymentStatusHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets purchasePaymentStatus history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody PurchasePaymentStatusHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public PurchasePaymentStatusRestAdmin (PurchasePaymentStatusAdminService service, PurchasePaymentStatusConverter converter) {
        super(service, converter);
    }


}