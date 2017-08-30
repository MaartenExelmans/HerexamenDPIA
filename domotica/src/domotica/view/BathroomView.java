package domotica.view;

import java.util.*;
import javax.swing.*;

import domotica.model.*;

@SuppressWarnings("serial")
public class BathroomView extends RoomView {

	private JTextField showerTemperatureField;
	private JTextField showerFlowLevelField;
	private JTextField tapTemperatureField;
	private JTextField tapFlowLevelField;
	
	public BathroomView(Bathroom bathroom) {
		super(bathroom);
	}

	@Override
	protected void init() {
		super.init();
		showerTemperatureField = addLabelAndTextField("shower temprature");
		showerFlowLevelField = addLabelAndTextField("shower flow level");
		tapTemperatureField = addLabelAndTextField("tap temprature");
		tapFlowLevelField = addLabelAndTextField("tap flow level");
	}
	
	@Override
	public void update(Observable o, Object arg) {
		super.update(o,arg);
		Bathroom bathroom = (Bathroom)o;
		setTextField(showerTemperatureField,bathroom.getShowerTemperature());
		setTextField(showerFlowLevelField,bathroom.getShowerFlowLevel());
		setTextField(tapTemperatureField,bathroom.getTapTemperature());
		setTextField(tapFlowLevelField,bathroom.getTapFlowLevel());
	}
	
	
}
