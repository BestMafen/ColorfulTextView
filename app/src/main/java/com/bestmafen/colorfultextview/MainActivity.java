package com.bestmafen.colorfultextview;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ColorfulTextView tv = (ColorfulTextView) findViewById(R.id.tv);
        tv.appendText(new Text("BLUE", Color.BLUE, 16), new OnTextClickListener() {

            @Override
            public void onTextClick(ColorfulTextView colorfulTextView, int position, String s) {
                Toast.makeText(MainActivity.this, position + s, Toast.LENGTH_SHORT).show();
            }
        });
        tv.appendText(new Text(" RED", Color.RED, 24), new OnTextClickListener() {

            @Override
            public void onTextClick(ColorfulTextView colorfulTextView, int position, String s) {
                Toast.makeText(MainActivity.this, position + s, Toast.LENGTH_SHORT).show();
            }
        });
        tv.appendText(new Text(" GREEN", Color.GREEN, 32), new OnTextClickListener() {

            @Override
            public void onTextClick(ColorfulTextView colorfulTextView, int position, String s) {
                Toast.makeText(MainActivity.this, position + s, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
