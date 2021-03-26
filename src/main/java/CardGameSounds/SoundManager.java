package CardGameSounds;

public interface SoundManager {

	void playSound(CardGameSounds sound);

	void loopSound(CardGameSounds sound);

	void stopSound(CardGameSounds sound);

	void stopAllSounds();

}
