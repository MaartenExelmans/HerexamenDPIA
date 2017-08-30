package domotica.model;

@SuppressWarnings("serial")
public class Bedroom extends Room {

	private boolean alarmSwitchedOn;
	private int waterbedTemperature;

	Bedroom(String id) {
		super(id);
	}

	public boolean isAlarmSwitchedOn() 	{	return alarmSwitchedOn;	}
	public int getWaterbedTemperature() {	return waterbedTemperature;	}
	
	public void setAlarmSwitchedOn(boolean alarmSwitchedOn) throws ElectricityException {
		Checks.checkElectricity();
		this.alarmSwitchedOn = alarmSwitchedOn;
	}

	public void setWaterbedTemperature(int waterbedTemperature) throws ElectricityException {
		Checks.checkInt(waterbedTemperature, 10, 30);
		Checks.checkElectricity();
		this.waterbedTemperature = waterbedTemperature;
	}

	@Override
	public void reset() throws DomoticaException {
		super.reset();
		setAlarmSwitchedOn(false);
		setWaterbedTemperature(20);
	}
}
