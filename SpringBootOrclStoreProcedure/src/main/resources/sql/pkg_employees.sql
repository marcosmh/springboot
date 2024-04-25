
CREATE OR REPLACE PACKAGE PKG_EMPLOYEES
IS
    PROCEDURE PRC_COUNT(P_TOTAL OUT NUMBER, P_MENSAJE OUT VARCHAR2);
    PROCEDURE PRC_FIND_ALL(P_LISTA_EMPLEADOS OUT SYS_REFCURSOR,P_MENSAJE OUT VARCHAR2);
    PROCEDURE PRC_FIND_BY_ID(P_ID NUMBER,P_LISTA_EMPLEADOS OUT SYS_REFCURSOR,P_MENSAJE OUT VARCHAR2);
    PROCEDURE PRC_SAVE(P_ID NUMBER,P_FIRST_NAME VARCHAR2,P_LAST_NAME VARCHAR2, P_EMAIL_ADDRESS VARCHAR2,P_MENSAJE OUT VARCHAR2);
    PROCEDURE PRC_UPDATE(P_ID NUMBER,P_FIRST_NAME VARCHAR2,P_LAST_NAME VARCHAR2, P_EMAIL_ADDRESS VARCHAR2,P_MENSAJE OUT VARCHAR2);
    PROCEDURE PRC_DELETE_BY_ID(P_ID NUMBER,P_MENSAJE OUT VARCHAR2);
END;


CREATE OR REPLACE PACKAGE BODY PKG_EMPLOYEES
IS
   PROCEDURE PRC_COUNT(P_TOTAL OUT NUMBER, P_MENSAJE OUT VARCHAR2) IS
   V_MSG VARCHAR2(1000);
   BEGIN
        SELECT COUNT(ID) INTO P_TOTAL FROM EMPLOYEES;
        P_MENSAJE := 'OK';
        
        EXCEPTION
        WHEN OTHERS THEN 
            V_MSG:= 'Error al obtener  el total de empleados:' || SUBSTR(SQLERRM,1,200); 
            P_MENSAJE:= V_MSG;
   END;
   
    PROCEDURE PRC_FIND_ALL(P_LISTA_EMPLEADOS OUT SYS_REFCURSOR,P_MENSAJE OUT VARCHAR2) IS
    V_MSG VARCHAR2(1000);
    BEGIN 
     OPEN P_LISTA_EMPLEADOS FOR
     SELECT ID,FIRST_NAME,LAST_NAME,EMAIL_ADDRESS FROM EMPLOYEES;
     P_MENSAJE := 'OK';
     
     EXCEPTION
        WHEN OTHERS THEN 
            V_MSG := 'Error al consultar employees' || SUBSTR(SQLERRM,1,200);
            P_MENSAJE := V_MSG;
     
    END;
   
   PROCEDURE PRC_FIND_BY_ID(P_ID NUMBER,P_LISTA_EMPLEADOS OUT SYS_REFCURSOR,P_MENSAJE OUT VARCHAR2) IS
   V_MSG VARCHAR2(1000);
   BEGIN 
   
     OPEN P_LISTA_EMPLEADOS FOR
     SELECT ID,FIRST_NAME,LAST_NAME,EMAIL_ADDRESS FROM EMPLOYEES WHERE id = P_ID;
     P_MENSAJE := 'OK';
     
     EXCEPTION
        WHEN OTHERS THEN 
            V_MSG:= 'Error al consultar employees por id: ' || SUBSTR(SQLERRM,1,200);
            P_MENSAJE:= V_MSG;
     
   END;
   
   PROCEDURE PRC_SAVE(P_ID NUMBER,P_FIRST_NAME VARCHAR2,P_LAST_NAME VARCHAR2, P_EMAIL_ADDRESS VARCHAR2,P_MENSAJE OUT VARCHAR2) IS
   V_MSG VARCHAR2(1000);
   BEGIN 
   
     INSERT INTO EMPLOYEES(ID,FIRST_NAME,LAST_NAME,EMAIL_ADDRESS) 
     VALUES(P_ID,P_FIRST_NAME,P_LAST_NAME,P_EMAIL_ADDRESS);
     P_MENSAJE := 'OK';
     
     EXCEPTION
        WHEN OTHERS THEN 
            V_MSG:= 'Error al guardar employees ' || SUBSTR(SQLERRM,1,200);
            P_MENSAJE:= V_MSG;
     
   END;
   
   PROCEDURE PRC_UPDATE(P_ID NUMBER,P_FIRST_NAME VARCHAR2,P_LAST_NAME VARCHAR2, P_EMAIL_ADDRESS VARCHAR2,P_MENSAJE OUT VARCHAR2) IS
   V_MSG VARCHAR2(1000);
   BEGIN 
     
     UPDATE EMPLOYEES SET 
        FIRST_NAME    = P_FIRST_NAME,
        LAST_NAME     = P_LAST_NAME,
        EMAIL_ADDRESS = P_EMAIL_ADDRESS
     WHERE ID = P_ID;
     
     P_MENSAJE := 'OK';
     
     
     EXCEPTION
        WHEN OTHERS THEN 
            V_MSG:= 'Error al actualizar employees ' || SUBSTR(SQLERRM,1,200);
            P_MENSAJE:= V_MSG;
     
   END;
   
  PROCEDURE PRC_DELETE_BY_ID(P_ID NUMBER,P_MENSAJE OUT VARCHAR2) IS
   V_MSG VARCHAR2(1000);
   BEGIN 
     DELETE FROM EMPLOYEES WHERE id = P_ID;
     
     P_MENSAJE := 'OK';
     
     EXCEPTION
        WHEN OTHERS THEN 
            V_MSG:= 'Error al borrar employees por id: ' || SUBSTR(SQLERRM,1,200);
            P_MENSAJE:= V_MSG;
     
   END;
   
END;


