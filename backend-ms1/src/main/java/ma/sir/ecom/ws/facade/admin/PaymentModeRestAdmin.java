package  ma.sir.ecom.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.ecom.bean.core.PaymentMode;
import ma.sir.ecom.bean.history.PaymentModeHistory;
import ma.sir.ecom.dao.criteria.core.PaymentModeCriteria;
import ma.sir.ecom.dao.criteria.history.PaymentModeHistoryCriteria;
import ma.sir.ecom.service.facade.admin.PaymentModeAdminService;
import ma.sir.ecom.ws.converter.PaymentModeConverter;
import ma.sir.ecom.ws.dto.PaymentModeDto;
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

@Api("Manages paymentMode services")
@RestController
@RequestMapping("/api/admin/paymentMode/")
public class PaymentModeRestAdmin  extends AbstractController<PaymentMode, PaymentModeDto, PaymentModeHistory, PaymentModeCriteria, PaymentModeHistoryCriteria, PaymentModeAdminService, PaymentModeConverter> {



    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody PaymentModeDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one paymentMode")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple paymentModes")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all paymentModes")
    @GetMapping("")
    public ResponseEntity<List<PaymentModeDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all paymentModes")
    @GetMapping("optimized")
    public ResponseEntity<List<PaymentModeDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a paymentMode by id")
    @GetMapping("id/{id}")
    public ResponseEntity<PaymentModeDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  paymentMode")
    @PostMapping("")
    public ResponseEntity<PaymentModeDto> save(@RequestBody PaymentModeDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  paymentMode")
    @PutMapping("")
    public ResponseEntity<PaymentModeDto> update(@RequestBody PaymentModeDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of paymentMode")
    @PostMapping("multiple")
    public ResponseEntity<List<PaymentModeDto>> delete(@RequestBody List<PaymentModeDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified paymentMode")
    @DeleteMapping("")
    public ResponseEntity<PaymentModeDto> delete(@RequestBody PaymentModeDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified paymentMode")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple paymentModes by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("Finds paymentModes by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<PaymentModeDto>> findByCriteria(@RequestBody PaymentModeCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated paymentModes by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody PaymentModeCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports paymentModes by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody PaymentModeCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets paymentMode data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody PaymentModeCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets paymentMode history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets paymentMode paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody PaymentModeHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports paymentMode history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody PaymentModeHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets paymentMode history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody PaymentModeHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public PaymentModeRestAdmin (PaymentModeAdminService service, PaymentModeConverter converter) {
        super(service, converter);
    }


}