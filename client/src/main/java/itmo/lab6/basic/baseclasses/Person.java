package itmo.lab6.basic.baseclasses;

import itmo.lab6.basic.auxiliary.Randomness;
import itmo.lab6.basic.baseenums.Color;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * The `Person` class implements `Serializable` interface and is used to store information about a person.
 * It has various instance variables to store the person's name, birthday, height, hair color, and location.
 * The class provides constructors with different parameters and getters and setters for all the instance variables.
 * It also provides an implementation of the `toString()` method for convenient output.
 *
 * @author zxc nylon
 * @version 1.0
 * @since 1999
 */
public class Person implements Serializable {
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
	 * The name of the person.
	 */
	private String name;

	/**
	 * Returns the name of the person.
	 *
	 * @return The name of the person.
	 */
	public String getName() {
		return name;
	}


	/**
	 * Creates a new `Person` object with the specified parameters.
	 *
	 * @param name The name of the person.
	 */

	public Person(String name) {
		if (name == null || name.isEmpty())
			throw new IllegalArgumentException("Can't be null or empty sequences.");
		this.name = name;
	}



	/**
	 * Creates a new `Person` object with standard parameters.
	 */
	public Person() {
		this.name = "Quentin Tarantino";
	}

	/**
	 * Sets the name of the person.
	 *
	 * @param name The name of the person.
	 */
	public void setName(String name) {
		this.name = name;
	}

	public boolean equals(Person p) {
		return this.name.equals(p.name);
	}



	public String toString() {
		return prcr + "Director's name: " + whcr + name;
	}
}
