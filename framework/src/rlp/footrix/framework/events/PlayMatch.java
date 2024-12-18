package rlp.footrix.framework.events;

import com.google.gson.Gson;
import rlp.footrix.framework.Json;
import rlp.footrix.framework.types.Match;
import rlp.footrix.framework.types.definitions.MatchDefinition;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;

public class PlayMatch extends Event {

    private final MatchDefinition definition;
    private final String matchFilePath;
    private Match match;

    public PlayMatch(MatchDefinition definition, File matchFilePath) {
        super(definition.date());
        this.definition = definition;
        this.matchFilePath = matchFilePath.getAbsolutePath();
    }

    @Override
    public boolean preconditions() {
        try {
            match = Json.fromJson(Files.readString(Path.of(URI.create(matchFilePath))), Match.class);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    @Override
    public void execute() {
        //TODO: ESTO HACE EFECTO SOBRE LOS JUGADORES
    }
}
