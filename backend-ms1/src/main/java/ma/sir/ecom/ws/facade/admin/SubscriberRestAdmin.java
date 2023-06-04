package  ma.sir.ecom.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.ecom.bean.core.Subscriber;
import ma.sir.ecom.bean.history.SubscriberHistory;
import ma.sir.ecom.dao.criteria.core.SubscriberCriteria;
import ma.sir.ecom.dao.criteria.history.SubscriberHistoryCriteria;
import ma.sir.ecom.service.facade.admin.SubscriberAdminService;
import ma.sir.ecom.ws.converter.SubscriberConverter;
import ma.sir.ecom.ws.dto.SubscriberDto;
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

@Api("Manages subscriber services")
@RestController
@RequestMapping("/api/admin/subscriber/")
public class SubscriberRestAdmin  extends AbstractController<Subscriber, SubscriberDto, SubscriberHistory, SubscriberCriteria, SubscriberHistoryCriteria, SubscriberAdminService, SubscriberConverter> {



    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody SubscriberDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one subscriber")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple subscribers")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all subscribers")
    @GetMapping("")
    public ResponseEntity<List<SubscriberDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all subscribers")
    @GetMapping("optimized")
    public ResponseEntity<List<SubscriberDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a subscriber by id")
    @GetMapping("id/{id}")
    public ResponseEntity<SubscriberDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  subscriber")
    @PostMapping("")
    public ResponseEntity<SubscriberDto> save(@RequestBody SubscriberDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  subscriber")
    @PutMapping("")
    public ResponseEntity<SubscriberDto> update(@RequestBody SubscriberDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of subscriber")
    @PostMapping("multiple")
    public ResponseEntity<List<SubscriberDto>> delete(@RequestBody List<SubscriberDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified subscriber")
    @DeleteMapping("")
    public ResponseEntity<SubscriberDto> delete(@RequestBody SubscriberDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified subscriber")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple subscribers by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("Finds a subscriber and associated list by id")
    @GetMapping("detail/id/{id}")
    public ResponseEntity<SubscriberDto> findWithAssociatedLists(@PathVariable Long id) {
        return super.findWithAssociatedLists(id);
    }

    @ApiOperation("Finds subscribers by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<SubscriberDto>> findByCriteria(@RequestBody SubscriberCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated subscribers by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody SubscriberCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports subscribers by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody SubscriberCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets subscriber data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody SubscriberCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets subscriber history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets subscriber paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody SubscriberHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports subscriber history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody SubscriberHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets subscriber history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody SubscriberHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public SubscriberRestAdmin (SubscriberAdminService service, SubscriberConverter converter) {
        super(service, converter);
    }


}