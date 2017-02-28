package sv.com.chuckle.game.spaceinvaderclon.utils;

import com.badlogic.gdx.Gdx;

public class Utils {
    public static int ANCHO = 480;
    public static int ALTO = 650;
    public static boolean IS_DEBUG = true;

    public static void log(String tag,String message){
        if(IS_DEBUG)
            Gdx.app.log(tag, message);
    }

}
