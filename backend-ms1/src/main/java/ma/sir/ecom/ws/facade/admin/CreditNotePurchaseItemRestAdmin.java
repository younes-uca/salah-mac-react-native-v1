package  ma.sir.ecom.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.ecom.bean.core.CreditNotePurchaseItem;
import ma.sir.ecom.bean.history.CreditNotePurchaseItemHistory;
import ma.sir.ecom.dao.criteria.core.CreditNotePurchaseItemCriteria;
import ma.sir.ecom.dao.criteria.history.CreditNotePurchaseItemHistoryCriteria;
import ma.sir.ecom.service.facade.admin.CreditNotePurchaseItemAdminService;
import ma.sir.ecom.ws.converter.CreditNotePurchaseItemConverter;
import ma.sir.ecom.ws.dto.CreditNotePurchaseItemDto;
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

@Api("Manages creditNotePurchaseItem services")
@RestController
@RequestMapping("/api/admin/creditNotePurchaseItem/")
public class CreditNotePurchaseItemRestAdmin  extends AbstractController<CreditNotePurchaseItem, CreditNotePurchaseItemDto, CreditNotePurchaseItemHistory, CreditNotePurchaseItemCriteria, CreditNotePurchaseItemHistoryCriteria, CreditNotePurchaseItemAdminService, CreditNotePurchaseItemConverter> {



    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody CreditNotePurchaseItemDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one creditNotePurchaseItem")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple creditNotePurchaseItems")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all creditNotePurchaseItems")
    @GetMapping("")
    public ResponseEntity<List<CreditNotePurchaseItemDto>> findAll() throws Exception {
        return super.findAll();
    }


    @ApiOperation("Finds a creditNotePurchaseItem by id")
    @GetMapping("id/{id}")
    public ResponseEntity<CreditNotePurchaseItemDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  creditNotePurchaseItem")
    @PostMapping("")
    public ResponseEntity<CreditNotePurchaseItemDto> save(@RequestBody CreditNotePurchaseItemDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  creditNotePurchaseItem")
    @PutMapping("")
    public ResponseEntity<CreditNotePurchaseItemDto> update(@RequestBody CreditNotePurchaseItemDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of creditNotePurchaseItem")
    @PostMapping("multiple")
    public ResponseEntity<List<CreditNotePurchaseItemDto>> delete(@RequestBody List<CreditNotePurchaseItemDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified creditNotePurchaseItem")
    @DeleteMapping("")
    public ResponseEntity<CreditNotePurchaseItemDto> delete(@RequestBody CreditNotePurchaseItemDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified creditNotePurchaseItem")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple creditNotePurchaseItems by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("find by product id")
    @GetMapping("product/id/{id}")
    public List<CreditNotePurchaseItem> findByProductId(@PathVariable Long id){
        return service.findByProductId(id);
    }
    @ApiOperation("delete by product id")
    @DeleteMapping("product/id/{id}")
    public int deleteByProductId(@PathVariable Long id){
        return service.deleteByProductId(id);
    }
    @ApiOperation("find by creditNotePurchase id")
    @GetMapping("creditNotePurchase/id/{id}")
    public List<CreditNotePurchaseItem> findByCreditNotePurchaseId(@PathVariable Long id){
        return service.findByCreditNotePurchaseId(id);
    }
    @ApiOperation("delete by creditNotePurchase id")
    @DeleteMapping("creditNotePurchase/id/{id}")
    public int deleteByCreditNotePurchaseId(@PathVariable Long id){
        return service.deleteByCreditNotePurchaseId(id);
    }
    @ApiOperation("Finds creditNotePurchaseItems by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<CreditNotePurchaseItemDto>> findByCriteria(@RequestBody CreditNotePurchaseItemCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated creditNotePurchaseItems by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody CreditNotePurchaseItemCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports creditNotePurchaseItems by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody CreditNotePurchaseItemCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets creditNotePurchaseItem data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody CreditNotePurchaseItemCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets creditNotePurchaseItem history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets creditNotePurchaseItem paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody CreditNotePurchaseItemHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports creditNotePurchaseItem history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody CreditNotePurchaseItemHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets creditNotePurchaseItem history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody CreditNotePurchaseItemHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public CreditNotePurchaseItemRestAdmin (CreditNotePurchaseItemAdminService service, CreditNotePurchaseItemConverter converter) {
        super(service, converter);
    }


}