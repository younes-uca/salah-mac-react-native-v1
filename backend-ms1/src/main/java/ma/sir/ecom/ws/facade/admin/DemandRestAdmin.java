package  ma.sir.ecom.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.ecom.bean.core.Demand;
import ma.sir.ecom.bean.history.DemandHistory;
import ma.sir.ecom.dao.criteria.core.DemandCriteria;
import ma.sir.ecom.dao.criteria.history.DemandHistoryCriteria;
import ma.sir.ecom.service.facade.admin.DemandAdminService;
import ma.sir.ecom.ws.converter.DemandConverter;
import ma.sir.ecom.ws.dto.DemandDto;
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

@Api("Manages demand services")
@RestController
@RequestMapping("/api/admin/demand/")
public class DemandRestAdmin  extends AbstractController<Demand, DemandDto, DemandHistory, DemandCriteria, DemandHistoryCriteria, DemandAdminService, DemandConverter> {



    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody DemandDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one demand")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple demands")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all demands")
    @GetMapping("")
    public ResponseEntity<List<DemandDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all demands")
    @GetMapping("optimized")
    public ResponseEntity<List<DemandDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a demand by id")
    @GetMapping("id/{id}")
    public ResponseEntity<DemandDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  demand")
    @PostMapping("")
    public ResponseEntity<DemandDto> save(@RequestBody DemandDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  demand")
    @PutMapping("")
    public ResponseEntity<DemandDto> update(@RequestBody DemandDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of demand")
    @PostMapping("multiple")
    public ResponseEntity<List<DemandDto>> delete(@RequestBody List<DemandDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified demand")
    @DeleteMapping("")
    public ResponseEntity<DemandDto> delete(@RequestBody DemandDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified demand")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple demands by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("find by client id")
    @GetMapping("client/id/{id}")
    public List<Demand> findByClientId(@PathVariable Long id){
        return service.findByClientId(id);
    }
    @ApiOperation("delete by client id")
    @DeleteMapping("client/id/{id}")
    public int deleteByClientId(@PathVariable Long id){
        return service.deleteByClientId(id);
    }
    @ApiOperation("find by demandStatus id")
    @GetMapping("demandStatus/id/{id}")
    public List<Demand> findByDemandStatusId(@PathVariable Long id){
        return service.findByDemandStatusId(id);
    }
    @ApiOperation("delete by demandStatus id")
    @DeleteMapping("demandStatus/id/{id}")
    public int deleteByDemandStatusId(@PathVariable Long id){
        return service.deleteByDemandStatusId(id);
    }
    @ApiOperation("Finds a demand and associated list by id")
    @GetMapping("detail/id/{id}")
    public ResponseEntity<DemandDto> findWithAssociatedLists(@PathVariable Long id) {
        return super.findWithAssociatedLists(id);
    }

    @ApiOperation("Finds demands by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<DemandDto>> findByCriteria(@RequestBody DemandCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated demands by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody DemandCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports demands by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody DemandCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets demand data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody DemandCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets demand history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets demand paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody DemandHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports demand history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody DemandHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets demand history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody DemandHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public DemandRestAdmin (DemandAdminService service, DemandConverter converter) {
        super(service, converter);
    }


}