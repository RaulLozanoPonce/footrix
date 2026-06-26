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

public abstract class AbstractAppTemplate<B extends Box> extends io.intino.alexandria.ui.displays.components.Template<TemplateNotifier, java.lang.Void, B> {
	public _27_1_0898319770 _27_1_0898319770;
	public AppTemplate._27_1_0898319770. _28_2_01276302935 _28_2_01276302935;
	public HeaderTemplate header;
	public AppTemplate._27_1_0898319770. _31_2_01811349954 _31_2_01811349954;
	public AppTemplate._27_1_0898319770._31_2_01811349954. _32_3_11424894600 _32_3_11424894600;
	public AppTemplate._27_1_0898319770._31_2_01811349954._32_3_11424894600. Menu menu;
	public AppTemplate._27_1_0898319770._31_2_01811349954._32_3_11424894600.Menu. OverviewOpt overviewOpt;
	public AppTemplate._27_1_0898319770._31_2_01811349954._32_3_11424894600.Menu.OverviewOpt. _35_6_1132494945 _35_6_1132494945;
	public AppTemplate._27_1_0898319770._31_2_01811349954._32_3_11424894600.Menu.OverviewOpt. _36_6_02039091381 _36_6_02039091381;
	public AppTemplate._27_1_0898319770._31_2_01811349954._32_3_11424894600.Menu. CompetitionsOpt competitionsOpt;
	public AppTemplate._27_1_0898319770._31_2_01811349954._32_3_11424894600.Menu.CompetitionsOpt. _38_6_1225078887 _38_6_1225078887;
	public AppTemplate._27_1_0898319770._31_2_01811349954._32_3_11424894600.Menu.CompetitionsOpt. _39_6_11345121768 _39_6_11345121768;
	public AppTemplate._27_1_0898319770._31_2_01811349954._32_3_11424894600.Menu. TeamsOpt teamsOpt;
	public AppTemplate._27_1_0898319770._31_2_01811349954._32_3_11424894600.Menu.TeamsOpt. _41_6_11687601513 _41_6_11687601513;
	public AppTemplate._27_1_0898319770._31_2_01811349954._32_3_11424894600.Menu.TeamsOpt. _42_6_11896789298 _42_6_11896789298;
	public AppTemplate._27_1_0898319770._31_2_01811349954. _43_3_0128459239 _43_3_0128459239;
	public AppTemplate._27_1_0898319770._31_2_01811349954._43_3_0128459239. Loading loading;
	public AppTemplate._27_1_0898319770._31_2_01811349954._43_3_0128459239.Loading. _44_59_039976812 _44_59_039976812;
	public AppTemplate._27_1_0898319770._31_2_01811349954._43_3_0128459239. UpdateRequiredPage updateRequiredPage;
	public AppTemplate._27_1_0898319770._31_2_01811349954._43_3_0128459239.UpdateRequiredPage. _47_5_11228315650 _47_5_11228315650;
	public AppTemplate._27_1_0898319770._31_2_01811349954._43_3_0128459239.UpdateRequiredPage. ReloadPage reloadPage;
	public AppTemplate._27_1_0898319770._31_2_01811349954._43_3_0128459239. OverviewPage overviewPage;
	public OverviewTemplate overviewStamp;
	public AppTemplate._27_1_0898319770._31_2_01811349954._43_3_0128459239. CompetitionsPage competitionsPage;
	public CompetitionsTemplate competitionsStamp;
	public AppTemplate._27_1_0898319770._31_2_01811349954._43_3_0128459239. CompetitionPage competitionPage;
	public CompetitionTemplate competitionStamp;
	public AppTemplate._27_1_0898319770._31_2_01811349954._43_3_0128459239. TeamsPage teamsPage;
	public TeamsTemplate teamsStamp;
	public AppTemplate._27_1_0898319770._31_2_01811349954._43_3_0128459239. TeamPage teamPage;
	public TeamTemplate teamStamp;
	public AppTemplate._27_1_0898319770._31_2_01811349954._43_3_0128459239. MatchPage matchPage;
	public MatchTemplate matchStamp;

	public AbstractAppTemplate(B box) {
		super(box);
		id("appTemplate");
	}

	@Override
	public void init() {
		super.init();
		if (_27_1_0898319770 == null) _27_1_0898319770 = register(new _27_1_0898319770(box()).<_27_1_0898319770>id("a_967563288").owner(AbstractAppTemplate.this));
		if (_27_1_0898319770 != null) _28_2_01276302935 = _27_1_0898319770._28_2_01276302935;
		if (_28_2_01276302935 != null) header = _27_1_0898319770._28_2_01276302935.header;
		if (_27_1_0898319770 != null) _31_2_01811349954 = _27_1_0898319770._31_2_01811349954;
		if (_31_2_01811349954 != null) _32_3_11424894600 = _27_1_0898319770._31_2_01811349954._32_3_11424894600;
		if (_32_3_11424894600 != null) menu = _27_1_0898319770._31_2_01811349954._32_3_11424894600.menu;
		if (menu != null) overviewOpt = _27_1_0898319770._31_2_01811349954._32_3_11424894600.menu.overviewOpt;
		if (overviewOpt != null) _35_6_1132494945 = _27_1_0898319770._31_2_01811349954._32_3_11424894600.menu.overviewOpt._35_6_1132494945;
		if (overviewOpt != null) _36_6_02039091381 = _27_1_0898319770._31_2_01811349954._32_3_11424894600.menu.overviewOpt._36_6_02039091381;
		if (menu != null) competitionsOpt = _27_1_0898319770._31_2_01811349954._32_3_11424894600.menu.competitionsOpt;
		if (competitionsOpt != null) _38_6_1225078887 = _27_1_0898319770._31_2_01811349954._32_3_11424894600.menu.competitionsOpt._38_6_1225078887;
		if (competitionsOpt != null) _39_6_11345121768 = _27_1_0898319770._31_2_01811349954._32_3_11424894600.menu.competitionsOpt._39_6_11345121768;
		if (menu != null) teamsOpt = _27_1_0898319770._31_2_01811349954._32_3_11424894600.menu.teamsOpt;
		if (teamsOpt != null) _41_6_11687601513 = _27_1_0898319770._31_2_01811349954._32_3_11424894600.menu.teamsOpt._41_6_11687601513;
		if (teamsOpt != null) _42_6_11896789298 = _27_1_0898319770._31_2_01811349954._32_3_11424894600.menu.teamsOpt._42_6_11896789298;
		if (_31_2_01811349954 != null) _43_3_0128459239 = _27_1_0898319770._31_2_01811349954._43_3_0128459239;
		if (_43_3_0128459239 != null) loading = _27_1_0898319770._31_2_01811349954._43_3_0128459239.loading;
		if (loading != null) _44_59_039976812 = _27_1_0898319770._31_2_01811349954._43_3_0128459239.loading._44_59_039976812;
		if (_43_3_0128459239 != null) updateRequiredPage = _27_1_0898319770._31_2_01811349954._43_3_0128459239.updateRequiredPage;
		if (updateRequiredPage != null) _47_5_11228315650 = _27_1_0898319770._31_2_01811349954._43_3_0128459239.updateRequiredPage._47_5_11228315650;
		if (updateRequiredPage != null) reloadPage = _27_1_0898319770._31_2_01811349954._43_3_0128459239.updateRequiredPage.reloadPage;
		if (_43_3_0128459239 != null) overviewPage = _27_1_0898319770._31_2_01811349954._43_3_0128459239.overviewPage;
		if (overviewPage != null) overviewStamp = _27_1_0898319770._31_2_01811349954._43_3_0128459239.overviewPage.overviewStamp;
		if (_43_3_0128459239 != null) competitionsPage = _27_1_0898319770._31_2_01811349954._43_3_0128459239.competitionsPage;
		if (competitionsPage != null) competitionsStamp = _27_1_0898319770._31_2_01811349954._43_3_0128459239.competitionsPage.competitionsStamp;
		if (_43_3_0128459239 != null) competitionPage = _27_1_0898319770._31_2_01811349954._43_3_0128459239.competitionPage;
		if (competitionPage != null) competitionStamp = _27_1_0898319770._31_2_01811349954._43_3_0128459239.competitionPage.competitionStamp;
		if (_43_3_0128459239 != null) teamsPage = _27_1_0898319770._31_2_01811349954._43_3_0128459239.teamsPage;
		if (teamsPage != null) teamsStamp = _27_1_0898319770._31_2_01811349954._43_3_0128459239.teamsPage.teamsStamp;
		if (_43_3_0128459239 != null) teamPage = _27_1_0898319770._31_2_01811349954._43_3_0128459239.teamPage;
		if (teamPage != null) teamStamp = _27_1_0898319770._31_2_01811349954._43_3_0128459239.teamPage.teamStamp;
		if (_43_3_0128459239 != null) matchPage = _27_1_0898319770._31_2_01811349954._43_3_0128459239.matchPage;
		if (matchPage != null) matchStamp = _27_1_0898319770._31_2_01811349954._43_3_0128459239.matchPage.matchStamp;
	}

	@Override
	public void remove() {
		super.remove();
		if (_27_1_0898319770 != null) _27_1_0898319770.unregister();
	}

	public class _27_1_0898319770 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
		public AppTemplate._27_1_0898319770. _28_2_01276302935 _28_2_01276302935;
		public AppTemplate._27_1_0898319770. _31_2_01811349954 _31_2_01811349954;

		public _27_1_0898319770(B box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (_28_2_01276302935 == null) _28_2_01276302935 = register(new _28_2_01276302935(box()).<_28_2_01276302935>id("a_435807278").owner(AbstractAppTemplate.this));
			if (_31_2_01811349954 == null) _31_2_01811349954 = register(new _31_2_01811349954(box()).<_31_2_01811349954>id("a1420297035").owner(AbstractAppTemplate.this));
		}

		@Override
		public void unregister() {
			super.unregister();
			if (_28_2_01276302935 != null) _28_2_01276302935.unregister();
			if (_31_2_01811349954 != null) _31_2_01811349954.unregister();
		}

		public class _28_2_01276302935 extends io.intino.alexandria.ui.displays.components.Header<io.intino.alexandria.ui.displays.notifiers.HeaderNotifier, B>  {
			public HeaderTemplate header;

			public _28_2_01276302935(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (header == null) header = AbstractAppTemplate.this.header = register(new HeaderTemplate((ProtrixBox)box()).id("a162375656"));
			}

			@Override
			public void unregister() {
				super.unregister();
				if (header != null) header.unregister();
			}
		}

		public class _31_2_01811349954 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
			public AppTemplate._27_1_0898319770._31_2_01811349954. _32_3_11424894600 _32_3_11424894600;
			public AppTemplate._27_1_0898319770._31_2_01811349954. _43_3_0128459239 _43_3_0128459239;

			public _31_2_01811349954(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (_32_3_11424894600 == null) _32_3_11424894600 = register(new _32_3_11424894600(box()).<_32_3_11424894600>id("a_120323159").owner(AbstractAppTemplate.this));
				if (_43_3_0128459239 == null) _43_3_0128459239 = register(new _43_3_0128459239(box()).<_43_3_0128459239>id("a_432429161").owner(AbstractAppTemplate.this));
			}

			@Override
			public void unregister() {
				super.unregister();
				if (_32_3_11424894600 != null) _32_3_11424894600.unregister();
				if (_43_3_0128459239 != null) _43_3_0128459239.unregister();
			}

			public class _32_3_11424894600 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
				public AppTemplate._27_1_0898319770._31_2_01811349954._32_3_11424894600. Menu menu;

				public _32_3_11424894600(B box) {
					super(box);
				}

				@Override
				public void init() {
					super.init();
					if (menu == null) menu = register(new Menu(box()).<Menu>id("a2079698912").owner(AbstractAppTemplate.this));
				}

				@Override
				public void unregister() {
					super.unregister();
					if (menu != null) menu.unregister();
				}

				public class Menu extends io.intino.alexandria.ui.displays.components.SelectorListBox<io.intino.alexandria.ui.displays.notifiers.SelectorListBoxNotifier, B>  {
					public AppTemplate._27_1_0898319770._31_2_01811349954._32_3_11424894600.Menu. OverviewOpt overviewOpt;
					public AppTemplate._27_1_0898319770._31_2_01811349954._32_3_11424894600.Menu. CompetitionsOpt competitionsOpt;
					public AppTemplate._27_1_0898319770._31_2_01811349954._32_3_11424894600.Menu. TeamsOpt teamsOpt;

					public Menu(B box) {
						super(box);
						_multipleSelection(false);
					}

					@Override
					public void init() {
						super.init();
						if (overviewOpt == null) overviewOpt = register(new OverviewOpt(box()).<OverviewOpt>id("a1490380955").owner(AbstractAppTemplate.this));
						if (competitionsOpt == null) competitionsOpt = register(new CompetitionsOpt(box()).<CompetitionsOpt>id("a_1128702688").owner(AbstractAppTemplate.this));
						if (teamsOpt == null) teamsOpt = register(new TeamsOpt(box()).<TeamsOpt>id("a_1103059300").owner(AbstractAppTemplate.this));
					}

					@Override
					public void unregister() {
						super.unregister();
						if (overviewOpt != null) overviewOpt.unregister();
						if (competitionsOpt != null) competitionsOpt.unregister();
						if (teamsOpt != null) teamsOpt.unregister();
					}

					public class OverviewOpt extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B> implements io.intino.alexandria.ui.displays.components.selector.SelectorOption {
						public AppTemplate._27_1_0898319770._31_2_01811349954._32_3_11424894600.Menu.OverviewOpt. _35_6_1132494945 _35_6_1132494945;
						public AppTemplate._27_1_0898319770._31_2_01811349954._32_3_11424894600.Menu.OverviewOpt. _36_6_02039091381 _36_6_02039091381;

						public OverviewOpt(B box) {
							super(box);

							name("overviewOpt");
						}

						@Override
						public void init() {
							super.init();
							if (_35_6_1132494945 == null) _35_6_1132494945 = register(new _35_6_1132494945(box()).<_35_6_1132494945>id("a1253107797").owner(AbstractAppTemplate.this));
							if (_36_6_02039091381 == null) _36_6_02039091381 = register(new _36_6_02039091381(box()).<_36_6_02039091381>id("a1764132046").owner(AbstractAppTemplate.this));
						}

						@Override
						public void unregister() {
							super.unregister();
							if (_35_6_1132494945 != null) _35_6_1132494945.unregister();
							if (_36_6_02039091381 != null) _36_6_02039091381.unregister();
						}

						public class _35_6_1132494945 extends io.intino.alexandria.ui.displays.components.MaterialIcon<io.intino.alexandria.ui.displays.notifiers.MaterialIconNotifier, B>  {

							public _35_6_1132494945(B box) {
								super(box);

								_color("white");
								_icon("Home");
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

						public class _36_6_02039091381 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

							public _36_6_02039091381(B box) {
								super(box);

								_color("white");
								_value("Inicio");
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

					public class CompetitionsOpt extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B> implements io.intino.alexandria.ui.displays.components.selector.SelectorOption {
						public AppTemplate._27_1_0898319770._31_2_01811349954._32_3_11424894600.Menu.CompetitionsOpt. _38_6_1225078887 _38_6_1225078887;
						public AppTemplate._27_1_0898319770._31_2_01811349954._32_3_11424894600.Menu.CompetitionsOpt. _39_6_11345121768 _39_6_11345121768;

						public CompetitionsOpt(B box) {
							super(box);

							name("competitionsOpt");
						}

						@Override
						public void init() {
							super.init();
							if (_38_6_1225078887 == null) _38_6_1225078887 = register(new _38_6_1225078887(box()).<_38_6_1225078887>id("a1581218797").owner(AbstractAppTemplate.this));
							if (_39_6_11345121768 == null) _39_6_11345121768 = register(new _39_6_11345121768(box()).<_39_6_11345121768>id("a_108031429").owner(AbstractAppTemplate.this));
						}

						@Override
						public void unregister() {
							super.unregister();
							if (_38_6_1225078887 != null) _38_6_1225078887.unregister();
							if (_39_6_11345121768 != null) _39_6_11345121768.unregister();
						}

						public class _38_6_1225078887 extends io.intino.alexandria.ui.displays.components.Icon<io.intino.alexandria.ui.displays.notifiers.IconNotifier, B>  {

							public _38_6_1225078887(B box) {
								super(box);

								_color("white");
								_icon(AbstractAppTemplate.class.getResource("/icons/menu/leaderboard.png"));
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

						public class _39_6_11345121768 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

							public _39_6_11345121768(B box) {
								super(box);

								_color("white");
								_value("Competiciones");
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

					public class TeamsOpt extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B> implements io.intino.alexandria.ui.displays.components.selector.SelectorOption {
						public AppTemplate._27_1_0898319770._31_2_01811349954._32_3_11424894600.Menu.TeamsOpt. _41_6_11687601513 _41_6_11687601513;
						public AppTemplate._27_1_0898319770._31_2_01811349954._32_3_11424894600.Menu.TeamsOpt. _42_6_11896789298 _42_6_11896789298;

						public TeamsOpt(B box) {
							super(box);

							name("teamsOpt");
						}

						@Override
						public void init() {
							super.init();
							if (_41_6_11687601513 == null) _41_6_11687601513 = register(new _41_6_11687601513(box()).<_41_6_11687601513>id("a1560214406").owner(AbstractAppTemplate.this));
							if (_42_6_11896789298 == null) _42_6_11896789298 = register(new _42_6_11896789298(box()).<_42_6_11896789298>id("a344416960").owner(AbstractAppTemplate.this));
						}

						@Override
						public void unregister() {
							super.unregister();
							if (_41_6_11687601513 != null) _41_6_11687601513.unregister();
							if (_42_6_11896789298 != null) _42_6_11896789298.unregister();
						}

						public class _41_6_11687601513 extends io.intino.alexandria.ui.displays.components.Icon<io.intino.alexandria.ui.displays.notifiers.IconNotifier, B>  {

							public _41_6_11687601513(B box) {
								super(box);

								_color("white");
								_icon(AbstractAppTemplate.class.getResource("/icons/menu/shield.png"));
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

						public class _42_6_11896789298 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

							public _42_6_11896789298(B box) {
								super(box);

								_color("white");
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
					}
				}
			}

			public class _43_3_0128459239 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
				public AppTemplate._27_1_0898319770._31_2_01811349954._43_3_0128459239. Loading loading;
				public AppTemplate._27_1_0898319770._31_2_01811349954._43_3_0128459239. UpdateRequiredPage updateRequiredPage;
				public AppTemplate._27_1_0898319770._31_2_01811349954._43_3_0128459239. OverviewPage overviewPage;
				public AppTemplate._27_1_0898319770._31_2_01811349954._43_3_0128459239. CompetitionsPage competitionsPage;
				public AppTemplate._27_1_0898319770._31_2_01811349954._43_3_0128459239. CompetitionPage competitionPage;
				public AppTemplate._27_1_0898319770._31_2_01811349954._43_3_0128459239. TeamsPage teamsPage;
				public AppTemplate._27_1_0898319770._31_2_01811349954._43_3_0128459239. TeamPage teamPage;
				public AppTemplate._27_1_0898319770._31_2_01811349954._43_3_0128459239. MatchPage matchPage;

				public _43_3_0128459239(B box) {
					super(box);
				}

				@Override
				public void init() {
					super.init();
					if (loading == null) loading = register(new Loading(box()).<Loading>id("a_874446021").owner(AbstractAppTemplate.this));
					if (updateRequiredPage == null) updateRequiredPage = register(new UpdateRequiredPage(box()).<UpdateRequiredPage>id("a997636824").owner(AbstractAppTemplate.this));
					if (overviewPage == null) overviewPage = register(new OverviewPage(box()).<OverviewPage>id("a1399432457").owner(AbstractAppTemplate.this));
					if (competitionsPage == null) competitionsPage = register(new CompetitionsPage(box()).<CompetitionsPage>id("a_999178204").owner(AbstractAppTemplate.this));
					if (competitionPage == null) competitionPage = register(new CompetitionPage(box()).<CompetitionPage>id("a_864541715").owner(AbstractAppTemplate.this));
					if (teamsPage == null) teamsPage = register(new TeamsPage(box()).<TeamsPage>id("a_86002780").owner(AbstractAppTemplate.this));
					if (teamPage == null) teamPage = register(new TeamPage(box()).<TeamPage>id("a_557989779").owner(AbstractAppTemplate.this));
					if (matchPage == null) matchPage = register(new MatchPage(box()).<MatchPage>id("a686220339").owner(AbstractAppTemplate.this));
				}

				@Override
				public void unregister() {
					super.unregister();
					if (loading != null) loading.unregister();
					if (updateRequiredPage != null) updateRequiredPage.unregister();
					if (overviewPage != null) overviewPage.unregister();
					if (competitionsPage != null) competitionsPage.unregister();
					if (competitionPage != null) competitionPage.unregister();
					if (teamsPage != null) teamsPage.unregister();
					if (teamPage != null) teamPage.unregister();
					if (matchPage != null) matchPage.unregister();
				}

				public class Loading extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
					public AppTemplate._27_1_0898319770._31_2_01811349954._43_3_0128459239.Loading. _44_59_039976812 _44_59_039976812;

					public Loading(B box) {
						super(box);
					}

					@Override
					public void init() {
						super.init();
						if (_44_59_039976812 == null) _44_59_039976812 = register(new _44_59_039976812(box()).<_44_59_039976812>id("a_1371944864").owner(AbstractAppTemplate.this));
					}

					@Override
					public void unregister() {
						super.unregister();
						if (_44_59_039976812 != null) _44_59_039976812.unregister();
					}

					public class _44_59_039976812 extends io.intino.alexandria.ui.displays.components.Spinner<io.intino.alexandria.ui.displays.notifiers.SpinnerNotifier, B>  {

						public _44_59_039976812(B box) {
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

				public class UpdateRequiredPage extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
					public AppTemplate._27_1_0898319770._31_2_01811349954._43_3_0128459239.UpdateRequiredPage. _47_5_11228315650 _47_5_11228315650;
					public AppTemplate._27_1_0898319770._31_2_01811349954._43_3_0128459239.UpdateRequiredPage. ReloadPage reloadPage;

					public UpdateRequiredPage(B box) {
						super(box);
					}

					@Override
					public void init() {
						super.init();
						if (_47_5_11228315650 == null) _47_5_11228315650 = register(new _47_5_11228315650(box()).<_47_5_11228315650>id("a1483162916").owner(AbstractAppTemplate.this));
						if (reloadPage == null) reloadPage = register(new ReloadPage(box()).<ReloadPage>id("a_1519990897").owner(AbstractAppTemplate.this));
					}

					@Override
					public void unregister() {
						super.unregister();
						if (_47_5_11228315650 != null) _47_5_11228315650.unregister();
						if (reloadPage != null) reloadPage.unregister();
					}

					public class _47_5_11228315650 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

						public _47_5_11228315650(B box) {
							super(box);
							_value("Hay una actualización pendiente. No se puede acceder en estos momentos. Inténtelo más tarde.");
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

					public class ReloadPage extends io.intino.alexandria.ui.displays.components.Action<io.intino.alexandria.ui.displays.notifiers.ActionNotifier, B>  {

						public ReloadPage(B box) {
							super(box);
							_title("Intentar de nuevo");
							_mode(io.intino.alexandria.ui.displays.components.Actionable.Mode.valueOf("Link"));
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

				public class OverviewPage extends io.intino.alexandria.ui.displays.components.BlockConditional<io.intino.alexandria.ui.displays.notifiers.BlockConditionalNotifier, B>  {
					public OverviewTemplate overviewStamp;

					public OverviewPage(B box) {
						super(box);
					}

					@Override
					public void initConditional() {
						super.init();
						if (overviewStamp == null) overviewStamp = AbstractAppTemplate.this.overviewStamp = register(new OverviewTemplate((ProtrixBox)box()).id("a744414484"));
						if (AbstractAppTemplate.this.overviewStamp == null) AbstractAppTemplate.this.overviewStamp = _27_1_0898319770._31_2_01811349954._43_3_0128459239.overviewPage.overviewStamp;
					}

					@Override
					public void unregister() {
						super.unregister();
						if (overviewStamp != null) overviewStamp.unregister();
					}
				}

				public class CompetitionsPage extends io.intino.alexandria.ui.displays.components.BlockConditional<io.intino.alexandria.ui.displays.notifiers.BlockConditionalNotifier, B>  {
					public CompetitionsTemplate competitionsStamp;

					public CompetitionsPage(B box) {
						super(box);
					}

					@Override
					public void initConditional() {
						super.init();
						if (competitionsStamp == null) competitionsStamp = AbstractAppTemplate.this.competitionsStamp = register(new CompetitionsTemplate((ProtrixBox)box()).id("a1558876724"));
						if (AbstractAppTemplate.this.competitionsStamp == null) AbstractAppTemplate.this.competitionsStamp = _27_1_0898319770._31_2_01811349954._43_3_0128459239.competitionsPage.competitionsStamp;
					}

					@Override
					public void unregister() {
						super.unregister();
						if (competitionsStamp != null) competitionsStamp.unregister();
					}
				}

				public class CompetitionPage extends io.intino.alexandria.ui.displays.components.BlockConditional<io.intino.alexandria.ui.displays.notifiers.BlockConditionalNotifier, B>  {
					public CompetitionTemplate competitionStamp;

					public CompetitionPage(B box) {
						super(box);
					}

					@Override
					public void initConditional() {
						super.init();
						if (competitionStamp == null) competitionStamp = AbstractAppTemplate.this.competitionStamp = register(new CompetitionTemplate((ProtrixBox)box()).id("a1918662486"));
						if (AbstractAppTemplate.this.competitionStamp == null) AbstractAppTemplate.this.competitionStamp = _27_1_0898319770._31_2_01811349954._43_3_0128459239.competitionPage.competitionStamp;
					}

					@Override
					public void unregister() {
						super.unregister();
						if (competitionStamp != null) competitionStamp.unregister();
					}
				}

				public class TeamsPage extends io.intino.alexandria.ui.displays.components.BlockConditional<io.intino.alexandria.ui.displays.notifiers.BlockConditionalNotifier, B>  {
					public TeamsTemplate teamsStamp;

					public TeamsPage(B box) {
						super(box);
					}

					@Override
					public void initConditional() {
						super.init();
						if (teamsStamp == null) teamsStamp = AbstractAppTemplate.this.teamsStamp = register(new TeamsTemplate((ProtrixBox)box()).id("a347348776"));
						if (AbstractAppTemplate.this.teamsStamp == null) AbstractAppTemplate.this.teamsStamp = _27_1_0898319770._31_2_01811349954._43_3_0128459239.teamsPage.teamsStamp;
					}

					@Override
					public void unregister() {
						super.unregister();
						if (teamsStamp != null) teamsStamp.unregister();
					}
				}

				public class TeamPage extends io.intino.alexandria.ui.displays.components.BlockConditional<io.intino.alexandria.ui.displays.notifiers.BlockConditionalNotifier, B>  {
					public TeamTemplate teamStamp;

					public TeamPage(B box) {
						super(box);
					}

					@Override
					public void initConditional() {
						super.init();
						if (teamStamp == null) teamStamp = AbstractAppTemplate.this.teamStamp = register(new TeamTemplate((ProtrixBox)box()).id("a_569615852"));
						if (AbstractAppTemplate.this.teamStamp == null) AbstractAppTemplate.this.teamStamp = _27_1_0898319770._31_2_01811349954._43_3_0128459239.teamPage.teamStamp;
					}

					@Override
					public void unregister() {
						super.unregister();
						if (teamStamp != null) teamStamp.unregister();
					}
				}

				public class MatchPage extends io.intino.alexandria.ui.displays.components.BlockConditional<io.intino.alexandria.ui.displays.notifiers.BlockConditionalNotifier, B>  {
					public MatchTemplate matchStamp;

					public MatchPage(B box) {
						super(box);
					}

					@Override
					public void initConditional() {
						super.init();
						if (matchStamp == null) matchStamp = AbstractAppTemplate.this.matchStamp = register(new MatchTemplate((ProtrixBox)box()).id("a_630640502"));
						if (AbstractAppTemplate.this.matchStamp == null) AbstractAppTemplate.this.matchStamp = _27_1_0898319770._31_2_01811349954._43_3_0128459239.matchPage.matchStamp;
					}

					@Override
					public void unregister() {
						super.unregister();
						if (matchStamp != null) matchStamp.unregister();
					}
				}
			}
		}
	}
}