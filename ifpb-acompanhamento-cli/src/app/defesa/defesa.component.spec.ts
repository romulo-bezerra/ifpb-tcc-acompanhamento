import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DefesaComponent } from './defesa.component';

describe('DefesaComponent', () => {
  let component: DefesaComponent;
  let fixture: ComponentFixture<DefesaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DefesaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DefesaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
