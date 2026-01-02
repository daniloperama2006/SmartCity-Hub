import { bootstrapApplication } from '@angular/platform-browser';
import { AppComponent } from '../src/app/app';
import { provideHttpClient } from '@angular/common/http';
import { provideRouter } from '@angular/router';

bootstrapApplication(AppComponent, {
  providers: [
    provideHttpClient(),
    provideRouter([]), // Routes can be added here if needed in the future
  ],
});
