CREATE TABLE MUNROS AS
SELECT *
FROM CSVREAD('classpath:csv/munrotab_v6.2.csv');