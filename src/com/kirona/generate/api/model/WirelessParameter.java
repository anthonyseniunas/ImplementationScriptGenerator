package com.kirona.generate.api.model;

public class WirelessParameter
{
  private String  parameter;
  private String  value;
  private String  comments;
  private boolean encrypted;
  private boolean systemInd;
  
	public String getParameter()
	{
		return parameter;
	}
	
	public void setParameter(String parameter)
	{
		this.parameter = parameter;
	}
	
	public String getValue()
	{
		return value;
	}
	
	public void setValue(String value)
	{
		this.value = value;
	}
	
	public String getComments()
	{
		return comments;
	}
	
	public void setComments(String comments)
	{
		this.comments = comments;
	}
	
	public boolean isEncrypted()
	{
		return encrypted;
	}
	
	public void setEncrypted(boolean encrypted)
	{
		this.encrypted = encrypted;
	}
	
	public boolean isSystemInd()
	{
		return systemInd;
	}
	
	public void setSystemInd(boolean systemInd)
	{
		this.systemInd = systemInd;
	}
}
