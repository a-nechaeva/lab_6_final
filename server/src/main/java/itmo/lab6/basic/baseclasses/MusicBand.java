package itmo.lab6.basic.baseclasses;

import itmo.lab6.basic.baseclasses.builders.annotations.Generated;
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
    @Generated
    private static final long serialVersionUID = 6529685098267757690L;

    @Generated
    private static Long nextId = 1L;

    /**
     * The unique ID of the music band.
     * Generates automatically, can't be null, greater than zero.
     */
    private Long id;

    /**
     * The name of the music band. Can't be null and an empty sequence.
     */
    private String name;

    /**
     * The coordinates of the music band. Can't be null
     *
     * @see Coordinates
     */
    private Coordinates coordinates;

    /**
     * The creation date of the music band. Generates automatically, can't be null.
     */
    private java.time.ZonedDateTime creationDate;

    /**
     * The number of participants won by the music band. Not negative.
     */
    private int numberOfParticipants;

    /**
     * The number of singles. Not negative.
     */
    private Integer singlesCount;

    private Date establishmentDate;


    /**
     * The genre of the music.
     *
     * @see MusicGenre
     */
    private MusicGenre genre;

    /**
     * The studio of the music band. The field can't be null.
     *
     * @see Studio
     */
    private Studio studio;

    /**
     * Constructor to create a music band with the given parameters.
     * Automatically sets the id and creation date for the music band.
     *
     * @param name        the name of the music band
     * @param coordinates the coordinates of the music band
     * @param numberOfParticipants the number of participants of the music band
     * @param singlesCount the number of singles
     * @param establishmentDate the date of establish
     * @param genre       the genre of the music
     * @param studio    the studio of the music band
     * @see Studio
     * @see Coordinates
     * @see MusicGenre
     */
    public MusicBand(String name, Coordinates coordinates, int numberOfParticipants, Integer singlesCount, Date establishmentDate, MusicGenre genre, Studio studio) {
        if (name == null || name.isEmpty() || coordinates == null || numberOfParticipants < 0 || genre == null  || studio == null)
            throw new IllegalArgumentException("The fields can't be null or empty sequences.");
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

    /**
     * Constructs a `MusicBand` instance with the specified ID, its name, creation date,
     * number of participants, singles count, establishment date, genre and studio.
     *
     * @param id           the unique ID of the music band
     * @param name         the name of the music band
     * @param coordinates  the coordinates of the music band
     * @param creationDate the creation date of the music band
     * @param singlesCount the number of singles
     * @param numberOfParticipants  the number of participants
     * @param establishmentDate the date of establish
     * @param genre        the genre of the music
     * @param studio     the studio of the music band
     * @see MusicBand#MusicBand(String name, Coordinates coordinates, int numberOfParticipants, Integer singlesCount, Date establishmentDate, MusicGenre genre, Studio studio)
     */
    public MusicBand(Long id, String name, Coordinates coordinates, java.time.ZonedDateTime creationDate, int numberOfParticipants, Integer singlesCount, Date establishmentDate, MusicGenre genre, Studio studio) {
        if (name == null || name.isEmpty() || coordinates == null || numberOfParticipants < 0 || genre == null  || studio == null)
            throw new IllegalArgumentException("The fields can't be null or empty sequences.");
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
     * @return the unique ID of the music band
     * @see MusicBand#id
     * @see MusicBand#nextId
     */
    public Long getId() {
        return id;
    }

    /**
     * Used to set the ID of the music band
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the establishment date of the music band
     * @see MusicBand#establishmentDate
     */
    public Date getEstablishmentDate() {return establishmentDate;}

    /**
     * Used to set the establishment date of the music band
     */
    public void setEstablishmentDate(Date establishmentDate) {
        this.establishmentDate = establishmentDate;
    }

    /**
     * @return the name of the music band
     * @see MusicBand#name
     */
    public String getName() {
        return name;
    }

    /**
     * Used to set the name of the music band
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the coordinates of the music band
     * @see MusicBand#coordinates
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }

    /**
     * Used to set the coordinates of the music band
     *
     * @see Coordinates
     */
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    /**
     * @return the creation date of the music band
     * @see MusicBand#creationDate
     */
    public java.time.ZonedDateTime getCreationDate() {
        return creationDate;
    }

    /**
     * Used to set the creation date of the music band
     */
    public void setCreationDate(java.time.ZonedDateTime creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * @return the genre of the music band
     * @see MusicBand#genre
     */
    public MusicGenre getGenre() {
        return genre;
    }

    /**
     * Used to set the genre of the music band
     *
     * @see MusicBand#genre
     * @see MusicGenre
     */
    public void setGenre(MusicGenre genre) {
        this.genre = genre;
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
     * Used to set the studio of the music band
     *
     * @see MusicBand#studio
     * @see Studio
     */
    public void setStudio(Studio studio) {
        this.studio = studio;
    }

    /**
     * @return the number of participants of the music band
     * @see MusicBand#numberOfParticipants
     */
   // @Deprecated
    public int getNumberOfParticipants() {
        return numberOfParticipants;
    }

    /**
     * @return the number of singles of the music band
     * @see MusicBand#singlesCount
     */
    public Integer getSinglesCount() {
        return singlesCount;
    }

    public void setSinglesCount(Integer singlesCount) {
        this.singlesCount = singlesCount;
    }

    /**
     * Used to set the number of participants of the music band.
     *
     * @param numberOfParticipants
     * @see MusicBand#numberOfParticipants
     */
    public void setNumberOfParticipants(int numberOfParticipants) {
        this.numberOfParticipants = numberOfParticipants;
    }


    public Object[] getFields() {
        return new Object[]{id, name, coordinates, creationDate, numberOfParticipants, genre, studio};
    }

    /**
     * Used to compare music bands.
     */
    @Override
    public int compareTo(MusicBand musicBand) {
        return  (int) (this.getSinglesCount() - musicBand.getSinglesCount());
    }

    /**
     * Used see if two music bands are the same.
     */
    public boolean equals(MusicBand musicBand) {
        return coordinates.equals(musicBand.getCoordinates()) && name.equals(musicBand.getName()) && numberOfParticipants == musicBand.getNumberOfParticipants() && genre == musicBand.getGenre() &&  studio.equals(musicBand.getStudio());
    }

    @Override
    public String toString() {
        String establishmentDate = new java.text.SimpleDateFormat("dd.MM.yyyy").format(this.establishmentDate);
        return id + ".\n"
                + "Music band's name: " + name + ",\n"
                + "Music band's coordinates: " + coordinates + ",\n"
                + "Creation Date: " + creationDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) + ",\n"
                + "Number of Participants: " + numberOfParticipants + ",\n"
                + "Singles Count: " + singlesCount + ",\n"
       + "Establishment Date: " + establishmentDate + ",\n"
                + "Genre: " + genre + ",\n"
                + studio.toString();
    }
}
