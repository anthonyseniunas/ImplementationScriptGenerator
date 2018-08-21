package com.kirona.generate.api.model;

/**
 * 
 * @author cwightman
 *
 * Ref Code Class for data transfer to JM
 * Returns Strings of the correct size.  Larger strings are automatically truncated.
 * 
 */
public class RefCode
{
	private String  domain;
	private String  lowValue;
	private String  highValue;
	private String  abbreviation;
	private String  meaning;
	private String  attributeName;
	private boolean currentIndicator;
	private String  dataS01; // 30
	private String  dataS02;
	private String  dataS03;
	private String  dataS04;
	private String  dataM01; // 60
	private String  dataM02;
	private String  dataL01; // 120
	private String  dataL02;
	private String  dataX01; // 240
	private String  dataX02;
	private boolean syncToMobile;
	
	public String getDomain()
	{
		return (domain != null && domain.length() > 30 ? domain.substring(0, 30) : domain);
	}
	
	public void setDomain(String domain)
	{
		this.domain = domain;
	}
	
	public String getLowValue()
	{
		return (lowValue != null && lowValue.length() > 240 ? lowValue.substring(0, 240) : lowValue);
	}
	
	public void setLowValue(String lowValue)
	{
		this.lowValue = lowValue;
	}
	
	public String getHighValue()
	{
		return (highValue != null && highValue.length() > 240 ? highValue.substring(0, 240) : highValue);
	}
	
	public void setHighValue(String highValue)
	{
		this.highValue = highValue;
	}
	
	public String getAbbreviation()
	{
		return (abbreviation != null && abbreviation.length() > 240 ? abbreviation.substring(0, 240) : abbreviation);
	}
	
	public void setAbbreviation(String abbreviation)
	{
		this.abbreviation = abbreviation;
	}
	
	public String getMeaning()
	{
		return (meaning != null && meaning.length() > 4000 ? meaning.substring(0, 4000) : meaning);
	}
	
	public void setMeaning(String meaning)
	{
		this.meaning = meaning;
	}
	
	public String getAttributeName()
	{
		return (attributeName != null && attributeName.length() > 100 ? attributeName.substring(0, 100) : attributeName);
	}
	
	public void setAttributeName(String attributeName)
	{
		this.attributeName = attributeName;
	}
	
	public boolean isCurrentIndicator()
	{
		return currentIndicator;
	}
	
	public void setCurrentIndicator(boolean currentIndicator)
	{
		this.currentIndicator = currentIndicator;
	}
	
	public String getDataS01()
	{
		return (dataS01 != null && dataS01.length() > 30 ? dataS01.substring(0, 30) : dataS01);
	}
	
	public void setDataS01(String dataS01)
	{
		this.dataS01 = dataS01;
	}
	
	public String getDataS02()
	{
		return (dataS02 != null && dataS02.length() > 30 ? dataS02.substring(0, 30) : dataS02);
	}
	
	public void setDataS02(String dataS02)
	{
		this.dataS02 = dataS02;
	}
	
	public String getDataS03()
	{
		return (dataS03 != null && dataS03.length() > 30 ? dataS03.substring(0, 30) : dataS03);
	}
	
	public void setDataS03(String dataS03)
	{
		this.dataS03 = dataS03;
	}
	
	public String getDataS04()
	{
		return (dataS04 != null && dataS04.length() > 30 ? dataS04.substring(0, 30) : dataS04);
	}
	
	public void setDataS04(String dataS04)
	{
		this.dataS04 = dataS04;
	}
	
	public String getDataM01()
	{
		return (dataM01 != null && dataM01.length() > 60 ? dataM01.substring(0, 60) : dataM01);
	}
	
	public void setDataM01(String dataM01)
	{
		this.dataM01 = dataM01;
	}
	
	public String getDataM02()
	{
		return (dataM02 != null && dataM02.length() > 60 ? dataM02.substring(0, 60) : dataM02);
	}
	
	public void setDataM02(String dataM02)
	{
		this.dataM02 = dataM02;
	}
	
	public String getDataL01()
	{
		return (dataL01 != null && dataL01.length() > 120 ? dataL01.substring(0, 120) : dataL01);
	}
	
	public void setDataL01(String dataL01)
	{
		this.dataL01 = dataL01;
	}
	
	public String getDataL02()
	{
		return (dataL02 != null && dataL02.length() > 120 ? dataL02.substring(0, 120) : dataL02);
	}
	
	public void setDataL02(String dataL02)
	{
		this.dataL02 = dataL02;
	}
	
	public String getDataX01()
	{
		return (dataX01 != null && dataX01.length() > 240 ? dataX01.substring(0, 240) : dataX01);
	}
	
	public void setDataX01(String dataX01)
	{
		this.dataX01 = dataX01;
	}
	
	public String getDataX02()
	{
		return (dataX02 != null && dataX02.length() > 240 ? dataX02.substring(0, 240) : dataX02);
	}
	
	public void setDataX02(String dataX02)
	{
		this.dataX02 = dataX02;
	}
	
	public boolean isSyncToMobile()
	{
		return syncToMobile;
	}
	
	public void setSyncToMobile(boolean syncToMobile)
	{
		this.syncToMobile = syncToMobile;
	}
}
