package shortcutHelper.backend.functionality.formatStringFunctionality;

import shortcutHelper.backend.functionality.FunctionalityDataContainer;

public class FormatStringFunctionalityDataContainer extends FunctionalityDataContainer{
	private String originalFormat;
	private String transformationToTargetFormat;
	private String oTargetFormat;
	private String oTransformationToOriginalFormat;
	private boolean dReverseFormat;
	
	public String getOriginalFormat()
	{
		return originalFormat;
	}
	
	public void setOriginalFormat(String originalFormat){
		this.originalFormat = originalFormat;
	}
	public String getTransformationToTargetFormat()
	{
		return transformationToTargetFormat;
	}
	
	public void setTransformationToTargetFormat(String transformationToTargetFormat){
		this.transformationToTargetFormat = transformationToTargetFormat;
	}
	public String getOTargetFormat()
	{
		return oTargetFormat;
	}
	
	public void setOTargetFormat(String oTargetFormat){
		this.oTargetFormat = oTargetFormat;
	}
	public String getOTransformationToOriginalFormat()
	{
		return oTransformationToOriginalFormat;
	}
	
	public void setOTransformationToOriginalFormat(String oTransformationToOriginalFormat){
		this.oTransformationToOriginalFormat = oTransformationToOriginalFormat;
	}
	public boolean getDReverseFormat()
	{
		return dReverseFormat;
	}
	
	public void setDReverseFormat(boolean dReverseFormat){
		this.dReverseFormat = dReverseFormat;
	}
}
