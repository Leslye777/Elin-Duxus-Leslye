import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AppService } from '../app.service';

@Component({
  selector: 'app-montagem-de-time',
  templateUrl: './montagem-de-time.component.html',
  styleUrls: ['./montagem-de-time.component.css']
})
export class MontagemDeTimeComponent implements OnInit {

  montagemForm: FormGroup;
  integrantes: any[] = [];

  constructor(private formBuilder: FormBuilder, private appService: AppService) {
    this.montagemForm = this.formBuilder.group({
      timeId: ['', Validators.required],
      jogador: ['',Validators.required]
    });
  }

  ngOnInit(): void {
    this.buscarIntegrantes()

  }

  onSubmit() {
    if (this.montagemForm.valid) {

      const timeId = this.montagemForm.get('timeId')?.value;
      const jogador = this.montagemForm.get('jogador')?.value;

      this.appService.cadastrarComposicaoTime(timeId, jogador).subscribe(
        (response) => {
          console.log('Jogador adicionado com sucesso:', response);
          alert("cadastrado com sucesso")

        },
        (error) => {
          alert("erro ao cadastrar")
          console.error('Erro ao adicionar jogador:', error);
        }
      );
    }
  }

  public buscarIntegrantes(){
    this.appService.listarIntegrantes().subscribe(response => {
      this.integrantes = response;
    });
  }


}
