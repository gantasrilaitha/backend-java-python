import { TestBed } from '@angular/core/testing';

import { AminServiceService } from './amin-service.service';

describe('AminServiceService', () => {
  let service: AminServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AminServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
