import { Component, EventEmitter, Output } from '@angular/core';
import { EspecialidadService } from 'src/app/services/especialidad.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-especialidad',
  templateUrl: './especialidad.component.html',
  styleUrls: ['./especialidad.component.css']
})
export class EspecialidadComponent {
  @Output() botonClickeado = new EventEmitter<any>();
  especialidades: { id: number, descripcion: string }[] = [];
  listaFiltrada: { id: number; descripcion: string; }[] = [];
  valorInput: string;
  nuevaEspecialidad: string;
  inputValidado: boolean = false;
  listaEspecialidades: any;
  

  constructor(private especialidadServicio:EspecialidadService) {
    this.listaEspecialidades = [];
    this.nuevaEspecialidad = "";
    this.valorInput = "";
  }

  ngOnInit(): void {
    this.listaFiltrada = [];
    this.obtenerListaEspecialidades();
  }

  obtenerListaEspecialidades() {
    this.especialidadServicio.obtenerEspecialidades().subscribe((data: any[]) => {
      console.log(data);
      this.especialidades = data;
      this.listaFiltrada = [...this.especialidades];
    });
  }

  validarEspecialidad() {
    if (this.valorInput.match(/^[a-zA-Z ]+$/)) {
      this.inputValidado = true;
      this.nuevaEspecialidad = this.valorInput;
    }
    else {
      this.inputValidado = false;
    }
    this.valorInput = '';
    this.listaFiltrada = [...this.especialidades];
  }

  filtrarLista() {
    this.listaFiltrada = this.especialidades.filter((item: { id: number; descripcion: string; }) =>
      item.descripcion.toLowerCase().includes(this.valorInput.toLowerCase())
    );
  }
  

  agregarItem() {
    if (this.inputValidado) {
      var esp = {
        descripcion: this.nuevaEspecialidad
      };
      this.especialidadServicio.crear(esp).subscribe({
        next: (res) => {
          Swal.fire({
            icon: 'success',
            title: '¡Éxito!',
            text: 'Especialidad guardada con éxito.',
          });

        this.obtenerListaEspecialidades();
          
        },
        error: (error) => {
          Swal.fire({
            icon: 'error',
            title: 'Error',
            text: 'No se pudo guardar la especialidad.',
          });
        },
      });

    }
    else {
      Swal.fire("Sólo debe contener letras", "FALLÓ AL AGREGAR", 'error');
    }
  }


  ayuda() {
    Swal.fire("Si no encuentra su especialidad en la lista, puede agregarla escribiendola y tocando el botón '+'", "Modo de uso:", 'info');
  }

 
  clickListado(especialidad: any) {
    const especialidadConNombreId = { nombre: especialidad.descripcion,
      id:especialidad.id
     };

    if (!this.listaEspecialidades.some((e:any) => e.nombre === especialidad.descripcion)) {
      if (this.listaEspecialidades.length < 1) {
        this.listaEspecialidades.push(especialidadConNombreId);
        this.botonClickeado.emit(this.listaEspecialidades);
      }
    } else {
      const indice = this.listaEspecialidades.findIndex((e:any) => e.nombre === especialidad.descripcion);
      this.listaEspecialidades.splice(indice, 1);
      this.botonClickeado.emit(this.listaEspecialidades);
    }
  
  }
}
