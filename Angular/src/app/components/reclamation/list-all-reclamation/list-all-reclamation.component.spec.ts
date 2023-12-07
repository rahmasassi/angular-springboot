import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListAllReclamationComponent } from './list-all-reclamation.component';

describe('ListAllReclamationComponent', () => {
  let component: ListAllReclamationComponent;
  let fixture: ComponentFixture<ListAllReclamationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListAllReclamationComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListAllReclamationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
