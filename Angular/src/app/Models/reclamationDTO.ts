export class ReclamationDTO {
    id: number;
    name: string;
    description: string;
    userId?: number;
    agencyId?: number;
  
    constructor(reclamation: any) {
      this.id = reclamation.id;
      this.name = reclamation.name;
      this.description = reclamation.description;
      this.userId = reclamation.userId;
      this.agencyId = reclamation.agencyId;
    }
  }
  