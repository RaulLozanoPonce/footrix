package rlp.footrix.protrix.box.ui.displays;

import io.intino.alexandria.ui.Soul;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class AbstractRouteDispatcher implements io.intino.alexandria.ui.displays.DisplayRouteDispatcher {
	private static java.util.Map<String, String> patterns = new HashMap<>();

	public AbstractRouteDispatcher() {
		registerPatterns();
	}

	@Override
	public void dispatch(Soul soul, String address) {
		address = address.replaceFirst(soul.session().browser().basePath(), "");
		List<String> params = paramsOf(address);
		address = addressWithoutQueryString(address);
		if (address.length() <= 1) { dispatchHome(soul); return; }
		if (address.matches(patterns.get("home"))) { dispatchHome(soul); return; }
		if (address.matches(patterns.get("competitions"))) { dispatchCompetitions(soul); return; }
		if (address.matches(patterns.get("competition"))) { dispatchCompetition(soul, params.get(0), params.get(1)); return; }
		if (address.matches(patterns.get("teams"))) { dispatchTeams(soul); return; }
		if (address.matches(patterns.get("team"))) { dispatchTeam(soul, params.get(0)); return; }
		if (address.matches(patterns.get("match"))) { dispatchMatch(soul, params.get(0)); return; }
		if (address.matches(patterns.get("trace"))) { dispatchTrace(soul); return; }
		if (address.matches(patterns.get("playerTrace"))) { dispatchPlayerTrace(soul, params.get(0)); return; }
		if (address.matches(patterns.get("playerMatchTrace"))) { dispatchPlayerMatchTrace(soul, params.get(0)); return; }
	}

	public abstract void dispatchHome(Soul soul);
	public abstract void dispatchCompetitions(Soul soul);
	public abstract void dispatchCompetition(Soul soul, String competitionId, String season);
	public abstract void dispatchTeams(Soul soul);
	public abstract void dispatchTeam(Soul soul, String teamId);
	public abstract void dispatchMatch(Soul soul, String matchId);
	public abstract void dispatchTrace(Soul soul);
	public abstract void dispatchPlayerTrace(Soul soul, String playerId);
	public abstract void dispatchPlayerMatchTrace(Soul soul, String playerId);

	private void registerPatterns() {
		if (patterns.size() > 0) return;
		patterns.put("home", "");
		patterns.put("competitions", "\\/competitions");
		patterns.put("competition", "\\/competitions\\/([^\\/]*)\\/([^\\/]*)");
		patterns.put("teams", "\\/teams");
		patterns.put("team", "\\/teams\\/([^\\/]*)");
		patterns.put("match", "\\/matches\\/([^\\/]*)");
		patterns.put("trace", "\\/trace");
		patterns.put("playerTrace", "\\/player-trace\\/([^\\/]*)");
		patterns.put("playerMatchTrace", "\\/minute-player-trace\\/([^\\/]*)");
	}

	private String patternOf(String address) {
		String addressPart = addressWithoutQueryString(address);
		if (addressPart.matches(patterns.get("home"))) return patterns.get("home");
		else if (addressPart.matches(patterns.get("home"))) return patterns.get("home");
		else if (addressPart.matches(patterns.get("competitions"))) return patterns.get("competitions");
		else if (addressPart.matches(patterns.get("competition"))) return patterns.get("competition");
		else if (addressPart.matches(patterns.get("teams"))) return patterns.get("teams");
		else if (addressPart.matches(patterns.get("team"))) return patterns.get("team");
		else if (addressPart.matches(patterns.get("match"))) return patterns.get("match");
		else if (addressPart.matches(patterns.get("trace"))) return patterns.get("trace");
		else if (addressPart.matches(patterns.get("playerTrace"))) return patterns.get("playerTrace");
		else if (addressPart.matches(patterns.get("playerMatchTrace"))) return patterns.get("playerMatchTrace");
		return null;
	}

	private List<String> paramsOf(String address) {
		return paramsOf(address, patternOf(address));
	}

	private List<String> paramsOf(String address, String pattern) {
		if (pattern == null) return java.util.Collections.emptyList();
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(address);
		if (!m.find()) return Collections.emptyList();
		List<String> result = new ArrayList<>();
		for (int i=1; i<=m.groupCount(); i++) result.add(m.group(i).split("\\?")[0]);
		return addQueryStringParams(address, result);
	}

	private List<String> addQueryStringParams(String address, List<String> result) {
        if (address.indexOf("?") == -1) return result;
        String[] parameters = address.split("\\?")[1].split("&");
        for (int i = 0; i < parameters.length; i++) {
            String[] split = parameters[i].split("=");
            result.add(split.length > 1 ? split[1] : "");
        }
        return result;
	}

    private String addressWithoutQueryString(String address) {
        return address.indexOf("?") != -1 ? address.substring(0, address.indexOf("?")) : address;
    }

}