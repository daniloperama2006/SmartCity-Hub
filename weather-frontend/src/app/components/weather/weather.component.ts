import { Component, ChangeDetectorRef } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { WeatherService } from '../../services/weather.service';
import { finalize } from 'rxjs';

@Component({
  selector: 'app-weather',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './weather.component.html',
  styleUrls: ['./weather.component.css'],
})
export class WeatherComponent {
  // State management variables / Variables de gestión de estado
  city = '';
  weatherData: any = null;
  loading = false;
  error: string | null = null;

  constructor(
    private weatherService: WeatherService,
    private cdr: ChangeDetectorRef // Injected to handle manual change detection / Inyectado para manejar detección de cambios manual
  ) {}

  /**
   * Main method to fetch weather data / Método principal para obtener datos climáticos
   */
  searchWeather() {
    const cityQuery = this.city.trim();

    // Guard clause to prevent empty searches or multiple concurrent requests
    // Cláusula de guarda para evitar búsquedas vacías o múltiples peticiones simultáneas
    if (!cityQuery || this.loading) return;

    // Reset state before new request / Reiniciar estado antes de la nueva petición
    this.loading = true;
    this.error = null;
    this.weatherData = null;

    this.weatherService
      .getWeatherByCity(cityQuery)
      .pipe(
        // Ensure loading state is reset regardless of success or failure
        // Garantiza que el estado de carga se reinicie sin importar si hay éxito o fallo
        finalize(() => {
          this.loading = false;
          this.cdr.detectChanges(); // Sync UI with the final state / Sincronizar UI con el estado final
        })
      )
      .subscribe({
        next: (data) => {
          this.weatherData = data;
          // Trigger change detection to ensure immediate UI update
          // Disparar detección de cambios para asegurar actualización inmediata de la UI
          this.cdr.detectChanges();
        },
        error: (err) => {
          console.error('Weather Fetch Error:', err);
          this.error = 'No se pudo encontrar la ciudad o hubo un error.';
          this.cdr.detectChanges();
        },
      });
  }
}
