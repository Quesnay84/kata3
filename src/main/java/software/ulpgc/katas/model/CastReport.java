package software.ulpgc.katas.model;

import java.util.List;

public record CastReport(MetaData metaData, List<CastMember> castMembers) {
    public static CastReport of(ParseResult result){
        return new CastReport(MetaData.of(result), result.castMembers());
    }
}
