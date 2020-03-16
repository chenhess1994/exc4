package cities;

import java.util.Set;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.List;

public class Country implements Comparable<Country>{
	private Set<City> cities;
	private String name;

	public Country(String name) {
		if(name.length() ==0) 
			throw new IllegalArgumentException("Country name is empty");
		this.name = name;
		cities = new TreeSet<City>();
	}

	public void addCity(City city) {
		if (!city.getCountry().name.equals(name) || city == null)
			throw new IllegalArgumentException("This city is not in this country");
		cities.add(city);
	}

	/**
	 * Returns the sum of all populations
	 * in all cities in the country.
	 * @return sum of cities populations : int
	 */
	public int population() {
		int sum = 0;
		for (City city : cities) {
			sum += city.getPopulation();
		}
		return sum;
	}

	/**
	 * @return the name of the city : String
	 */
	public String toString() {
		return name;
	}
	/**
	 * return country population and each city population
	 * it is already sort thanks to the comparable of our object.
	 * @return Report: String
	 */
	public String report() {
		StringBuilder str = new StringBuilder("");
		str.append(name);
		str.append("(");
		str.append(population());
		str.append(") : ");
		//Set<City> sorted cities = new TreeSet<City>();

		for (City city : cities) {
			str.append(city.getName());
			str.append("(");
			str.append(city.getPopulation());
			str.append("), ");
		}
		str.deleteCharAt(str.length()-1);
		str.deleteCharAt(str.length()-1);

		return str.toString();
	}

	public List<City> smallCities(int under) {
		List <City> l = new ArrayList<City>();
		if(under < 0) return l;
		for (City city : cities) {
			if(city.getPopulation() < under)
				l.add(city);
		}
		return l;
	}

	@Override
	public int compareTo(Country arg0) {
		return name.compareTo(arg0.name);
	}
	@Override
	public boolean equals(Object country) {
		return compareTo((Country) country) == 0 ? true : false;
	}

}
