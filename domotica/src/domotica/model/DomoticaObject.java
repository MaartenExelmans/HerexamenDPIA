package domotica.model;

import java.io.Serializable;
import java.util.Observable;

@SuppressWarnings("serial")
public abstract class DomoticaObject extends Observable implements Serializable {

	private int aircoTemperature;
	private float lightLevel;
	private boolean rollerShutterDown;
	private boolean doorClosed;
	private String id;

	public String getId() {	return id; }

	public String toString() {
		return getId();
	}

	DomoticaObject(String id) {
		this.id = id;
	}

	public int getAircoTemperature()		{	return aircoTemperature; }
	public float getLightLevel() 			{	return lightLevel; }
	public boolean isRollerShutterDown()	{	return rollerShutterDown; }
	public boolean isDoorClosed() 			{	return doorClosed; }

	public void setAircoTemperature(int aircoTemperature) throws ElectricityException {
		Checks.checkInt(aircoTemperature, 15, 25);
		Checks.checkElectricity();
		this.aircoTemperature = aircoTemperature;
	}

	public void setLightLevel(float lightLevel) throws ElectricityException {
		Checks.checkFloat(lightLevel, 0, 1);
		Checks.checkElectricity();
		this.lightLevel = lightLevel;
	}

	public void setRollerShutterDown() throws ElectricityException {
		Checks.checkElectricity();
		this.rollerShutterDown = true;
	}

	public void setRollerShutterUp() throws ElectricityException {
		Checks.checkElectricity();
		this.rollerShutterDown = false;
	}

	public void setDoorsClosed() throws ElectricityException {
		Checks.checkElectricity();
		this.doorClosed = true;
		System.out.println("Closing doors...");
	}

	public void setDoorsOpened() throws ElectricityException {
		Checks.checkElectricity();
		this.doorClosed = false;
		System.out.println("Opening doors...");
	}

	public void reset() throws DomoticaException {
		setAircoTemperature(20);
		setLightLevel(0);
		setRollerShutterDown();
		setDoorsClosed();
	}

	public void openRoom() {
		try {
			setAircoTemperature(20);
			setLightLevel(1);
			setRollerShutterDown();
			setDoorsOpened();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void closeRoom() {
		try {
			setAircoTemperature(10);
			setLightLevel(0);
			setRollerShutterUp();
			setDoorsClosed();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update() {
		setChanged();
		notifyObservers();
	}
}
