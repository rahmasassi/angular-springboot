import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home.component';
import { FooterComponent } from './footer/footer.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ListReservationAgenceComponent } from './list-reservation-agence/list-reservation-agence.component';
import { ListReservationClientComponent } from './list-reservation-client/list-reservation-client.component';
import { ListVoitureUserComponent } from './list-voiture-user/list-voiture-user.component';
import { ListVoitureAgenceComponent } from './list-voiture-agence/list-voiture-agence.component';

import { library } from '@fortawesome/fontawesome-svg-core';
import { faSearch, faInfoCircle, faExclamationTriangle, faWarning } from '@fortawesome/free-solid-svg-icons';
import { ButtonDetailsEditComponent } from './button-details-edit/button-details-edit.component';
import { ButtonAddDeleteComponent } from './button-add-delete/button-add-delete.component';
import { ListAgenceComponent } from './list-agence/list-agence.component';
import { ListReclamationComponent } from './list-reclamation/list-reclamation.component';
import { ListClientComponent } from './list-client/list-client.component';
@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    HomeComponent,
    FooterComponent,
    DashboardComponent,
    ListReservationAgenceComponent,
    ListReservationClientComponent,
    ListVoitureUserComponent,
    ListVoitureAgenceComponent,
    ButtonDetailsEditComponent,
    ButtonAddDeleteComponent,
    ListAgenceComponent,
    ListReclamationComponent,
    ListClientComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
