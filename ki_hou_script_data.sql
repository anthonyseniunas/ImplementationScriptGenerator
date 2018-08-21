/*
Script Category				: Implementation
Script Name    				: ki_hou_script_data_2.3.13.5.sql
Implementation Type(s)		: Housing Job Manager Integrated Solution
Description	   				: Script data
Run Context	   				: SQL*PLUS KIRONA schema
*/


SET TERMOUT ON
SET FEEDBACK ON

PROMPT Setting BIND Variables
VARIABLE ORG_ID NUMBER
BEGIN
:ORG_ID := &1;
END;
/

SET DEFINE OFF

BEGIN
application_utils.set_organisation(:ORG_ID);
application_utils.set_username('ki_hou_sd_23135.sql');
application_utils.set_version('2.3.13.5');
END;
/

REM **********************************************************************
REM            					SCRIPT DATA
REM **********************************************************************


REM **********************************************************************
REM            					MAPPING TYPE SCRIPT_DATA
REM **********************************************************************


PROMPT Updating Job Mapping Customer: DUDLEY Type: SCRIPT_DATA Entity: TENANT_AND_HOUSEHOLD_MEMBERS LocalName:EMAIL

UPDATE kir_hou_job_mappings 
SET HJMA_REMOTE_NAME='EMAIL'
WHERE HJMA_CUSTOMER_NAME='DUDLEY' AND HJMA_MAPPING_TYPE='SCRIPT_DATA' AND HJMA_ENTITY_NAME='TENANT_AND_HOUSEHOLD_MEMBERS' AND HJMA_LOCAL_NAME='EMAIL';


PROMPT Updating Job Mapping Customer: DUDLEY Type: SCRIPT_DATA Entity: TENANT_AND_HOUSEHOLD_MEMBERS LocalName:MOBILE

UPDATE kir_hou_job_mappings 
SET HJMA_REMOTE_NAME='MOBILETEL'
WHERE HJMA_CUSTOMER_NAME='DUDLEY' AND HJMA_MAPPING_TYPE='SCRIPT_DATA' AND HJMA_ENTITY_NAME='TENANT_AND_HOUSEHOLD_MEMBERS' AND HJMA_LOCAL_NAME='MOBILE';


PROMPT Updating Job Mapping Customer: DUDLEY Type: SCRIPT_DATA Entity: TENANT_AND_HOUSEHOLD_MEMBERS LocalName:TELEPHONE

UPDATE kir_hou_job_mappings 
SET HJMA_REMOTE_NAME='HOMETEL'
WHERE HJMA_CUSTOMER_NAME='DUDLEY' AND HJMA_MAPPING_TYPE='SCRIPT_DATA' AND HJMA_ENTITY_NAME='TENANT_AND_HOUSEHOLD_MEMBERS' AND HJMA_LOCAL_NAME='TELEPHONE';

COMMIT;

PROMPT Checking and compiling invalid objects...

BEGIN
FOR i IN (SELECT 'ALTER '||DECODE(object_type,'PACKAGE BODY','PACKAGE', object_type ) ||' '||object_name||' compile ' || DECODE( object_type, 'PACKAGE BODY', 'BODY' ) sql_text
 FROM user_objects
 WHERE status = 'INVALID'
  AND object_type IN ('PACKAGE','VIEW','TRIGGER','PACKAGE BODY' )) LOOP
EXECUTE IMMEDIATE i.sql_text;
END LOOP;
END;
/

COL object_name FORMAT A30
SELECT object_name,object_type
FROM user_objects
WHERE status = 'INVALID'
/

exit 0;
