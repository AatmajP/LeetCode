# Write your MySQL query statement below
SELECT
    d.name AS Department,
    e1.name AS Employee,
    e1.salary AS Salary
FROM Employee e1
JOIN Department d
    ON e1.departmentId = d.id
where(select count(distinct e2.salary)
from Employee e2
where e2.departmentId=e1.departmentId
and e2.salary>e1.salary)<3