package com.beatricefarias.quizapp;

import android.util.Log;

/**
 *
 */

public class QuizQuestions {

    private String mQuestions[] = {
            "Lithuania's official language is Russian.",
            "Lithuania is part of the Baltic States country.",
            "The Lithuanian language is one of the oldest languages in the world.",
            "Lithuania is part of the European Union.",
            "Lithuania's capital is Riga",
            "The Lithuanian language is a Baltic language.",
            "Lithuania is an Eastern European country.",
            "Lithuania has one of the fastest Internet connections in the world.",
            "Lithuania has summer.",
            "Lithuanian cuisine contains a lot of potatoes."
    };

    private boolean mCorrectAnswer[] = {
            false,
            false,
            true,
            true,
            false,
            true,
            false,
            true,
            true,
            true,
    };

    private String mAnswers[] = {
            "While some Lithuanians do speak Russian, especially the older generation, the official language of Lithuania is Lithuanian.",
            "Lithuania is an independent country in the Baltic region, but Baltic States as a country does not exist.",
            "Lithuanian language is the oldest surviving Indo-European languages, spoken by about 4 million people.",
            "Lithuania is a member of the European Union, including Eurozone and Schengen.",
            "Lithuania's capital is Vilnius, one of the largest and oldest cities in the country.",
            "There are only 2 remaining Baltic languages in the world: Lithuanian and Latvian.",
            "While Lithuania used to be an Eastern European country, recently the United Nations classified Lithuania as part of Northern Europe.",
            "Lithuania has a very fast Internet connection, average speed rate is 45 Mbps.",
            "Lithuania has four seasons, including summer. It can get very hot over the summer too.",
            "Lithuanian cuisine definitely consists of a lot of potatoes. Most traditional dishes, such as celepinai and bulviniai blynai are potato based. "
    };

    public String getQuestion(int index) {
        String question = mQuestions[index];
        return question;
    }

    public String getAnswer(int index) {
        String answer = mAnswers[index];
        return answer;
    }

    public boolean getCorrectAnswer(int index) {
        boolean correctAnswer = mCorrectAnswer[index];
        return correctAnswer;
    }

    public int getQuestionsQuantity() {
        int questionsQuantity = mQuestions.length;
        return questionsQuantity;
    }

}
