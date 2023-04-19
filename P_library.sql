/*
        T_BOOK ���̺�
        ������ȣ       ������    �⺻Ű(unique + not null)
        ����           ������    �ʼ��׸�
        ����           ������    �ʼ��׸�
        ���ǻ�         ������
        ���࿬��       ��¥��
        
        T_BOOK_STATUS ���̺�
        �뿩��ȣ       ������    �⺻Ű(unique + not null)
        ������ȣ       ������
        ����           ������    �ʼ��׸� 
        ����ȸ��       ������  
        ������         ��¥��
        �ݳ�������     ��¥�� 
        
        T_MEMBER
        ���̵�         ������    �⺻Ű
        �н�����       ������    �ʼ��׸�
        �̸�           ������    �ʼ��׸�
        �ּ�           ������    �ʼ��׸�
        �ڵ�����ȣ     ������    �ʼ��׸�    

*/

--���� ���̺� ����
CREATE TABLE T_BOOK(
                    REG_NO      NUMBER(5)      PRIMARY KEY
                   ,TITLE       VARCHAR2(200)  NOT NULL
                   ,WRITER      VARCHAR2(100)  NOT NULL
                   ,PUBLISHER   VARCHAR2(100)
                   ,ISSUE_YEAR  NUMBER(4)
                   );
                   
                   
--�뿩 ���̺� ����                  
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
                       
                       
                       
--ȸ�� ���̺� ����                     
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
  

--������ȣ�� �뿩ȸ�� �� �뿩���� ��ȸ                     
SELECT RENT_NO
      ,B1.REG_NO
      ,TITLE
      ,RENT_ID
      ,RENT_DATE
      ,RETURN_DATE
  FROM T_B_STATUS S1
  JOIN T_BOOK     B1   ON B1.REG_NO = S1.REG_NO;        
  

--�������� ��ȸ / �뿩�׿��� �ԷµǾ� �뿩��ȣ�� ���� ������ ������
SELECT B1.REG_NO
      ,B1.TITLE
      ,B1.WRITER
      ,PUBLISHER
      ,ISSUE_YEAR
      ,CASE WHEN S1.RENT_NO IS NULL THEN '���Ⱑ��' ELSE '������' END AS STATUS 
  FROM T_BOOK                B1
  LEFT OUTER JOIN T_B_STATUS S1      ON S1.REG_NO = B1.REG_NO
  ORDER BY B1.TITLE;  
 
--ID�� �뿩���� ���� ��ȸ
SELECT S1.REG_NO
      ,TITLE
      ,RENT_DATE
      ,RETURN_DATE
  FROM T_B_STATUS S1
  JOIN T_BOOK     B1      ON B1.REG_NO = S1.REG_NO
 WHERE RENT_ID = 'aaa'
 ORDER BY RENT_DATE, REG_NO; 
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
                      
                      
                      
                      
                      
                      