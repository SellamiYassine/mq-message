import { Component } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { PartenaireService } from '../../core/services/partenaire.service';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { FormGroup, FormControl, ReactiveFormsModule } from '@angular/forms';
import { PartenaireListComponent } from '../partenaires/partenaire-list.component';

@Component({
imports: [
MatFormFieldModule,
MatButtonModule,
MatInputModule,
MatSelectModule,
ReactiveFormsModule,
PartenaireListComponent
],
selector: 'app-partenaire-form',
templateUrl: './partenaire-form.component.html',
standalone: true,
})
export class PartenaireFormComponent {
form = this.fb.group({
alias: ['', Validators.required],
type: ['', Validators.required],
direction: ['INBOUND'],
application: [''],
processedFlowType: ['MESSAGE'],
description: ['', Validators.required]
});

constructor(private fb: FormBuilder, private partenaireService: PartenaireService, private partenaireListComponent: PartenaireListComponent) { }

  onSubmit(): void {
    if (this.form.valid) {
      this.partenaireService.addPartenaire(this.form.value).subscribe(() => {
        this.form.reset();
        this.partenaireService.getPartenaires().subscribe(data => this.partenaireListComponent.partenaires = data);
      });
    }
  }
}
