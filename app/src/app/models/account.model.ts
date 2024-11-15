import { Customer } from './customer.model';

export interface Account {
    id: number;
    accountNumber: string;
    balance: number;
    customers: Customer[];
}
