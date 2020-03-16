package cities;

public class City implements Comparable<City> {
	private String name;
	private Country country;
	private int population;

	/**
	 * City Constructor
	 * @throw IllegalArgumentException if one of the constructor parameters illigal
	 * @param name       : City
	 * @param country    : Country
	 * @param population : int
	 */
	public City(String name, Country country, int population) {
		if(population<0 || name.length() == 0 || country == null)
			throw new IllegalArgumentException("illigal city parameters");
		this.name = name;
		this.country = country;
		this.population = population;
	}

	/**
	 * city name Getter
	 * 
	 * @return name of the city : String
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * country name Getter
	 * 
	 * @return name of the country : String
	 */
	public Country getCountry() {
		return country;
	}

	/**
	 * population Getter
	 * 
	 * @return population : int
	 */
	public int getPopulation() {
		return population;
	}

	/**
	 * format: <b>cityname</b> (of <b>ountry</b>)
	 */
	public String toString() {
		return name + " (of " + country + ")";
	}

	@Override
	public int compareTo(City o) {
		return name.compareTo(o.getName());
	}
	@Override
	public boolean equals(Object city) {
		return compareTo((City) city) == 0 ? true : false;
	}

}
