package  ma.sir.ecom.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.ecom.bean.core.Brand;
import ma.sir.ecom.bean.history.BrandHistory;
import ma.sir.ecom.dao.criteria.core.BrandCriteria;
import ma.sir.ecom.dao.criteria.history.BrandHistoryCriteria;
import ma.sir.ecom.service.facade.admin.BrandAdminService;
import ma.sir.ecom.ws.converter.BrandConverter;
import ma.sir.ecom.ws.dto.BrandDto;
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

@Api("Manages brand services")
@RestController
@RequestMapping("/api/admin/brand/")
public class BrandRestAdmin  extends AbstractController<Brand, BrandDto, BrandHistory, BrandCriteria, BrandHistoryCriteria, BrandAdminService, BrandConverter> {



    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody BrandDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one brand")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple brands")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all brands")
    @GetMapping("")
    public ResponseEntity<List<BrandDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all brands")
    @GetMapping("optimized")
    public ResponseEntity<List<BrandDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a brand by id")
    @GetMapping("id/{id}")
    public ResponseEntity<BrandDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  brand")
    @PostMapping("")
    public ResponseEntity<BrandDto> save(@RequestBody BrandDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  brand")
    @PutMapping("")
    public ResponseEntity<BrandDto> update(@RequestBody BrandDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of brand")
    @PostMapping("multiple")
    public ResponseEntity<List<BrandDto>> delete(@RequestBody List<BrandDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified brand")
    @DeleteMapping("")
    public ResponseEntity<BrandDto> delete(@RequestBody BrandDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified brand")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple brands by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("Finds brands by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<BrandDto>> findByCriteria(@RequestBody BrandCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated brands by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody BrandCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports brands by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody BrandCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets brand data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody BrandCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets brand history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets brand paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody BrandHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports brand history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody BrandHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets brand history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody BrandHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public BrandRestAdmin (BrandAdminService service, BrandConverter converter) {
        super(service, converter);
    }


}