package com.epsi.quizzfilm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.epsi.quizzfilm.pojo.Questions;

public class CheatActivity extends AppCompatActivity {
    private TextView tvResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        // récupère les éléments
        tvResponse = findViewById(R.id.tvResponse);
        //récupère l'intent qui à permit d'appeler cette activité
        Intent intent = getIntent();
        // récupère objet question
        Questions question = (Questions) intent.getSerializableExtra(MainActivity.KEY_QUESTION);
        tvResponse.setText(String.format("%s : %s", question.getText(), question.GetAnswer()));

    }
}