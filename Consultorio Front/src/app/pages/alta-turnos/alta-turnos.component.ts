import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { PacienteService } from 'src/app/services/paciente.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-alta-turnos',
  templateUrl: './alta-turnos.component.html',
  styleUrls: ['./alta-turnos.component.css']
})
export class AltaTurnosComponent {
  formulario: FormGroup;

  constructor(private fb: FormBuilder, private pacienteService: PacienteService) {
    this.formulario = this.fb.group({
      cuil: ['', Validators.required]
    });
  }

  onSubmit() {
    const cuil = this.formulario.value.cuil;
    this.pacienteService.obtenerPacientePorCuil(cuil).subscribe({
      next: (res) => {
        Swal.fire({
          icon: 'success',
          title: 'Cuil valido!',
          text: 'Bienvenido '+ res.nombre+' '+res.apellido+'!',
        });
      },
      error: (error) => {
        Swal.fire({
          icon: 'error',
          title: 'Error',
          text: 'No se encuentra el cuil.',
        });
      },
    });
  }
}
