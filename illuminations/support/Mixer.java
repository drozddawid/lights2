package support;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public abstract class Mixer implements Serializable {
    private static final long serialVersionUID = 1L;
    ArrayList<Integer> lightings;
    int speed;
    private String name = "default";

    public Mixer(String name, int numberOfLights, ArrayList<Integer> colors, int speed) {
        this.lightings = new ArrayList<>();
        this.speed = speed;
        this.name = name;
        int colorsLen = colors.size();
        for (int i = 0; i < numberOfLights; i++) {
            lightings.add(colors.get(new Random().nextInt(colorsLen)));
        }
    }

    public Mixer(String name) {
        this.name = name;
    }

    public int getSpeed() {
        return this.speed;
    }

    // algorithm, that takes an arrays of integer values representing
    // colors of lights and modifies them in some way
    public abstract void mix(ArrayList<Integer> lightings);

    // delivers mixer name
    public String getName() {
        return name;
    }

}
