/**
 * Emanuel Juarez
 * CS 240.01
 * 05/09/16
 * Assignment 3
 *
 * Copyright 2016: smanna@cpp.edu
 * CS 240 Spring 2016
 *
 * STUDENTS SHOULD COMPLETE THIS CODE.
 * You will upload this code to Blackboard.
 *
 * If you do not write enough comments, at least two points
 * will be deducted from your assignment. Also make sure you
 * follow the coding conventions.
 *
 * The main aim is to simulate a HotPotato game using
 * Queue. Please read through the details from the instructions.
 *
 */

public class HotPotato
{
  //not really necessary, but looks cleaner in my opinion
  private String winner;

  // set winner to null
  public HotPotato()
  {
    winner = null;
  }

  /** Simulating HotPotato game.
   *  @param names Takes names of players
   *  @param num   number of times the potato is passed
   *  @return the name of the winner
   */
  public String play(Queue<String> names, int num)
  {
    //repeat the process until the queue has only one name
    while (names.size() != 1)
    {
      //loop through num number of times, enqueue the person who has been removed from the front
      for (int i = 0; i < num; i++)
        names.enqueue(names.dequeue());
      //after looping num number of times, remove the front person from the queue
      names.dequeue();
    }
    //there should only be one person left by this point, so peeking will give the winner
    winner = names.peek();
    return winner; // make sure to change this
  }

}
