import { Component, OnInit } from '@angular/core';
import { CarsService } from 'src/app/services/cars.service';
import { CarDTO } from 'src/app/Models/CarDTO';
@Component({
  selector: 'app-list-voiture-user',
  templateUrl: './list-voiture-user.component.html',
  styleUrls: ['./list-voiture-user.component.css']
})
export class ListVoitureUserComponent implements OnInit {
  cars: CarDTO[] = [];
  constructor(private carService: CarsService) { }
  ngOnInit(): void {
    this.carService.getAllCars().subscribe((data: CarDTO[]) => {
      this.cars = data;
  });
}

getImageUrl(car: CarDTO): string {
  if (car.imageData) {
    const base64Image = 'data:image/' + car.fileType + ';base64,' + car.imageData;
    return base64Image;
  }
  return '';
}

}
