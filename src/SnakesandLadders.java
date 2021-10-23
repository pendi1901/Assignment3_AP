import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.ArrayList;

public class SnakesandLadders {

    public static class Floor{
        private int position;
        private int points;

        public Floor(int position , int points){
            this.points=points;
            this.position = position;
        }

        public void fall(int decrement){
            position-=decrement;
        }
        public void climb(int increment){
            position+=increment;
        }
        public void add(int adder){
            points+=adder;
        }
        public void sub(int dec){
            points-=dec;
        }
        public String toString(){
            return ("Total points: " + points +"\n" + "Player position Floor: " + position);
        }
        public void setPosition(int value){
            position = value;
        }
        public void setPoints(int val){
            points = val;
        }
        public int getPosition() {
            return position;
        }

        // Face value getter/setter.
        public int getPoints() {
            return points;
        }

    }
    public static class Empty extends Floor {

        public Empty(int position, int points) {
            super(position, points);
        }

//        @Override
//        public void climb(int increment) {
//            super.climb(1);
//        }
//
//        @Override
//        public void add(int adder) {
//            super.add(1);
//        }


    }
    public static class normalSnake extends Floor {

        public normalSnake(int position, int points) {
            super(position, points);
        }

//        @Override
//        public void fall(int decrement) {
//            super.fall(4);
//        }
//
//        @Override
//        public void sub(int dec) {
//            super.sub(2);
//        }
    }

    public static class KingCobra extends Floor {

        public KingCobra(int position, int points) {
            super(position, points);
        }

//        @Override
//        public void fall(int decrement) {
//            super.fall(8);
//        }
//
//        @Override
//        public void sub(int dec) {
//            super.sub(4);
//        }
    }
    public static class normalLadder extends Floor {


        public normalLadder(int position, int points) {
            super(position, points);
        }

//        @Override
//        public void climb(int increment) {
//            super.climb(4);
//        }
//
//        @Override
//        public void add(int adder) {
//            super.add(2);
//        }
    }

    public static class Elevator extends Floor {

        public Elevator(int position, int points) {
            super(position, points);
        }

//        @Override
//        public void climb(int increment) {
//            super.climb(8);
//        }
//
//        @Override
//        public void add(int adder) {
//            super.add(4);
//        }
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

    public static void main(String[] args) throws IOException {
        Random rand  = new Random();
        Scanner sc= new Scanner(System.in);
        InputStreamReader r=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(r);
        Dice d1 = new Dice(2);
        System.out.println("Enter the player name and hit enter");
        String name = br.readLine();
        System.out.println("The game setup is ready");
        System.out.println("Hit enter to roll the dice");
        String b = br.readLine();

        while(true){
            d1.roll();
            if(d1.faceValue == 1){
                break;
            }
            else if(d1.faceValue == 2){
                System.out.println("Dice gave: " + d1.getFaceValue());
                System.out.println("Game cannot start until you get 1");

            }
        }
        System.out.println("Dice gave: 1");
        System.out.println("Player position: Floor-0");
        System.out.println(name + " has reached an Empty floor");
        System.out.println("Total points: 1" );
        int points =1;
        int position =0;
        Floor f1 = new Floor(position, points);
        while(true){
            System.out.println("Hit enter to roll the dice");
            String a = br.readLine();
            d1.roll();
            System.out.println("Dice gave: " + d1.getFaceValue());
            position+=d1.faceValue;
            if(position ==1 || position==3 || position==4 || position==6 || position==7 || position==9 || position==10){

                Empty e1 = new Empty(position,points);
                e1.add(1);
                System.out.println("Player position Floor " + e1.getPosition());
                System.out.println(name + " has reached an Empty floor");
                System.out.println("Total Points: " + e1.getPoints());
                e1.setPoints(e1.getPoints());
                e1.setPosition(e1.getPosition());
                points = e1.getPoints();
                position = e1.getPosition();

            }
            else if(position == 2){
                System.out.println(name + " has reached an Elevator Floor");
                Elevator e1 = new Elevator(position,points);
                e1.add(4);
                e1.climb(8);
                System.out.println("Total Points: " + e1.getPoints());
                System.out.println("Player position Floor " + e1.getPosition());
                System.out.println(name + " has reached an Empty floor");
                e1.setPoints(e1.getPoints());
                e1.setPosition(e1.getPosition());
                points = e1.getPoints();
                position = e1.getPosition();
                Empty e2 = new Empty(position,points);
                e2.add(1);
                e2.setPoints(e2.getPoints());
                e2.setPosition(e2.getPosition());
                points = e2.getPoints();
                position = e2.getPosition();
                System.out.println("Total Points: " + e2.getPoints());
            }
            else if( position== 8){
                System.out.println(name + " has reached a Ladder Floor");
                normalLadder nl1 = new normalLadder(position,points);
                nl1.add(2);
                nl1.climb(4);
                System.out.println("Total Points: " + nl1.getPoints());
                System.out.println("Player position Floor " + nl1.getPosition());
                System.out.println(name + " has reached an Empty floor");
                nl1.setPoints(nl1.getPoints());
                nl1.setPosition(nl1.getPosition());
                points = nl1.getPoints();
                position = nl1.getPosition();
                Empty e2 = new Empty(position,points);
                e2.add(1);
                e2.setPoints(e2.getPoints());
                e2.setPosition(e2.getPosition());
                points = e2.getPoints();
                position = e2.getPosition();
                System.out.println("Total Points: " + e2.getPoints());
            }
            else if(position== 5){
                System.out.println(name + " has reached a Snake Floor");
                normalSnake ns1 = new normalSnake(position,points);
                ns1.sub(2);
                ns1.fall(4);
                System.out.println("Total Points: " + ns1.getPoints());
                System.out.println("Player position Floor " + ns1.getPosition());
                System.out.println(name + " has reached an Empty floor");
                ns1.setPoints(ns1.getPoints());
                ns1.setPosition(ns1.getPosition());
                points = ns1.getPoints();
                position = ns1.getPosition();
                Empty e2 = new Empty(position,points);
                e2.add(1);
                e2.setPoints(e2.getPoints());
                e2.setPosition(e2.getPosition());
                points = e2.getPoints();
                position = e2.getPosition();
                System.out.println("Total Points: " + e2.getPoints());
            }
            else if(position==11){
                System.out.println(name + " has reached a King Cobra Floor");
                KingCobra kc1 = new KingCobra(position,points);
                kc1.sub(4);
                kc1.fall(8);
                System.out.println("Total Points: " + kc1.getPoints());
                System.out.println("Player position Floor " + kc1.getPosition());
                System.out.println(name + " has reached an Empty floor");
                kc1.setPoints(kc1.getPoints());
                kc1.setPosition(kc1.getPosition());
                Empty e2 = new Empty(position,points);
                e2.add(1);
                e2.setPoints(e2.getPoints());
                e2.setPosition(e2.getPosition());
                points = e2.getPoints();
                position = e2.getPosition();
                System.out.println("Total Points: " + e2.getPoints());

            }
            else if(position ==12){
                System.out.println("Player position: " + position);
                System.out.println(name + " has reached an empty floor");
                points++;
                System.out.println("Total points: " + points);
                while(true) {
                    System.out.println("Hit enter to roll the dice ");
                    String c = br.readLine();
                    d1.roll();
                    if (d1.faceValue == 1) {
                        System.out.println("Dice gave: " + d1.faceValue);
                        points++;
                        System.out.println("Player position: " + position);
                        System.out.println(name + " has reached an empty floor");
                        System.out.println("Total points: "+points);
                        break;
                    }
                    else if (d1.faceValue == 2) {
                        System.out.println("Dice gave: " + d1.faceValue);
                        System.out.println("Cannot move ");

                    }
                }
                break;
            }
        }
        System.out.println("Total Points: " + points);
        System.out.println("Game Over");
        System.out.println(name + " accumulated " + points + " points");


    }
}
