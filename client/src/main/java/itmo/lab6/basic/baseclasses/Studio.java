package itmo.lab6.basic.baseclasses;


import java.io.Serial;
import java.io.Serializable;

/**
 * The `Studio` class implements `Serializable` interface and is used to store information about a studio.
 * It has various instance variables to store the studio's name.
 * The class provides constructors with different parameters and getters and setters for all the instance variables.
 * It also provides an implementation of the `toString()` method for convenient output.
 *
 */
public class Studio implements Serializable {
	@Serial
	private static final long serialVersionUID = 6529685098267757690L;
	/**
	 * A constant to represent the white color code in ANSI escape codes.
	 */
	public static final String whcr = "\u001B[0m";
	
	/**
	 * The ANSI color for blue.
	 */
	public static final String blcr = "\u001B[34m";

	/**
	 * A constant to represent the purple color code in ANSI escape codes.
	 */
	public static final String prcr = "\u001B[35m";

	/**
	 * The name of the studio.
	 */
	private String name;

	/**
	 * Returns the name of the studio.
	 *
	 * @return The name of the studio.
	 */
	public String getName() {
		return name;
	}


	/**
	 * Creates a new `Studio` object with the specified parameters.
	 *
	 * @param name The name of the studio.
	 */

	public Studio(String name) {
		if (name == null || name.isEmpty())
			throw new IllegalArgumentException("Can't be null or empty string.");
		this.name = name;
	}



	/**
	 * Creates a new `Studio` object with standard parameters.
	 */
	public Studio() {
		this.name = "Roses";
	}

	/**
	 * Sets the name of the studio.
	 *
	 * @param name The name of the studio.
	 */
	public void setName(String name) {
		this.name = name;
	}

	public boolean equals(Studio p) {
		return this.name.equals(p.name);
	}



	public String toString() {
		return prcr + "Studio's name: " + whcr + name;
	}
}
