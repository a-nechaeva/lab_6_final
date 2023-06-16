package itmo.lab6.basic.baseclasses;

import itmo.lab6.basic.auxiliary.Randomness;
import itmo.lab6.basic.baseenums.MusicGenre;

import java.io.Serial;
import java.io.Serializable;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * The `MusicBand` class represents a music band, which includes its name, creation date,
 * number of participants, singles count, establishment date, genre and studio.
 *
 */
public class MusicBand implements Comparable<MusicBand>, Serializable {
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
	 * The next unique ID to be assigned to a music band instance.
	 */
	private static Long nextId = Long.valueOf(1);

	/**
	 * The unique ID of the music band.
	 * Generates automatically, can't be null, greater than zero.
	 */
	private Long id;

	/**
	 * The name of the music band. Can't be null and an empty string.
	 */
	private String name;

	/**
	 * The coordinates of the music band. Can't be null
	 * @see Coordinates
	 */
	private Coordinates coordinates;

	/**
	 * The creation date of the music band. Generates automatically, can't be null.
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

	/**
	 * The date of establishment.
	 */
	private Date establishmentDate;

	/**
	 * The genre of the music band.
	 * @see MusicGenre
	 */
	private MusicGenre genre;

	/**
	 * The Studio. The field can't be null.
	 * @see Studio
	 */
	private Studio studio;

	/**
	 * Constructor to create a music band with the given parameters.
	 * Automatically sets the id and creation date for the music band.
	 * @param name the name of the music band
	 * @param coordinates the coordinates of the music band
	 * @param numberOfParticipants the number of participants
	 * @param singlesCount the number of singles
	 * @param establishmentDate the date of establish
	 * @param genre the genre of the music
	 * @param studio the studio of the  music band
	 * @see Studio
	 * @see Coordinates
	 * @see MusicGenre
	 */
	public MusicBand(String name, Coordinates coordinates, int numberOfParticipants, Integer singlesCount, Date establishmentDate, MusicGenre genre, Studio studio) {
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

	public MusicBand(Long id, String name, Coordinates coordinates, int numberOfParticipants, Integer singlesCount,  Date establishmentDate, MusicGenre genre, Studio studio) {
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
	 * Constructs a `MusicBand` instance with the specified ID, its name, creation date,
	 * number of participants, singles count, establishment date, genre and studio.
	 *
	 * @param id the unique ID of the music band
	 * @param name the name of the music band
	 * @param coordinates the coordinates of the music band
	 * @param creationDate the creation date of the music band
	 * @param numberOfParticipants the number of participants
	 * @param singlesCount the number of singles
	 * @param establishmentDate the date of establish
	 * @param genre the genre of the music band
	 * @param studio the director of the music band
	 * @see MusicBand#MusicBand(String name, Coordinates coordinates, int numberOfParticipants, Integer singlesCount, Date establishmentDate, MusicGenre genre, Studio studio)
	 */
	public MusicBand(Long id, String name, Coordinates coordinates, java.time.ZonedDateTime creationDate, int numberOfParticipants, Integer singlesCount, Date establishmentDate, MusicGenre genre, Studio studio) {
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
	 * Constructs a `MusicBand` instance with the specified name, and random values for the other attributes.
	 *
	 * @param name the name of the music band
	 * @see MusicBand#MusicBand(String name, Coordinates coordinates, int numberOfParticipants, Integer singlesCount, Date establishmentDate, MusicGenre genre, Studio studio)
	 */
	public MusicBand(String name) {
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
	 * Constructs a `MusicBand` instance with default values for all attributes.
	 * @see MusicBand#MusicBand(String name, Coordinates coordinates, int numberOfParticipants, Integer singlesCount, Date establishmentDate, MusicGenre genre, Studio studio)
	 */
	public MusicBand() {}

	/**
	 * @return the date of establish of the music band
	 * @see MusicBand#establishmentDate
	 */
	public Date getEstablishmentDate() {return establishmentDate;}
	public void setEstablishmentDate(Date establishmentDate) {
		this.establishmentDate = establishmentDate;
	}

	/**
	 * @return the unique ID of the music band
	 * @see MusicBand#id
	 * @see MusicBand#nextId
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the name of the music band
	 * @see MusicBand#name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the coordinates of the music band
	 * @see MusicBand#coordinates
	 */
	public Coordinates getCoordinates() {
		return coordinates;
	}

	/**
	 * @return the creation date of the music band
	 * @see MusicBand#creationDate
	 */
	public java.time.ZonedDateTime getCreationDate() {
		return creationDate;
	}

	/**
	 * @return the genre of the music band
	 * @see MusicBand#genre
	 */
	public MusicGenre getGenre() {
		return genre;
	}

	/**
	 * @return the director of the music band
	 * @see MusicBand#studio
	 * @see Studio
	 */
	public Studio getStudio() {
		return studio;
	}

	/**
	 * @return the number of participants.
	 */
	//@Deprecated
	public int getNumberOfParticipants() {
		return numberOfParticipants;
	}

	/**
	 * @return the number of singles.
	 */
	public Integer getSinglesCount() {
		return singlesCount;
	}


	/**
	 * Used to set the name of the music band.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Used to set the coordinates of the music band.
	 * @see Coordinates
	 */
	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}

	/**
	 * Used to set the number of participants.
	 * @param numberOfParticipants
	 * @see MusicBand#numberOfParticipants
	 */
	public void setNumberOfParticipants(int numberOfParticipants) {
		this.numberOfParticipants = numberOfParticipants;
	}

	/**
	 * Used to set the number of singles.
	 * @param singlesCount
	 * @see MusicBand#numberOfParticipants
	 */
	public void setSinglesCount(Integer singlesCount) {
		this.singlesCount = singlesCount;
	}

	/**
	 * Used to set the genre of the music band.
	 * @see MusicBand#genre
	 * @see MusicGenre
	 */
	public void setGenre(MusicGenre genre) {
		this.genre = genre;
	}


	/**
	 * Used to set the studio of the music band.
	 * @see MusicBand#studio
	 * @see Studio
	 */
	public void setStudio(Studio studio) {
		this.studio = studio;
	}

	/**
	 * Used to set the creation date of the music band.
	 */
	public void setCreationDate(java.time.ZonedDateTime creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * Used to set the ID of the music band.
	 */
	public void setId(Long id) {
		this.id = id;
	}


	public Object[] getFields() {
		return new Object[] {id, name, coordinates, creationDate, numberOfParticipants, genre, studio};
	}

	/**
	 * Used to compare movies.
	 */
	@Override
	public int compareTo(MusicBand musicBand) {  return (int) (this.getSinglesCount() - musicBand.getSinglesCount()); }


	/**
	 * Used see if two music band are same.
	 */
	public boolean equals(MusicBand musicBand) {
		return coordinates.equals(musicBand.getCoordinates()) && name.equals(musicBand.getName())
				&& numberOfParticipants == musicBand.getNumberOfParticipants() && genre == musicBand.getGenre()
				&& studio.equals(musicBand.getStudio());
	}

	/**
	 * Used to print the music band info.
	 * @return the music band info
	 * @see Studio#toString()
	 */
	public String toString() {
		String establishmentDate = new java.text.SimpleDateFormat("dd.MM.yyyy").format(this.establishmentDate);
		return id + ".\n" + prcr + "Music band's name: " + whcr + name + ",\n"
			+ prcr + "Music band's coordinates: " + whcr + coordinates + ",\n"
			+ prcr + "Creation Date: " + whcr + creationDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) + ",\n"
			+ prcr + "Number of Participants: " + whcr + numberOfParticipants + ",\n"
			+ prcr + "Singles Count: " + whcr + singlesCount + ",\n"
			+ prcr +"Establishment Date: " + whcr + establishmentDate + ",\n"
			+ prcr + "Genre: " + whcr + genre + ",\n"
			+ prcr + "\n" + studio.toString();
	}

}
