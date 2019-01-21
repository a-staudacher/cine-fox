import { TestBed } from '@angular/core/testing';

import { mediaService } from './media.service';

describe('mediaService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: mediaService = TestBed.get(mediaService);
    expect(service).toBeTruthy();
  });
});
