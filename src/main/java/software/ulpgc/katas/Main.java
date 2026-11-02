package software.ulpgc.katas;

import software.ulpgc.katas.io.CastLoadException;
import software.ulpgc.katas.io.adapters.GsonReportSerializer;
import software.ulpgc.katas.io.adapters.JsonCastDeserializer;
import software.ulpgc.katas.io.adapters.OutputStreamReportWriter;
import software.ulpgc.katas.io.adapters.StreamTextReader;
import software.ulpgc.katas.io.ports.CastDeserializer;
import software.ulpgc.katas.io.ports.ReportWriter;
import software.ulpgc.katas.io.ports.TextReader;
import software.ulpgc.katas.model.CastReport;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URI;

public class Main {
    public static void main(String[] args) {
        try {
            TextReader reader = new StreamTextReader(URI.create("https://rickandmortyapi.com/api/character").toURL().openStream());
            CastDeserializer deserializer = new JsonCastDeserializer();
            ReportWriter writer = new OutputStreamReportWriter(System.out, new GsonReportSerializer());
            writer.write(CastReport.of(deserializer.deserialize(reader.read())));
        } catch (CastLoadException | IOException | UncheckedIOException e) {
            System.err.println(e.getMessage());
        }
    }
}
