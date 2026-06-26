package rlp.footrix.protrix.box.ui.displays.templates;

import io.intino.alexandria.core.Box;
import io.intino.alexandria.exceptions.*;
import io.intino.alexandria.ui.displays.components.*;
import rlp.footrix.protrix.box.ui.*;

import rlp.footrix.protrix.box.ProtrixBox;

import rlp.footrix.protrix.box.ui.displays.templates.*;






import rlp.footrix.protrix.box.ui.displays.items.*;
import rlp.footrix.protrix.box.ui.displays.rows.*;
import io.intino.alexandria.ui.displays.notifiers.TemplateNotifier;

public abstract class AbstractCompetitionTemplate<B extends Box> extends io.intino.alexandria.ui.displays.components.Template<TemplateNotifier, java.lang.Void, B> {
	public _27_1_0435423044 _27_1_0435423044;
	public CompetitionTemplate._27_1_0435423044. CompetitionName competitionName;
	public _29_1_1566634046 _29_1_1566634046;
	public CompetitionTemplate._29_1_1566634046. Tabs tabs;
	public CompetitionTemplate._29_1_1566634046.Tabs. ClassificationOpt classificationOpt;
	public CompetitionTemplate._29_1_1566634046.Tabs. TeamsOpt teamsOpt;
	public CompetitionTemplate._29_1_1566634046.Tabs. MatchesOpt matchesOpt;
	public CompetitionTemplate._29_1_1566634046.Tabs. RankingsOpt rankingsOpt;
	public CompetitionClassificationBlock competitionClassificationBlock;
	public CompetitionClassificationTemplate competitionClassificationStamp;
	public CompetitionTeamsBlock competitionTeamsBlock;
	public TeamsTemplate competitionTeamsStamp;
	public CompetitionMatchesBlock competitionMatchesBlock;
	public MatchesTemplate competitionMatchesStamp;
	public CompetitionRankingsBlock competitionRankingsBlock;
	public CompetitionRankingsTemplate competitionRankingsStamp;

	public AbstractCompetitionTemplate(B box) {
		super(box);
		id("competitionTemplate");
	}

	@Override
	public void init() {
		super.init();
		if (_27_1_0435423044 == null) _27_1_0435423044 = register(new _27_1_0435423044(box()).<_27_1_0435423044>id("a2114948943").owner(AbstractCompetitionTemplate.this));
		if (_27_1_0435423044 != null) competitionName = _27_1_0435423044.competitionName;
		if (_29_1_1566634046 == null) _29_1_1566634046 = register(new _29_1_1566634046(box()).<_29_1_1566634046>id("a979042731").owner(AbstractCompetitionTemplate.this));
		if (_29_1_1566634046 != null) tabs = _29_1_1566634046.tabs;
		if (tabs != null) classificationOpt = _29_1_1566634046.tabs.classificationOpt;
		if (tabs != null) teamsOpt = _29_1_1566634046.tabs.teamsOpt;
		if (tabs != null) matchesOpt = _29_1_1566634046.tabs.matchesOpt;
		if (tabs != null) rankingsOpt = _29_1_1566634046.tabs.rankingsOpt;
		if (competitionClassificationBlock == null) competitionClassificationBlock = register(new CompetitionClassificationBlock(box()).<CompetitionClassificationBlock>id("a2108965965").owner(AbstractCompetitionTemplate.this));
		if (competitionClassificationBlock != null) competitionClassificationStamp = competitionClassificationBlock.competitionClassificationStamp;
		if (competitionTeamsBlock == null) competitionTeamsBlock = register(new CompetitionTeamsBlock(box()).<CompetitionTeamsBlock>id("a_117470799").owner(AbstractCompetitionTemplate.this));
		if (competitionTeamsBlock != null) competitionTeamsStamp = competitionTeamsBlock.competitionTeamsStamp;
		if (competitionMatchesBlock == null) competitionMatchesBlock = register(new CompetitionMatchesBlock(box()).<CompetitionMatchesBlock>id("a1390791124").owner(AbstractCompetitionTemplate.this));
		if (competitionMatchesBlock != null) competitionMatchesStamp = competitionMatchesBlock.competitionMatchesStamp;
		if (competitionRankingsBlock == null) competitionRankingsBlock = register(new CompetitionRankingsBlock(box()).<CompetitionRankingsBlock>id("a_385708010").owner(AbstractCompetitionTemplate.this));
		if (competitionRankingsBlock != null) competitionRankingsStamp = competitionRankingsBlock.competitionRankingsStamp;
	}

	@Override
	public void remove() {
		super.remove();
		if (_27_1_0435423044 != null) _27_1_0435423044.unregister();
		if (_29_1_1566634046 != null) _29_1_1566634046.unregister();
		if (competitionClassificationBlock != null) competitionClassificationBlock.unregister();
		if (competitionTeamsBlock != null) competitionTeamsBlock.unregister();
		if (competitionMatchesBlock != null) competitionMatchesBlock.unregister();
		if (competitionRankingsBlock != null) competitionRankingsBlock.unregister();
	}

	public class _27_1_0435423044 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
		public CompetitionTemplate._27_1_0435423044. CompetitionName competitionName;

		public _27_1_0435423044(B box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (competitionName == null) competitionName = register(new CompetitionName(box()).<CompetitionName>id("a1389280781").owner(AbstractCompetitionTemplate.this));
		}

		@Override
		public void unregister() {
			super.unregister();
			if (competitionName != null) competitionName.unregister();
		}

		public class CompetitionName extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

			public CompetitionName(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
			}

			@Override
			public void unregister() {
				super.unregister();
			}
		}
	}

	public class _29_1_1566634046 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
		public CompetitionTemplate._29_1_1566634046. Tabs tabs;

		public _29_1_1566634046(B box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (tabs == null) tabs = register(new Tabs(box()).<Tabs>id("a_1801113607").owner(AbstractCompetitionTemplate.this));
		}

		@Override
		public void unregister() {
			super.unregister();
			if (tabs != null) tabs.unregister();
		}

		public class Tabs extends io.intino.alexandria.ui.displays.components.SelectorTabs<io.intino.alexandria.ui.displays.notifiers.SelectorTabsNotifier, B>  {
			public CompetitionTemplate._29_1_1566634046.Tabs. ClassificationOpt classificationOpt;
			public CompetitionTemplate._29_1_1566634046.Tabs. TeamsOpt teamsOpt;
			public CompetitionTemplate._29_1_1566634046.Tabs. MatchesOpt matchesOpt;
			public CompetitionTemplate._29_1_1566634046.Tabs. RankingsOpt rankingsOpt;

			public Tabs(B box) {
				super(box);
				_multipleSelection(false);
			}

			@Override
			public void init() {
				super.init();
				if (classificationOpt == null) classificationOpt = register(new ClassificationOpt(box()).<ClassificationOpt>id("a_289268185").owner(AbstractCompetitionTemplate.this));
				if (teamsOpt == null) teamsOpt = register(new TeamsOpt(box()).<TeamsOpt>id("a_1909640541").owner(AbstractCompetitionTemplate.this));
				if (matchesOpt == null) matchesOpt = register(new MatchesOpt(box()).<MatchesOpt>id("a1270930566").owner(AbstractCompetitionTemplate.this));
				if (rankingsOpt == null) rankingsOpt = register(new RankingsOpt(box()).<RankingsOpt>id("a501849904").owner(AbstractCompetitionTemplate.this));
			}

			@Override
			public void unregister() {
				super.unregister();
				if (classificationOpt != null) classificationOpt.unregister();
				if (teamsOpt != null) teamsOpt.unregister();
				if (matchesOpt != null) matchesOpt.unregister();
				if (rankingsOpt != null) rankingsOpt.unregister();
			}

			public class ClassificationOpt extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B> implements io.intino.alexandria.ui.displays.components.selector.SelectorOption {

				public ClassificationOpt(B box) {
					super(box);

					name("classificationOpt");
					_value("Clasificación");
				}

				@Override
				public void init() {
					super.init();
				}

				@Override
				public void unregister() {
					super.unregister();
				}
			}

			public class TeamsOpt extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B> implements io.intino.alexandria.ui.displays.components.selector.SelectorOption {

				public TeamsOpt(B box) {
					super(box);

					name("teamsOpt");
					_value("Equipos");
				}

				@Override
				public void init() {
					super.init();
				}

				@Override
				public void unregister() {
					super.unregister();
				}
			}

			public class MatchesOpt extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B> implements io.intino.alexandria.ui.displays.components.selector.SelectorOption {

				public MatchesOpt(B box) {
					super(box);

					name("matchesOpt");
					_value("Partidos");
				}

				@Override
				public void init() {
					super.init();
				}

				@Override
				public void unregister() {
					super.unregister();
				}
			}

			public class RankingsOpt extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B> implements io.intino.alexandria.ui.displays.components.selector.SelectorOption {

				public RankingsOpt(B box) {
					super(box);

					name("rankingsOpt");
					_value("Rankings");
				}

				@Override
				public void init() {
					super.init();
				}

				@Override
				public void unregister() {
					super.unregister();
				}
			}
		}
	}

	public class CompetitionClassificationBlock extends io.intino.alexandria.ui.displays.components.BlockConditional<io.intino.alexandria.ui.displays.notifiers.BlockConditionalNotifier, B>  {
		public CompetitionClassificationTemplate competitionClassificationStamp;

		public CompetitionClassificationBlock(B box) {
			super(box);
		}

		@Override
		public void initConditional() {
			super.init();
			if (competitionClassificationStamp == null) competitionClassificationStamp = AbstractCompetitionTemplate.this.competitionClassificationStamp = register(new CompetitionClassificationTemplate((ProtrixBox)box()).id("a1536321904"));
			if (AbstractCompetitionTemplate.this.competitionClassificationStamp == null) AbstractCompetitionTemplate.this.competitionClassificationStamp = competitionClassificationBlock.competitionClassificationStamp;
		}

		@Override
		public void unregister() {
			super.unregister();
			if (competitionClassificationStamp != null) competitionClassificationStamp.unregister();
		}
	}

	public class CompetitionTeamsBlock extends io.intino.alexandria.ui.displays.components.BlockConditional<io.intino.alexandria.ui.displays.notifiers.BlockConditionalNotifier, B>  {
		public TeamsTemplate competitionTeamsStamp;

		public CompetitionTeamsBlock(B box) {
			super(box);
		}

		@Override
		public void initConditional() {
			super.init();
			if (competitionTeamsStamp == null) competitionTeamsStamp = AbstractCompetitionTemplate.this.competitionTeamsStamp = register(new TeamsTemplate((ProtrixBox)box()).id("a_176490818"));
			if (AbstractCompetitionTemplate.this.competitionTeamsStamp == null) AbstractCompetitionTemplate.this.competitionTeamsStamp = competitionTeamsBlock.competitionTeamsStamp;
		}

		@Override
		public void unregister() {
			super.unregister();
			if (competitionTeamsStamp != null) competitionTeamsStamp.unregister();
		}
	}

	public class CompetitionMatchesBlock extends io.intino.alexandria.ui.displays.components.BlockConditional<io.intino.alexandria.ui.displays.notifiers.BlockConditionalNotifier, B>  {
		public MatchesTemplate competitionMatchesStamp;

		public CompetitionMatchesBlock(B box) {
			super(box);
		}

		@Override
		public void initConditional() {
			super.init();
			if (competitionMatchesStamp == null) competitionMatchesStamp = AbstractCompetitionTemplate.this.competitionMatchesStamp = register(new MatchesTemplate((ProtrixBox)box()).id("a1019077700"));
			if (AbstractCompetitionTemplate.this.competitionMatchesStamp == null) AbstractCompetitionTemplate.this.competitionMatchesStamp = competitionMatchesBlock.competitionMatchesStamp;
		}

		@Override
		public void unregister() {
			super.unregister();
			if (competitionMatchesStamp != null) competitionMatchesStamp.unregister();
		}
	}

	public class CompetitionRankingsBlock extends io.intino.alexandria.ui.displays.components.BlockConditional<io.intino.alexandria.ui.displays.notifiers.BlockConditionalNotifier, B>  {
		public CompetitionRankingsTemplate competitionRankingsStamp;

		public CompetitionRankingsBlock(B box) {
			super(box);
		}

		@Override
		public void initConditional() {
			super.init();
			if (competitionRankingsStamp == null) competitionRankingsStamp = AbstractCompetitionTemplate.this.competitionRankingsStamp = register(new CompetitionRankingsTemplate((ProtrixBox)box()).id("a_278314160"));
			if (AbstractCompetitionTemplate.this.competitionRankingsStamp == null) AbstractCompetitionTemplate.this.competitionRankingsStamp = competitionRankingsBlock.competitionRankingsStamp;
		}

		@Override
		public void unregister() {
			super.unregister();
			if (competitionRankingsStamp != null) competitionRankingsStamp.unregister();
		}
	}
}