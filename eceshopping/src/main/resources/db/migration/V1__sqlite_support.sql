CREATE TABLE Users (
	id integer PRIMARY KEY AUTOINCREMENT,
	email varchar,
	password varchar,
	name varchar,
	admin boolean
);

CREATE TABLE Products (
	id integer PRIMARY KEY AUTOINCREMENT,
	name varchar,
	price float,
	bulk_price float,
	image blob
);

CREATE TABLE Grades (
	user_id integer,
	product_id integer,
	grade integer,
	comment varchar
);

CREATE TABLE Sessions (
	id integer PRIMARY KEY AUTOINCREMENT,
	user_id integer,
	start_time timestamp
);

CREATE TABLE Baskets (
	user_id integer,
	id integer PRIMARY KEY AUTOINCREMENT
);

CREATE TABLE Basket_Items (
	id integer PRIMARY KEY AUTOINCREMENT,
	basket_id integer,
	product_id integer,
	quantity integer
);

CREATE TABLE Purchases (
	id integer PRIMARY KEY AUTOINCREMENT,
	user_id integer,
	purchase_date datetime
);

CREATE TABLE Purchase_Items (
	id integer PRIMARY KEY AUTOINCREMENT,
	purchase_id integer,
	product_id integer
);
