package ca.yorku.eecs.mack.demotiltball70505;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class DemoTiltBallSetup extends Activity 
{
	final static String[] ORDER_OF_CONTROL = { "Velocity", "Position" }; // NOTE: do not change strings
	final static String[] GAIN = { "Very low", "Low", "Medium", "High", "Very high" };
	final static String[] PATH_TYPE = { "Square", "Circle", "Free" };
	final static String[] PATH_WIDTH = { "Narrow", "Medium", "Wide" };
	//COLOR FOR PATHS
	final static String[] COLOR_PATH = {"Blue", "Green"};
	//LAP ARRAY FOR SPINNER, GOES FROM 1-5
	final static Integer[] NUMBER_OF_LAPS = new Integer[]{ 1, 2, 3, 4, 5 };

	// somewhat arbitrary mappings for gain by order of control
	final static int[] GAIN_ARG_POSITION_CONTROL = { 5, 10, 20, 40, 80 };
	final static int[] GAIN_ARG_VELOCITY_CONTROL = { 25, 50, 100, 200, 400 };

	Spinner spinOrderOfControl, spinGain, spinPathMode, spinPathWidth, spinnerLaps, spinnerColor;

	// called when the activity is first created
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.setup);

		spinOrderOfControl = (Spinner) findViewById(R.id.paramOrderOfControl);
		ArrayAdapter<CharSequence> adapter2 = new ArrayAdapter<CharSequence>(this, R.layout.spinnerstyle, ORDER_OF_CONTROL);
		spinOrderOfControl.setAdapter(adapter2);

		spinGain = (Spinner) findViewById(R.id.paramGain);
		ArrayAdapter<CharSequence> adapter3 = new ArrayAdapter<CharSequence>(this, R.layout.spinnerstyle, GAIN);
		spinGain.setAdapter(adapter3);
		spinGain.setSelection(2); // "medium" default

		spinPathMode = (Spinner) findViewById(R.id.paramPathType);
		ArrayAdapter<CharSequence> adapter1 = new ArrayAdapter<CharSequence>(this, R.layout.spinnerstyle, PATH_TYPE);
		spinPathMode.setAdapter(adapter1);
		spinPathMode.setSelection(0); // free

		spinPathWidth = (Spinner) findViewById(R.id.paramPathWidth);
		ArrayAdapter<CharSequence> adapter4 = new ArrayAdapter<CharSequence>(this, R.layout.spinnerstyle, PATH_WIDTH);
		spinPathWidth.setAdapter(adapter4);
		spinPathWidth.setSelection(1); // medium

		//SPINNER FOR LAP SELECTION IN SETUP MENU
		spinnerLaps = (Spinner) findViewById(R.id.paramNumLaps);
		ArrayAdapter<Integer> adapter5 = new ArrayAdapter<Integer>(this, R.layout.spinnerstyle, NUMBER_OF_LAPS);
		spinnerLaps.setAdapter(adapter5);
		spinnerLaps.setSelection(0);

		spinnerColor = (Spinner) findViewById(R.id.paramColor);
		ArrayAdapter<CharSequence> adapter6 = new ArrayAdapter<CharSequence>(this, R.layout.spinnerstyle, COLOR_PATH);
		spinnerColor.setAdapter(adapter6);
		spinnerColor.setSelection(0); //BLUE
	}

	// called when the "OK" button is tapped
	public void clickOK(View view)
	{
		// get user's choices...
		String orderOfControl = (String) spinOrderOfControl.getSelectedItem();


		// actual gain value depends on order of control
		int gain;
		int laps = NUMBER_OF_LAPS[spinnerLaps.getSelectedItemPosition()];
		if (orderOfControl.equals("Velocity"))
			gain = GAIN_ARG_VELOCITY_CONTROL[spinGain.getSelectedItemPosition()];
		else
			gain = GAIN_ARG_POSITION_CONTROL[spinGain.getSelectedItemPosition()];

		String pathType = PATH_TYPE[spinPathMode.getSelectedItemPosition()];
		String pathWidth = PATH_WIDTH[spinPathWidth.getSelectedItemPosition()];
		String color = COLOR_PATH[spinnerColor.getSelectedItemPosition()];

		// bundle up parameters to pass on to activity
		Bundle b = new Bundle();
		b.putString("orderOfControl", orderOfControl);
		b.putInt("gain", gain);
		b.putString("pathType", pathType);
		b.putString("pathWidth", pathWidth);
		b.putString("color", color);;
		//SENDS THE LAP SELECTION TO MAIN ACTIVITY
		b.putInt("laps", laps);

		// start experiment activity
		Intent i = new Intent(getApplicationContext(), DemoTiltBall70505Activity.class);
		i.putExtras(b);
		startActivity(i);

		// comment out (return to setup after clicking BACK in main activity
		//finish();
	}

	/** Called when the "Exit" button is pressed. */
	public void clickExit(View view)
	{
		super.onDestroy(); // cleanup
		this.finish(); // terminate
	}
}
