package pairmaker.controller;

import pairmaker.model.Participant;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@UtilityClass
public class ParticipantReader {

  public List<Participant> asList(String filePath) {
    List<Participant> participants = FileReader.lines(filePath)
                                               .map(toParticipant())
                                               .collect(Collectors.toList());
    return participants;
  }

  private Function<String, Participant> toParticipant() {
    return line -> Participant.builder()
                              .name(line)
                              .build();
  }
}
