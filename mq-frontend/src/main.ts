import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';
import { bootstrapApplication } from '@angular/platform-browser';
import { AppModule } from './app/app.module';
import { AppComponent } from './app/app.component';
import { provideRouter } from '@angular/router';
import routeConfig from './app/routes';
import { enableProdMode } from '@angular/core';
import { provideHttpClient } from '@angular/common/http';


enableProdMode();
bootstrapApplication(AppComponent,
  {
    providers: [
      provideRouter(routeConfig), provideHttpClient()
    ]
  }
).catch(err => console.error(err));
