package mixers;

import support.Mixer;

import java.util.ArrayList;
import java.util.Collections;

public class WalkingRightMixer extends Mixer {
    public WalkingRightMixer(String name, int numberOfLights, ArrayList<Integer> colors, int speed) {
        super(name, numberOfLights, colors, speed);
    }

    @Override
    public void mix(ArrayList<Integer> lightings) {
        Collections.rotate(lightings, 1);
    }

}
