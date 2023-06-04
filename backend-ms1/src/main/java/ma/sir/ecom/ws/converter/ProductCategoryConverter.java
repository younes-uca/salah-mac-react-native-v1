package  ma.sir.ecom.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.ecom.zynerator.util.StringUtil;
import ma.sir.ecom.zynerator.converter.AbstractConverter;
import ma.sir.ecom.zynerator.util.DateUtil;
import ma.sir.ecom.bean.history.ProductCategoryHistory;
import ma.sir.ecom.bean.core.ProductCategory;
import ma.sir.ecom.ws.dto.ProductCategoryDto;

@Component
public class ProductCategoryConverter extends AbstractConverter<ProductCategory, ProductCategoryDto, ProductCategoryHistory> {


    public  ProductCategoryConverter(){
        super(ProductCategory.class, ProductCategoryDto.class, ProductCategoryHistory.class);
    }

    @Override
    public ProductCategory toItem(ProductCategoryDto dto) {
        if (dto == null) {
            return null;
        } else {
        ProductCategory item = new ProductCategory();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getReference()))
                item.setReference(dto.getReference());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());


        return item;
        }
    }

    @Override
    public ProductCategoryDto toDto(ProductCategory item) {
        if (item == null) {
            return null;
        } else {
            ProductCategoryDto dto = new ProductCategoryDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getReference()))
                dto.setReference(item.getReference());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());


        return dto;
        }
    }


    public void initObject(boolean value) {
    }


}
