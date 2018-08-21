package com.kirona.generate.implementation;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.kirona.generate.api.model.JobMappings;
import com.kirona.generate.api.model.RefCode;
import com.kirona.generate.api.model.WirelessParameter;
import com.kirona.generate.implementation.database.GenerateDaoImpl;
import com.kirona.generate.implementation.utils.BeanManager;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan({"com.kirona.generate.implementation.database","com.kirona.generate.implementation.utils"})
public class GenerateImplementationScripts implements CommandLineRunner {
  
private static Connection conn;
private static String dbUrl;
private static String username;
private static String password;
private static String referenceDomains;
private static String scriptDataCustomer;
private static String scriptDataEntityName;
private static String scriptDataMappingTypes;

	public static void generateWirelessParameterReport()
	{
		  try 
		  {
			  PrintWriter writer = new PrintWriter("ki_hou_wireless_parameters.sql", "UTF-8");
			  
			  writer.println("/*");
			  writer.println("Script Category				: Implementation");
			  writer.println("Script Name    				: ki_hou_wireless_parameters_2.3.13.5.sql");
			  writer.println("Implementation Type(s)		: Housing Job Manager Integrated Solution");	
			  writer.println("Description	   				: Wireless parameters");
			  writer.println("Run Context	   				: SQL*PLUS KIRONA schema");
			  writer.println("*/");
			  writer.println("");
			  writer.println("");
			  writer.println("SET TERMOUT ON");
			  writer.println("SET FEEDBACK ON");
			  writer.println("");
			  writer.println("PROMPT Setting BIND Variables");
			  writer.println("VARIABLE ORG_ID NUMBER");
			  writer.println("BEGIN");
			  writer.println(":ORG_ID := &1;");
			  writer.println("END;");
			  writer.println("/");
			  writer.println("");
			  writer.println("SET DEFINE OFF");
			  writer.println("");
			  writer.println("BEGIN");
			  writer.println("application_utils.set_organisation(:ORG_ID);");
			  writer.println("application_utils.set_username('ki_hou_wps_23135.sql');");
			  writer.println("application_utils.set_version('2.3.13.5');");  
			  writer.println("END;");
			  writer.println("/");
			  writer.println("");
			  writer.println("REM **********************************************************************");                                                                                                                              
			  writer.println("REM            			WIRELESS PARAMETERS");                                                                                                                                              
			  writer.println("REM **********************************************************************");                                                                                                                              
			  writer.println("");
			  
			  GenerateDaoImpl generateDao = BeanManager.getGenerator();
			  
			      
			  String[] wirelessParameters = { "SET_CDE_SCRIPT_DEFAULTS",
			                                  "PRETV_INCOME_MGMT_NORTH_DACHS_EMAIL",			  
			                                  "PRETV_INCOME_MGMT_SOUTH_DACHS_EMAIL",
			                                  "PRETV_DIV_AUN_TYPE",
			                                  "PRETV_NORTH_AUN",
			                                  "PRETV_SOUTH_AUN",
			                                  "PRETV_PATCH_AUN_TYPE",
			                                  "PRETV_PATCH_ADMIN_UNIT_EMAIL_CD",  
			                                  "RESOURCE_FILES_LOCATION",
			                                  "OUTPUT_FILE_LOCATION"};
			  
			  List<WirelessParameter> wirelessParameterList = generateDao.getWirelessParameters(wirelessParameters);
			      
			  for (WirelessParameter wirelessParameter : wirelessParameterList)
			  {
				  String paramaterName 	= wirelessParameter.getParameter();
				  String parameterValue = wirelessParameter.getValue();
				  
				  writer.println("");
				  writer.println("PROMPT Updating Parameter "+paramaterName);
				  writer.println("");
				  writer.println("UPDATE wireless_parameters");
				  writer.println("SET wpm_parameter_value='"+parameterValue+"'");
				  writer.println("WHERE wpm_parameter='"+paramaterName+"';");
				  writer.println("");
						  						  
			}
			endOfFile(writer);
			 writer.close();
			
		  } 
		  catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
}
	
	public static void generateReferenceCodesReport()
	{
		  try 
		  {
			  PrintWriter writer = new PrintWriter("ki_hou_reference_codes.sql", "UTF-8");
			  
			  writer.println("/*");
			  writer.println("Script Category				: Implementation");
			  writer.println("Script Name    				: ki_hou_reference_codes_2.3.13.5.sql");
			  writer.println("Implementation Type(s)		: Housing Job Manager Integrated Solution");	
			  writer.println("Description	   				: Reference Data");
			  writer.println("Run Context	   				: SQL*PLUS KIRONA schema");
			  writer.println("*/");
			  writer.println("");
			  writer.println("");
			  writer.println("SET TERMOUT ON");
			  writer.println("SET FEEDBACK ON");
			  writer.println("");
			  writer.println("PROMPT Setting BIND Variables");
			  writer.println("VARIABLE ORG_ID NUMBER");
			  writer.println("BEGIN");
			  writer.println(":ORG_ID := &1;");
			  writer.println("END;");
			  writer.println("/");
			  writer.println("");
			  writer.println("SET DEFINE OFF");
			  writer.println("");
			  writer.println("BEGIN");
			  writer.println("application_utils.set_organisation(:ORG_ID);");
			  writer.println("application_utils.set_username('ki_hou_rc_23135.sql');");
			  writer.println("application_utils.set_version('2.3.13.5');");  
			  writer.println("END;");
			  writer.println("/");
			  writer.println("");
			  writer.println("REM **********************************************************************");                                                                                                                              
			  writer.println("REM            			REFERENCE CODES");                                                                                                                                              
			  writer.println("REM **********************************************************************");                                                                                                                              
			  writer.println("");
			  
			  
			String[] referenceDomainsArray = referenceDomains.split(",");
			
			for (int i = 0; i < referenceDomainsArray.length; i++) 
			{
				
				  writer.println("REM **********************************************************************");                                                                                                                              
				  writer.println("REM            			REFERENCE DOMAIN "+referenceDomainsArray[i]);                                                                                                                                              
				  writer.println("REM **********************************************************************");      
				  
		      GenerateDaoImpl generateDao = BeanManager.getGenerator();
		      
		      List<RefCode> refCodesList = generateDao.getRefCodes(referenceDomainsArray[i]);
		      
		      for (RefCode refCode : refCodesList)
		      {

					  String lowValue 		= refCode.getLowValue();
					  String highValue  	= refCode.getHighValue();
					  String abbreviation = refCode.getAbbreviation();
					  String meaning  		= refCode.getMeaning();				  

					  writer.println("");
					  writer.println("PROMPT Reference Domain "+referenceDomainsArray[i]+ " low value: "+lowValue);
					  writer.println("");
					  writer.println("UPDATE REF_CODES");
					  
					  boolean highValueSet 		=	highValue!=null 	&& !highValue.equals("") ;
					  boolean abbreviationSet =	abbreviation!=null 	&& !abbreviation.equals("") ;
					  boolean meaningSet 		  =	meaning!=null 		&& !meaning.equals("") ;
					  
					  String sql = "SET ";
					  
					  String highValueSQL 	 = highValueSet?" RV_HIGH_VALUE='"+highValue+"'":"";
					  String abbreviationSQL = abbreviationSet?" RV_ABBREVIATION='"+abbreviation+"'":"";
					  String meaningSQL 		 = meaningSet?" RV_MEANING='"+meaning+"'":"";
					  		
					  
					  if (highValueSet)
					  {
						  sql+=highValueSQL;
						  
						  if (abbreviationSet)
						  {
							  sql+=","+abbreviationSQL;
							  
							  if (meaningSet)
							  {
								  sql+=","+meaningSQL;
							  }
						  }
						  else if (meaningSet)
						  {
							  sql+=","+meaningSQL; 
						  }
						  
					  }
					  else if (abbreviationSet)
					  {
						  sql+=abbreviationSQL;
						  
						  if (meaningSet)
						  {
							  sql+=","+meaningSQL;
						  }
					  }
					  else if (meaningSet)
					  {
						  sql+=meaningSQL; 
					  }
						  writer.println(sql);
						  					  
					  writer.println(" WHERE RV_DOMAIN='"+referenceDomainsArray[i]+"' AND RV_LOW_VALUE='"+lowValue+"';");
					  writer.println("");
					 
				}	
				
			}

			  endOfFile(writer);
			 writer.close();
		  } 
		  catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
}
		
	public static void generateScriptDataReport()
	{
		  try 
		  {
			  PrintWriter writer = new PrintWriter("ki_hou_script_data.sql", "UTF-8");
			  
			  writer.println("/*");
			  writer.println("Script Category				: Implementation");
			  writer.println("Script Name    				: ki_hou_script_data_2.3.13.5.sql");
			  writer.println("Implementation Type(s)		: Housing Job Manager Integrated Solution");	
			  writer.println("Description	   				: Script data");
			  writer.println("Run Context	   				: SQL*PLUS KIRONA schema");
			  writer.println("*/");
			  writer.println("");
			  writer.println("");
			  writer.println("SET TERMOUT ON");
			  writer.println("SET FEEDBACK ON");
			  writer.println("");
			  writer.println("PROMPT Setting BIND Variables");
			  writer.println("VARIABLE ORG_ID NUMBER");
			  writer.println("BEGIN");
			  writer.println(":ORG_ID := &1;");
			  writer.println("END;");
			  writer.println("/");
			  writer.println("");
			  writer.println("SET DEFINE OFF");
			  writer.println("");
			  writer.println("BEGIN");
			  writer.println("application_utils.set_organisation(:ORG_ID);");
			  writer.println("application_utils.set_username('ki_hou_sd_23135.sql');");
			  writer.println("application_utils.set_version('2.3.13.5');");  
			  writer.println("END;");
			  writer.println("/");
			  writer.println("");
			  writer.println("REM **********************************************************************");                                                                                                                              
			  writer.println("REM            					SCRIPT DATA");                                                                                                                                              
			  writer.println("REM **********************************************************************");                                                                                                                              
			  writer.println("");
			  
			  
			String[] mappingTypeArray = scriptDataMappingTypes.split(",");
			
			for (int i = 0; i < mappingTypeArray.length; i++) {
				
				  writer.println("");
				  writer.println("REM **********************************************************************");                                                                                                                              
				  writer.println("REM            					MAPPING TYPE "+mappingTypeArray[i]);                                                                                                                                              
				  writer.println("REM **********************************************************************");                                                                                                                              
				  writer.println("");
				  
          
          GenerateDaoImpl generateDao = BeanManager.getGenerator();
          
				  List<JobMappings> jobMappingsList = generateDao.getJobMappings(scriptDataCustomer, mappingTypeArray[i], scriptDataEntityName);
				  
				  for (JobMappings jobMappings : jobMappingsList)
				  {

					  String localName 	= jobMappings.getLocalName();
					  String remoteName = jobMappings.getRemoteName();
					  
					  writer.println("");
					  writer.println("PROMPT Updating Job Mapping Customer: "+scriptDataCustomer+" Type: "+mappingTypeArray[i]+" Entity: "+scriptDataEntityName+" LocalName:"+localName);
					  writer.println("");
					  writer.println("UPDATE kir_hou_job_mappings ");
					  writer.println("SET HJMA_REMOTE_NAME='"+remoteName+"'");
					  writer.println("WHERE HJMA_CUSTOMER_NAME='" +scriptDataCustomer+"'"+
							  		 " AND HJMA_MAPPING_TYPE='"+mappingTypeArray[i]+"'"+
							  		 " AND HJMA_ENTITY_NAME='"+scriptDataEntityName+"'"+
							  		 " AND HJMA_LOCAL_NAME='"+localName+"';");
					  writer.println("");
							  						  
				}
				endOfFile(writer);
				 writer.close();
			
			}
			

			
		  } 
		  catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
}
	
	public static void endOfFile(PrintWriter writer)
	{
		writer.println("COMMIT;");
		writer.println("");

		writer.println("PROMPT Checking and compiling invalid objects...");
		writer.println("");
		
		writer.println("BEGIN");
		
		writer.println("FOR i IN (SELECT 'ALTER '||DECODE(object_type,'PACKAGE BODY','PACKAGE', object_type ) ||' '||object_name||' compile ' || DECODE( object_type, 'PACKAGE BODY', 'BODY' ) sql_text");
		writer.println(" FROM user_objects");
		writer.println(" WHERE status = 'INVALID'");
		writer.println("  AND object_type IN ('PACKAGE','VIEW','TRIGGER','PACKAGE BODY' )) LOOP");
		writer.println("EXECUTE IMMEDIATE i.sql_text;");

		writer.println("END LOOP;");
		writer.println("END;");
		writer.println("/");
		writer.println("");
		
		writer.println("COL object_name FORMAT A30");
		writer.println("SELECT object_name,object_type");
		writer.println("FROM user_objects"); 
		writer.println("WHERE status = 'INVALID'");
		writer.println("/");
		writer.println("");
		writer.println("exit 0;");
		
	}
	  public static boolean initConnection(String dbURL, String username, String password)
	  {
	    try
	    {
	      if (conn!=null && !conn.isClosed()) conn.close();
	    }
	    catch(Exception e)
	    {
	      System.err.println("ERROR occurred closing connection, this may be expected: " + e.getMessage());
	    }
	    try
	    {
//	      DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
	      conn = DriverManager.getConnection(dbURL,username, password);

	    }
	    catch(SQLException e)
	    {
	      System.err.println("ERROR occurred obtaining oracle connection: " + e.getMessage());
	      return false;
	    }
	    return true;
	  }
	  
	  public static void loadProperties()
	  {
			Properties prop = new Properties();
			InputStream input = null;

			try {

				input = new FileInputStream("application.properties");

				// load a properties file
				prop.load(input);
				dbUrl 					=	prop.getProperty("jdbc.url");
				username				=	prop.getProperty("jdbc.username");
				password				=	prop.getProperty("jdbc.password");
				referenceDomains		=	prop.getProperty("reference.domains");
				scriptDataCustomer		=	prop.getProperty("script.data.customer");
				scriptDataEntityName	=	prop.getProperty("script.data.entity");
				scriptDataMappingTypes	=	prop.getProperty("script.data.mapping.types");
				
				
			} catch (IOException ex) {
				ex.printStackTrace();
			} finally {
				if (input != null) {
					try {
						input.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
	  }
	  
	  public static void main(String[] args)
	  {
      SpringApplication.run(GenerateImplementationScripts.class, args);		  
	  }

    public void run(String... args) throws Exception {
      System.out.println("Hello");
      loadProperties();
      
      initConnection(dbUrl,username,password);
      
      generateWirelessParameterReport();
      generateReferenceCodesReport();
      generateScriptDataReport();

    }   	  

}
