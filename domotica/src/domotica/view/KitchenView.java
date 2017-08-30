package domotica.view;

import java.util.*;
import javax.swing.*;

import domotica.model.*;

@SuppressWarnings("serial")
public class KitchenView extends RoomView {

	private JTextField cooktopSwitchedOnField;
	private JTextField extractorHoodSwitchedOnField;
	private JTextField refrigeratorTemperatureField;
	private JTextField freezerTempratureField;
	
	public KitchenView(Kitchen kitchen) {
		super(kitchen);
	}
	
	@Override
	protected void init() {
		super.init();
		cooktopSwitchedOnField = addLabelAndTextField("cooktop switched on?");
		extractorHoodSwitchedOnField = addLabelAndTextField("extractor hood switched on?");
		refrigeratorTemperatureField = addLabelAndTextField("refrigerator temperature");
		freezerTempratureField = addLabelAndTextField("freezer temperature");
	}
	
	@Override
	public void update(Observable o, Object arg) {
		super.update(o,arg);
		Kitchen kitchen = (Kitchen)o;
		setTextField(cooktopSwitchedOnField,kitchen.isCooktopSwitchedOn());
		setTextField(extractorHoodSwitchedOnField,kitchen.isExtractorHoodSwitchedOn());	
		setTextField(refrigeratorTemperatureField,kitchen.getRefrigeratorTemperature());
		setTextField(freezerTempratureField,kitchen.getFreezerTemprature());		
	}
	
}
