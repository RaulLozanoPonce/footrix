package rlp.footrix.framework.managers;

import rlp.footrix.framework.configuration.TeamRule;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RulesManager {
    private final Map<String, TeamRule> rules = new HashMap<>();

    public List<TeamRule> get(List<String> ruleIds) {
        return rules.entrySet().stream().filter(e -> ruleIds.contains(e.getKey())).map(Map.Entry::getValue).toList();
    }

    public void add(String id, TeamRule rule) {
        rules.put(id, rule);
    }
}
