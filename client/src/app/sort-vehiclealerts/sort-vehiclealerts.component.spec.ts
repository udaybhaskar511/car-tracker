import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SortVehiclealertsComponent } from './sort-vehiclealerts.component';

describe('SortVehiclealertsComponent', () => {
  let component: SortVehiclealertsComponent;
  let fixture: ComponentFixture<SortVehiclealertsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SortVehiclealertsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SortVehiclealertsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
