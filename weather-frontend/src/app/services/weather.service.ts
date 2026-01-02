import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../enviroments/enviroment';

/**
 * Service to handle all weather-related API communications.
 * Servicio para manejar todas las comunicaciones de API relacionadas con el clima.
 */
@Injectable({
  providedIn: 'root', // This service is available globally (Singleton) / Este servicio está disponible globalmente (Singleton)
})
export class WeatherService {
  /**
   * API endpoint constructed from environment variables for better scalability.
   * Endpoint de la API construido desde variables de entorno para mejor escalabilidad.
   */
  private apiUrl = `${environment.apiUrl}/weather`;

  constructor(private http: HttpClient) {}

  /**
   * Fetches weather data for a specific city.
   * Obtiene datos meteorológicos para una ciudad específica.
   * * @param city Name of the city to search / Nombre de la ciudad a buscar
   * @returns An Observable with the weather data / Un Observable con los datos del clima
   */
  getWeatherByCity(city: string): Observable<any> {
    // Standard GET request using Angular's HttpClient
    // Petición GET estándar usando el HttpClient de Angular
    return this.http.get(`${this.apiUrl}/${city}`);
  }
}
