CREATE KEYSPACE mykeyspace
    WITH REPLICATION = {
        'class': 'SimpleStrategy', 
        'replication_factor': 1
    };


    CREATE TABLE ExchangeValue (
    id INT PRIMARY KEY,
    fromCurrency TEXT,
    toCurrency TEXT,
    port INT,
    conversionMultiple DECIMAL
);

INSERT INTO ExchangeValue (id, fromCurrency, toCurrency, conversionMultiple) VALUES (1, 'USD', 'INR', 65);
INSERT INTO ExchangeValue (id, fromCurrency, toCurrency, conversionMultiple) VALUES (1, 'GBP', 'INR', 75);
INSERT INTO ExchangeValue (id, fromCurrency, toCurrency, conversionMultiple) VALUES (3, 'AUD', 'INR', 50);