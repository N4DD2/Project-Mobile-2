package com.example.dany.jjdraw;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.text.method.LinkMovementMethod;

public class About extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        TextView t2 = (TextView) findViewById(R.id.credit);
        t2.setMovementMethod(LinkMovementMethod.getInstance());

        TextView t3 = (TextView) findViewById(R.id.source);
        t3.setMovementMethod(LinkMovementMethod.getInstance());
    }

}