import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VehicleGeolocationComponent } from './vehicle-geolocation.component';

describe('VehicleGeolocationComponent', () => {
  let component: VehicleGeolocationComponent;
  let fixture: ComponentFixture<VehicleGeolocationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VehicleGeolocationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VehicleGeolocationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
