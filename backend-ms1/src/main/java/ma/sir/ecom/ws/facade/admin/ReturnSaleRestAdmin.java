package  ma.sir.ecom.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.ecom.bean.core.ReturnSale;
import ma.sir.ecom.bean.history.ReturnSaleHistory;
import ma.sir.ecom.dao.criteria.core.ReturnSaleCriteria;
import ma.sir.ecom.dao.criteria.history.ReturnSaleHistoryCriteria;
import ma.sir.ecom.service.facade.admin.ReturnSaleAdminService;
import ma.sir.ecom.ws.converter.ReturnSaleConverter;
import ma.sir.ecom.ws.dto.ReturnSaleDto;
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

@Api("Manages returnSale services")
@RestController
@RequestMapping("/api/admin/returnSale/")
public class ReturnSaleRestAdmin  extends AbstractController<ReturnSale, ReturnSaleDto, ReturnSaleHistory, ReturnSaleCriteria, ReturnSaleHistoryCriteria, ReturnSaleAdminService, ReturnSaleConverter> {



    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody ReturnSaleDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one returnSale")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple returnSales")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all returnSales")
    @GetMapping("")
    public ResponseEntity<List<ReturnSaleDto>> findAll() throws Exception {
        return super.findAll();
    }


    @ApiOperation("Finds a returnSale by id")
    @GetMapping("id/{id}")
    public ResponseEntity<ReturnSaleDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  returnSale")
    @PostMapping("")
    public ResponseEntity<ReturnSaleDto> save(@RequestBody ReturnSaleDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  returnSale")
    @PutMapping("")
    public ResponseEntity<ReturnSaleDto> update(@RequestBody ReturnSaleDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of returnSale")
    @PostMapping("multiple")
    public ResponseEntity<List<ReturnSaleDto>> delete(@RequestBody List<ReturnSaleDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified returnSale")
    @DeleteMapping("")
    public ResponseEntity<ReturnSaleDto> delete(@RequestBody ReturnSaleDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified returnSale")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple returnSales by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("find by sale id")
    @GetMapping("sale/id/{id}")
    public List<ReturnSale> findBySaleId(@PathVariable Long id){
        return service.findBySaleId(id);
    }
    @ApiOperation("delete by sale id")
    @DeleteMapping("sale/id/{id}")
    public int deleteBySaleId(@PathVariable Long id){
        return service.deleteBySaleId(id);
    }
    @ApiOperation("find by returnStatus id")
    @GetMapping("returnStatus/id/{id}")
    public List<ReturnSale> findByReturnStatusId(@PathVariable Long id){
        return service.findByReturnStatusId(id);
    }
    @ApiOperation("delete by returnStatus id")
    @DeleteMapping("returnStatus/id/{id}")
    public int deleteByReturnStatusId(@PathVariable Long id){
        return service.deleteByReturnStatusId(id);
    }
    @ApiOperation("Finds a returnSale and associated list by id")
    @GetMapping("detail/id/{id}")
    public ResponseEntity<ReturnSaleDto> findWithAssociatedLists(@PathVariable Long id) {
        return super.findWithAssociatedLists(id);
    }

    @ApiOperation("Finds returnSales by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<ReturnSaleDto>> findByCriteria(@RequestBody ReturnSaleCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated returnSales by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody ReturnSaleCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports returnSales by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody ReturnSaleCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets returnSale data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody ReturnSaleCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets returnSale history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets returnSale paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody ReturnSaleHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports returnSale history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody ReturnSaleHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets returnSale history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody ReturnSaleHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public ReturnSaleRestAdmin (ReturnSaleAdminService service, ReturnSaleConverter converter) {
        super(service, converter);
    }


}