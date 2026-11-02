package software.ulpgc.katas.model;

import java.util.Map;
import java.util.stream.Collectors;

public record MetaData(int records, int discarded, Map<String, Integer> membersPerSpecies) {
    public static MetaData of(ParseResult parseResult) {
        return new MetaData(parseResult.castMembers().size(), parseResult.discarded(), membersPerSpeciesOf(parseResult));
    }

    private static Map<String, Integer> membersPerSpeciesOf(ParseResult parseResult) {
        return parseResult.castMembers().stream()
                .collect(Collectors.toMap(CastMember::species, castMemeber
                -> 1, Integer::sum));
    }
}
