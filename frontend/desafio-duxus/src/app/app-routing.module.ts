import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CadastroDeIntegrantesComponent } from './cadastro-de-integrantes/cadastro-de-integrantes.component';
import { HttpClientModule } from '@angular/common/http';
import { MontagemDeTimeComponent } from './montagem-de-time/montagem-de-time.component';


const routes: Routes = [
  { path: '', component:  CadastroDeIntegrantesComponent},
  { path: 'cadastro', component:  CadastroDeIntegrantesComponent},
  { path: 'montagem', component:  MontagemDeTimeComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
