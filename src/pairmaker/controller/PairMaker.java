package pairmaker.controller;

import pairmaker.model.Pair;
import pairmaker.model.Participant;
import lombok.experimental.UtilityClass;

import java.util.*;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@UtilityClass
public class PairMaker {

  public List<Pair> create(List<Participant> participants) {

    if (participants.size() < 2) {
      return new ArrayList<>();
    }
    Queue<Participant> shuffled = shuffle(participants);
    List<Pair> pairs = toPairs(shuffled);
    addLastParticipant(pairs, shuffled);
    return pairs;
  }

  private Queue<Participant> shuffle(List<Participant> participants) {
    List<Participant> shuffled = new LinkedList<>(participants);
    Collections.shuffle(shuffled);
    return (Queue) shuffled;
  }

  private List<Pair> toPairs(Queue<Participant> participants) {
    return IntStream.generate(() -> 0)
                    .takeWhile(n -> participants.size() > 1)
                    .mapToObj(toPair(participants))
                    .collect(Collectors.toList());
  }

  private IntFunction<Pair> toPair(Queue<Participant> participants) {
    return n -> Pair.builder()
                    .participants(takeTwoParticipants(participants))
                    .build();
  }

  private List<Participant> takeTwoParticipants(Queue<Participant> participants) {
    return Stream.of(participants.poll(),
        participants.poll())
                 .collect(Collectors.toList());
  }

  private void addLastParticipant(List<Pair> pairs, Queue<Participant> participants) {
    if (participants.isEmpty()) {
      return;
    }

    Pair firstPair = pairs.get(0);
    Participant lastParticipant = participants.poll();
    firstPair.getParticipants().add(lastParticipant);
  }
}