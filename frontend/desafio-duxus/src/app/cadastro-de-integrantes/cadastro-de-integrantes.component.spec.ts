import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CadastroDeIntegrantesComponent } from './cadastro-de-integrantes.component';

describe('CadastroDeIntegrantesComponent', () => {
  let component: CadastroDeIntegrantesComponent;
  let fixture: ComponentFixture<CadastroDeIntegrantesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CadastroDeIntegrantesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CadastroDeIntegrantesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
