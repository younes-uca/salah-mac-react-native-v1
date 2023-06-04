package  ma.sir.ecom.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.ecom.bean.core.PaymentDelivery;
import ma.sir.ecom.bean.history.PaymentDeliveryHistory;
import ma.sir.ecom.dao.criteria.core.PaymentDeliveryCriteria;
import ma.sir.ecom.dao.criteria.history.PaymentDeliveryHistoryCriteria;
import ma.sir.ecom.service.facade.admin.PaymentDeliveryAdminService;
import ma.sir.ecom.ws.converter.PaymentDeliveryConverter;
import ma.sir.ecom.ws.dto.PaymentDeliveryDto;
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

@Api("Manages paymentDelivery services")
@RestController
@RequestMapping("/api/admin/paymentDelivery/")
public class PaymentDeliveryRestAdmin  extends AbstractController<PaymentDelivery, PaymentDeliveryDto, PaymentDeliveryHistory, PaymentDeliveryCriteria, PaymentDeliveryHistoryCriteria, PaymentDeliveryAdminService, PaymentDeliveryConverter> {



    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody PaymentDeliveryDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one paymentDelivery")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple paymentDeliverys")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all paymentDeliverys")
    @GetMapping("")
    public ResponseEntity<List<PaymentDeliveryDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all paymentDeliverys")
    @GetMapping("optimized")
    public ResponseEntity<List<PaymentDeliveryDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a paymentDelivery by id")
    @GetMapping("id/{id}")
    public ResponseEntity<PaymentDeliveryDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  paymentDelivery")
    @PostMapping("")
    public ResponseEntity<PaymentDeliveryDto> save(@RequestBody PaymentDeliveryDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  paymentDelivery")
    @PutMapping("")
    public ResponseEntity<PaymentDeliveryDto> update(@RequestBody PaymentDeliveryDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of paymentDelivery")
    @PostMapping("multiple")
    public ResponseEntity<List<PaymentDeliveryDto>> delete(@RequestBody List<PaymentDeliveryDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified paymentDelivery")
    @DeleteMapping("")
    public ResponseEntity<PaymentDeliveryDto> delete(@RequestBody PaymentDeliveryDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified paymentDelivery")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple paymentDeliverys by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("find by delivery id")
    @GetMapping("delivery/id/{id}")
    public List<PaymentDelivery> findByDeliveryId(@PathVariable Long id){
        return service.findByDeliveryId(id);
    }
    @ApiOperation("delete by delivery id")
    @DeleteMapping("delivery/id/{id}")
    public int deleteByDeliveryId(@PathVariable Long id){
        return service.deleteByDeliveryId(id);
    }
    @ApiOperation("find by sale id")
    @GetMapping("sale/id/{id}")
    public List<PaymentDelivery> findBySaleId(@PathVariable Long id){
        return service.findBySaleId(id);
    }
    @ApiOperation("delete by sale id")
    @DeleteMapping("sale/id/{id}")
    public int deleteBySaleId(@PathVariable Long id){
        return service.deleteBySaleId(id);
    }
    @ApiOperation("find by paymentMethod id")
    @GetMapping("paymentMethod/id/{id}")
    public List<PaymentDelivery> findByPaymentMethodId(@PathVariable Long id){
        return service.findByPaymentMethodId(id);
    }
    @ApiOperation("delete by paymentMethod id")
    @DeleteMapping("paymentMethod/id/{id}")
    public int deleteByPaymentMethodId(@PathVariable Long id){
        return service.deleteByPaymentMethodId(id);
    }
    @ApiOperation("find by paymentDeliveryStatus id")
    @GetMapping("paymentDeliveryStatus/id/{id}")
    public List<PaymentDelivery> findByPaymentDeliveryStatusId(@PathVariable Long id){
        return service.findByPaymentDeliveryStatusId(id);
    }
    @ApiOperation("delete by paymentDeliveryStatus id")
    @DeleteMapping("paymentDeliveryStatus/id/{id}")
    public int deleteByPaymentDeliveryStatusId(@PathVariable Long id){
        return service.deleteByPaymentDeliveryStatusId(id);
    }
    @ApiOperation("Finds paymentDeliverys by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<PaymentDeliveryDto>> findByCriteria(@RequestBody PaymentDeliveryCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated paymentDeliverys by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody PaymentDeliveryCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports paymentDeliverys by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody PaymentDeliveryCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets paymentDelivery data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody PaymentDeliveryCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets paymentDelivery history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets paymentDelivery paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody PaymentDeliveryHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports paymentDelivery history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody PaymentDeliveryHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets paymentDelivery history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody PaymentDeliveryHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public PaymentDeliveryRestAdmin (PaymentDeliveryAdminService service, PaymentDeliveryConverter converter) {
        super(service, converter);
    }


}