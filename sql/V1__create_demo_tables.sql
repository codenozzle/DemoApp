CREATE TABLE user (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username varchar(50) NOT NULL,
    email varchar(50) NOT NULL,
    password varchar(255) NOT NULL,
    role int null,
    constraint username
        unique (username)
);

CREATE TABLE customer (
      id INT AUTO_INCREMENT PRIMARY KEY,
      name VARCHAR(255) NOT NULL,
      email VARCHAR(255) NOT NULL
);

CREATE TABLE account (
     id INT AUTO_INCREMENT PRIMARY KEY,
     account_number VARCHAR(20) NOT NULL,
     name VARCHAR(255) NOT NULL,
     balance DECIMAL(15, 2) NOT NULL
);

CREATE TABLE transaction (
     id INT AUTO_INCREMENT PRIMARY KEY,
     amount DECIMAL(15, 2) NOT NULL,
     description VARCHAR(255) NOT NULL,
     timestamp DATETIME NOT NULL,
     account_id INT,
     FOREIGN KEY (account_id) REFERENCES account(id)
);

CREATE TABLE customer_account (
      customer_id INT,
      account_id INT,
      PRIMARY KEY (customer_id, account_id),
      FOREIGN KEY (customer_id) REFERENCES customer(id),
      FOREIGN KEY (account_id) REFERENCES account(id)
);

-- Create relationships
ALTER TABLE transaction
    ADD CONSTRAINT fk_account_transaction
        FOREIGN KEY (account_id) REFERENCES account(id);

ALTER TABLE customer_account
    ADD CONSTRAINT fk_customer_account_customer
        FOREIGN KEY (customer_id) REFERENCES customer(id);

ALTER TABLE customer_account
    ADD CONSTRAINT fk_customer_account_account
        FOREIGN KEY (account_id) REFERENCES account(id);