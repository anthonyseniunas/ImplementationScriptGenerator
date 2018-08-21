package com.kirona.generate.api.model;

import lombok.Data;

@Data
public class JobMappings
{
  private long id;
  private String customerName;
  private String mappingType;
  private String entityName;
  private String localName;
  private String remoteName;
  private String description;
  private String dataDomainType;
  private String dataDomain;
  private long dataLimitAmount;
  private String dataLimitType;
  private String datatype;
  private String displayType;
  private long length;
  private long multiRecordLength;
  private String formatMask;
  private boolean current;
  private String parameterName;
  private String elementCode;

  
}
