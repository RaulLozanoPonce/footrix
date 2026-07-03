package rlp.footrix.protrix.box.ui;
import rlp.footrix.protrix.box.ui.displays.*;
import rlp.footrix.protrix.box.ui.resources.*;
import rlp.footrix.protrix.box.ProtrixBox;
import rlp.footrix.protrix.box.ProtrixConfiguration;

import io.intino.alexandria.ui.UISpark;
import io.intino.alexandria.ui.displays.notifiers.DisplayNotifier;
import io.intino.alexandria.ui.displays.notifiers.DisplayNotifierProvider;
import io.intino.alexandria.ui.displays.DisplayRouteDispatcher;
import io.intino.alexandria.ui.resources.AssetResourceLoader;
import io.intino.alexandria.ui.services.push.PushService;
import io.intino.alexandria.ui.spark.resources.AfterDisplayRequest;
import io.intino.alexandria.ui.spark.resources.AssetResource;
import io.intino.alexandria.ui.spark.resources.AuthenticateCallbackResource;
import io.intino.alexandria.ui.spark.resources.BeforeDisplayRequest;

import java.net.MalformedURLException;
import java.net.URL;

public class ProtrixUiService extends io.intino.alexandria.ui.UI {

	public static void init(UISpark spark, ProtrixBox box, PushService pushService, DisplayRouteDispatcher routeDispatcher) {
		ProtrixConfiguration configuration = (ProtrixConfiguration) box.configuration();
		box.routeManager(routeManager(spark, routeDispatcher));
		spark.route("/_alexandria/push").push(pushService);
		spark.route("/authenticate-callback").get(manager -> new AuthenticateCallbackResource(manager, notifierProvider()).execute());
		spark.route("/authenticate-callback/").get(manager -> new AuthenticateCallbackResource(manager, notifierProvider()).execute());
		spark.route("/asset/:name").get(manager -> new AssetResource(name -> new AssetResourceLoader(box).load(name), manager, notifierProvider()).execute());
		spark.route("/").get(manager -> new HomeResource(box, manager, notifierProvider()).execute());
		spark.route("/competitions").get(manager -> new CompetitionsResource(box, manager, notifierProvider()).execute());
		spark.route("/competitions/:competitionId/:season").get(manager -> new CompetitionResource(box, manager, notifierProvider()).execute());
		spark.route("/teams").get(manager -> new TeamsResource(box, manager, notifierProvider()).execute());
		spark.route("/teams/:teamId").get(manager -> new TeamResource(box, manager, notifierProvider()).execute());
		spark.route("/matches/:matchId").get(manager -> new MatchResource(box, manager, notifierProvider()).execute());
		spark.route("/trace").get(manager -> new TraceResource(box, manager, notifierProvider()).execute());
		spark.route("/player-trace/:playerId").get(manager -> new PlayerTraceResource(box, manager, notifierProvider()).execute());
		spark.route("/minute-player-trace/:playerId").get(manager -> new PlayerMatchTraceResource(box, manager, notifierProvider()).execute());
		initDisplays(spark, pushService);
	}

	public static void initDisplays(UISpark spark, PushService pushService) {
		initTraceTemplate(spark, pushService);
		initFullClassificationTemplate(spark, pushService);
		initCompetitionGoalRankingTemplate(spark, pushService);
		initCompetitionAssistRankingTemplate(spark, pushService);
		initCompetitionReceivedGoalRankingTemplate(spark, pushService);
		initCompetitionsTemplate(spark, pushService);
		initCompetitionTemplate(spark, pushService);
		initCompetitionRankingsTemplate(spark, pushService);
		initMatchTemplate(spark, pushService);
		initMatchInfoTemplate(spark, pushService);
		initMatchPlayersTemplate(spark, pushService);
		initMatchLineupPinTemplate(spark, pushService);
		initMatchCompetitionTemplate(spark, pushService);
		initMatchesTemplate(spark, pushService);
		initOverviewTemplate(spark, pushService);
		initPlayerMatchTraceTemplate(spark, pushService);
		initPlayerTraceTemplate(spark, pushService);
		initTeamsTemplate(spark, pushService);
		initTeamTemplate(spark, pushService);
		initSquadTeamTemplate(spark, pushService);
		initOutTeamTemplate(spark, pushService);
		initAppTemplate(spark, pushService);
		initHeaderTemplate(spark, pushService);
		initIdMold(spark, pushService);
		initNameMold(spark, pushService);
		initTeamMold(spark, pushService);
		initAgeMold(spark, pushService);
		initRoleMold(spark, pushService);
		initOverallMold(spark, pushService);
		initPositionMold(spark, pushService);
		initHappinessContractMold(spark, pushService);
		initHappinessGameTimeMold(spark, pushService);
		initHappinessIndividualMold(spark, pushService);
		initHappinessCollectiveMold(spark, pushService);
		initMinutesMold(spark, pushService);
		initScoreMold(spark, pushService);
		initCacheIniMold(spark, pushService);
		initCacheMold(spark, pushService);
		initFullClassificationPositionMold(spark, pushService);
		initFullClassificationTeamMold(spark, pushService);
		initFullClassificationPlayedMatchesMold(spark, pushService);
		initFullClassificationWinMatchesMold(spark, pushService);
		initFullClassificationDrawMatchesMold(spark, pushService);
		initFullClassificationLostMatchesMold(spark, pushService);
		initFullClassificationGoalsForMold(spark, pushService);
		initFullClassificationGoalsAgainstMold(spark, pushService);
		initFullClassificationGoalsDifferenceMold(spark, pushService);
		initFullClassificationPointsMold(spark, pushService);
		initTopScorersPositionMold(spark, pushService);
		initTopScorersPlayerMold(spark, pushService);
		initTopScorersGoalsMold(spark, pushService);
		initTopScorersPlayedMatchesMold(spark, pushService);
		initTopAssistersPositionMold(spark, pushService);
		initTopAssistersPlayerMold(spark, pushService);
		initTopAssistersAssistsMold(spark, pushService);
		initTopAssistersPlayedMatchesMold(spark, pushService);
		initTopGoalkeepersPositionMold(spark, pushService);
		initTopGoalkeepersPlayerMold(spark, pushService);
		initTopGoalkeepersGoalsMold(spark, pushService);
		initTopGoalkeepersPlayedMinutesMold(spark, pushService);
		initCompetitionsTableMold(spark, pushService);
		initMatchEventsLocalPlayerMold(spark, pushService);
		initMatchEventsMinuteMold(spark, pushService);
		initMatchEventsVisitantPlayerMold(spark, pushService);
		initMatchPlayersNumberMold(spark, pushService);
		initMatchPlayersNameMold(spark, pushService);
		initMatchPlayersPositionMold(spark, pushService);
		initMatchPlayersEntersMold(spark, pushService);
		initMatchPlayersExitsMold(spark, pushService);
		initMatchPlayersGoalsMold(spark, pushService);
		initMatchPlayersAssistsMold(spark, pushService);
		initMatchPlayersYellowCardsMold(spark, pushService);
		initMatchPlayersRedCardsMold(spark, pushService);
		initMatchPlayersScoreMold(spark, pushService);
		initMatchTableMold(spark, pushService);
		initClassificationPositionMold(spark, pushService);
		initClassificationTeamMold(spark, pushService);
		initClassificationPlayedMatchesMold(spark, pushService);
		initClassificationWinMatchesMold(spark, pushService);
		initClassificationDrawMatchesMold(spark, pushService);
		initClassificationLostMatchesMold(spark, pushService);
		initClassificationGoalsDifferenceMold(spark, pushService);
		initClassificationPointsMold(spark, pushService);
		initMatchTraceMinuteMold(spark, pushService);
		initDateTraceMinuteMold(spark, pushService);
		initMinuteTraceMinuteMold(spark, pushService);
		initStaminaTraceMinuteMold(spark, pushService);
		initEnergyTraceMinuteMold(spark, pushService);
		initDateTraceMold(spark, pushService);
		initEnergyTraceMold(spark, pushService);
		initPhysicalConditionTraceMold(spark, pushService);
		initSelfConfidenceTraceMold(spark, pushService);
		initContractSatisfactionTraceMold(spark, pushService);
		initGameTimeSatisfactionTraceMold(spark, pushService);
		initCollectivePerformanceTraceMold(spark, pushService);
		initMinuteTraceMold(spark, pushService);
		initStaminaTraceMold(spark, pushService);
		initInjuredTraceMold(spark, pushService);
		initTeamsTableMold(spark, pushService);
		initSquadTeamNumberMold(spark, pushService);
		initSquadTeamPositionMold(spark, pushService);
		initSquadTeamNameMold(spark, pushService);
		initSquadTeamCountryMold(spark, pushService);
		initSquadTeamMatchesMold(spark, pushService);
		initSquadTeamMinutesMold(spark, pushService);
		initSquadTeamGoalsMold(spark, pushService);
		initSquadTeamAssistsMold(spark, pushService);
		initSquadTeamYellowCardsMold(spark, pushService);
		initSquadTeamRedCardsMold(spark, pushService);
		initOutTeamPositionMold(spark, pushService);
		initOutTeamNameMold(spark, pushService);
		initOutTeamFromMold(spark, pushService);
		initOutTeamToMold(spark, pushService);
		initOutTeamDescriptionMold(spark, pushService);
		initPlayersTableRow(spark, pushService);
		initFullClassificationTableRow(spark, pushService);
		initTopScorersTableRow(spark, pushService);
		initTopAssistersTableRow(spark, pushService);
		initTopGoalkeepersTableRow(spark, pushService);
		initMatchEventsTableRow(spark, pushService);
		initMatchPlayersTableRow(spark, pushService);
		initClassificationTableRow(spark, pushService);
		initMinuteTraceTableRow(spark, pushService);
		initTraceTableRow(spark, pushService);
		initSquadTeamTableRow(spark, pushService);
		initOutTeamTableRow(spark, pushService);
		registerNotifiers();
	}

	private static void registerNotifiers() {
		register(io.intino.alexandria.ui.displays.notifiers.TemplateNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.templates.TraceTemplate.class);
		register(io.intino.alexandria.ui.displays.notifiers.TemplateNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.templates.FullClassificationTemplate.class);
		register(io.intino.alexandria.ui.displays.notifiers.TemplateNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.templates.CompetitionGoalRankingTemplate.class);
		register(io.intino.alexandria.ui.displays.notifiers.TemplateNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.templates.CompetitionAssistRankingTemplate.class);
		register(io.intino.alexandria.ui.displays.notifiers.TemplateNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.templates.CompetitionReceivedGoalRankingTemplate.class);
		register(io.intino.alexandria.ui.displays.notifiers.TemplateNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.templates.CompetitionsTemplate.class);
		register(io.intino.alexandria.ui.displays.notifiers.TemplateNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.templates.CompetitionTemplate.class);
		register(io.intino.alexandria.ui.displays.notifiers.TemplateNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.templates.CompetitionRankingsTemplate.class);
		register(io.intino.alexandria.ui.displays.notifiers.TemplateNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.templates.MatchTemplate.class);
		register(io.intino.alexandria.ui.displays.notifiers.TemplateNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.templates.MatchInfoTemplate.class);
		register(io.intino.alexandria.ui.displays.notifiers.TemplateNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.templates.MatchPlayersTemplate.class);
		register(io.intino.alexandria.ui.displays.notifiers.TemplateNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.templates.MatchLineupPinTemplate.class);
		register(io.intino.alexandria.ui.displays.notifiers.TemplateNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.templates.MatchCompetitionTemplate.class);
		register(io.intino.alexandria.ui.displays.notifiers.TemplateNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.templates.MatchesTemplate.class);
		register(io.intino.alexandria.ui.displays.notifiers.TemplateNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.templates.OverviewTemplate.class);
		register(io.intino.alexandria.ui.displays.notifiers.TemplateNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.templates.PlayerMatchTraceTemplate.class);
		register(io.intino.alexandria.ui.displays.notifiers.TemplateNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.templates.PlayerTraceTemplate.class);
		register(io.intino.alexandria.ui.displays.notifiers.TemplateNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.templates.TeamsTemplate.class);
		register(io.intino.alexandria.ui.displays.notifiers.TemplateNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.templates.TeamTemplate.class);
		register(io.intino.alexandria.ui.displays.notifiers.TemplateNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.templates.SquadTeamTemplate.class);
		register(io.intino.alexandria.ui.displays.notifiers.TemplateNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.templates.OutTeamTemplate.class);
		register(io.intino.alexandria.ui.displays.notifiers.TemplateNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.templates.AppTemplate.class);
		register(io.intino.alexandria.ui.displays.notifiers.TemplateNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.templates.HeaderTemplate.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.items.IdMold.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.items.NameMold.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.items.TeamMold.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.items.AgeMold.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.items.RoleMold.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.items.OverallMold.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.items.PositionMold.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.items.HappinessContractMold.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.items.HappinessGameTimeMold.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.items.HappinessIndividualMold.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.items.HappinessCollectiveMold.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.items.MinutesMold.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.items.ScoreMold.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.items.CacheIniMold.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.items.CacheMold.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.items.FullClassificationPositionMold.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.items.FullClassificationTeamMold.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.items.FullClassificationPlayedMatchesMold.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.items.FullClassificationWinMatchesMold.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.items.FullClassificationDrawMatchesMold.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.items.FullClassificationLostMatchesMold.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.items.FullClassificationGoalsForMold.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.items.FullClassificationGoalsAgainstMold.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.items.FullClassificationGoalsDifferenceMold.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.items.FullClassificationPointsMold.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.items.TopScorersPositionMold.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.items.TopScorersPlayerMold.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.items.TopScorersGoalsMold.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.items.TopScorersPlayedMatchesMold.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.items.TopAssistersPositionMold.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.items.TopAssistersPlayerMold.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.items.TopAssistersAssistsMold.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.items.TopAssistersPlayedMatchesMold.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.items.TopGoalkeepersPositionMold.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.items.TopGoalkeepersPlayerMold.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.items.TopGoalkeepersGoalsMold.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.items.TopGoalkeepersPlayedMinutesMold.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.items.CompetitionsTableMold.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.items.MatchEventsLocalPlayerMold.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.items.MatchEventsMinuteMold.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.items.MatchEventsVisitantPlayerMold.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.items.MatchPlayersNumberMold.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.items.MatchPlayersNameMold.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.items.MatchPlayersPositionMold.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.items.MatchPlayersEntersMold.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.items.MatchPlayersExitsMold.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.items.MatchPlayersGoalsMold.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.items.MatchPlayersAssistsMold.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.items.MatchPlayersYellowCardsMold.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.items.MatchPlayersRedCardsMold.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.items.MatchPlayersScoreMold.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.items.MatchTableMold.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.items.ClassificationPositionMold.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.items.ClassificationTeamMold.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.items.ClassificationPlayedMatchesMold.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.items.ClassificationWinMatchesMold.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.items.ClassificationDrawMatchesMold.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.items.ClassificationLostMatchesMold.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.items.ClassificationGoalsDifferenceMold.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.items.ClassificationPointsMold.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.items.MatchTraceMinuteMold.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.items.DateTraceMinuteMold.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.items.MinuteTraceMinuteMold.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.items.StaminaTraceMinuteMold.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.items.EnergyTraceMinuteMold.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.items.DateTraceMold.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.items.EnergyTraceMold.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.items.PhysicalConditionTraceMold.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.items.SelfConfidenceTraceMold.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.items.ContractSatisfactionTraceMold.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.items.GameTimeSatisfactionTraceMold.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.items.CollectivePerformanceTraceMold.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.items.MinuteTraceMold.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.items.StaminaTraceMold.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.items.InjuredTraceMold.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.items.TeamsTableMold.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.items.SquadTeamNumberMold.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.items.SquadTeamPositionMold.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.items.SquadTeamNameMold.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.items.SquadTeamCountryMold.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.items.SquadTeamMatchesMold.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.items.SquadTeamMinutesMold.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.items.SquadTeamGoalsMold.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.items.SquadTeamAssistsMold.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.items.SquadTeamYellowCardsMold.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.items.SquadTeamRedCardsMold.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.items.OutTeamPositionMold.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.items.OutTeamNameMold.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.items.OutTeamFromMold.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.items.OutTeamToMold.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.items.OutTeamDescriptionMold.class);
		register(io.intino.alexandria.ui.displays.notifiers.RowNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.rows.PlayersTableRow.class);
		register(io.intino.alexandria.ui.displays.notifiers.RowNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.rows.FullClassificationTableRow.class);
		register(io.intino.alexandria.ui.displays.notifiers.RowNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.rows.TopScorersTableRow.class);
		register(io.intino.alexandria.ui.displays.notifiers.RowNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.rows.TopAssistersTableRow.class);
		register(io.intino.alexandria.ui.displays.notifiers.RowNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.rows.TopGoalkeepersTableRow.class);
		register(io.intino.alexandria.ui.displays.notifiers.RowNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.rows.MatchEventsTableRow.class);
		register(io.intino.alexandria.ui.displays.notifiers.RowNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.rows.MatchPlayersTableRow.class);
		register(io.intino.alexandria.ui.displays.notifiers.RowNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.rows.ClassificationTableRow.class);
		register(io.intino.alexandria.ui.displays.notifiers.RowNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.rows.MinuteTraceTableRow.class);
		register(io.intino.alexandria.ui.displays.notifiers.RowNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.rows.TraceTableRow.class);
		register(io.intino.alexandria.ui.displays.notifiers.RowNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.rows.SquadTeamTableRow.class);
		register(io.intino.alexandria.ui.displays.notifiers.RowNotifier.class).forDisplay(rlp.footrix.protrix.box.ui.displays.rows.OutTeamTableRow.class);
	}

	private static void initTraceTemplate(UISpark spark, PushService pushService) {
		spark.route("/tracetemplate/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/tracetemplate/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.TemplateRequester(manager, notifierProvider()).execute());
		spark.route("/tracetemplate/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("tracetemplate", new io.intino.alexandria.ui.displays.requesters.TemplatePushRequester());

	}
	private static void initFullClassificationTemplate(UISpark spark, PushService pushService) {
		spark.route("/fullclassificationtemplate/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/fullclassificationtemplate/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.TemplateRequester(manager, notifierProvider()).execute());
		spark.route("/fullclassificationtemplate/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("fullclassificationtemplate", new io.intino.alexandria.ui.displays.requesters.TemplatePushRequester());

	}
	private static void initCompetitionGoalRankingTemplate(UISpark spark, PushService pushService) {
		spark.route("/competitiongoalrankingtemplate/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/competitiongoalrankingtemplate/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.TemplateRequester(manager, notifierProvider()).execute());
		spark.route("/competitiongoalrankingtemplate/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("competitiongoalrankingtemplate", new io.intino.alexandria.ui.displays.requesters.TemplatePushRequester());

	}
	private static void initCompetitionAssistRankingTemplate(UISpark spark, PushService pushService) {
		spark.route("/competitionassistrankingtemplate/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/competitionassistrankingtemplate/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.TemplateRequester(manager, notifierProvider()).execute());
		spark.route("/competitionassistrankingtemplate/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("competitionassistrankingtemplate", new io.intino.alexandria.ui.displays.requesters.TemplatePushRequester());

	}
	private static void initCompetitionReceivedGoalRankingTemplate(UISpark spark, PushService pushService) {
		spark.route("/competitionreceivedgoalrankingtemplate/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/competitionreceivedgoalrankingtemplate/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.TemplateRequester(manager, notifierProvider()).execute());
		spark.route("/competitionreceivedgoalrankingtemplate/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("competitionreceivedgoalrankingtemplate", new io.intino.alexandria.ui.displays.requesters.TemplatePushRequester());

	}
	private static void initCompetitionsTemplate(UISpark spark, PushService pushService) {
		spark.route("/competitionstemplate/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/competitionstemplate/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.TemplateRequester(manager, notifierProvider()).execute());
		spark.route("/competitionstemplate/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("competitionstemplate", new io.intino.alexandria.ui.displays.requesters.TemplatePushRequester());

	}
	private static void initCompetitionTemplate(UISpark spark, PushService pushService) {
		spark.route("/competitiontemplate/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/competitiontemplate/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.TemplateRequester(manager, notifierProvider()).execute());
		spark.route("/competitiontemplate/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("competitiontemplate", new io.intino.alexandria.ui.displays.requesters.TemplatePushRequester());

	}
	private static void initCompetitionRankingsTemplate(UISpark spark, PushService pushService) {
		spark.route("/competitionrankingstemplate/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/competitionrankingstemplate/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.TemplateRequester(manager, notifierProvider()).execute());
		spark.route("/competitionrankingstemplate/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("competitionrankingstemplate", new io.intino.alexandria.ui.displays.requesters.TemplatePushRequester());

	}
	private static void initMatchTemplate(UISpark spark, PushService pushService) {
		spark.route("/matchtemplate/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/matchtemplate/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.TemplateRequester(manager, notifierProvider()).execute());
		spark.route("/matchtemplate/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("matchtemplate", new io.intino.alexandria.ui.displays.requesters.TemplatePushRequester());

	}
	private static void initMatchInfoTemplate(UISpark spark, PushService pushService) {
		spark.route("/matchinfotemplate/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/matchinfotemplate/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.TemplateRequester(manager, notifierProvider()).execute());
		spark.route("/matchinfotemplate/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("matchinfotemplate", new io.intino.alexandria.ui.displays.requesters.TemplatePushRequester());

	}
	private static void initMatchPlayersTemplate(UISpark spark, PushService pushService) {
		spark.route("/matchplayerstemplate/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/matchplayerstemplate/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.TemplateRequester(manager, notifierProvider()).execute());
		spark.route("/matchplayerstemplate/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("matchplayerstemplate", new io.intino.alexandria.ui.displays.requesters.TemplatePushRequester());

	}
	private static void initMatchLineupPinTemplate(UISpark spark, PushService pushService) {
		spark.route("/matchlineuppintemplate/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/matchlineuppintemplate/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.TemplateRequester(manager, notifierProvider()).execute());
		spark.route("/matchlineuppintemplate/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("matchlineuppintemplate", new io.intino.alexandria.ui.displays.requesters.TemplatePushRequester());

	}
	private static void initMatchCompetitionTemplate(UISpark spark, PushService pushService) {
		spark.route("/matchcompetitiontemplate/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/matchcompetitiontemplate/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.TemplateRequester(manager, notifierProvider()).execute());
		spark.route("/matchcompetitiontemplate/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("matchcompetitiontemplate", new io.intino.alexandria.ui.displays.requesters.TemplatePushRequester());

	}
	private static void initMatchesTemplate(UISpark spark, PushService pushService) {
		spark.route("/matchestemplate/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/matchestemplate/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.TemplateRequester(manager, notifierProvider()).execute());
		spark.route("/matchestemplate/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("matchestemplate", new io.intino.alexandria.ui.displays.requesters.TemplatePushRequester());

	}
	private static void initOverviewTemplate(UISpark spark, PushService pushService) {
		spark.route("/overviewtemplate/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/overviewtemplate/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.TemplateRequester(manager, notifierProvider()).execute());
		spark.route("/overviewtemplate/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("overviewtemplate", new io.intino.alexandria.ui.displays.requesters.TemplatePushRequester());

	}
	private static void initPlayerMatchTraceTemplate(UISpark spark, PushService pushService) {
		spark.route("/playermatchtracetemplate/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/playermatchtracetemplate/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.TemplateRequester(manager, notifierProvider()).execute());
		spark.route("/playermatchtracetemplate/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("playermatchtracetemplate", new io.intino.alexandria.ui.displays.requesters.TemplatePushRequester());

	}
	private static void initPlayerTraceTemplate(UISpark spark, PushService pushService) {
		spark.route("/playertracetemplate/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/playertracetemplate/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.TemplateRequester(manager, notifierProvider()).execute());
		spark.route("/playertracetemplate/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("playertracetemplate", new io.intino.alexandria.ui.displays.requesters.TemplatePushRequester());

	}
	private static void initTeamsTemplate(UISpark spark, PushService pushService) {
		spark.route("/teamstemplate/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/teamstemplate/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.TemplateRequester(manager, notifierProvider()).execute());
		spark.route("/teamstemplate/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("teamstemplate", new io.intino.alexandria.ui.displays.requesters.TemplatePushRequester());

	}
	private static void initTeamTemplate(UISpark spark, PushService pushService) {
		spark.route("/teamtemplate/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/teamtemplate/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.TemplateRequester(manager, notifierProvider()).execute());
		spark.route("/teamtemplate/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("teamtemplate", new io.intino.alexandria.ui.displays.requesters.TemplatePushRequester());

	}
	private static void initSquadTeamTemplate(UISpark spark, PushService pushService) {
		spark.route("/squadteamtemplate/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/squadteamtemplate/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.TemplateRequester(manager, notifierProvider()).execute());
		spark.route("/squadteamtemplate/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("squadteamtemplate", new io.intino.alexandria.ui.displays.requesters.TemplatePushRequester());

	}
	private static void initOutTeamTemplate(UISpark spark, PushService pushService) {
		spark.route("/outteamtemplate/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/outteamtemplate/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.TemplateRequester(manager, notifierProvider()).execute());
		spark.route("/outteamtemplate/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("outteamtemplate", new io.intino.alexandria.ui.displays.requesters.TemplatePushRequester());

	}
	private static void initAppTemplate(UISpark spark, PushService pushService) {
		spark.route("/apptemplate/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/apptemplate/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.TemplateRequester(manager, notifierProvider()).execute());
		spark.route("/apptemplate/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("apptemplate", new io.intino.alexandria.ui.displays.requesters.TemplatePushRequester());

	}
	private static void initHeaderTemplate(UISpark spark, PushService pushService) {
		spark.route("/headertemplate/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/headertemplate/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.TemplateRequester(manager, notifierProvider()).execute());
		spark.route("/headertemplate/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("headertemplate", new io.intino.alexandria.ui.displays.requesters.TemplatePushRequester());

	}
	private static void initIdMold(UISpark spark, PushService pushService) {
		spark.route("/idmold/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/idmold/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/idmold/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("idmold", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

	}
	private static void initNameMold(UISpark spark, PushService pushService) {
		spark.route("/namemold/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/namemold/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/namemold/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("namemold", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

	}
	private static void initTeamMold(UISpark spark, PushService pushService) {
		spark.route("/teammold/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/teammold/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/teammold/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("teammold", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

	}
	private static void initAgeMold(UISpark spark, PushService pushService) {
		spark.route("/agemold/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/agemold/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/agemold/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("agemold", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

	}
	private static void initRoleMold(UISpark spark, PushService pushService) {
		spark.route("/rolemold/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/rolemold/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/rolemold/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("rolemold", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

	}
	private static void initOverallMold(UISpark spark, PushService pushService) {
		spark.route("/overallmold/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/overallmold/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/overallmold/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("overallmold", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

	}
	private static void initPositionMold(UISpark spark, PushService pushService) {
		spark.route("/positionmold/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/positionmold/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/positionmold/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("positionmold", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

	}
	private static void initHappinessContractMold(UISpark spark, PushService pushService) {
		spark.route("/happinesscontractmold/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/happinesscontractmold/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/happinesscontractmold/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("happinesscontractmold", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

	}
	private static void initHappinessGameTimeMold(UISpark spark, PushService pushService) {
		spark.route("/happinessgametimemold/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/happinessgametimemold/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/happinessgametimemold/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("happinessgametimemold", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

	}
	private static void initHappinessIndividualMold(UISpark spark, PushService pushService) {
		spark.route("/happinessindividualmold/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/happinessindividualmold/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/happinessindividualmold/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("happinessindividualmold", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

	}
	private static void initHappinessCollectiveMold(UISpark spark, PushService pushService) {
		spark.route("/happinesscollectivemold/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/happinesscollectivemold/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/happinesscollectivemold/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("happinesscollectivemold", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

	}
	private static void initMinutesMold(UISpark spark, PushService pushService) {
		spark.route("/minutesmold/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/minutesmold/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/minutesmold/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("minutesmold", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

	}
	private static void initScoreMold(UISpark spark, PushService pushService) {
		spark.route("/scoremold/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/scoremold/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/scoremold/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("scoremold", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

	}
	private static void initCacheIniMold(UISpark spark, PushService pushService) {
		spark.route("/cacheinimold/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/cacheinimold/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/cacheinimold/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("cacheinimold", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

	}
	private static void initCacheMold(UISpark spark, PushService pushService) {
		spark.route("/cachemold/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/cachemold/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/cachemold/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("cachemold", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

	}
	private static void initFullClassificationPositionMold(UISpark spark, PushService pushService) {
		spark.route("/fullclassificationpositionmold/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/fullclassificationpositionmold/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/fullclassificationpositionmold/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("fullclassificationpositionmold", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

	}
	private static void initFullClassificationTeamMold(UISpark spark, PushService pushService) {
		spark.route("/fullclassificationteammold/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/fullclassificationteammold/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/fullclassificationteammold/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("fullclassificationteammold", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

	}
	private static void initFullClassificationPlayedMatchesMold(UISpark spark, PushService pushService) {
		spark.route("/fullclassificationplayedmatchesmold/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/fullclassificationplayedmatchesmold/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/fullclassificationplayedmatchesmold/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("fullclassificationplayedmatchesmold", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

	}
	private static void initFullClassificationWinMatchesMold(UISpark spark, PushService pushService) {
		spark.route("/fullclassificationwinmatchesmold/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/fullclassificationwinmatchesmold/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/fullclassificationwinmatchesmold/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("fullclassificationwinmatchesmold", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

	}
	private static void initFullClassificationDrawMatchesMold(UISpark spark, PushService pushService) {
		spark.route("/fullclassificationdrawmatchesmold/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/fullclassificationdrawmatchesmold/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/fullclassificationdrawmatchesmold/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("fullclassificationdrawmatchesmold", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

	}
	private static void initFullClassificationLostMatchesMold(UISpark spark, PushService pushService) {
		spark.route("/fullclassificationlostmatchesmold/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/fullclassificationlostmatchesmold/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/fullclassificationlostmatchesmold/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("fullclassificationlostmatchesmold", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

	}
	private static void initFullClassificationGoalsForMold(UISpark spark, PushService pushService) {
		spark.route("/fullclassificationgoalsformold/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/fullclassificationgoalsformold/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/fullclassificationgoalsformold/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("fullclassificationgoalsformold", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

	}
	private static void initFullClassificationGoalsAgainstMold(UISpark spark, PushService pushService) {
		spark.route("/fullclassificationgoalsagainstmold/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/fullclassificationgoalsagainstmold/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/fullclassificationgoalsagainstmold/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("fullclassificationgoalsagainstmold", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

	}
	private static void initFullClassificationGoalsDifferenceMold(UISpark spark, PushService pushService) {
		spark.route("/fullclassificationgoalsdifferencemold/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/fullclassificationgoalsdifferencemold/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/fullclassificationgoalsdifferencemold/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("fullclassificationgoalsdifferencemold", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

	}
	private static void initFullClassificationPointsMold(UISpark spark, PushService pushService) {
		spark.route("/fullclassificationpointsmold/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/fullclassificationpointsmold/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/fullclassificationpointsmold/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("fullclassificationpointsmold", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

	}
	private static void initTopScorersPositionMold(UISpark spark, PushService pushService) {
		spark.route("/topscorerspositionmold/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/topscorerspositionmold/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/topscorerspositionmold/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("topscorerspositionmold", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

	}
	private static void initTopScorersPlayerMold(UISpark spark, PushService pushService) {
		spark.route("/topscorersplayermold/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/topscorersplayermold/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/topscorersplayermold/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("topscorersplayermold", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

	}
	private static void initTopScorersGoalsMold(UISpark spark, PushService pushService) {
		spark.route("/topscorersgoalsmold/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/topscorersgoalsmold/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/topscorersgoalsmold/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("topscorersgoalsmold", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

	}
	private static void initTopScorersPlayedMatchesMold(UISpark spark, PushService pushService) {
		spark.route("/topscorersplayedmatchesmold/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/topscorersplayedmatchesmold/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/topscorersplayedmatchesmold/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("topscorersplayedmatchesmold", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

	}
	private static void initTopAssistersPositionMold(UISpark spark, PushService pushService) {
		spark.route("/topassisterspositionmold/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/topassisterspositionmold/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/topassisterspositionmold/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("topassisterspositionmold", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

	}
	private static void initTopAssistersPlayerMold(UISpark spark, PushService pushService) {
		spark.route("/topassistersplayermold/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/topassistersplayermold/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/topassistersplayermold/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("topassistersplayermold", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

	}
	private static void initTopAssistersAssistsMold(UISpark spark, PushService pushService) {
		spark.route("/topassistersassistsmold/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/topassistersassistsmold/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/topassistersassistsmold/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("topassistersassistsmold", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

	}
	private static void initTopAssistersPlayedMatchesMold(UISpark spark, PushService pushService) {
		spark.route("/topassistersplayedmatchesmold/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/topassistersplayedmatchesmold/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/topassistersplayedmatchesmold/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("topassistersplayedmatchesmold", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

	}
	private static void initTopGoalkeepersPositionMold(UISpark spark, PushService pushService) {
		spark.route("/topgoalkeeperspositionmold/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/topgoalkeeperspositionmold/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/topgoalkeeperspositionmold/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("topgoalkeeperspositionmold", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

	}
	private static void initTopGoalkeepersPlayerMold(UISpark spark, PushService pushService) {
		spark.route("/topgoalkeepersplayermold/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/topgoalkeepersplayermold/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/topgoalkeepersplayermold/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("topgoalkeepersplayermold", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

	}
	private static void initTopGoalkeepersGoalsMold(UISpark spark, PushService pushService) {
		spark.route("/topgoalkeepersgoalsmold/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/topgoalkeepersgoalsmold/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/topgoalkeepersgoalsmold/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("topgoalkeepersgoalsmold", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

	}
	private static void initTopGoalkeepersPlayedMinutesMold(UISpark spark, PushService pushService) {
		spark.route("/topgoalkeepersplayedminutesmold/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/topgoalkeepersplayedminutesmold/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/topgoalkeepersplayedminutesmold/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("topgoalkeepersplayedminutesmold", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

	}
	private static void initCompetitionsTableMold(UISpark spark, PushService pushService) {
		spark.route("/competitionstablemold/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/competitionstablemold/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/competitionstablemold/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("competitionstablemold", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

	}
	private static void initMatchEventsLocalPlayerMold(UISpark spark, PushService pushService) {
		spark.route("/matcheventslocalplayermold/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/matcheventslocalplayermold/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/matcheventslocalplayermold/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("matcheventslocalplayermold", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

	}
	private static void initMatchEventsMinuteMold(UISpark spark, PushService pushService) {
		spark.route("/matcheventsminutemold/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/matcheventsminutemold/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/matcheventsminutemold/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("matcheventsminutemold", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

	}
	private static void initMatchEventsVisitantPlayerMold(UISpark spark, PushService pushService) {
		spark.route("/matcheventsvisitantplayermold/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/matcheventsvisitantplayermold/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/matcheventsvisitantplayermold/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("matcheventsvisitantplayermold", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

	}
	private static void initMatchPlayersNumberMold(UISpark spark, PushService pushService) {
		spark.route("/matchplayersnumbermold/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/matchplayersnumbermold/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/matchplayersnumbermold/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("matchplayersnumbermold", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

	}
	private static void initMatchPlayersNameMold(UISpark spark, PushService pushService) {
		spark.route("/matchplayersnamemold/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/matchplayersnamemold/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/matchplayersnamemold/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("matchplayersnamemold", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

	}
	private static void initMatchPlayersPositionMold(UISpark spark, PushService pushService) {
		spark.route("/matchplayerspositionmold/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/matchplayerspositionmold/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/matchplayerspositionmold/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("matchplayerspositionmold", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

	}
	private static void initMatchPlayersEntersMold(UISpark spark, PushService pushService) {
		spark.route("/matchplayersentersmold/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/matchplayersentersmold/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/matchplayersentersmold/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("matchplayersentersmold", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

	}
	private static void initMatchPlayersExitsMold(UISpark spark, PushService pushService) {
		spark.route("/matchplayersexitsmold/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/matchplayersexitsmold/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/matchplayersexitsmold/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("matchplayersexitsmold", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

	}
	private static void initMatchPlayersGoalsMold(UISpark spark, PushService pushService) {
		spark.route("/matchplayersgoalsmold/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/matchplayersgoalsmold/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/matchplayersgoalsmold/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("matchplayersgoalsmold", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

	}
	private static void initMatchPlayersAssistsMold(UISpark spark, PushService pushService) {
		spark.route("/matchplayersassistsmold/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/matchplayersassistsmold/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/matchplayersassistsmold/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("matchplayersassistsmold", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

	}
	private static void initMatchPlayersYellowCardsMold(UISpark spark, PushService pushService) {
		spark.route("/matchplayersyellowcardsmold/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/matchplayersyellowcardsmold/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/matchplayersyellowcardsmold/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("matchplayersyellowcardsmold", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

	}
	private static void initMatchPlayersRedCardsMold(UISpark spark, PushService pushService) {
		spark.route("/matchplayersredcardsmold/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/matchplayersredcardsmold/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/matchplayersredcardsmold/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("matchplayersredcardsmold", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

	}
	private static void initMatchPlayersScoreMold(UISpark spark, PushService pushService) {
		spark.route("/matchplayersscoremold/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/matchplayersscoremold/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/matchplayersscoremold/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("matchplayersscoremold", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

	}
	private static void initMatchTableMold(UISpark spark, PushService pushService) {
		spark.route("/matchtablemold/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/matchtablemold/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/matchtablemold/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("matchtablemold", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

	}
	private static void initClassificationPositionMold(UISpark spark, PushService pushService) {
		spark.route("/classificationpositionmold/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/classificationpositionmold/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/classificationpositionmold/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("classificationpositionmold", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

	}
	private static void initClassificationTeamMold(UISpark spark, PushService pushService) {
		spark.route("/classificationteammold/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/classificationteammold/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/classificationteammold/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("classificationteammold", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

	}
	private static void initClassificationPlayedMatchesMold(UISpark spark, PushService pushService) {
		spark.route("/classificationplayedmatchesmold/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/classificationplayedmatchesmold/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/classificationplayedmatchesmold/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("classificationplayedmatchesmold", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

	}
	private static void initClassificationWinMatchesMold(UISpark spark, PushService pushService) {
		spark.route("/classificationwinmatchesmold/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/classificationwinmatchesmold/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/classificationwinmatchesmold/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("classificationwinmatchesmold", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

	}
	private static void initClassificationDrawMatchesMold(UISpark spark, PushService pushService) {
		spark.route("/classificationdrawmatchesmold/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/classificationdrawmatchesmold/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/classificationdrawmatchesmold/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("classificationdrawmatchesmold", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

	}
	private static void initClassificationLostMatchesMold(UISpark spark, PushService pushService) {
		spark.route("/classificationlostmatchesmold/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/classificationlostmatchesmold/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/classificationlostmatchesmold/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("classificationlostmatchesmold", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

	}
	private static void initClassificationGoalsDifferenceMold(UISpark spark, PushService pushService) {
		spark.route("/classificationgoalsdifferencemold/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/classificationgoalsdifferencemold/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/classificationgoalsdifferencemold/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("classificationgoalsdifferencemold", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

	}
	private static void initClassificationPointsMold(UISpark spark, PushService pushService) {
		spark.route("/classificationpointsmold/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/classificationpointsmold/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/classificationpointsmold/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("classificationpointsmold", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

	}
	private static void initMatchTraceMinuteMold(UISpark spark, PushService pushService) {
		spark.route("/matchtraceminutemold/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/matchtraceminutemold/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/matchtraceminutemold/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("matchtraceminutemold", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

	}
	private static void initDateTraceMinuteMold(UISpark spark, PushService pushService) {
		spark.route("/datetraceminutemold/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/datetraceminutemold/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/datetraceminutemold/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("datetraceminutemold", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

	}
	private static void initMinuteTraceMinuteMold(UISpark spark, PushService pushService) {
		spark.route("/minutetraceminutemold/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/minutetraceminutemold/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/minutetraceminutemold/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("minutetraceminutemold", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

	}
	private static void initStaminaTraceMinuteMold(UISpark spark, PushService pushService) {
		spark.route("/staminatraceminutemold/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/staminatraceminutemold/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/staminatraceminutemold/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("staminatraceminutemold", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

	}
	private static void initEnergyTraceMinuteMold(UISpark spark, PushService pushService) {
		spark.route("/energytraceminutemold/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/energytraceminutemold/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/energytraceminutemold/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("energytraceminutemold", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

	}
	private static void initDateTraceMold(UISpark spark, PushService pushService) {
		spark.route("/datetracemold/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/datetracemold/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/datetracemold/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("datetracemold", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

	}
	private static void initEnergyTraceMold(UISpark spark, PushService pushService) {
		spark.route("/energytracemold/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/energytracemold/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/energytracemold/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("energytracemold", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

	}
	private static void initPhysicalConditionTraceMold(UISpark spark, PushService pushService) {
		spark.route("/physicalconditiontracemold/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/physicalconditiontracemold/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/physicalconditiontracemold/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("physicalconditiontracemold", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

	}
	private static void initSelfConfidenceTraceMold(UISpark spark, PushService pushService) {
		spark.route("/selfconfidencetracemold/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/selfconfidencetracemold/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/selfconfidencetracemold/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("selfconfidencetracemold", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

	}
	private static void initContractSatisfactionTraceMold(UISpark spark, PushService pushService) {
		spark.route("/contractsatisfactiontracemold/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/contractsatisfactiontracemold/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/contractsatisfactiontracemold/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("contractsatisfactiontracemold", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

	}
	private static void initGameTimeSatisfactionTraceMold(UISpark spark, PushService pushService) {
		spark.route("/gametimesatisfactiontracemold/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/gametimesatisfactiontracemold/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/gametimesatisfactiontracemold/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("gametimesatisfactiontracemold", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

	}
	private static void initCollectivePerformanceTraceMold(UISpark spark, PushService pushService) {
		spark.route("/collectiveperformancetracemold/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/collectiveperformancetracemold/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/collectiveperformancetracemold/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("collectiveperformancetracemold", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

	}
	private static void initMinuteTraceMold(UISpark spark, PushService pushService) {
		spark.route("/minutetracemold/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/minutetracemold/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/minutetracemold/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("minutetracemold", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

	}
	private static void initStaminaTraceMold(UISpark spark, PushService pushService) {
		spark.route("/staminatracemold/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/staminatracemold/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/staminatracemold/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("staminatracemold", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

	}
	private static void initInjuredTraceMold(UISpark spark, PushService pushService) {
		spark.route("/injuredtracemold/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/injuredtracemold/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/injuredtracemold/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("injuredtracemold", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

	}
	private static void initTeamsTableMold(UISpark spark, PushService pushService) {
		spark.route("/teamstablemold/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/teamstablemold/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/teamstablemold/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("teamstablemold", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

	}
	private static void initSquadTeamNumberMold(UISpark spark, PushService pushService) {
		spark.route("/squadteamnumbermold/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/squadteamnumbermold/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/squadteamnumbermold/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("squadteamnumbermold", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

	}
	private static void initSquadTeamPositionMold(UISpark spark, PushService pushService) {
		spark.route("/squadteampositionmold/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/squadteampositionmold/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/squadteampositionmold/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("squadteampositionmold", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

	}
	private static void initSquadTeamNameMold(UISpark spark, PushService pushService) {
		spark.route("/squadteamnamemold/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/squadteamnamemold/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/squadteamnamemold/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("squadteamnamemold", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

	}
	private static void initSquadTeamCountryMold(UISpark spark, PushService pushService) {
		spark.route("/squadteamcountrymold/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/squadteamcountrymold/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/squadteamcountrymold/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("squadteamcountrymold", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

	}
	private static void initSquadTeamMatchesMold(UISpark spark, PushService pushService) {
		spark.route("/squadteammatchesmold/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/squadteammatchesmold/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/squadteammatchesmold/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("squadteammatchesmold", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

	}
	private static void initSquadTeamMinutesMold(UISpark spark, PushService pushService) {
		spark.route("/squadteamminutesmold/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/squadteamminutesmold/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/squadteamminutesmold/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("squadteamminutesmold", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

	}
	private static void initSquadTeamGoalsMold(UISpark spark, PushService pushService) {
		spark.route("/squadteamgoalsmold/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/squadteamgoalsmold/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/squadteamgoalsmold/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("squadteamgoalsmold", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

	}
	private static void initSquadTeamAssistsMold(UISpark spark, PushService pushService) {
		spark.route("/squadteamassistsmold/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/squadteamassistsmold/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/squadteamassistsmold/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("squadteamassistsmold", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

	}
	private static void initSquadTeamYellowCardsMold(UISpark spark, PushService pushService) {
		spark.route("/squadteamyellowcardsmold/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/squadteamyellowcardsmold/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/squadteamyellowcardsmold/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("squadteamyellowcardsmold", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

	}
	private static void initSquadTeamRedCardsMold(UISpark spark, PushService pushService) {
		spark.route("/squadteamredcardsmold/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/squadteamredcardsmold/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/squadteamredcardsmold/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("squadteamredcardsmold", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

	}
	private static void initOutTeamPositionMold(UISpark spark, PushService pushService) {
		spark.route("/outteampositionmold/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/outteampositionmold/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/outteampositionmold/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("outteampositionmold", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

	}
	private static void initOutTeamNameMold(UISpark spark, PushService pushService) {
		spark.route("/outteamnamemold/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/outteamnamemold/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/outteamnamemold/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("outteamnamemold", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

	}
	private static void initOutTeamFromMold(UISpark spark, PushService pushService) {
		spark.route("/outteamfrommold/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/outteamfrommold/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/outteamfrommold/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("outteamfrommold", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

	}
	private static void initOutTeamToMold(UISpark spark, PushService pushService) {
		spark.route("/outteamtomold/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/outteamtomold/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/outteamtomold/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("outteamtomold", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

	}
	private static void initOutTeamDescriptionMold(UISpark spark, PushService pushService) {
		spark.route("/outteamdescriptionmold/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/outteamdescriptionmold/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/outteamdescriptionmold/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("outteamdescriptionmold", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

	}
	private static void initPlayersTableRow(UISpark spark, PushService pushService) {
		spark.route("/playerstablerow/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/playerstablerow/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.RowRequester(manager, notifierProvider()).execute());
		spark.route("/playerstablerow/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("playerstablerow", new io.intino.alexandria.ui.displays.requesters.RowPushRequester());

	}
	private static void initFullClassificationTableRow(UISpark spark, PushService pushService) {
		spark.route("/fullclassificationtablerow/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/fullclassificationtablerow/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.RowRequester(manager, notifierProvider()).execute());
		spark.route("/fullclassificationtablerow/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("fullclassificationtablerow", new io.intino.alexandria.ui.displays.requesters.RowPushRequester());

	}
	private static void initTopScorersTableRow(UISpark spark, PushService pushService) {
		spark.route("/topscorerstablerow/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/topscorerstablerow/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.RowRequester(manager, notifierProvider()).execute());
		spark.route("/topscorerstablerow/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("topscorerstablerow", new io.intino.alexandria.ui.displays.requesters.RowPushRequester());

	}
	private static void initTopAssistersTableRow(UISpark spark, PushService pushService) {
		spark.route("/topassisterstablerow/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/topassisterstablerow/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.RowRequester(manager, notifierProvider()).execute());
		spark.route("/topassisterstablerow/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("topassisterstablerow", new io.intino.alexandria.ui.displays.requesters.RowPushRequester());

	}
	private static void initTopGoalkeepersTableRow(UISpark spark, PushService pushService) {
		spark.route("/topgoalkeeperstablerow/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/topgoalkeeperstablerow/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.RowRequester(manager, notifierProvider()).execute());
		spark.route("/topgoalkeeperstablerow/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("topgoalkeeperstablerow", new io.intino.alexandria.ui.displays.requesters.RowPushRequester());

	}
	private static void initMatchEventsTableRow(UISpark spark, PushService pushService) {
		spark.route("/matcheventstablerow/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/matcheventstablerow/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.RowRequester(manager, notifierProvider()).execute());
		spark.route("/matcheventstablerow/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("matcheventstablerow", new io.intino.alexandria.ui.displays.requesters.RowPushRequester());

	}
	private static void initMatchPlayersTableRow(UISpark spark, PushService pushService) {
		spark.route("/matchplayerstablerow/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/matchplayerstablerow/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.RowRequester(manager, notifierProvider()).execute());
		spark.route("/matchplayerstablerow/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("matchplayerstablerow", new io.intino.alexandria.ui.displays.requesters.RowPushRequester());

	}
	private static void initClassificationTableRow(UISpark spark, PushService pushService) {
		spark.route("/classificationtablerow/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/classificationtablerow/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.RowRequester(manager, notifierProvider()).execute());
		spark.route("/classificationtablerow/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("classificationtablerow", new io.intino.alexandria.ui.displays.requesters.RowPushRequester());

	}
	private static void initMinuteTraceTableRow(UISpark spark, PushService pushService) {
		spark.route("/minutetracetablerow/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/minutetracetablerow/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.RowRequester(manager, notifierProvider()).execute());
		spark.route("/minutetracetablerow/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("minutetracetablerow", new io.intino.alexandria.ui.displays.requesters.RowPushRequester());

	}
	private static void initTraceTableRow(UISpark spark, PushService pushService) {
		spark.route("/tracetablerow/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/tracetablerow/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.RowRequester(manager, notifierProvider()).execute());
		spark.route("/tracetablerow/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("tracetablerow", new io.intino.alexandria.ui.displays.requesters.RowPushRequester());

	}
	private static void initSquadTeamTableRow(UISpark spark, PushService pushService) {
		spark.route("/squadteamtablerow/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/squadteamtablerow/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.RowRequester(manager, notifierProvider()).execute());
		spark.route("/squadteamtablerow/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("squadteamtablerow", new io.intino.alexandria.ui.displays.requesters.RowPushRequester());

	}
	private static void initOutTeamTableRow(UISpark spark, PushService pushService) {
		spark.route("/outteamtablerow/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/outteamtablerow/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.RowRequester(manager, notifierProvider()).execute());
		spark.route("/outteamtablerow/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("outteamtablerow", new io.intino.alexandria.ui.displays.requesters.RowPushRequester());

	}
}