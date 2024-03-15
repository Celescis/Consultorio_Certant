import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { PacienteService } from 'src/app/services/paciente.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-alta-pacientes',
  templateUrl: './alta-pacientes.component.html',
  styleUrls: ['./alta-pacientes.component.css']
})
export class AltaPacientesComponent {
  constructor(private fb: FormBuilder, private pacienteService: PacienteService) { }

  paciente = this.fb.group({
    cuil: ['', [Validators.required, Validators.pattern(/^\d{11}$/)]],
    nombre: ['', Validators.required],
    apellido: ['', Validators.required],
    obraSocial: ['', Validators.required],
    telefono: ['', [Validators.required, Validators.minLength(10)]],
  });
  
  onSubmit() {
    if (this.paciente.valid) {
      this.pacienteService.crear(this.paciente.value).subscribe({
        next: (res) => {
          Swal.fire({
            icon: 'success',
            title: '¡Éxito!',
            text: 'Paciente guardado con éxito.',
          });
          this.paciente.reset();
        },
        error: (error) => {
          Swal.fire({
            icon: 'error',
            title: 'Error',
            text: 'No se pudo guardar el paciente.',
          });
        },
      });
    } else {
      Swal.fire({
        icon: 'error',
        title: 'Formulario inválido',
        text: 'Por favor, revise los datos del formulario.',
      });
    }
  }
}
