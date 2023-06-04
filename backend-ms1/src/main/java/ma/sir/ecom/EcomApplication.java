package  ma.sir.ecom;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import java.util.*;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import org.springframework.cache.annotation.EnableCaching;


import ma.sir.ecom.bean.core.*;
import ma.sir.ecom.service.facade.admin.*;

import ma.sir.ecom.zynerator.security.common.AuthoritiesConstants;
import ma.sir.ecom.zynerator.security.bean.User;
import ma.sir.ecom.zynerator.security.bean.Permission;
import ma.sir.ecom.zynerator.security.bean.Role;
import ma.sir.ecom.zynerator.security.service.facade.UserService;
import ma.sir.ecom.zynerator.security.service.facade.RoleService;


import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableCaching
//@EnableFeignClients("ma.sir.ecom.required.facade")
public class EcomApplication {
    public static ConfigurableApplicationContext ctx;

    public static void main(String[] args) {
        ctx=SpringApplication.run(EcomApplication.class, args);
    }


    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
    @Autowired
    private ObjectMapper objectMapper;

    @Bean
    ObjectMapper objectMapper(){
        return new ObjectMapper();
    }
    public static ConfigurableApplicationContext getCtx() {
        return ctx;
    }

    @Bean
    public CommandLineRunner demo(UserService userService, RoleService roleService) {
    return (args) -> {
        if(true){



    // Role admin

        User userForAdmin = new User("admin");

        Role roleForAdmin = new Role();
        roleForAdmin.setAuthority(AuthoritiesConstants.ADMIN);
        List<Permission> permissionsForAdmin = new ArrayList<>();
        addPermissionForAdmin(permissionsForAdmin);
        roleForAdmin.setPermissions(permissionsForAdmin);
        if(userForAdmin.getRoles()==null)
            userForAdmin.setRoles(new ArrayList<>());

        userForAdmin.getRoles().add(roleForAdmin);
        userService.save(userForAdmin);
            }
        };
    }




    private static String fakeString(String attributeName, int i) {
        return attributeName + i;
    }

    private static Long fakeLong(String attributeName, int i) {
        return  10L * i;
    }
    private static Integer fakeInteger(String attributeName, int i) {
        return  10 * i;
    }

    private static Double fakeDouble(String attributeName, int i) {
        return 10D * i;
    }

    private static BigDecimal fakeBigDecimal(String attributeName, int i) {
        return  BigDecimal.valueOf(i*1L*10);
    }

    private static Boolean fakeBoolean(String attributeName, int i) {
        return i % 2 == 0 ? true : false;
    }
    private static LocalDateTime fakeLocalDateTime(String attributeName, int i) {
        return LocalDateTime.now().plusDays(i);
    }
    private static void addPermissionForAdmin(List<Permission> permissions){
        permissions.add(new Permission("CorporateTaxRate.edit"));
        permissions.add(new Permission("CorporateTaxRate.list"));
        permissions.add(new Permission("CorporateTaxRate.view"));
        permissions.add(new Permission("CorporateTaxRate.add"));
        permissions.add(new Permission("CorporateTaxRate.delete"));
        permissions.add(new Permission("AccountingOperation.edit"));
        permissions.add(new Permission("AccountingOperation.list"));
        permissions.add(new Permission("AccountingOperation.view"));
        permissions.add(new Permission("AccountingOperation.add"));
        permissions.add(new Permission("AccountingOperation.delete"));
        permissions.add(new Permission("ReturnStatus.edit"));
        permissions.add(new Permission("ReturnStatus.list"));
        permissions.add(new Permission("ReturnStatus.view"));
        permissions.add(new Permission("ReturnStatus.add"));
        permissions.add(new Permission("ReturnStatus.delete"));
        permissions.add(new Permission("Brand.edit"));
        permissions.add(new Permission("Brand.list"));
        permissions.add(new Permission("Brand.view"));
        permissions.add(new Permission("Brand.add"));
        permissions.add(new Permission("Brand.delete"));
        permissions.add(new Permission("Purchase.edit"));
        permissions.add(new Permission("Purchase.list"));
        permissions.add(new Permission("Purchase.view"));
        permissions.add(new Permission("Purchase.add"));
        permissions.add(new Permission("Purchase.delete"));
        permissions.add(new Permission("SupplierQuoteItem.edit"));
        permissions.add(new Permission("SupplierQuoteItem.list"));
        permissions.add(new Permission("SupplierQuoteItem.view"));
        permissions.add(new Permission("SupplierQuoteItem.add"));
        permissions.add(new Permission("SupplierQuoteItem.delete"));
        permissions.add(new Permission("SaleItem.edit"));
        permissions.add(new Permission("SaleItem.list"));
        permissions.add(new Permission("SaleItem.view"));
        permissions.add(new Permission("SaleItem.add"));
        permissions.add(new Permission("SaleItem.delete"));
        permissions.add(new Permission("MeasurementUnit.edit"));
        permissions.add(new Permission("MeasurementUnit.list"));
        permissions.add(new Permission("MeasurementUnit.view"));
        permissions.add(new Permission("MeasurementUnit.add"));
        permissions.add(new Permission("MeasurementUnit.delete"));
        permissions.add(new Permission("PaymentDeliveryStatus.edit"));
        permissions.add(new Permission("PaymentDeliveryStatus.list"));
        permissions.add(new Permission("PaymentDeliveryStatus.view"));
        permissions.add(new Permission("PaymentDeliveryStatus.add"));
        permissions.add(new Permission("PaymentDeliveryStatus.delete"));
        permissions.add(new Permission("CreditNotePurchaseItem.edit"));
        permissions.add(new Permission("CreditNotePurchaseItem.list"));
        permissions.add(new Permission("CreditNotePurchaseItem.view"));
        permissions.add(new Permission("CreditNotePurchaseItem.add"));
        permissions.add(new Permission("CreditNotePurchaseItem.delete"));
        permissions.add(new Permission("DemandStatus.edit"));
        permissions.add(new Permission("DemandStatus.list"));
        permissions.add(new Permission("DemandStatus.view"));
        permissions.add(new Permission("DemandStatus.add"));
        permissions.add(new Permission("DemandStatus.delete"));
        permissions.add(new Permission("PurchasePaymentStatus.edit"));
        permissions.add(new Permission("PurchasePaymentStatus.list"));
        permissions.add(new Permission("PurchasePaymentStatus.view"));
        permissions.add(new Permission("PurchasePaymentStatus.add"));
        permissions.add(new Permission("PurchasePaymentStatus.delete"));
        permissions.add(new Permission("BalanceSheetStatus.edit"));
        permissions.add(new Permission("BalanceSheetStatus.list"));
        permissions.add(new Permission("BalanceSheetStatus.view"));
        permissions.add(new Permission("BalanceSheetStatus.add"));
        permissions.add(new Permission("BalanceSheetStatus.delete"));
        permissions.add(new Permission("ValidationAccountant.edit"));
        permissions.add(new Permission("ValidationAccountant.list"));
        permissions.add(new Permission("ValidationAccountant.view"));
        permissions.add(new Permission("ValidationAccountant.add"));
        permissions.add(new Permission("ValidationAccountant.delete"));
        permissions.add(new Permission("Product.edit"));
        permissions.add(new Permission("Product.list"));
        permissions.add(new Permission("Product.view"));
        permissions.add(new Permission("Product.add"));
        permissions.add(new Permission("Product.delete"));
        permissions.add(new Permission("ProductStock.edit"));
        permissions.add(new Permission("ProductStock.list"));
        permissions.add(new Permission("ProductStock.view"));
        permissions.add(new Permission("ProductStock.add"));
        permissions.add(new Permission("ProductStock.delete"));
        permissions.add(new Permission("ReceptionStatus.edit"));
        permissions.add(new Permission("ReceptionStatus.list"));
        permissions.add(new Permission("ReceptionStatus.view"));
        permissions.add(new Permission("ReceptionStatus.add"));
        permissions.add(new Permission("ReceptionStatus.delete"));
        permissions.add(new Permission("DeliveryStatus.edit"));
        permissions.add(new Permission("DeliveryStatus.list"));
        permissions.add(new Permission("DeliveryStatus.view"));
        permissions.add(new Permission("DeliveryStatus.add"));
        permissions.add(new Permission("DeliveryStatus.delete"));
        permissions.add(new Permission("HandlingAccountant.edit"));
        permissions.add(new Permission("HandlingAccountant.list"));
        permissions.add(new Permission("HandlingAccountant.view"));
        permissions.add(new Permission("HandlingAccountant.add"));
        permissions.add(new Permission("HandlingAccountant.delete"));
        permissions.add(new Permission("CheckOwner.edit"));
        permissions.add(new Permission("CheckOwner.list"));
        permissions.add(new Permission("CheckOwner.view"));
        permissions.add(new Permission("CheckOwner.add"));
        permissions.add(new Permission("CheckOwner.delete"));
        permissions.add(new Permission("BalanceSheet.edit"));
        permissions.add(new Permission("BalanceSheet.list"));
        permissions.add(new Permission("BalanceSheet.view"));
        permissions.add(new Permission("BalanceSheet.add"));
        permissions.add(new Permission("BalanceSheet.delete"));
        permissions.add(new Permission("PurchaseStatus.edit"));
        permissions.add(new Permission("PurchaseStatus.list"));
        permissions.add(new Permission("PurchaseStatus.view"));
        permissions.add(new Permission("PurchaseStatus.add"));
        permissions.add(new Permission("PurchaseStatus.delete"));
        permissions.add(new Permission("SaleStatus.edit"));
        permissions.add(new Permission("SaleStatus.list"));
        permissions.add(new Permission("SaleStatus.view"));
        permissions.add(new Permission("SaleStatus.add"));
        permissions.add(new Permission("SaleStatus.delete"));
        permissions.add(new Permission("Order.edit"));
        permissions.add(new Permission("Order.list"));
        permissions.add(new Permission("Order.view"));
        permissions.add(new Permission("Order.add"));
        permissions.add(new Permission("Order.delete"));
        permissions.add(new Permission("Supplier.edit"));
        permissions.add(new Permission("Supplier.list"));
        permissions.add(new Permission("Supplier.view"));
        permissions.add(new Permission("Supplier.add"));
        permissions.add(new Permission("Supplier.delete"));
        permissions.add(new Permission("Reception.edit"));
        permissions.add(new Permission("Reception.list"));
        permissions.add(new Permission("Reception.view"));
        permissions.add(new Permission("Reception.add"));
        permissions.add(new Permission("Reception.delete"));
        permissions.add(new Permission("AccountingOperationStatus.edit"));
        permissions.add(new Permission("AccountingOperationStatus.list"));
        permissions.add(new Permission("AccountingOperationStatus.view"));
        permissions.add(new Permission("AccountingOperationStatus.add"));
        permissions.add(new Permission("AccountingOperationStatus.delete"));
        permissions.add(new Permission("LatePaymentRate.edit"));
        permissions.add(new Permission("LatePaymentRate.list"));
        permissions.add(new Permission("LatePaymentRate.view"));
        permissions.add(new Permission("LatePaymentRate.add"));
        permissions.add(new Permission("LatePaymentRate.delete"));
        permissions.add(new Permission("OrderStatus.edit"));
        permissions.add(new Permission("OrderStatus.list"));
        permissions.add(new Permission("OrderStatus.view"));
        permissions.add(new Permission("OrderStatus.add"));
        permissions.add(new Permission("OrderStatus.delete"));
        permissions.add(new Permission("PaymentSale.edit"));
        permissions.add(new Permission("PaymentSale.list"));
        permissions.add(new Permission("PaymentSale.view"));
        permissions.add(new Permission("PaymentSale.add"));
        permissions.add(new Permission("PaymentSale.delete"));
        permissions.add(new Permission("AccountingAccount.edit"));
        permissions.add(new Permission("AccountingAccount.list"));
        permissions.add(new Permission("AccountingAccount.view"));
        permissions.add(new Permission("AccountingAccount.add"));
        permissions.add(new Permission("AccountingAccount.delete"));
        permissions.add(new Permission("DemandItem.edit"));
        permissions.add(new Permission("DemandItem.list"));
        permissions.add(new Permission("DemandItem.view"));
        permissions.add(new Permission("DemandItem.add"));
        permissions.add(new Permission("DemandItem.delete"));
        permissions.add(new Permission("OrderItem.edit"));
        permissions.add(new Permission("OrderItem.list"));
        permissions.add(new Permission("OrderItem.view"));
        permissions.add(new Permission("OrderItem.add"));
        permissions.add(new Permission("OrderItem.delete"));
        permissions.add(new Permission("PaymentStatus.edit"));
        permissions.add(new Permission("PaymentStatus.list"));
        permissions.add(new Permission("PaymentStatus.view"));
        permissions.add(new Permission("PaymentStatus.add"));
        permissions.add(new Permission("PaymentStatus.delete"));
        permissions.add(new Permission("BankCheckOwner.edit"));
        permissions.add(new Permission("BankCheckOwner.list"));
        permissions.add(new Permission("BankCheckOwner.view"));
        permissions.add(new Permission("BankCheckOwner.add"));
        permissions.add(new Permission("BankCheckOwner.delete"));
        permissions.add(new Permission("DeliveryItem.edit"));
        permissions.add(new Permission("DeliveryItem.list"));
        permissions.add(new Permission("DeliveryItem.view"));
        permissions.add(new Permission("DeliveryItem.add"));
        permissions.add(new Permission("DeliveryItem.delete"));
        permissions.add(new Permission("SubAccountingClass.edit"));
        permissions.add(new Permission("SubAccountingClass.list"));
        permissions.add(new Permission("SubAccountingClass.view"));
        permissions.add(new Permission("SubAccountingClass.add"));
        permissions.add(new Permission("SubAccountingClass.delete"));
        permissions.add(new Permission("ReceptionItem.edit"));
        permissions.add(new Permission("ReceptionItem.list"));
        permissions.add(new Permission("ReceptionItem.view"));
        permissions.add(new Permission("ReceptionItem.add"));
        permissions.add(new Permission("ReceptionItem.delete"));
        permissions.add(new Permission("OrderStatusOrder.edit"));
        permissions.add(new Permission("OrderStatusOrder.list"));
        permissions.add(new Permission("OrderStatusOrder.view"));
        permissions.add(new Permission("OrderStatusOrder.add"));
        permissions.add(new Permission("OrderStatusOrder.delete"));
        permissions.add(new Permission("ProductCategory.edit"));
        permissions.add(new Permission("ProductCategory.list"));
        permissions.add(new Permission("ProductCategory.view"));
        permissions.add(new Permission("ProductCategory.add"));
        permissions.add(new Permission("ProductCategory.delete"));
        permissions.add(new Permission("VatDeclaration.edit"));
        permissions.add(new Permission("VatDeclaration.list"));
        permissions.add(new Permission("VatDeclaration.view"));
        permissions.add(new Permission("VatDeclaration.add"));
        permissions.add(new Permission("VatDeclaration.delete"));
        permissions.add(new Permission("CreditNotePurchase.edit"));
        permissions.add(new Permission("CreditNotePurchase.list"));
        permissions.add(new Permission("CreditNotePurchase.view"));
        permissions.add(new Permission("CreditNotePurchase.add"));
        permissions.add(new Permission("CreditNotePurchase.delete"));
        permissions.add(new Permission("Bank.edit"));
        permissions.add(new Permission("Bank.list"));
        permissions.add(new Permission("Bank.view"));
        permissions.add(new Permission("Bank.add"));
        permissions.add(new Permission("Bank.delete"));
        permissions.add(new Permission("PaymentMode.edit"));
        permissions.add(new Permission("PaymentMode.list"));
        permissions.add(new Permission("PaymentMode.view"));
        permissions.add(new Permission("PaymentMode.add"));
        permissions.add(new Permission("PaymentMode.delete"));
        permissions.add(new Permission("Subscriber.edit"));
        permissions.add(new Permission("Subscriber.list"));
        permissions.add(new Permission("Subscriber.view"));
        permissions.add(new Permission("Subscriber.add"));
        permissions.add(new Permission("Subscriber.delete"));
        permissions.add(new Permission("SupplierQuote.edit"));
        permissions.add(new Permission("SupplierQuote.list"));
        permissions.add(new Permission("SupplierQuote.view"));
        permissions.add(new Permission("SupplierQuote.add"));
        permissions.add(new Permission("SupplierQuote.delete"));
        permissions.add(new Permission("IncomeStatementDeclaration.edit"));
        permissions.add(new Permission("IncomeStatementDeclaration.list"));
        permissions.add(new Permission("IncomeStatementDeclaration.view"));
        permissions.add(new Permission("IncomeStatementDeclaration.add"));
        permissions.add(new Permission("IncomeStatementDeclaration.delete"));
        permissions.add(new Permission("DemandPayment.edit"));
        permissions.add(new Permission("DemandPayment.list"));
        permissions.add(new Permission("DemandPayment.view"));
        permissions.add(new Permission("DemandPayment.add"));
        permissions.add(new Permission("DemandPayment.delete"));
        permissions.add(new Permission("Sale.edit"));
        permissions.add(new Permission("Sale.list"));
        permissions.add(new Permission("Sale.view"));
        permissions.add(new Permission("Sale.add"));
        permissions.add(new Permission("Sale.delete"));
        permissions.add(new Permission("AccountingClass.edit"));
        permissions.add(new Permission("AccountingClass.list"));
        permissions.add(new Permission("AccountingClass.view"));
        permissions.add(new Permission("AccountingClass.add"));
        permissions.add(new Permission("AccountingClass.delete"));
        permissions.add(new Permission("Demand.edit"));
        permissions.add(new Permission("Demand.list"));
        permissions.add(new Permission("Demand.view"));
        permissions.add(new Permission("Demand.add"));
        permissions.add(new Permission("Demand.delete"));
        permissions.add(new Permission("Delivery.edit"));
        permissions.add(new Permission("Delivery.list"));
        permissions.add(new Permission("Delivery.view"));
        permissions.add(new Permission("Delivery.add"));
        permissions.add(new Permission("Delivery.delete"));
        permissions.add(new Permission("PaymentDelivery.edit"));
        permissions.add(new Permission("PaymentDelivery.list"));
        permissions.add(new Permission("PaymentDelivery.view"));
        permissions.add(new Permission("PaymentDelivery.add"));
        permissions.add(new Permission("PaymentDelivery.delete"));
        permissions.add(new Permission("PurchaseItem.edit"));
        permissions.add(new Permission("PurchaseItem.list"));
        permissions.add(new Permission("PurchaseItem.view"));
        permissions.add(new Permission("PurchaseItem.add"));
        permissions.add(new Permission("PurchaseItem.delete"));
        permissions.add(new Permission("ReturnSaleItem.edit"));
        permissions.add(new Permission("ReturnSaleItem.list"));
        permissions.add(new Permission("ReturnSaleItem.view"));
        permissions.add(new Permission("ReturnSaleItem.add"));
        permissions.add(new Permission("ReturnSaleItem.delete"));
        permissions.add(new Permission("Shop.edit"));
        permissions.add(new Permission("Shop.list"));
        permissions.add(new Permission("Shop.view"));
        permissions.add(new Permission("Shop.add"));
        permissions.add(new Permission("Shop.delete"));
        permissions.add(new Permission("Client.edit"));
        permissions.add(new Permission("Client.list"));
        permissions.add(new Permission("Client.view"));
        permissions.add(new Permission("Client.add"));
        permissions.add(new Permission("Client.delete"));
        permissions.add(new Permission("PaymentPurchase.edit"));
        permissions.add(new Permission("PaymentPurchase.list"));
        permissions.add(new Permission("PaymentPurchase.view"));
        permissions.add(new Permission("PaymentPurchase.add"));
        permissions.add(new Permission("PaymentPurchase.delete"));
        permissions.add(new Permission("ReturnSale.edit"));
        permissions.add(new Permission("ReturnSale.list"));
        permissions.add(new Permission("ReturnSale.view"));
        permissions.add(new Permission("ReturnSale.add"));
        permissions.add(new Permission("ReturnSale.delete"));
        permissions.add(new Permission("OrderPayment.edit"));
        permissions.add(new Permission("OrderPayment.list"));
        permissions.add(new Permission("OrderPayment.view"));
        permissions.add(new Permission("OrderPayment.add"));
        permissions.add(new Permission("OrderPayment.delete"));
        permissions.add(new Permission("AccountingOperationType.edit"));
        permissions.add(new Permission("AccountingOperationType.list"));
        permissions.add(new Permission("AccountingOperationType.view"));
        permissions.add(new Permission("AccountingOperationType.add"));
        permissions.add(new Permission("AccountingOperationType.delete"));
        permissions.add(new Permission("StatusPaymentDemand.edit"));
        permissions.add(new Permission("StatusPaymentDemand.list"));
        permissions.add(new Permission("StatusPaymentDemand.view"));
        permissions.add(new Permission("StatusPaymentDemand.add"));
        permissions.add(new Permission("StatusPaymentDemand.delete"));
        permissions.add(new Permission("Company.edit"));
        permissions.add(new Permission("Company.list"));
        permissions.add(new Permission("Company.view"));
        permissions.add(new Permission("Company.add"));
        permissions.add(new Permission("Company.delete"));
        permissions.add(new Permission("Store.edit"));
        permissions.add(new Permission("Store.list"));
        permissions.add(new Permission("Store.view"));
        permissions.add(new Permission("Store.add"));
        permissions.add(new Permission("Store.delete"));
        permissions.add(new Permission("PaymentMethod.edit"));
        permissions.add(new Permission("PaymentMethod.list"));
        permissions.add(new Permission("PaymentMethod.view"));
        permissions.add(new Permission("PaymentMethod.add"));
        permissions.add(new Permission("PaymentMethod.delete"));
        permissions.add(new Permission("CreditNotePurchaseStatus.edit"));
        permissions.add(new Permission("CreditNotePurchaseStatus.list"));
        permissions.add(new Permission("CreditNotePurchaseStatus.view"));
        permissions.add(new Permission("CreditNotePurchaseStatus.add"));
        permissions.add(new Permission("CreditNotePurchaseStatus.delete"));
    }

}


