package itmo.lab6.basic.baseclasses.builders;

import itmo.lab6.basic.baseclasses.Studio;
import itmo.lab6.basic.baseclasses.builders.annotations.NotEmpty;
import itmo.lab6.basic.baseclasses.builders.annotations.NotNull;

public class StudioBuilder implements Builder {
    @NotNull
    @NotEmpty
    private String name;

    @Override
    public Studio build() {

        return new Studio(name);

    }
}
