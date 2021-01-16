package com.drozd.mixers;


import com.drozd.support.Mixer;

import java.util.ArrayList;
import java.util.Collections;

public class WalkingLeftMixer extends Mixer {


    public WalkingLeftMixer(String name, int numberOfLights, ArrayList<Integer> colors, int speed) {
        super(name, numberOfLights, colors, speed);
    }

    @Override
    public void mix(ArrayList<Integer> lightings) {
        Collections.rotate(lightings, -1);
    }
}
