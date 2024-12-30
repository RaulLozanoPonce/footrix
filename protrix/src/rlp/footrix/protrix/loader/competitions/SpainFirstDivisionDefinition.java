package rlp.footrix.protrix.loader.competitions;

import rlp.footrix.framework.types.Country;
import rlp.footrix.framework.types.definitions.CompetitionDefinition;

import java.time.Instant;
import java.util.List;

public class SpainFirstDivisionDefinition implements CompetitionDefinition {

    @Override
    public String id() {
        return "ESP-1";
    }

    @Override
    public String name() {
        return "Primera división española";
    }

    @Override
    public Country country() {
        return Country.Spain;
    }

    @Override
    public List<PhaseDefinition> phases() {
        return List.of(
                new PhaseDefinition() {

                    @Override
                    public String name() {
                        return "Liga Regular";
                    }

                    @Override
                    public GroupDefinition groupDefinition() {
                        return new GroupDefinition() {
                            @Override
                            public String name(int i) {
                                return null;
                            }

                            @Override
                            public int nTeams() {
                                return 20;
                            }
                        };
                    }

                    @Override
                    public int nGroups() {
                        return 1;
                    }

                    @Override
                    public LocalPolicy localPolicy() {
                        return LocalPolicy.Keep;
                    }

                    @Override
                    public boolean withExtension() {
                        return false;
                    }

                    @Override
                    public boolean withPenalties() {
                        return false;
                    }

                    @Override
                    public boolean hasSecondLeg() {
                        return true;
                    }

                    @Override
                    public int substitutesNumber() {
                        return 12;
                    }

                    @Override
                    public int substitutionsNumber() {
                        return 5;
                    }

                    @Override
                    public int rankingScore() {
                        return 15;
                    }

                    @Override
                    public List<TeamClassification> classify(List<TeamClassification> teams) {
                        return teams.stream().sorted((o1, o2) -> {
                            if (o1.points() > o2.points()) return -1;
                            else if (o1.points() == o2.points()) return 0;
                            return 1;
                        }).toList();
                    }

                    @Override
                    public String matchDayName(int i) {
                        return "Jornada " + i;
                    }

                    @Override
                    public Instant nextDate(int i, Instant instant) {
                        return Instant.ofEpochMilli(instant.toEpochMilli() + 1000 * 60 * 60 * 24 * 7);    //TODO
                    }
                }
        );
    }

    @Override
    public int redCardSanction() {
        return 3;
    }

    @Override
    public int doubleYellowCardSanction() {
        return 1;
    }

    @Override
    public int accumulatedYellowCardSanction() {
        return 1;
    }

    @Override
    public int accumulatedYellowCardNumber() {
        return 5;
    }
}
