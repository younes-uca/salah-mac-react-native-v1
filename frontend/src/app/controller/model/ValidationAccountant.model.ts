import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class ValidationAccountantDto  extends BaseDto{

    public id: number;
    public cin: string;
    public lastName: string;
    public firstName: string;

}
