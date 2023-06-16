package itmo.lab6.basic.types.builders;

import itmo.lab6.basic.baseclasses.Coordinates;
import itmo.lab6.basic.baseclasses.Movie;
import itmo.lab6.basic.baseclasses.Studio;
import itmo.lab6.basic.baseenums.MusicGenre;
import itmo.lab6.basic.types.builders.annotations.Generated;
import itmo.lab6.basic.types.builders.annotations.NotNull;
import itmo.lab6.basic.types.builders.annotations.Value;

import java.time.ZonedDateTime;

public class MovieBuilder implements Builder {
    @NotNull
    @Generated
    @Value(min = 0)
    private Long id;
    @NotNull
    private String name;

    @NotNull
    private Coordinates coordinates;
    @NotNull
    @Generated
    private ZonedDateTime creationDate;

    @Value(min = 0)
    private int numberOfParticipants;

    @Value(min = 0)
    private Integer singlesCount;

    @NotNull
    private MusicGenre genre;

    @NotNull
    private Studio studio;

    @Override
    public Movie build() {
        return new Movie(id, name, coordinates, creationDate, numberOfParticipants, singlesCount, genre, studio);
    }
}
