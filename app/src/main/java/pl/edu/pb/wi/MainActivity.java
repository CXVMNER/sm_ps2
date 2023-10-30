package pl.edu.pb.wi;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView questionTextView;

    private final Question[] questions = new Question[] {
            new Question(R.string.q_angielski, true),
            new Question(R.string.q_apple, false),
            new Question(R.string.q_bsd, false),
            new Question(R.string.q_ms, true),
            new Question(R.string.q_ziemia, false)
    };

    private int currentIndex = 0;

    private int score = 0;

    private void checkAnswerCorrectness(boolean userAnswer) {
        boolean correctAnswer = questions[currentIndex].isTrueAnswer();
        int resultMessageId;
        if (userAnswer == correctAnswer) {
            resultMessageId = R.string.correct_answer;
            score++;
        } else {
            resultMessageId = R.string.incorrect_answer;
        }
        Toast.makeText(this, resultMessageId, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button trueButton = findViewById(R.id.true_button);
        Button falseButton = findViewById(R.id.false_button);
        Button nextButton = findViewById(R.id.next_button);
        questionTextView = findViewById(R.id.question_text_view);

        trueButton.setOnClickListener(v -> checkAnswerCorrectness(true));

        falseButton.setOnClickListener(v -> checkAnswerCorrectness(false));

        nextButton.setOnClickListener(v -> {
            currentIndex = (currentIndex + 1) % questions.length;
            setNextQuestion();
        });

        setNextQuestion();
    }

    private void setNextQuestion() {
        if (currentIndex == questions.length - 1) {
            questionTextView.setText(questions[currentIndex].getQuestionId());
            Toast.makeText(this, "Twój wynik to: " + score, Toast.LENGTH_LONG).show();
        } else {
            questionTextView.setText(questions[currentIndex].getQuestionId());
        }
    }
}
