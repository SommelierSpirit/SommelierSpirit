package com.example.daniel.sommelierspirit;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

import java.io.IOException;
import java.io.InputStream;


public class MainActivity extends ActionBarActivity {


    WebView wV1;
    InputStream fin;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wV1=(WebView)findViewById(R.id.wV1);
        try{
//            InputStream
                    fin = getAssets().open("sommelier_help.html");
            byte [] buffer = new byte [fin.available()];
            fin.read (buffer);
            fin.close();
            wV1.loadData(new String(buffer),"text/html","UTF-8");


        }catch(IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void buttonRegister(View v){
        Button Register= (Button) v;
        startActivity(new Intent(getApplicationContext(), Register.class));
    }

    public void buttonLogin(View v){
        Button Login = (Button) v;
        startActivity(new Intent(getApplicationContext(), Login.class));
    }
    public void buttonGuest(View v){
        Button Guest = (Button) v;
        startActivity(new Intent(getApplicationContext(), Guest.class));
    }

}
