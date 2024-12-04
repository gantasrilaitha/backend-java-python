import { Component } from '@angular/core';
import { CustomerService } from '../service/customer.service';
import { FormBuilder, FormGroup, Validators,ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { AdminServiceService } from '../service/amin-service.service';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [ReactiveFormsModule,CommonModule],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {

  post_cus_form!: FormGroup;
  errorMessage: string | null = null; // To store the error message
  successMessage: string | null = null; 
  customers=<any>[];
  searchForm!: FormGroup;
  updateForm!: FormGroup;
  cus_search:any;
  cus_update:any;
  deleteForm!: FormGroup;
  del_suc:string | null = null;
  del_err:string | null = null;
  adminDeleteForm!: FormGroup;
  adminDelErr: string | null = null;
  adminDelSuc: string | null = null;


  constructor(
    private cusService: CustomerService,
    private fb:FormBuilder,
    private adService:AdminServiceService,
    
  ) { }

  ngOnInit() {
    this.post_cus_form=this.fb.group({
      name: [null,Validators.required],
      age: [null,Validators.required],
      location: [null,Validators.required]
    }),
    this.searchForm=this.fb.group({
      id: [null,Validators.required]
    }),
    this.updateForm = this.fb.group({
      id: [null,Validators.required],
      location: [null, Validators.required]
    }),
    this.deleteForm = this.fb.group({
      id: [null, Validators.required], // ID field for deletion
  }),
  this.adminDeleteForm = this.fb.group({
    adminId: [null, Validators.required],
    customerId: [null, Validators.required],
  }),
    this.fetchCustomers();
  }

  post_cus() {
    this.errorMessage = null; // Reset error message
    this.cusService.create_Customer(this.post_cus_form.value).subscribe(
      (res) => {
        console.log(res);
        this.successMessage = 'Customer added successfully!';
        this.post_cus_form.reset(); // Reset the form on success
        this.fetchCustomers();
      },
      (error) => {
        console.error(error);
        this.errorMessage = error.error.error || 'An unexpected error occurred.';
      }
    );
  }

  fetchCustomers(): void {
    this.cusService.get_Customers().subscribe(
      (data) => {
        this.customers = data;
        console.log(data);
      }
    );
  }
  onSearch(f:FormGroup) {
    const id = f.get('id')?.value;
    this.cusService.getCustomerById(id).subscribe(
      (response) => {
        this.cus_search = response;
        this.errorMessage = '';  // Clear any previous error messages
      },
      (error) => {
        this.cus_search = null;
        this.errorMessage = 'Customer not found!';
      }
    );
  }

  onUpdate() {
    
    
      const id = this.updateForm.get('id')?.value;
      const updatedLocation = this.updateForm.get('location')?.value;
      this.cusService.updateCustomerLocation(id, updatedLocation).subscribe(
        (response) => {
          this.cus_update = response;
          this.errorMessage = '';
          this.successMessage = 'Customer updated successfully!';
          this.onSearch(this.updateForm);
          
        },
        (error) => {
          this.errorMessage = 'no such id, Error updating customer location.';
          this.successMessage = '';
        }
      );
    
  }

  onDelete() {
    const id = this.deleteForm.get('id')?.value;

    if (!id) {
        this.errorMessage = 'Please enter a valid Customer ID.';
        return;
    }

    this.cusService.deleteCustomerById(id).subscribe(
        (response) => {
            this.del_suc = response.suc_msg; // Display success message
            this.del_err = ''; // Clear any previous error messages
            this.fetchCustomers();
            this.deleteForm.reset(); // Reset the form
        },
        (error) => {
            this.del_err = error.error.error||'Customer not found!';
            this.del_suc = ''; // Clear any success messages

        }
    );
  }


  onAdminDelete() {
    const adminId = this.adminDeleteForm.get('adminId')?.value;
    const customerId = this.adminDeleteForm.get('customerId')?.value;

    this.adService.adminDeleteCustomer(adminId, customerId).subscribe(
      (response) => {
        this.adminDelSuc = response;
        this.adminDelErr = null;
        this.adminDeleteForm.reset(); // Reset form on success
      },
      (error) => {
        this.adminDelErr = error.error || 'Error deleting customer.';
        this.adminDelSuc = null;
      }
    );
  }

}
