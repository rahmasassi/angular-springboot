export class ListReclamation {

     id?: number;
     name?: string;
     description? : string;
     userId ? : number;
     agencyId ? : number;
    // constructor(
    //   public this.id: number,
    //   public name: string,
    //   public description : string,
    //   public userId ? : number,
    //   public agencyId ? : number
      
     
   
    // ) {}
    constructor(id?: number, name?: string, description?: string, userId?: number, agencyId?: number) {
      this.id = id;
      this.name = name;
      this.description = description;
      this.userId = userId;
      this.agencyId = agencyId;
    }

  }