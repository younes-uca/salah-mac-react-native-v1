package  ma.sir.ecom.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.ecom.bean.core.SubAccountingClass;
import ma.sir.ecom.bean.history.SubAccountingClassHistory;
import ma.sir.ecom.dao.criteria.core.SubAccountingClassCriteria;
import ma.sir.ecom.dao.criteria.history.SubAccountingClassHistoryCriteria;
import ma.sir.ecom.service.facade.admin.SubAccountingClassAdminService;
import ma.sir.ecom.ws.converter.SubAccountingClassConverter;
import ma.sir.ecom.ws.dto.SubAccountingClassDto;
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

@Api("Manages subAccountingClass services")
@RestController
@RequestMapping("/api/admin/subAccountingClass/")
public class SubAccountingClassRestAdmin  extends AbstractController<SubAccountingClass, SubAccountingClassDto, SubAccountingClassHistory, SubAccountingClassCriteria, SubAccountingClassHistoryCriteria, SubAccountingClassAdminService, SubAccountingClassConverter> {



    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody SubAccountingClassDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one subAccountingClass")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple subAccountingClasss")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all subAccountingClasss")
    @GetMapping("")
    public ResponseEntity<List<SubAccountingClassDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all subAccountingClasss")
    @GetMapping("optimized")
    public ResponseEntity<List<SubAccountingClassDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a subAccountingClass by id")
    @GetMapping("id/{id}")
    public ResponseEntity<SubAccountingClassDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  subAccountingClass")
    @PostMapping("")
    public ResponseEntity<SubAccountingClassDto> save(@RequestBody SubAccountingClassDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  subAccountingClass")
    @PutMapping("")
    public ResponseEntity<SubAccountingClassDto> update(@RequestBody SubAccountingClassDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of subAccountingClass")
    @PostMapping("multiple")
    public ResponseEntity<List<SubAccountingClassDto>> delete(@RequestBody List<SubAccountingClassDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified subAccountingClass")
    @DeleteMapping("")
    public ResponseEntity<SubAccountingClassDto> delete(@RequestBody SubAccountingClassDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified subAccountingClass")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple subAccountingClasss by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("find by accountingClass id")
    @GetMapping("accountingClass/id/{id}")
    public List<SubAccountingClass> findByAccountingClassId(@PathVariable Long id){
        return service.findByAccountingClassId(id);
    }
    @ApiOperation("delete by accountingClass id")
    @DeleteMapping("accountingClass/id/{id}")
    public int deleteByAccountingClassId(@PathVariable Long id){
        return service.deleteByAccountingClassId(id);
    }
    @ApiOperation("Finds subAccountingClasss by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<SubAccountingClassDto>> findByCriteria(@RequestBody SubAccountingClassCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated subAccountingClasss by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody SubAccountingClassCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports subAccountingClasss by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody SubAccountingClassCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets subAccountingClass data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody SubAccountingClassCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets subAccountingClass history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets subAccountingClass paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody SubAccountingClassHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports subAccountingClass history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody SubAccountingClassHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets subAccountingClass history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody SubAccountingClassHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public SubAccountingClassRestAdmin (SubAccountingClassAdminService service, SubAccountingClassConverter converter) {
        super(service, converter);
    }


}