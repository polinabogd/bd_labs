# Stored Procedures, Triggers? Functions in MySQL

## Database of electronic resources with books
### STORED PROCEDURES
1. Ensure parameterized insertion of new values in
table Users.
2. Create a package that inserts 10 rows into the Book table in the
mother <Noname + No>, for example: Noname5, Noname6, Noname7, etc.
3. Using the cursor, ensure the dynamic creation of the database
with Usernames, with a random number of tables for
each database (from 1 to 9). The structure of the tables is arbitrary. Names
tables correspond to the name of the User with the serial number
from 1 to 9.
### FUNCTIONS
1. For the Users table, write the function as it will search
MAX Column Rating. Then make a data sample (SELECT),
using this function.
2. Write a function that extracts the key between the tables
Catalog tree and Books value field Heading. Then
make a sample of all data (SELECT) from the table Books,
using this function.
### TRIGGERS
1. Ensure the integrity of the values for the database structure.
2. Value Users → Rating should be within [0; 5],
the data type allows only two digits after the comma;
3. for Book → UDC provide format: 2 arbitrary letters + '.' + 3 digits.
4. Disable deleting ribbons from the Passwords table.
