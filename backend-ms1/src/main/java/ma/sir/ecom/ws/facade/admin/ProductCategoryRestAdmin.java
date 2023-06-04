package  ma.sir.ecom.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.ecom.bean.core.ProductCategory;
import ma.sir.ecom.bean.history.ProductCategoryHistory;
import ma.sir.ecom.dao.criteria.core.ProductCategoryCriteria;
import ma.sir.ecom.dao.criteria.history.ProductCategoryHistoryCriteria;
import ma.sir.ecom.service.facade.admin.ProductCategoryAdminService;
import ma.sir.ecom.ws.converter.ProductCategoryConverter;
import ma.sir.ecom.ws.dto.ProductCategoryDto;
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

@Api("Manages productCategory services")
@RestController
@RequestMapping("/api/admin/productCategory/")
public class ProductCategoryRestAdmin  extends AbstractController<ProductCategory, ProductCategoryDto, ProductCategoryHistory, ProductCategoryCriteria, ProductCategoryHistoryCriteria, ProductCategoryAdminService, ProductCategoryConverter> {



    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody ProductCategoryDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one productCategory")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple productCategorys")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all productCategorys")
    @GetMapping("")
    public ResponseEntity<List<ProductCategoryDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all productCategorys")
    @GetMapping("optimized")
    public ResponseEntity<List<ProductCategoryDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a productCategory by id")
    @GetMapping("id/{id}")
    public ResponseEntity<ProductCategoryDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  productCategory")
    @PostMapping("")
    public ResponseEntity<ProductCategoryDto> save(@RequestBody ProductCategoryDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  productCategory")
    @PutMapping("")
    public ResponseEntity<ProductCategoryDto> update(@RequestBody ProductCategoryDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of productCategory")
    @PostMapping("multiple")
    public ResponseEntity<List<ProductCategoryDto>> delete(@RequestBody List<ProductCategoryDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified productCategory")
    @DeleteMapping("")
    public ResponseEntity<ProductCategoryDto> delete(@RequestBody ProductCategoryDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified productCategory")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple productCategorys by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("Finds productCategorys by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<ProductCategoryDto>> findByCriteria(@RequestBody ProductCategoryCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated productCategorys by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody ProductCategoryCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports productCategorys by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody ProductCategoryCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets productCategory data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody ProductCategoryCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets productCategory history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets productCategory paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody ProductCategoryHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports productCategory history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody ProductCategoryHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets productCategory history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody ProductCategoryHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public ProductCategoryRestAdmin (ProductCategoryAdminService service, ProductCategoryConverter converter) {
        super(service, converter);
    }


}