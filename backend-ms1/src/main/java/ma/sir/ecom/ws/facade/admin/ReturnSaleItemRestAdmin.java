package  ma.sir.ecom.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.ecom.bean.core.ReturnSaleItem;
import ma.sir.ecom.bean.history.ReturnSaleItemHistory;
import ma.sir.ecom.dao.criteria.core.ReturnSaleItemCriteria;
import ma.sir.ecom.dao.criteria.history.ReturnSaleItemHistoryCriteria;
import ma.sir.ecom.service.facade.admin.ReturnSaleItemAdminService;
import ma.sir.ecom.ws.converter.ReturnSaleItemConverter;
import ma.sir.ecom.ws.dto.ReturnSaleItemDto;
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

@Api("Manages returnSaleItem services")
@RestController
@RequestMapping("/api/admin/returnSaleItem/")
public class ReturnSaleItemRestAdmin  extends AbstractController<ReturnSaleItem, ReturnSaleItemDto, ReturnSaleItemHistory, ReturnSaleItemCriteria, ReturnSaleItemHistoryCriteria, ReturnSaleItemAdminService, ReturnSaleItemConverter> {



    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody ReturnSaleItemDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one returnSaleItem")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple returnSaleItems")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all returnSaleItems")
    @GetMapping("")
    public ResponseEntity<List<ReturnSaleItemDto>> findAll() throws Exception {
        return super.findAll();
    }


    @ApiOperation("Finds a returnSaleItem by id")
    @GetMapping("id/{id}")
    public ResponseEntity<ReturnSaleItemDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  returnSaleItem")
    @PostMapping("")
    public ResponseEntity<ReturnSaleItemDto> save(@RequestBody ReturnSaleItemDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  returnSaleItem")
    @PutMapping("")
    public ResponseEntity<ReturnSaleItemDto> update(@RequestBody ReturnSaleItemDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of returnSaleItem")
    @PostMapping("multiple")
    public ResponseEntity<List<ReturnSaleItemDto>> delete(@RequestBody List<ReturnSaleItemDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified returnSaleItem")
    @DeleteMapping("")
    public ResponseEntity<ReturnSaleItemDto> delete(@RequestBody ReturnSaleItemDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified returnSaleItem")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple returnSaleItems by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("find by product id")
    @GetMapping("product/id/{id}")
    public List<ReturnSaleItem> findByProductId(@PathVariable Long id){
        return service.findByProductId(id);
    }
    @ApiOperation("delete by product id")
    @DeleteMapping("product/id/{id}")
    public int deleteByProductId(@PathVariable Long id){
        return service.deleteByProductId(id);
    }
    @ApiOperation("find by returnSale id")
    @GetMapping("returnSale/id/{id}")
    public List<ReturnSaleItem> findByReturnSaleId(@PathVariable Long id){
        return service.findByReturnSaleId(id);
    }
    @ApiOperation("delete by returnSale id")
    @DeleteMapping("returnSale/id/{id}")
    public int deleteByReturnSaleId(@PathVariable Long id){
        return service.deleteByReturnSaleId(id);
    }
    @ApiOperation("Finds returnSaleItems by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<ReturnSaleItemDto>> findByCriteria(@RequestBody ReturnSaleItemCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated returnSaleItems by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody ReturnSaleItemCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports returnSaleItems by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody ReturnSaleItemCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets returnSaleItem data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody ReturnSaleItemCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets returnSaleItem history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets returnSaleItem paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody ReturnSaleItemHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports returnSaleItem history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody ReturnSaleItemHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets returnSaleItem history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody ReturnSaleItemHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public ReturnSaleItemRestAdmin (ReturnSaleItemAdminService service, ReturnSaleItemConverter converter) {
        super(service, converter);
    }


}