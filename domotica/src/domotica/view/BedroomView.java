package domotica.view;

import java.util.*;
import javax.swing.*;

import domotica.model.*;

@SuppressWarnings("serial")
public class BedroomView extends RoomView {

	private JTextField alarmSwitchedOnField;
	private JTextField waterbedTemperatureField;

	public BedroomView(Bedroom bedroom) {
		super(bedroom);
	}
	
	@Override
	protected void init() {
		super.init();
		alarmSwitchedOnField = addLabelAndTextField("alarm switched on?");
		waterbedTemperatureField = addLabelAndTextField("waterbed temperature");
	}
	
	@Override
	public void update(Observable o, Object arg) {
		super.update(o,arg);
		Bedroom bedroom = (Bedroom)o;
		setTextField(alarmSwitchedOnField,bedroom.isAlarmSwitchedOn());
		setTextField(waterbedTemperatureField,bedroom.getWaterbedTemperature());		
	}
	
}
