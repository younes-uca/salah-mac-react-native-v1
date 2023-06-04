package  ma.sir.ecom.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.ecom.bean.core.Sale;
import ma.sir.ecom.bean.history.SaleHistory;
import ma.sir.ecom.dao.criteria.core.SaleCriteria;
import ma.sir.ecom.dao.criteria.history.SaleHistoryCriteria;
import ma.sir.ecom.service.facade.admin.SaleAdminService;
import ma.sir.ecom.ws.converter.SaleConverter;
import ma.sir.ecom.ws.dto.SaleDto;
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

@Api("Manages sale services")
@RestController
@RequestMapping("/api/admin/sale/")
public class SaleRestAdmin  extends AbstractController<Sale, SaleDto, SaleHistory, SaleCriteria, SaleHistoryCriteria, SaleAdminService, SaleConverter> {



    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody SaleDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one sale")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple sales")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all sales")
    @GetMapping("")
    public ResponseEntity<List<SaleDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all sales")
    @GetMapping("optimized")
    public ResponseEntity<List<SaleDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a sale by id")
    @GetMapping("id/{id}")
    public ResponseEntity<SaleDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  sale")
    @PostMapping("")
    public ResponseEntity<SaleDto> save(@RequestBody SaleDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  sale")
    @PutMapping("")
    public ResponseEntity<SaleDto> update(@RequestBody SaleDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of sale")
    @PostMapping("multiple")
    public ResponseEntity<List<SaleDto>> delete(@RequestBody List<SaleDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified sale")
    @DeleteMapping("")
    public ResponseEntity<SaleDto> delete(@RequestBody SaleDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified sale")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple sales by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("find by store id")
    @GetMapping("store/id/{id}")
    public List<Sale> findByStoreId(@PathVariable Long id){
        return service.findByStoreId(id);
    }
    @ApiOperation("delete by store id")
    @DeleteMapping("store/id/{id}")
    public int deleteByStoreId(@PathVariable Long id){
        return service.deleteByStoreId(id);
    }
    @ApiOperation("find by client id")
    @GetMapping("client/id/{id}")
    public List<Sale> findByClientId(@PathVariable Long id){
        return service.findByClientId(id);
    }
    @ApiOperation("delete by client id")
    @DeleteMapping("client/id/{id}")
    public int deleteByClientId(@PathVariable Long id){
        return service.deleteByClientId(id);
    }
    @ApiOperation("find by saleStatus id")
    @GetMapping("saleStatus/id/{id}")
    public List<Sale> findBySaleStatusId(@PathVariable Long id){
        return service.findBySaleStatusId(id);
    }
    @ApiOperation("delete by saleStatus id")
    @DeleteMapping("saleStatus/id/{id}")
    public int deleteBySaleStatusId(@PathVariable Long id){
        return service.deleteBySaleStatusId(id);
    }
    @ApiOperation("Finds a sale and associated list by id")
    @GetMapping("detail/id/{id}")
    public ResponseEntity<SaleDto> findWithAssociatedLists(@PathVariable Long id) {
        return super.findWithAssociatedLists(id);
    }

    @ApiOperation("Finds sales by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<SaleDto>> findByCriteria(@RequestBody SaleCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated sales by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody SaleCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports sales by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody SaleCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets sale data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody SaleCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets sale history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets sale paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody SaleHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports sale history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody SaleHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets sale history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody SaleHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public SaleRestAdmin (SaleAdminService service, SaleConverter converter) {
        super(service, converter);
    }


}