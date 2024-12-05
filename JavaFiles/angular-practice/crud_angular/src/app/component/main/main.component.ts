import { Component } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';

@Component({
  selector: 'app-main',
  standalone:true,
  imports:[ReactiveFormsModule,FormsModule],
  templateUrl: './main.component.html',
  styleUrl: './main.component.css'
})
export class MainComponent {
  form!: FormGroup;
  constructor(
    
    private fb:FormBuilder,

  ) { }
  ngOnInit() { //run these automatically when the server loads &is ready
    this.form=this.fb.group({
      name: [
        null,
        [
          Validators.required,
          Validators.pattern('^[a-zA-Z ]*$') // Allows only letters and spaces
        ]
      ],
  })
  }
  onSubmit() {
    const name = this.form.get('name') as FormControl;
    console.log(name?.value);
  }
}
