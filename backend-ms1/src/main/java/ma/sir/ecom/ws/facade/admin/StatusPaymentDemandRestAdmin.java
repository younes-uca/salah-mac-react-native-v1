package  ma.sir.ecom.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.ecom.bean.core.StatusPaymentDemand;
import ma.sir.ecom.bean.history.StatusPaymentDemandHistory;
import ma.sir.ecom.dao.criteria.core.StatusPaymentDemandCriteria;
import ma.sir.ecom.dao.criteria.history.StatusPaymentDemandHistoryCriteria;
import ma.sir.ecom.service.facade.admin.StatusPaymentDemandAdminService;
import ma.sir.ecom.ws.converter.StatusPaymentDemandConverter;
import ma.sir.ecom.ws.dto.StatusPaymentDemandDto;
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

@Api("Manages statusPaymentDemand services")
@RestController
@RequestMapping("/api/admin/statusPaymentDemand/")
public class StatusPaymentDemandRestAdmin  extends AbstractController<StatusPaymentDemand, StatusPaymentDemandDto, StatusPaymentDemandHistory, StatusPaymentDemandCriteria, StatusPaymentDemandHistoryCriteria, StatusPaymentDemandAdminService, StatusPaymentDemandConverter> {



    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody StatusPaymentDemandDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one statusPaymentDemand")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple statusPaymentDemands")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all statusPaymentDemands")
    @GetMapping("")
    public ResponseEntity<List<StatusPaymentDemandDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all statusPaymentDemands")
    @GetMapping("optimized")
    public ResponseEntity<List<StatusPaymentDemandDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a statusPaymentDemand by id")
    @GetMapping("id/{id}")
    public ResponseEntity<StatusPaymentDemandDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  statusPaymentDemand")
    @PostMapping("")
    public ResponseEntity<StatusPaymentDemandDto> save(@RequestBody StatusPaymentDemandDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  statusPaymentDemand")
    @PutMapping("")
    public ResponseEntity<StatusPaymentDemandDto> update(@RequestBody StatusPaymentDemandDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of statusPaymentDemand")
    @PostMapping("multiple")
    public ResponseEntity<List<StatusPaymentDemandDto>> delete(@RequestBody List<StatusPaymentDemandDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified statusPaymentDemand")
    @DeleteMapping("")
    public ResponseEntity<StatusPaymentDemandDto> delete(@RequestBody StatusPaymentDemandDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified statusPaymentDemand")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple statusPaymentDemands by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("Finds statusPaymentDemands by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<StatusPaymentDemandDto>> findByCriteria(@RequestBody StatusPaymentDemandCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated statusPaymentDemands by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody StatusPaymentDemandCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports statusPaymentDemands by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody StatusPaymentDemandCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets statusPaymentDemand data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody StatusPaymentDemandCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets statusPaymentDemand history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets statusPaymentDemand paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody StatusPaymentDemandHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports statusPaymentDemand history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody StatusPaymentDemandHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets statusPaymentDemand history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody StatusPaymentDemandHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public StatusPaymentDemandRestAdmin (StatusPaymentDemandAdminService service, StatusPaymentDemandConverter converter) {
        super(service, converter);
    }


}