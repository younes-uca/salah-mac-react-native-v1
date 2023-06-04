package  ma.sir.ecom.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.ecom.bean.core.PaymentSale;
import ma.sir.ecom.bean.history.PaymentSaleHistory;
import ma.sir.ecom.dao.criteria.core.PaymentSaleCriteria;
import ma.sir.ecom.dao.criteria.history.PaymentSaleHistoryCriteria;
import ma.sir.ecom.service.facade.admin.PaymentSaleAdminService;
import ma.sir.ecom.ws.converter.PaymentSaleConverter;
import ma.sir.ecom.ws.dto.PaymentSaleDto;
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

@Api("Manages paymentSale services")
@RestController
@RequestMapping("/api/admin/paymentSale/")
public class PaymentSaleRestAdmin  extends AbstractController<PaymentSale, PaymentSaleDto, PaymentSaleHistory, PaymentSaleCriteria, PaymentSaleHistoryCriteria, PaymentSaleAdminService, PaymentSaleConverter> {



    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody PaymentSaleDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one paymentSale")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple paymentSales")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all paymentSales")
    @GetMapping("")
    public ResponseEntity<List<PaymentSaleDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all paymentSales")
    @GetMapping("optimized")
    public ResponseEntity<List<PaymentSaleDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a paymentSale by id")
    @GetMapping("id/{id}")
    public ResponseEntity<PaymentSaleDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  paymentSale")
    @PostMapping("")
    public ResponseEntity<PaymentSaleDto> save(@RequestBody PaymentSaleDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  paymentSale")
    @PutMapping("")
    public ResponseEntity<PaymentSaleDto> update(@RequestBody PaymentSaleDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of paymentSale")
    @PostMapping("multiple")
    public ResponseEntity<List<PaymentSaleDto>> delete(@RequestBody List<PaymentSaleDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified paymentSale")
    @DeleteMapping("")
    public ResponseEntity<PaymentSaleDto> delete(@RequestBody PaymentSaleDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified paymentSale")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple paymentSales by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("find by sale id")
    @GetMapping("sale/id/{id}")
    public List<PaymentSale> findBySaleId(@PathVariable Long id){
        return service.findBySaleId(id);
    }
    @ApiOperation("delete by sale id")
    @DeleteMapping("sale/id/{id}")
    public int deleteBySaleId(@PathVariable Long id){
        return service.deleteBySaleId(id);
    }
    @ApiOperation("find by paymentMethod id")
    @GetMapping("paymentMethod/id/{id}")
    public List<PaymentSale> findByPaymentMethodId(@PathVariable Long id){
        return service.findByPaymentMethodId(id);
    }
    @ApiOperation("delete by paymentMethod id")
    @DeleteMapping("paymentMethod/id/{id}")
    public int deleteByPaymentMethodId(@PathVariable Long id){
        return service.deleteByPaymentMethodId(id);
    }
    @ApiOperation("find by paymentStatus id")
    @GetMapping("paymentStatus/id/{id}")
    public List<PaymentSale> findByPaymentStatusId(@PathVariable Long id){
        return service.findByPaymentStatusId(id);
    }
    @ApiOperation("delete by paymentStatus id")
    @DeleteMapping("paymentStatus/id/{id}")
    public int deleteByPaymentStatusId(@PathVariable Long id){
        return service.deleteByPaymentStatusId(id);
    }
    @ApiOperation("Finds paymentSales by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<PaymentSaleDto>> findByCriteria(@RequestBody PaymentSaleCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated paymentSales by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody PaymentSaleCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports paymentSales by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody PaymentSaleCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets paymentSale data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody PaymentSaleCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets paymentSale history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets paymentSale paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody PaymentSaleHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports paymentSale history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody PaymentSaleHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets paymentSale history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody PaymentSaleHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public PaymentSaleRestAdmin (PaymentSaleAdminService service, PaymentSaleConverter converter) {
        super(service, converter);
    }


}