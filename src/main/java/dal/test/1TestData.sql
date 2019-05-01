INSERT INTO Status VALUES (1, 'TEST-STATUS_Bestilt');
INSERT INTO Status VALUES (2, 'TEST-STATUS_Under Produktion');
INSERT INTO Status VALUES (3, 'TEST-STATUS_Færdiggjort');

INSERT INTO Roles VALUES (1,'TEST_Farmaceut');
INSERT INTO Roles VALUES (2,'TEST_Produktionsleder');
INSERT INTO Roles VALUES (3,'TEST_Laborant');
INSERT INTO Roles VALUES (4,'TEST_Administrator');

INSERT INTO Product VALUES (1, 'TEST_P-Piller');
INSERT INTO Recipe VALUES (1, 'TEST_Opskrift', 1);

INSERT INTO Commodity VALUES (1,'TEST_Estradiol', 1, 0);
INSERT INTO Commodity VALUES (2,'TEST_Norethisteronacetat', 1, 0);
INSERT INTO Commodity VALUES (3,'TEST_Opovidon', 0, 0);
INSERT INTO Commodity VALUES (4,'TEST_Laktosemonohydrat', 0, 0);
INSERT INTO Commodity VALUES (5,'TEST_Magnesiumstearat',0,0);
INSERT INTO Commodity VALUES (6,'TEST_Majsstivelse',0,0);

INSERT INTO Ingredient VALUES (1, 1, 1, 0.05);
INSERT INTO Ingredient VALUES (1, 2, 0.5 , 0.05);
INSERT INTO Ingredient VALUES (1, 3, 50, 0.01);
INSERT INTO Ingredient VALUES (1, 4, 10, 0.01);
INSERT INTO Ingredient VALUES (1, 5, 15, 0.05);
INSERT INTO Ingredient VALUES (1, 6, 120, 0.05);

INSERT INTO pBatch VALUES (1, 1, 1, 500*21, 2);

INSERT INTO cBatch VALUES (23, 1, 'TEST_Manufacturer A', 10000000, 0);
INSERT INTO cBatch VALUES (24, 2, 'TEST_Manufacturer A', 10000000, 0);
INSERT INTO cBatch VALUES (25, 3, 'TEST_Manufacturer A', 10000000, 0);
INSERT INTO cBatch VALUES (26, 4, 'TEST_Manufacturer A', 10000000, 0);
INSERT INTO cBatch VALUES (27, 5, 'TEST_Manufacturer A', 10000000, 0);
INSERT INTO cBatch VALUES (28, 6, 'TEST_Manufacturer A', 10000000, 0);

INSERT INTO cBatch VALUES (33, 1, 'TEST_Manufacturer B', 20000000, 0);
INSERT INTO cBatch VALUES (34, 2, 'TEST_Manufacturer B', 1000000, 0);
INSERT INTO cBatch VALUES (35, 3, 'TEST_Manufacturer B', 2000000, 0);
INSERT INTO cBatch VALUES (36, 4, 'TEST_Manufacturer B', 10000000, 0);
INSERT INTO cBatch VALUES (37, 5, 'TEST_Manufacturer B', 10000000, 0);
INSERT INTO cBatch VALUES (38, 6, 'TEST_Manufacturer B', 100000, 0);

INSERT INTO Extract VALUES (1, 23, 1);
INSERT INTO Extract VALUES (1, 24, 2);
INSERT INTO Extract VALUES (1, 25, 3);
INSERT INTO Extract VALUES (1, 36, 4);
INSERT INTO Extract VALUES (1, 37, 5);
INSERT INTO Extract VALUES (1, 28, 6);