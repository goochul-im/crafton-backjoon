-- 코드를 작성해주세요
select count(*) as fish_count from fish_info i left join fish_name_info n on i.fish_type = n.fish_type  where n.fish_name = 'BASS' or n.fish_name = 'SNAPPER'