WITH filled_fish_info AS (
    SELECT
        id,
        fish_type,
        IFNULL(length, 10) AS length,
        time
    FROM fish_info
)

SELECT
    fish_count,
    max_length,
    fish_type
FROM (
    SELECT
        COUNT(fish_type) AS fish_count,
        AVG(length) AS avg_length,
        MAX(length) AS max_length,
        fish_type
    FROM filled_fish_info
    GROUP BY fish_type
) subquery
WHERE avg_length >= 33
ORDER BY fish_type ASC
