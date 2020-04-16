SET FOREIGN_KEY_CHECKS = 0;
truncate table shopitem;
truncate table product;
truncate table category;
SET FOREIGN_KEY_CHECKS = 1;


insert into category values (null, 'Τρόφιμα');
insert into category values (null, 'Καθαριστικά');

insert into product values (null, 'Γάλα Όλυμπος χωρίς λακτόζη', 1);
insert into product values (null, 'Γιαούρτι Όλυμπος Freelact 2% λιπαρά', 1);
insert into product values (null, 'Δημητριακά All-Bran Fibre Plus Kelloggs', 1);
insert into product values (null, 'Τυρί Τρικαλινό Ελαφρύ σε Φέτες ΦΑΓΕ', 1);
insert into product values (null, 'AJAX για τζάμια', 2);
insert into product values (null, 'AJAX Chloron', 2);
insert into product values (null, 'Σακούλες Απορριμμάτων Ultra Strong Μεγάλες Sanitas (52x75cm)', 2);


insert into shopitem values (null, null, '1', 1);
insert into shopitem values (null, null, '3', 2);
insert into shopitem values (null, null, '1', 5);
insert into shopitem values (null, null, '2', 6);

insert into `user` values(null, 'ifer', 'lGrjiDtLeoHfUSjoBo2n3bK4+ohQnk1V', 'ROLE_USER,ROLE_ADMIN', 0);