import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './pages/navbar/navbar.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HomeComponent } from './pages/home/home.component';
import { AltaPacientesComponent } from './pages/alta-pacientes/alta-pacientes.component';
import { AltaProfesionalesComponent } from './pages/alta-profesionales/alta-profesionales.component';
import { AltaTurnosComponent } from './pages/alta-turnos/alta-turnos.component';
import { ListaEspecialidadesComponent } from './pages/lista-especialidades/lista-especialidades.component';
import { ListaProfesionalesComponent } from './pages/lista-profesionales/lista-profesionales.component';
import { ListaTurnosComponent } from './pages/lista-turnos/lista-turnos.component';
import { ListaTurnosPacienteComponent } from './pages/lista-turnos-paciente/lista-turnos-paciente.component';
import { EspecialidadComponent } from './component/especialidad/especialidad.component';


@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    HomeComponent,
    AltaPacientesComponent,
    AltaProfesionalesComponent,
    AltaTurnosComponent,
    EspecialidadComponent,
    ListaEspecialidadesComponent,
    ListaProfesionalesComponent,
    ListaTurnosComponent,
    ListaTurnosPacienteComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

