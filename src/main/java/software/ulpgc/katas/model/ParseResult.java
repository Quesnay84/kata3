package software.ulpgc.katas.model;

import java.lang.reflect.Member;
import java.util.List;

public record ParseResult(List<CastMember> castMembers, int discarded) {
}
