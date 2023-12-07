import { Component } from '@angular/core';
import { ReclamationDTO } from 'src/app/Models/reclamationDTO';
import { ReclamationServiceService } from 'src/app/services/reclamation-service.service';

@Component({
  selector: 'app-list-all-reclamation',
  templateUrl: './list-all-reclamation.component.html',
  styleUrls: ['./list-all-reclamation.component.css']
})
export class ListAllReclamationComponent {
    
  reclamations: ReclamationDTO[] = [];
  constructor(private reclamationService: ReclamationServiceService) {}
  ngOnInit() {
    this.getAllReclamations();
  }
  getAllReclamations() {
    this.reclamationService.getAllReclamations().subscribe(
      (reclamations) => {
        this.reclamations = reclamations;
      },
      (error) => {
        console.error('Error getting all reclamations', error);
      }
    );
  }
 
}
