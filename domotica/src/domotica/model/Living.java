package domotica.model;

@SuppressWarnings("serial")
public class Living extends Room {

	private boolean tvSwitchedOn;
	private int tvChannel;
	private int tvVolume;

	Living(String id) {
		super(id);
	}

	public boolean isTvSwitchedOn()	{	return tvSwitchedOn; }
	public int getTvChannel() 		{	return tvChannel; }
	public int getTvVolume() 		{	return tvVolume; }
	
	public void setTvSwitchedOn(boolean tvSwitchedOn) {
		this.tvSwitchedOn = tvSwitchedOn;
	}
	
	public void setTvChannel(int tvChannel) throws ElectricityException {
		Checks.checkInt(tvChannel, 0, 99);
		Checks.checkElectricity();
		this.tvChannel = tvChannel;
	}
	
	public void setTvVolume(int tvVolume) throws ElectricityException {
		Checks.checkInt(tvVolume, 0, 10);
		Checks.checkElectricity();
		this.tvVolume = tvVolume;
	}

	@Override
	public void reset() throws DomoticaException {
		super.reset();
		setTvSwitchedOn(false);
		setTvChannel(1);
		setTvVolume(3);
	}
	
}
