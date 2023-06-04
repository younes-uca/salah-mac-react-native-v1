package  ma.sir.ecom.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.ecom.bean.core.PaymentPurchase;
import ma.sir.ecom.bean.history.PaymentPurchaseHistory;
import ma.sir.ecom.dao.criteria.core.PaymentPurchaseCriteria;
import ma.sir.ecom.dao.criteria.history.PaymentPurchaseHistoryCriteria;
import ma.sir.ecom.service.facade.admin.PaymentPurchaseAdminService;
import ma.sir.ecom.ws.converter.PaymentPurchaseConverter;
import ma.sir.ecom.ws.dto.PaymentPurchaseDto;
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

@Api("Manages paymentPurchase services")
@RestController
@RequestMapping("/api/admin/paymentPurchase/")
public class PaymentPurchaseRestAdmin  extends AbstractController<PaymentPurchase, PaymentPurchaseDto, PaymentPurchaseHistory, PaymentPurchaseCriteria, PaymentPurchaseHistoryCriteria, PaymentPurchaseAdminService, PaymentPurchaseConverter> {



    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody PaymentPurchaseDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one paymentPurchase")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple paymentPurchases")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all paymentPurchases")
    @GetMapping("")
    public ResponseEntity<List<PaymentPurchaseDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all paymentPurchases")
    @GetMapping("optimized")
    public ResponseEntity<List<PaymentPurchaseDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a paymentPurchase by id")
    @GetMapping("id/{id}")
    public ResponseEntity<PaymentPurchaseDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  paymentPurchase")
    @PostMapping("")
    public ResponseEntity<PaymentPurchaseDto> save(@RequestBody PaymentPurchaseDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  paymentPurchase")
    @PutMapping("")
    public ResponseEntity<PaymentPurchaseDto> update(@RequestBody PaymentPurchaseDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of paymentPurchase")
    @PostMapping("multiple")
    public ResponseEntity<List<PaymentPurchaseDto>> delete(@RequestBody List<PaymentPurchaseDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified paymentPurchase")
    @DeleteMapping("")
    public ResponseEntity<PaymentPurchaseDto> delete(@RequestBody PaymentPurchaseDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified paymentPurchase")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple paymentPurchases by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("find by purchase id")
    @GetMapping("purchase/id/{id}")
    public List<PaymentPurchase> findByPurchaseId(@PathVariable Long id){
        return service.findByPurchaseId(id);
    }
    @ApiOperation("delete by purchase id")
    @DeleteMapping("purchase/id/{id}")
    public int deleteByPurchaseId(@PathVariable Long id){
        return service.deleteByPurchaseId(id);
    }
    @ApiOperation("find by paymentMode id")
    @GetMapping("paymentMode/id/{id}")
    public List<PaymentPurchase> findByPaymentModeId(@PathVariable Long id){
        return service.findByPaymentModeId(id);
    }
    @ApiOperation("delete by paymentMode id")
    @DeleteMapping("paymentMode/id/{id}")
    public int deleteByPaymentModeId(@PathVariable Long id){
        return service.deleteByPaymentModeId(id);
    }
    @ApiOperation("find by purchasePaymentStatus id")
    @GetMapping("purchasePaymentStatus/id/{id}")
    public List<PaymentPurchase> findByPurchasePaymentStatusId(@PathVariable Long id){
        return service.findByPurchasePaymentStatusId(id);
    }
    @ApiOperation("delete by purchasePaymentStatus id")
    @DeleteMapping("purchasePaymentStatus/id/{id}")
    public int deleteByPurchasePaymentStatusId(@PathVariable Long id){
        return service.deleteByPurchasePaymentStatusId(id);
    }
    @ApiOperation("Finds paymentPurchases by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<PaymentPurchaseDto>> findByCriteria(@RequestBody PaymentPurchaseCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated paymentPurchases by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody PaymentPurchaseCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports paymentPurchases by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody PaymentPurchaseCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets paymentPurchase data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody PaymentPurchaseCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets paymentPurchase history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets paymentPurchase paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody PaymentPurchaseHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports paymentPurchase history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody PaymentPurchaseHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets paymentPurchase history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody PaymentPurchaseHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public PaymentPurchaseRestAdmin (PaymentPurchaseAdminService service, PaymentPurchaseConverter converter) {
        super(service, converter);
    }


}