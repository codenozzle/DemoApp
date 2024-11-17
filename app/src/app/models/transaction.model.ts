import { Account } from './account.model';

export interface Transaction {
    id: number;
    amount: number;
    description: string;
    timestamp: string;
    account: Account;
}
