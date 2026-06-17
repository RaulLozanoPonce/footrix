package rlp.footrix.framework.events.types;

import rlp.footrix.framework.events.Event;
import rlp.footrix.framework.types.entities.SeasonReference;

import java.util.ArrayList;
import java.util.List;

public class InitPhaseEvent extends Event {
    private String competitionId;
    private SeasonReference season;
    private int nPhase;
    private List<String> rulesIds = new ArrayList<>();
    private List<String> teamIds = new ArrayList<>();

    public String competitionId() {
        return competitionId;
    }

    public InitPhaseEvent competitionId(String competitionId) {
        this.competitionId = competitionId;
        return this;
    }

    public SeasonReference season() {
        return season;
    }

    public InitPhaseEvent season(SeasonReference season) {
        this.season = season;
        return this;
    }

    public int nPhase() {
        return nPhase;
    }

    public InitPhaseEvent nPhase(int nPhase) {
        this.nPhase = nPhase;
        return this;
    }

    public List<String> rulesIds() {
        return rulesIds;
    }

    public InitPhaseEvent rulesIds(List<String> rulesIds) {
        this.rulesIds = rulesIds;
        return this;
    }

    public List<String> teamIds() {
        return teamIds;
    }

    public InitPhaseEvent teamIds(List<String> teamIds) {
        this.teamIds = teamIds;
        return this;
    }
}
