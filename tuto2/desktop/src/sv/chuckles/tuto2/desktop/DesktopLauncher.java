package sv.chuckles.tuto2.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import sv.chuckles.tuto2.Tuto2;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title="Tutorial 2 - http://libgdxelsalvador.blogspot.com/";
		new LwjglApplication(new Tuto2(), config);
	}
}
