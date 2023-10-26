# Write your MySQL query statement below
Select score,
dense_rank() over 
(Order By score DESC) as 'rank' from Scores ;
