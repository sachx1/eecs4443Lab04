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

    final static String MYDEBUG = "MYDEBUG";
    RollingBallPanel rb;
    public TextView lapText;
    int totalLaps;
    int wallHits;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.endingscreen);
        totalLaps = rb.lapNumber;
        Log.i(MYDEBUG, "laps are " + totalLaps);
        wallHits = rb.wallHits;
        lapText = (TextView)findViewById(R.id.lapDisplay);
        lapText.setText(String.format(Locale.CANADA, "Laps: %d" + totalLaps));

        //initialize();
    }

    public void initialize(){
//        totalLaps = rb.lapNumber;
//        Log.i(MYDEBUG, "laps are " + totalLaps);
//        wallHits = rb.wallHits;
//        lapText = (TextView)findViewById(R.id.lapDisplay);
//        //laps.setText(totalLaps);
//        //laps.setText(String.format(Locale.CANADA, "Laps: %d" + totalLaps));
//        lapText.setText("Snakes " + totalLaps);

        TextView wall = (TextView) findViewById(R.id.wallhits);
        wall.setText(wallHits);

    }
//
//    public void passThrough(int curLapArg, int wallHitsArg){
//
//    }
}
