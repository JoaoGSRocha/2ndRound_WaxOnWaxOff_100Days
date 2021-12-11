export class Skin {
  sku: string = "";
  stripe_price: string = "";
  name: string = "";
  description: string = "";
  rarity: string = "";
  condition: string = "";
  price: number = 0;
  imgUrl: string = "";
  active: boolean = false;
  unitsInStock: number = 0;
  dateCreated: Date = new Date();
  lastUpdate: Date = new Date();
  releasedate: Date = new Date();
}
