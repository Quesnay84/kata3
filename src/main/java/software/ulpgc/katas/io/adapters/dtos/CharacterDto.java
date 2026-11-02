package software.ulpgc.katas.io.adapters.dtos;

import java.util.List;

public record CharacterDto(String name, String status, String species, List<String> episode) {
}
