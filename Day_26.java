//  Write your MySQL query statement below
select Employee.name , Bonus.bonus
from Employee left join Bonus
on Employee.empId = Bonus.empId
where bonus is null || bonus<1000;
