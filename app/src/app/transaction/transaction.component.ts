import { Component, OnInit } from '@angular/core';
import { ApiService } from '../api.service';
import { Transaction } from '../models/transaction.model';

@Component({
  selector: 'app-transaction',
  templateUrl: './transaction.component.html',
  styleUrls: ['./transaction.component.css']
})
export class TransactionComponent implements OnInit {
  transactions: Transaction[] = [];
  newTransaction: Transaction = { id: 0, amount: 0, type: '', timestamp: '', account: null };

  constructor(private apiService: ApiService) {}

  ngOnInit(): void {
    this.getTransactions();
  }

  getTransactions(): void {
    this.apiService.getTransactions().subscribe(transactions => {
      this.transactions = transactions;
    });
  }

  createTransaction(): void {
    this.apiService.createTransaction(this.newTransaction).subscribe(transaction => {
      this.transactions.push(transaction);
      this.newTransaction = { id: 0, amount: 0, type: '', timestamp: '', account: null };
    });
  }
}
