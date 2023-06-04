package  ma.sir.ecom.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.ecom.bean.core.Delivery;
import ma.sir.ecom.bean.history.DeliveryHistory;
import ma.sir.ecom.dao.criteria.core.DeliveryCriteria;
import ma.sir.ecom.dao.criteria.history.DeliveryHistoryCriteria;
import ma.sir.ecom.service.facade.admin.DeliveryAdminService;
import ma.sir.ecom.ws.converter.DeliveryConverter;
import ma.sir.ecom.ws.dto.DeliveryDto;
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

@Api("Manages delivery services")
@RestController
@RequestMapping("/api/admin/delivery/")
public class DeliveryRestAdmin  extends AbstractController<Delivery, DeliveryDto, DeliveryHistory, DeliveryCriteria, DeliveryHistoryCriteria, DeliveryAdminService, DeliveryConverter> {



    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody DeliveryDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one delivery")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple deliverys")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all deliverys")
    @GetMapping("")
    public ResponseEntity<List<DeliveryDto>> findAll() throws Exception {
        return super.findAll();
    }


    @ApiOperation("Finds a delivery by id")
    @GetMapping("id/{id}")
    public ResponseEntity<DeliveryDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  delivery")
    @PostMapping("")
    public ResponseEntity<DeliveryDto> save(@RequestBody DeliveryDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  delivery")
    @PutMapping("")
    public ResponseEntity<DeliveryDto> update(@RequestBody DeliveryDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of delivery")
    @PostMapping("multiple")
    public ResponseEntity<List<DeliveryDto>> delete(@RequestBody List<DeliveryDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified delivery")
    @DeleteMapping("")
    public ResponseEntity<DeliveryDto> delete(@RequestBody DeliveryDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified delivery")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple deliverys by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("find by demand id")
    @GetMapping("demand/id/{id}")
    public List<Delivery> findByDemandId(@PathVariable Long id){
        return service.findByDemandId(id);
    }
    @ApiOperation("delete by demand id")
    @DeleteMapping("demand/id/{id}")
    public int deleteByDemandId(@PathVariable Long id){
        return service.deleteByDemandId(id);
    }
    @ApiOperation("find by deliveryStatus id")
    @GetMapping("deliveryStatus/id/{id}")
    public List<Delivery> findByDeliveryStatusId(@PathVariable Long id){
        return service.findByDeliveryStatusId(id);
    }
    @ApiOperation("delete by deliveryStatus id")
    @DeleteMapping("deliveryStatus/id/{id}")
    public int deleteByDeliveryStatusId(@PathVariable Long id){
        return service.deleteByDeliveryStatusId(id);
    }
    @ApiOperation("find by client id")
    @GetMapping("client/id/{id}")
    public List<Delivery> findByClientId(@PathVariable Long id){
        return service.findByClientId(id);
    }
    @ApiOperation("delete by client id")
    @DeleteMapping("client/id/{id}")
    public int deleteByClientId(@PathVariable Long id){
        return service.deleteByClientId(id);
    }
    @ApiOperation("Finds a delivery and associated list by id")
    @GetMapping("detail/id/{id}")
    public ResponseEntity<DeliveryDto> findWithAssociatedLists(@PathVariable Long id) {
        return super.findWithAssociatedLists(id);
    }

    @ApiOperation("Finds deliverys by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<DeliveryDto>> findByCriteria(@RequestBody DeliveryCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated deliverys by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody DeliveryCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports deliverys by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody DeliveryCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets delivery data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody DeliveryCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets delivery history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets delivery paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody DeliveryHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports delivery history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody DeliveryHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets delivery history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody DeliveryHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public DeliveryRestAdmin (DeliveryAdminService service, DeliveryConverter converter) {
        super(service, converter);
    }


}