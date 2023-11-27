import { Component, Input, OnInit } from '@angular/core';
import { CarsService } from 'src/app/services/cars.service';
import { CarDTO } from 'src/app/Models/CarDTO';
import { ActivatedRoute, Router } from '@angular/router';
import { ca } from 'date-fns/locale';


@Component({
  selector: 'app-list-voiture-user',
  templateUrl: './list-voiture-user.component.html',
  styleUrls: ['./list-voiture-user.component.css']
})
export class ListVoitureUserComponent implements OnInit {
  @Input() car!: CarDTO;
  cars: CarDTO[] = [];
  searchResults: CarDTO[] = [];
  showSearchResults: boolean = false;
  constructor(private carService: CarsService, private route: ActivatedRoute, private router : Router) {}
  ngOnInit(): void {
    // Récupérez tous les véhicules à partir du service lors de l'initialisation
    this.route.paramMap.subscribe(()=>{
      this.listCars();
    });
    
  }
  listCars(){
    this.showSearchResults = this.route.snapshot.paramMap.has('keyword');
    if (this.showSearchResults){
      this.searchCars();
    }
    else{
      this.getAllCars();
    }
    
  }
  searchCars(){
    const theKeyword: string | null = this.route.snapshot.paramMap.get('keyword');

    if (theKeyword !== null) {
      this.carService.searchCars(theKeyword).subscribe((data: CarDTO[]) => {
        this.cars = data;
        
      });
    } else {
      console.log("null")
      
    }
  }
  getAllCars(): void {
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
  deleteCar(car: CarDTO): void {
    if (car && car.id) {
      this.carService.delete(car.id).subscribe(
        () => {
          console.log(`Car with ID ${car.id} deleted successfully.`);
          this.router.navigate(['/list-voiture-user']).then(() => {
          location.reload();
          });
        },
        (error) => {
          console.error('Error deleting car:', error);
        }
      );
    } else {
      console.error('Invalid car data for deletion.', car);
    }
  }
  
  editCar(car: CarDTO): void {
    if (car && car.id) {
      this.router.navigate(['/edit-car', car.id]);
    } else {
      console.error('Invalid car data for editing.', car);
    }
  }
  reserveCar(car: CarDTO):void{
    if (car && car.id){
      this.router.navigate(['/reservation', car.id]);
    }else{
      console.error('Invalid car data for reserving.', car);
    }
  }
}

