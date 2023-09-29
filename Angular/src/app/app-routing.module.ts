import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './dashboard/dashboard.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { SingupUserComponent } from './singup-user/singup-user.component';
import { DetailCarComponent } from './components/cars/detail-car/detail-car.component';
import { SingupAgencyComponent } from './singup-agency/singup-agency.component';
import { DetailReservationComponent } from './components/reservations/detail-reservation/detail-reservation.component';
import { ConditionComponent } from './condition/condition.component';

import { ListReservationAgenceComponent } from './list-reservation-agence/list-reservation-agence.component';
import { ListReservationClientComponent } from './list-reservation-client/list-reservation-client.component';
import { ListVoitureUserComponent } from './list-voiture-user/list-voiture-user.component';
import { ListVoitureAgenceComponent } from './list-voiture-agence/list-voiture-agence.component';
import { ListAgenceComponent } from './list-agence/list-agence.component';
import { ListReclamation } from './Models/reclamation';
import { ListReclamationComponent } from './list-reclamation/list-reclamation.component';
import { ListClientComponent } from './list-client/list-client.component';

import { AddCarComponent } from './add-car/add-car.component';
import { AddReclamationComponent } from './add-reclamation/add-reclamation.component';
import { AddReservationComponent } from './add-reservation/add-reservation.component';
import { CalendarComponent } from './calendar/calendar.component';


const routes: Routes = [

  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'inscrire-user',
    component: SingupUserComponent
  },
  {
    path: 'inscrire-agency',
    component: SingupAgencyComponent
  },
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
        path: 'detail-car',
        component: DetailCarComponent
      },
      {
        path: 'detail-reservation',
        component: DetailReservationComponent
      },
      {
        path: 'condition',
        component: ConditionComponent
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
      },
      {
        path: 'addcar',
        component: AddCarComponent
      },
      {
        path: 'addrec',
        component: AddReclamationComponent
      },
      {
        path: 'reservation',
        component: AddReservationComponent
      },
      {
        path: 'calendar',
        component:CalendarComponent
      }
    ],
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
