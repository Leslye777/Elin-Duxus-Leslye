import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MontagemDeTimeComponent } from './montagem-de-time.component';

describe('MontagemDeTimeComponent', () => {
  let component: MontagemDeTimeComponent;
  let fixture: ComponentFixture<MontagemDeTimeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MontagemDeTimeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MontagemDeTimeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
