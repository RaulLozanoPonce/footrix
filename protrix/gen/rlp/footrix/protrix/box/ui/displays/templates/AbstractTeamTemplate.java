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

public abstract class AbstractTeamTemplate<B extends Box> extends io.intino.alexandria.ui.displays.components.Template<TemplateNotifier, java.lang.Void, B> {
	public _8_1_0798210932 _8_1_0798210932;
	public TeamTemplate._8_1_0798210932. _9_2_11856258761 _9_2_11856258761;
	public TeamTemplate._8_1_0798210932._9_2_11856258761. _9_44_0288009109 _9_44_0288009109;
	public TeamTemplate._8_1_0798210932. TeamName teamName;
	public _11_1_175072804 _11_1_175072804;
	public TeamTemplate._11_1_175072804. Tabs tabs;
	public TeamTemplate._11_1_175072804.Tabs. InfoOpt infoOpt;
	public TeamTemplate._11_1_175072804.Tabs. MatchesOpt matchesOpt;
	public TeamTemplate._11_1_175072804.Tabs. SquadOpt squadOpt;
	public TeamTemplate._11_1_175072804.Tabs. ClassificationOpt classificationOpt;
	public TeamTemplate._11_1_175072804.Tabs. OutOpt outOpt;
	public TeamTemplate._11_1_175072804.Tabs. TrophiesOpt trophiesOpt;
	public TeamMatchesBlock teamMatchesBlock;
	public MatchesTemplate teamMatchesStamp;
	public TeamSquadBlock teamSquadBlock;
	public SquadTeamTemplate teamSquadStamp;
	public TeamClassificationBlock teamClassificationBlock;
	public FullClassificationTemplate teamClassificationStamp;
	public TeamOutBlock teamOutBlock;
	public OutTeamTemplate teamOutStamp;

	public AbstractTeamTemplate(B box) {
		super(box);
		id("teamTemplate");
	}

	@Override
	public void init() {
		super.init();
		if (_8_1_0798210932 == null) _8_1_0798210932 = register(new _8_1_0798210932(box()).<_8_1_0798210932>id("a_1110734600").owner(AbstractTeamTemplate.this));
		if (_8_1_0798210932 != null) _9_2_11856258761 = _8_1_0798210932._9_2_11856258761;
		if (_9_2_11856258761 != null) _9_44_0288009109 = _8_1_0798210932._9_2_11856258761._9_44_0288009109;
		if (_8_1_0798210932 != null) teamName = _8_1_0798210932.teamName;
		if (_11_1_175072804 == null) _11_1_175072804 = register(new _11_1_175072804(box()).<_11_1_175072804>id("a1146835561").owner(AbstractTeamTemplate.this));
		if (_11_1_175072804 != null) tabs = _11_1_175072804.tabs;
		if (tabs != null) infoOpt = _11_1_175072804.tabs.infoOpt;
		if (tabs != null) matchesOpt = _11_1_175072804.tabs.matchesOpt;
		if (tabs != null) squadOpt = _11_1_175072804.tabs.squadOpt;
		if (tabs != null) classificationOpt = _11_1_175072804.tabs.classificationOpt;
		if (tabs != null) outOpt = _11_1_175072804.tabs.outOpt;
		if (tabs != null) trophiesOpt = _11_1_175072804.tabs.trophiesOpt;
		if (teamMatchesBlock == null) teamMatchesBlock = register(new TeamMatchesBlock(box()).<TeamMatchesBlock>id("a_428990624").owner(AbstractTeamTemplate.this));
		if (teamMatchesBlock != null) teamMatchesStamp = teamMatchesBlock.teamMatchesStamp;
		if (teamSquadBlock == null) teamSquadBlock = register(new TeamSquadBlock(box()).<TeamSquadBlock>id("a1368890937").owner(AbstractTeamTemplate.this));
		if (teamSquadBlock != null) teamSquadStamp = teamSquadBlock.teamSquadStamp;
		if (teamClassificationBlock == null) teamClassificationBlock = register(new TeamClassificationBlock(box()).<TeamClassificationBlock>id("a_197732031").owner(AbstractTeamTemplate.this));
		if (teamClassificationBlock != null) teamClassificationStamp = teamClassificationBlock.teamClassificationStamp;
		if (teamOutBlock == null) teamOutBlock = register(new TeamOutBlock(box()).<TeamOutBlock>id("a1139975461").owner(AbstractTeamTemplate.this));
		if (teamOutBlock != null) teamOutStamp = teamOutBlock.teamOutStamp;
	}

	@Override
	public void remove() {
		super.remove();
		if (_8_1_0798210932 != null) _8_1_0798210932.unregister();
		if (_11_1_175072804 != null) _11_1_175072804.unregister();
		if (teamMatchesBlock != null) teamMatchesBlock.unregister();
		if (teamSquadBlock != null) teamSquadBlock.unregister();
		if (teamClassificationBlock != null) teamClassificationBlock.unregister();
		if (teamOutBlock != null) teamOutBlock.unregister();
	}

	public class _8_1_0798210932 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
		public TeamTemplate._8_1_0798210932. _9_2_11856258761 _9_2_11856258761;
		public TeamTemplate._8_1_0798210932. TeamName teamName;

		public _8_1_0798210932(B box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (_9_2_11856258761 == null) _9_2_11856258761 = register(new _9_2_11856258761(box()).<_9_2_11856258761>id("a698395426").owner(AbstractTeamTemplate.this));
			if (teamName == null) teamName = register(new TeamName(box()).<TeamName>id("a1519135046").owner(AbstractTeamTemplate.this));
		}

		@Override
		public void unregister() {
			super.unregister();
			if (_9_2_11856258761 != null) _9_2_11856258761.unregister();
			if (teamName != null) teamName.unregister();
		}

		public class _9_2_11856258761 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
			public TeamTemplate._8_1_0798210932._9_2_11856258761. _9_44_0288009109 _9_44_0288009109;

			public _9_2_11856258761(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (_9_44_0288009109 == null) _9_44_0288009109 = register(new _9_44_0288009109(box()).<_9_44_0288009109>id("a1492644025").owner(AbstractTeamTemplate.this));
			}

			@Override
			public void unregister() {
				super.unregister();
				if (_9_44_0288009109 != null) _9_44_0288009109.unregister();
			}

			public class _9_44_0288009109 extends io.intino.alexandria.ui.displays.components.Icon<io.intino.alexandria.ui.displays.notifiers.IconNotifier, B>  {

				public _9_44_0288009109(B box) {
					super(box);
					_icon(AbstractTeamTemplate.class.getResource("/icons/flags/0.png"));
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

		public class TeamName extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

			public TeamName(B box) {
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

	public class _11_1_175072804 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
		public TeamTemplate._11_1_175072804. Tabs tabs;

		public _11_1_175072804(B box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (tabs == null) tabs = register(new Tabs(box()).<Tabs>id("a108447330").owner(AbstractTeamTemplate.this));
		}

		@Override
		public void unregister() {
			super.unregister();
			if (tabs != null) tabs.unregister();
		}

		public class Tabs extends io.intino.alexandria.ui.displays.components.SelectorTabs<io.intino.alexandria.ui.displays.notifiers.SelectorTabsNotifier, B>  {
			public TeamTemplate._11_1_175072804.Tabs. InfoOpt infoOpt;
			public TeamTemplate._11_1_175072804.Tabs. MatchesOpt matchesOpt;
			public TeamTemplate._11_1_175072804.Tabs. SquadOpt squadOpt;
			public TeamTemplate._11_1_175072804.Tabs. ClassificationOpt classificationOpt;
			public TeamTemplate._11_1_175072804.Tabs. OutOpt outOpt;
			public TeamTemplate._11_1_175072804.Tabs. TrophiesOpt trophiesOpt;

			public Tabs(B box) {
				super(box);
				_multipleSelection(false);
			}

			@Override
			public void init() {
				super.init();
				if (infoOpt == null) infoOpt = register(new InfoOpt(box()).<InfoOpt>id("a_519612856").owner(AbstractTeamTemplate.this));
				if (matchesOpt == null) matchesOpt = register(new MatchesOpt(box()).<MatchesOpt>id("a2081577597").owner(AbstractTeamTemplate.this));
				if (squadOpt == null) squadOpt = register(new SquadOpt(box()).<SquadOpt>id("a104750422").owner(AbstractTeamTemplate.this));
				if (classificationOpt == null) classificationOpt = register(new ClassificationOpt(box()).<ClassificationOpt>id("a511462480").owner(AbstractTeamTemplate.this));
				if (outOpt == null) outOpt = register(new OutOpt(box()).<OutOpt>id("a993149186").owner(AbstractTeamTemplate.this));
				if (trophiesOpt == null) trophiesOpt = register(new TrophiesOpt(box()).<TrophiesOpt>id("a_1198427480").owner(AbstractTeamTemplate.this));
			}

			@Override
			public void unregister() {
				super.unregister();
				if (infoOpt != null) infoOpt.unregister();
				if (matchesOpt != null) matchesOpt.unregister();
				if (squadOpt != null) squadOpt.unregister();
				if (classificationOpt != null) classificationOpt.unregister();
				if (outOpt != null) outOpt.unregister();
				if (trophiesOpt != null) trophiesOpt.unregister();
			}

			public class InfoOpt extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B> implements io.intino.alexandria.ui.displays.components.selector.SelectorOption {

				public InfoOpt(B box) {
					super(box);

					name("infoOpt");
					_value("Info");
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

			public class SquadOpt extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B> implements io.intino.alexandria.ui.displays.components.selector.SelectorOption {

				public SquadOpt(B box) {
					super(box);

					name("squadOpt");
					_value("Plantilla");
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

			public class OutOpt extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B> implements io.intino.alexandria.ui.displays.components.selector.SelectorOption {

				public OutOpt(B box) {
					super(box);

					name("outOpt");
					_value("Lesiones/Sanciones");
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

			public class TrophiesOpt extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B> implements io.intino.alexandria.ui.displays.components.selector.SelectorOption {

				public TrophiesOpt(B box) {
					super(box);

					name("trophiesOpt");
					_value("Palmarés");
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

	public class TeamMatchesBlock extends io.intino.alexandria.ui.displays.components.BlockConditional<io.intino.alexandria.ui.displays.notifiers.BlockConditionalNotifier, B>  {
		public MatchesTemplate teamMatchesStamp;

		public TeamMatchesBlock(B box) {
			super(box);
		}

		@Override
		public void initConditional() {
			super.init();
			if (teamMatchesStamp == null) teamMatchesStamp = AbstractTeamTemplate.this.teamMatchesStamp = register(new MatchesTemplate((ProtrixBox)box()).id("a_1105726388"));
			if (AbstractTeamTemplate.this.teamMatchesStamp == null) AbstractTeamTemplate.this.teamMatchesStamp = teamMatchesBlock.teamMatchesStamp;
		}

		@Override
		public void unregister() {
			super.unregister();
			if (teamMatchesStamp != null) teamMatchesStamp.unregister();
		}
	}

	public class TeamSquadBlock extends io.intino.alexandria.ui.displays.components.BlockConditional<io.intino.alexandria.ui.displays.notifiers.BlockConditionalNotifier, B>  {
		public SquadTeamTemplate teamSquadStamp;

		public TeamSquadBlock(B box) {
			super(box);
		}

		@Override
		public void initConditional() {
			super.init();
			if (teamSquadStamp == null) teamSquadStamp = AbstractTeamTemplate.this.teamSquadStamp = register(new SquadTeamTemplate((ProtrixBox)box()).id("a_1562952532"));
			if (AbstractTeamTemplate.this.teamSquadStamp == null) AbstractTeamTemplate.this.teamSquadStamp = teamSquadBlock.teamSquadStamp;
		}

		@Override
		public void unregister() {
			super.unregister();
			if (teamSquadStamp != null) teamSquadStamp.unregister();
		}
	}

	public class TeamClassificationBlock extends io.intino.alexandria.ui.displays.components.BlockConditional<io.intino.alexandria.ui.displays.notifiers.BlockConditionalNotifier, B>  {
		public FullClassificationTemplate teamClassificationStamp;

		public TeamClassificationBlock(B box) {
			super(box);
		}

		@Override
		public void initConditional() {
			super.init();
			if (teamClassificationStamp == null) teamClassificationStamp = AbstractTeamTemplate.this.teamClassificationStamp = register(new FullClassificationTemplate((ProtrixBox)box()).id("a_973033246"));
			if (AbstractTeamTemplate.this.teamClassificationStamp == null) AbstractTeamTemplate.this.teamClassificationStamp = teamClassificationBlock.teamClassificationStamp;
		}

		@Override
		public void unregister() {
			super.unregister();
			if (teamClassificationStamp != null) teamClassificationStamp.unregister();
		}
	}

	public class TeamOutBlock extends io.intino.alexandria.ui.displays.components.BlockConditional<io.intino.alexandria.ui.displays.notifiers.BlockConditionalNotifier, B>  {
		public OutTeamTemplate teamOutStamp;

		public TeamOutBlock(B box) {
			super(box);
		}

		@Override
		public void initConditional() {
			super.init();
			if (teamOutStamp == null) teamOutStamp = AbstractTeamTemplate.this.teamOutStamp = register(new OutTeamTemplate((ProtrixBox)box()).id("a1108313964"));
			if (AbstractTeamTemplate.this.teamOutStamp == null) AbstractTeamTemplate.this.teamOutStamp = teamOutBlock.teamOutStamp;
		}

		@Override
		public void unregister() {
			super.unregister();
			if (teamOutStamp != null) teamOutStamp.unregister();
		}
	}
}