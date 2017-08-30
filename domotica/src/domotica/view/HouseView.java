package domotica.view;

import java.awt.*;
import javax.swing.*;

import domotica.model.*;

@SuppressWarnings("serial")
public class HouseView extends JFrame {

	public HouseView(House house) {
		super(house.getId());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(2,2));
		add(new LivingView(house.getLiving()));
		add(new KitchenView(house.getKitchen()));
		add(new BathroomView(house.getBathroom()));
		add(new BedroomView(house.getBedroom()));		
		pack();
		setVisible(true);
	}
	
}
