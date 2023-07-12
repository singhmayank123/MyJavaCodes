// Program to perform ranked choice voting algorithm using a data
// file of voting preferences.  Candidate names are listed in order
// of preference with tabs separating choices.

import java.util.*;
import java.io.*;

public class TallyVotes {

    public static void main(String[] args) 
            throws FileNotFoundException {
        Scanner input = new Scanner(new File("vote.txt"));
        ArrayList<Ballot> ballots = readFile(input);

        int round = 1;
        boolean done = false;
        while (!done) {
            
            System.out.println("Round #" + round);

              for(int i = 0; i<ballots.size(); i++){

                if(ballots.get(i).isEmpty()){
                    ballots.remove(i);
                }
            }

            Collections.sort(ballots);

            done = oneRound(ballots);
            System.out.println("------------------------------");
            round++;
        }
    }

    public static ArrayList<Ballot> readFile(Scanner input) {
        ArrayList<Ballot> result = new ArrayList<>();
        while (input.hasNextLine()) {
            String text = input.nextLine();
            result.add(new Ballot(text.split("\t")));
        }
        return result;
    }

    public static boolean oneRound(ArrayList<Ballot> ballots) {
        String top = null;
        String bottom = null;
        int topCount = 0;
        int bottomCount = ballots.size() + 1;
        int i = 0;
        while (i < ballots.size()) {

            String next = ballots.get(i).getCandidate();

            int count = 0;
            do {
                i++;
                count++;
            } while (i < ballots.size() && 
                     ballots.get(i).getCandidate().equals(next));
            double percent = 100.0 * count / ballots.size();

            if(next.equals(""))
                next = "none";

            System.out.printf("%d votes for %s (%4.1f%%)\n", count,
                              next, percent);

            if (count > topCount) {
                topCount = count;
                top = next;
            }
            if (count < bottomCount) {
                bottomCount = count;
                bottom = next;
            }
        }
        if (topCount == bottomCount) {
            System.out.println("Election has no winner");
            return true;
        } else if (topCount * 2 > ballots.size()) {
            System.out.println("Winner is " + top);
            return true;
        } else {
            System.out.println("no winner, eliminating " + bottom);
            eliminate(bottom, ballots);
            return false;
        }
    }

    public static void eliminate(String candidate, 
                                 ArrayList<Ballot> ballots) {

        if(candidate.equals("none"))
            candidate = "";

        for (Ballot b : ballots) {
            b.eliminate(candidate);
        }
    }
}