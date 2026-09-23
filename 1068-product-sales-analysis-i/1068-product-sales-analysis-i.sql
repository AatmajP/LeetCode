# Write your MySQL query statement below
select p.product_name, year,pr.price
from Sales pr
left join Product p
on pr.product_id=p.product_id;