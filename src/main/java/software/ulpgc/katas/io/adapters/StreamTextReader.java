package software.ulpgc.katas.io.adapters;

import software.ulpgc.katas.io.CastLoadException;
import software.ulpgc.katas.io.ports.CastDeserializer;
import software.ulpgc.katas.io.ports.TextReader;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public record StreamTextReader(InputStream stream) implements TextReader {
    @Override
    public String read() {
        try(stream){
            return new String(stream.readAllBytes(), StandardCharsets.UTF_8);
        } catch (IOException e){
            throw new CastLoadException("Cannot read input: " + e.getMessage(), e);
        }
    }
}
