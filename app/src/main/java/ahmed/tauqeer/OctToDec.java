package ahmed.tauqeer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class OctToDec extends AppCompatActivity implements View.OnClickListener {

    //Creating Everything
    AlphaAnimation alpha = new AlphaAnimation(1F,0.8F);
    EditText octal,decimal;
    Button convert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oct_to_dec);

        //Initializing Everything
        octal = (EditText) findViewById(R.id.octal1);
        decimal = (EditText) findViewById(R.id.decimal3);
        convert = (Button) findViewById(R.id.convert3);

        //OnClickListeners
        convert.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        v.startAnimation(alpha);
        if (v.getId() == R.id.convert3) {
            String expression = octal.getText().toString();
            if (expression.equals("")) {
                Toast.makeText(OctToDec.this,"Enter an Octal Number!",Toast.LENGTH_LONG).show();
            }
            else {
                int result = octToDec(expression);
                decimal.setText(result+"");
            }
        }
    }

    private int octToDec (String input) {
        int power = input.length() - 1;
        int result = 0;
        for (int i = 0;i < input.length();i++) {
            int number = Integer.decode(String.valueOf(input.charAt(i)));
            number = number * (int) Math.pow(8,power);
            result = result + number;
            power--;
        }
        return result;
    }
}
