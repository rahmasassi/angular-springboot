import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home.component';
import { FooterComponent } from './footer/footer.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { SingupUserComponent } from './singup-user/singup-user.component';
import { LoginComponent } from './login/login.component';
import { DetailCarComponent } from './components/cars/detail-car/detail-car.component';
import { SingupAgencyComponent } from './singup-agency/singup-agency.component';
import { DetailReservationComponent } from './components/reservations/detail-reservation/detail-reservation.component';
import { ConditionComponent } from './condition/condition.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    HomeComponent,
    FooterComponent,
    DashboardComponent,
    SingupUserComponent,
    LoginComponent,
    DetailCarComponent,
    SingupAgencyComponent,
    DetailReservationComponent,
    ConditionComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
