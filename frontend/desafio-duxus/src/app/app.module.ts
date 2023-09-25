import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CadastroTimeComponent } from './cadastro-time/cadastro-time.component';
import { CadastroDeIntegrantesComponent } from './cadastro-de-integrantes/cadastro-de-integrantes.component';

@NgModule({
  declarations: [
    AppComponent,
    CadastroTimeComponent,
    CadastroDeIntegrantesComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
