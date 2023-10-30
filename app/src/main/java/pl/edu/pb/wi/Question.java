package pl.edu.pb.wi;

public class Question {
    private final int questionId;
    private final boolean trueAnswer;

    public Question(int questionId, boolean trueAnswer) {
        this.questionId = questionId;
        this.trueAnswer = trueAnswer;
    }

    public int getQuestionId() {
        return questionId;
    }

    public boolean isTrueAnswer() {
        return trueAnswer;
    }
}

