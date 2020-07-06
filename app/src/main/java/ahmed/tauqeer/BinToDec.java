package ahmed.tauqeer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BinToDec extends AppCompatActivity implements View.OnClickListener {

    //Creating Everything
    AlphaAnimation alpha = new AlphaAnimation(1F,0.8F);
    EditText binary,decimal;
    Button convert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bin_to_dec);

        //Initializing Everything
        binary = (EditText) findViewById(R.id.binary1);
        decimal = (EditText) findViewById(R.id.decimal1);
        convert = (Button) findViewById(R.id.convert1);

        //OnClick Listeners
        convert.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        v.startAnimation(alpha);
        int id = v.getId();
        if (id == R.id.convert1) {
            String expression = binary.getText().toString();
            if (expression.equals("")) {
                Toast.makeText(BinToDec.this,"Enter a number first!",Toast.LENGTH_LONG).show();
            }
            else {
                int result = binToDec(expression);
                decimal.setText(result+"");
            }
        }
    }

    private int binToDec(String input) {
        int power = input.length() - 1;
        int result = 0;
        for (int i = 0;i < input.length();i++) {
            int number = Integer.decode(String.valueOf(input.charAt(i)));
            number = number * (int) Math.pow(2,power);
            result = result + number;
            power--;
        }
        return result;
    }
}
