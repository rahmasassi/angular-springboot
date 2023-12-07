import { Component } from '@angular/core';
import { ListReclamation } from '../../../Models/reclamation';
import { ReclamationServiceService } from 'src/app/services/reclamation-service.service';
import { AuthenticateService } from 'src/app/services/authenticate.service';
import { ReclamationDTO } from 'src/app/Models/reclamationDTO';
import { Router } from '@angular/router';

@Component({
  selector: 'app-list-reclamation',
  templateUrl: './list-reclamation.component.html',
  styleUrls: ['./list-reclamation.component.css']
})
export class ListReclamationComponent {
  reclamations: ReclamationDTO[] = [];
  constructor(private reclamationService: ReclamationServiceService,private authService: AuthenticateService,private router:Router) {}
  ngOnInit() {
    this.getReclamationByAgency();
  }
  getReclamationByAgency() {
    const agencyId = this.authService.getCurrentUserId();
    this.reclamationService.getReclamationByAgencyId(agencyId).subscribe(
      (reclamations) => {
        this.reclamations = reclamations;
      },
      (error) => {
        console.error('Error getting reclamations by agency ID', error);
      }
    );
  }
  deleteReclamation(reclamation: ListReclamation): void {
    if (reclamation && reclamation.id) {
      this.reclamationService.deleteReclamation(reclamation.id).subscribe(
        () => {
          console.log(`Reclamation with ID ${reclamation.id} deleted successfully.`);
          this.router.navigate(['/list-reclamation']).then(() => {
            location.reload();
          });
        },
        (error) => {
          console.error('Error deleting reclamation:', error);
        }
      );
    } else {
      console.error('Invalid reclamation data for deletion.', reclamation);
    }
  }


  
 

}
