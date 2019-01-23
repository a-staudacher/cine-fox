import { TestBed } from '@angular/core/testing';

import { Series_ratingService } from './series_rating.service';

describe('Series_ratingService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: Series_ratingService = TestBed.get(Series_ratingService);
    expect(service).toBeTruthy();
  });
});
