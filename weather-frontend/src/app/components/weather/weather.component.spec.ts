import { ComponentFixture, TestBed } from '@angular/core/testing';
import { WeatherComponent } from './weather.component';

/**
 * Unit Test Suite for WeatherComponent
 * Suite de Pruebas Unitarias para WeatherComponent
 */
describe('WeatherComponent', () => {
  let component: WeatherComponent;
  let fixture: ComponentFixture<WeatherComponent>;

  /**
   * Async setup to initialize the testing module
   * Configuración asíncrona para inicializar el módulo de pruebas
   */
  beforeEach(async () => {
    await TestBed.configureTestingModule({
      // Standalone components are imported directly in the testing module
      // Los componentes standalone se importan directamente en el módulo de pruebas
      imports: [WeatherComponent],
    }).compileComponents();

    // Create the component instance and its test fixture
    // Crea la instancia del componente y su entorno de pruebas (fixture)
    fixture = TestBed.createComponent(WeatherComponent);
    component = fixture.componentInstance;

    // Wait for async initialization (like template data binding)
    // Espera a que la inicialización asíncrona finalice (como el data binding)
    await fixture.whenStable();
  });

  /**
   * Basic sanity check: Verify the component is successfully instantiated
   * Prueba de humo básica: Verifica que el componente se instancie correctamente
   */
  it('should create the component instance', () => {
    expect(component).toBeTruthy();
  });

  /**
   * Note for Recruiters:
   * Additional tests would typically mock the WeatherService to test
   * UI behavior during data fetching and error handling.
   * * Nota para Reclutadores:
   * Pruebas adicionales normalmente usarían mocks del WeatherService para probar
   * el comportamiento de la UI durante la carga de datos y manejo de errores.
   */
});
