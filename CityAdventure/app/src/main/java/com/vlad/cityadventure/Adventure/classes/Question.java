package com.vlad.cityadventure.Adventure.classes;

/**
 * A question with the question text, answer options and the correct answer
 * Used for quizzes (we might decide to use the same class for polls too?)
 * I did not add a quiz and a poll class, because we could just use a boolean to tell which one it is
 * Or not
 */

/**
 * How would we collect a quiz's questions together?
 */

import java.lang.Boolean;
import java.lang.String;

import com.vlad.cityadventure.Adventure.classes.Landmark;


public class Question {
    public String question_text;
    public String[][] answers;  //First field stores the answer text, the second a 1 for true, 0 for false
    public boolean quiz;
    public boolean poll;
    public Landmark landmark;  //The landmark the question is tied to.
    public int points;

    // Constructor
    public Question(String qt, String[][] ans, Boolean quiz, Boolean poll, Landmark landmark, int points) {
        this.question_text = qt;
        this.answers = ans;
        this.quiz = quiz;
        this.poll = poll;
        this.landmark = landmark;
        this.points = points
    }

    // Copy Constructor
    public Question(Question q) {
        this.question_text = q.question_text;
        this.answers = q.answers;
        this.quiz = q.quiz;
        this.poll = q.poll;
        this.landmark = q.landmark;
        this.points = q.points

    }

    public Boolean isQuiz() {
        return quiz;
    }

    public Boolean isPoll() {
        return poll;
    }

    public String getQuestion_text() {
        return question_text;
    }

    public void setQuestion_text(String question_text) {
        this.question_text = question_text;
    }

    public String[][] getAnswers() {
        return answers;
    }

    public void setAnswers(String[][] answers) {
        this.answers = answers;
    }

    public Boolean getQuiz() {
        return quiz;
    }

    public void setQuiz(Boolean quiz) {
        this.quiz = quiz;
    }

    public Boolean getPoll() {
        return poll;
    }

    public void setPoll(Boolean poll) {
        this.poll = poll;
    }

    public Landmark getLandmark() {
        return landmark;
    }

    public void setLandmark(Landmark landmark) {
        this.landmark = landmark;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
