export interface Virement {
  id : number;
  beneficiaireId : number ;
  sourceRIB : string;
  amount : number;
  description : string;
  virementDate : Date ;
  type : string;
}
