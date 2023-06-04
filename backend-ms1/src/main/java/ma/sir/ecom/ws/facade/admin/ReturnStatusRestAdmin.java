package  ma.sir.ecom.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.ecom.bean.core.ReturnStatus;
import ma.sir.ecom.bean.history.ReturnStatusHistory;
import ma.sir.ecom.dao.criteria.core.ReturnStatusCriteria;
import ma.sir.ecom.dao.criteria.history.ReturnStatusHistoryCriteria;
import ma.sir.ecom.service.facade.admin.ReturnStatusAdminService;
import ma.sir.ecom.ws.converter.ReturnStatusConverter;
import ma.sir.ecom.ws.dto.ReturnStatusDto;
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

@Api("Manages returnStatus services")
@RestController
@RequestMapping("/api/admin/returnStatus/")
public class ReturnStatusRestAdmin  extends AbstractController<ReturnStatus, ReturnStatusDto, ReturnStatusHistory, ReturnStatusCriteria, ReturnStatusHistoryCriteria, ReturnStatusAdminService, ReturnStatusConverter> {



    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody ReturnStatusDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one returnStatus")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple returnStatuss")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all returnStatuss")
    @GetMapping("")
    public ResponseEntity<List<ReturnStatusDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all returnStatuss")
    @GetMapping("optimized")
    public ResponseEntity<List<ReturnStatusDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a returnStatus by id")
    @GetMapping("id/{id}")
    public ResponseEntity<ReturnStatusDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  returnStatus")
    @PostMapping("")
    public ResponseEntity<ReturnStatusDto> save(@RequestBody ReturnStatusDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  returnStatus")
    @PutMapping("")
    public ResponseEntity<ReturnStatusDto> update(@RequestBody ReturnStatusDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of returnStatus")
    @PostMapping("multiple")
    public ResponseEntity<List<ReturnStatusDto>> delete(@RequestBody List<ReturnStatusDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified returnStatus")
    @DeleteMapping("")
    public ResponseEntity<ReturnStatusDto> delete(@RequestBody ReturnStatusDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified returnStatus")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple returnStatuss by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("Finds returnStatuss by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<ReturnStatusDto>> findByCriteria(@RequestBody ReturnStatusCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated returnStatuss by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody ReturnStatusCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports returnStatuss by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody ReturnStatusCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets returnStatus data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody ReturnStatusCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets returnStatus history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets returnStatus paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody ReturnStatusHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports returnStatus history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody ReturnStatusHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets returnStatus history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody ReturnStatusHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public ReturnStatusRestAdmin (ReturnStatusAdminService service, ReturnStatusConverter converter) {
        super(service, converter);
    }


}