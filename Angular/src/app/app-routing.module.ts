import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './dashboard/dashboard.component';
import { HomeComponent } from './home/home.component';
import { AddCarComponent } from './add-car/add-car.component';
import { AddReclamationComponent } from './add-reclamation/add-reclamation.component';
import { AddReservationComponent } from './add-reservation/add-reservation.component';
import { CalendarComponent } from './calendar/calendar.component';

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
