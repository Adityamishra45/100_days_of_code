# Write your MySQL query statement below
SELECT a.machine_id, ROUND(SUM((c.timestamp - a.timestamp)) / COUNT(a.machine_id),3) as processing_time  

FROM Activity as a 

JOIN Activity as c ON a.machine_id = c.machine_id 
and a.process_id = c.process_id 
and a.activity_type = "start" 
and c.activity_type = "end"

GROUP BY a.machine_id
