package spacesurvival.model.sound;

import spacesurvival.utilities.path.SoundPath;


import java.io.IOException;
import java.util.Optional;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

	
public abstract class Sound {
    private static final double START_VOLUME = 0.50;
    private SoundPath soundPath;
    private double volume;
    private Optional<Clip> clip = Optional.empty();
    private boolean isPlaying;

    public Sound() {
        this.soundPath = null;
        this.volume = START_VOLUME;
    }


    public Sound(final SoundPath sound) {
        this.soundPath = sound;
        this.volume = START_VOLUME;

        AudioInputStream audioInputStream = null;

        try {
            audioInputStream = AudioSystem.getAudioInputStream(ClassLoader.getSystemResource(sound.getPath()));
            setClip(AudioSystem.getClip());
            getClip().get().open(audioInputStream);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    /** 
     * Set the current sound type. 
     * 
     * @param sound the soundType rappresenting the sound to be set.
     */
    public void setSoundType(final SoundPath sound) {
        this.soundPath = sound;
    }

    /** 
     * Return the sound type composed by the name, the path of the file wav and the specified type like effect or loop.
     * 
     * @return the sound type rappresenting the currrent sound.
     */
    public SoundPath getSoundType() {
       return this.soundPath;
    }

    /** 
     * Set the clip of the current sound.
     * 
     * @param clip that will be set in the sound.
     */
    public void setClip(final Clip clip) {
        this.clip = Optional.of(clip);
    }

    /** 
     * Return the clip of the current sound.
     * 
     * @return clip of the current sound.
     */
    public Optional<Clip> getClip() {
        return this.clip;
    }

    /** 
     * Return if the clip of the current sound is playing.
     * 
     * @return true if is playing
     */
    public boolean isPlaying() {
        return this.isPlaying;
    }

    /** 
     * Stop the clip of the current sound.
     * 
     */
    public void stopClip() {
        this.clip.get().stop();
        this.isPlaying = false;
    }

    /** 
     * Start the clip of the current sound.
     * 
     */
    public void startClip() {
        playSound(this.volume);
        this.isPlaying = true;
    }

    /** 
     * Method to be implemented for type loop or effect.
     * 
     * @param volume the volume that will be set before starting the sound.
     */
    protected abstract void playSound(double volume);

    /** 
     * Set the volume of sound.
     * 
     * @param volume the volume that will be set on the sound.
     */
    public void setVolume(final double volume) {
        this.volume = volume;
        final FloatControl gain = (FloatControl) getClip().get().getControl(FloatControl.Type.MASTER_GAIN);
        final float dB = (float) (Math.log(volume) / Math.log(10) * 20);

        gain.setValue(dB);
    }

    /** 
     * Get the volume of sound.
     * 
     * @return volume the volume that is set on the sound.
     */
    public double getVolume() {
        return this.volume;
    }


}