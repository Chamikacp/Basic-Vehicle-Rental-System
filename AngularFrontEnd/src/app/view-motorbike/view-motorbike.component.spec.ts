import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {ViewMotorbikeComponent} from './view-motorbike.component';

describe('ViewMotorbikeComponent', () => {
  let component: ViewMotorbikeComponent;
  let fixture: ComponentFixture<ViewMotorbikeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ViewMotorbikeComponent]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewMotorbikeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
