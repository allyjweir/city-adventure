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
    private String description;
    protected TaskType type;

    public Task(String description, TaskType type, String landmark) {
        this.type = type;
        this.landmark = landmark;
        this.description = description;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

        public QuestionTask(String description, TaskType type, String landmark, String[] options, int answer, String question) {
            super(description, type, landmark);
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
