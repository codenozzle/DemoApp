import {Component, OnInit, ViewChild} from '@angular/core';
import { ApiService } from '../api.service';
import { Customer } from '../models/customer.model';
import { MatTableDataSource } from '@angular/material/table';
import {MatPaginator} from "@angular/material/paginator";
import { Router } from '@angular/router';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.scss']
})
export class CustomerComponent implements OnInit {
  customers: Customer[] = [];
  dataSource = new MatTableDataSource<Customer>();
  displayedColumns: string[] = ['id', 'name', 'actions'];
  newCustomer: Customer = { id: 0, name: '' };
  editingCustomer: Customer | null = null;
  @ViewChild(MatPaginator) paginator: MatPaginator;

  constructor(private apiService: ApiService, private router: Router) {}

  ngOnInit(): void {
    this.getCustomers();
  }

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
  }

  getCustomers(): void {
    this.apiService.getCustomers().subscribe(customers => {
      this.customers = customers;
      this.dataSource.data = customers;
    });
  }

  createCustomer(): void {
    if (this.editingCustomer) {
      this.apiService.updateCustomer(this.newCustomer).subscribe(() => {
        this.getCustomers();
        this.cancelEdit();
      });
    } else {
      this.apiService.createCustomer(this.newCustomer).subscribe(customer => {
        this.customers.push(customer);
        this.dataSource.data = this.customers;
        this.newCustomer = { id: 0, name: '' };
      });
    }
  }

  editCustomer(customer: Customer): void {
    this.editingCustomer = customer;
    this.newCustomer = { ...customer };
  }

  cancelEdit(): void {
    this.editingCustomer = null;
    this.newCustomer = { id: 0, name: '' };
  }
}
