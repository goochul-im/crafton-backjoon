-- 코드를 작성해주세요
select route, concat(round(sum(D_BETWEEN_DIST) ,1),"km") as total_distance,
concat(round(avg(D_BETWEEN_DIST),2),"km") as AVERAGE_DISTANCE
from SUBWAY_DISTANCE
group by ROUTE
order by sum(D_BETWEEN_DIST) desc