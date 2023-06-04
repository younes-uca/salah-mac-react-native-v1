package  ma.sir.ecom.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.ecom.bean.core.DeliveryItem;
import ma.sir.ecom.bean.history.DeliveryItemHistory;
import ma.sir.ecom.dao.criteria.core.DeliveryItemCriteria;
import ma.sir.ecom.dao.criteria.history.DeliveryItemHistoryCriteria;
import ma.sir.ecom.service.facade.admin.DeliveryItemAdminService;
import ma.sir.ecom.ws.converter.DeliveryItemConverter;
import ma.sir.ecom.ws.dto.DeliveryItemDto;
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

@Api("Manages deliveryItem services")
@RestController
@RequestMapping("/api/admin/deliveryItem/")
public class DeliveryItemRestAdmin  extends AbstractController<DeliveryItem, DeliveryItemDto, DeliveryItemHistory, DeliveryItemCriteria, DeliveryItemHistoryCriteria, DeliveryItemAdminService, DeliveryItemConverter> {



    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody DeliveryItemDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one deliveryItem")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple deliveryItems")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all deliveryItems")
    @GetMapping("")
    public ResponseEntity<List<DeliveryItemDto>> findAll() throws Exception {
        return super.findAll();
    }


    @ApiOperation("Finds a deliveryItem by id")
    @GetMapping("id/{id}")
    public ResponseEntity<DeliveryItemDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  deliveryItem")
    @PostMapping("")
    public ResponseEntity<DeliveryItemDto> save(@RequestBody DeliveryItemDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  deliveryItem")
    @PutMapping("")
    public ResponseEntity<DeliveryItemDto> update(@RequestBody DeliveryItemDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of deliveryItem")
    @PostMapping("multiple")
    public ResponseEntity<List<DeliveryItemDto>> delete(@RequestBody List<DeliveryItemDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified deliveryItem")
    @DeleteMapping("")
    public ResponseEntity<DeliveryItemDto> delete(@RequestBody DeliveryItemDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified deliveryItem")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple deliveryItems by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("find by product id")
    @GetMapping("product/id/{id}")
    public List<DeliveryItem> findByProductId(@PathVariable Long id){
        return service.findByProductId(id);
    }
    @ApiOperation("delete by product id")
    @DeleteMapping("product/id/{id}")
    public int deleteByProductId(@PathVariable Long id){
        return service.deleteByProductId(id);
    }
    @ApiOperation("find by store id")
    @GetMapping("store/id/{id}")
    public List<DeliveryItem> findByStoreId(@PathVariable Long id){
        return service.findByStoreId(id);
    }
    @ApiOperation("delete by store id")
    @DeleteMapping("store/id/{id}")
    public int deleteByStoreId(@PathVariable Long id){
        return service.deleteByStoreId(id);
    }
    @ApiOperation("find by delivery id")
    @GetMapping("delivery/id/{id}")
    public List<DeliveryItem> findByDeliveryId(@PathVariable Long id){
        return service.findByDeliveryId(id);
    }
    @ApiOperation("delete by delivery id")
    @DeleteMapping("delivery/id/{id}")
    public int deleteByDeliveryId(@PathVariable Long id){
        return service.deleteByDeliveryId(id);
    }
    @ApiOperation("Finds deliveryItems by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<DeliveryItemDto>> findByCriteria(@RequestBody DeliveryItemCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated deliveryItems by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody DeliveryItemCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports deliveryItems by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody DeliveryItemCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets deliveryItem data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody DeliveryItemCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets deliveryItem history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets deliveryItem paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody DeliveryItemHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports deliveryItem history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody DeliveryItemHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets deliveryItem history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody DeliveryItemHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public DeliveryItemRestAdmin (DeliveryItemAdminService service, DeliveryItemConverter converter) {
        super(service, converter);
    }


}