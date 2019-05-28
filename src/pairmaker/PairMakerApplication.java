package pairmaker;

import pairmaker.controller.PairMaker;
import pairmaker.controller.ParticipantReader;
import pairmaker.model.Pair;
import pairmaker.model.Participant;
import pairmaker.view.Screen;

import java.util.List;

public class PairMakerApplication {
  public static void main(String[] args) {
    String filePath = "pairmaker/Files/participants.txt";
    List<Participant> participants = ParticipantReader.asList(filePath);
    List<Pair> pairs = PairMaker.create(participants);
    Screen.display(pairs);
  }
}

//  The coffee can problem
//    Suppose you have a coffee can which contains an unknown number of black beans and an unknown number of white beans. Repeat the following process until exactly one bean remains: Select two beans from the can at random. If they are both the same color, throw them both out, but insert another black bean. If they are different colors, throw the black one away, but return the white one. Prove that this process terminates with exactly one bean left.
//
//    What can you deduce about the color of the last bean as a function of the initial number of black and white beans?
//
//    Test every single piece of logic in your programm.
//    Test methods that manipulate data
//    Test smaller private methods by leaving their visibility as default
//    Keep tests clean by using parameterized tests and other useful JUnit features
//
//  Apply the following design principles and patterns to the solution:
//  KISS (Keep It Simple Stupid)
//  DRY (Don’t Repeat Yourself)
//  SLAP (Single Level of Abstraction Principle)
//  SRP (Single Responsibility Principle)
//  OCP (Open/Close Principle)
//  Singleton/Utility class pattern
//  Mutable class/Data class pattern
//  Immutable class/Value class pattern
//  Builder pattern
//  MVC (Model View Controller)
//
//    Hints:
//      Find a way to generate coffee beans randomly
//      The process of putting beans in the can and filter them until there is one left should be repeatable
//      The results of the filtering should be remembered so we can calculate and present statistics
//
//    Requirements:
//      We want to provide the number of repetitions of this coffee bean process and we want to receive statistics about each individual try, and the overall statistics
//      For each individual try we want to know how many coffee beans were white and black, the percentage ratio between them (as in white ratio 54.17% and black ratio 45.83%), and which was the colour of the last one
//      For the overall statistics we want to know how many tries were performed, how many total black and white beans were generated with their percentage ratios, and how many times was the last bean black or white with their percentage ratios as well
//
//    Restrictions:
//      You’re not allowed to use System.out prints
//      You’re allowed to write the results in a file
//
//------------------------------------------------------
//Number of tries: 10
//Total number of white beans: 50104
//Total number of black beans: 49896
//Number of times where the last bean was white: 8
//Number of times where the last bean was black: 2
//Total bean ratio: 50.104% white 49.896 % black
//Total last bean ratio: 80.0% white 20.0 % black
//-------------------------------------------------------
