import {Component, OnInit, ViewChild} from '@angular/core';
import { ApiService } from '../api.service';
import { Transaction } from '../models/transaction.model';
import { MatTableDataSource } from '@angular/material/table';
import {MatPaginator} from "@angular/material/paginator";

@Component({
  selector: 'app-transaction',
  templateUrl: './transaction.component.html',
  styleUrls: ['./transaction.component.scss']
})
export class TransactionComponent implements OnInit {
  transactions: Transaction[] = [];
  dataSource = new MatTableDataSource<Transaction>();
  displayedColumns: string[] = ['id', 'amount', 'description', 'timestamp', 'accountId', 'actions'];
  newTransaction: Transaction = { id: 0, amount: 0, description: '', timestamp: '', accountId: 0 };
  editingTransaction: Transaction | null = null;
  @ViewChild(MatPaginator) paginator: MatPaginator;

  constructor(private apiService: ApiService) {}

  ngOnInit(): void {
    this.getTransactions();
  }

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
  }

  getTransactions(): void {
    this.apiService.getTransactions().subscribe(transactions => {
      this.transactions = transactions;
      this.dataSource.data = transactions;
    });
  }

  createTransaction(): void {
    if (this.editingTransaction) {
      this.apiService.updateTransaction(this.newTransaction).subscribe(() => {
        this.getTransactions();
        this.cancelEdit();
      });
    } else {
      this.apiService.createTransaction(this.newTransaction).subscribe(transaction => {
        this.transactions.push(transaction);
        this.dataSource.data = this.transactions;
        this.newTransaction = { id: 0, amount: 0, description: '', timestamp: '', accountId: 0 };
      });
    }
  }

  editTransaction(transaction: Transaction): void {
    this.editingTransaction = transaction;
    this.newTransaction = { ...transaction };
  }

  cancelEdit(): void {
    this.editingTransaction = null;
    this.newTransaction = { id: 0, amount: 0, description: '', timestamp: '', accountId: 0 };
  }
}
