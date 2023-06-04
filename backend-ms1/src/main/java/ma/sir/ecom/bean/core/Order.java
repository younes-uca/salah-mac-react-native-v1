package ma.sir.ecom.bean.core;

import java.util.Objects;
import java.util.List;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;



import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.ecom.zynerator.audit.AuditBusinessObject;
import javax.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "order")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="order_seq",sequenceName="order_seq",allocationSize=1, initialValue = 1)
public class Order   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String reference;
    private LocalDateTime orderDate ;
    private BigDecimal total = BigDecimal.ZERO;
    private BigDecimal totalPaid = BigDecimal.ZERO;
    private BigDecimal totalPaidCheck = BigDecimal.ZERO;
    private BigDecimal totalPaidCash = BigDecimal.ZERO;

    private Client client ;
    
    private OrderStatus orderStatus ;
    

    private List<OrderItem> orderItems ;

    public Order(){
        super();
    }

    public Order(Long id,String reference){
        this.id = id;
        this.reference = reference ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="order_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getReference(){
        return this.reference;
    }
    public void setReference(String reference){
        this.reference = reference;
    }
    public LocalDateTime getOrderDate(){
        return this.orderDate;
    }
    public void setOrderDate(LocalDateTime orderDate){
        this.orderDate = orderDate;
    }
    public BigDecimal getTotal(){
        return this.total;
    }
    public void setTotal(BigDecimal total){
        this.total = total;
    }
    public BigDecimal getTotalPaid(){
        return this.totalPaid;
    }
    public void setTotalPaid(BigDecimal totalPaid){
        this.totalPaid = totalPaid;
    }
    public BigDecimal getTotalPaidCheck(){
        return this.totalPaidCheck;
    }
    public void setTotalPaidCheck(BigDecimal totalPaidCheck){
        this.totalPaidCheck = totalPaidCheck;
    }
    public BigDecimal getTotalPaidCash(){
        return this.totalPaidCash;
    }
    public void setTotalPaidCash(BigDecimal totalPaidCash){
        this.totalPaidCash = totalPaidCash;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Client getClient(){
        return this.client;
    }
    public void setClient(Client client){
        this.client = client;
    }
    @OneToMany(mappedBy = "order")
    public List<OrderItem> getOrderItems(){
        return this.orderItems;
    }
    public void setOrderItems(List<OrderItem> orderItems){
        this.orderItems = orderItems;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public OrderStatus getOrderStatus(){
        return this.orderStatus;
    }
    public void setOrderStatus(OrderStatus orderStatus){
        this.orderStatus = orderStatus;
    }

    @Transient
    public String getLabel() {
        label = reference;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id != null && id.equals(order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

