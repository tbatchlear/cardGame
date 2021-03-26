package CardGameSounds;

import java.io.BufferedInputStream;
import java.net.URL;
import java.util.EnumMap;
import java.util.Map;
import java.util.function.Function;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * Sound manager for card games
 * 
 * @author Tom Batchlear
 */
public class soundEffects implements SoundManager {

	private final Function<CardGameSounds, URL> fnSoundURL;
	private final Map<CardGameSounds, Clip> clipCache = new EnumMap<>(CardGameSounds.class);


	public soundEffects(Function<CardGameSounds, URL> fnSoundURL) {
		this.fnSoundURL = fnSoundURL;
	}

	private Clip createAndOpenClip(URL url) {
		try (BufferedInputStream bs = new BufferedInputStream(url.openStream())) {
			try (AudioInputStream as = AudioSystem.getAudioInputStream(bs)) {
				Clip clip = AudioSystem.getClip();
				clip.open(as);
				return clip;
			}
		} catch (Exception x) {
			throw new RuntimeException("Error opening audio clip", x);
		}
	}

	private Clip getClip(CardGameSounds sound) {
		Clip clip = null;
		if (clipCache.containsKey(sound)) {
			clip = clipCache.get(sound);
		} else {
			clip = createAndOpenClip(fnSoundURL.apply(sound));
			clipCache.put(sound, clip);
		}
		clip.setFramePosition(0);
		return clip;
	}

	@Override
	public void playSound(CardGameSounds sound) {
		getClip(sound).start();
	}

	@Override
	public void loopSound(CardGameSounds sound) {
		getClip(sound).loop(Clip.LOOP_CONTINUOUSLY);
	}

	@Override
	public void stopSound(CardGameSounds sound) {
		getClip(sound).stop();
	}

	@Override
	public void stopAllSounds() {
            for (Clip clip : clipCache.values()) {
                    clip.stop();
            }
	}
}