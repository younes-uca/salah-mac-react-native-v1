package  ma.sir.ecom.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.ecom.bean.core.SupplierQuoteItem;
import ma.sir.ecom.bean.history.SupplierQuoteItemHistory;
import ma.sir.ecom.dao.criteria.core.SupplierQuoteItemCriteria;
import ma.sir.ecom.dao.criteria.history.SupplierQuoteItemHistoryCriteria;
import ma.sir.ecom.service.facade.admin.SupplierQuoteItemAdminService;
import ma.sir.ecom.ws.converter.SupplierQuoteItemConverter;
import ma.sir.ecom.ws.dto.SupplierQuoteItemDto;
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

@Api("Manages supplierQuoteItem services")
@RestController
@RequestMapping("/api/admin/supplierQuoteItem/")
public class SupplierQuoteItemRestAdmin  extends AbstractController<SupplierQuoteItem, SupplierQuoteItemDto, SupplierQuoteItemHistory, SupplierQuoteItemCriteria, SupplierQuoteItemHistoryCriteria, SupplierQuoteItemAdminService, SupplierQuoteItemConverter> {



    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody SupplierQuoteItemDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one supplierQuoteItem")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple supplierQuoteItems")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all supplierQuoteItems")
    @GetMapping("")
    public ResponseEntity<List<SupplierQuoteItemDto>> findAll() throws Exception {
        return super.findAll();
    }


    @ApiOperation("Finds a supplierQuoteItem by id")
    @GetMapping("id/{id}")
    public ResponseEntity<SupplierQuoteItemDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  supplierQuoteItem")
    @PostMapping("")
    public ResponseEntity<SupplierQuoteItemDto> save(@RequestBody SupplierQuoteItemDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  supplierQuoteItem")
    @PutMapping("")
    public ResponseEntity<SupplierQuoteItemDto> update(@RequestBody SupplierQuoteItemDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of supplierQuoteItem")
    @PostMapping("multiple")
    public ResponseEntity<List<SupplierQuoteItemDto>> delete(@RequestBody List<SupplierQuoteItemDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified supplierQuoteItem")
    @DeleteMapping("")
    public ResponseEntity<SupplierQuoteItemDto> delete(@RequestBody SupplierQuoteItemDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified supplierQuoteItem")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple supplierQuoteItems by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("find by product id")
    @GetMapping("product/id/{id}")
    public List<SupplierQuoteItem> findByProductId(@PathVariable Long id){
        return service.findByProductId(id);
    }
    @ApiOperation("delete by product id")
    @DeleteMapping("product/id/{id}")
    public int deleteByProductId(@PathVariable Long id){
        return service.deleteByProductId(id);
    }
    @ApiOperation("find by supplierQuote id")
    @GetMapping("supplierQuote/id/{id}")
    public List<SupplierQuoteItem> findBySupplierQuoteId(@PathVariable Long id){
        return service.findBySupplierQuoteId(id);
    }
    @ApiOperation("delete by supplierQuote id")
    @DeleteMapping("supplierQuote/id/{id}")
    public int deleteBySupplierQuoteId(@PathVariable Long id){
        return service.deleteBySupplierQuoteId(id);
    }
    @ApiOperation("Finds supplierQuoteItems by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<SupplierQuoteItemDto>> findByCriteria(@RequestBody SupplierQuoteItemCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated supplierQuoteItems by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody SupplierQuoteItemCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports supplierQuoteItems by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody SupplierQuoteItemCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets supplierQuoteItem data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody SupplierQuoteItemCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets supplierQuoteItem history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets supplierQuoteItem paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody SupplierQuoteItemHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports supplierQuoteItem history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody SupplierQuoteItemHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets supplierQuoteItem history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody SupplierQuoteItemHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public SupplierQuoteItemRestAdmin (SupplierQuoteItemAdminService service, SupplierQuoteItemConverter converter) {
        super(service, converter);
    }


}