-- 코드를 입력하세요
SELECT MCDP_CD as 진료과코드, count(*) as 5월예약건수
from APPOINTMENT
where APNT_YMD >= '2022-05-01' and APNT_YMD < '2022-06-01'
group by MCDP_CD
order by 5월예약건수, MCDP_CD