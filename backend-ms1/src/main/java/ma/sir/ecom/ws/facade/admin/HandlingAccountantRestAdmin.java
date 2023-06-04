package  ma.sir.ecom.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.ecom.bean.core.HandlingAccountant;
import ma.sir.ecom.bean.history.HandlingAccountantHistory;
import ma.sir.ecom.dao.criteria.core.HandlingAccountantCriteria;
import ma.sir.ecom.dao.criteria.history.HandlingAccountantHistoryCriteria;
import ma.sir.ecom.service.facade.admin.HandlingAccountantAdminService;
import ma.sir.ecom.ws.converter.HandlingAccountantConverter;
import ma.sir.ecom.ws.dto.HandlingAccountantDto;
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

@Api("Manages handlingAccountant services")
@RestController
@RequestMapping("/api/admin/handlingAccountant/")
public class HandlingAccountantRestAdmin  extends AbstractController<HandlingAccountant, HandlingAccountantDto, HandlingAccountantHistory, HandlingAccountantCriteria, HandlingAccountantHistoryCriteria, HandlingAccountantAdminService, HandlingAccountantConverter> {



    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody HandlingAccountantDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one handlingAccountant")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple handlingAccountants")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all handlingAccountants")
    @GetMapping("")
    public ResponseEntity<List<HandlingAccountantDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all handlingAccountants")
    @GetMapping("optimized")
    public ResponseEntity<List<HandlingAccountantDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a handlingAccountant by id")
    @GetMapping("id/{id}")
    public ResponseEntity<HandlingAccountantDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  handlingAccountant")
    @PostMapping("")
    public ResponseEntity<HandlingAccountantDto> save(@RequestBody HandlingAccountantDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  handlingAccountant")
    @PutMapping("")
    public ResponseEntity<HandlingAccountantDto> update(@RequestBody HandlingAccountantDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of handlingAccountant")
    @PostMapping("multiple")
    public ResponseEntity<List<HandlingAccountantDto>> delete(@RequestBody List<HandlingAccountantDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified handlingAccountant")
    @DeleteMapping("")
    public ResponseEntity<HandlingAccountantDto> delete(@RequestBody HandlingAccountantDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified handlingAccountant")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple handlingAccountants by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("Finds handlingAccountants by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<HandlingAccountantDto>> findByCriteria(@RequestBody HandlingAccountantCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated handlingAccountants by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody HandlingAccountantCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports handlingAccountants by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody HandlingAccountantCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets handlingAccountant data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody HandlingAccountantCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets handlingAccountant history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets handlingAccountant paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody HandlingAccountantHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports handlingAccountant history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody HandlingAccountantHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets handlingAccountant history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody HandlingAccountantHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public HandlingAccountantRestAdmin (HandlingAccountantAdminService service, HandlingAccountantConverter converter) {
        super(service, converter);
    }


}