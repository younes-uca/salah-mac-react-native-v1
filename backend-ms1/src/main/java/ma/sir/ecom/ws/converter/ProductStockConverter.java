package  ma.sir.ecom.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.ecom.zynerator.util.StringUtil;
import ma.sir.ecom.zynerator.converter.AbstractConverter;
import ma.sir.ecom.zynerator.util.DateUtil;
import ma.sir.ecom.bean.history.ProductStockHistory;
import ma.sir.ecom.bean.core.ProductStock;
import ma.sir.ecom.ws.dto.ProductStockDto;

@Component
public class ProductStockConverter extends AbstractConverter<ProductStock, ProductStockDto, ProductStockHistory> {

    @Autowired
    private ProductConverter productConverter ;
    @Autowired
    private ShopConverter shopConverter ;
    private boolean shop;
    private boolean product;

    public  ProductStockConverter(){
        super(ProductStock.class, ProductStockDto.class, ProductStockHistory.class);
    }

    @Override
    public ProductStock toItem(ProductStockDto dto) {
        if (dto == null) {
            return null;
        } else {
        ProductStock item = new ProductStock();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getQuantity()))
                item.setQuantity(dto.getQuantity());
            if(StringUtil.isNotEmpty(dto.getDefectiveQuantity()))
                item.setDefectiveQuantity(dto.getDefectiveQuantity());
            if(this.shop && dto.getShop()!=null)
                item.setShop(shopConverter.toItem(dto.getShop())) ;

            if(this.product && dto.getProduct()!=null)
                item.setProduct(productConverter.toItem(dto.getProduct())) ;



        return item;
        }
    }

    @Override
    public ProductStockDto toDto(ProductStock item) {
        if (item == null) {
            return null;
        } else {
            ProductStockDto dto = new ProductStockDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getQuantity()))
                dto.setQuantity(item.getQuantity());
            if(StringUtil.isNotEmpty(item.getDefectiveQuantity()))
                dto.setDefectiveQuantity(item.getDefectiveQuantity());
        if(this.shop && item.getShop()!=null) {
            dto.setShop(shopConverter.toDto(item.getShop())) ;
        }
        if(this.product && item.getProduct()!=null) {
            dto.setProduct(productConverter.toDto(item.getProduct())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.shop = value;
        this.product = value;
    }


    public ProductConverter getProductConverter(){
        return this.productConverter;
    }
    public void setProductConverter(ProductConverter productConverter ){
        this.productConverter = productConverter;
    }
    public ShopConverter getShopConverter(){
        return this.shopConverter;
    }
    public void setShopConverter(ShopConverter shopConverter ){
        this.shopConverter = shopConverter;
    }
    public boolean  isShop(){
        return this.shop;
    }
    public void  setShop(boolean shop){
        this.shop = shop;
    }
    public boolean  isProduct(){
        return this.product;
    }
    public void  setProduct(boolean product){
        this.product = product;
    }
}
