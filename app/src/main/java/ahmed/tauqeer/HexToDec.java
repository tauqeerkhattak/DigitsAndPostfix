package ahmed.tauqeer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class HexToDec extends AppCompatActivity implements View.OnClickListener {

    //Creating Everything
    AlphaAnimation alpha = new AlphaAnimation(1F,0.8F);
    EditText hexa,decimal;
    Button convert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hex_to_dec);

        //Initializing Components
        hexa = (EditText) findViewById(R.id.hexadecimal2);
        decimal = (EditText) findViewById(R.id.decimal5);
        convert = (Button) findViewById(R.id.convert5);

        //OnClick Listeners
        convert.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        v.startAnimation(alpha);
        if (v.getId() == R.id.convert5) {
            String expression = hexa.getText().toString();
            if (expression.equals("")) {
                Toast.makeText(HexToDec.this,"Enter a Hex number!",Toast.LENGTH_LONG).show();
            }
            else {
                int result = Integer.parseInt(expression,16);
                decimal.setText(result+"");
            }
        }
    }
}
