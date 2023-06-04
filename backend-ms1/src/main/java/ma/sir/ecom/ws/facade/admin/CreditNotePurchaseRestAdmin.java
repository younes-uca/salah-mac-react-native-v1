package  ma.sir.ecom.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.ecom.bean.core.CreditNotePurchase;
import ma.sir.ecom.bean.history.CreditNotePurchaseHistory;
import ma.sir.ecom.dao.criteria.core.CreditNotePurchaseCriteria;
import ma.sir.ecom.dao.criteria.history.CreditNotePurchaseHistoryCriteria;
import ma.sir.ecom.service.facade.admin.CreditNotePurchaseAdminService;
import ma.sir.ecom.ws.converter.CreditNotePurchaseConverter;
import ma.sir.ecom.ws.dto.CreditNotePurchaseDto;
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

@Api("Manages creditNotePurchase services")
@RestController
@RequestMapping("/api/admin/creditNotePurchase/")
public class CreditNotePurchaseRestAdmin  extends AbstractController<CreditNotePurchase, CreditNotePurchaseDto, CreditNotePurchaseHistory, CreditNotePurchaseCriteria, CreditNotePurchaseHistoryCriteria, CreditNotePurchaseAdminService, CreditNotePurchaseConverter> {



    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody CreditNotePurchaseDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one creditNotePurchase")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple creditNotePurchases")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all creditNotePurchases")
    @GetMapping("")
    public ResponseEntity<List<CreditNotePurchaseDto>> findAll() throws Exception {
        return super.findAll();
    }


    @ApiOperation("Finds a creditNotePurchase by id")
    @GetMapping("id/{id}")
    public ResponseEntity<CreditNotePurchaseDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  creditNotePurchase")
    @PostMapping("")
    public ResponseEntity<CreditNotePurchaseDto> save(@RequestBody CreditNotePurchaseDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  creditNotePurchase")
    @PutMapping("")
    public ResponseEntity<CreditNotePurchaseDto> update(@RequestBody CreditNotePurchaseDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of creditNotePurchase")
    @PostMapping("multiple")
    public ResponseEntity<List<CreditNotePurchaseDto>> delete(@RequestBody List<CreditNotePurchaseDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified creditNotePurchase")
    @DeleteMapping("")
    public ResponseEntity<CreditNotePurchaseDto> delete(@RequestBody CreditNotePurchaseDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified creditNotePurchase")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple creditNotePurchases by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("find by purchase id")
    @GetMapping("purchase/id/{id}")
    public List<CreditNotePurchase> findByPurchaseId(@PathVariable Long id){
        return service.findByPurchaseId(id);
    }
    @ApiOperation("delete by purchase id")
    @DeleteMapping("purchase/id/{id}")
    public int deleteByPurchaseId(@PathVariable Long id){
        return service.deleteByPurchaseId(id);
    }
    @ApiOperation("find by creditNotePurchaseStatus id")
    @GetMapping("creditNotePurchaseStatus/id/{id}")
    public List<CreditNotePurchase> findByCreditNotePurchaseStatusId(@PathVariable Long id){
        return service.findByCreditNotePurchaseStatusId(id);
    }
    @ApiOperation("delete by creditNotePurchaseStatus id")
    @DeleteMapping("creditNotePurchaseStatus/id/{id}")
    public int deleteByCreditNotePurchaseStatusId(@PathVariable Long id){
        return service.deleteByCreditNotePurchaseStatusId(id);
    }
    @ApiOperation("Finds a creditNotePurchase and associated list by id")
    @GetMapping("detail/id/{id}")
    public ResponseEntity<CreditNotePurchaseDto> findWithAssociatedLists(@PathVariable Long id) {
        return super.findWithAssociatedLists(id);
    }

    @ApiOperation("Finds creditNotePurchases by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<CreditNotePurchaseDto>> findByCriteria(@RequestBody CreditNotePurchaseCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated creditNotePurchases by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody CreditNotePurchaseCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports creditNotePurchases by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody CreditNotePurchaseCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets creditNotePurchase data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody CreditNotePurchaseCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets creditNotePurchase history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets creditNotePurchase paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody CreditNotePurchaseHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports creditNotePurchase history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody CreditNotePurchaseHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets creditNotePurchase history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody CreditNotePurchaseHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public CreditNotePurchaseRestAdmin (CreditNotePurchaseAdminService service, CreditNotePurchaseConverter converter) {
        super(service, converter);
    }


}