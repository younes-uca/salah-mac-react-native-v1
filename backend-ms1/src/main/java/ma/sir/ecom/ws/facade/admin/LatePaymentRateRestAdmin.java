package  ma.sir.ecom.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.ecom.bean.core.LatePaymentRate;
import ma.sir.ecom.bean.history.LatePaymentRateHistory;
import ma.sir.ecom.dao.criteria.core.LatePaymentRateCriteria;
import ma.sir.ecom.dao.criteria.history.LatePaymentRateHistoryCriteria;
import ma.sir.ecom.service.facade.admin.LatePaymentRateAdminService;
import ma.sir.ecom.ws.converter.LatePaymentRateConverter;
import ma.sir.ecom.ws.dto.LatePaymentRateDto;
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

@Api("Manages latePaymentRate services")
@RestController
@RequestMapping("/api/admin/latePaymentRate/")
public class LatePaymentRateRestAdmin  extends AbstractController<LatePaymentRate, LatePaymentRateDto, LatePaymentRateHistory, LatePaymentRateCriteria, LatePaymentRateHistoryCriteria, LatePaymentRateAdminService, LatePaymentRateConverter> {



    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody LatePaymentRateDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one latePaymentRate")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple latePaymentRates")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all latePaymentRates")
    @GetMapping("")
    public ResponseEntity<List<LatePaymentRateDto>> findAll() throws Exception {
        return super.findAll();
    }


    @ApiOperation("Finds a latePaymentRate by id")
    @GetMapping("id/{id}")
    public ResponseEntity<LatePaymentRateDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  latePaymentRate")
    @PostMapping("")
    public ResponseEntity<LatePaymentRateDto> save(@RequestBody LatePaymentRateDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  latePaymentRate")
    @PutMapping("")
    public ResponseEntity<LatePaymentRateDto> update(@RequestBody LatePaymentRateDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of latePaymentRate")
    @PostMapping("multiple")
    public ResponseEntity<List<LatePaymentRateDto>> delete(@RequestBody List<LatePaymentRateDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified latePaymentRate")
    @DeleteMapping("")
    public ResponseEntity<LatePaymentRateDto> delete(@RequestBody LatePaymentRateDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified latePaymentRate")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple latePaymentRates by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("Finds latePaymentRates by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<LatePaymentRateDto>> findByCriteria(@RequestBody LatePaymentRateCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated latePaymentRates by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody LatePaymentRateCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports latePaymentRates by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody LatePaymentRateCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets latePaymentRate data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody LatePaymentRateCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets latePaymentRate history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets latePaymentRate paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody LatePaymentRateHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports latePaymentRate history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody LatePaymentRateHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets latePaymentRate history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody LatePaymentRateHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public LatePaymentRateRestAdmin (LatePaymentRateAdminService service, LatePaymentRateConverter converter) {
        super(service, converter);
    }


}