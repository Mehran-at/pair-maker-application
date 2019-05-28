package pairmaker.view;

import pairmaker.model.Pair;
import pairmaker.model.Participant;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.function.Consumer;

import static java.util.stream.Collectors.joining;

@UtilityClass
public class Screen {

  public void display(List<Pair> pairs) {
    System.out.println("\n\n----Pairs----");
    pairs.forEach(display());
    System.out.println("\n----Pairs----");
  }

  private Consumer<Pair> display() {
    return pair -> {
      String names = pair.getParticipants().stream()
                         .map(Participant::getName)
                         .collect(joining(", "));
      System.out.println(names);
    };
  }
}