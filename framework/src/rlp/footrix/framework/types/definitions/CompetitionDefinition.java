package rlp.footrix.framework.types.definitions;

import rlp.footrix.framework.types.Country;

import java.time.Instant;
import java.util.List;

public interface CompetitionDefinition {

    String id();
    String name();
    Country country();
    List<PhaseDefinition> phases();
    int redCardSanction();
    int doubleYellowCardSanction();
    int accumulatedYellowCardSanction();
    int accumulatedYellowCardNumber();
    int substitutesNumber();
    int substitutionsNumber();

    interface PhaseDefinition {
        String name();
        GroupDefinition groupDefinition();
        int nGroups();
        String matchDayName(int number);
        LocalPolicy localPolicy();
        SecondLegPolicy secondLegPolicy();
        List<String> classify(List<TeamClassification> classification);
        Instant nextDate(int matchDay, Instant date);

        interface GroupDefinition {
            String name(int number);
            int nTeams();
        }

        enum LocalPolicy {
            Underdog, Favorite, Neutral, Keep
        }

        enum SecondLegPolicy {
            OnlyOneLeg, Ordered, Unordered
        }

        record TeamClassification(String teamId, int points, int goalsFor, int goalsAgainst) {}
    }
}
