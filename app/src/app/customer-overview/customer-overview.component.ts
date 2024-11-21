import {Component, Input, OnInit, ViewChild} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import { ApiService } from '../api.service';
import {CustomerDetail} from "../models/customerDetail.model";
import {MatPaginator} from "@angular/material/paginator";
import {MatTableDataSource} from "@angular/material/table";
import {Account} from "../models/account.model";
import {Transaction} from "../models/transaction.model";

@Component({
  selector: 'app-customer-overview',
  templateUrl: './customer-overview.component.html',
  styleUrls: ['./customer-overview.component.scss']
})
export class CustomerOverviewComponent implements OnInit {
  customerDetail: CustomerDetail | null = null;
  dataSource = new MatTableDataSource<Account>();
  dataSource2 = new MatTableDataSource<Transaction>();
  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatPaginator) paginator2: MatPaginator;

  constructor(private route: ActivatedRoute, private apiService: ApiService, private router: Router) {}

  ngOnInit(): void {
    const customerId = this.route.snapshot.paramMap.get('id');
    if (customerId) {
      this.getCustomerDetails(+customerId);
    }
  }

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
    this.dataSource2.paginator = this.paginator2;
  }

  getCustomerDetails(customerId: number): void {
    this.apiService.getCustomerDetails(customerId).subscribe(customerDetails => {
      this.customerDetail = customerDetails;
      this.dataSource.data = customerDetails.accounts;
      this.dataSource2.data = customerDetails.transactions;
    });
  }

  goToCustomers() {
    this.router.navigate(['/customers']);
  }
}
