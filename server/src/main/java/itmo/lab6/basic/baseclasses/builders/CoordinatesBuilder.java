package itmo.lab6.basic.baseclasses.builders;

import itmo.lab6.basic.baseclasses.Coordinates;
import itmo.lab6.basic.baseclasses.builders.annotations.NotNull;
import itmo.lab6.basic.baseclasses.builders.annotations.Value;

public class CoordinatesBuilder implements Builder {

    @Value(min = -98)
    private Float x;
    @Value(min = -480)
    @NotNull
    private Double y;

    @Override
    public Coordinates build() {
        return new Coordinates(x, y);
    }
}
