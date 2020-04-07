select * from category;
select * from product;

select l.listid, p.descr, c.descr, l.amount, l.comment from shoplist l, product p, category c 
where p.catid = c.catid and l.prodid = p.prodid;

select * from user;