package itmo.lab6.basic.moviecollection;

import itmo.lab6.basic.baseclasses.MusicBand;
import itmo.lab6.basic.baseclasses.Studio;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * The MovieCol class is a collection based on HashMap that extends the MusicBandHashtable class.
 * This class contains instance variables used to store information about movies.
 *
 * @see MusicBandHashtable
 * @see MusicBand
 */
public class MovieCollection extends MusicBandHashtable<Long, MusicBand> {
    /**
     * Instantiates a new MovieCol object.
     */
    public MovieCollection() {
    }

    /**
     * prints the collection elements and its contents to the console
     *
     * @see MusicBand
     * @see Studio
     */
    public String show() {
        MusicBand[] musicBands = getSortedMoviesName(false);
        return Arrays.stream(musicBands).map(Object::toString).collect(Collectors.joining("\n"));
      //  return Arrays.stream(this.values()).map(MusicBand::toString).collect(Collectors.joining("\n"));
    }

    /**
     * removes all elements with higher number of participants than given key from the collection.
     *
     * @param key the key to compare with.
     */
    public boolean removeGreater(Long key) {
        return Arrays.stream(this.values())
                .filter(musicBand -> musicBand.getSinglesCount() > key)
                .map(movie -> this.removeByKey(movie.getId()))
                .reduce(false, (a, b) -> a || b);
    }

    /**
     * removes all elements with less number of participants than given key from the collection.
     *
     * @param key the key to compare with.
     */
    public boolean removeLower(Long key) {
        return Arrays.stream(this.values())
                .filter(musicBand -> musicBand.getSinglesCount() < key)
                .map(movie -> this.removeByKey(movie.getId()))
                .reduce(false, (a, b) -> a || b);
    }

    public boolean equals(MovieCollection map) {
        MusicBand[] a = this.values();
        MusicBand[] b = map.values();
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++) if (!a[i].equals(b[i])) return false;
        return true;
    }

    /**
     * sorts the elements of the collection by the number of participants received and prints them in a new order.
     *
     * @see MusicBand
     */
    @Override
    public String printAscending() {
        MusicBand[] musicBands = getSortedMovies(false);
        return Arrays.stream(musicBands).map(Object::toString).collect(Collectors.joining("\n"));
    }

    /**
     * sorts the elements of the collection by the number of participants received in a reversed order and prints them.
     *
     * @see MusicBand
     */
    @Override
    public String printDescending() {
        MusicBand[] musicBands = getSortedMovies(true);
        return Arrays.stream(musicBands).map(Object::toString).collect(Collectors.joining("\n"));
    }

    /**
     * get the id of the element in the collection
     *
     * @param musicBand the element to get the id of
     * @return the id of the element or -1 if the element is not in the collection
     * @see MusicBand
     */
    @Override
    public Long getKey(MusicBand musicBand) {
        return musicBand.getId();
    }

    /**
     * get the elements of the collection
     *
     * @return MusicBand[]
     * @see MusicBand
     */
    @Override
    public MusicBand[] values() {
        return this.getMap().values().toArray(new MusicBand[this.size()]);
    }

    /**
     * swap the elements if the provided elements has less number of participants than the element in the collection
     *
     * @param key   the key of the element in the collection
     * @param musicBand the element to compare with
     * @return true if the elements are swapped, false otherwise
     */
    public boolean replaceLower(Long key, MusicBand musicBand) {
        if (musicBand.getNumberOfParticipants() < this.get(key).getNumberOfParticipants()) {
            this.update(key, musicBand);
            return true;
        }
        return false;
    }

    /**
     * check if the collection contains such an element.
     *
     * @param musicBand the element to check
     * @return true if the element is in the collection, false otherwise
     * @see MusicBand
     */
    @Override
    public boolean contains(MusicBand musicBand) {
        return this.getMap().containsValue(musicBand);
    }

    /**
     * check if the collection contains such a key.
     *
     * @param key the key to check
     * @return true if the key is in the collection, false otherwise
     */
    public boolean isKeyPresented(Long key) {
        return this.getMap().containsKey(key);
    }

    @Override
    public MusicBand[] getSortedMovies(boolean reverse) {
        MusicBand[] musicBands = this.values();
        Arrays.sort(musicBands, (reverse) ? Comparator.reverseOrder() : Comparator.naturalOrder());
        return musicBands;
    }

    public MusicBand[] getSortedMoviesName(boolean reverse) {
        MusicBand[] musicBands = this.values();
        Arrays.sort(musicBands, (reverse) ? Comparator.reverseOrder() : Comparator.naturalOrder());
        return musicBands;
    }


}
