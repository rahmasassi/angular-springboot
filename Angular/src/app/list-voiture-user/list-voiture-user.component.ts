import { Component } from '@angular/core';
import { Car } from '../Models/car.model';

@Component({
  selector: 'app-list-voiture-user',
  templateUrl: './list-voiture-user.component.html',
  styleUrls: ['./list-voiture-user.component.css']
})
export class ListVoitureUserComponent {

  cars: Car[] = [
    { name: 'Mercedes Grand Sedan', brand: 'Cheverolet', price: 500, perDay: true, image: 'assets/images/car-1.jpg' },
    { name: 'Range Rover', brand: 'Subaru', price: 500, perDay: true, image: 'assets/images/car-2.jpg' },
    { name: 'Range Rover', brand: 'Subaru', price: 500, perDay: true, image: 'assets/images/car-2.jpg' },
    { name: 'Range Rover', brand: 'Subaru', price: 500, perDay: true, image: 'assets/images/car-2.jpg' },
    { name: 'Range Rover', brand: 'Subaru', price: 500, perDay: true, image: 'assets/images/car-2.jpg' },
    { name: 'Range Rover', brand: 'Subaru', price: 500, perDay: true, image: 'assets/images/car-2.jpg' },
    { name: 'Range Rover', brand: 'Subaru', price: 500, perDay: true, image: 'assets/images/car-2.jpg' },
    { name: 'Range Rover', brand: 'Subaru', price: 500, perDay: true, image: 'assets/images/car-2.jpg' },
    { name: 'Range Rover', brand: 'Subaru', price: 500, perDay: true, image: 'assets/images/car-2.jpg' },
    // Ajoutez d'autres voitures ici
  ];

}
