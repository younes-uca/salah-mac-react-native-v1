package  ma.sir.ecom.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.ecom.bean.core.OrderItem;
import ma.sir.ecom.bean.history.OrderItemHistory;
import ma.sir.ecom.dao.criteria.core.OrderItemCriteria;
import ma.sir.ecom.dao.criteria.history.OrderItemHistoryCriteria;
import ma.sir.ecom.service.facade.admin.OrderItemAdminService;
import ma.sir.ecom.ws.converter.OrderItemConverter;
import ma.sir.ecom.ws.dto.OrderItemDto;
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

@Api("Manages orderItem services")
@RestController
@RequestMapping("/api/admin/orderItem/")
public class OrderItemRestAdmin  extends AbstractController<OrderItem, OrderItemDto, OrderItemHistory, OrderItemCriteria, OrderItemHistoryCriteria, OrderItemAdminService, OrderItemConverter> {



    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody OrderItemDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one orderItem")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple orderItems")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all orderItems")
    @GetMapping("")
    public ResponseEntity<List<OrderItemDto>> findAll() throws Exception {
        return super.findAll();
    }


    @ApiOperation("Finds a orderItem by id")
    @GetMapping("id/{id}")
    public ResponseEntity<OrderItemDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  orderItem")
    @PostMapping("")
    public ResponseEntity<OrderItemDto> save(@RequestBody OrderItemDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  orderItem")
    @PutMapping("")
    public ResponseEntity<OrderItemDto> update(@RequestBody OrderItemDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of orderItem")
    @PostMapping("multiple")
    public ResponseEntity<List<OrderItemDto>> delete(@RequestBody List<OrderItemDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified orderItem")
    @DeleteMapping("")
    public ResponseEntity<OrderItemDto> delete(@RequestBody OrderItemDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified orderItem")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple orderItems by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("find by product id")
    @GetMapping("product/id/{id}")
    public List<OrderItem> findByProductId(@PathVariable Long id){
        return service.findByProductId(id);
    }
    @ApiOperation("delete by product id")
    @DeleteMapping("product/id/{id}")
    public int deleteByProductId(@PathVariable Long id){
        return service.deleteByProductId(id);
    }
    @ApiOperation("find by order id")
    @GetMapping("order/id/{id}")
    public List<OrderItem> findByOrderId(@PathVariable Long id){
        return service.findByOrderId(id);
    }
    @ApiOperation("delete by order id")
    @DeleteMapping("order/id/{id}")
    public int deleteByOrderId(@PathVariable Long id){
        return service.deleteByOrderId(id);
    }
    @ApiOperation("Finds orderItems by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<OrderItemDto>> findByCriteria(@RequestBody OrderItemCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated orderItems by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody OrderItemCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports orderItems by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody OrderItemCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets orderItem data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody OrderItemCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets orderItem history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets orderItem paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody OrderItemHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports orderItem history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody OrderItemHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets orderItem history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody OrderItemHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public OrderItemRestAdmin (OrderItemAdminService service, OrderItemConverter converter) {
        super(service, converter);
    }


}