package rlp.footrix.protrix.box.ui.displays.templates;

import rlp.footrix.framework.types.records.TeamMatchRecord;
import rlp.footrix.protrix.box.ProtrixBox;

import java.util.List;
import java.util.stream.Collectors;

public class ClassificationTemplate extends AbstractClassificationTemplate<ProtrixBox> {

	public ClassificationTemplate(ProtrixBox box) {
		super(box);
	}

	public void setParameters(String competitionId, int season) {
        List<ClassificationRowTemplate.TeamMatchRecordRow> records = groupedRecords(competitionId, season);
		for (int i = 0; i < records.size(); i++) classificationRowStamp.add().results(i + 1, records.get(i));
	}

    private List<ClassificationRowTemplate.TeamMatchRecordRow> groupedRecords(String competitionId, int season) {
        return box().application().recordStore().teamMatchRecords().stream()
                .filter(r -> r.competition().equals(competitionId))
                .filter(r -> r.season() == season)
                .collect(Collectors.groupingBy(TeamMatchRecord::team))
                .values().stream()
                .map(this::recordOf)
                .sorted((r1, r2) -> Integer.compare(r2.points(), r1.points()))
                .toList();
    }

    private ClassificationRowTemplate.TeamMatchRecordRow recordOf(List<TeamMatchRecord> records) {
        return new ClassificationRowTemplate.TeamMatchRecordRow(
                records.getFirst().team(),
                (int) records.stream().filter(r -> r.streak() == 1).count(),
                (int) records.stream().filter(r -> r.streak() == 0).count(),
                (int) records.stream().filter(r -> r.streak() == -1).count(),
                records.stream().mapToInt(TeamMatchRecord::goalsFor).sum(),
                records.stream().mapToInt(TeamMatchRecord::goalsAgainst).sum(),
                records.stream().mapToInt(TeamMatchRecord::points).sum()
        );
    }
}