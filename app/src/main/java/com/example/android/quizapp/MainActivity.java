package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /**
     * This app displays a quiz app for french learners.
     */

    int trueQuestions = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method checks answers whether they are true or not.
     */
    public void findAnswers() {

        RadioButton answer1 = (RadioButton) findViewById(R.id.right1);
        boolean trueAnswer1 = answer1.isChecked();
        sumTrueQuestions(trueAnswer1);


        RadioButton answer2 = (RadioButton) findViewById(R.id.right2);
        boolean trueAnswer2 = answer2.isChecked();
        sumTrueQuestions(trueAnswer2);

        RadioButton answer3 = (RadioButton) findViewById(R.id.right3);
        boolean trueAnswer3 = answer3.isChecked();
        sumTrueQuestions(trueAnswer3);


        RadioButton answer4 = (RadioButton) findViewById(R.id.right4);
        boolean trueAnswer4 = answer4.isChecked();
        sumTrueQuestions(trueAnswer4);


        CheckBox wrong5a = (CheckBox) findViewById(R.id.wrong5a);
        CheckBox wrong5b = (CheckBox) findViewById(R.id.wrong5b);

        boolean wrongAnswer5a=wrong5a.isChecked();
        boolean wrongAnswer5b=wrong5b.isChecked();

        if(wrongAnswer5a==false && wrongAnswer5b==false){
            CheckBox answer5 = (CheckBox) findViewById(R.id.right5a);
            boolean trueAnswer5 = answer5.isChecked();
            if(trueAnswer5==true){
                answer5 = (CheckBox) findViewById(R.id.right5b);
                trueAnswer5 = answer5.isChecked();
                sumTrueQuestions(trueAnswer5);
            }

        }

        CheckBox wrong6a = (CheckBox) findViewById(R.id.wrong6a);
        CheckBox wrong6b = (CheckBox) findViewById(R.id.wrong6b);

        boolean wrongAnswer6a=wrong6a.isChecked();
        boolean wrongAnswer6b=wrong6b.isChecked();

        if(wrongAnswer6a==false && wrongAnswer6b==false){

            CheckBox answer6 = (CheckBox) findViewById(R.id.right6a);
            boolean trueAnswer6 = answer6.isChecked();
            if(trueAnswer6==true){
                answer6 = (CheckBox) findViewById(R.id.right6b);
                trueAnswer6 = answer6.isChecked();
                sumTrueQuestions(trueAnswer6);
            }
        }

    }

    /**
     * This method returns score to the user after hitting SUBMIT button.
     */

    public void submitAnswers(View view){

        EditText nameField = (EditText) findViewById(R.id.name_field);
        String name = nameField.getText().toString();
        findAnswers();
        String message;
        if(trueQuestions ==6){
            message = "Bonjour " + name + "! You answered all questions right! Félicitations ! ";

        }
        else{
            message = "Bonjour " + name + "! You answered " + trueQuestions +" right out of 6. Please try again or check the CHECK ANSWERS button to see correct solutions.";
        }

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        trueQuestions=0;

    }

    /**
     * This method returns the answers to the user after hitting CHECK ANSWER button.
     */

    public void checkAnswers(View view) {

        String message;

        TextView answer1 = (TextView) findViewById(R.id.right1);
        String quizAnswers = answer1.getText().toString();
        message = "Question 1. " + quizAnswers + "\n";

        TextView answer2 = (TextView) findViewById(R.id.right2);
        quizAnswers = answer2.getText().toString();
        message = message + "Question 2. " + quizAnswers + "\n";

        TextView answer3 = (TextView) findViewById(R.id.right3);
        quizAnswers = answer3.getText().toString();
        message = message + "Question 3. " + quizAnswers + "\n";

        TextView answer4 = (TextView) findViewById(R.id.right4);
        quizAnswers = answer4.getText().toString();
        displayMessage(quizAnswers);
        message = message + "Question 4. " + quizAnswers + "\n";

        TextView answer5a = (TextView) findViewById(R.id.right5a);
        quizAnswers = answer5a.getText().toString();
        displayMessage(quizAnswers);
        message = message + "Question 5. " + quizAnswers + ", ";

        TextView answer5b = (TextView) findViewById(R.id.right5b);
        quizAnswers = answer5b.getText().toString();
        message = message + quizAnswers + "\n";

        TextView answer6a = (TextView) findViewById(R.id.right6a);
        quizAnswers = answer6a.getText().toString();
        message = message + "Question 6. " + quizAnswers + ", ";

        TextView answer6b = (TextView) findViewById(R.id.right6b);
        quizAnswers = answer6b.getText().toString();
        message = message + quizAnswers;
        displayMessage(message);

    }
    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView submitAnswersTextView = (TextView) findViewById(R.id.summary_view);
        submitAnswersTextView.setText(message);
    }
    /**
     * This method sums up the number of correct answers.
     */
    private void sumTrueQuestions(boolean answer){
        if(answer == true){
        trueQuestions++;
        }

    }

}
