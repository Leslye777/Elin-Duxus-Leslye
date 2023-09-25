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

      // Chame seu serviço para adicionar o jogador ao time pelo ID
      this.appService.cadastrarComposicaoTime(timeId, jogador).subscribe(
        (response) => {
          // Lide com a resposta, por exemplo, atualize a lista de jogadores no time
          console.log('Jogador adicionado com sucesso:', response);
        },
        (error) => {
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
