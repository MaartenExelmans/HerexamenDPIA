package domotica.model;

@SuppressWarnings("serial")
public class Bathroom extends Room {

	private int showerTemperature;
	private float showerFlowLevel;
	private int tapTemperature;
	private float tapFlowLevel;

	Bathroom(String id) {
		super(id);
	}

	public int getShowerTemperature() 	{ return showerTemperature;	}
	public float getShowerFlowLevel() 	{ return showerFlowLevel; }
	public int getTapTemperature() 		{ return tapTemperature; }
	public float getTapFlowLevel() 		{ return tapFlowLevel;}

	public void setShowerTemperature(int showerTemperature) throws GasException {
		Checks.checkInt(showerTemperature, 10, 60);
		Checks.checkGas();
		this.showerTemperature = showerTemperature;
	}

	public void setShowerFlowLevel(float showerFlowLevel) throws WaterException {
		Checks.checkFloat(showerFlowLevel, 0, 1);
		Checks.checkWater();
		this.showerFlowLevel = showerFlowLevel;
	}

	public void setTapTemperature(int tapTemperature) throws GasException {
		Checks.checkInt(tapTemperature, 10, 60);
		Checks.checkGas();
		this.tapTemperature = tapTemperature;
	}

	public void setTapFlowLevel(float tapFlowLevel) throws WaterException {
		Checks.checkFloat(showerFlowLevel, 0, 1);
		Checks.checkWater();
		this.tapFlowLevel = tapFlowLevel;
	}

	@Override public void reset() throws DomoticaException {
		super.reset();
		setShowerTemperature(20);
		setShowerFlowLevel(0);
		setTapTemperature(20);
		setTapFlowLevel(0);
	}

}
