import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './dashboard/dashboard.component';
import { HomeComponent } from './home/home.component';
import { ListReservationAgenceComponent } from './list-reservation-agence/list-reservation-agence.component';

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
      }

    ],
  }  
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
