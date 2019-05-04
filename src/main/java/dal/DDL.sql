CREATE TABLE Product (
	p_ID INT(6) PRIMARY KEY,
    name TEXT
);

CREATE TABLE Commodity (
	c_ID INT(6) PRIMARY KEY,
    name TEXT,
    active BOOLEAN,
    reorder BOOLEAN
);

CREATE TABLE cBatch (
	cb_ID INT(6) PRIMARY KEY,
    c_ID INT(6),
    manufacturer TEXT,
    stock INT,
    remainder BOOLEAN,
    FOREIGN KEY (c_ID) REFERENCES Commodity (c_ID)
);

CREATE TABLE Recipe (
	re_ID INT(6) PRIMARY KEY,
    title TEXT,
    p_ID INT(6),
    quantity INT,
    FOREIGN KEY (p_ID) REFERENCES Product (p_ID)
);

CREATE TABLE Ingredient (
	re_ID INT(6),
    c_ID INT(6),
    quantity INT,
    deviation DECIMAL(10,3),
    PRIMARY KEY (re_ID, c_ID),
    FOREIGN KEY (re_ID) REFERENCES Recipe (re_ID),
    FOREIGN KEY (c_ID) REFERENCES Commodity (c_ID)
);

CREATE TABLE Status (
	s_ID INT(6) PRIMARY KEY,
    name TEXT
);

CREATE TABLE pBatch (
pb_ID INT(6) PRIMARY KEY,
p_ID INT(6),
re_ID INT(6),
s_ID INT(6),
FOREIGN KEY (p_ID) REFERENCES Product (p_ID),
FOREIGN KEY (re_ID) REFERENCES Recipe (re_ID),
FOREIGN KEY (s_ID) REFERENCES Status (s_ID)
);

CREATE TABLE Extract (
	pb_ID INT(6),
    cb_ID INT(6),
    c_ID INT(6),
    PRIMARY KEY (pb_ID, cb_ID, c_ID),
    FOREIGN KEY (pb_ID) REFERENCES pBatch (pb_ID) ON DELETE CASCADE,
    FOREIGN KEY (cb_ID) REFERENCES cBatch (cb_ID),
    FOREIGN KEY (c_ID) REFERENCES Commodity (c_ID)
);

CREATE TABLE User (u_ID INT(6) PRIMARY KEY, name TEXT);

CREATE TABLE Roles (ro_ID INT(6) PRIMARY KEY, name VARCHAR(200) UNIQUE);

CREATE TABLE uRoles (
u_ID INT(6),
ro_ID INT(6),
FOREIGN KEY (u_ID) REFERENCES User (u_ID) ON DELETE CASCADE,
FOREIGN KEY (ro_ID) REFERENCES Roles (ro_ID),
PRIMARY KEY (u_ID, ro_ID));