package rlp.footrix.framework.stores;

import rlp.footrix.framework.Json;
import rlp.footrix.framework.types.Match;
import rlp.footrix.framework.types.definitions.MatchDefinition;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.WRITE;

public class MatchFileStore {

    public void save(Match match) throws IOException {
        File matchFile = matchFileOf(match.definition());
        create(matchFile);
        Files.writeString(matchFile.toPath(), Json.toJson(match), CREATE, WRITE);
    }

    public List<Match> get(String competition, String season, int phaseId, int groupId) {
        File folder = new File("./temp/matches/" + season + "/" + competition + "/" + phaseId + "/" + groupId + "/");
        return Arrays.stream(Objects.requireNonNull(folder.listFiles())).map(this::matchOf).toList();
    }

    private File matchFileOf(MatchDefinition definition) {
        //TODO
        return new File("./temp/matches/" + definition.season() + "/" + definition.competition() + "/" + definition.phase() + "/" + definition.group() + "/" + definition.local() + "-" + definition.visitant() + ".jsonl");
    }

    private void create(File file) throws IOException {
        if (file.exists()) return;
        create(file.getParentFile());
        if (!file.getName().endsWith("jsonl")) {
            Files.createDirectory(file.toPath());
        }
    }

    private Match matchOf(File file) {
        try {
            return Json.fromJson(Files.readString(file.toPath()), Match.class);
        } catch (Throwable t) {
            System.out.println(t.getMessage());
        }
        return null;
    }
}
