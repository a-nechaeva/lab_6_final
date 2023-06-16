package itmo.lab6.basic.types.builders;

import itmo.lab6.basic.baseclasses.Studio;
import itmo.lab6.basic.types.builders.annotations.NotNull;

public class StudioBuilder implements Builder {
    @NotNull
    private String name;

    @Override
    public Studio build() {
        return new Studio(name);
    }
}
