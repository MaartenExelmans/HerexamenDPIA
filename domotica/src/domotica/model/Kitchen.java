package domotica.model;

@SuppressWarnings("serial")
public class Kitchen extends Room {

	private boolean cooktopSwitchedOn;
	private boolean extractorHoodSwitchedOn;
	private int refrigeratorTemperature;
	private int freezerTemprature;

	Kitchen(String id) {
		super(id);
	}

	public boolean isCooktopSwitchedOn()		{	return cooktopSwitchedOn; }
	public boolean isExtractorHoodSwitchedOn()	{	return extractorHoodSwitchedOn;	}
	public int getRefrigeratorTemperature() 	{	return refrigeratorTemperature;	}
	public int getFreezerTemprature() 			{	return freezerTemprature; }
	
	public void setCooktopSwitchedOn(boolean cooktopSwitchedOn) {
		this.cooktopSwitchedOn = cooktopSwitchedOn;
	}

	public void setExtractorHoodSwitchedOn(boolean extractorHoodSwitchedOn) {
		this.extractorHoodSwitchedOn = extractorHoodSwitchedOn;
	}

	public void setRefrigeratorTemperature(int refrigeratorTemperature) throws ElectricityException {
		Checks.checkInt(refrigeratorTemperature, 1, 15);
		Checks.checkElectricity();
		this.refrigeratorTemperature = refrigeratorTemperature;
	}

	public void setFreezerTemperature(int freezerTemprature) throws ElectricityException {
		Checks.checkInt(freezerTemprature, -15, -1);
		Checks.checkElectricity();
		this.freezerTemprature = freezerTemprature;	
	}

	@Override
	public void reset() throws DomoticaException {
		super.reset();
		setCooktopSwitchedOn(false);
		setExtractorHoodSwitchedOn(false);
		setRefrigeratorTemperature(10);
		setFreezerTemperature(-5);
	}
}
