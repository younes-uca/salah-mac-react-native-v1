package  ma.sir.ecom.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.ecom.bean.core.DemandPayment;
import ma.sir.ecom.bean.history.DemandPaymentHistory;
import ma.sir.ecom.dao.criteria.core.DemandPaymentCriteria;
import ma.sir.ecom.dao.criteria.history.DemandPaymentHistoryCriteria;
import ma.sir.ecom.service.facade.admin.DemandPaymentAdminService;
import ma.sir.ecom.ws.converter.DemandPaymentConverter;
import ma.sir.ecom.ws.dto.DemandPaymentDto;
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

@Api("Manages demandPayment services")
@RestController
@RequestMapping("/api/admin/demandPayment/")
public class DemandPaymentRestAdmin  extends AbstractController<DemandPayment, DemandPaymentDto, DemandPaymentHistory, DemandPaymentCriteria, DemandPaymentHistoryCriteria, DemandPaymentAdminService, DemandPaymentConverter> {



    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody DemandPaymentDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one demandPayment")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple demandPayments")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all demandPayments")
    @GetMapping("")
    public ResponseEntity<List<DemandPaymentDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all demandPayments")
    @GetMapping("optimized")
    public ResponseEntity<List<DemandPaymentDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a demandPayment by id")
    @GetMapping("id/{id}")
    public ResponseEntity<DemandPaymentDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  demandPayment")
    @PostMapping("")
    public ResponseEntity<DemandPaymentDto> save(@RequestBody DemandPaymentDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  demandPayment")
    @PutMapping("")
    public ResponseEntity<DemandPaymentDto> update(@RequestBody DemandPaymentDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of demandPayment")
    @PostMapping("multiple")
    public ResponseEntity<List<DemandPaymentDto>> delete(@RequestBody List<DemandPaymentDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified demandPayment")
    @DeleteMapping("")
    public ResponseEntity<DemandPaymentDto> delete(@RequestBody DemandPaymentDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified demandPayment")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple demandPayments by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("find by demand id")
    @GetMapping("demand/id/{id}")
    public List<DemandPayment> findByDemandId(@PathVariable Long id){
        return service.findByDemandId(id);
    }
    @ApiOperation("delete by demand id")
    @DeleteMapping("demand/id/{id}")
    public int deleteByDemandId(@PathVariable Long id){
        return service.deleteByDemandId(id);
    }
    @ApiOperation("find by paymentMode id")
    @GetMapping("paymentMode/id/{id}")
    public List<DemandPayment> findByPaymentModeId(@PathVariable Long id){
        return service.findByPaymentModeId(id);
    }
    @ApiOperation("delete by paymentMode id")
    @DeleteMapping("paymentMode/id/{id}")
    public int deleteByPaymentModeId(@PathVariable Long id){
        return service.deleteByPaymentModeId(id);
    }
    @ApiOperation("find by statusPaymentDemand id")
    @GetMapping("statusPaymentDemand/id/{id}")
    public List<DemandPayment> findByStatusPaymentDemandId(@PathVariable Long id){
        return service.findByStatusPaymentDemandId(id);
    }
    @ApiOperation("delete by statusPaymentDemand id")
    @DeleteMapping("statusPaymentDemand/id/{id}")
    public int deleteByStatusPaymentDemandId(@PathVariable Long id){
        return service.deleteByStatusPaymentDemandId(id);
    }
    @ApiOperation("Finds demandPayments by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<DemandPaymentDto>> findByCriteria(@RequestBody DemandPaymentCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated demandPayments by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody DemandPaymentCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports demandPayments by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody DemandPaymentCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets demandPayment data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody DemandPaymentCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets demandPayment history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets demandPayment paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody DemandPaymentHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports demandPayment history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody DemandPaymentHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets demandPayment history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody DemandPaymentHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public DemandPaymentRestAdmin (DemandPaymentAdminService service, DemandPaymentConverter converter) {
        super(service, converter);
    }


}