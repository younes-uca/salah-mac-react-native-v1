package  ma.sir.ecom.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.ecom.bean.core.ReceptionStatus;
import ma.sir.ecom.bean.history.ReceptionStatusHistory;
import ma.sir.ecom.dao.criteria.core.ReceptionStatusCriteria;
import ma.sir.ecom.dao.criteria.history.ReceptionStatusHistoryCriteria;
import ma.sir.ecom.service.facade.admin.ReceptionStatusAdminService;
import ma.sir.ecom.ws.converter.ReceptionStatusConverter;
import ma.sir.ecom.ws.dto.ReceptionStatusDto;
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

@Api("Manages receptionStatus services")
@RestController
@RequestMapping("/api/admin/receptionStatus/")
public class ReceptionStatusRestAdmin  extends AbstractController<ReceptionStatus, ReceptionStatusDto, ReceptionStatusHistory, ReceptionStatusCriteria, ReceptionStatusHistoryCriteria, ReceptionStatusAdminService, ReceptionStatusConverter> {



    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody ReceptionStatusDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one receptionStatus")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple receptionStatuss")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all receptionStatuss")
    @GetMapping("")
    public ResponseEntity<List<ReceptionStatusDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all receptionStatuss")
    @GetMapping("optimized")
    public ResponseEntity<List<ReceptionStatusDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a receptionStatus by id")
    @GetMapping("id/{id}")
    public ResponseEntity<ReceptionStatusDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  receptionStatus")
    @PostMapping("")
    public ResponseEntity<ReceptionStatusDto> save(@RequestBody ReceptionStatusDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  receptionStatus")
    @PutMapping("")
    public ResponseEntity<ReceptionStatusDto> update(@RequestBody ReceptionStatusDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of receptionStatus")
    @PostMapping("multiple")
    public ResponseEntity<List<ReceptionStatusDto>> delete(@RequestBody List<ReceptionStatusDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified receptionStatus")
    @DeleteMapping("")
    public ResponseEntity<ReceptionStatusDto> delete(@RequestBody ReceptionStatusDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified receptionStatus")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple receptionStatuss by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("Finds receptionStatuss by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<ReceptionStatusDto>> findByCriteria(@RequestBody ReceptionStatusCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated receptionStatuss by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody ReceptionStatusCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports receptionStatuss by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody ReceptionStatusCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets receptionStatus data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody ReceptionStatusCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets receptionStatus history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets receptionStatus paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody ReceptionStatusHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports receptionStatus history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody ReceptionStatusHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets receptionStatus history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody ReceptionStatusHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public ReceptionStatusRestAdmin (ReceptionStatusAdminService service, ReceptionStatusConverter converter) {
        super(service, converter);
    }


}