package pairmaker.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Participant {

  private String name;
}


//  private Participant(String name) {
//    this.name = name;
//  }
//
//  public static ParticipantBuilder builder() {
//    return new ParticipantBuilder();
//  }
//
//  private static class ParticipantBuilder {
//
//    private String name;
//
//    private ParticipantBuilder() {
//
//    }
//
//    public ParticipantBuilder name(String name) {
//      this.name = name;
//      return this;
//    }
//
//    public Participant build() {
//      return new Participant(name);
//    }
//  }
