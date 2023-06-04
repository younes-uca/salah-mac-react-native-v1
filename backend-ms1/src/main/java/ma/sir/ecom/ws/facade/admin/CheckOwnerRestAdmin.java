package  ma.sir.ecom.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.ecom.bean.core.CheckOwner;
import ma.sir.ecom.bean.history.CheckOwnerHistory;
import ma.sir.ecom.dao.criteria.core.CheckOwnerCriteria;
import ma.sir.ecom.dao.criteria.history.CheckOwnerHistoryCriteria;
import ma.sir.ecom.service.facade.admin.CheckOwnerAdminService;
import ma.sir.ecom.ws.converter.CheckOwnerConverter;
import ma.sir.ecom.ws.dto.CheckOwnerDto;
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

@Api("Manages checkOwner services")
@RestController
@RequestMapping("/api/admin/checkOwner/")
public class CheckOwnerRestAdmin  extends AbstractController<CheckOwner, CheckOwnerDto, CheckOwnerHistory, CheckOwnerCriteria, CheckOwnerHistoryCriteria, CheckOwnerAdminService, CheckOwnerConverter> {



    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody CheckOwnerDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one checkOwner")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple checkOwners")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all checkOwners")
    @GetMapping("")
    public ResponseEntity<List<CheckOwnerDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all checkOwners")
    @GetMapping("optimized")
    public ResponseEntity<List<CheckOwnerDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a checkOwner by id")
    @GetMapping("id/{id}")
    public ResponseEntity<CheckOwnerDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  checkOwner")
    @PostMapping("")
    public ResponseEntity<CheckOwnerDto> save(@RequestBody CheckOwnerDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  checkOwner")
    @PutMapping("")
    public ResponseEntity<CheckOwnerDto> update(@RequestBody CheckOwnerDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of checkOwner")
    @PostMapping("multiple")
    public ResponseEntity<List<CheckOwnerDto>> delete(@RequestBody List<CheckOwnerDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified checkOwner")
    @DeleteMapping("")
    public ResponseEntity<CheckOwnerDto> delete(@RequestBody CheckOwnerDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified checkOwner")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple checkOwners by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("Finds checkOwners by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<CheckOwnerDto>> findByCriteria(@RequestBody CheckOwnerCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated checkOwners by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody CheckOwnerCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports checkOwners by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody CheckOwnerCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets checkOwner data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody CheckOwnerCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets checkOwner history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets checkOwner paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody CheckOwnerHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports checkOwner history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody CheckOwnerHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets checkOwner history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody CheckOwnerHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public CheckOwnerRestAdmin (CheckOwnerAdminService service, CheckOwnerConverter converter) {
        super(service, converter);
    }


}