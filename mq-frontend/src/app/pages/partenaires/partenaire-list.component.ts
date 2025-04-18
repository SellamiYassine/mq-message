import { Component, OnInit } from '@angular/core';
import { PartenaireService, Partenaire } from '../../core/services/partenaire.service';
import { MatTableModule } from '@angular/material/table';
import { PartenaireFormComponent } from '../partenaires/partenaire-form.component';

@Component({
imports: [
MatTableModule,
PartenaireFormComponent
],
selector: 'app-partenaire-list',
templateUrl: './partenaire-list.component.html',
standalone: true,
})
export class PartenaireListComponent implements OnInit {
partenaires: Partenaire[] = [];
displayedColumns: string[] = ['id', 'alias', 'type', 'direction', 'application', 'processedFlowType', 'description', 'actions'];

constructor(private partenaireService: PartenaireService) { }

  ngOnInit(): void {
    this.partenaireService.getPartenaires().subscribe(data => this.partenaires = data);
  }

  deletePartenaire(id: number): void {
    this.partenaireService.deletePartenaire(id).subscribe(() => {
      this.partenaireService.getPartenaires().subscribe(data => this.partenaires = data);
    });
  }
}
