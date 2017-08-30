package domotica.view;

import java.util.*;
import javax.swing.*;

import domotica.model.*;

@SuppressWarnings("serial")
public class LivingView extends RoomView {

	private JTextField tvSwitchedOnField;
	private JTextField tvChannelField;
	private JTextField tvVolumeField;
		
	public LivingView(Living living) {
		super(living);
	}
	
	@Override
	protected void init() {
		super.init();
		tvSwitchedOnField = addLabelAndTextField("tv switched on?");
		tvChannelField = addLabelAndTextField("tv channel");
		tvVolumeField = addLabelAndTextField("tv volume");
	}
	
	@Override
	public void update(Observable o, Object arg) {
		super.update(o,arg);
		Living living = (Living)o;
		setTextField(tvSwitchedOnField,living.isTvSwitchedOn());
		setTextField(tvChannelField,living.getTvChannel());
		setTextField(tvVolumeField,living.getTvVolume());
	}
	
}
