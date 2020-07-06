package ahmed.tauqeer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;

public class DigitsActivity extends AppCompatActivity implements View.OnClickListener {

    //Creating Everything
    AlphaAnimation alpha = new AlphaAnimation(1F,0.8F);
    Button decToBin,binToDec,decToOct,octToDec,decToHex,hexToDec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_digits);

        //Components Initialization
        decToBin = (Button) findViewById(R.id.decToBin);
        binToDec = (Button) findViewById(R.id.binToDec);
        decToOct = (Button) findViewById(R.id.decToOct);
        octToDec = (Button) findViewById(R.id.octToDec);
        decToHex = (Button) findViewById(R.id.decToHex);
        hexToDec = (Button) findViewById(R.id.hexToDec);

        //OnClickListeners
        decToBin.setOnClickListener(this);
        binToDec.setOnClickListener(this);
        decToOct.setOnClickListener(this);
        octToDec.setOnClickListener(this);
        decToHex.setOnClickListener(this);
        hexToDec.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        v.startAnimation(alpha);
        int id = v.getId();
        if (id == R.id.decToBin) {
            Intent intent = new Intent(DigitsActivity.this, DecToBin.class);
            startActivity(intent);
        }
        else if (id == R.id.binToDec) {
            Intent intent = new Intent(DigitsActivity.this,BinToDec.class);
            startActivity(intent);
        }
        else if (id == R.id.decToOct) {
            Intent intent = new Intent(DigitsActivity.this,DecToOct.class);
            startActivity(intent);
        }
        else if (id == R.id.octToDec) {
            Intent intent = new Intent(DigitsActivity.this,OctToDec.class);
            startActivity(intent);
        }
        else if (id == R.id.decToHex) {
            Intent intent = new Intent(DigitsActivity.this,DecToHex.class);
            startActivity(intent);
        }
        else if (id == R.id.hexToDec) {
            Intent intent = new Intent(DigitsActivity.this,HexToDec.class);
            startActivity(intent);
        }
    }
}
