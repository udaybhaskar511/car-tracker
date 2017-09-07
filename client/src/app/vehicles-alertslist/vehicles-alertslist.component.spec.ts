import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VehiclesAlertslistComponent } from './vehicles-alertslist.component';

describe('VehiclesAlertslistComponent', () => {
  let component: VehiclesAlertslistComponent;
  let fixture: ComponentFixture<VehiclesAlertslistComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VehiclesAlertslistComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VehiclesAlertslistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
