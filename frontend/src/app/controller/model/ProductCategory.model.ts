import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class ProductCategoryDto  extends BaseDto{

    public id: number;
    public reference: string;
    public libelle: string;

}
