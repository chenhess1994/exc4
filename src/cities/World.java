package cities;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class World {
	//The group of countries is reserved so that they can be reached by their name.
	private Map <String, Country> countries = new TreeMap<String, Country>();;
	private int sum_population;
	/**
	 * Create a new country by the given name,
	 * and adds it to countries data structure .
	 * @param name country name: String
	 */
	public void addCountry(String name) {
		if(name.length() ==0) 
			throw new IllegalArgumentException("Country name is empty");
		countries.put(name, new Country(name));
	}
	/**
	 * Create a new city and add it to the appropriate state object
	 * which it finds with the help of countries. If there is no country in this name,
	 * then thrown here IllegalArgumentException.
	 * @param name
	 * @param countryName
	 * @param population
	 */
	public void addCity(String name, String countryName, int population) {
		Country c = countries.get(countryName);
		if (c==null)
			throw new IllegalArgumentException(countryName+" not exist");

		c.addCity(new City(name, c, population));
		sum_population +=population;

	}
	/**
	 * Returns the total population in all the countries listed.
	 * @return total population : int
	 */
	public int population() {
		return sum_population;
	}


	public List<City> smallCities(int under) {
		List <City> l = new ArrayList<City>();
		if(under < 0) return l;
		for (Map.Entry<String, Country>  m : countries.entrySet()) {
			l.addAll(m.getValue().smallCities(under));
		}
		return l;
	}
	/**
	 * Returns a string that represents all.
	 * @return
	 */
	public String report() {
		StringBuilder str = new StringBuilder();
		for (Map.Entry<String, Country>  m : countries.entrySet()) {
			str.append(m.getValue().report());
			str.append("\n");
		}
		str.append("Total population is "+population());
		str.append("\n");		
		return str.toString();
	}

}
