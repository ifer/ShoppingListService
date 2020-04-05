select * from category;
select * from product;

select p.descr, c.descr, l.amount from list l, product p, category c 
where p.catid = c.catid and l.prodid = p.prodid;