--1 创建TMS库TRANSPORT的影子用户PT_TRANSPORT_BL
create user PT_TRANSPORT_BL identified by oracle;
/
--授权
grant create session,resource to PT_TRANSPORT_BL;
/

--创建索引
CREATE INDEX BL_LOCATION_IDX1 ON BL_LOCATION ("CODE");
/

--创建序列
CREATE SEQUENCE BL_SEQ_LOCATION_BRANCH_TIME_ID MINVALUE 1 MAXVALUE 9999999999999999999999999999 START WITH 21 INCREMENT BY 1 CACHE 20;
/

--创建存储过程
create or replace procedure p_pressure_line AS
  i number := 0;
  maxnum number := 25000;

begin
for i in 0 .. (maxnum - 1) loop

insert into bl_line (ID, MODEL1, MODEL2, MODEL3, CODE, NAME)
values (BL_SEQ_LINE_ID.nextval, 'shipment', '', '', seq_pressure_line_code.nextval, 'PT_'||'广东广州电商部-广东广州公司-广东广州白云集散中心(二班车)');

end loop;
commit;

end p_pressure_line;

/
--创建触发器   tri_pressure_line
CREATE OR REPLACE TRIGGER tri_pressure_line BEFORE INSERT ON bl_line FOR EACH ROW
BEGIN

IF(substr(:NEW.NAME, 0, 3) = 'PT_' and :NEW.business_type='1') THEN
--pt bl_line_stop
insert into bl_line_stop (ID, LINE, LANE, LOCATION, SORT_NUM, LOAD_STOP)
values (BL_SEQ_LINE_STOP_ID.nextval, :NEW.ID, null, 49789, 1.000000, 0);
END IF;
  
IF(substr(:NEW.NAME, 0, 3) = 'PT_' and :NEW.business_type='0') THEN
--pt bl_line_stop
insert into bl_line_stop (ID, LINE, LANE, LOCATION, SORT_NUM, LOAD_STOP)
values (BL_SEQ_LINE_STOP_ID.nextval, :NEW.ID, null, 49789, 1.000000, 0);
END IF;
END;

/
