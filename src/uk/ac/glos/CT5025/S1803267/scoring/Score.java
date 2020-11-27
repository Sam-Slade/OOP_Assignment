package uk.ac.glos.CT5025.S1803267.scoring;

public class Score {

  private String name;
  private int score;
  private String outcome;

  public Score(String name, int score, String outcome) {
    this.name = name;
    this.score = score;
    this.outcome = outcome;
  }

  public String getName() {
    return this.name;
  }

  public int getScore() {
    return this.score;
  }

  public String getOutcome() {
    return this.outcome;
  }
}
