package  ma.sir.ecom.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.ecom.bean.core.Order;
import ma.sir.ecom.bean.history.OrderHistory;
import ma.sir.ecom.dao.criteria.core.OrderCriteria;
import ma.sir.ecom.dao.criteria.history.OrderHistoryCriteria;
import ma.sir.ecom.service.facade.admin.OrderAdminService;
import ma.sir.ecom.ws.converter.OrderConverter;
import ma.sir.ecom.ws.dto.OrderDto;
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

@Api("Manages order services")
@RestController
@RequestMapping("/api/admin/order/")
public class OrderRestAdmin  extends AbstractController<Order, OrderDto, OrderHistory, OrderCriteria, OrderHistoryCriteria, OrderAdminService, OrderConverter> {



    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody OrderDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one order")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple orders")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all orders")
    @GetMapping("")
    public ResponseEntity<List<OrderDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all orders")
    @GetMapping("optimized")
    public ResponseEntity<List<OrderDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a order by id")
    @GetMapping("id/{id}")
    public ResponseEntity<OrderDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  order")
    @PostMapping("")
    public ResponseEntity<OrderDto> save(@RequestBody OrderDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  order")
    @PutMapping("")
    public ResponseEntity<OrderDto> update(@RequestBody OrderDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of order")
    @PostMapping("multiple")
    public ResponseEntity<List<OrderDto>> delete(@RequestBody List<OrderDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified order")
    @DeleteMapping("")
    public ResponseEntity<OrderDto> delete(@RequestBody OrderDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified order")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple orders by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("find by client id")
    @GetMapping("client/id/{id}")
    public List<Order> findByClientId(@PathVariable Long id){
        return service.findByClientId(id);
    }
    @ApiOperation("delete by client id")
    @DeleteMapping("client/id/{id}")
    public int deleteByClientId(@PathVariable Long id){
        return service.deleteByClientId(id);
    }
    @ApiOperation("find by orderStatus id")
    @GetMapping("orderStatus/id/{id}")
    public List<Order> findByOrderStatusId(@PathVariable Long id){
        return service.findByOrderStatusId(id);
    }
    @ApiOperation("delete by orderStatus id")
    @DeleteMapping("orderStatus/id/{id}")
    public int deleteByOrderStatusId(@PathVariable Long id){
        return service.deleteByOrderStatusId(id);
    }
    @ApiOperation("Finds a order and associated list by id")
    @GetMapping("detail/id/{id}")
    public ResponseEntity<OrderDto> findWithAssociatedLists(@PathVariable Long id) {
        return super.findWithAssociatedLists(id);
    }

    @ApiOperation("Finds orders by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<OrderDto>> findByCriteria(@RequestBody OrderCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated orders by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody OrderCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports orders by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody OrderCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets order data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody OrderCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets order history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets order paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody OrderHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports order history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody OrderHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets order history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody OrderHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public OrderRestAdmin (OrderAdminService service, OrderConverter converter) {
        super(service, converter);
    }


}