package itmo.lab6.basic.baseclasses;

import itmo.lab6.basic.auxiliary.Randomness;
import itmo.lab6.basic.baseclasses.builders.annotations.Generated;
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
    @Generated
    private static final long serialVersionUID = 6529685098267757690L;

    /**
     * The name of the person.
     */
    private String name;


    /**
     * Creates a new `Person` object with the specified parameter.
     *
     * @param name The name of the person.
     */
    public Person(String name) {
        if (name == null || name.isEmpty()) throw new IllegalArgumentException("Can't be null or empty sequences.");
        this.name = name;
    }

    /**
     * Creates a new `Person` object with standard parameters.
     */
    public Person() {
        this.name = "Quentin Tarantino";
    }

    /**
     * Returns the name of the person.
     *
     * @return The name of the person.
     */
    public String getName() {
        return name;
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

    @Override
    public String toString() {
        return "Director's name: " + name + ",\n";
    }
}
