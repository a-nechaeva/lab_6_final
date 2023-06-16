package itmo.lab6.basic.types.builders;

public class BuilderFactory {
    public static Builder getBuilder(String className) {
        return switch (className.toLowerCase()) {
            case "coordinates" -> new CoordinatesBuilder();
            case "date" -> new DateBuilder();
            case "studio" -> new StudioBuilder();
           // case "location" -> new LocationBuilder();
            case "music_band" -> new MusicBandBuilder();
            default -> null;
        };
    }
}
