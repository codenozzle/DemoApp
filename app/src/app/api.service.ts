import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Customer } from './models/customer.model';
import { Account } from './models/account.model';
import { Transaction } from './models/transaction.model';
import {TransactionCountHistory} from "./models/transactionCountHistory.model";
import {TransactionAmountHistory} from "./models/transactionAmountHistory.model";
import {CustomerDetail} from "./models/customerDetail.model";
import {CustomerWizardModel} from "./models/customerWizard.model";

@Injectable({ providedIn: 'root' })
export class ApiService {
  private baseUrl = 'http://localhost:8080/api';

  constructor(private http: HttpClient) {}

  getCustomers(): Observable<Customer[]> {
    return this.http.get<Customer[]>(`${this.baseUrl}/customer`);
  }

  createCustomer(customer: Customer): Observable<Customer> {
    return this.http.post<Customer>(`${this.baseUrl}/customer`, customer);
  }

  getAccounts(): Observable<Account[]> {
    return this.http.get<Account[]>(`${this.baseUrl}/account`);
  }

  createAccount(account: Account): Observable<Account> {
    return this.http.post<Account>(`${this.baseUrl}/account`, account);
  }

  getTransactions(): Observable<Transaction[]> {
    return this.http.get<Transaction[]>(`${this.baseUrl}/transaction`);
  }

  createTransaction(transaction: Transaction): Observable<Transaction> {
    return this.http.post<Transaction>(`${this.baseUrl}/transaction`, transaction);
  }

  getTransactionCountHistory(): Observable<TransactionCountHistory[]> {
    return this.http.get<TransactionCountHistory[]>(`${this.baseUrl}/customer/countHistory`);
  }

  getTransactionAmountHistory(): Observable<TransactionAmountHistory[]> {
    return this.http.get<TransactionAmountHistory[]>(`${this.baseUrl}/customer/amountHistory`);
  }

  updateCustomer(customer: Customer): Observable<Customer> {
    return this.http.put<Customer>(`${this.baseUrl}/customer/${customer.id}`, customer);
  }

  updateAccount(account: Account): Observable<Account> {
    return this.http.put<Account>(`${this.baseUrl}/account/${account.id}`, account);
  }

  updateTransaction(transaction: Transaction): Observable<Transaction> {
    return this.http.put<Transaction>(`${this.baseUrl}/transaction/${transaction.id}`, transaction);
  }

  getCustomerDetails(customerId: number): Observable<CustomerDetail> {
    return this.http.get<CustomerDetail>(`${this.baseUrl}/customer/${customerId}/details`);
  }

  createCustomerWizard(newCustomer: CustomerWizardModel): Observable<CustomerWizardModel> {
    return this.http.post<CustomerWizardModel>(`${this.baseUrl}/customer/onboard`, newCustomer);
  }
}
