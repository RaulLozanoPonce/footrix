package rlp.footrix.framework.types.definitions;

import rlp.footrix.framework.types.Country;

import java.time.Instant;
import java.util.List;

public interface CompetitionDefinition {

    String id();
    String name();
    Country country();
    List<PhaseDefinition> phases();

    interface PhaseDefinition {
        GroupDefinition groupDefinition();
        int nGroups();
        LocalPolicy localPolicy();
        boolean secondLeg();
        String matchDayName(int number);
        Instant nextDate(int matchDay, Instant date);

        interface GroupDefinition {
            String name(int number);
            int nTeams();
            SortPolicy sortPolicy();
            List<TeamClassification> classification(List<TeamClassification> classification);

            enum SortPolicy {
                Ordered, Unordered, Mirrored
            }

            public record TeamClassification(String teamId, String teamName, int points, int goalsFor, int goalsAgainst) {}
        }

        enum LocalPolicy {
            Underdog, Favorite, Neutral, Keep
        }
    }
}
