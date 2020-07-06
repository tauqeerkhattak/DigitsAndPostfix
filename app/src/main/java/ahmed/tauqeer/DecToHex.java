package ahmed.tauqeer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DecToHex extends AppCompatActivity implements View.OnClickListener {

    //Creating Everything
    AlphaAnimation alpha = new AlphaAnimation(0.8F,1F);
    EditText decimal,hexa;
    Button convert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dec_to_hex);

        //Components Initialization
        decimal = (EditText) findViewById(R.id.decimal4);
        hexa = (EditText) findViewById(R.id.hexadecimal);
        convert = (Button) findViewById(R.id.convert4);

        //OnClick Listeners
        convert.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        v.startAnimation(alpha);
        if (v.getId() == R.id.convert4) {
            String expression = decimal.getText().toString();
            if (expression.equals("")) {
                Toast.makeText(DecToHex.this,"Enter a decimal number!",Toast.LENGTH_LONG).show();
            }
            else {
                String result = Integer.toHexString(Integer.parseInt(expression));
                hexa.setText(result);
            }
        }
    }
}
