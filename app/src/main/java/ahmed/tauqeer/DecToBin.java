package ahmed.tauqeer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DecToBin extends AppCompatActivity implements View.OnClickListener {

    //Creating Everything
    AlphaAnimation alpha = new AlphaAnimation(1F,0.7F);
    EditText decimal,binary;
    Button convert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dec_to_bin);

        //Components Initialization
        decimal = (EditText) findViewById(R.id.decimal);
        binary = (EditText) findViewById(R.id.binary);
        convert = (Button) findViewById(R.id.convert);

        //OnClick Listeners
        convert.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        v.startAnimation(alpha);
        int id = v.getId();
        if (id == R.id.convert) {
            String expression =  decimal.getText().toString();
            try {
                if (expression.equals("")) {
                    Toast.makeText(DecToBin.this,"Enter a number!",Toast.LENGTH_LONG).show();
                }
                else {
                    int value = Integer.valueOf(expression);
                    String output = Integer.toBinaryString(value);
                    binary.setText(output);
                }
            }catch (NumberFormatException e) {
                Toast.makeText(DecToBin.this,"Characters are prohibted!",Toast.LENGTH_LONG).show();
            }
        }
    }
}
