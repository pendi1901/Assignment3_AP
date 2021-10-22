import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.ArrayList;

public class Main {

    public class Floor{
        int position;
        int points;
    }
    public class Empty extends Floor{

    }
    public class SnakeFloor extends Floor{

    }
    public class Normal extends SnakeFloor{


    }
    public class KingCobra extends SnakeFloor{

    }
    public class Ladder extends Floor{


    }
    public class Norm extends Ladder{

    }
    public class Elevator extends Ladder{

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

    public static void main(String [] args) throws IOException {
        int points=0 ;
        int position = 0;
        Random rand  = new Random();
        Scanner sc= new Scanner(System.in);
        InputStreamReader r=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(r);
        //Number of faces = 2
        //checker if the dice class works

        System.out.println("Enter the player name and hit enter");
        String name = br.readLine();
        System.out.println("The game setup is ready");

        while(true) {
            System.out.println("Hit enter to roll the dice ");
            Dice d1 = new Dice(2);
            d1.roll();
            System.out.println("Dice gave: "+d1.faceValue);
            if (d1.faceValue == 2) {
                System.out.println("Game cannot start until you roll a 1");
            }
            else if (d1.faceValue == 1) {
                System.out.println("Started");
                break;
            }
        }
        while(true){
            Dice d1 = new Dice(2);
            System.out.println("Hit enter to continue\ret");

            d1.roll();
            System.out.println("Dice gave: "+d1.faceValue);
            position+= d1.faceValue;
            points++;
            if(position == 2){
                position+=8;
                points+=5;
                System.out.println("Elevator level");
                System.out.println("Player position: " + position);
                System.out.println("Total points: "+points);
            }
            else if(position == 5){
                System.out.println("Snake level");
                position-=3;
                points-=1;
                System.out.println("Player position: " + position);
                System.out.println("Total points: "+points);

            }
            else if(position == 8){
                System.out.println("Ladder level");
                position+=4;
                points+=3;
                System.out.println("Player position: " + position);
                System.out.println("Total points: "+points);
            }
            else if(position == 11){
                System.out.println("King cobra level");
                position-=8;
                points-=3;
                System.out.println("Player position: " + position);
                System.out.println("Total points: "+points);
            }
            else if (position == 12){
                while(true) {
                    d1.roll();
                    if (d1.faceValue == 1) {
                        System.out.println("End of the game");
                        points++;
                        System.out.println("Player position: " + position);
                        System.out.println("Total points: "+points);
                        break;

                    } else if (d1.faceValue == 2) {
                        System.out.println("Cannot move ");

                    }
                }
                break;
            }
        }
    }
}
