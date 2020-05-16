import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateKeyPairComponent } from './create-key-pair.component';

describe('CreateKeyPairComponent', () => {
  let component: CreateKeyPairComponent;
  let fixture: ComponentFixture<CreateKeyPairComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateKeyPairComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateKeyPairComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
