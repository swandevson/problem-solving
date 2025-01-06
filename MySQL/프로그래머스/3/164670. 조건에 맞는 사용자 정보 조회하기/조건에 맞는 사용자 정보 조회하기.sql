-- 코드를 입력하세요
WITH particular_user AS (
    SELECT writer_id
    FROM used_goods_board
    GROUP BY writer_id
    HAVING COUNT(board_id) >= 3
)

SELECT
    u.user_id,
    u.nickname,
    CONCAT(u.city, ' ', u.street_address1, ' ', u.street_address2) AS 전체주소,
    CONCAT(SUBSTR(tlno, 1, 3), '-',
           SUBSTR(tlno, 4, 4), '-',
           SUBSTR(tlno, 8, 4)) AS 전화번호
FROM particular_user p
JOIN used_goods_user u
ON p.writer_id = u.user_id
ORDER BY u.user_id DESC