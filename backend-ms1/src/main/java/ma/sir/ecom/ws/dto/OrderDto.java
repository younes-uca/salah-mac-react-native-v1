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
public class OrderDto  extends AuditBaseDto {

    private String reference  ;
    private String orderDate ;
    private BigDecimal total  ;
    private BigDecimal totalPaid  ;
    private BigDecimal totalPaidCheck  ;
    private BigDecimal totalPaidCash  ;

    private ClientDto client ;
    private OrderStatusDto orderStatus ;

    private List<OrderItemDto> orderItems ;


    public OrderDto(){
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
    public String getOrderDate(){
        return this.orderDate;
    }
    public void setOrderDate(String orderDate){
        this.orderDate = orderDate;
    }

    @Log
    public BigDecimal getTotal(){
        return this.total;
    }
    public void setTotal(BigDecimal total){
        this.total = total;
    }

    @Log
    public BigDecimal getTotalPaid(){
        return this.totalPaid;
    }
    public void setTotalPaid(BigDecimal totalPaid){
        this.totalPaid = totalPaid;
    }

    @Log
    public BigDecimal getTotalPaidCheck(){
        return this.totalPaidCheck;
    }
    public void setTotalPaidCheck(BigDecimal totalPaidCheck){
        this.totalPaidCheck = totalPaidCheck;
    }

    @Log
    public BigDecimal getTotalPaidCash(){
        return this.totalPaidCash;
    }
    public void setTotalPaidCash(BigDecimal totalPaidCash){
        this.totalPaidCash = totalPaidCash;
    }


    public ClientDto getClient(){
        return this.client;
    }

    public void setClient(ClientDto client){
        this.client = client;
    }
    public OrderStatusDto getOrderStatus(){
        return this.orderStatus;
    }

    public void setOrderStatus(OrderStatusDto orderStatus){
        this.orderStatus = orderStatus;
    }



    public List<OrderItemDto> getOrderItems(){
        return this.orderItems;
    }

    public void setOrderItems(List<OrderItemDto> orderItems){
        this.orderItems = orderItems;
    }

}
