package software.ulpgc.katas.io.ports;

import com.google.gson.JsonElement;
import software.ulpgc.katas.model.ParseResult;

import java.io.IOException;

public interface CastDeserializer {
    ParseResult deserialize(String text);
}
