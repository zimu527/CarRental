-----------------------------------------------------
-- Export file for user DONG_LL                    --
-- Created by Administrator on 2015/6/19, 10:55:54 --
-----------------------------------------------------

set define off
spool kk.log

prompt
prompt Creating table ALARM_CONFIG
prompt ===========================
prompt
create table DONG_LL.ALARM_CONFIG
(
  id          NUMBER not null,
  all_alarm   BLOB,
  insert_time DATE default sysdate,
  description VARCHAR2(64)
)
tablespace DONGLL
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
comment on column DONG_LL.ALARM_CONFIG.id
  is 'ID标识';
comment on column DONG_LL.ALARM_CONFIG.all_alarm
  is '告警策略';
comment on column DONG_LL.ALARM_CONFIG.insert_time
  is '插入时间';
comment on column DONG_LL.ALARM_CONFIG.description
  is '描述';
alter table DONG_LL.ALARM_CONFIG
  add primary key (ID)
  using index 
  tablespace DONGLL
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table APPLICATION
prompt ==========================
prompt
create table DONG_LL.APPLICATION
(
  id            NUMBER not null,
  name          VARCHAR2(64),
  public_ip     VARCHAR2(32),
  local_ip      VARCHAR2(32),
  insert_time   DATE default Sysdate,
  public_ip_raw VARCHAR2(256),
  local_ip_raw  VARCHAR2(256)
)
tablespace DONGLL
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
comment on column DONG_LL.APPLICATION.id
  is 'ID标识';
comment on column DONG_LL.APPLICATION.name
  is '应用名称';
comment on column DONG_LL.APPLICATION.public_ip
  is '外网IP';
comment on column DONG_LL.APPLICATION.local_ip
  is '内网IP';
comment on column DONG_LL.APPLICATION.insert_time
  is '添加时间';
alter table DONG_LL.APPLICATION
  add primary key (ID)
  using index 
  tablespace DONGLL
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating sequence ALARM_CONFIG_SEQ
prompt ==================================
prompt
create sequence DONG_LL.ALARM_CONFIG_SEQ
minvalue 1
maxvalue 99999999
start with 281
increment by 1
cache 20;

prompt
prompt Creating sequence APPLICATION_SEQ
prompt =================================
prompt
create sequence DONG_LL.APPLICATION_SEQ
minvalue 1
maxvalue 99999999
start with 141
increment by 1
cache 20;

prompt
prompt Creating trigger ALARM_CONFIG_TRIG
prompt ==================================
prompt
create or replace trigger dong_ll.ALARM_CONFIG_TRIG
  	before insert on ALARM_CONFIG
  	for each row
begin
    select ALARM_CONFIG_SEQ.nextval into :new.ID from dual;
end;
/

prompt
prompt Creating trigger APPLICATIONN_TRIG
prompt ==================================
prompt
create or replace trigger dong_ll.APPLICATIONN_TRIG
  	before insert on APPLICATION
  	for each row
begin
    select APPLICATION_SEQ.nextval into :new.ID from dual;
end;
/


spool off
