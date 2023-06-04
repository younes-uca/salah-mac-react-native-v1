package  ma.sir.ecom.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.ecom.bean.core.Shop;
import ma.sir.ecom.bean.history.ShopHistory;
import ma.sir.ecom.dao.criteria.core.ShopCriteria;
import ma.sir.ecom.dao.criteria.history.ShopHistoryCriteria;
import ma.sir.ecom.service.facade.admin.ShopAdminService;
import ma.sir.ecom.ws.converter.ShopConverter;
import ma.sir.ecom.ws.dto.ShopDto;
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

@Api("Manages shop services")
@RestController
@RequestMapping("/api/admin/shop/")
public class ShopRestAdmin  extends AbstractController<Shop, ShopDto, ShopHistory, ShopCriteria, ShopHistoryCriteria, ShopAdminService, ShopConverter> {



    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody ShopDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one shop")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple shops")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all shops")
    @GetMapping("")
    public ResponseEntity<List<ShopDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all shops")
    @GetMapping("optimized")
    public ResponseEntity<List<ShopDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a shop by id")
    @GetMapping("id/{id}")
    public ResponseEntity<ShopDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  shop")
    @PostMapping("")
    public ResponseEntity<ShopDto> save(@RequestBody ShopDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  shop")
    @PutMapping("")
    public ResponseEntity<ShopDto> update(@RequestBody ShopDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of shop")
    @PostMapping("multiple")
    public ResponseEntity<List<ShopDto>> delete(@RequestBody List<ShopDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified shop")
    @DeleteMapping("")
    public ResponseEntity<ShopDto> delete(@RequestBody ShopDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified shop")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple shops by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("find by store id")
    @GetMapping("store/id/{id}")
    public List<Shop> findByStoreId(@PathVariable Long id){
        return service.findByStoreId(id);
    }
    @ApiOperation("delete by store id")
    @DeleteMapping("store/id/{id}")
    public int deleteByStoreId(@PathVariable Long id){
        return service.deleteByStoreId(id);
    }
    @ApiOperation("Finds shops by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<ShopDto>> findByCriteria(@RequestBody ShopCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated shops by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody ShopCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports shops by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody ShopCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets shop data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody ShopCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets shop history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets shop paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody ShopHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports shop history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody ShopHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets shop history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody ShopHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public ShopRestAdmin (ShopAdminService service, ShopConverter converter) {
        super(service, converter);
    }


}