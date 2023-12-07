import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ListReclamation } from 'src/app/Models/reclamation';
import { AuthenticateService } from 'src/app/services/authenticate.service';
import { ReclamationServiceService } from 'src/app/services/reclamation-service.service';

@Component({
  selector: 'app-add-reclamation',
  templateUrl: './add-reclamation.component.html',
  styleUrls: ['./add-reclamation.component.css']
})
export class AddReclamationComponent {
  reclamation: ListReclamation = new ListReclamation();
  selectedAgencyId: number | undefined;

  constructor(
    private route: ActivatedRoute,
    private reclamationService: ReclamationServiceService,
    private authService: AuthenticateService,
    private router: Router
  ) {}

  ngOnInit(): void {
    // Récupérez l'ID de l'agence à partir des paramètres de l'URL
    this.route.params.subscribe((params) => {
      this.selectedAgencyId = +params['id'];
      console.log('selectedeid', this.selectedAgencyId)
    });
  }

  onSubmit(form: NgForm) {
    const currentUserId = this.authService.getCurrentUserId();
    this.reclamation.userId = currentUserId;
    this.reclamation.agencyId = this.selectedAgencyId;
    const message = this.reclamation.description;
    console.log('Message:', message);

    this.reclamationService.addReclamation(this.reclamation, currentUserId).subscribe(
      (response) => {
        console.log('Réponse du backend :', response);
        this.router.navigate(['/list-agence']);
      },
      (error) => {
        console.error('Erreur lors de l\'envoi des données auu backend :', error);
      }
    );
  }
}
