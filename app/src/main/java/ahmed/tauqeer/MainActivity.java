package ahmed.tauqeer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //Creating Everything
    private AlphaAnimation alpha = new AlphaAnimation(1F,0.8F);
    Button digits;
    Button notations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Component Initializing
        digits = (Button) findViewById(R.id.digits);
        notations = (Button) findViewById(R.id.notations);

        //OnClickListeners
        digits.setOnClickListener(this);
        notations.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        v.startAnimation(alpha);
        int object = v.getId();
        if (object == R.id.digits) {
            Intent intent = new Intent(MainActivity.this,DigitsActivity.class);
            startActivity(intent);
        }
        else if (object == R.id.notations) {
            Intent intent = new Intent(MainActivity.this,NotationsActivity.class);
            startActivity(intent);
        }
    }

    public void onBackPressed() {
        System.exit(0);
    }
}
