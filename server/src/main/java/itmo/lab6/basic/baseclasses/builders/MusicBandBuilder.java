package itmo.lab6.basic.baseclasses.builders;

import itmo.lab6.basic.baseclasses.Coordinates;
import itmo.lab6.basic.baseclasses.MusicBand;
import itmo.lab6.basic.baseclasses.Studio;
import itmo.lab6.basic.baseclasses.builders.annotations.Generated;
import itmo.lab6.basic.baseclasses.builders.annotations.NotEmpty;
import itmo.lab6.basic.baseclasses.builders.annotations.NotNull;
import itmo.lab6.basic.baseclasses.builders.annotations.Value;
import itmo.lab6.basic.baseenums.MusicGenre;

public class MusicBandBuilder implements Builder {
    @NotNull
    @Value(min = 0)
    private Long id;
    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    private Coordinates coordinates;
    @NotNull
    @Generated
    private java.time.ZonedDateTime creationDate;

    @Value(min = 0)
    private int numberOfParticipants;

    @Value(min = 0)
    private Integer singlesCount;

    private java.time.LocalDate establishmentDate;

    @NotNull
    private MusicGenre genre;

    @NotNull
    private Studio studio;

    @Override
    public MusicBand build() {
        return new MusicBand(id, name, coordinates, creationDate, numberOfParticipants, singlesCount, establishmentDate, genre, studio);
    }
}
