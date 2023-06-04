package  ma.sir.ecom.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.ecom.bean.core.Bank;
import ma.sir.ecom.bean.history.BankHistory;
import ma.sir.ecom.dao.criteria.core.BankCriteria;
import ma.sir.ecom.dao.criteria.history.BankHistoryCriteria;
import ma.sir.ecom.service.facade.admin.BankAdminService;
import ma.sir.ecom.ws.converter.BankConverter;
import ma.sir.ecom.ws.dto.BankDto;
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

@Api("Manages bank services")
@RestController
@RequestMapping("/api/admin/bank/")
public class BankRestAdmin  extends AbstractController<Bank, BankDto, BankHistory, BankCriteria, BankHistoryCriteria, BankAdminService, BankConverter> {



    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody BankDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one bank")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple banks")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all banks")
    @GetMapping("")
    public ResponseEntity<List<BankDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all banks")
    @GetMapping("optimized")
    public ResponseEntity<List<BankDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a bank by id")
    @GetMapping("id/{id}")
    public ResponseEntity<BankDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  bank")
    @PostMapping("")
    public ResponseEntity<BankDto> save(@RequestBody BankDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  bank")
    @PutMapping("")
    public ResponseEntity<BankDto> update(@RequestBody BankDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of bank")
    @PostMapping("multiple")
    public ResponseEntity<List<BankDto>> delete(@RequestBody List<BankDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified bank")
    @DeleteMapping("")
    public ResponseEntity<BankDto> delete(@RequestBody BankDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified bank")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple banks by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("Finds banks by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<BankDto>> findByCriteria(@RequestBody BankCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated banks by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody BankCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports banks by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody BankCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets bank data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody BankCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets bank history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets bank paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody BankHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports bank history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody BankHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets bank history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody BankHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public BankRestAdmin (BankAdminService service, BankConverter converter) {
        super(service, converter);
    }


}