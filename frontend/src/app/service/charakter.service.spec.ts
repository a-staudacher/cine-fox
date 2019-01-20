import { TestBed } from '@angular/core/testing';

import { CharakterService } from './charakter.service';

describe('CharakterService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CharakterService = TestBed.get(CharakterService);
    expect(service).toBeTruthy();
  });
});
