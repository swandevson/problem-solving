WITH january_sales AS (
    SELECT * FROM book_sales
    WHERE DATE_FORMAT(sales_date, '%Y-%m') = '2022-01' 
)
SELECT
    a.author_id,
    a.author_name,
    b.category,
    SUM(b.price * s.sales) AS total_sales
FROM january_sales s
JOIN book b ON b.book_id = s.book_id
JOIN author a ON a.author_id = b.author_id
GROUP BY a.author_id, b.category
ORDER BY a.author_id , b.category DESC