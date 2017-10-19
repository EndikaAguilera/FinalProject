package com.example;

// jokes taken from https://frugalfun4boys.com/2015/04/30/hilarious-jokes-for-kids/

import java.util.Random;

/**
 * Created by thisobeystudio on 19/10/17.
 * Copyright: (c) 2017 ThisObey Studio
 * Contact: thisobeystudio@gmail.com
 */

@SuppressWarnings("SameReturnValue")
public class Jokes {

    private final int totalJokes = 30;

    private String getJoke_01() {
        return "Q: How do all the oceans say hello to each other?\n\nThey wave!";
    }

    private String getJoke_02() {
        return "Q: What did one wall say to the other wall?\n\nI’ll meet you at the corner!";
    }

    private String getJoke_03() {
        return "Q: What do you call a bear with no teeth?\n\nA gummy bear!";
    }

    private String getJoke_04() {
        return "Q: What do you call cheese that isn’t yours?\n\nNacho cheese!";
    }

    private String getJoke_05() {
        return "Q: Where do cows go for entertainment?\n\nTo the moo-vies!";
    }

    private String getJoke_06() {
        return "Knock, knock.\n\nWho’s there?\n\nCows go.\n\nCows go who?\n\nNo, cows go MOO!";
    }

    private String getJoke_07() {
        return "Q: How do you know if there’s an elephant under your bed?\n\n" +
                "Your head hits the ceiling!";
    }

    private String getJoke_08() {
        return "Q: Why are elephants so wrinkled?\n\nBecause they take too long to iron!";
    }

    private String getJoke_09() {
        return "Q: How do you keep an elephant from charging?\n\nTake away her credit card!";
    }

    private String getJoke_10() {
        return "Q: Why did the elephant paint himself different colors?\n\n" +
                "So he could hide in the crayon box!";
    }

    private String getJoke_11() {
        return "Q: How can you tell if an elephant has been in your refrigerator?\n\n" +
                "By the footprints in the butter!";
    }

    private String getJoke_12() {
        return "Q: What is the difference between elephants and grapes?\n\nGrapes are purple.";
    }

    private String getJoke_13() {
        return "Q: What did Tarzan say when he saw the elephants coming?\n\n" +
                "“Here come the elephants!";
    }

    private String getJoke_14() {
        return "Q: What did Jane say when she saw the elephants coming?\n\n" +
                "“Here come the grapes!” (She was colorblind.)";
    }

    private String getJoke_15() {
        return "Q: What do you call a cow with no legs?\n\nGround beef!";
    }

    private String getJoke_16() {
        return "Q: What do you call a cow with two legs?\n\nLean meat!";
    }

    private String getJoke_17() {
        return "Q: What do you call a pig that knows karate?\n\nA pork chop!";
    }

    private String getJoke_18() {
        return "Q: Why are ghosts bad liars?\n\nBecause you can see right through them!";
    }

    private String getJoke_19() {
        return "Q: What animal needs to wear a wig?\n\nA bald eagle!";
    }

    private String getJoke_20() {
        return "Q: What do you call a fly without wings?\n\nA walk!";
    }

    private String getJoke_21() {
        return "Knock knock.\n\nWho’s there?\n\nA little old lady?\n\n" +
                "A little old lady who?\n\nI didn’t know you could yodel!";
    }

    private String getJoke_22() {
        return "Q: Why do bees have sticky hair?\n\nBecause they use honey combs!";
    }

    private String getJoke_23() {
        return "Q: What do you call an alligator in a vest?\n\nAn investigator!";
    }

    private String getJoke_24() {
        return "Q: Why can’t you give Elsa a balloon?\n\nBecause she will let it go!";
    }

    private String getJoke_25() {
        return "Q: What do you get when you cross a snowman with a vampire?\n\nFrostbite!";
    }

    private String getJoke_26() {
        return "Q: What has four wheels and flies?\n\nA garbage truck!";
    }

    private String getJoke_27() {
        return "Q: Why did the man run around his bed?\n\n" +
                "Because he was trying to catch up on his sleep!";
    }

    private String getJoke_28() {
        return "Q: Why did the math book look so sad?\n\nBecause it had so many problems!";
    }

    private String getJoke_29() {
        return "Q: Can a kangaroo jump higher than the Empire State Building?\n\n" +
                "Of course! The Empire State Building can’t jump!";
    }

    private String getJoke_30() {
        return "Q: If April showers bring Mayflowers, what do Mayflowers bring?\n\nPilgrims!";
    }

    private String getJokeByPosition(int position) {
        switch (position) {
            case 1:
                return getJoke_01();
            case 2:
                return getJoke_02();
            case 3:
                return getJoke_03();
            case 4:
                return getJoke_04();
            case 5:
                return getJoke_05();
            case 6:
                return getJoke_06();
            case 7:
                return getJoke_07();
            case 8:
                return getJoke_08();
            case 9:
                return getJoke_09();
            case 10:
                return getJoke_10();
            case 11:
                return getJoke_11();
            case 12:
                return getJoke_12();
            case 13:
                return getJoke_13();
            case 14:
                return getJoke_14();
            case 15:
                return getJoke_15();
            case 16:
                return getJoke_16();
            case 17:
                return getJoke_17();
            case 18:
                return getJoke_18();
            case 19:
                return getJoke_19();
            case 20:
                return getJoke_20();
            case 21:
                return getJoke_21();
            case 22:
                return getJoke_22();
            case 23:
                return getJoke_23();
            case 24:
                return getJoke_24();
            case 25:
                return getJoke_25();
            case 26:
                return getJoke_26();
            case 27:
                return getJoke_27();
            case 28:
                return getJoke_28();
            case 29:
                return getJoke_29();
            case 30:
                return getJoke_30();
            default:
                return null;
        }
    }

    @SuppressWarnings("unused")
    private String getRandomJoke() {

        String randomJoke;

        Random r = new Random();
        int min = 1;
        int randomPos = r.nextInt(totalJokes + min - min) + min;

        randomJoke = getJokeByPosition(randomPos);

        if (randomJoke == null) {
            return "derp";
        }

        return randomJoke;
    }

    // getOrderedJoke() initial pos
    private static int currentPos = 0;

    public String getOrderedJoke() {

        if (currentPos < totalJokes) {
            currentPos++;
        } else {
            currentPos = 1;
        }

        String orderedJoke;

        orderedJoke = getJokeByPosition(currentPos);

        if (orderedJoke == null) {
            return "derp";
        }

        return orderedJoke;
    }
}
