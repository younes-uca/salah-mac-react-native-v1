package  ma.sir.ecom.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.ecom.bean.core.SaleStatus;
import ma.sir.ecom.bean.history.SaleStatusHistory;
import ma.sir.ecom.dao.criteria.core.SaleStatusCriteria;
import ma.sir.ecom.dao.criteria.history.SaleStatusHistoryCriteria;
import ma.sir.ecom.service.facade.admin.SaleStatusAdminService;
import ma.sir.ecom.ws.converter.SaleStatusConverter;
import ma.sir.ecom.ws.dto.SaleStatusDto;
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

@Api("Manages saleStatus services")
@RestController
@RequestMapping("/api/admin/saleStatus/")
public class SaleStatusRestAdmin  extends AbstractController<SaleStatus, SaleStatusDto, SaleStatusHistory, SaleStatusCriteria, SaleStatusHistoryCriteria, SaleStatusAdminService, SaleStatusConverter> {



    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody SaleStatusDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one saleStatus")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple saleStatuss")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all saleStatuss")
    @GetMapping("")
    public ResponseEntity<List<SaleStatusDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all saleStatuss")
    @GetMapping("optimized")
    public ResponseEntity<List<SaleStatusDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a saleStatus by id")
    @GetMapping("id/{id}")
    public ResponseEntity<SaleStatusDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  saleStatus")
    @PostMapping("")
    public ResponseEntity<SaleStatusDto> save(@RequestBody SaleStatusDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  saleStatus")
    @PutMapping("")
    public ResponseEntity<SaleStatusDto> update(@RequestBody SaleStatusDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of saleStatus")
    @PostMapping("multiple")
    public ResponseEntity<List<SaleStatusDto>> delete(@RequestBody List<SaleStatusDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified saleStatus")
    @DeleteMapping("")
    public ResponseEntity<SaleStatusDto> delete(@RequestBody SaleStatusDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified saleStatus")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple saleStatuss by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("Finds saleStatuss by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<SaleStatusDto>> findByCriteria(@RequestBody SaleStatusCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated saleStatuss by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody SaleStatusCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports saleStatuss by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody SaleStatusCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets saleStatus data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody SaleStatusCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets saleStatus history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets saleStatus paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody SaleStatusHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports saleStatus history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody SaleStatusHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets saleStatus history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody SaleStatusHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public SaleStatusRestAdmin (SaleStatusAdminService service, SaleStatusConverter converter) {
        super(service, converter);
    }


}