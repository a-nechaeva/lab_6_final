package itmo.lab6.basic.types.builders;

import itmo.lab6.basic.baseclasses.Coordinates;
import itmo.lab6.basic.types.builders.annotations.NotNull;
import itmo.lab6.basic.types.builders.annotations.Value;

public class CoordinatesBuilder implements Builder {

    @Value(min = -98)
    private float x;
    @Value(min = -480)
    @NotNull
    private Double y;

    @Override
    public Coordinates build() {
        return new Coordinates(x, y);
    }
}
