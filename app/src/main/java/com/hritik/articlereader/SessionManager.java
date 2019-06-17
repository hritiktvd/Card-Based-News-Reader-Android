package com.hritik.articlereader;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import java.util.HashMap;

@SuppressLint("CommitPrefEdits")
public class SessionManager {

    public static final String user_Id = "uid";
    public static final String user_name = "uname";
    public static final String user_email = "uemail";
    public static final String user_image = "uimage";

    // Sharedpref file name
    private static final String PREF_NAME = "userdetail";
    // All Shared Preferences Keys-
    private static final String IS_LOGIN = "IsLoggedIn";
    // Shared Preferences
    SharedPreferences pref;
    // Editor for Shared preferences
    Editor editor;
    // Context
    Context _context;
    // Shared pref mode
    int PRIVATE_MODE = 0;


    // Constructor
    public SessionManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }


    public void createLoginSession(String str_name, String str_email, String str_image) {
        // Storing login value as TRUE
        try {


            editor.putBoolean(IS_LOGIN, true);
            // Storing name in pref
            editor.putString(user_name, str_name);
            editor.putString(user_email, str_email);
            editor.putString(user_image, str_image);


            // commit changes
            editor.commit();

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }

    /**/

    /**
     * Check login method wil check user login status If false it will redirect
     * user to login page Else won't do anything
     */
    public int checkLogin() {
        // Check login status

        int flag;

        if (!this.isLoggedIn()) {
            // user is not logged in redirect him to LoginActivity Activity
            // Intent i = new Intent(_context, LoginActivity.class);
            // Closing all the Activities
            // i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            // Add new Flag to start new Activity
            // i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            // Staring LoginActivity Activity
            // _context.startActivity(i);

            flag = 0;
        } else {

            flag = 1;
        }

        return flag;
    }


    /**
     * Get stored session data
     */
    public HashMap<String, String> getUserDetails() {

        HashMap<String, String> user = new HashMap<String, String>();

        user.put(user_name, pref.getString(user_name, null));
        user.put(user_email, pref.getString(user_email, null));
        user.put(user_image, pref.getString(user_image, null));

        return user;
    }

    /**
     * Clear session details
     */
    public void clearUser() {
        // Clearing all data from Shared Preferences
        editor.clear();
        editor.commit();
    }

    public void logoutUser() {
        // Clearing all data from Shared Preferences
        editor.clear();
        editor.commit();

        // After logout redirect user to Loing Activity
        Intent i = new Intent(_context, WelcomeScreen.class);
        // Closing all the Activities
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        // Add new Flag to start new Activity
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        // Staring LoginActivity Activity
        _context.startActivity(i);
    }

    /**
     * Quick check for login
     **/
    // Get LoginActivity State
    public boolean isLoggedIn() {
        return pref.getBoolean(IS_LOGIN, false);
    }

}
