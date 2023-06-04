package  ma.sir.ecom.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.ecom.bean.core.BankCheckOwner;
import ma.sir.ecom.bean.history.BankCheckOwnerHistory;
import ma.sir.ecom.dao.criteria.core.BankCheckOwnerCriteria;
import ma.sir.ecom.dao.criteria.history.BankCheckOwnerHistoryCriteria;
import ma.sir.ecom.service.facade.admin.BankCheckOwnerAdminService;
import ma.sir.ecom.ws.converter.BankCheckOwnerConverter;
import ma.sir.ecom.ws.dto.BankCheckOwnerDto;
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

@Api("Manages bankCheckOwner services")
@RestController
@RequestMapping("/api/admin/bankCheckOwner/")
public class BankCheckOwnerRestAdmin  extends AbstractController<BankCheckOwner, BankCheckOwnerDto, BankCheckOwnerHistory, BankCheckOwnerCriteria, BankCheckOwnerHistoryCriteria, BankCheckOwnerAdminService, BankCheckOwnerConverter> {



    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody BankCheckOwnerDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one bankCheckOwner")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple bankCheckOwners")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all bankCheckOwners")
    @GetMapping("")
    public ResponseEntity<List<BankCheckOwnerDto>> findAll() throws Exception {
        return super.findAll();
    }


    @ApiOperation("Finds a bankCheckOwner by id")
    @GetMapping("id/{id}")
    public ResponseEntity<BankCheckOwnerDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  bankCheckOwner")
    @PostMapping("")
    public ResponseEntity<BankCheckOwnerDto> save(@RequestBody BankCheckOwnerDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  bankCheckOwner")
    @PutMapping("")
    public ResponseEntity<BankCheckOwnerDto> update(@RequestBody BankCheckOwnerDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of bankCheckOwner")
    @PostMapping("multiple")
    public ResponseEntity<List<BankCheckOwnerDto>> delete(@RequestBody List<BankCheckOwnerDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified bankCheckOwner")
    @DeleteMapping("")
    public ResponseEntity<BankCheckOwnerDto> delete(@RequestBody BankCheckOwnerDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified bankCheckOwner")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple bankCheckOwners by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("find by checkOwner id")
    @GetMapping("checkOwner/id/{id}")
    public List<BankCheckOwner> findByCheckOwnerId(@PathVariable Long id){
        return service.findByCheckOwnerId(id);
    }
    @ApiOperation("delete by checkOwner id")
    @DeleteMapping("checkOwner/id/{id}")
    public int deleteByCheckOwnerId(@PathVariable Long id){
        return service.deleteByCheckOwnerId(id);
    }
    @ApiOperation("find by bank id")
    @GetMapping("bank/id/{id}")
    public List<BankCheckOwner> findByBankId(@PathVariable Long id){
        return service.findByBankId(id);
    }
    @ApiOperation("delete by bank id")
    @DeleteMapping("bank/id/{id}")
    public int deleteByBankId(@PathVariable Long id){
        return service.deleteByBankId(id);
    }
    @ApiOperation("Finds bankCheckOwners by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<BankCheckOwnerDto>> findByCriteria(@RequestBody BankCheckOwnerCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated bankCheckOwners by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody BankCheckOwnerCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports bankCheckOwners by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody BankCheckOwnerCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets bankCheckOwner data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody BankCheckOwnerCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets bankCheckOwner history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets bankCheckOwner paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody BankCheckOwnerHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports bankCheckOwner history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody BankCheckOwnerHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets bankCheckOwner history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody BankCheckOwnerHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public BankCheckOwnerRestAdmin (BankCheckOwnerAdminService service, BankCheckOwnerConverter converter) {
        super(service, converter);
    }


}