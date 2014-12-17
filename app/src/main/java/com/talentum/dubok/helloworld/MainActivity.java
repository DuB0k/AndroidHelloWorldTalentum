package com.talentum.dubok.helloworld;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity{

    Button bttHello;
    int mNumClick = 0;
    EditText txtInput;
    TextView lblTitle;
    ImageView mImgPhoto;
    int mResImg = R.drawable.single;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImgPhoto = (ImageView) findViewById(R.id.imgPhoto);

        txtInput = (EditText) findViewById(R.id.txtInput);
        lblTitle = (TextView) findViewById(R.id.lblTitle);

        bttHello = (Button) findViewById(R.id.bttHello);
        bttHello.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.d("Debug.Main","Hello World, button clicked "+ ++mNumClick);
                final String text = txtInput.getText().toString();
                lblTitle.setText(""+text);

                if (mResImg == R.drawable.futurama) {
                    mResImg = R.drawable.single;
                }
                else {
                    mResImg = R.drawable.futurama;
                }

                Bitmap bm = BitmapFactory.decodeResource(getResources(), mResImg);
                mImgPhoto.setImageBitmap(bm);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        if (id == R.id.action_show_text_activity){
            final String text = txtInput.getText().toString();
            Intent i = new Intent(this, ShowTextActivity.class);
            i.putExtra(Constants.KEY_INTENT_TEXT_MAIN, text);
            startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }
}
