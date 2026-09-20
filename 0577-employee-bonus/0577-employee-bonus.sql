# Write your MySQL query statement below
select n.name, b.bonus
from Employee n
left join Bonus b
on n.empid=b.empid
where b.bonus<1000 or b.bonus is null