package rlp.footrix.framework.types;

import rlp.footrix.framework.types.definitions.CompetitionDefinition;
import rlp.footrix.framework.types.definitions.CompetitionDefinition.PhaseDefinition.GroupDefinition;
import rlp.footrix.framework.types.team.Team;

import java.util.ArrayList;
import java.util.List;

public class Competition {

    private final CompetitionDefinition definition;
    private final List<Phase> phases;

    public Competition(CompetitionDefinition definition) {
        this.definition = definition;
        this.phases = definition.phases().stream().map(Phase::new).toList();
    }

    public CompetitionDefinition definition() {
        return definition;
    }

    public Phase phase(int nPhase) {
        return this.phases.get(nPhase);
    }

    public static class Phase {
        private final CompetitionDefinition.PhaseDefinition definition;
        private List<Group> groups;

        public Phase(CompetitionDefinition.PhaseDefinition definition) {
            this.definition = definition;
        }

        public void init(List<Team> teams) {
            //TODO AÑADIR POLÍTICA PARA AGRUPAR LOS EQUIPOS DE UNA FASE. ESTO DEBE ESTAR AQUÍ?
            this.groups = new ArrayList<>();
            int teamsByGroup = teams.size() / definition.nGroups();
            for (int i = 0; i < definition.nGroups(); i++) {
                this.groups.add(groupOf(definition.groupDefinition(), teams.subList(i * teamsByGroup, (i + 1) * teamsByGroup)));
            }
        }

        private Group groupOf(GroupDefinition groupDefinition, List<Team> teams) {
            return new Group(groupDefinition, teams);
        }

        public CompetitionDefinition.PhaseDefinition definition() {
            return definition;
        }

        public List<Group> groups() {
            return groups;
        }

        public Group group(int nGroup) {
            return this.groups.get(nGroup);
        }

        public record Group(GroupDefinition definition, List<Team> teams) {}
    }
}
