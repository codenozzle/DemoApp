import { Component, OnInit } from '@angular/core';
import { ApiService } from '../api.service';
import { Account } from '../models/account.model';

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.scss']
})
export class AccountComponent implements OnInit {
  accounts: Account[] = [];
  newAccount: Account = { id: 0, accountNumber: '', balance: 0, customers: [] };

  constructor(private apiService: ApiService) {}

  ngOnInit(): void {
    this.getAccounts();
  }

  getAccounts(): void {
    this.apiService.getAccounts().subscribe(accounts => {
      this.accounts = accounts;
    });
  }

  createAccount(): void {
    this.apiService.createAccount(this.newAccount).subscribe(account => {
      this.accounts.push(account);
      this.newAccount = { id: 0, accountNumber: '', balance: 0, customers: [] };
    });
  }
}
