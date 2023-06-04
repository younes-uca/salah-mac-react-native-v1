package  ma.sir.ecom.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.ecom.bean.core.PaymentStatus;
import ma.sir.ecom.bean.history.PaymentStatusHistory;
import ma.sir.ecom.dao.criteria.core.PaymentStatusCriteria;
import ma.sir.ecom.dao.criteria.history.PaymentStatusHistoryCriteria;
import ma.sir.ecom.service.facade.admin.PaymentStatusAdminService;
import ma.sir.ecom.ws.converter.PaymentStatusConverter;
import ma.sir.ecom.ws.dto.PaymentStatusDto;
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

@Api("Manages paymentStatus services")
@RestController
@RequestMapping("/api/admin/paymentStatus/")
public class PaymentStatusRestAdmin  extends AbstractController<PaymentStatus, PaymentStatusDto, PaymentStatusHistory, PaymentStatusCriteria, PaymentStatusHistoryCriteria, PaymentStatusAdminService, PaymentStatusConverter> {



    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody PaymentStatusDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one paymentStatus")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple paymentStatuss")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all paymentStatuss")
    @GetMapping("")
    public ResponseEntity<List<PaymentStatusDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all paymentStatuss")
    @GetMapping("optimized")
    public ResponseEntity<List<PaymentStatusDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a paymentStatus by id")
    @GetMapping("id/{id}")
    public ResponseEntity<PaymentStatusDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  paymentStatus")
    @PostMapping("")
    public ResponseEntity<PaymentStatusDto> save(@RequestBody PaymentStatusDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  paymentStatus")
    @PutMapping("")
    public ResponseEntity<PaymentStatusDto> update(@RequestBody PaymentStatusDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of paymentStatus")
    @PostMapping("multiple")
    public ResponseEntity<List<PaymentStatusDto>> delete(@RequestBody List<PaymentStatusDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified paymentStatus")
    @DeleteMapping("")
    public ResponseEntity<PaymentStatusDto> delete(@RequestBody PaymentStatusDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified paymentStatus")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple paymentStatuss by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("Finds paymentStatuss by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<PaymentStatusDto>> findByCriteria(@RequestBody PaymentStatusCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated paymentStatuss by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody PaymentStatusCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports paymentStatuss by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody PaymentStatusCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets paymentStatus data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody PaymentStatusCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets paymentStatus history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets paymentStatus paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody PaymentStatusHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports paymentStatus history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody PaymentStatusHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets paymentStatus history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody PaymentStatusHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public PaymentStatusRestAdmin (PaymentStatusAdminService service, PaymentStatusConverter converter) {
        super(service, converter);
    }


}