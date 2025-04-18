import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MessageListComponent } from './pages/messages/message-list.component';
import { PartenaireListComponent } from './pages/partenaires/partenaire-list.component';

const routes: Routes = [
{ path: 'messages', component: MessageListComponent },
{ path: 'partenaires', component: PartenaireListComponent },
{ path: '', redirectTo: '/messages', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule],
  exports: [RouterModule]
})
export class AppRoutingModule { }
