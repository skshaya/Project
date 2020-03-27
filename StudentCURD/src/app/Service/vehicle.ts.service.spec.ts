import { TestBed } from '@angular/core/testing';

import { Vehicle.TsService } from './vehicle.ts.service';

describe('Vehicle.TsService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: Vehicle.TsService = TestBed.get(Vehicle.TsService);
    expect(service).toBeTruthy();
  });
});
