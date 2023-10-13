# Write your MySQL query statement below
WITH CTE AS(
    SELECT query_name , rating /position AS ratio ,
    CASE WHEN rating < 3 THEN 1
    ELSE 0 
    END AS quality_binary 
    FROM Queries
)

SELECT query_name , ROUND(AVG(ratio),2) AS quality , ROUND((SUM(quality_binary) / COUNT(*))*100,2) AS  poor_query_percentage 
FROM CTE 
GROUP BY query_name;
