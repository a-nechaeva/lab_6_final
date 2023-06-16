package itmo.lab6.basic.baseclasses;

import itmo.lab6.basic.baseclasses.builders.annotations.Generated;
import itmo.lab6.basic.baseenums.MusicGenre;
import itmo.lab6.basic.baseenums.MpaaRating;

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
    @Generated
    private static final long serialVersionUID = 6529685098267757690L;

    @Generated
    private static Long nextId = 1L;

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
     * The coordinates of the movie. Can't be null
     *
     * @see Coordinates
     */
    private Coordinates coordinates;

    /**
     * The creation date of the movie. Generates automatically, can't be null.
     */
    private java.time.ZonedDateTime creationDate;

    /**
     * The number of participants won by the movie. Not negative.
     */
    private int numberOfParticipants;

    /**
     * The number of singles. Not negative.
     */
    private Integer singlesCount;


    /**
     * The genre of the movie.
     *
     * @see MusicGenre
     */
    private MusicGenre genre;

    /**
     * The director of the movie. The field can't be null.
     *
     * @see Studio
     */
    private Studio studio;

    /**
     * Constructor to create a movie with the given parameters.
     * Automatically sets the id and creation date for the movie.
     *
     * @param name        the name of the movie
     * @param coordinates the coordinates of the movie
     * @param numberOfParticipants the number of oscars won by the movie
     * @param singlesCount the number of singles
     * @param genre       the genre of the movie
     * @param studio    the director of the movie
     * @see Studio
     * @see Coordinates
     * @see MusicGenre
     */
    public Movie(String name, Coordinates coordinates, int numberOfParticipants, Integer singlesCount, MusicGenre genre, Studio studio) {
        if (name == null || name.isEmpty() || coordinates == null || numberOfParticipants < 0 || genre == null  || studio == null)
            throw new IllegalArgumentException("The fields can't be null or empty sequences.");
        this.id = nextId++;
        this.name = name;
        this.coordinates = coordinates;
        this.numberOfParticipants = numberOfParticipants;
        this.singlesCount = singlesCount;
        this.genre = genre;
        this.studio = studio;
        this.creationDate = java.time.ZonedDateTime.now();
    }

    /**
     * Constructs a `Movie` instance with the specified ID, name, coordinates, creation date,
     * number of Oscars, genre, MPAA rating, and director.
     *
     * @param id           the unique ID of the movie
     * @param name         the name of the movie
     * @param coordinates  the coordinates of the movie
     * @param creationDate the creation date of the movie
     * @param singlesCount the number of singles
     * @param numberOfParticipants  the number of participants
     * @param genre        the genre of the movie
     * @param studio     the director of the movie
     * @see Movie#Movie(String name, Coordinates coordinates, int numberOfParticipants, Integer singlesCount, MusicGenre genre, Studio studio)
     */
    public Movie(Long id, String name, Coordinates coordinates, java.time.ZonedDateTime creationDate, int numberOfParticipants, Integer singlesCount, MusicGenre genre, Studio studio) {
        if (name == null || name.isEmpty() || coordinates == null || numberOfParticipants < 0 || genre == null  || studio == null)
            throw new IllegalArgumentException("The fields can't be null or empty sequences.");
        nextId++;
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.numberOfParticipants = numberOfParticipants;
        this.singlesCount = singlesCount;
        this.genre = genre;
        this.studio = studio;
    }


    /**
     * @return the amount of Oscars won by the movie
     * @see Movie#oscarsCount
     */
    /*public long oscarsCount() {
        return oscarsCount;
    }

     */

    /**
     * @return the unique ID of the movie
     * @see Movie#id
     * @see Movie#nextId
     */
    public Long getId() {
        return id;
    }

    /**
     * Used to set the ID of the movie.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the name of the movie
     * @see Movie#name
     */
    public String getName() {
        return name;
    }

    /**
     * Used to set the name of the movie.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the coordinates of the movie
     * @see Movie#coordinates
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }

    /**
     * Used to set the coordinates of the movie.
     *
     * @see Coordinates
     */
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    /**
     * @return the creation date of the movie
     * @see Movie#creationDate
     */
    public java.time.ZonedDateTime getCreationDate() {
        return creationDate;
    }

    /**
     * Used to set the creation date of the movie.
     */
    public void setCreationDate(java.time.ZonedDateTime creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * @return the genre of the movie
     * @see Movie#genre
     */
    public MusicGenre getGenre() {
        return genre;
    }

    /**
     * Used to set the genre of the movie.
     *
     * @see Movie#genre
     * @see MusicGenre
     */
    public void setGenre(MusicGenre genre) {
        this.genre = genre;
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
     * Used to set the director of the movie.
     *
     * @see Movie#studio
     * @see Studio
     */
    public void setStudio(Studio studio) {
        this.studio = studio;
    }

    /**
     * @return the amount of Oscars won by the movie.
     //* @see Movie#numberOfParticipants()
   //  * @see MpaaRating
   //  * @deprecated use {@link Movie#getOscarsInt()} or {@link Movie#oscarsCount()} instead
     */
   // @Deprecated
    public int getNumberOfParticipants() {
        return numberOfParticipants;
    }

    public Integer getSinglesCount() {
        return singlesCount;
    }

    public void setSinglesCount(Integer singlesCount) {
        this.singlesCount = singlesCount;
    }

    /**
     * Used to set the amount of Oscars won by the movie.
     *
     * @param numberOfParticipants
     * @see Movie#numberOfParticipants
     */
    public void setNumberOfParticipants(int numberOfParticipants) {
        this.numberOfParticipants = numberOfParticipants;
    }

    /**
     * @return the amount of Oscars won by the movie as an integer.
   //  * @see Movie#oscarsCount()
   //  * @see MpaaRating
     */
  /*  public int getOscarsInt() {
        return (int) oscarsCount;
    }

   */


//	/**
//	 * Used to compare ids.
//	 */
//	public int compareTo(Movie movie) {
//		return this.id.compareTo(movie.id);
//	}

    public Object[] getFields() {
        return new Object[]{id, name, coordinates, creationDate, numberOfParticipants, genre, studio};
    }

    /**
     * Used to compare movies.
     */
    @Override
    public int compareTo(Movie movie) {
        return  (int) (this.getNumberOfParticipants() - movie.getNumberOfParticipants());
    }

    /**
     * Used see if two movies are set on the same position.
     */
    public boolean equals(Movie movie) {
        return coordinates.equals(movie.getCoordinates()) && name.equals(movie.getName()) && numberOfParticipants == movie.getNumberOfParticipants() && genre == movie.getGenre() &&  studio.equals(movie.getStudio());
    }

    @Override
    public String toString() {
        return id + ".\n"
                + "Film's title: " + name + ",\n"
                + "Film's coords: " + coordinates + ",\n"
                + "Creation Date: " + creationDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) + ",\n"
                + "Number of Participants: " + numberOfParticipants + ",\n"
                + "Singles Count: " + singlesCount + ",\n"
                + "Genre: " + genre + ",\n"
                + studio.toString();
    }
}
