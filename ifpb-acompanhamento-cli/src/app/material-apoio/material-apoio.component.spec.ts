import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MaterialApoioComponent } from './material-apoio.component';

describe('MaterialApoioComponent', () => {
  let component: MaterialApoioComponent;
  let fixture: ComponentFixture<MaterialApoioComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MaterialApoioComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MaterialApoioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
