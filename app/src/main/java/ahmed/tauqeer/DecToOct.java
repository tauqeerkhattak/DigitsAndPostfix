package ahmed.tauqeer;

import android.app.SearchManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DecToOct extends AppCompatActivity implements View.OnClickListener {

    //Creating Everything
    AlphaAnimation alpha = new AlphaAnimation(1F,0.8F);
    EditText decimal,octal;
    Button convert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dec_to_oct);

        //Initializing components
        decimal = (EditText) findViewById(R.id.decimal2);
        octal = (EditText) findViewById(R.id.octal);
        convert = (Button) findViewById(R.id.convert2);

        //OnClick Listeners
        convert.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        v.startAnimation(alpha);
        int id = v.getId();
        if (id == R.id.convert2) {
            String expression = decimal.getText().toString();
            if (expression.equals("")) {
                Toast.makeText(DecToOct.this,"Enter a decimal number!",Toast.LENGTH_LONG).show();
            }
            else {
                int value = Integer.parseInt(expression);
                String result = Integer.toOctalString(value);
                octal.setText(result);
            }
        }
    }
}
