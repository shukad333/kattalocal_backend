

SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE table clicks;
TRUNCATE table offer;
TRUNCATE table events;
delete from business;
INSERT INTO `business` VALUES (1,'Home Fresh','A4345MTDY1',_binary '',11.80562591002969,75.99492567974923,'Sport Shope','','','','PENDING'),(2,'Sports Town','A4345MTDY13',_binary '',11.80562591002969,75.99492567974923,'Sport Shope','','','','PENDING'),(3,'Focus Mall','KA6736',_binary '',11.261884286595464,75.77785151666103,'Mall','','','','PENDING'),(5,'Nike Store,Feroke','KA67362',_binary '',11.173782379173195,75.83956722715229,'Mall','','','','PENDING'),(7,'Fruit Store','KA673612',_binary '',11.259018077347958,75.78028217320397,'Grocery','','','','PENDING');

INSERT INTO `offer` VALUES (1,1,'Thakkali Offer','XXXX Just for today cool offers!','100','90','2023-07-22','2023-07-22',NULL,1,'',1),(2,1,'RTomato','XXXX Just for today cool offers!','100','90','2023-07-22','2023-07-22',NULL,1,'4 kg',1),(3,2,'Nike','XXXX Just for today cool offers!','100','90','2023-07-22','2023-07-22',NULL,1,'6 litre',1),(4,3,'Dress','XXXX Just for today cool offers!','100','90','2023-07-22','2023-07-22',NULL,1,'',1),(5,5,'Vat','XXXX Just for today cool offers!','100','90','2023-07-22','2023-07-22',NULL,1,'',1),(6,5,'Pineapple','10 rs for a KG','50','10','2023-07-22','2023-07-22',NULL,1,'',1),(7,7,'Pineapple','10 rs for a KG','50','10','2023-07-22','2023-07-22',NULL,1,'',1);

INSERT INTO `events` VALUES (1,7,'Shop closing for 2 days','10 rs for a KG','2023-07-22','2023-07-22',NULL,_binary ''),(2,1,'Special PazhamPOri','Pazham pori and Uchishtam','2023-07-22','2023-07-22',NULL,_binary ''),(3,2,'Yonex Offer 50%','Badminton Yonex offer','2023-07-22','2023-07-22',NULL,_binary '');
SET FOREIGN_KEY_CHECKS = 1;