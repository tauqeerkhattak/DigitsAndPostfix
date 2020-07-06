package ahmed.tauqeer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;

public class NotationsActivity extends AppCompatActivity implements View.OnClickListener {

    //Creating Everything
    AlphaAnimation alpha = new AlphaAnimation(1F,0.8F);
    Button in,post,pre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notations);

        //Initializing Components
        in = (Button) findViewById(R.id.in);
        post = (Button) findViewById(R.id.post);
        pre = (Button) findViewById(R.id.pre);

        //OnClick Listeners
        in.setOnClickListener(this);
        post.setOnClickListener(this);
        pre.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        v.startAnimation(alpha);
        if (v.getId() == R.id.in) {
            Intent intent = new Intent(NotationsActivity.this,InFixActivity.class);
            startActivity(intent);
        }
        else if (v.getId() == R.id.post) {

        }
        else if (v.getId() == R.id.pre) {

        }
    }
}
