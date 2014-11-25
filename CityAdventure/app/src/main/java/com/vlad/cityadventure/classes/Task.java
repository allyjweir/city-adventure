package com.vlad.cityadventure.classes;

/**
 * A task is associated with a specific landmark (can be city)
 * Can have steps (maybe?) and conditions for completion.
 * <p/>
 * Could a quiz/poll be a type of task? - Ally
 */
public class Task {

    public enum TaskType {QUESTION, PHOTO}

    private String landmark;
    protected TaskType type;

    public Task(TaskType type, String landmark) {
        this.type = type;
        this.landmark = landmark;
    }

    public TaskType getType() {
        return type;
    }

    public void setType(TaskType type) {
        this.type = type;
    }

    public static class QuestionTask extends Task{
        private String[] options;
        private int answer;
        private String question;

        public QuestionTask(TaskType type, String landmark, String[] options, int answer, String question) {
            super(type, landmark);
            this.options = options;
            this.answer = answer;
            this.question = question;
        }

        public String[] getOptions() {
            return options;
        }

        public void setOptions(String[] options) {
            this.options = options;
        }

        public int getAnswer() {
            return answer;
        }

        public void setAnswer(int answer) {
            this.answer = answer;
        }

        public String getQuestion() {
            return question;
        }

        public void setQuestion(String question) {
            this.question = question;
        }
    }
}
