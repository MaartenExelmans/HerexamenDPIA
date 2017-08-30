package domotica.view;

import java.util.*;
import java.awt.*;
import javax.swing.*;

import domotica.model.*;

@SuppressWarnings("serial")
public abstract class RoomView extends JPanel implements Observer {

	private JTextField aircoTemperatureField;
	private JTextField lightLevelField;
	private JTextField rollerShutterDownField;
	private JTextField doorClosedField;

	public RoomView(Room room) {
		room.addObserver(this);
		setBorder(BorderFactory.createTitledBorder(room.getId()));
		init();
		setLayout(new GridLayout(getComponents().length/2, 2));
		update(room,null);
	}

	protected JTextField addLabelAndTextField(String label) {
		add(new JLabel(label));
		JTextField field = new JTextField(10);
		field.setEditable(false);
		add(field);
		return field;
	}
	
	protected void init() {
		aircoTemperatureField = addLabelAndTextField("airco temperature");
		lightLevelField = addLabelAndTextField("light level");
		rollerShutterDownField = addLabelAndTextField("roller shutter down?");
		doorClosedField = addLabelAndTextField("door closed?");
	}
	
	protected static void setTextField(JTextField field, Object obj) {
		field.setText(obj.toString());
	}
	
	@Override
	public void update(Observable o, Object arg) {
		Room room = (Room)o;
		setTextField(aircoTemperatureField,room.getAircoTemperature());
		setTextField(lightLevelField,room.getLightLevel());
		setTextField(rollerShutterDownField,room.isRollerShutterDown());
		setTextField(doorClosedField,room.isDoorClosed());
	}

}
