import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.ArrayList;

public class SnakesandLadders {

    public class Floor{
        int position;
        int points;
    }
    public class Empty extends Floor {

    }
    public class SnakeFloor extends Floor {

    }
    public class Normal extends SnakeFloor {


    }
    public class KingCobra extends SnakeFloor {

    }
    public class Ladder extends Floor {


    }
    public class Norm extends Ladder {

    }
    public class Elevator extends Ladder {

    }
    public static class Dice {
        Random rand = new Random();
        private final int numFaces; //maximum face value
        private int faceValue; //current value showing on the dice
        // Constructor: Sets the initial face value.
        public Dice(int _numFaces) {
            numFaces = _numFaces;
            roll();
        }
        // Rolls the dice
        public void roll() {
            int curr_faceValue = 1 + rand.nextInt(numFaces);
            setFaceValue(curr_faceValue);
        }
        // Face value setter/mutator.
        private void setFaceValue (int value) {
            if (value <= numFaces)
                faceValue = value;
        }


        // Face value getter/setter.
        public int getFaceValue() {
            return faceValue;
        }

        // Face value getter/setter.
        public int getNumFaces() {
            return numFaces;
        }

        // Returns a string representation of this dice
        public String toString() {
            return "number of Faces " + numFaces + "current face value "  + faceValue;
        }
    }

    public static void main(String [] args){
        Random rand  = new Random();
        Scanner sc= new Scanner(System.in);
        InputStreamReader r=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(r);


    }
}
