package com.examplo.game_engine;

import android.os.SystemClock;

public class GEWatch {
      protected long mTempoAtual;
      protected long mUltimoTempo;
      protected float mIntervaloTempo;

       protected float tick(){  
             if (mTempoAtual == 0 ){
	   mUltimoTempo = mTempoAtual = SystemClock.uptimeMillis();
              }
              else{
                     mTempoAtual = SystemClock.uptimeMillis();    
               }
               mIntervaloTempo = (mTempoAtual- mUltimoTempo)/1000.0f;
               mUltimoTempo = mTempoAtual;          
               return mIntervaloTempo;
       }       
}
