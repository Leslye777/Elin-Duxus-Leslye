import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { AppService } from '../app.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-cadastro-de-integrantes',
  templateUrl: './cadastro-de-integrantes.component.html',
  styleUrls: ['./cadastro-de-integrantes.component.css']
})
export class CadastroDeIntegrantesComponent implements OnInit {

  ngOnInit(): void {

  }
  integranteForm: FormGroup;

  constructor(private formBuilder: FormBuilder, private integranteService: AppService, private router: Router) {
    this.integranteForm = this.formBuilder.group({
      nome: ['', Validators.required],
      funcao: ['', Validators.required],
      franquia: ['', Validators.required],
    });
  }

  onSubmit() {
    if (this.integranteForm.valid) {
      const integranteData = this.integranteForm.value;
      this.integranteService.inserirIntegrante(integranteData).subscribe(
        response => {
          alert("cadastrado com sucesso")
          this.router.navigate(['/montagem/']);

        },
        error => {
          alert('Erro ao inserir integrante: '+error)
          this.router.navigate(['/montagem/']);


        }
      );
    }
  }



}
