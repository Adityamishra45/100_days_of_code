# Write your MySQL query statement below
select request_at as day,
round(
    avg(
        case when status ='cancelled_by_driver' or status='cancelled_by_client' then 1 
        else 0 
        end
    )
    ,2
) as 'Cancellation rate'
from 
(
    select * from trips where client_id in 
    (
        select users_id from users where role='client' and banned='No'
    ) 
    AND 
    driver_id in 
    (
        select users_id from users where role='driver' and banned='No'
    )
) as a group by day having day between '2013-10-01' AND '2013-10-03';
