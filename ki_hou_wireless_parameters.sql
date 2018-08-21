/*
Script Category				: Implementation
Script Name    				: ki_hou_wireless_parameters_2.3.13.5.sql
Implementation Type(s)		: Housing Job Manager Integrated Solution
Description	   				: Wireless parameters
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
application_utils.set_username('ki_hou_wps_23135.sql');
application_utils.set_version('2.3.13.5');
END;
/

REM **********************************************************************
REM            			WIRELESS PARAMETERS
REM **********************************************************************


PROMPT Updating Parameter SET_CDE_SCRIPT_DEFAULTS

UPDATE wireless_parameters
SET wpm_parameter_value='Y'
WHERE wpm_parameter='SET_CDE_SCRIPT_DEFAULTS';


PROMPT Updating Parameter PRETV_INCOME_MGMT_NORTH_DACHS_EMAIL

UPDATE wireless_parameters
SET wpm_parameter_value='northdachsemail'
WHERE wpm_parameter='PRETV_INCOME_MGMT_NORTH_DACHS_EMAIL';


PROMPT Updating Parameter PRETV_INCOME_MGMT_SOUTH_DACHS_EMAIL

UPDATE wireless_parameters
SET wpm_parameter_value='southdachsemail'
WHERE wpm_parameter='PRETV_INCOME_MGMT_SOUTH_DACHS_EMAIL';


PROMPT Updating Parameter PRETV_DIV_AUN_TYPE

UPDATE wireless_parameters
SET wpm_parameter_value='OFF'
WHERE wpm_parameter='PRETV_DIV_AUN_TYPE';


PROMPT Updating Parameter PRETV_NORTH_AUN

UPDATE wireless_parameters
SET wpm_parameter_value='NOR'
WHERE wpm_parameter='PRETV_NORTH_AUN';


PROMPT Updating Parameter PRETV_SOUTH_AUN

UPDATE wireless_parameters
SET wpm_parameter_value='SOU'
WHERE wpm_parameter='PRETV_SOUTH_AUN';


PROMPT Updating Parameter PRETV_PATCH_ADMIN_UNIT_EMAIL_CD

UPDATE wireless_parameters
SET wpm_parameter_value='EMAIL_HOME'
WHERE wpm_parameter='PRETV_PATCH_ADMIN_UNIT_EMAIL_CD';


PROMPT Updating Parameter RESOURCE_FILES_LOCATION

UPDATE wireless_parameters
SET wpm_parameter_value='http://presales-ushou:81/jmtest/photorenderer?imgID='
WHERE wpm_parameter='RESOURCE_FILES_LOCATION';


PROMPT Updating Parameter OUTPUT_FILE_LOCATION

UPDATE wireless_parameters
SET wpm_parameter_value='/app/kirona/logo/'
WHERE wpm_parameter='OUTPUT_FILE_LOCATION';

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
