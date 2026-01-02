-- 코드를 작성해주세요
select sum(g.score) as score ,e.emp_no, e.emp_name, e.position, e.email
from HR_EMPLOYEES e
left join HR_GRADE g
on e.emp_no = g.emp_no
where g.year = '2022'
group by e.emp_no, e.emp_name, e.position, e.email
order by sum(g.score) desc
limit 1