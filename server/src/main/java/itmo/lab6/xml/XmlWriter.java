package itmo.lab6.xml;


import itmo.lab6.basic.baseclasses.MusicBand;
import itmo.lab6.basic.baseclasses.builders.annotations.Generated;
import itmo.lab6.basic.moviecollection.MovieCollection;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static itmo.lab6.utils.string.StringUtils.toSnakeCase;

/**
 * Xml writer class. Used for writing to xml file
 *
 */
public class XmlWriter extends XmlAction {
    private final BufferedOutputStream bufferedOutput;
    private int indentLevel = 0;

    protected XmlWriter(Xml xml) {
        super(xml);
        try {
            this.bufferedOutput = new BufferedOutputStream(new FileOutputStream(xml.getXmlFile()));
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found");
        }
    }

    /**
     * Write string to file with new line ('\n')
     *
     * @param line String to write
     */
    protected void writeLine(String line) throws RuntimeException {
        try {
            bufferedOutput.write(line.getBytes());
            bufferedOutput.write("\n".getBytes());
            bufferedOutput.flush();

        } catch (IOException e) {
            System.out.println("Error while writing to file: " + e.getMessage());
        }
    }

    /**
     * Write collection to file in xml format
     *
     * @param collection Collection to write
     */
    public void writeCollection(MovieCollection collection) {
        writeLine(indentString() + "<" + collection.getClass().getSimpleName() + ">");
        indentLevel++;
        for (MusicBand musicBand : collection.values()) {
            writeObject(musicBand);
        }
        indentLevel--;
        writeLine(indentString() + "</" + collection.getClass().getSimpleName() + ">");
    }

    /**
     * Write object to file in xml format
     *
     * @param object Object to write
     */
    private void writeObject(Object object) throws RuntimeException {
        if (!object.getClass().getSimpleName().equalsIgnoreCase("studio"))
            writeLine(indentString() + "<" + object.getClass().getSimpleName() + ">");
        else writeLine(indentString() + "<Studio>");
        indentLevel++;
        Arrays.stream(object.getClass().getDeclaredFields()).filter(a -> !a.isAnnotationPresent(Generated.class)).forEach(field -> {
            field.setAccessible(true);
            try {
                if (List.of("location", "coordinates", "music_band", "studio").contains(field.getType().getSimpleName().toLowerCase())) {
                    writeObject(field.get(object));
                } else if (field.getType().getSimpleName().equals("Date")) {
                    Date date = (Date) field.get(object);
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
                    String dateString = dateFormat.format(date);
                    writeLine(indentString() + "<" + toSnakeCase(field.getName()) + ">" + dateString + "</" + toSnakeCase(field.getName()) + ">");
                } else
                    writeLine(indentString() + "<" + toSnakeCase(field.getName()) + ">" + field.get(object) + "</" + toSnakeCase(field.getName()) + ">");
            } catch (IllegalAccessException e) {
                System.out.println("Error while writing to file: " + e.getMessage());
            }
        });
        --indentLevel;
        if (!object.getClass().getSimpleName().equalsIgnoreCase("studio"))
            writeLine(indentString() + "</" + object.getClass().getSimpleName() + ">");
        else writeLine(indentString() + "</Studio>");
    }

    /**
     * Generate indent string
     *
     * @return Indent string
     */
    private String indentString() {
        return new String(new char[indentLevel * 4]).replace("\0", " ");
    }
}


