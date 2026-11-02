package software.ulpgc.katas.io.adapters;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import software.ulpgc.katas.io.CastLoadException;
import software.ulpgc.katas.io.adapters.dtos.CharacterDto;
import software.ulpgc.katas.io.adapters.dtos.PageDto;
import software.ulpgc.katas.io.ports.CastDeserializer;
import software.ulpgc.katas.model.CastMember;
import software.ulpgc.katas.model.ParseResult;
import software.ulpgc.katas.model.Status;

import java.util.Arrays;
import java.util.List;

public record JsonCastDeserializer() implements CastDeserializer {
    @Override
    public ParseResult deserialize(String json) {
        return resultOf(charactersOf(pageOf(json)));
    }

    private ParseResult resultOf(List<CharacterDto> characterDtos) {
        return resultOf(characterDtos.stream().filter(this::isValid).map(this::memberOf).toList(), characterDtos.size());
    }

    private CastMember memberOf(CharacterDto characterDto) {
        return new CastMember(characterDto.name(), statusOf(characterDto.status()), characterDto.species(), 
                characterDto.episode().size());
    }

    private Status statusOf(String status) {
        return Status.valueOf(status.toUpperCase());
    }

    private boolean isValid(CharacterDto character) {
        return character != null && hasText(character.name())
                && hasText(character.species())
                && character.episode() != null
                && isKnownStatus(character.status());
    }

    private boolean isKnownStatus(String status) {
        return Arrays.stream(Status.values()).anyMatch(s -> s.name().equalsIgnoreCase(status));
    }

    private boolean hasText(String value) {
        return value != null && !value.isBlank();
    }

    private ParseResult resultOf(List<CastMember> members, int total) {
        return new ParseResult(members, total -  members.size());
    }

    private PageDto pageOf(String json) {
        try{
            return new Gson().fromJson(json, PageDto.class);
        } catch (JsonParseException e){
            throw new CastLoadException("Cannot parse json: " + e.getMessage(), e);
        }
    }

    private List<CharacterDto> charactersOf(PageDto page) {
        if(page == null || page.results() == null) throw new CastLoadException("Page is null or results is null");
        return page.results();

    }

}
