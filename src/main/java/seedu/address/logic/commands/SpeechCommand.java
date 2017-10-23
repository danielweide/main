package seedu.address.logic.commands;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

/**
 *Translate Command Text Into Voice
 */
public class SpeechCommand {
    private static final String VOICENAME_kevin = "kevin16";

    /**
     * Speaks Method To Make Application Speaks
     */
    public void speak(String command) {
        Voice voice;
        VoiceManager voiceManager = VoiceManager.getInstance();
        voice = voiceManager.getVoice(VOICENAME_kevin);
        voice.allocate();
        voice.speak(command);
    }
}
