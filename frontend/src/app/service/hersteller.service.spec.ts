import { TestBed } from '@angular/core/testing';

import { HerstellerService } from './hersteller.service';

describe('HerstellerService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: HerstellerService = TestBed.get(HerstellerService);
    expect(service).toBeTruthy();
  });
});
