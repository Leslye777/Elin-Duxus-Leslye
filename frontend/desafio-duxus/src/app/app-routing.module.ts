import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CadastroTimeComponent } from './cadastro-time/cadastro-time.component';

const routes: Routes = [
  { path: 'cadastro', component: CadastroTimeComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
