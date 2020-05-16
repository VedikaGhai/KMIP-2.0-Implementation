import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DestroyKeyComponent } from './destroy-key.component';

describe('DestroyKeyComponent', () => {
  let component: DestroyKeyComponent;
  let fixture: ComponentFixture<DestroyKeyComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DestroyKeyComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DestroyKeyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
