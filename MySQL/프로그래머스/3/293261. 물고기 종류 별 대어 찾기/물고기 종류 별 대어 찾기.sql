-- 코드를 작성해주세요
    
SELECT
    id,
    a.fish_name,
    a.length
FROM (
    SELECT
        n.fish_name,
        n.fish_type,
        MAX(length) AS length
    FROM fish_info i
    JOIN fish_name_info n ON n.fish_type = i.fish_type
    GROUP BY n.fish_type, n.fish_name
) a
JOIN fish_info b
    ON a.fish_type = b.fish_type
    AND a.length = b.length
