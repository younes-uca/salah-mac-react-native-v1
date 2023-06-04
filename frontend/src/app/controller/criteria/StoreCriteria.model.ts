import {CompanyCriteria} from './CompanyCriteria.model';
import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';


export class StoreCriteria  extends   BaseCriteria  {

    public id: number;
    public libelle: string;
    public libelleLike: string;
    public reference: string;
    public referenceLike: string;
  public company: CompanyCriteria ;
  public companys: Array<CompanyCriteria> ;

}
