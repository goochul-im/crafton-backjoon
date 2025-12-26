-- 코드를 입력하세요
SELECT f.flavor
from FIRST_HALF f
left join ICECREAM_INFO i
on f.flavor = i.flavor
where f.total_order > 3000
and i.INGREDIENT_TYPE = 'fruit_based'
order by f.total_order desc