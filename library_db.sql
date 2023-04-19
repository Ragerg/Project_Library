/*
        T_BOOK 테이블
        등록번호       숫자형    기본키(unique + not null)
        제목           문자형    필수항목
        저자           문자형    필수항목
        출판사         문자형
        발행연도       날짜형
        보유권수       숫자형    필수항목 
        
        T_BOOK_STATUS 테이블
        등록번호       숫자형    기본키(unique + not null)
        제목           문자형    필수항목
        보유권수       숫자형    필수항목  
        대출상태       문자형    필수항목 
        대출회원       문자형  
        대출일         날짜형
        반납예정일     날짜형 
        
        T_MEMBER
        아이디         문자형    기본키
        패스워드       문자형    필수항목
        이름           문자형    필수항목
        주소           문자형    필수항목
        핸드폰번호     문자형    필수항목    
        
        T_MANAGER
        아이디         문자형    기본키
        패스워드       문자형    필수항목
        이름           문자형    필수항목
*/

CREATE TABLE T_BOOK(
                    REG_NO      NUMBER(5)      PRIMARY KEY
                   ,TITLE       VARCHAR2(200)  NOT NULL
                   ,WRITER      VARCHAR2(100)  NOT NULL
                   ,PUBLISHER   VARCHAR2(100)
                   ,ISSUE_YEAR  NUMBER(4)
                   );
 
CREATE SEQUENCE SEQ_T_BOOK_REG_NO NOCACHE;   
ALTER TABLE T_BOOK MODIFY ISSUE_YEAR NUMBER(4) ;
ALTER TABLE T_BOOK DROP COLUMN STOCK;
                   
CREATE TABLE T_B_STATUS (
                         RENT_NO     NUMBER(5)      PRIMARY KEY     
                        ,REG_NO      NUMBER(5)      UNIQUE,     
                                                    CONSTRAINT   FK_REG_NO
                                                    FOREIGN KEY  (REG_NO)
                                                    REFERENCES   T_BOOK(REG_NO)
                        ,RENT_ID     VARCHAR2(20),  CONSTRAINT   FK_ID
                                                    FOREIGN KEY  (RENT_ID)
                                                    REFERENCES   T_MEMBER(ID)
                        ,RENT_DATE   DATE DEFAULT SYSDATE
                        ,RETURN_DATE DATE DEFAULT STSDATE +14
                       );

CREATE SEQUENCE SEQ_T_B_STATUS_RENT_NO NOCACHE; 
ALTER TABLE T_B_STATUS modify rent_date varchar2(10) default to_char(sysdate, 'yyyy-mm-dd');
ALTER TABLE T_B_STATUS modify return_date varchar2(10) default to_char(sysdate +14 , 'yyyy-mm-dd');
rollback;
DELETE  FROM T_B_STATUS;      

                            
CREATE TABLE T_MEMBER (
                       ID        VARCHAR(20)   PRIMARY KEY
                      ,PW        VARCHAR(20)   NOT NULL
                      ,NAME      VARCHAR(20)   NOT NULL
                      ,ADDRESS   VARCHAR2(20)  NOT NULL
                      ,PHONE_NUM VARCHAR2(11)  NOT NULL
                      );
                      
DELETE  FROM T_MEMBER;                    
ALTER TABLE T_MEMBER MODIFY PHONE_NUM VARCHAR2(11);
ALTER TABLE T_MEMBER MODIFY NAME      VARCHAR(20);
                    
                      
                            
COMMIT;

select *
  from t_member;
  
select *
  from t_book;
  

select *
  from T_B_STATUS;

  
 SELECT RENT_NO
	,b1.REG_NO
	,TITLE
	,RENT_ID
	,RENT_DATE
	,RETURN_DATE
  FROM T_B_STATUS S1
  JOIN T_BOOK     B1   ON B1.REG_NO = S1.REG_NO; 


select b1.reg_no, b1.title, b1.writer, publisher, issue_year, case when s1.rent_no is null then '대출가능' else '대출중' end status 
  from t_book b1
  left outer join t_b_status s1      on s1.reg_no = b1.reg_no
  order by b1.title;
  
select s1.reg_no, title, rent_date, return_date
  from t_b_status s1
  join t_book b1      on b1.reg_no = s1.reg_no
 where rent_id = 'rgrg' ;
                   
update t_member
   set pw = ?
 where id = ?;
   
                   
SELECT REG_NO
      ,TITLE
      ,WRITER
      ,PUBLISHER
      ,ISSUE_YEAR

  FROM T_BOOK
 WHERE TITLE like '%호%'
 GROUP BY TITLE
         ,WRITER
         ,PUBLISHER
         ,ISSUE_YEAR
         ,REG_NO