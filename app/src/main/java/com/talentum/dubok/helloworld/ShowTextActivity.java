package com.talentum.dubok.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

//Para no tener que poner Constants delante de las constantes
import static com.talentum.dubok.helloworld.Constants.*;

public class ShowTextActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_text);

        Intent i = getIntent();
        final String text = i.getStringExtra(KEY_INTENT_TEXT_MAIN);

        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_show_text, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_go_back){
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
