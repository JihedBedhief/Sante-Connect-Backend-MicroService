-- Create database if it doesn't exist
CREATE DATABASE IF NOT EXISTS keycloak;

-- Grant all privileges to root user on localhost
GRANT ALL PRIVILEGES ON *.* TO 'root'@'localhost' WITH GRANT OPTION;
FLUSH PRIVILEGES;

-- Set authentication plugin and password for root user
ALTER USER 'root'@'localhost' IDENTIFIED WITH caching_sha2_password  BY 'root';
FLUSH PRIVILEGES;
