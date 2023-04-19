/*
        T_BOOK 테이블
        도서번호       숫자형    기본키(unique + not null)
        제목           문자형    필수항목
        저자           문자형    필수항목
        출판사         문자형
        발행연도       날짜형
        
        T_BOOK_STATUS 테이블
        대여번호       숫자형    기본키(unique + not null)
        도서번호       숫자형
        제목           문자형    필수항목 
        대출회원       문자형  
        대출일         날짜형
        반납예정일     날짜형 
        
        T_MEMBER
        아이디         문자형    기본키
        패스워드       문자형    필수항목
        이름           문자형    필수항목
        주소           문자형    필수항목
        핸드폰번호     문자형    필수항목    

*/

--도서 테이블 생성
CREATE TABLE T_BOOK(
                    REG_NO      NUMBER(5)      PRIMARY KEY
                   ,TITLE       VARCHAR2(200)  NOT NULL
                   ,WRITER      VARCHAR2(100)  NOT NULL
                   ,PUBLISHER   VARCHAR2(100)
                   ,ISSUE_YEAR  NUMBER(4)
                   );
                   
                   
--대여 테이블 생성                  
CREATE TABLE T_B_STATUS (
                         RENT_NO     NUMBER(5)      PRIMARY KEY     
                        ,REG_NO      NUMBER(5)      UNIQUE     
                                                   ,CONSTRAINT   FK_REG_NO
                                                    FOREIGN KEY  (REG_NO)
                                                    REFERENCES   T_BOOK(REG_NO)
                        ,RENT_ID     VARCHAR2(20)  ,CONSTRAINT   FK_ID
                                                    FOREIGN KEY  (RENT_ID)
                                                    REFERENCES   T_MEMBER(ID)
                        ,RENT_DATE   VARCHAR2(10)   DEFAULT TO_CHAR(SYSDATE    , 'YYYY-MM-DD')
                        ,RETURN_DATE VARCHAR2(10)   DEFAULT TO_CHAR(SYSDATE +14, 'YYYY-MM-DD')
                       );   
                       
                       
                       
--회원 테이블 생성                     
CREATE TABLE T_MEMBER (
                       ID        VARCHAR(20)   PRIMARY KEY
                      ,PW        VARCHAR(20)   NOT NULL
                      ,NAME      VARCHAR(20)   NOT NULL
                      ,ADDRESS   VARCHAR2(30)  NOT NULL
                      ,PHONE_NUM VARCHAR2(11)  NOT NULL
                      );
               
                      
COMMIT;


SELECT *
  FROM T_MEMBER;
  
SELECT *
  FROM T_BOOK;  
  
SELECT *
  FROM T_B_STATUS;
  

--도서번호로 대여회원 및 대여도서 조회                     
SELECT RENT_NO
      ,B1.REG_NO
      ,TITLE
      ,RENT_ID
      ,RENT_DATE
      ,RETURN_DATE
  FROM T_B_STATUS S1
  JOIN T_BOOK     B1   ON B1.REG_NO = S1.REG_NO;        
  

--도서정보 조회 / 대여테여블에 입력되어 대여번호가 생긴 도서는 대출중
SELECT B1.REG_NO
      ,B1.TITLE
      ,B1.WRITER
      ,PUBLISHER
      ,ISSUE_YEAR
      ,CASE WHEN S1.RENT_NO IS NULL THEN '대출가능' ELSE '대출중' END AS STATUS 
  FROM T_BOOK                B1
  LEFT OUTER JOIN T_B_STATUS S1      ON S1.REG_NO = B1.REG_NO
  ORDER BY B1.TITLE;  
 
--ID로 대여중인 도서 조회
SELECT S1.REG_NO
      ,TITLE
      ,RENT_DATE
      ,RETURN_DATE
  FROM T_B_STATUS S1
  JOIN T_BOOK     B1      ON B1.REG_NO = S1.REG_NO
 WHERE RENT_ID = 'aaa'
 ORDER BY RENT_DATE, REG_NO; 
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
                      
                      
                      
                      
                      
                      