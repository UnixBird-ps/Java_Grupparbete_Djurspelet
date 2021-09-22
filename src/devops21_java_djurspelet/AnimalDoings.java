package devops21_java_djurspelet;

import java.util.Random;


public class AnimalDoings {

    Random rand = new Random();

    public AnimalBase Breeding(AnimalBase a, AnimalBase b) {
        int birthRate = rand.nextInt(2);
        if (a.getKind().equals(b.getKind()) && a.getGender() != b.getGender() && (birthRate == 1)) {
            return mKind;
        }
    }
}