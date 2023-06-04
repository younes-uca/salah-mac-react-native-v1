package  ma.sir.ecom.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.ecom.bean.core.SaleItem;
import ma.sir.ecom.bean.history.SaleItemHistory;
import ma.sir.ecom.dao.criteria.core.SaleItemCriteria;
import ma.sir.ecom.dao.criteria.history.SaleItemHistoryCriteria;
import ma.sir.ecom.service.facade.admin.SaleItemAdminService;
import ma.sir.ecom.ws.converter.SaleItemConverter;
import ma.sir.ecom.ws.dto.SaleItemDto;
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

@Api("Manages saleItem services")
@RestController
@RequestMapping("/api/admin/saleItem/")
public class SaleItemRestAdmin  extends AbstractController<SaleItem, SaleItemDto, SaleItemHistory, SaleItemCriteria, SaleItemHistoryCriteria, SaleItemAdminService, SaleItemConverter> {



    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody SaleItemDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one saleItem")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple saleItems")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all saleItems")
    @GetMapping("")
    public ResponseEntity<List<SaleItemDto>> findAll() throws Exception {
        return super.findAll();
    }


    @ApiOperation("Finds a saleItem by id")
    @GetMapping("id/{id}")
    public ResponseEntity<SaleItemDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  saleItem")
    @PostMapping("")
    public ResponseEntity<SaleItemDto> save(@RequestBody SaleItemDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  saleItem")
    @PutMapping("")
    public ResponseEntity<SaleItemDto> update(@RequestBody SaleItemDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of saleItem")
    @PostMapping("multiple")
    public ResponseEntity<List<SaleItemDto>> delete(@RequestBody List<SaleItemDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified saleItem")
    @DeleteMapping("")
    public ResponseEntity<SaleItemDto> delete(@RequestBody SaleItemDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified saleItem")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple saleItems by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("find by product id")
    @GetMapping("product/id/{id}")
    public List<SaleItem> findByProductId(@PathVariable Long id){
        return service.findByProductId(id);
    }
    @ApiOperation("delete by product id")
    @DeleteMapping("product/id/{id}")
    public int deleteByProductId(@PathVariable Long id){
        return service.deleteByProductId(id);
    }
    @ApiOperation("find by sale id")
    @GetMapping("sale/id/{id}")
    public List<SaleItem> findBySaleId(@PathVariable Long id){
        return service.findBySaleId(id);
    }
    @ApiOperation("delete by sale id")
    @DeleteMapping("sale/id/{id}")
    public int deleteBySaleId(@PathVariable Long id){
        return service.deleteBySaleId(id);
    }
    @ApiOperation("Finds saleItems by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<SaleItemDto>> findByCriteria(@RequestBody SaleItemCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated saleItems by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody SaleItemCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports saleItems by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody SaleItemCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets saleItem data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody SaleItemCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets saleItem history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets saleItem paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody SaleItemHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports saleItem history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody SaleItemHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets saleItem history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody SaleItemHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public SaleItemRestAdmin (SaleItemAdminService service, SaleItemConverter converter) {
        super(service, converter);
    }


}