package rlp.footrix.framework.ai;

import rlp.footrix.framework.types.entities.Training;
import rlp.footrix.framework.types.entities.team.Team;

import java.time.Instant;

public interface Trainer {
    Training train(Instant date, Team team, int duration);
}
