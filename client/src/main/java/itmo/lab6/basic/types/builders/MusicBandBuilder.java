package itmo.lab6.basic.types.builders;

import itmo.lab6.basic.baseclasses.Coordinates;
import itmo.lab6.basic.baseclasses.MusicBand;
import itmo.lab6.basic.baseclasses.Studio;
import itmo.lab6.basic.baseenums.MusicGenre;
import itmo.lab6.basic.types.builders.annotations.Generated;
import itmo.lab6.basic.types.builders.annotations.NotNull;
import itmo.lab6.basic.types.builders.annotations.Value;

import java.time.ZonedDateTime;

public class MusicBandBuilder implements Builder {
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

    private java.util.Date establishmentDate;

    @NotNull
    private MusicGenre genre;

    @NotNull
    private Studio studio;

    @Override
    public MusicBand build() {
        return new MusicBand(id, name, coordinates, creationDate, numberOfParticipants, singlesCount, establishmentDate, genre, studio);
    }
}
