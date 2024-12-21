package rlp.footrix.framework;

import rlp.footrix.framework.configuration.DataBase;
import rlp.footrix.framework.events.Event;
import rlp.footrix.framework.var.Var;

import java.time.Instant;
import java.util.List;

public interface FootrixConfiguration {
    Instant initDate();
    String initSeason();
    DataBase initDatabase();
    List<Event> initEvents();
    Var var();
}
