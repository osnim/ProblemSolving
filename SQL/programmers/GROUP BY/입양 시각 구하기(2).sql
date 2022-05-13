-- 코드를 입력하세요
SET @h := -1; -- 변수 선언

SELECT (@h := @h+1) as HOUR, -- 선언한 변수 h를 0부터 시작
    (SELECT COUNT(*) 
    FROM ANIMAL_OUTS 
    WHERE HOUR(DATETIME) = @h) AS COUNT -- COUNT를 h와 같은 것만 출력, 없으면 0개 출력
    
FROM ANIMAL_OUTS
WHERE @h < 23 -- h를 23시까지