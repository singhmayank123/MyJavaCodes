public class Temperature{
// holds temperature in fahrenheit
	private double ftemp; 
	// constructor to initialize ftemp

	public Temperature(double ftemp){
		this.ftemp = ftemp;
	}

	/** method to set the temperature in fahrenheit **/
	public void setFahrenheit(double ftemp){
		this.ftemp = ftemp;
	}

	/** method to get the temperature in fahrenheit **/
	public double getFahrenheit(){
		return ftemp;
	}

	/** method to get the temperature in celcius **/
	public double getCelcius(){
		double celcius = (5.0/9.0) * (ftemp - 32);
		return celcius;
	}

	/** method to get the temperature in kelvin **/

	public double getKelvin(){
		double kelvin = getCelcius() + 273;
		return kelvin;
	}

}