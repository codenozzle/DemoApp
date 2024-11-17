import { Component, OnInit } from '@angular/core';
import { ApiService } from '../api.service';
import { Customer } from '../models/customer.model';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.scss']
})
export class CustomerComponent implements OnInit {
  customers: Customer[] = [];
  newCustomer: Customer = { id: 0, name: '', email: '' };

  constructor(private apiService: ApiService) {}

  ngOnInit(): void {
    this.getCustomers();
  }

  getCustomers(): void {
    this.apiService.getCustomers().subscribe(customers => {
      this.customers = customers;
    });
  }

  createCustomer(): void {
    this.apiService.createCustomer(this.newCustomer).subscribe(customer => {
      this.customers.push(customer);
      this.newCustomer = { id: 0, name: '', email: '' };
    });
  }
}
