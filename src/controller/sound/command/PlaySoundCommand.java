package controller.sound.command;

import model.sound.Sound;

public class PlaySoundCommand implements CommandAudio {

	@Override
	public void execute(Sound sound) {
		System.out.println("Start Sound");
		sound.startClip();
		//setSoundType(st);
		//startClip();	
	}
}
