
import { Component, EventEmitter, Output, OnInit } from '@angular/core';
import { CarDTO } from 'src/app/Models/CarDTO';
import { CarsService } from 'src/app/services/cars.service';
import { ListVoitureUserComponent } from '../cars/list-voiture-user/list-voiture-user.component';
// import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticateService } from 'src/app/services/authenticate.service';
@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})

export class HeaderComponent implements OnInit {

  isLoggedIn: boolean = false;

  constructor(private authService: AuthenticateService, private router: Router) {}

  ngOnInit() {
    this.isLoggedIn = this.authService.isAuthenticated();
  }
  logout() {
    this.authService.logout();
    this.isLoggedIn = false;
  }
}
