package  ma.sir.ecom.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.ecom.bean.core.CorporateTaxRate;
import ma.sir.ecom.bean.history.CorporateTaxRateHistory;
import ma.sir.ecom.dao.criteria.core.CorporateTaxRateCriteria;
import ma.sir.ecom.dao.criteria.history.CorporateTaxRateHistoryCriteria;
import ma.sir.ecom.service.facade.admin.CorporateTaxRateAdminService;
import ma.sir.ecom.ws.converter.CorporateTaxRateConverter;
import ma.sir.ecom.ws.dto.CorporateTaxRateDto;
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

@Api("Manages corporateTaxRate services")
@RestController
@RequestMapping("/api/admin/corporateTaxRate/")
public class CorporateTaxRateRestAdmin  extends AbstractController<CorporateTaxRate, CorporateTaxRateDto, CorporateTaxRateHistory, CorporateTaxRateCriteria, CorporateTaxRateHistoryCriteria, CorporateTaxRateAdminService, CorporateTaxRateConverter> {



    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody CorporateTaxRateDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one corporateTaxRate")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple corporateTaxRates")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all corporateTaxRates")
    @GetMapping("")
    public ResponseEntity<List<CorporateTaxRateDto>> findAll() throws Exception {
        return super.findAll();
    }


    @ApiOperation("Finds a corporateTaxRate by id")
    @GetMapping("id/{id}")
    public ResponseEntity<CorporateTaxRateDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  corporateTaxRate")
    @PostMapping("")
    public ResponseEntity<CorporateTaxRateDto> save(@RequestBody CorporateTaxRateDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  corporateTaxRate")
    @PutMapping("")
    public ResponseEntity<CorporateTaxRateDto> update(@RequestBody CorporateTaxRateDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of corporateTaxRate")
    @PostMapping("multiple")
    public ResponseEntity<List<CorporateTaxRateDto>> delete(@RequestBody List<CorporateTaxRateDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified corporateTaxRate")
    @DeleteMapping("")
    public ResponseEntity<CorporateTaxRateDto> delete(@RequestBody CorporateTaxRateDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified corporateTaxRate")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple corporateTaxRates by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("Finds corporateTaxRates by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<CorporateTaxRateDto>> findByCriteria(@RequestBody CorporateTaxRateCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated corporateTaxRates by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody CorporateTaxRateCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports corporateTaxRates by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody CorporateTaxRateCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets corporateTaxRate data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody CorporateTaxRateCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets corporateTaxRate history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets corporateTaxRate paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody CorporateTaxRateHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports corporateTaxRate history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody CorporateTaxRateHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets corporateTaxRate history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody CorporateTaxRateHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public CorporateTaxRateRestAdmin (CorporateTaxRateAdminService service, CorporateTaxRateConverter converter) {
        super(service, converter);
    }


}