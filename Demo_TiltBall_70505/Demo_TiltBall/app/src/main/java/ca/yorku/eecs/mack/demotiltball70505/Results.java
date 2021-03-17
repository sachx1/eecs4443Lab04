package ca.yorku.eecs.mack.demotiltball70505;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.Locale;

public class Results extends Activity {

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results);

        Bundle b = getIntent().getExtras();
        int wallHits = b.getInt("wallHits");
        double averageLapTime = b.getDouble("averageLapTime");
        double averagePathPercentage = b.getDouble("percentInPathTime");
        int laps = b.getInt("targetLaps");

        TextView lapResult = (TextView) findViewById(R.id.paramLaps);
        TextView lapTimeResult = (TextView) findViewById(R.id.paramAveLapTime);
        TextView wallHitsResult = (TextView) findViewById(R.id.paramWallHits);
        TextView pathPercentageResult = (TextView) findViewById(R.id.paramInPathPercent);

        lapResult.setText("Laps = " + laps);
        lapTimeResult.setText("Lap time = " + new DecimalFormat("##.##").format(averageLapTime) + " s (mean/lap)");
        wallHitsResult.setText("Wall hits = " + wallHits);
        pathPercentageResult.setText("In-path time = " + new DecimalFormat("##.##").format(averagePathPercentage) + "%");

    }

    // called when the "Results" button is pressed
    public void clickSetup(View view) {
        Intent i = new Intent(getApplicationContext(), DemoTiltBallSetup.class);
        //i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(i);
    }

    /** Called when the "Exit" button is pressed. */
    public void clickExit(View view) {
        super.onDestroy(); // cleanup
        this.finish(); // terminate
        //System.exit(0);
    }
//
//    public void passThrough(int curLapArg, int wallHitsArg){
//
//    }
}
