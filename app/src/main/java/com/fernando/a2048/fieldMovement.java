package com.fernando.a2048;

import android.util.Log;

/**
 * Created by fernando on 19/10/17.
 */

public class fieldMovement {

    public static int[] moveRightToLeft(int[] valors)
    {
        int chagePosition = -1;
        for(int linePosition=0; linePosition<15; linePosition+=4){
            Log.e("Line:", String.valueOf(linePosition) );
            for(int i=linePosition+1; i<(linePosition+4); i++){
                Log.e("i:", String.valueOf(i) );
                if(valors[i] > 0){
                    for(int j=i-1; j>=linePosition; j--){
                        Log.e("j:", String.valueOf(j) );
                        if(valors[j] > 0){
                            if(valors[i] == valors[j]){
                                valors[j] += valors[i];
                                valors[i] = 0;
                            }
                            break;
                        }
                        else{
                            chagePosition = j;
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
        return valors;
    }

    public static int[] moveLeftToRight(int[] valors)
    {
        int chagePosition = -1;
        for(int linePosition=15; linePosition>0; linePosition-=4){
            for(int i=linePosition-1; i>(linePosition-4); i--){
                if(valors[i] > 0){
                    for(int j=i+1; j<=linePosition; j++){
                        if(valors[j] > 0){
                            if(valors[i] == valors[j]){
                                valors[j] += valors[i];
                                valors[i] = 0;
                            }
                            break;
                        }
                        else{
                            chagePosition = j;
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
        return valors;
    }

    public static int[] moveUpToDown(int[] valors)
    {
        int chagePosition = -1;
        for(int linePosition=12; linePosition<16; linePosition++){
            for(int i=linePosition-4; i>=0; i-=4){
                if(valors[i] > 0){
                    for(int j=i+4; j<15; j+=4){
                        if(valors[j] > 0){
                            if(valors[i] == valors[j]){
                                valors[j] += valors[i];
                                valors[i] = 0;
                            }
                            break;
                        }
                        else{
                            chagePosition = j;
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

        return valors;
    }

    public static int[] moveDownToUp(int[] valors)
    {
        int chagePosition = -1;
        for(int linePosition=0; linePosition<4; linePosition++){
            for(int i=linePosition+4; i<15; i+=4){
                if(valors[i] > 0){
                    for(int j=i-4; j>0; j-=4){
                        if(valors[j] > 0){
                            if(valors[i] == valors[j]){
                                valors[j] += valors[i];
                                valors[i] = 0;
                            }
                            break;
                        }
                        else{
                            chagePosition = j;
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

        return valors;
    }
}
