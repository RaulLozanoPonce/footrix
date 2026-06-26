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

public abstract class AbstractMatchLineupPinTemplate<B extends Box> extends io.intino.alexandria.ui.displays.components.Template<TemplateNotifier, java.lang.Void, B> {
	public _115_1_01461012100 _115_1_01461012100;
	public MatchLineupPinTemplate._115_1_01461012100. _116_2_014651816 _116_2_014651816;
	public MatchLineupPinTemplate._115_1_01461012100._116_2_014651816. GoalsIcon goalsIcon;
	public MatchLineupPinTemplate._115_1_01461012100._116_2_014651816. AssistsIcon assistsIcon;
	public MatchLineupPinTemplate._115_1_01461012100._116_2_014651816. Goals goals;
	public MatchLineupPinTemplate._115_1_01461012100._116_2_014651816. Assists assists;
	public MatchLineupPinTemplate._115_1_01461012100. _121_2_0764350777 _121_2_0764350777;
	public MatchLineupPinTemplate._115_1_01461012100._121_2_0764350777. Position position;
	public MatchLineupPinTemplate._115_1_01461012100. _123_2_01488047461 _123_2_01488047461;
	public MatchLineupPinTemplate._115_1_01461012100._123_2_01488047461. Score score;
	public _125_1_1459558078 _125_1_1459558078;
	public MatchLineupPinTemplate._125_1_1459558078. _126_2_11968070735 _126_2_11968070735;
	public MatchLineupPinTemplate._125_1_1459558078._126_2_11968070735. Exits exits;
	public MatchLineupPinTemplate._125_1_1459558078. _128_2_1873606005 _128_2_1873606005;
	public MatchLineupPinTemplate._125_1_1459558078._128_2_1873606005. Number number;
	public MatchLineupPinTemplate._125_1_1459558078. _130_2_01902072984 _130_2_01902072984;
	public MatchLineupPinTemplate._125_1_1459558078._130_2_01902072984. YellowCardsIcon yellowCardsIcon;
	public MatchLineupPinTemplate._125_1_1459558078._130_2_01902072984. RedCardsIcon redCardsIcon;
	public _133_1_0774853936 _133_1_0774853936;
	public MatchLineupPinTemplate._133_1_0774853936. Name name;

	public AbstractMatchLineupPinTemplate(B box) {
		super(box);
		id("matchLineupPinTemplate");
	}

	@Override
	public void init() {
		super.init();
		if (_115_1_01461012100 == null) _115_1_01461012100 = register(new _115_1_01461012100(box()).<_115_1_01461012100>id("a1585606140").owner(AbstractMatchLineupPinTemplate.this));
		if (_115_1_01461012100 != null) _116_2_014651816 = _115_1_01461012100._116_2_014651816;
		if (_116_2_014651816 != null) goalsIcon = _115_1_01461012100._116_2_014651816.goalsIcon;
		if (_116_2_014651816 != null) assistsIcon = _115_1_01461012100._116_2_014651816.assistsIcon;
		if (_116_2_014651816 != null) goals = _115_1_01461012100._116_2_014651816.goals;
		if (_116_2_014651816 != null) assists = _115_1_01461012100._116_2_014651816.assists;
		if (_115_1_01461012100 != null) _121_2_0764350777 = _115_1_01461012100._121_2_0764350777;
		if (_121_2_0764350777 != null) position = _115_1_01461012100._121_2_0764350777.position;
		if (_115_1_01461012100 != null) _123_2_01488047461 = _115_1_01461012100._123_2_01488047461;
		if (_123_2_01488047461 != null) score = _115_1_01461012100._123_2_01488047461.score;
		if (_125_1_1459558078 == null) _125_1_1459558078 = register(new _125_1_1459558078(box()).<_125_1_1459558078>id("a880127891").owner(AbstractMatchLineupPinTemplate.this));
		if (_125_1_1459558078 != null) _126_2_11968070735 = _125_1_1459558078._126_2_11968070735;
		if (_126_2_11968070735 != null) exits = _125_1_1459558078._126_2_11968070735.exits;
		if (_125_1_1459558078 != null) _128_2_1873606005 = _125_1_1459558078._128_2_1873606005;
		if (_128_2_1873606005 != null) number = _125_1_1459558078._128_2_1873606005.number;
		if (_125_1_1459558078 != null) _130_2_01902072984 = _125_1_1459558078._130_2_01902072984;
		if (_130_2_01902072984 != null) yellowCardsIcon = _125_1_1459558078._130_2_01902072984.yellowCardsIcon;
		if (_130_2_01902072984 != null) redCardsIcon = _125_1_1459558078._130_2_01902072984.redCardsIcon;
		if (_133_1_0774853936 == null) _133_1_0774853936 = register(new _133_1_0774853936(box()).<_133_1_0774853936>id("a1601763648").owner(AbstractMatchLineupPinTemplate.this));
		if (_133_1_0774853936 != null) name = _133_1_0774853936.name;
	}

	@Override
	public void remove() {
		super.remove();
		if (_115_1_01461012100 != null) _115_1_01461012100.unregister();
		if (_125_1_1459558078 != null) _125_1_1459558078.unregister();
		if (_133_1_0774853936 != null) _133_1_0774853936.unregister();
	}

	public class _115_1_01461012100 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
		public MatchLineupPinTemplate._115_1_01461012100. _116_2_014651816 _116_2_014651816;
		public MatchLineupPinTemplate._115_1_01461012100. _121_2_0764350777 _121_2_0764350777;
		public MatchLineupPinTemplate._115_1_01461012100. _123_2_01488047461 _123_2_01488047461;

		public _115_1_01461012100(B box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (_116_2_014651816 == null) _116_2_014651816 = register(new _116_2_014651816(box()).<_116_2_014651816>id("a_633145413").owner(AbstractMatchLineupPinTemplate.this));
			if (_121_2_0764350777 == null) _121_2_0764350777 = register(new _121_2_0764350777(box()).<_121_2_0764350777>id("a989730743").owner(AbstractMatchLineupPinTemplate.this));
			if (_123_2_01488047461 == null) _123_2_01488047461 = register(new _123_2_01488047461(box()).<_123_2_01488047461>id("a_1779555736").owner(AbstractMatchLineupPinTemplate.this));
		}

		@Override
		public void unregister() {
			super.unregister();
			if (_116_2_014651816 != null) _116_2_014651816.unregister();
			if (_121_2_0764350777 != null) _121_2_0764350777.unregister();
			if (_123_2_01488047461 != null) _123_2_01488047461.unregister();
		}

		public class _116_2_014651816 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
			public MatchLineupPinTemplate._115_1_01461012100._116_2_014651816. GoalsIcon goalsIcon;
			public MatchLineupPinTemplate._115_1_01461012100._116_2_014651816. AssistsIcon assistsIcon;
			public MatchLineupPinTemplate._115_1_01461012100._116_2_014651816. Goals goals;
			public MatchLineupPinTemplate._115_1_01461012100._116_2_014651816. Assists assists;

			public _116_2_014651816(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (goalsIcon == null) goalsIcon = register(new GoalsIcon(box()).<GoalsIcon>id("a254744905").owner(AbstractMatchLineupPinTemplate.this));
				if (assistsIcon == null) assistsIcon = register(new AssistsIcon(box()).<AssistsIcon>id("a_755744845").owner(AbstractMatchLineupPinTemplate.this));
				if (goals == null) goals = register(new Goals(box()).<Goals>id("a_1652801360").owner(AbstractMatchLineupPinTemplate.this));
				if (assists == null) assists = register(new Assists(box()).<Assists>id("a_103207910").owner(AbstractMatchLineupPinTemplate.this));
			}

			@Override
			public void unregister() {
				super.unregister();
				if (goalsIcon != null) goalsIcon.unregister();
				if (assistsIcon != null) assistsIcon.unregister();
				if (goals != null) goals.unregister();
				if (assists != null) assists.unregister();
			}

			public class GoalsIcon extends io.intino.alexandria.ui.displays.components.Icon<io.intino.alexandria.ui.displays.notifiers.IconNotifier, B>  {

				public GoalsIcon(B box) {
					super(box);
					_icon(AbstractMatchLineupPinTemplate.class.getResource("/icons/goal.png"));
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

			public class AssistsIcon extends io.intino.alexandria.ui.displays.components.Icon<io.intino.alexandria.ui.displays.notifiers.IconNotifier, B>  {

				public AssistsIcon(B box) {
					super(box);
					_icon(AbstractMatchLineupPinTemplate.class.getResource("/icons/assist.png"));
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

			public class Goals extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

				public Goals(B box) {
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

			public class Assists extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

				public Assists(B box) {
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

		public class _121_2_0764350777 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
			public MatchLineupPinTemplate._115_1_01461012100._121_2_0764350777. Position position;

			public _121_2_0764350777(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (position == null) position = register(new Position(box()).<Position>id("a1274028511").owner(AbstractMatchLineupPinTemplate.this));
			}

			@Override
			public void unregister() {
				super.unregister();
				if (position != null) position.unregister();
			}

			public class Position extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

				public Position(B box) {
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
				public Position textColor(String color) {
					this._textColor(color);
					this._refreshHighlight();
					return this;
				}

				public Position backgroundColor(String color) {
					this._backgroundColor(color);
					this._refreshHighlight();
					return this;
				}
			}
		}

		public class _123_2_01488047461 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
			public MatchLineupPinTemplate._115_1_01461012100._123_2_01488047461. Score score;

			public _123_2_01488047461(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (score == null) score = register(new Score(box()).<Score>id("a_711180386").owner(AbstractMatchLineupPinTemplate.this));
			}

			@Override
			public void unregister() {
				super.unregister();
				if (score != null) score.unregister();
			}

			public class Score extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

				public Score(B box) {
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
				public Score textColor(String color) {
					this._textColor(color);
					this._refreshHighlight();
					return this;
				}

				public Score backgroundColor(String color) {
					this._backgroundColor(color);
					this._refreshHighlight();
					return this;
				}
			}
		}
	}

	public class _125_1_1459558078 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
		public MatchLineupPinTemplate._125_1_1459558078. _126_2_11968070735 _126_2_11968070735;
		public MatchLineupPinTemplate._125_1_1459558078. _128_2_1873606005 _128_2_1873606005;
		public MatchLineupPinTemplate._125_1_1459558078. _130_2_01902072984 _130_2_01902072984;

		public _125_1_1459558078(B box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (_126_2_11968070735 == null) _126_2_11968070735 = register(new _126_2_11968070735(box()).<_126_2_11968070735>id("a_1739480760").owner(AbstractMatchLineupPinTemplate.this));
			if (_128_2_1873606005 == null) _128_2_1873606005 = register(new _128_2_1873606005(box()).<_128_2_1873606005>id("a_1359488291").owner(AbstractMatchLineupPinTemplate.this));
			if (_130_2_01902072984 == null) _130_2_01902072984 = register(new _130_2_01902072984(box()).<_130_2_01902072984>id("a489606906").owner(AbstractMatchLineupPinTemplate.this));
		}

		@Override
		public void unregister() {
			super.unregister();
			if (_126_2_11968070735 != null) _126_2_11968070735.unregister();
			if (_128_2_1873606005 != null) _128_2_1873606005.unregister();
			if (_130_2_01902072984 != null) _130_2_01902072984.unregister();
		}

		public class _126_2_11968070735 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
			public MatchLineupPinTemplate._125_1_1459558078._126_2_11968070735. Exits exits;

			public _126_2_11968070735(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (exits == null) exits = register(new Exits(box()).<Exits>id("a_1850885852").owner(AbstractMatchLineupPinTemplate.this));
			}

			@Override
			public void unregister() {
				super.unregister();
				if (exits != null) exits.unregister();
			}

			public class Exits extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

				public Exits(B box) {
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
				public Exits textColor(String color) {
					this._textColor(color);
					this._refreshHighlight();
					return this;
				}

				public Exits backgroundColor(String color) {
					this._backgroundColor(color);
					this._refreshHighlight();
					return this;
				}
			}
		}

		public class _128_2_1873606005 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
			public MatchLineupPinTemplate._125_1_1459558078._128_2_1873606005. Number number;

			public _128_2_1873606005(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (number == null) number = register(new Number(box()).<Number>id("a_1680920232").owner(AbstractMatchLineupPinTemplate.this));
			}

			@Override
			public void unregister() {
				super.unregister();
				if (number != null) number.unregister();
			}

			public class Number extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

				public Number(B box) {
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

		public class _130_2_01902072984 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
			public MatchLineupPinTemplate._125_1_1459558078._130_2_01902072984. YellowCardsIcon yellowCardsIcon;
			public MatchLineupPinTemplate._125_1_1459558078._130_2_01902072984. RedCardsIcon redCardsIcon;

			public _130_2_01902072984(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (yellowCardsIcon == null) yellowCardsIcon = register(new YellowCardsIcon(box()).<YellowCardsIcon>id("a_595624048").owner(AbstractMatchLineupPinTemplate.this));
				if (redCardsIcon == null) redCardsIcon = register(new RedCardsIcon(box()).<RedCardsIcon>id("a542762691").owner(AbstractMatchLineupPinTemplate.this));
			}

			@Override
			public void unregister() {
				super.unregister();
				if (yellowCardsIcon != null) yellowCardsIcon.unregister();
				if (redCardsIcon != null) redCardsIcon.unregister();
			}

			public class YellowCardsIcon extends io.intino.alexandria.ui.displays.components.Icon<io.intino.alexandria.ui.displays.notifiers.IconNotifier, B>  {

				public YellowCardsIcon(B box) {
					super(box);
					_icon(AbstractMatchLineupPinTemplate.class.getResource("/icons/yellow-card.png"));
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

			public class RedCardsIcon extends io.intino.alexandria.ui.displays.components.Icon<io.intino.alexandria.ui.displays.notifiers.IconNotifier, B>  {

				public RedCardsIcon(B box) {
					super(box);
					_icon(AbstractMatchLineupPinTemplate.class.getResource("/icons/red-card.png"));
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

	public class _133_1_0774853936 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
		public MatchLineupPinTemplate._133_1_0774853936. Name name;

		public _133_1_0774853936(B box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (name == null) name = register(new Name(box()).<Name>id("a_750797215").owner(AbstractMatchLineupPinTemplate.this));
		}

		@Override
		public void unregister() {
			super.unregister();
			if (name != null) name.unregister();
		}

		public class Name extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

			public Name(B box) {
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
			public Name textColor(String color) {
				this._textColor(color);
				this._refreshHighlight();
				return this;
			}

			public Name backgroundColor(String color) {
				this._backgroundColor(color);
				this._refreshHighlight();
				return this;
			}
		}
	}
}