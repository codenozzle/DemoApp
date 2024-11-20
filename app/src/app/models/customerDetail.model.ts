import { Customer } from './customer.model';
import { Account } from "./account.model";
import { Transaction } from "./transaction.model";

export interface CustomerDetail {
  customer: Customer;
  accounts: Account[];
  transactions: Transaction[];
  numberOfTransactions: number;
  numberOfAccounts: number;
  totalBalance: number;
  totalSpendingLimit: number;
  creditRatio: number;
}
