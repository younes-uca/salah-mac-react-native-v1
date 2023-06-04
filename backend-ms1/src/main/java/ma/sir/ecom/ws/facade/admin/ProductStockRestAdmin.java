package  ma.sir.ecom.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.ecom.bean.core.ProductStock;
import ma.sir.ecom.bean.history.ProductStockHistory;
import ma.sir.ecom.dao.criteria.core.ProductStockCriteria;
import ma.sir.ecom.dao.criteria.history.ProductStockHistoryCriteria;
import ma.sir.ecom.service.facade.admin.ProductStockAdminService;
import ma.sir.ecom.ws.converter.ProductStockConverter;
import ma.sir.ecom.ws.dto.ProductStockDto;
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

@Api("Manages productStock services")
@RestController
@RequestMapping("/api/admin/productStock/")
public class ProductStockRestAdmin  extends AbstractController<ProductStock, ProductStockDto, ProductStockHistory, ProductStockCriteria, ProductStockHistoryCriteria, ProductStockAdminService, ProductStockConverter> {



    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody ProductStockDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one productStock")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple productStocks")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all productStocks")
    @GetMapping("")
    public ResponseEntity<List<ProductStockDto>> findAll() throws Exception {
        return super.findAll();
    }


    @ApiOperation("Finds a productStock by id")
    @GetMapping("id/{id}")
    public ResponseEntity<ProductStockDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  productStock")
    @PostMapping("")
    public ResponseEntity<ProductStockDto> save(@RequestBody ProductStockDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  productStock")
    @PutMapping("")
    public ResponseEntity<ProductStockDto> update(@RequestBody ProductStockDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of productStock")
    @PostMapping("multiple")
    public ResponseEntity<List<ProductStockDto>> delete(@RequestBody List<ProductStockDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified productStock")
    @DeleteMapping("")
    public ResponseEntity<ProductStockDto> delete(@RequestBody ProductStockDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified productStock")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple productStocks by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("find by shop id")
    @GetMapping("shop/id/{id}")
    public List<ProductStock> findByShopId(@PathVariable Long id){
        return service.findByShopId(id);
    }
    @ApiOperation("delete by shop id")
    @DeleteMapping("shop/id/{id}")
    public int deleteByShopId(@PathVariable Long id){
        return service.deleteByShopId(id);
    }
    @ApiOperation("find by product id")
    @GetMapping("product/id/{id}")
    public List<ProductStock> findByProductId(@PathVariable Long id){
        return service.findByProductId(id);
    }
    @ApiOperation("delete by product id")
    @DeleteMapping("product/id/{id}")
    public int deleteByProductId(@PathVariable Long id){
        return service.deleteByProductId(id);
    }
    @ApiOperation("Finds productStocks by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<ProductStockDto>> findByCriteria(@RequestBody ProductStockCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated productStocks by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody ProductStockCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports productStocks by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody ProductStockCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets productStock data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody ProductStockCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets productStock history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets productStock paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody ProductStockHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports productStock history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody ProductStockHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets productStock history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody ProductStockHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public ProductStockRestAdmin (ProductStockAdminService service, ProductStockConverter converter) {
        super(service, converter);
    }


}