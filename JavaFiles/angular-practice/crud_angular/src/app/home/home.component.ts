import { Component, NgModule, OnInit } from '@angular/core';
import { CustomerService } from '../service/customer.service';
import { FormBuilder, FormGroup, Validators,ReactiveFormsModule, FormsModule, FormControl } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Router, RouterModule } from '@angular/router';
import { AdminServiceService } from '../service/amin-service.service';
import { Customer } from '../customer';
import { MainComponent } from '../component/main/main.component';

//for reactive forms
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  standalone:true,
  imports: [ReactiveFormsModule,CommonModule,RouterModule],
  styleUrls: ['./home.component.css'],
})
export class HomeComponent {

  post_cus_form!: FormGroup;
  errorMessage: string | null = null; // To store the error message
  successMessage: string | null = null; 
  customers:Customer[]=[];
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
    private router: Router,
  ) { }

  ngOnInit() { //run these automatically when the server loads &is ready
    this.post_cus_form=this.fb.group({
      name: [
        null,
        [
          Validators.required,
          Validators.pattern('^[a-zA-Z ]*$') // Allows only letters and spaces
        ]
      ],
      age: [null, [Validators.required]],
      location: [null, [Validators.required]]
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
      (data:Customer[]) => {
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
          console.log(response);
            this.del_suc = response.suc_msg; // Display success message
            this.del_err = ''; // Clear any previous error messages
            this.fetchCustomers();
            this.deleteForm.reset(); // Reset the form
        },
        (error) => {
          console.log(error);
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
        console.log(response);
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

  goToMain() {
    this.router.navigate(['/main']);
  }
}



/*
//for template-driven forms

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  standalone:true,
  imports: [FormsModule,CommonModule],
  styleUrls: ['./home.component.css'],
})
export class HomeComponent {
  customerForm = {
    name: '',
    age: null,
    location: '',
  };

  searchId: number | null = null;
  updateData = {
    id: null,
    location: '',
  };
  deleteId: number | null = null;
  adminDeleteData = {
    adminId: null,
    customerId: null,
  };

  successMessage: string | null = null;
  errorMessage: string | null = null;
  del_suc: string | null = null;
  del_err: string | null = null;
  adminDelErr: string | null = null;
  adminDelSuc: string | null = null;

  customers: Customer[] = [];
  cus_search: any;

  constructor(
    private cusService: CustomerService,
    private adService: AdminServiceService
  ) {}

  ngOnInit() {
    this.fetchCustomers();
  }

  post_cus() {
    this.cusService.create_Customer(this.customerForm).subscribe(
      (res) => {
        this.successMessage = 'Customer added successfully!';
        this.customerForm = { name: '', age: null, location: '' };
        this.fetchCustomers();
      },
      (error) => {
        this.errorMessage = error.error.error || 'An unexpected error occurred.';
      }
    );
  }

  fetchCustomers(): void {
    this.cusService.get_Customers().subscribe((data: Customer[]) => {
      this.customers = data;
    });
  }

  onSearch(f: any) {
    const id = f.value.id; // Ensure you retrieve the value properly from the form
    this.cusService.getCustomerById(id).subscribe(
      (response) => {
        this.cus_search = response;
        this.errorMessage = null; // Reset error messages on success
      },
      (error) => {
        console.error('HTTP Error:', error); // Log the error to console
        this.cus_search = null;
        this.errorMessage = error.error.error || 'Customer not found!';
      }
    );
  }
  

  onUpdate() {
    const { id, location } = this.updateData;
    if (!id || !location) return;

    this.cusService.updateCustomerLocation(id, location).subscribe(
      (response) => {
        this.successMessage = 'Customer updated successfully!';
        this.updateData = { id: null, location: '' };
        this.fetchCustomers();
      },
      (error) => {
        this.errorMessage = 'Error updating customer location.';
      }
    );
  }

  onDelete() {
    if (!this.deleteId) return;

    this.cusService.deleteCustomerById(this.deleteId).subscribe(
      (response) => {
        this.del_suc = 'Customer deleted successfully!';
        this.del_err = null;
        this.fetchCustomers();
        this.deleteId = null;
      },
      (error) => {
        this.del_err = error.error.error || 'Customer not found!';
      }
    );
  }

  onAdminDelete() {
    const { adminId, customerId } = this.adminDeleteData;
    if (!adminId || !customerId) return;

    this.adService.adminDeleteCustomer(adminId, customerId).subscribe(
      (response) => {
        this.adminDelSuc = 'Customer deleted by admin successfully!';
        this.adminDelErr = null;
        this.adminDeleteData = { adminId: null, customerId: null };
        this.fetchCustomers();
      },
      (error) => {
        this.adminDelErr = 'Error deleting customer.';
      }
    );
  }
}
*/