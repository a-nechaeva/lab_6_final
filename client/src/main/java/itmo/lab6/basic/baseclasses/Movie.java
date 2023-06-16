package itmo.lab6.basic.baseclasses;

import itmo.lab6.basic.auxiliary.Randomness;
import itmo.lab6.basic.baseenums.MusicGenre;

import java.io.Serial;
import java.io.Serializable;
import java.time.format.DateTimeFormatter;

/**
 * The `Movie` class represents a movie, which includes its name, creation date,
 * number of Oscars it won, genre, MPAA rating, and director.
 *
 * @author dorlneylon
 * @version 99999999.9999999
 * @since 2023-02-02
 */
public class Movie implements Comparable<Movie>, Serializable {
	@Serial
	private static final long serialVersionUID = 6529685098267757690L;
	/**
	 * Reset the ANSI color.
	 */
	public static final String whcr = "\u001B[0m";

	/**
	 * The ANSI color for blue.
	 */
	public static final String blcr = "\u001B[34m";

	/**
	 * the ANSI color for purple.
	 */
	public static final String prcr = "\u001B[35m";
	/**
	 * The next unique ID to be assigned to a movie instance.
	 */
	private static Long nextId = Long.valueOf(1);

	/**
	 * The unique ID of the movie.
	 * Generates automatically, can't be null, greater than zero.
	 */
	private Long id;

	/**
	 * The name of the movie. Can't be null and an empty sequence.
	 */
	private String name;

	/**
	 * The coordinates of the movie. Can't be nulld
	 * @see Coordinates
	 */
	private Coordinates coordinates;

	/**
	 * The creation date of the movie. Generates automatically, can't be null.
	 */
	private java.time.ZonedDateTime creationDate;

	/**
	 * The number of participants. Not negative.
	 */
	private int numberOfParticipants;

	/**
	 * The number of singles. Not negative.
	 */
	private Integer singlesCount;

	private java.time.LocalDate establishmentDate;

	/**
	 * The genre of the movie.
	 * @see MusicGenre
	 */
	private MusicGenre genre;

	/**
	 * The Studio. The field can't be null.
	 * @see Studio
	 */
	private Studio studio;

	/**
	 * Constructor to create a movie with the given parameters.
	 * Automatically sets the id and creation date for the movie.
	 * @param name the name of the movie
	 * @param coordinates the coordinates of the movie
	 * @param numberOfParticipants the number of participants
	 * @param singlesCount the number of singles
	 * @param establishmentDate the date of establish
	 * @param genre the genre of the movie
	 * @param studio the director of the movie
	 * @see Studio
	 * @see Coordinates
	 * @see MusicGenre
	// * @see MpaaRating
	 */
	public Movie(String name, Coordinates coordinates, int numberOfParticipants, Integer singlesCount, java.time.LocalDate establishmentDate, MusicGenre genre, Studio studio) {
		if (name == null || name.isEmpty() || coordinates == null  || numberOfParticipants < 0 || genre == null || studio == null) throw new IllegalArgumentException("The fields can't be null or empty sequences.");
		this.id = nextId++;
		this.name = name;
		this.coordinates = coordinates;
		this.numberOfParticipants = numberOfParticipants;
		this.singlesCount = singlesCount;
		this.establishmentDate = establishmentDate;
		this.genre = genre;
		this.studio = studio;
		this.creationDate = java.time.ZonedDateTime.now();
	}

	public Movie(Long id, String name, Coordinates coordinates, int numberOfParticipants, Integer singlesCount,  java.time.LocalDate establishmentDate, MusicGenre genre, Studio studio) {
		if (name == null || name.isEmpty() || coordinates == null ||  numberOfParticipants < 0 || genre == null || studio == null) throw new IllegalArgumentException("The fields can't be null or empty sequences.");
		this.id = id;
		this.name = name;
		this.coordinates = coordinates;
		this.numberOfParticipants = numberOfParticipants;
		this.singlesCount = singlesCount;
		this.establishmentDate = establishmentDate;
		this.genre = genre;
		this.studio = studio;
		this.creationDate = java.time.ZonedDateTime.now();
	}

	/**
	 * Constructs a `Movie` instance with the specified ID, name, coordinates, creation date,
	 * number of Oscars, genre, MPAA rating, and director.
	 *
	 * @param id the unique ID of the movie
	 * @param name the name of the movie
	 * @param coordinates the coordinates of the movie
	 * @param creationDate the creation date of the movie
	 * @param numberOfParticipants the number of participants
	 * @param singlesCount the number of singles
	 * @param establishmentDate the date of establish
	 * @param genre the genre of the movie
	 * @param studio the director of the movie
	 * @see Movie#Movie(String name, Coordinates coordinates, int numberOfParticipants, Integer singlesCount, java.time.LocalDate establishmentDate, MusicGenre genre, Studio studio)
	 */
	public Movie(Long id, String name, Coordinates coordinates, java.time.ZonedDateTime creationDate, int numberOfParticipants, Integer singlesCount, java.time.LocalDate establishmentDate, MusicGenre genre, Studio studio) {
		if (name == null || name.isEmpty() || coordinates == null || numberOfParticipants < 0 || genre == null  || studio == null) throw new IllegalArgumentException("The fields can't be null or empty sequences.");
		nextId++;
		this.id = id;
		this.name = name;
		this.coordinates = coordinates;
		this.creationDate = creationDate;
		this.numberOfParticipants = numberOfParticipants;
		this.establishmentDate = establishmentDate;
		this.singlesCount = singlesCount;
		this.genre = genre;
		this.studio = studio;
	}

	/**
	 * Constructs a `Movie` instance with the specified name, and random values for the other attributes.
	 *
	 * @param name the name of the movie
	 * @see Movie#Movie(String name, Coordinates coordinates, int numberOfParticipants, Integer singlesCount, java.time.LocalDate establishmentDate, MusicGenre genre, Studio studio)
	 */
	public Movie(String name) {
		this.id = nextId++;
		this.name = name;
		this.creationDate = java.time.ZonedDateTime.now();
		this.coordinates = new Coordinates();
		this.numberOfParticipants = 0;
		this.singlesCount = null;
		this.establishmentDate = null;
		this.genre = Randomness.random(MusicGenre.class);
		this.studio = new Studio();
	}

	/**
	 * Constructs a `Movie` instance with default values for all attributes.
	 * @see Movie#Movie(String name, Coordinates coordinates, int numberOfParticipants, Integer singlesCount, java.time.LocalDate establishmentDate, MusicGenre genre, Studio studio)
	 */
	public Movie() {}

	public java.time.LocalDate getEstablishmentDate() {return establishmentDate;}
	public void setEstablishmentDate(java.time.LocalDate establishmentDate) {
		this.establishmentDate = establishmentDate;
	}

	/**
	 * @return the unique ID of the movie
	 * @see Movie#id
	 * @see Movie#nextId
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the name of the movie
	 * @see Movie#name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the coordinates of the movie
	 * @see Movie#coordinates
	 */
	public Coordinates getCoordinates() {
		return coordinates;
	}

	/**
	 * @return the creation date of the movie
	 * @see Movie#creationDate
	 */
	public java.time.ZonedDateTime getCreationDate() {
		return creationDate;
	}

	/**
	 * @return the genre of the movie
	 * @see Movie#genre
	 */
	public MusicGenre getGenre() {
		return genre;
	}

	/**
	 * @return the director of the movie
	 * @see Movie#studio
	 * @see Studio
	 */
	public Studio getStudio() {
		return studio;
	}

	/**
	 * @return the amount of Oscars won by the movie.
	// * @see Movie#oscarsCount()
	 */
	//@Deprecated
	public int getNumberOfParticipants() {
		return numberOfParticipants;
	}

	/**
	 * @return the amount of Oscars won by the movie.
	// * @see Movie#oscarsCount()
	 */
	public Integer getSinglesCount() {
		return singlesCount;
	}


	/**
	 * Used to set the name of the movie.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Used to set the coordinates of the movie.
	 * @see Coordinates
	 */
	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}

	/**
	 * Used to set the amount of Oscars won by the movie.
	 * @param numberOfParticipants
	 * @see Movie#numberOfParticipants
	 */
	public void setNumberOfParticipants(int numberOfParticipants) {
		this.numberOfParticipants = numberOfParticipants;
	}

	public void setSinglesCount(Integer singlesCount) {
		this.singlesCount = singlesCount;
	}

	/**
	 * Used to set the genre of the movie.
	 * @see Movie#genre
	 * @see MusicGenre
	 */
	public void setGenre(MusicGenre genre) {
		this.genre = genre;
	}


	/**
	 * Used to set the director of the movie.
	 * @see Movie#studio
	 * @see Studio
	 */
	public void setStudio(Studio studio) {
		this.studio = studio;
	}

	/**
	 * Used to set the creation date of the movie.
	 */
	public void setCreationDate(java.time.ZonedDateTime creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * Used to set the ID of the movie.
	 */
	public void setId(Long id) {
		this.id = id;
	}

//	/**
//	 * Used to compare ids.
//	 */
//	public int compareTo(Movie movie) {
//		return this.id.compareTo(movie.id);
//	}

	public Object[] getFields() {
		return new Object[] {id, name, coordinates, creationDate, numberOfParticipants, genre, studio};
	}

	/**
	 * Used to compare movies.
	 */
	@Override
	public int compareTo(Movie movie) {  return (int) (this.getNumberOfParticipants() - movie.getNumberOfParticipants()); }


	/**
	 * Used see if two movies are set on the same position.
	 */
	public boolean equals(Movie movie) {
		return coordinates.equals(movie.getCoordinates()) && name.equals(movie.getName()) && numberOfParticipants == movie.getNumberOfParticipants() && genre == movie.getGenre() && studio.equals(movie.getStudio());
	}

	/**
	 * Used to print the movie info.
	 * @return the movie info
	 * @see Studio#toString()
	 */
	public String toString() {
		return id + ".\n" + prcr + "Film's title: " + whcr + name + ",\n"
			+ prcr + "Film's coords: " + whcr + coordinates + ",\n"
			+ prcr + "Creation Date: " + whcr + creationDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) + ",\n"
			+ prcr + "Number of Participants: " + whcr + numberOfParticipants + ",\n"
			+ prcr + "Singles Count: " + whcr + singlesCount + ",\n"
			+ prcr +"Establishment Date = " + establishmentDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) + ",\n"
			+ prcr + "Genre: " + whcr + genre + ",\n"
			+ prcr + "\n" + studio.toString();
	}

}
