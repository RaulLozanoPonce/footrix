package rlp.footrix.protrix.box;

import rlp.footrix.framework.types.entities.Match;
import rlp.footrix.framework.types.entities.player.Player;
import rlp.footrix.framework.types.records.PlayerMatchRecord;
import rlp.footrix.framework.types.records.TeamMatchRecord;
import rlp.footrix.protrix.ProtrixAppConfiguration;
import rlp.footrix.protrix.ProtrixApplication;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

import static rlp.footrix.framework.types.entities.Match.MatchEvent.Type.*;

public class ProtrixBox extends AbstractBox {

	private ProtrixApplication application;
    private Map<String, Double> initialCaches;

    public ProtrixBox(String[] args) {
		this(new ProtrixConfiguration(args));
	}

	public ProtrixBox(ProtrixConfiguration configuration) {
		super(configuration);
	}

	@Override
	public io.intino.alexandria.core.Box put(Object o) {
		super.put(o);
		return this;
	}

	public void beforeStart() {
		ProtrixAppConfiguration config = new ProtrixAppConfiguration();
		application = new ProtrixApplication(config);
		application.start();
	}

	public void afterStart() {
        this.initialCaches = application.entityStore().players().stream().collect(Collectors.toMap(p -> p.definition().id(), p -> p.cache().absoluteCache()));
		application.setDate(Instant.parse("2025-08-01T00:00:00Z"));

        double homeWinPct = application.entityStore().matches("ESP-1", 0).stream().filter(m -> m.definition().local().equals(m.winner())).count() / (double) (38 * 10);
        double drawPct = application.entityStore().matches("ESP-1", 0).stream().filter(m -> m.winner() == null).count() / (double) (38 * 10);
        double minScore = application.recordStore().playerMatchRecords().stream().filter(r -> r.score() != null).mapToDouble(PlayerMatchRecord::score).min().orElse(0.0);
        double meanScore = application.recordStore().playerMatchRecords().stream().filter(r -> r.score() != null).mapToDouble(PlayerMatchRecord::score).average().orElse(0.0);
        double maxScore = application.recordStore().playerMatchRecords().stream().filter(r -> r.score() != null).mapToDouble(PlayerMatchRecord::score).max().orElse(0.0);

        double maxCacheDiff = application.entityStore().players().stream().mapToDouble(p -> p.cache().absoluteCache() - initialCaches.get(p.definition().id())).max().orElse(0.0);
        String playerMaxCache = application.entityStore().players().stream().reduce(new BinaryOperator<Player>() {
            @Override
            public Player apply(Player p1, Player p2) {
                if (p1.cache().absoluteCache() - initialCaches.get(p1.definition().id()) > p2.cache().absoluteCache() - initialCaches.get(p2.definition().id())) {
                    return p1;
                }
                return p2;
            }
        }).get().definition().id();

        String bestPlayer = application.entityStore().players().stream().reduce(new BinaryOperator<Player>() {
            @Override
            public Player apply(Player p1, Player p2) {
                if (p1.team() == null) return p2;
                if (p2.team() == null) return p1;
                int p1Minutes = application.recordStore().playerMatchRecords(p1.definition().id(), p1.team().definition().id(), "ESP-1", 0).stream().mapToInt(PlayerMatchRecord::playedMinutes).sum();
                int p2Minutes = application.recordStore().playerMatchRecords(p2.definition().id(), p2.team().definition().id(), "ESP-1", 0).stream().mapToInt(PlayerMatchRecord::playedMinutes).sum();
                if (p1Minutes * 0.7 > p2Minutes) return p1;
                if (p2Minutes * 0.7 > p1Minutes) return p2;
                double p1Score = application.recordStore().playerMatchRecords(p1.definition().id(), p1.team().definition().id(), "ESP-1", 0).stream().filter(r -> r.score() != null && r.score() > 0.0).mapToDouble(PlayerMatchRecord::score).average().getAsDouble();
                double p2Score = application.recordStore().playerMatchRecords(p2.definition().id(), p2.team().definition().id(), "ESP-1", 0).stream().filter(r -> r.score() != null && r.score() > 0.0).mapToDouble(PlayerMatchRecord::score).average().getAsDouble();
                if (p1Score > p2Score) return p1;
                return p2;
            }
        }).get().definition().name();

        Map<String, Double> averages = averages();
        System.out.println("homeWinPct: " + homeWinPct);
        System.out.println("drawPct: " + drawPct);
        System.out.println("minScore: " + minScore);
        System.out.println("meanScore: " + meanScore);
        System.out.println("maxScore: " + maxScore);
        System.out.println("maxCacheDiff: " + maxCacheDiff);    //0.2
        System.out.println("playerMaxCache: " + playerMaxCache);
        System.out.println("bestPlayer: " + bestPlayer);

        System.out.println("Goal: " + averages.get("Goal"));    //2.5 – 2.8
        System.out.println("Assist: " + averages.get("Assist"));    //1.8 – 2.2
        System.out.println("Substitution: " + averages.get("Substitution"));    // 7–8
        System.out.println("YellowCard: " + averages.get("YellowCard"));    //4 – 5
        System.out.println("RedCard: " + averages.get("RedCard"));  //0.10 – 0.15
        System.out.println("Injury: " + averages.get("Injury"));    //1.2 – 1.5
	}

    private Map<String, Double> averages() {
        Map<String, Double> averages = new HashMap<>();
        List<Match> matchList = application.entityStore().matches("ESP-1", 0);
        for (Match match : matchList) {
            averages.putIfAbsent(Goal.name(), 0.0);
            averages.putIfAbsent("Assist", 0.0);
            averages.putIfAbsent(Substitution.name(), 0.0);
            averages.putIfAbsent(YellowCard.name(), 0.0);
            averages.putIfAbsent(RedCard.name(), 0.0);
            averages.putIfAbsent(Injury.name(), 0.0);

            averages.put(Goal.name(), averages.get(Goal.name()) + match.events().stream().filter(e -> e.type() == Goal).count() / (double) matchList.size());
            averages.put("Assist", averages.get("Assist") + match.events().stream().filter(e -> e.type() == Goal).filter(e -> e.secondaryWho() != null).count() / (double) matchList.size());
            averages.put(Substitution.name(), averages.get(Substitution.name()) + match.events().stream().filter(e -> e.type() == Substitution).count() / (double) matchList.size());
            averages.put(YellowCard.name(), averages.get(YellowCard.name()) + match.events().stream().filter(e -> e.type() == YellowCard).count() / (double) matchList.size());
            averages.put(RedCard.name(), averages.get(RedCard.name()) + match.events().stream().filter(e -> e.type() == RedCard).count() / (double) matchList.size());
            averages.put(Injury.name(), averages.get(Injury.name()) + match.events().stream().filter(e -> e.type() == Injury).count() / (double) matchList.size());
        }
        return averages;
    }

    public void beforeStop() {

	}

	public void afterStop() {

	}

	protected io.intino.alexandria.ui.services.AuthService authService(java.net.URL authServiceUrl) {
		//TODO add your authService
		return null;
	}

	public ProtrixApplication application() {
		return application;
	}

    public Map<String, Double> initialCaches() {
        return initialCaches;
    }
}