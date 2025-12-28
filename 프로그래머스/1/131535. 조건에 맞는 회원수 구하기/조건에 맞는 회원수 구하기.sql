-- 코드를 입력하세요
SELECT count(*) users
from user_info
where joined >= '2021-01-01' and joined < '2022-01-01'
and age >= 20 and age <= 29