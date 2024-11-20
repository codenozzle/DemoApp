import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Customer } from './models/customer.model';
import { Account } from './models/account.model';
import { Transaction } from './models/transaction.model';
import {TransactionCountHistory} from "./models/transactionCountHistory.model";
import {TransactionAmountHistory} from "./models/transactionAmountHistory.model";
import {CustomerDetail} from "./models/customerDetail.model";

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

  getTransactionCountHistory(): Observable<TransactionCountHistory[]> {
    return this.http.get<TransactionCountHistory[]>(`${this.baseUrl}/customers/countHistory`);
  }

  getTransactionAmountHistory(): Observable<TransactionAmountHistory[]> {
    return this.http.get<TransactionAmountHistory[]>(`${this.baseUrl}/customers/amountHistory`);
  }

  updateCustomer(customer: Customer): Observable<Customer> {
    return this.http.put<Customer>(`${this.baseUrl}/customers/${customer.id}`, customer);
  }

  updateAccount(account: Account): Observable<Account> {
    return this.http.put<Account>(`${this.baseUrl}/accounts/${account.id}`, account);
  }

  updateTransaction(transaction: Transaction): Observable<Transaction> {
    return this.http.put<Transaction>(`${this.baseUrl}/transactions/${transaction.id}`, transaction);
  }

  getCustomerDetails(customerId: number): Observable<CustomerDetail> {
    return this.http.get<CustomerDetail>(`${this.baseUrl}/customers/${customerId}/details`);
  }
}
