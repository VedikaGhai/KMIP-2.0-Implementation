import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GetKeyComponent } from './get-key.component';

describe('GetKeyComponent', () => {
  let component: GetKeyComponent;
  let fixture: ComponentFixture<GetKeyComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GetKeyComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GetKeyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
