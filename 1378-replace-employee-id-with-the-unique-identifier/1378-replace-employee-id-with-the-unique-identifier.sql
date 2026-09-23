# Write your MySQL query statement below
select e.unique_id,n.name
from  Employees n
left join EmployeeUNI e
on e.id=n.id;