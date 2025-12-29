-- 코드를 작성해주세요
select count(*) as fish_count, MONTH(time) as MONTH
from fish_info
group by month(time)
order by month asc