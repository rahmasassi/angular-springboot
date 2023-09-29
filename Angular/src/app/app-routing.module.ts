import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './dashboard/dashboard.component';
import { HomeComponent } from './home/home.component';
import { ListReservationAgenceComponent } from './list-reservation-agence/list-reservation-agence.component';
import { ListReservationClientComponent } from './list-reservation-client/list-reservation-client.component';
import { ListVoitureUserComponent } from './list-voiture-user/list-voiture-user.component';
import { ListVoitureAgenceComponent } from './list-voiture-agence/list-voiture-agence.component';
import { ListAgenceComponent } from './list-agence/list-agence.component';
import { ListReclamation } from './Models/reclamation';
import { ListReclamationComponent } from './list-reclamation/list-reclamation.component';
import { ListClientComponent } from './list-client/list-client.component';

const routes: Routes = [
  
  {
    path: '',
    component: DashboardComponent,
    children: [
      { path: '', 
      redirectTo: 'home',
      pathMatch: 'full'
      },
      {
        path: 'home',
        component: HomeComponent
      },
      {
        path: 'reservation-agence',
        component: ListReservationAgenceComponent 
      },
      {
        path: 'reservation-client',
        component: ListReservationClientComponent 
      },
      {
        path: 'list-voiture-user',
        component: ListVoitureUserComponent 
      },
      {
        path: 'list-voiture-agence',
        component: ListVoitureAgenceComponent 
      },
      {
        path: 'list-agence',
        component: ListAgenceComponent 
      },
      {
        path: 'list-reclamation',
        component: ListReclamationComponent
      },
      {
        path: 'list-client',
        component: ListClientComponent
      }
    ],
  
  }  
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
