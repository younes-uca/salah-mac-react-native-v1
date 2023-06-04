package  ma.sir.ecom.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.ecom.bean.core.OrderPayment;
import ma.sir.ecom.bean.history.OrderPaymentHistory;
import ma.sir.ecom.dao.criteria.core.OrderPaymentCriteria;
import ma.sir.ecom.dao.criteria.history.OrderPaymentHistoryCriteria;
import ma.sir.ecom.service.facade.admin.OrderPaymentAdminService;
import ma.sir.ecom.ws.converter.OrderPaymentConverter;
import ma.sir.ecom.ws.dto.OrderPaymentDto;
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

@Api("Manages orderPayment services")
@RestController
@RequestMapping("/api/admin/orderPayment/")
public class OrderPaymentRestAdmin  extends AbstractController<OrderPayment, OrderPaymentDto, OrderPaymentHistory, OrderPaymentCriteria, OrderPaymentHistoryCriteria, OrderPaymentAdminService, OrderPaymentConverter> {



    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody OrderPaymentDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one orderPayment")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple orderPayments")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all orderPayments")
    @GetMapping("")
    public ResponseEntity<List<OrderPaymentDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all orderPayments")
    @GetMapping("optimized")
    public ResponseEntity<List<OrderPaymentDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a orderPayment by id")
    @GetMapping("id/{id}")
    public ResponseEntity<OrderPaymentDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  orderPayment")
    @PostMapping("")
    public ResponseEntity<OrderPaymentDto> save(@RequestBody OrderPaymentDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  orderPayment")
    @PutMapping("")
    public ResponseEntity<OrderPaymentDto> update(@RequestBody OrderPaymentDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of orderPayment")
    @PostMapping("multiple")
    public ResponseEntity<List<OrderPaymentDto>> delete(@RequestBody List<OrderPaymentDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified orderPayment")
    @DeleteMapping("")
    public ResponseEntity<OrderPaymentDto> delete(@RequestBody OrderPaymentDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified orderPayment")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple orderPayments by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("find by order id")
    @GetMapping("order/id/{id}")
    public List<OrderPayment> findByOrderId(@PathVariable Long id){
        return service.findByOrderId(id);
    }
    @ApiOperation("delete by order id")
    @DeleteMapping("order/id/{id}")
    public int deleteByOrderId(@PathVariable Long id){
        return service.deleteByOrderId(id);
    }
    @ApiOperation("find by paymentMode id")
    @GetMapping("paymentMode/id/{id}")
    public List<OrderPayment> findByPaymentModeId(@PathVariable Long id){
        return service.findByPaymentModeId(id);
    }
    @ApiOperation("delete by paymentMode id")
    @DeleteMapping("paymentMode/id/{id}")
    public int deleteByPaymentModeId(@PathVariable Long id){
        return service.deleteByPaymentModeId(id);
    }
    @ApiOperation("find by orderStatusOrder id")
    @GetMapping("orderStatusOrder/id/{id}")
    public List<OrderPayment> findByOrderStatusOrderId(@PathVariable Long id){
        return service.findByOrderStatusOrderId(id);
    }
    @ApiOperation("delete by orderStatusOrder id")
    @DeleteMapping("orderStatusOrder/id/{id}")
    public int deleteByOrderStatusOrderId(@PathVariable Long id){
        return service.deleteByOrderStatusOrderId(id);
    }
    @ApiOperation("Finds orderPayments by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<OrderPaymentDto>> findByCriteria(@RequestBody OrderPaymentCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated orderPayments by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody OrderPaymentCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports orderPayments by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody OrderPaymentCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets orderPayment data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody OrderPaymentCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets orderPayment history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets orderPayment paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody OrderPaymentHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports orderPayment history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody OrderPaymentHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets orderPayment history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody OrderPaymentHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public OrderPaymentRestAdmin (OrderPaymentAdminService service, OrderPaymentConverter converter) {
        super(service, converter);
    }


}