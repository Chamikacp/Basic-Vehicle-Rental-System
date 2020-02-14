import {TestBed} from '@angular/core/testing';

import {MotorbikeService} from './motorbike.service';

describe('MotorbikeService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: MotorbikeService = TestBed.get(MotorbikeService);
    expect(service).toBeTruthy();
  });
});
