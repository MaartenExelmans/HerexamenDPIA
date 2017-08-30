package domotica.model;

class Checks {

	private Checks() {
		//	prevents instantiation
	}
	
	static void checkFloat(float f, float lo, float hi) {
		if (f < lo || hi < f) throw new IllegalArgumentException();
	}
	
	static void checkInt(int i, int lo, int hi) {
		if (i < lo || hi < i) throw new IllegalArgumentException();
	}
	
	
	//	onderstaande checks simuleren dat er af en toe eens iets mis kan gaan
	
	static void checkWater() throws WaterException {
		if (Math.random() < 0.1) throw new WaterException();
	}
	
	static void checkElectricity() throws ElectricityException {
		if (Math.random() < 0.1) throw new ElectricityException();
	}
	
	static void checkGas() throws GasException {
		if (Math.random() < 0.1) throw new GasException();
	}
	
}
