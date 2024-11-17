import { Component, OnInit } from '@angular/core';
import { ApiService } from '../api.service';
import { ChartData, ChartType } from 'chart.js';
import { Customer } from '../models/customer.model';
import { Account } from '../models/account.model';
import { Transaction } from '../models/transaction.model';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {
  customers: Customer[] = [];
  accounts: Account[] = [];
  transactions: Transaction[] = [];

  public customerChartData: ChartData<'doughnut'>;
  public accountChartData: ChartData<'bar'>;
  public transactionChartData: ChartData<'line'>;

  public chartOptions = {
    responsive: true,
  };

  constructor(private apiService: ApiService) {
    this.customerChartData = {
      labels: [],
      datasets: [{ data: [] }]
    };
    this.accountChartData = {
      labels: [],
      datasets: [{ data: [] }]
    };
    this.transactionChartData = {
      labels: [],
      datasets: [{ data: [] }]
    };
  }

  ngOnInit(): void {
    this.getCustomers();
    this.getAccounts();
    this.getTransactions();
  }

  getCustomers(): void {
    this.apiService.getCustomers().subscribe(customers => {
      this.customers = customers;
      this.customerChartData = {
        labels: ['Total Customers'],
        datasets: [{ data: [customers.length], backgroundColor: ['#42A5F5'] }]
      };
    });
  }

  getAccounts(): void {
    this.apiService.getAccounts().subscribe(accounts => {
      this.accounts = accounts;
      this.accountChartData = {
        labels: accounts.map(account => account.accountNumber),
        datasets: [{ data: accounts.map(account => account.balance), label: 'Account Balances', backgroundColor: ['#66BB6A'] }]
      };
    });
  }

  getTransactions(): void {
    this.apiService.getTransactions().subscribe(transactions => {
      this.transactions = transactions;
      this.transactionChartData = {
        labels: transactions.map(transaction => transaction.timestamp),
        datasets: [{ data: transactions.map(transaction => transaction.amount), label: 'Transaction Amounts', borderColor: '#FFA726', fill: false }]
      };
    });
  }
}
