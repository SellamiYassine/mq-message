import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { Component } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { MatToolbarModule } from '@angular/material/toolbar';
import { RouterModule } from '@angular/router';
import { MatTableModule } from '@angular/material/table';




@Component ({
imports: [
MatSlideToggleModule,
AppRoutingModule,
MatToolbarModule,
MatTableModule,
RouterModule
],
selector: 'app-root',
templateUrl: './app.component.html',
standalone: true,
})
export class AppComponent {

}
