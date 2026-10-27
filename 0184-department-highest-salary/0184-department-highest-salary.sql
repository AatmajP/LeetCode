SELECT
dep.name AS Department,
e.name AS Employee,
e.salary AS Salary
FROM Employee e
JOIN Department dep
ON e.departmentId = dep.id
WHERE e.salary = (
SELECT MAX(d.salary)
FROM Employee d
WHERE d.departmentId = e.departmentId
);
