package com.example.jtest;

import java.util.HashMap;
import java.util.Locale;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends ActionBarActivity implements OnClickListener {
	Button btnTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnTest = (Button)findViewById(R.id.btn_test);
        btnTest.setOnClickListener(this);
        initSpeech();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
        case R.id.btn_test:
        	talk("this is a test apk.");
        	break;
		}
	}
	
	TextToSpeech testSpeech;
	HashMap map = new HashMap();
	private void initSpeech() { 
        testSpeech =new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() { 
            @Override 
            public void onInit(int status) { 
                if(status != TextToSpeech.ERROR) { 
                    testSpeech.setLanguage(Locale.ENGLISH); 
                } 
            } 
        }); 
 
        testSpeech.setOnUtteranceProgressListener(new UtteranceProgressListener() { 
            @Override 
            public void onStart(String utteranceId) { 
            } 
 
            @Override 
            public void onDone(String utteranceId) { 
            } 
 
            @Override 
            public void onError(String utteranceId) { 
            } 
        }); 
        map.put(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, "LumenDialer"); 
    } 
 
    /** 
     * 
     * @param text 
     */ 
    private void talk(String text){ 
        testSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, map); 
    } 

}
