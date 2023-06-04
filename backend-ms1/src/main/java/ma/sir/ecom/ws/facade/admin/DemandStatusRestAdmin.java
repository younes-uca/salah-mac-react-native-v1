package  ma.sir.ecom.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.ecom.bean.core.DemandStatus;
import ma.sir.ecom.bean.history.DemandStatusHistory;
import ma.sir.ecom.dao.criteria.core.DemandStatusCriteria;
import ma.sir.ecom.dao.criteria.history.DemandStatusHistoryCriteria;
import ma.sir.ecom.service.facade.admin.DemandStatusAdminService;
import ma.sir.ecom.ws.converter.DemandStatusConverter;
import ma.sir.ecom.ws.dto.DemandStatusDto;
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

@Api("Manages demandStatus services")
@RestController
@RequestMapping("/api/admin/demandStatus/")
public class DemandStatusRestAdmin  extends AbstractController<DemandStatus, DemandStatusDto, DemandStatusHistory, DemandStatusCriteria, DemandStatusHistoryCriteria, DemandStatusAdminService, DemandStatusConverter> {



    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody DemandStatusDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one demandStatus")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple demandStatuss")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all demandStatuss")
    @GetMapping("")
    public ResponseEntity<List<DemandStatusDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all demandStatuss")
    @GetMapping("optimized")
    public ResponseEntity<List<DemandStatusDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a demandStatus by id")
    @GetMapping("id/{id}")
    public ResponseEntity<DemandStatusDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  demandStatus")
    @PostMapping("")
    public ResponseEntity<DemandStatusDto> save(@RequestBody DemandStatusDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  demandStatus")
    @PutMapping("")
    public ResponseEntity<DemandStatusDto> update(@RequestBody DemandStatusDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of demandStatus")
    @PostMapping("multiple")
    public ResponseEntity<List<DemandStatusDto>> delete(@RequestBody List<DemandStatusDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified demandStatus")
    @DeleteMapping("")
    public ResponseEntity<DemandStatusDto> delete(@RequestBody DemandStatusDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified demandStatus")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple demandStatuss by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("Finds demandStatuss by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<DemandStatusDto>> findByCriteria(@RequestBody DemandStatusCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated demandStatuss by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody DemandStatusCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports demandStatuss by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody DemandStatusCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets demandStatus data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody DemandStatusCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets demandStatus history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets demandStatus paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody DemandStatusHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports demandStatus history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody DemandStatusHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets demandStatus history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody DemandStatusHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public DemandStatusRestAdmin (DemandStatusAdminService service, DemandStatusConverter converter) {
        super(service, converter);
    }


}