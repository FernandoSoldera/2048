package com.fernando.a2048;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by fernando on 19/10/17.
 */

public class fieldMovement {

    public static int[] moveRightToLeft(int[] valors, int mode) //mode = 0 = play AND mode = 1 = verificaton
    {
        int chagePosition = -1;
        int existMovemets = 0;
        for(int linePosition=0; linePosition<15; linePosition+=4){
            for(int i=linePosition+1; i<(linePosition+4); i++){
                if(valors[i] > 0){
                    for(int j=i-1; j>=linePosition; j--){
                        if(valors[j] > 0){
                            if(valors[i] == valors[j]){
                                if(mode == 0){
                                    valors[j] += valors[i];
                                    valors[i] = 0;
                                    Points points = Points.getInstance();
                                    points.setTotalPoints(points.getTotalPoints() + valors[j]);
                                }else{
                                    existMovemets = 1;
                                    return new int[]{existMovemets, 0};
                                }
                            }
                            break;
                        }
                        else{
                            if(mode == 0){
                                chagePosition = j;
                            }else{
                                existMovemets = 1;
                                return new int[]{existMovemets, 0};
                            }
                        }
                    }
                    if(chagePosition > -1){
                        valors[chagePosition] = valors[i];
                        valors[i] = 0;
                    }
                }
                chagePosition = -1;
            }
        }
        if(mode == 0){
            return chooseLocationNewSquare(valors);
        }else{
            return new int[]{existMovemets, 0};
        }
    }

    public static int[] moveLeftToRight(int[] valors, int mode)
    {
        int chagePosition = -1;
        int existMovements = 0;
        for(int linePosition=15; linePosition>0; linePosition-=4){
            for(int i=linePosition-1; i>(linePosition-4); i--){
                if(valors[i] > 0){
                    for(int j=i+1; j<=linePosition; j++){
                        if(valors[j] > 0){
                            if(valors[i] == valors[j]){
                                if(mode == 0){
                                    valors[j] += valors[i];
                                    valors[i] = 0;
                                    Points points = Points.getInstance();
                                    points.setTotalPoints(points.getTotalPoints() + valors[j]);
                                }else{
                                    existMovements = 1;
                                    return new int[]{existMovements, 0};
                                }
                            }
                            break;
                        }
                        else{
                            if(mode == 0){
                                chagePosition = j;
                            }else{
                                existMovements = 1;
                                return new int[]{existMovements, 0};
                            }
                        }
                    }
                    if(chagePosition > -1){
                        valors[chagePosition] = valors[i];
                        valors[i] = 0;
                    }
                }
                chagePosition = -1;
            }
        }
        if(mode == 0){
            return chooseLocationNewSquare(valors);
        }else{
            return new int[]{existMovements, 0};
        }

    }

    public static int[] moveUpToDown(int[] valors, int mode)
    {
        int chagePosition = -1;
        int existMovements = 0;
        for(int linePosition=12; linePosition<16; linePosition++){
            for(int i=linePosition-4; i>=0; i-=4){
                if(valors[i] > 0){
                    for(int j=i+4; j<=15; j+=4){
                        if(valors[j] > 0){
                            if(valors[i] == valors[j]){
                                if(mode == 0){
                                    valors[j] += valors[i];
                                    valors[i] = 0;
                                    Points points = Points.getInstance();
                                    points.setTotalPoints(points.getTotalPoints() + valors[j]);
                                }else{
                                    existMovements = 1;
                                    return new int[]{existMovements, 0};
                                }
                            }
                            break;
                        }
                        else{
                            if(mode == 0){
                                chagePosition = j;
                            }else{
                                existMovements = 1;
                                return new int[]{existMovements, 0};
                            }
                        }
                    }
                    if(chagePosition > -1){
                        valors[chagePosition] = valors[i];
                        valors[i] = 0;
                    }
                }
                chagePosition = -1;
            }
        }
        if(mode == 0){
            return chooseLocationNewSquare(valors);
        }else{
            return new int[]{existMovements, 0};
        }
    }

    public static int[] moveDownToUp(int[] valors, int mode)
    {
        int chagePosition = -1;
        int existMovements = 0;
        for(int linePosition=0; linePosition<4; linePosition++){
            for(int i=linePosition+4; i<=15; i+=4){
                if(valors[i] > 0){
                    for(int j=i-4; j>=0; j-=4){
                        if(valors[j] > 0){
                            if(valors[i] == valors[j]){
                                if(mode == 0){
                                    valors[j] += valors[i];
                                    valors[i] = 0;
                                    Points points = Points.getInstance();
                                    points.setTotalPoints(points.getTotalPoints() + valors[j]);
                                }else{
                                    existMovements = 1;
                                    return new int[]{existMovements, 0};
                                }
                            }
                            break;
                        }
                        else{
                            if(mode == 0){
                                chagePosition = j;
                            }else{
                                existMovements = 1;
                                return new int[]{existMovements, 0};
                            }
                        }
                    }
                    if(chagePosition > -1){
                        valors[chagePosition] = valors[i];
                        valors[i] = 0;
                    }
                }
                chagePosition = -1;
            }
        }
        if(mode == 0){
            return chooseLocationNewSquare(valors);
        }else{
            return new int[]{existMovements, 0};
        }

    }

    public static int[] chooseLocationNewSquare(int[] valors){

        List<Integer> possibleLocations = new ArrayList<Integer>();

        for(int i=0; i<16; i++){
            if(valors[i] == 0){
                possibleLocations.add(i);
            }
        }
        if(possibleLocations.size()>0){
            valors[possibleLocations.get(new Random().nextInt(possibleLocations.size()))] = 2;
        }
        return valors;
    }
}
