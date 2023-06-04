package  ma.sir.ecom.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.ecom.bean.core.Company;
import ma.sir.ecom.bean.history.CompanyHistory;
import ma.sir.ecom.dao.criteria.core.CompanyCriteria;
import ma.sir.ecom.dao.criteria.history.CompanyHistoryCriteria;
import ma.sir.ecom.service.facade.admin.CompanyAdminService;
import ma.sir.ecom.ws.converter.CompanyConverter;
import ma.sir.ecom.ws.dto.CompanyDto;
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

@Api("Manages company services")
@RestController
@RequestMapping("/api/admin/company/")
public class CompanyRestAdmin  extends AbstractController<Company, CompanyDto, CompanyHistory, CompanyCriteria, CompanyHistoryCriteria, CompanyAdminService, CompanyConverter> {



    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody CompanyDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one company")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple companys")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all companys")
    @GetMapping("")
    public ResponseEntity<List<CompanyDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all companys")
    @GetMapping("optimized")
    public ResponseEntity<List<CompanyDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a company by id")
    @GetMapping("id/{id}")
    public ResponseEntity<CompanyDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  company")
    @PostMapping("")
    public ResponseEntity<CompanyDto> save(@RequestBody CompanyDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  company")
    @PutMapping("")
    public ResponseEntity<CompanyDto> update(@RequestBody CompanyDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of company")
    @PostMapping("multiple")
    public ResponseEntity<List<CompanyDto>> delete(@RequestBody List<CompanyDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified company")
    @DeleteMapping("")
    public ResponseEntity<CompanyDto> delete(@RequestBody CompanyDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified company")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple companys by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("find by subscriber id")
    @GetMapping("subscriber/id/{id}")
    public List<Company> findBySubscriberId(@PathVariable Long id){
        return service.findBySubscriberId(id);
    }
    @ApiOperation("delete by subscriber id")
    @DeleteMapping("subscriber/id/{id}")
    public int deleteBySubscriberId(@PathVariable Long id){
        return service.deleteBySubscriberId(id);
    }
    @ApiOperation("Finds a company and associated list by id")
    @GetMapping("detail/id/{id}")
    public ResponseEntity<CompanyDto> findWithAssociatedLists(@PathVariable Long id) {
        return super.findWithAssociatedLists(id);
    }

    @ApiOperation("Finds companys by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<CompanyDto>> findByCriteria(@RequestBody CompanyCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated companys by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody CompanyCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports companys by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody CompanyCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets company data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody CompanyCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets company history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets company paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody CompanyHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports company history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody CompanyHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets company history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody CompanyHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public CompanyRestAdmin (CompanyAdminService service, CompanyConverter converter) {
        super(service, converter);
    }


}