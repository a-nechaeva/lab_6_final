package itmo.lab6.basic.types.builders;

//import itmo.lab6.basic.baseclasses.Location;
import itmo.lab6.basic.baseclasses.Person;
import itmo.lab6.basic.baseenums.Color;
import itmo.lab6.basic.types.builders.annotations.NotNull;
import itmo.lab6.basic.types.builders.annotations.Value;

import java.util.Date;

public class DirectorBuilder implements Builder {
    @NotNull
    private String name;

    @Override
    public Person build() {
        return new Person(name);
    }
}
