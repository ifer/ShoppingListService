select * from category;
select * from product;

select i.itemid, p.descr, c.descr, i.quantity, i.comment from shopitem i, product p, category c 
where p.catid = c.catid and i.prodid = p.prodid  order by c.descr;

select count(*) from shopitem;

select * from user;