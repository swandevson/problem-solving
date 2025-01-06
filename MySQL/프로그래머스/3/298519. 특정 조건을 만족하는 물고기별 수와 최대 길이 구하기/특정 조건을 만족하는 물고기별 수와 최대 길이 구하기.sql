SELECT
    COUNT(fish_type) AS fish_count,
    MAX(length) AS max_length,
    fish_type
FROM (
    SELECT
        id,
        fish_type,
        IFNULL(length, 10) AS length
    FROM fish_info
) f
GROUP BY fish_type
HAVING AVG(length) >= 33
ORDER BY fish_type ASC