package  ma.sir.ecom.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.ecom.bean.core.PaymentMethod;
import ma.sir.ecom.bean.history.PaymentMethodHistory;
import ma.sir.ecom.dao.criteria.core.PaymentMethodCriteria;
import ma.sir.ecom.dao.criteria.history.PaymentMethodHistoryCriteria;
import ma.sir.ecom.service.facade.admin.PaymentMethodAdminService;
import ma.sir.ecom.ws.converter.PaymentMethodConverter;
import ma.sir.ecom.ws.dto.PaymentMethodDto;
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

@Api("Manages paymentMethod services")
@RestController
@RequestMapping("/api/admin/paymentMethod/")
public class PaymentMethodRestAdmin  extends AbstractController<PaymentMethod, PaymentMethodDto, PaymentMethodHistory, PaymentMethodCriteria, PaymentMethodHistoryCriteria, PaymentMethodAdminService, PaymentMethodConverter> {



    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody PaymentMethodDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one paymentMethod")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple paymentMethods")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all paymentMethods")
    @GetMapping("")
    public ResponseEntity<List<PaymentMethodDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all paymentMethods")
    @GetMapping("optimized")
    public ResponseEntity<List<PaymentMethodDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a paymentMethod by id")
    @GetMapping("id/{id}")
    public ResponseEntity<PaymentMethodDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  paymentMethod")
    @PostMapping("")
    public ResponseEntity<PaymentMethodDto> save(@RequestBody PaymentMethodDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  paymentMethod")
    @PutMapping("")
    public ResponseEntity<PaymentMethodDto> update(@RequestBody PaymentMethodDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of paymentMethod")
    @PostMapping("multiple")
    public ResponseEntity<List<PaymentMethodDto>> delete(@RequestBody List<PaymentMethodDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified paymentMethod")
    @DeleteMapping("")
    public ResponseEntity<PaymentMethodDto> delete(@RequestBody PaymentMethodDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified paymentMethod")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple paymentMethods by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("Finds paymentMethods by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<PaymentMethodDto>> findByCriteria(@RequestBody PaymentMethodCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated paymentMethods by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody PaymentMethodCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports paymentMethods by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody PaymentMethodCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets paymentMethod data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody PaymentMethodCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets paymentMethod history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets paymentMethod paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody PaymentMethodHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports paymentMethod history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody PaymentMethodHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets paymentMethod history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody PaymentMethodHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public PaymentMethodRestAdmin (PaymentMethodAdminService service, PaymentMethodConverter converter) {
        super(service, converter);
    }


}