package br.com.ifsc.texttospeech;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import br.com.ifsc.texttospeech.R;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText etTextInput;
    private Button btnSpeak;
    private TextToSpeech textToSpeechHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTextInput = findViewById(R.id.editText);
        btnSpeak = findViewById(R.id.buttonSpeak);

        textToSpeechHelper = new TextToSpeech(this);

        btnSpeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = etTextInput.getText().toString();
                if (!text.isEmpty()) {
                    textToSpeechHelper.speak(text);
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}