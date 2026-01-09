-- 코드를 입력하세요
SELECT animal_type, ifnull(name, "No name") as name, SEX_UPON_INTAKE
from animal_ins
order by animal_id asc