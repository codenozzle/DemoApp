import {Component, OnInit, ViewChild} from '@angular/core';
import { ApiService } from '../api.service';
import { Account } from '../models/account.model';
import { MatTableDataSource } from '@angular/material/table';
import {MatPaginator} from "@angular/material/paginator";

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.scss']
})
export class AccountComponent implements OnInit {
  accounts: Account[] = [];
  dataSource = new MatTableDataSource<Account>();
  displayedColumns: string[] = ['id', 'creditCardNumber', 'creditCardType', 'balance', 'spendingLimit', 'actions'];
  newAccount: Account = { id: 0, creditCardNumber: '', creditCardType: '', balance: 0, spendingLimit: 0 };
  editingAccount: Account | null = null;
  @ViewChild(MatPaginator) paginator: MatPaginator;

  constructor(private apiService: ApiService) {}

  ngOnInit(): void {
    this.getAccounts();
  }

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
  }

  getAccounts(): void {
    this.apiService.getAccounts().subscribe(accounts => {
      this.accounts = accounts;
      this.dataSource.data = accounts;
    });
  }

  createAccount(): void {
    if (this.editingAccount) {
      this.apiService.updateAccount(this.newAccount).subscribe(() => {
        this.getAccounts();
        this.cancelEdit();
      });
    } else {
      this.apiService.createAccount(this.newAccount).subscribe(account => {
        this.accounts.push(account);
        this.dataSource.data = this.accounts;
        this.newAccount = { id: 0, creditCardNumber: '', creditCardType: '', balance: 0, spendingLimit: 0 };
      });
    }
  }

  editAccount(account: Account): void {
    this.editingAccount = account;
    this.newAccount = { ...account };
  }

  cancelEdit(): void {
    this.editingAccount = null;
    this.newAccount = { id: 0, creditCardNumber: '', creditCardType: '', balance: 0, spendingLimit: 0 };
  }
}
