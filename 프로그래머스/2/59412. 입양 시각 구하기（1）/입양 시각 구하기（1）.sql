-- 코드를 입력하세요
SELECT hour(DATETIME) as hour, count(*) as count
from ANIMAL_OUTS
WHERE HOUR(DATETIME) >= 9 AND HOUR(DATETIME) < 20
group by hour
order by hour asc