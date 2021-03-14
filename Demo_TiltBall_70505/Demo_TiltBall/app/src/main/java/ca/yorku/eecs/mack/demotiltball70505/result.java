package ca.yorku.eecs.mack.demotiltball70505;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.widget.Spinner;
import android.util.Log;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Locale;

public class result extends Activity {


    //int lapNumber = super.lapNumber;
    //int wallhits = super.wallHits;
    final static String MYDEBUG = "MYDEBUG";
    RollingBallPanel rb;
    public TextView laps;
    int totalLaps;
    int wallHits;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.endingscreen);
        initialize();
    }

    public void initialize(){
        totalLaps = rb.lapNumber;
        Log.i(MYDEBUG, "laps are " + totalLaps);
        wallHits = rb.wallHits;
        laps = (TextView) findViewById(R.id.laps);
        //laps.setText(totalLaps);
        laps.setText(String.format(Locale.CANADA, "Laps: %d" + totalLaps));

        TextView wall = (TextView) findViewById(R.id.wallhits);
        wall.setText(wallHits);

    }
//
//    public void passThrough(int curLapArg, int wallHitsArg){
//
//    }
}
