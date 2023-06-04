package  ma.sir.ecom.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.ecom.zynerator.util.StringUtil;
import ma.sir.ecom.zynerator.converter.AbstractConverter;
import ma.sir.ecom.zynerator.util.DateUtil;
import ma.sir.ecom.bean.history.ProductHistory;
import ma.sir.ecom.bean.core.Product;
import ma.sir.ecom.ws.dto.ProductDto;

@Component
public class ProductConverter extends AbstractConverter<Product, ProductDto, ProductHistory> {

    @Autowired
    private ProductCategoryConverter productCategoryConverter ;
    @Autowired
    private StoreConverter storeConverter ;
    @Autowired
    private BrandConverter brandConverter ;
    @Autowired
    private MeasurementUnitConverter measurementUnitConverter ;
    private boolean productCategory;
    private boolean measurementUnit;
    private boolean brand;
    private boolean store;

    public  ProductConverter(){
        super(Product.class, ProductDto.class, ProductHistory.class);
    }

    @Override
    public Product toItem(ProductDto dto) {
        if (dto == null) {
            return null;
        } else {
        Product item = new Product();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getReference()))
                item.setReference(dto.getReference());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());
            if(StringUtil.isNotEmpty(dto.getBarcode()))
                item.setBarcode(dto.getBarcode());
            if(StringUtil.isNotEmpty(dto.getDescription()))
                item.setDescription(dto.getDescription());
            if(StringUtil.isNotEmpty(dto.getAveragePurchasePrice()))
                item.setAveragePurchasePrice(dto.getAveragePurchasePrice());
            if(StringUtil.isNotEmpty(dto.getQuantity()))
                item.setQuantity(dto.getQuantity());
            if(StringUtil.isNotEmpty(dto.getAlertThreshold()))
                item.setAlertThreshold(dto.getAlertThreshold());
            if(StringUtil.isNotEmpty(dto.getProductPhotos()))
                item.setProductPhotos(dto.getProductPhotos());
            if(this.productCategory && dto.getProductCategory()!=null)
                item.setProductCategory(productCategoryConverter.toItem(dto.getProductCategory())) ;

            if(this.measurementUnit && dto.getMeasurementUnit()!=null)
                item.setMeasurementUnit(measurementUnitConverter.toItem(dto.getMeasurementUnit())) ;

            if(this.brand && dto.getBrand()!=null)
                item.setBrand(brandConverter.toItem(dto.getBrand())) ;

            if(this.store && dto.getStore()!=null)
                item.setStore(storeConverter.toItem(dto.getStore())) ;



        return item;
        }
    }

    @Override
    public ProductDto toDto(Product item) {
        if (item == null) {
            return null;
        } else {
            ProductDto dto = new ProductDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getReference()))
                dto.setReference(item.getReference());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());
            if(StringUtil.isNotEmpty(item.getBarcode()))
                dto.setBarcode(item.getBarcode());
            if(StringUtil.isNotEmpty(item.getDescription()))
                dto.setDescription(item.getDescription());
            if(StringUtil.isNotEmpty(item.getAveragePurchasePrice()))
                dto.setAveragePurchasePrice(item.getAveragePurchasePrice());
            if(StringUtil.isNotEmpty(item.getQuantity()))
                dto.setQuantity(item.getQuantity());
            if(StringUtil.isNotEmpty(item.getAlertThreshold()))
                dto.setAlertThreshold(item.getAlertThreshold());
            if(StringUtil.isNotEmpty(item.getProductPhotos()))
                dto.setProductPhotos(item.getProductPhotos());
        if(this.productCategory && item.getProductCategory()!=null) {
            dto.setProductCategory(productCategoryConverter.toDto(item.getProductCategory())) ;
        }
        if(this.measurementUnit && item.getMeasurementUnit()!=null) {
            dto.setMeasurementUnit(measurementUnitConverter.toDto(item.getMeasurementUnit())) ;
        }
        if(this.brand && item.getBrand()!=null) {
            dto.setBrand(brandConverter.toDto(item.getBrand())) ;
        }
        if(this.store && item.getStore()!=null) {
            dto.setStore(storeConverter.toDto(item.getStore())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.productCategory = value;
        this.measurementUnit = value;
        this.brand = value;
        this.store = value;
    }


    public ProductCategoryConverter getProductCategoryConverter(){
        return this.productCategoryConverter;
    }
    public void setProductCategoryConverter(ProductCategoryConverter productCategoryConverter ){
        this.productCategoryConverter = productCategoryConverter;
    }
    public StoreConverter getStoreConverter(){
        return this.storeConverter;
    }
    public void setStoreConverter(StoreConverter storeConverter ){
        this.storeConverter = storeConverter;
    }
    public BrandConverter getBrandConverter(){
        return this.brandConverter;
    }
    public void setBrandConverter(BrandConverter brandConverter ){
        this.brandConverter = brandConverter;
    }
    public MeasurementUnitConverter getMeasurementUnitConverter(){
        return this.measurementUnitConverter;
    }
    public void setMeasurementUnitConverter(MeasurementUnitConverter measurementUnitConverter ){
        this.measurementUnitConverter = measurementUnitConverter;
    }
    public boolean  isProductCategory(){
        return this.productCategory;
    }
    public void  setProductCategory(boolean productCategory){
        this.productCategory = productCategory;
    }
    public boolean  isMeasurementUnit(){
        return this.measurementUnit;
    }
    public void  setMeasurementUnit(boolean measurementUnit){
        this.measurementUnit = measurementUnit;
    }
    public boolean  isBrand(){
        return this.brand;
    }
    public void  setBrand(boolean brand){
        this.brand = brand;
    }
    public boolean  isStore(){
        return this.store;
    }
    public void  setStore(boolean store){
        this.store = store;
    }
}
