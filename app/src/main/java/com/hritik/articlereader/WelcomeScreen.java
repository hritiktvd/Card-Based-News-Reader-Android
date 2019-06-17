package com.hritik.articlereader;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class WelcomeScreen extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {

    ImageView logosmall;
    TextView titletext, titletagline;
    Button signin, signup;
    private static final String TAG = "WelcomeScreen";
    private static final int RC_SIGN_IN = 1;
    String name, email, image;
    String idToken;
    SessionManager sessionManager;
    private SignInButton signInButton;
    private GoogleApiClient googleApiClient;
    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener authStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        //session
        sessionManager = new SessionManager(this);

        firebaseAuth = com.google.firebase.auth.FirebaseAuth.getInstance();
        //this is where we start the Auth state Listener to listen for whether the user is signed in or not
        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                // Get signedIn user
                FirebaseUser user = firebaseAuth.getCurrentUser();

                //if user is signed in, we call a helper method to save the user details to Firebase
                if (user != null) {
                    // User is signed in
                    // you could place other firebase code
                    //logic to save the user details to Firebase
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                }
            }
        };


        signInButton = findViewById(R.id.google_signin);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                        .requestIdToken(getString(R.string.web_client_id))//you can also use R.string.default_web_client_id
                        .requestEmail()
                        .build();

                googleApiClient = new GoogleApiClient.Builder(WelcomeScreen.this)
                        .enableAutoManage(WelcomeScreen.this, WelcomeScreen.this)
                        .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                        .build();

                googleApiClient.connect();

                Intent intent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
                startActivityForResult(intent, RC_SIGN_IN);
            }
        });
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleSignInResult(result);
        }
    }

    private void handleSignInResult(GoogleSignInResult result) {
        if (result.isSuccess()) {
            GoogleSignInAccount account = result.getSignInAccount();
            idToken = account.getIdToken();
            name = account.getDisplayName();
            email = account.getEmail();
            image = String.valueOf(account.getPhotoUrl());
            // you can store user data to SharedPreference
            AuthCredential credential = GoogleAuthProvider.getCredential(idToken, null);
            firebaseAuthWithGoogle(credential);
        } else {
            // Google Sign In failed, update UI appropriately
            Log.e(TAG, "Login Unsuccessful. " + result);
            Toast.makeText(this, "Login Unsuccessful" + result, Toast.LENGTH_SHORT).show();
        }
    }

    private void firebaseAuthWithGoogle(AuthCredential credential) {

        firebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "signInWithCredential:onComplete:" + task.isSuccessful());
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "Login successful", Toast.LENGTH_SHORT).show();
                            gotoProfile();
                        } else {
                            Log.w(TAG, "signInWithCredential" + task.getException().getMessage());
                            task.getException().printStackTrace();
                            Toast.makeText(getApplicationContext(), "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }

                    }
                });
    }

/*    GoogleSignInOptions gso =  new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.web_client_id))//you can also use R.string.default_web_client_id
            .requestEmail()
            .build();*/


    private void gotoProfile() {
        sessionManager.createLoginSession(name, email, image);
        Intent intent = new Intent(WelcomeScreen.this, Hamburger_menu.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (authStateListener != null) {
            FirebaseAuth.getInstance().signOut();
        }
        firebaseAuth.addAuthStateListener(authStateListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (authStateListener != null) {
            firebaseAuth.removeAuthStateListener(authStateListener);
        }
    }

}


/*     OLD INTENT WITHOUT SIGN IN WORKING

  signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i_signin = new Intent(WelcomeScreen.this, MainActivity.class);
                startActivity(i_signin);
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i_signup = new Intent(WelcomeScreen.this, Signup.class);
                startActivity(i_signup);
            }
        });*/




