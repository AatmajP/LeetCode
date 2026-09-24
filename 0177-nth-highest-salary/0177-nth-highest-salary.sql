CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
set N=N-1;
    RETURN (
        SELECT DISTINCT salary
        FROM Employee
        ORDER BY salary DESC
        LIMIT N, 1 /*N = 1 → LIMIT 0, 1 → 1st highest
                        N = 2 → LIMIT 1, 1 → 2nd highest
                        N = 3 → LIMIT 2, 1 → 3rd highest*/
    );
END