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
      }
    ],
  }  
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
