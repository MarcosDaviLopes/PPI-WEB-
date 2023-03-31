import android.content.Context;
import android.speech.tts.TextToSpeech;
import java.util.Locale;

public class TextToSpeechHelper implements TextToSpeech.OnInitListener {
    private TextToSpeech tts;
    private boolean isReady = false;

    public TextToSpeechHelper(Context context) {
        tts = new TextToSpeech(context, this);
    }

    public void speak(String text) {
        if (isReady) {
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
        }
    }

    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {
            tts.setLanguage(Locale.getDefault());
            isReady = true;
        }
    }
}