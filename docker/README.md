# mysql 8 grant privileges

mysql> CREATE DATABASE jdbc DEFAULT CHARACTER SET utf8mb4;
mysql> CREATE USER 'dbuser'@'%' IDENTIFIED BY 'dbpass';
mysql> GRANT ALL PRIVILEGES ON *.* TO 'dbuser'@'%' WITH GRANT OPTION;
mysql> FLUSH PRIVILEGES;
