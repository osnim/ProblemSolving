SELECT P.PRODUCT_CODE, T.SUM_SALES_AMOUNT*P.PRICE AS SALES
FROM PRODUCT P JOIN (SELECT PRODUCT_ID, SUM(SALES_AMOUNT) AS SUM_SALES_AMOUNT
FROM OFFLINE_SALE
GROUP BY PRODUCT_ID) T
ON P.PRODUCT_ID = T.PRODUCT_ID
ORDER BY SALES DESC, P.PRODUCT_CODE