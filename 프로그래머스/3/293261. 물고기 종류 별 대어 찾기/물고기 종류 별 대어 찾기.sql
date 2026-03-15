select id, fish_name, fi.length from fish_info fi
join fish_name_info fni on fi.fish_type = fni.fish_type
join (select fish_type, max(length) as length from fish_info group by fish_type) fg
on fg.length = fi.length and fi.fish_type = fg.fish_type
order by id;