import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { AltaPacientesComponent } from './pages/alta-pacientes/alta-pacientes.component';
import { AltaProfesionalesComponent } from './pages/alta-profesionales/alta-profesionales.component';
import { AltaTurnosComponent } from './pages/alta-turnos/alta-turnos.component';

const routes: Routes = [
  { path: 'turnos', component: AltaTurnosComponent},
  { path: 'profesionales', component: AltaProfesionalesComponent},
  { path: 'pacientes', component: AltaPacientesComponent},
  { path: 'home', component: HomeComponent },
  { path: '', redirectTo: '/home', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
