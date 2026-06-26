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

public abstract class AbstractMatchTemplate<B extends Box> extends io.intino.alexandria.ui.displays.components.Template<TemplateNotifier, java.lang.Void, B> {
	public _8_1_0793583238 _8_1_0793583238;
	public MatchTemplate._8_1_0793583238. _9_2_11595693366 _9_2_11595693366;
	public MatchTemplate._8_1_0793583238._9_2_11595693366. Competition competition;
	public MatchTemplate._8_1_0793583238. _11_2_11808675846 _11_2_11808675846;
	public MatchTemplate._8_1_0793583238._11_2_11808675846. _12_3_135528624 _12_3_135528624;
	public MatchTemplate._8_1_0793583238._11_2_11808675846._12_3_135528624. LocalTeam localTeam;
	public MatchTemplate._8_1_0793583238._11_2_11808675846. _14_3_1227812112 _14_3_1227812112;
	public MatchTemplate._8_1_0793583238._11_2_11808675846._14_3_1227812112. Result result;
	public MatchTemplate._8_1_0793583238._11_2_11808675846. _16_3_1441951834 _16_3_1441951834;
	public MatchTemplate._8_1_0793583238._11_2_11808675846._16_3_1441951834. VisitantTeam visitantTeam;
	public MatchTemplate._8_1_0793583238. _18_2_1555207157 _18_2_1555207157;
	public MatchTemplate._8_1_0793583238._18_2_1555207157. _19_3_11129468632 _19_3_11129468632;
	public MatchTemplate._8_1_0793583238._18_2_1555207157._19_3_11129468632. MatchDay matchDay;
	public MatchTemplate._8_1_0793583238._18_2_1555207157._19_3_11129468632. Day day;
	public _22_1_11345200004 _22_1_11345200004;
	public MatchTemplate._22_1_11345200004. Tabs tabs;
	public MatchTemplate._22_1_11345200004.Tabs. InfoOpt infoOpt;
	public MatchTemplate._22_1_11345200004.Tabs. CompetitionOpt competitionOpt;
	public InfoBlock infoBlock;
	public MatchInfoTemplate matchInfoStamp;
	public CompetitionBlock competitionBlock;
	public MatchCompetitionTemplate matchCompetitionStamp;

	public AbstractMatchTemplate(B box) {
		super(box);
		id("matchTemplate");
	}

	@Override
	public void init() {
		super.init();
		if (_8_1_0793583238 == null) _8_1_0793583238 = register(new _8_1_0793583238(box()).<_8_1_0793583238>id("a675190141").owner(AbstractMatchTemplate.this));
		if (_8_1_0793583238 != null) _9_2_11595693366 = _8_1_0793583238._9_2_11595693366;
		if (_9_2_11595693366 != null) competition = _8_1_0793583238._9_2_11595693366.competition;
		if (_8_1_0793583238 != null) _11_2_11808675846 = _8_1_0793583238._11_2_11808675846;
		if (_11_2_11808675846 != null) _12_3_135528624 = _8_1_0793583238._11_2_11808675846._12_3_135528624;
		if (_12_3_135528624 != null) localTeam = _8_1_0793583238._11_2_11808675846._12_3_135528624.localTeam;
		if (_11_2_11808675846 != null) _14_3_1227812112 = _8_1_0793583238._11_2_11808675846._14_3_1227812112;
		if (_14_3_1227812112 != null) result = _8_1_0793583238._11_2_11808675846._14_3_1227812112.result;
		if (_11_2_11808675846 != null) _16_3_1441951834 = _8_1_0793583238._11_2_11808675846._16_3_1441951834;
		if (_16_3_1441951834 != null) visitantTeam = _8_1_0793583238._11_2_11808675846._16_3_1441951834.visitantTeam;
		if (_8_1_0793583238 != null) _18_2_1555207157 = _8_1_0793583238._18_2_1555207157;
		if (_18_2_1555207157 != null) _19_3_11129468632 = _8_1_0793583238._18_2_1555207157._19_3_11129468632;
		if (_19_3_11129468632 != null) matchDay = _8_1_0793583238._18_2_1555207157._19_3_11129468632.matchDay;
		if (_19_3_11129468632 != null) day = _8_1_0793583238._18_2_1555207157._19_3_11129468632.day;
		if (_22_1_11345200004 == null) _22_1_11345200004 = register(new _22_1_11345200004(box()).<_22_1_11345200004>id("a_103767927").owner(AbstractMatchTemplate.this));
		if (_22_1_11345200004 != null) tabs = _22_1_11345200004.tabs;
		if (tabs != null) infoOpt = _22_1_11345200004.tabs.infoOpt;
		if (tabs != null) competitionOpt = _22_1_11345200004.tabs.competitionOpt;
		if (infoBlock == null) infoBlock = register(new InfoBlock(box()).<InfoBlock>id("a1802876512").owner(AbstractMatchTemplate.this));
		if (infoBlock != null) matchInfoStamp = infoBlock.matchInfoStamp;
		if (competitionBlock == null) competitionBlock = register(new CompetitionBlock(box()).<CompetitionBlock>id("a_1608300275").owner(AbstractMatchTemplate.this));
		if (competitionBlock != null) matchCompetitionStamp = competitionBlock.matchCompetitionStamp;
	}

	@Override
	public void remove() {
		super.remove();
		if (_8_1_0793583238 != null) _8_1_0793583238.unregister();
		if (_22_1_11345200004 != null) _22_1_11345200004.unregister();
		if (infoBlock != null) infoBlock.unregister();
		if (competitionBlock != null) competitionBlock.unregister();
	}

	public class _8_1_0793583238 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
		public MatchTemplate._8_1_0793583238. _9_2_11595693366 _9_2_11595693366;
		public MatchTemplate._8_1_0793583238. _11_2_11808675846 _11_2_11808675846;
		public MatchTemplate._8_1_0793583238. _18_2_1555207157 _18_2_1555207157;

		public _8_1_0793583238(B box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (_9_2_11595693366 == null) _9_2_11595693366 = register(new _9_2_11595693366(box()).<_9_2_11595693366>id("a_952671919").owner(AbstractMatchTemplate.this));
			if (_11_2_11808675846 == null) _11_2_11808675846 = register(new _11_2_11808675846(box()).<_11_2_11808675846>id("a246410378").owner(AbstractMatchTemplate.this));
			if (_18_2_1555207157 == null) _18_2_1555207157 = register(new _18_2_1555207157(box()).<_18_2_1555207157>id("a1017342483").owner(AbstractMatchTemplate.this));
		}

		@Override
		public void unregister() {
			super.unregister();
			if (_9_2_11595693366 != null) _9_2_11595693366.unregister();
			if (_11_2_11808675846 != null) _11_2_11808675846.unregister();
			if (_18_2_1555207157 != null) _18_2_1555207157.unregister();
		}

		public class _9_2_11595693366 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
			public MatchTemplate._8_1_0793583238._9_2_11595693366. Competition competition;

			public _9_2_11595693366(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (competition == null) competition = register(new Competition(box()).<Competition>id("a1081607442").owner(AbstractMatchTemplate.this));
			}

			@Override
			public void unregister() {
				super.unregister();
				if (competition != null) competition.unregister();
			}

			public class Competition extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

				public Competition(B box) {
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

		public class _11_2_11808675846 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
			public MatchTemplate._8_1_0793583238._11_2_11808675846. _12_3_135528624 _12_3_135528624;
			public MatchTemplate._8_1_0793583238._11_2_11808675846. _14_3_1227812112 _14_3_1227812112;
			public MatchTemplate._8_1_0793583238._11_2_11808675846. _16_3_1441951834 _16_3_1441951834;

			public _11_2_11808675846(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (_12_3_135528624 == null) _12_3_135528624 = register(new _12_3_135528624(box()).<_12_3_135528624>id("a_1362305581").owner(AbstractMatchTemplate.this));
				if (_14_3_1227812112 == null) _14_3_1227812112 = register(new _14_3_1227812112(box()).<_14_3_1227812112>id("a_1773696390").owner(AbstractMatchTemplate.this));
				if (_16_3_1441951834 == null) _16_3_1441951834 = register(new _16_3_1441951834(box()).<_16_3_1441951834>id("a383110845").owner(AbstractMatchTemplate.this));
			}

			@Override
			public void unregister() {
				super.unregister();
				if (_12_3_135528624 != null) _12_3_135528624.unregister();
				if (_14_3_1227812112 != null) _14_3_1227812112.unregister();
				if (_16_3_1441951834 != null) _16_3_1441951834.unregister();
			}

			public class _12_3_135528624 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
				public MatchTemplate._8_1_0793583238._11_2_11808675846._12_3_135528624. LocalTeam localTeam;

				public _12_3_135528624(B box) {
					super(box);
				}

				@Override
				public void init() {
					super.init();
					if (localTeam == null) localTeam = register(new LocalTeam(box()).<LocalTeam>id("a_1918361576").owner(AbstractMatchTemplate.this));
				}

				@Override
				public void unregister() {
					super.unregister();
					if (localTeam != null) localTeam.unregister();
				}

				public class LocalTeam extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

					public LocalTeam(B box) {
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

			public class _14_3_1227812112 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
				public MatchTemplate._8_1_0793583238._11_2_11808675846._14_3_1227812112. Result result;

				public _14_3_1227812112(B box) {
					super(box);
				}

				@Override
				public void init() {
					super.init();
					if (result == null) result = register(new Result(box()).<Result>id("a_882569045").owner(AbstractMatchTemplate.this));
				}

				@Override
				public void unregister() {
					super.unregister();
					if (result != null) result.unregister();
				}

				public class Result extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

					public Result(B box) {
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

			public class _16_3_1441951834 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
				public MatchTemplate._8_1_0793583238._11_2_11808675846._16_3_1441951834. VisitantTeam visitantTeam;

				public _16_3_1441951834(B box) {
					super(box);
				}

				@Override
				public void init() {
					super.init();
					if (visitantTeam == null) visitantTeam = register(new VisitantTeam(box()).<VisitantTeam>id("a_73597179").owner(AbstractMatchTemplate.this));
				}

				@Override
				public void unregister() {
					super.unregister();
					if (visitantTeam != null) visitantTeam.unregister();
				}

				public class VisitantTeam extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

					public VisitantTeam(B box) {
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
		}

		public class _18_2_1555207157 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
			public MatchTemplate._8_1_0793583238._18_2_1555207157. _19_3_11129468632 _19_3_11129468632;

			public _18_2_1555207157(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (_19_3_11129468632 == null) _19_3_11129468632 = register(new _19_3_11129468632(box()).<_19_3_11129468632>id("a_160550168").owner(AbstractMatchTemplate.this));
			}

			@Override
			public void unregister() {
				super.unregister();
				if (_19_3_11129468632 != null) _19_3_11129468632.unregister();
			}

			public class _19_3_11129468632 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
				public MatchTemplate._8_1_0793583238._18_2_1555207157._19_3_11129468632. MatchDay matchDay;
				public MatchTemplate._8_1_0793583238._18_2_1555207157._19_3_11129468632. Day day;

				public _19_3_11129468632(B box) {
					super(box);
				}

				@Override
				public void init() {
					super.init();
					if (matchDay == null) matchDay = register(new MatchDay(box()).<MatchDay>id("a_762202240").owner(AbstractMatchTemplate.this));
					if (day == null) day = register(new Day(box()).<Day>id("a_235217389").owner(AbstractMatchTemplate.this));
				}

				@Override
				public void unregister() {
					super.unregister();
					if (matchDay != null) matchDay.unregister();
					if (day != null) day.unregister();
				}

				public class MatchDay extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

					public MatchDay(B box) {
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

				public class Day extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

					public Day(B box) {
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
		}
	}

	public class _22_1_11345200004 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
		public MatchTemplate._22_1_11345200004. Tabs tabs;

		public _22_1_11345200004(B box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (tabs == null) tabs = register(new Tabs(box()).<Tabs>id("a119188369").owner(AbstractMatchTemplate.this));
		}

		@Override
		public void unregister() {
			super.unregister();
			if (tabs != null) tabs.unregister();
		}

		public class Tabs extends io.intino.alexandria.ui.displays.components.SelectorTabs<io.intino.alexandria.ui.displays.notifiers.SelectorTabsNotifier, B>  {
			public MatchTemplate._22_1_11345200004.Tabs. InfoOpt infoOpt;
			public MatchTemplate._22_1_11345200004.Tabs. CompetitionOpt competitionOpt;

			public Tabs(B box) {
				super(box);
				_multipleSelection(false);
			}

			@Override
			public void init() {
				super.init();
				if (infoOpt == null) infoOpt = register(new InfoOpt(box()).<InfoOpt>id("a_24732553").owner(AbstractMatchTemplate.this));
				if (competitionOpt == null) competitionOpt = register(new CompetitionOpt(box()).<CompetitionOpt>id("a944891618").owner(AbstractMatchTemplate.this));
			}

			@Override
			public void unregister() {
				super.unregister();
				if (infoOpt != null) infoOpt.unregister();
				if (competitionOpt != null) competitionOpt.unregister();
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

			public class CompetitionOpt extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B> implements io.intino.alexandria.ui.displays.components.selector.SelectorOption {

				public CompetitionOpt(B box) {
					super(box);

					name("competitionOpt");
					_value("Competición");
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

	public class InfoBlock extends io.intino.alexandria.ui.displays.components.BlockConditional<io.intino.alexandria.ui.displays.notifiers.BlockConditionalNotifier, B>  {
		public MatchInfoTemplate matchInfoStamp;

		public InfoBlock(B box) {
			super(box);
		}

		@Override
		public void initConditional() {
			super.init();
			if (matchInfoStamp == null) matchInfoStamp = AbstractMatchTemplate.this.matchInfoStamp = register(new MatchInfoTemplate((ProtrixBox)box()).id("a_657208529"));
			if (AbstractMatchTemplate.this.matchInfoStamp == null) AbstractMatchTemplate.this.matchInfoStamp = infoBlock.matchInfoStamp;
		}

		@Override
		public void unregister() {
			super.unregister();
			if (matchInfoStamp != null) matchInfoStamp.unregister();
		}
	}

	public class CompetitionBlock extends io.intino.alexandria.ui.displays.components.BlockConditional<io.intino.alexandria.ui.displays.notifiers.BlockConditionalNotifier, B>  {
		public MatchCompetitionTemplate matchCompetitionStamp;

		public CompetitionBlock(B box) {
			super(box);
		}

		@Override
		public void initConditional() {
			super.init();
			if (matchCompetitionStamp == null) matchCompetitionStamp = AbstractMatchTemplate.this.matchCompetitionStamp = register(new MatchCompetitionTemplate((ProtrixBox)box()).id("a912656247"));
			if (AbstractMatchTemplate.this.matchCompetitionStamp == null) AbstractMatchTemplate.this.matchCompetitionStamp = competitionBlock.matchCompetitionStamp;
		}

		@Override
		public void unregister() {
			super.unregister();
			if (matchCompetitionStamp != null) matchCompetitionStamp.unregister();
		}
	}
}