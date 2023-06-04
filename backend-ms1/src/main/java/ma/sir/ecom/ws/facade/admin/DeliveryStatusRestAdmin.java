package  ma.sir.ecom.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.ecom.bean.core.DeliveryStatus;
import ma.sir.ecom.bean.history.DeliveryStatusHistory;
import ma.sir.ecom.dao.criteria.core.DeliveryStatusCriteria;
import ma.sir.ecom.dao.criteria.history.DeliveryStatusHistoryCriteria;
import ma.sir.ecom.service.facade.admin.DeliveryStatusAdminService;
import ma.sir.ecom.ws.converter.DeliveryStatusConverter;
import ma.sir.ecom.ws.dto.DeliveryStatusDto;
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

@Api("Manages deliveryStatus services")
@RestController
@RequestMapping("/api/admin/deliveryStatus/")
public class DeliveryStatusRestAdmin  extends AbstractController<DeliveryStatus, DeliveryStatusDto, DeliveryStatusHistory, DeliveryStatusCriteria, DeliveryStatusHistoryCriteria, DeliveryStatusAdminService, DeliveryStatusConverter> {



    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody DeliveryStatusDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one deliveryStatus")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple deliveryStatuss")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all deliveryStatuss")
    @GetMapping("")
    public ResponseEntity<List<DeliveryStatusDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all deliveryStatuss")
    @GetMapping("optimized")
    public ResponseEntity<List<DeliveryStatusDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a deliveryStatus by id")
    @GetMapping("id/{id}")
    public ResponseEntity<DeliveryStatusDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  deliveryStatus")
    @PostMapping("")
    public ResponseEntity<DeliveryStatusDto> save(@RequestBody DeliveryStatusDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  deliveryStatus")
    @PutMapping("")
    public ResponseEntity<DeliveryStatusDto> update(@RequestBody DeliveryStatusDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of deliveryStatus")
    @PostMapping("multiple")
    public ResponseEntity<List<DeliveryStatusDto>> delete(@RequestBody List<DeliveryStatusDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified deliveryStatus")
    @DeleteMapping("")
    public ResponseEntity<DeliveryStatusDto> delete(@RequestBody DeliveryStatusDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified deliveryStatus")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple deliveryStatuss by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("Finds deliveryStatuss by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<DeliveryStatusDto>> findByCriteria(@RequestBody DeliveryStatusCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated deliveryStatuss by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody DeliveryStatusCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports deliveryStatuss by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody DeliveryStatusCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets deliveryStatus data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody DeliveryStatusCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets deliveryStatus history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets deliveryStatus paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody DeliveryStatusHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports deliveryStatus history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody DeliveryStatusHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets deliveryStatus history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody DeliveryStatusHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public DeliveryStatusRestAdmin (DeliveryStatusAdminService service, DeliveryStatusConverter converter) {
        super(service, converter);
    }


}