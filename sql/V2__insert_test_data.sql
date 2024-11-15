INSERT INTO user (id, username, email, password, role) VALUES (1, 'codenozzle', 'rm.harrison.jr@gmail.com', '$2a$12$zXtCQnW61T9GKjKROSvnNO4W8EWB6FJ4.RUv7ToiGvpq0a91j8PMW', 1);

INSERT INTO customer (id, name, email) VALUES (1, 'WidgetWorks', 'user@WidgetWorks.com');
INSERT INTO customer (id, name, email) VALUES (2, 'TechTonic', 'user@TechTonic.com');
INSERT INTO customer (id, name, email) VALUES (3, 'ByteBright', 'user@ByteBright.com');
INSERT INTO customer (id, name, email) VALUES (4, 'Nimbus Labs', 'user@NimbusLabs.com');
INSERT INTO customer (id, name, email) VALUES (5, 'Nova Nexus', 'user@NovaNexus.com');
INSERT INTO customer (id, name, email) VALUES (6, 'Sparkline', 'user@Sparkline.com');
INSERT INTO customer (id, name, email) VALUES (7, 'Zelocity', 'user@Zelocity.com');

INSERT INTO account (id, account_number, name, balance) VALUES (1, 'IR3LZZ42H4', 'Operational Expense Account', 50645);
INSERT INTO account (id, account_number, name, balance) VALUES (2, 'ZHX35SEMDK', 'Capital Investments Fund', 38700);
INSERT INTO account (id, account_number, name, balance) VALUES (3, 'LJ4B4CYYGP', 'Vendor Payment Account', 70960);
INSERT INTO account (id, account_number, name, balance) VALUES (4, 'BER8HUSIYO', 'Travel & Entertainment Account', 20500);
INSERT INTO account (id, account_number, name, balance) VALUES (5, 'YLK4WBBMPQ', 'Project Allocation Account', 150028);

SET @MIN = NOW() - INTERVAL 2 MONTH;
SET @MAX = now();

INSERT INTO transaction (id, account_id, amount, description, timestamp) VALUES (1, 1, 1590.55, 'Software License Renewal', TIMESTAMPADD(SECOND, FLOOR(RAND() * TIMESTAMPDIFF(SECOND, @MIN, @MAX)), @MIN));




# Customer,Account,Amount,Description
# WidgetWorks,Operational Expense Account,1590.55,Software License Renewal
# Nova Nexus,Travel & Entertainment Account,1466.23,Conference Ticket
# TechTonic,Project Allocation Account,2426.22,Project X Materials
# Nimbus Labs,Capital Investments Fund,2520.02,Machinery Acquisition
# Nova Nexus,Capital Investments Fund,1187.26,Machinery Acquisition
# TechTonic,Travel & Entertainment Account,388.0,Client Dinner
# Zelocity,Operational Expense Account,2829.02,Utility Bill
# Zelocity,Travel & Entertainment Account,1095.17,Hotel Stay
# TechTonic,Travel & Entertainment Account,4919.25,Client Dinner
# ByteBright,Vendor Payment Account,272.01,Contractor Payment
# Nimbus Labs,Operational Expense Account,3657.79,Utility Bill
# WidgetWorks,Project Allocation Account,1774.45,Prototype Development
# Nimbus Labs,Travel & Entertainment Account,3902.03,Flight Booking
# WidgetWorks,Project Allocation Account,4365.73,Prototype Development
# Nimbus Labs,Project Allocation Account,1926.68,Prototype Development
# TechTonic,Operational Expense Account,2571.5,Facility Maintenance
# Zelocity,Travel & Entertainment Account,3319.74,Conference Ticket
# Nova Nexus,Project Allocation Account,2234.87,Research Funding
# Nova Nexus,Capital Investments Fund,4764.56,Machinery Acquisition
# Nimbus Labs,Travel & Entertainment Account,2539.94,Conference Ticket
# TechTonic,Project Allocation Account,1136.82,Prototype Development
# Nimbus Labs,Capital Investments Fund,2613.77,R&D Equipment
# ByteBright,Capital Investments Fund,520.99,Office Renovation
# Nimbus Labs,Travel & Entertainment Account,3071.44,Flight Booking
# Nova Nexus,Capital Investments Fund,1481.94,Machinery Acquisition
# TechTonic,Travel & Entertainment Account,484.1,Flight Booking
# Sparkline,Operational Expense Account,3482.23,Utility Bill
# Nimbus Labs,Travel & Entertainment Account,2758.6,Client Dinner
# Zelocity,Capital Investments Fund,4749.25,New Server Purchase
# Sparkline,Project Allocation Account,1495.7,Research Funding
# Nova Nexus,Travel & Entertainment Account,3101.12,Conference Ticket
# Nimbus Labs,Vendor Payment Account,2944.84,Monthly Subscription Fee
# Zelocity,Capital Investments Fund,4494.74,Office Renovation
# WidgetWorks,Capital Investments Fund,606.36,R&D Equipment
# TechTonic,Operational Expense Account,818.15,Office Supplies
# Sparkline,Vendor Payment Account,4247.05,Consulting Services
# TechTonic,Travel & Entertainment Account,114.36,Hotel Stay
# Zelocity,Capital Investments Fund,2456.19,Machinery Acquisition
# TechTonic,Operational Expense Account,891.63,Facility Maintenance
# WidgetWorks,Vendor Payment Account,4857.87,Monthly Subscription Fee
# TechTonic,Project Allocation Account,3963.16,Project X Materials
# WidgetWorks,Capital Investments Fund,2542.12,Office Renovation
# Nova Nexus,Vendor Payment Account,2103.77,Consulting Services
# Nimbus Labs,Vendor Payment Account,4993.52,Contractor Payment
# ByteBright,Vendor Payment Account,3758.38,Monthly Subscription Fee
# Nimbus Labs,Vendor Payment Account,1646.76,Contractor Payment
# TechTonic,Travel & Entertainment Account,2245.55,Conference Ticket
# WidgetWorks,Capital Investments Fund,2889.35,New Server Purchase
# TechTonic,Vendor Payment Account,2193.92,Consulting Services
# Nova Nexus,Travel & Entertainment Account,3386.78,Flight Booking




