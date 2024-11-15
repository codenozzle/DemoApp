import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Customer } from './models/customer.model';
import { Account } from './models/account.model';
import { Transaction } from './models/transaction.model';

@Injectable({ providedIn: 'root' })
export class ApiService {
  private baseUrl = 'http://localhost:8080/api';

  constructor(private http: HttpClient) {}

  getCustomers(): Observable<Customer[]> {
    return this.http.get<Customer[]>(`${this.baseUrl}/customers`);
  }

  createCustomer(customer: Customer): Observable<Customer> {
    return this.http.post<Customer>(`${this.baseUrl}/customers`, customer);
  }

  getAccounts(): Observable<Account[]> {
    return this.http.get<Account[]>(`${this.baseUrl}/accounts`);
  }

  createAccount(account: Account): Observable<Account> {
    return this.http.post<Account>(`${this.baseUrl}/accounts`, account);
  }

  getTransactions(): Observable<Transaction[]> {
    return this.http.get<Transaction[]>(`${this.baseUrl}/transactions`);
  }

  createTransaction(transaction: Transaction): Observable<Transaction> {
    return this.http.post<Transaction>(`${this.baseUrl}/transactions`, transaction);
  }
}
