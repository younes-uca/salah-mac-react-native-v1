package  ma.sir.ecom.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.ecom.bean.core.OrderStatusOrder;
import ma.sir.ecom.bean.history.OrderStatusOrderHistory;
import ma.sir.ecom.dao.criteria.core.OrderStatusOrderCriteria;
import ma.sir.ecom.dao.criteria.history.OrderStatusOrderHistoryCriteria;
import ma.sir.ecom.service.facade.admin.OrderStatusOrderAdminService;
import ma.sir.ecom.ws.converter.OrderStatusOrderConverter;
import ma.sir.ecom.ws.dto.OrderStatusOrderDto;
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

@Api("Manages orderStatusOrder services")
@RestController
@RequestMapping("/api/admin/orderStatusOrder/")
public class OrderStatusOrderRestAdmin  extends AbstractController<OrderStatusOrder, OrderStatusOrderDto, OrderStatusOrderHistory, OrderStatusOrderCriteria, OrderStatusOrderHistoryCriteria, OrderStatusOrderAdminService, OrderStatusOrderConverter> {



    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody OrderStatusOrderDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one orderStatusOrder")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple orderStatusOrders")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all orderStatusOrders")
    @GetMapping("")
    public ResponseEntity<List<OrderStatusOrderDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all orderStatusOrders")
    @GetMapping("optimized")
    public ResponseEntity<List<OrderStatusOrderDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a orderStatusOrder by id")
    @GetMapping("id/{id}")
    public ResponseEntity<OrderStatusOrderDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  orderStatusOrder")
    @PostMapping("")
    public ResponseEntity<OrderStatusOrderDto> save(@RequestBody OrderStatusOrderDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  orderStatusOrder")
    @PutMapping("")
    public ResponseEntity<OrderStatusOrderDto> update(@RequestBody OrderStatusOrderDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of orderStatusOrder")
    @PostMapping("multiple")
    public ResponseEntity<List<OrderStatusOrderDto>> delete(@RequestBody List<OrderStatusOrderDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified orderStatusOrder")
    @DeleteMapping("")
    public ResponseEntity<OrderStatusOrderDto> delete(@RequestBody OrderStatusOrderDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified orderStatusOrder")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple orderStatusOrders by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("Finds orderStatusOrders by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<OrderStatusOrderDto>> findByCriteria(@RequestBody OrderStatusOrderCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated orderStatusOrders by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody OrderStatusOrderCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports orderStatusOrders by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody OrderStatusOrderCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets orderStatusOrder data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody OrderStatusOrderCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets orderStatusOrder history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets orderStatusOrder paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody OrderStatusOrderHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports orderStatusOrder history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody OrderStatusOrderHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets orderStatusOrder history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody OrderStatusOrderHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public OrderStatusOrderRestAdmin (OrderStatusOrderAdminService service, OrderStatusOrderConverter converter) {
        super(service, converter);
    }


}