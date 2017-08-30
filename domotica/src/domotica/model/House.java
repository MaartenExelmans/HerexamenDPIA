package domotica.model;

@SuppressWarnings("serial")
public class House extends DomoticaObject {

	private Bathroom bathroom;
	private Bedroom bedroom;
	private Kitchen kitchen;
	private Living living;

	public House(String id) {
		super(id);
		bathroom = new Bathroom("bathroom@"+id);
		bedroom = new Bedroom("bedroom@" + id);
		kitchen = new Kitchen("kitchen@" + id);
		living = new Living("living@" + id);
	}

	public Bathroom getBathroom()	{	return bathroom; }
	public Bedroom getBedroom() 	{	return bedroom;	}
	public Kitchen getKitchen() 	{	return kitchen;	}
	public Living getLiving() 		{	return living; }

}
