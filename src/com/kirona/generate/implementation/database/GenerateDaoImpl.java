package com.kirona.generate.implementation.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.kirona.generate.api.model.JobMappings;
import com.kirona.generate.api.model.RefCode;
import com.kirona.generate.api.model.WirelessParameter;
@Component
public class GenerateDaoImpl
{
  @Autowired
  private JdbcTemplate  jdbcTemplate;
  
  public List<RefCode> getRefCodes(String domain)
  {
    List<RefCode> refCodesList = jdbcTemplate.query(
        "SELECT "+
        "  RV_LOW_VALUE, " + 
        "  RV_HIGH_VALUE," + 
        "  RV_ABBREVIATION," + 
        "  RV_MEANING," + 
        "  RV_ATTRIBUTE_NAME," + 
        "  RV_CURRENT_IND," + 
        "  RV_DATA_S_01," + 
        "  RV_DATA_S_02," + 
        "  RV_DATA_S_03," + 
        "  RV_DATA_S_04," + 
        "  RV_DATA_M_01," + 
        "  RV_DATA_M_02," + 
        "  RV_DATA_L_01," + 
        "  RV_DATA_L_02," + 
        "  RV_DATA_X_01," + 
        "  RV_DATA_X_02," + 
        "  SYNC_TO_MOBILE_FLAG " + 
        " FROM KIR_REF_CODES WHERE RV_DOMAIN=? ",
        new Object[] {domain},
        new RowMapper<RefCode>()
        {
          public RefCode mapRow(ResultSet rs, int rownum) throws SQLException
          {
            RefCode refCode = new RefCode();
            refCode.setLowValue(rs.getString("RV_LOW_VALUE"));
            refCode.setHighValue(rs.getString("RV_HIGH_VALUE"));
            refCode.setAbbreviation(rs.getString("RV_ABBREVIATION"));
            refCode.setMeaning(rs.getString("RV_MEANING"));
            refCode.setAttributeName(rs.getString("RV_ATTRIBUTE_NAME"));
            refCode.setCurrentIndicator(rs.getString("RV_CURRENT_IND").equals("Y")?true:false);
            refCode.setDataS01(rs.getString("RV_DATA_S_01"));
            refCode.setDataS02(rs.getString("RV_DATA_S_02"));
            refCode.setDataS03(rs.getString("RV_DATA_S_03"));
            refCode.setDataS04(rs.getString("RV_DATA_S_04"));
            
            refCode.setDataM01(rs.getString("RV_DATA_M_01"));
            refCode.setDataM02(rs.getString("RV_DATA_M_02"));
            
            refCode.setDataL01(rs.getString("RV_DATA_L_01"));
            refCode.setDataL02(rs.getString("RV_DATA_L_02"));
            
            refCode.setDataX01(rs.getString("RV_DATA_X_01"));
            refCode.setDataX02(rs.getString("RV_DATA_X_02"));
            
            refCode.setSyncToMobile(rs.getString("SYNC_TO_MOBILE_FLAG").equals("Y")?true:false);
            return refCode;
          }
        }
      );
      return refCodesList;
  }
  
  public List<WirelessParameter> getWirelessParameters(String[] wirelessParameters)
  {
    List<WirelessParameter> returnWirelessParameters = new ArrayList();
    
    for (int i = 0; i < wirelessParameters.length; i++)
    {
      WirelessParameter wirelessParameter = getWirelessParameter(wirelessParameters[i]);
      if (wirelessParameter !=null)
      {
        returnWirelessParameters.add(wirelessParameter);
      }
    }
    
    return returnWirelessParameters;
    
  }
  
  public WirelessParameter getWirelessParameter(String parameterName)
  {
    List<WirelessParameter> wirelessParametersList = jdbcTemplate.query(
        "SELECT KWP_PARAMETER, " + 
        "  KWP_PARAMETER_VALUE," + 
        "  KWP_PARAMETER_ENCRYPTED," + 
        "  KWP_COMMENTS," + 
        "  KWP_SYSTEM_IND FROM KIR_WIRELESS_PARAMETERS WHERE KWP_PARAMETER=?",
        new Object[] {parameterName},
        new RowMapper<WirelessParameter>()
        {
          public WirelessParameter mapRow(ResultSet rs, int rownum) throws SQLException
          {
            WirelessParameter wirelessParameter = new WirelessParameter();
            
            wirelessParameter.setParameter(rs.getString("KWP_PARAMETER"));
            wirelessParameter.setValue(rs.getString("KWP_PARAMETER_VALUE"));
            wirelessParameter.setEncrypted(rs.getString("KWP_PARAMETER_ENCRYPTED").equals("Y")?true:false);
            wirelessParameter.setComments(rs.getString("KWP_COMMENTS"));
            wirelessParameter.setSystemInd(rs.getString("KWP_SYSTEM_IND").equals("Y")?true:false);
            

            return wirelessParameter;
          }
        }
      );
    if(wirelessParametersList != null && wirelessParametersList.size() > 0)
    {
      return wirelessParametersList.get(0);
    }
    
    return null;
      
  }
   
  public List<JobMappings> getJobMappings(String customerName, String mappingType, String entityName)
  {
    List<JobMappings> jobMappingsList = jdbcTemplate.query(
        "SELECT HJMA_ID," + 
        "    HJMA_CUSTOMER_NAME," + 
        "    HJMA_MAPPING_TYPE," + 
        "    HJMA_ENTITY_NAME," + 
        "    HJMA_LOCAL_NAME," + 
        "    HJMA_REMOTE_NAME," + 
        "    HJMA_DESCRIPTION," + 
        "    HJMA_DATA_DOMAIN_TYPE," + 
        "    HJMA_DATA_DOMAIN," + 
        "    HJMA_DATA_LIMIT_AMOUNT," + 
        "    HJMA_DATA_LIMIT_TYPE," + 
        "    HJMA_DATATYPE," + 
        "    HJMA_DISPLAY_TYPE, " + 
        "    HJMA_LENGTH, " + 
        "    HJMA_MULTI_RECORD_LENGTH, " + 
        "    HJMA_FORMAT_MASK, " + 
        "    HJMA_CURRENT_IND, " + 
        "    HJMA_PARAMETER_NAME, " + 
        "    HJMA_ELEMENT_CODE " + 
        "FROM " + 
        "    KIR_HOU_JOB_MAPPINGS "+
        " WHERE HJMA_CUSTOMER_NAME=? " + 
        " AND HJMA_MAPPING_TYPE=? AND HJMA_ENTITY_NAME=? " ,
        new Object[] {customerName, mappingType, entityName},
        new RowMapper<JobMappings>()
        {
          public JobMappings mapRow(ResultSet rs, int rownum) throws SQLException
          {
            JobMappings jobMappings = new JobMappings();
            
            jobMappings.setId(rs.getLong("HJMA_ID"));
            jobMappings.setCustomerName(rs.getString("HJMA_CUSTOMER_NAME"));
            jobMappings.setMappingType(rs.getString("HJMA_MAPPING_TYPE"));
            jobMappings.setEntityName(rs.getString("HJMA_ENTITY_NAME"));
            jobMappings.setLocalName(rs.getString("HJMA_LOCAL_NAME"));
            jobMappings.setRemoteName(rs.getString("HJMA_REMOTE_NAME"));
            jobMappings.setDescription(rs.getString("HJMA_DESCRIPTION"));
            jobMappings.setDataDomainType(rs.getString("HJMA_DATA_DOMAIN_TYPE"));
            jobMappings.setDataDomain(rs.getString("HJMA_DATA_DOMAIN"));
            jobMappings.setDataLimitAmount(rs.getLong("HJMA_DATA_LIMIT_AMOUNT"));
            jobMappings.setDataLimitType(rs.getString("HJMA_DATA_LIMIT_TYPE"));
            jobMappings.setDatatype(rs.getString("HJMA_DATATYPE"));
            jobMappings.setDisplayType(rs.getString("HJMA_DISPLAY_TYPE"));
            jobMappings.setLength(rs.getLong("HJMA_LENGTH"));
            jobMappings.setMultiRecordLength(rs.getLong("HJMA_MULTI_RECORD_LENGTH"));
            jobMappings.setCurrent(rs.getString("HJMA_CURRENT_IND").equals("Y")?true:false);
            jobMappings.setParameterName(rs.getString("HJMA_PARAMETER_NAME"));
            jobMappings.setElementCode(rs.getString("HJMA_ELEMENT_CODE"));

            return jobMappings;
          }
        }
      );

    return jobMappingsList;
          
  }
}
