import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LocateKeyComponent } from './locate-key.component';

describe('LocateKeyComponent', () => {
  let component: LocateKeyComponent;
  let fixture: ComponentFixture<LocateKeyComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LocateKeyComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LocateKeyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
