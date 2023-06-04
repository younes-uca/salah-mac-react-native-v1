package  ma.sir.ecom.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.ecom.bean.core.SupplierQuote;
import ma.sir.ecom.bean.history.SupplierQuoteHistory;
import ma.sir.ecom.dao.criteria.core.SupplierQuoteCriteria;
import ma.sir.ecom.dao.criteria.history.SupplierQuoteHistoryCriteria;
import ma.sir.ecom.service.facade.admin.SupplierQuoteAdminService;
import ma.sir.ecom.ws.converter.SupplierQuoteConverter;
import ma.sir.ecom.ws.dto.SupplierQuoteDto;
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

@Api("Manages supplierQuote services")
@RestController
@RequestMapping("/api/admin/supplierQuote/")
public class SupplierQuoteRestAdmin  extends AbstractController<SupplierQuote, SupplierQuoteDto, SupplierQuoteHistory, SupplierQuoteCriteria, SupplierQuoteHistoryCriteria, SupplierQuoteAdminService, SupplierQuoteConverter> {



    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody SupplierQuoteDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one supplierQuote")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple supplierQuotes")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all supplierQuotes")
    @GetMapping("")
    public ResponseEntity<List<SupplierQuoteDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all supplierQuotes")
    @GetMapping("optimized")
    public ResponseEntity<List<SupplierQuoteDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a supplierQuote by id")
    @GetMapping("id/{id}")
    public ResponseEntity<SupplierQuoteDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  supplierQuote")
    @PostMapping("")
    public ResponseEntity<SupplierQuoteDto> save(@RequestBody SupplierQuoteDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  supplierQuote")
    @PutMapping("")
    public ResponseEntity<SupplierQuoteDto> update(@RequestBody SupplierQuoteDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of supplierQuote")
    @PostMapping("multiple")
    public ResponseEntity<List<SupplierQuoteDto>> delete(@RequestBody List<SupplierQuoteDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified supplierQuote")
    @DeleteMapping("")
    public ResponseEntity<SupplierQuoteDto> delete(@RequestBody SupplierQuoteDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified supplierQuote")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple supplierQuotes by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("find by supplier id")
    @GetMapping("supplier/id/{id}")
    public List<SupplierQuote> findBySupplierId(@PathVariable Long id){
        return service.findBySupplierId(id);
    }
    @ApiOperation("delete by supplier id")
    @DeleteMapping("supplier/id/{id}")
    public int deleteBySupplierId(@PathVariable Long id){
        return service.deleteBySupplierId(id);
    }
    @ApiOperation("Finds a supplierQuote and associated list by id")
    @GetMapping("detail/id/{id}")
    public ResponseEntity<SupplierQuoteDto> findWithAssociatedLists(@PathVariable Long id) {
        return super.findWithAssociatedLists(id);
    }

    @ApiOperation("Finds supplierQuotes by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<SupplierQuoteDto>> findByCriteria(@RequestBody SupplierQuoteCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated supplierQuotes by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody SupplierQuoteCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports supplierQuotes by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody SupplierQuoteCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets supplierQuote data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody SupplierQuoteCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets supplierQuote history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets supplierQuote paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody SupplierQuoteHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports supplierQuote history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody SupplierQuoteHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets supplierQuote history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody SupplierQuoteHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public SupplierQuoteRestAdmin (SupplierQuoteAdminService service, SupplierQuoteConverter converter) {
        super(service, converter);
    }


}