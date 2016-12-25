package remix.myplayer.util;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by taeja on 16-1-15.
 */

/**
 * SharedPrefs工具类
 */
public class SPUtil {
    public static SPUtil mInstance;
    public SPUtil() {
        if(mInstance == null)
            mInstance = this;
    }

    public static boolean putStringSet(Context context, String name, String key, Set<String> set){
        if(set == null)
            return false;
        SharedPreferences.Editor editor = context.getSharedPreferences(name,Context.MODE_PRIVATE).edit();
        editor.remove(key);
        return editor.putStringSet(key,set).commit();
    }

    public static Set<String> getStringSet(Context context, String name, String key){
        return context.getSharedPreferences(name,Context.MODE_PRIVATE).getStringSet(key,new HashSet<String>());
    }

    public static boolean putValue(Context context,String name,String key,int value) {
        SharedPreferences.Editor editor = context.getSharedPreferences(name,Context.MODE_PRIVATE).edit();
        return editor.putInt(key,value).commit();
    }

    public static boolean putValue(Context context,String name,String key,String value) {
        SharedPreferences.Editor editor = context.getSharedPreferences(name,Context.MODE_PRIVATE).edit();
        return editor.putString(key,value).commit();
    }

    public static boolean putValue(Context context,String name,String key,boolean value) {
        SharedPreferences.Editor editor = context.getSharedPreferences(name,Context.MODE_PRIVATE).edit();

        return editor.putBoolean(key,value).commit();
    }

    public static boolean getValue(Context context,String name,String key,boolean dft) {
        return context.getSharedPreferences(name,Context.MODE_PRIVATE).getBoolean(key,dft);
    }

    public static int getValue(Context context,String name,String key,int dft) {
        return context.getSharedPreferences(name,Context.MODE_PRIVATE).getInt(key,dft);
    }

    public static String getValue(Context context,String name,String key,String dft) {
        return context.getSharedPreferences(name,Context.MODE_PRIVATE).getString(key,dft);
    }

    public static void deleteValue(Context context,String name,String key) {
        SharedPreferences.Editor editor = context.getSharedPreferences(name,Context.MODE_PRIVATE).edit();
        editor.remove(key).apply();
    }

    public static void deleteFile(Context context,String name) {
        SharedPreferences.Editor editor = context.getSharedPreferences(name,Context.MODE_PRIVATE).edit();
        editor.clear().apply();
    }

}
