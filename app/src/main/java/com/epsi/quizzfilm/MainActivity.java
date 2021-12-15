package com.epsi.quizzfilm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
// Import de la bibliotèque view, button et toast
import android.os.PersistableBundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.epsi.quizzfilm.pojo.Questions;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Questions> questions = new ArrayList<>();
    int i = 1;
    int point = 0;
    Questions questionIn;
    public static final String KEY_QUESTION = "questionIn" ;
    private static final String TAG = "QuizzActivity";
    private static final String KEY_SCORE = "point";
    private static final String KEY_INDEX_QUESTION = "i";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.filmquizz2);
    //filtrer les logs
        Log.d(TAG, "onCreate() called");
        TextView questionText = findViewById(R.id.question);
        String question = getString(R.string.question_ai);
        //questionText.setText(question1.getText());
        Button buttonPour = findViewById(R.id.boutonDroit);
        Button buttonContre = findViewById(R.id.boutonGauche);
        TextView tvScore = findViewById(R.id.text);
        if(savedInstanceState != null){
            point = savedInstanceState.getInt(KEY_SCORE);
            i = savedInstanceState.getInt(KEY_INDEX_QUESTION);
        }

        Questions question1 = new Questions(1, question, true);
        question = getString(R.string.question_taxi_driver);
        Questions question2 = new Questions(2, question, true);
        question = getString(R.string.question_2001);
        Questions question3 = new Questions(3, question, false);
        question = getString(R.string.question_reservoir_dogs);
        Questions question4 = new Questions(4, question, true);
        question = getString(R.string.question_citizen_kane);
        Questions question5 = new Questions(5, question, false);
        questions.add(question1);
        questions.add(question2);
        questions.add(question3);
        questions.add(question4);
        questions.add(question5);



                questionIn = questions.get(i); //on récupère la question de la liste à l'index i
                questionText.setText(questions.get(i).getText()); // on change la question à l'index 0


    // Fonction pour l'action au click dur bouton contre
                        buttonContre.setOnClickListener(new View.OnClickListener() {



                            @Override
                            public void onClick(View v) {
    // si on a juste
                                if (questionIn.GetAnswer() == false) {
                                    Toast.makeText(getApplicationContext(),
                                            "Vous avez cliqué faux ! c'est correct",
                                            Toast.LENGTH_SHORT)
                                            .show();
                                    if(i < questions.size()){
                                        point = point +1;
                                        tvScore.setText("Score : " + point); // on change le text du score
    // si on a faux
                                    }
    // si on a faux
                                } else {
                                    Toast.makeText(getApplicationContext(),
                                            "Vous avez cliqué faux ! c'est faux",
                                            Toast.LENGTH_SHORT)
                                            .show();

                                }
                                //questionIn = questions.get(i++ %5);// % pour boucle infini
                               // questionText.setText(questionIn.getText());//prochaine question
                                if(i < questions.size()) {
                                    questionIn = questions.get(i++ );// % pour boucle infini
                                    questionText.setText(questionIn.getText());//prochaine question

                                }

                            }

                        });

    // Fonction pour l'action au click dur bouton Pour
                        buttonPour.setOnClickListener(new View.OnClickListener() {



                            @Override
                            public void onClick(View v) {
    // si on a juste
                                if (questionIn.GetAnswer() == true) {
                                    Toast.makeText(getApplicationContext(),
                                            "Vous avez cliqué vrai ! c'est correct",
                                            Toast.LENGTH_SHORT)
                                            .show();
                                    if(i < questions.size()){
                                        point = point +1;
                                    tvScore.setText("Score : " + point); // on change le text du score
    // si on a faux
                                    }
                                } else {
                                    Toast.makeText(getApplicationContext(),
                                            "Vous avez cliqué vrai ! c'est faux",
                                            Toast.LENGTH_SHORT)
                                            .show();
                                }
                               // questionIn = questions.get(i++ % 5); // % pour boucle infini
                                //questionText.setText(questionIn.getText()); // prochaine question
                                if(i < questions.size()) {
                                    questionIn = questions.get(i++ );// % pour boucle infini
                                    questionText.setText(questionIn.getText());//prochaine question

                                }
                            }
                        });

    }


    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        Log.d(TAG, "OnSaveInstanceState() called");
        outState.putInt(KEY_SCORE,point);
        outState.putInt(KEY_INDEX_QUESTION, i);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop() called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart() called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() called");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.cheat:
                // TODO lance la cheatActivity
                // crée un intent pour appeler activité
                Intent intent = new Intent(getApplicationContext(), CheatActivity.class);

                intent.putExtra(KEY_QUESTION, questionIn);

                // lance activity
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
