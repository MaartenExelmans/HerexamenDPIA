package domotica.facade;

import domotica.model.*;

public class DomoticaFacade {

	House house;

	public DomoticaFacade(House house) {
		this.house = house;
	}

	public void closeHouse() throws DomoticaException {

			Living living = house.getLiving();
			living.closeRoom();
			living.setTvSwitchedOn(false);

			Kitchen kitchen = house.getKitchen();
			kitchen.closeRoom();
			kitchen.setCooktopSwitchedOn(false);
			kitchen.setExtractorHoodSwitchedOn(false);
			kitchen.setRefrigeratorTemperature(15);
			kitchen.setFreezerTemperature(-1);

			Bathroom bathroom = house.getBathroom();
			bathroom.closeRoom();
			bathroom.setShowerTemperature(10);
			bathroom.setShowerFlowLevel(0);
			bathroom.setTapTemperature(10);
			bathroom.setTapFlowLevel(0);

			Bedroom bedroom = house.getBedroom();
			bedroom.closeRoom();
			bedroom.setAlarmSwitchedOn(true);
			bedroom.setWaterbedTemperature(10);
	}

		public void openHouse() throws DomoticaException {

			Living living = house.getLiving();
			living.openRoom();
			living.setTvSwitchedOn(true);
			living.setTvChannel(99);
			living.setTvVolume(10);

			Kitchen kitchen = house.getKitchen();
			kitchen.openRoom();
			kitchen.setCooktopSwitchedOn(true);
			kitchen.setExtractorHoodSwitchedOn(true);
			kitchen.setRefrigeratorTemperature(1);
			kitchen.setFreezerTemperature(-15);

			Bathroom bathroom = house.getBathroom();
			bathroom.openRoom();
			bathroom.setShowerTemperature(50);
			bathroom.setShowerFlowLevel(1);
			bathroom.setTapTemperature(50);
			bathroom.setTapFlowLevel(1);

			Bedroom bedroom = house.getBedroom();
			bedroom.openRoom();
			bedroom.setAlarmSwitchedOn(false);
			bedroom.setWaterbedTemperature(30);
		}
}