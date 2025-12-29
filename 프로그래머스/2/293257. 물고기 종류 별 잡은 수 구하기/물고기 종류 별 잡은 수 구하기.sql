-- 코드를 작성해주세요
select count(*) as fish_count, n.fish_name
from fish_info f
join fish_name_info n
on f.fish_type = n.fish_type
group by f.fish_type, n.fish_name
order by count(*) desc