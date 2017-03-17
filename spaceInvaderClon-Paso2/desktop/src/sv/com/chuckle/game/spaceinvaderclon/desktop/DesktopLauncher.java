package sv.com.chuckle.game.spaceinvaderclon.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import sv.com.chuckle.game.spaceinvaderclon.GameLoop;
import sv.com.chuckle.game.spaceinvaderclon.utils.Utils;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = Utils.ANCHO;
		config.height = Utils.ALTO;
		config.resizable =  false;
		config.title = "Space Invader - CLON";
		new LwjglApplication(new GameLoop(), config);
	}
}
