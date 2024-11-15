import { Account } from './account.model';

export interface Transaction {
  id: number;
  amount: number;
  type: string;
  timestamp: string;
  account: Account;
}
