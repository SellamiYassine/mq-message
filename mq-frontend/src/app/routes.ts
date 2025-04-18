import { Routes } from '@angular/router';
import { MessageListComponent } from './pages/messages/message-list.component';
import { PartenaireListComponent } from './pages/partenaires/partenaire-list.component';


const routeConfig: Routes = [
{ path: 'messages', component: MessageListComponent },
{ path: 'partenaires', component: PartenaireListComponent },
{ path: '', redirectTo: '/messages', pathMatch: 'full' }
];

export default routeConfig;
