package rlp.footrix.protrix;

import rlp.footrix.framework.events.Subscriber;
import rlp.footrix.framework.events.types.NewDayEvent;
import rlp.footrix.framework.types.entities.Match;
import rlp.footrix.framework.types.entities.player.Player;
import rlp.footrix.protrix.box.ProtrixBox;

import java.time.Instant;
import java.util.Objects;

public class PlayerDayRegisterSubscriber implements Subscriber<NewDayEvent> {
    private final ProtrixApplication application;
    private final ProtrixBox box;

    public PlayerDayRegisterSubscriber(ProtrixApplication application, ProtrixBox box) {
        this.application = application;
        this.box = box;
    }

    @Override
    public void receive(NewDayEvent newDayEvent) {
        //TODO ACTIVAR
        /*for (Player player : application.entityStore().players()) {
            register(newDayEvent.date(), player);
        }*/
    }

    private void register(Instant ts, Player player) {
        String playerId = player.definition().id();
        String teamId = player.team() == null ? "" : player.team().definition().id();
        double energy = player.psychophysics().energy();
        double physical = player.psychophysics().physicalCondition();
        double selfConfidence = player.psychophysics().selfConfidence();
        double contractSatisfaction = !teamId.isEmpty() ? player.psychophysics().contractSatisfaction() : 0;
        double gameTimeSatisfaction = player.psychophysics().gameTimeSatisfaction();
        double collectivePerformance = player.psychophysics().collectivePerformance();
        int minutes = application.entityStore().matches("ESP-1", 0).stream()
                .map(m -> m.playerStatistics().get(teamId))
                .filter(Objects::nonNull)
                .map(m -> m.get(playerId))
                .filter(Objects::nonNull)
                .mapToInt(Match.PlayerStatistics::minutes)
                .sum();
        double stamina = player.skills().stamina();
        boolean injured = player.isInjured();
        box.graph().create().playerDayRecord(ts, playerId, teamId, energy, physical, selfConfidence, contractSatisfaction, gameTimeSatisfaction, collectivePerformance, minutes, stamina, injured);
    }
}
