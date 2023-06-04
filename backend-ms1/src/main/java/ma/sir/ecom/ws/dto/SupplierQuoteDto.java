package  ma.sir.ecom.ws.dto;

import ma.sir.ecom.zynerator.audit.Log;
import ma.sir.ecom.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class SupplierQuoteDto  extends AuditBaseDto {

    private String reference  ;
    private String quoteDate ;
    private BigDecimal total  ;
    private String description  ;

    private SupplierDto supplier ;

    private List<SupplierQuoteItemDto> supplierQuoteItems ;


    public SupplierQuoteDto(){
        super();
    }



    @Log
    public String getReference(){
        return this.reference;
    }
    public void setReference(String reference){
        this.reference = reference;
    }

    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getQuoteDate(){
        return this.quoteDate;
    }
    public void setQuoteDate(String quoteDate){
        this.quoteDate = quoteDate;
    }

    @Log
    public BigDecimal getTotal(){
        return this.total;
    }
    public void setTotal(BigDecimal total){
        this.total = total;
    }

    @Log
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }


    public SupplierDto getSupplier(){
        return this.supplier;
    }

    public void setSupplier(SupplierDto supplier){
        this.supplier = supplier;
    }



    public List<SupplierQuoteItemDto> getSupplierQuoteItems(){
        return this.supplierQuoteItems;
    }

    public void setSupplierQuoteItems(List<SupplierQuoteItemDto> supplierQuoteItems){
        this.supplierQuoteItems = supplierQuoteItems;
    }

}
