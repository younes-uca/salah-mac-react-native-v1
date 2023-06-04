package  ma.sir.ecom.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.ecom.bean.core.ReceptionItem;
import ma.sir.ecom.bean.history.ReceptionItemHistory;
import ma.sir.ecom.dao.criteria.core.ReceptionItemCriteria;
import ma.sir.ecom.dao.criteria.history.ReceptionItemHistoryCriteria;
import ma.sir.ecom.service.facade.admin.ReceptionItemAdminService;
import ma.sir.ecom.ws.converter.ReceptionItemConverter;
import ma.sir.ecom.ws.dto.ReceptionItemDto;
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

@Api("Manages receptionItem services")
@RestController
@RequestMapping("/api/admin/receptionItem/")
public class ReceptionItemRestAdmin  extends AbstractController<ReceptionItem, ReceptionItemDto, ReceptionItemHistory, ReceptionItemCriteria, ReceptionItemHistoryCriteria, ReceptionItemAdminService, ReceptionItemConverter> {



    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody ReceptionItemDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one receptionItem")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple receptionItems")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all receptionItems")
    @GetMapping("")
    public ResponseEntity<List<ReceptionItemDto>> findAll() throws Exception {
        return super.findAll();
    }


    @ApiOperation("Finds a receptionItem by id")
    @GetMapping("id/{id}")
    public ResponseEntity<ReceptionItemDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  receptionItem")
    @PostMapping("")
    public ResponseEntity<ReceptionItemDto> save(@RequestBody ReceptionItemDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  receptionItem")
    @PutMapping("")
    public ResponseEntity<ReceptionItemDto> update(@RequestBody ReceptionItemDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of receptionItem")
    @PostMapping("multiple")
    public ResponseEntity<List<ReceptionItemDto>> delete(@RequestBody List<ReceptionItemDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified receptionItem")
    @DeleteMapping("")
    public ResponseEntity<ReceptionItemDto> delete(@RequestBody ReceptionItemDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified receptionItem")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple receptionItems by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("find by product id")
    @GetMapping("product/id/{id}")
    public List<ReceptionItem> findByProductId(@PathVariable Long id){
        return service.findByProductId(id);
    }
    @ApiOperation("delete by product id")
    @DeleteMapping("product/id/{id}")
    public int deleteByProductId(@PathVariable Long id){
        return service.deleteByProductId(id);
    }
    @ApiOperation("find by store id")
    @GetMapping("store/id/{id}")
    public List<ReceptionItem> findByStoreId(@PathVariable Long id){
        return service.findByStoreId(id);
    }
    @ApiOperation("delete by store id")
    @DeleteMapping("store/id/{id}")
    public int deleteByStoreId(@PathVariable Long id){
        return service.deleteByStoreId(id);
    }
    @ApiOperation("find by reception id")
    @GetMapping("reception/id/{id}")
    public List<ReceptionItem> findByReceptionId(@PathVariable Long id){
        return service.findByReceptionId(id);
    }
    @ApiOperation("delete by reception id")
    @DeleteMapping("reception/id/{id}")
    public int deleteByReceptionId(@PathVariable Long id){
        return service.deleteByReceptionId(id);
    }
    @ApiOperation("Finds receptionItems by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<ReceptionItemDto>> findByCriteria(@RequestBody ReceptionItemCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated receptionItems by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody ReceptionItemCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports receptionItems by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody ReceptionItemCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets receptionItem data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody ReceptionItemCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets receptionItem history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets receptionItem paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody ReceptionItemHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports receptionItem history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody ReceptionItemHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets receptionItem history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody ReceptionItemHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public ReceptionItemRestAdmin (ReceptionItemAdminService service, ReceptionItemConverter converter) {
        super(service, converter);
    }


}