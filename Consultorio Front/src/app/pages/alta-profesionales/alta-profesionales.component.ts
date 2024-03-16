import { Component, Input } from '@angular/core';
import { FormArray, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ProfesionalService } from 'src/app/services/profesional.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-alta-profesionales',
  templateUrl: './alta-profesionales.component.html',
  styleUrls: ['./alta-profesionales.component.css']
})
export class AltaProfesionalesComponent {
  @Input() especialidad?: any;
  inputEspecialidades: string = "";
  idDeLaEspecialidadSeleccionada:any;

  constructor(private fb: FormBuilder, private profesionalService: ProfesionalService) { }

  profesional = this.fb.group({
    matricula: ['', Validators.required, ],
    nombre: ['', Validators.required],
    apellido: ['', Validators.required],
    especialidad: this.fb.group({ 
      id: ['', Validators.required]
    }),
    disponibilidad: this.fb.array([])
  });

    get disponibilidad(): FormArray {
      return this.profesional.get('disponibilidad') as FormArray;
    }
  
    crearDisponibilidad(): FormGroup {
      return this.fb.group({
        dia: ['', Validators.required],
        horaInicio: ['', Validators.required],
        horaFin: ['', Validators.required]
      });
    }
  
    agregarDisponibilidad(): void {
      const nuevaDisponibilidad = this.crearDisponibilidad();
        this.disponibilidad.push(nuevaDisponibilidad);
    }
    
    
    eliminarDisponibilidad(index: number): void {
      this.disponibilidad.removeAt(index);
    }

    onSubmit() {
      if (this.profesional.valid) {
        const datosProfesional = { ...this.profesional.value };
        const disponibilidad = this.profesional.get('disponibilidad') as FormArray;
        
        let horarioInvalido = false;
    
        disponibilidad.controls.forEach(control => {
          let horaInicio = control.get('horaInicio')?.value;
          let horaFin = control.get('horaFin')?.value;
          if(horaInicio < "09:00" || horaFin > "23:00") {
            horarioInvalido = true;
          }
        });
    
        if(horarioInvalido) {
          Swal.fire({
            icon: 'error',
            title: 'Error',
            text: 'Todos los horarios deben ser entre las 09:00 y 23:00.',
          });
          return;
        }
        
        this.profesionalService.crear(datosProfesional).subscribe({
          next: (res) => {
            Swal.fire({
              icon: 'success',
              title: '¡Éxito!',
              text: 'Profesional guardado con éxito.',
            });
            this.profesional.reset();
          },
          error: (error) => {
            Swal.fire({
              icon: 'error',
              title: 'Error',
              text: 'No se pudo guardar al profesional.',
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
    

  clickListado($event: any) {
    //@ts-ignore
    this.inputEspecialidades = $event.map((especialidad) => especialidad.nombre).join(' - ');
    this.especialidad = $event;
    this.profesional.patchValue({ especialidad: { id: this.especialidad[0].id } }); 
    this.idDeLaEspecialidadSeleccionada=this.especialidad[0].id;
  }
}
