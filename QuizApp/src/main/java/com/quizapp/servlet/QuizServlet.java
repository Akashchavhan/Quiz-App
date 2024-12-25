package com.quizapp.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/quiz") // URL pattern defined directly on the servlet class
public class QuizServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set content type for response
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Retrieve quiz answers from the form parameters
        String q1Answer = request.getParameter("q1");
        String q2Answer = request.getParameter("q2");
        String q3Answer = request.getParameter("q3");
        String q4Answer = request.getParameter("q4");
        String q5Answer = request.getParameter("q5");
        String q6Answer = request.getParameter("q6");
        String q7Answer = request.getParameter("q7");
        String q8Answer = request.getParameter("q8");
        String q9Answer = request.getParameter("q9");
        String q10Answer = request.getParameter("q10");

        // Correct answers
        Map<String, String> correctAnswers = new HashMap<>();
        correctAnswers.put("q1", "HyperText Markup Language");
        correctAnswers.put("q2", "C");
        correctAnswers.put("q3", "Styling web pages");
        correctAnswers.put("q4", "HTML");
        correctAnswers.put("q5", "<a>");
        correctAnswers.put("q6", "JavaScript");
        correctAnswers.put("q7", "Declares a variable");
        correctAnswers.put("q8", "public void method()");
        correctAnswers.put("q9", "class");
        correctAnswers.put("q10", "22");

        // Array of answers provided by the user
        String[] userAnswers = {q1Answer, q2Answer, q3Answer, q4Answer, q5Answer,
                                 q6Answer, q7Answer, q8Answer, q9Answer, q10Answer};

        // Calculate the score
        int score = 0;
        for (int i = 0; i < userAnswers.length; i++) {
            if (userAnswers[i] != null && userAnswers[i].equals(correctAnswers.get("q" + (i + 1)))) {
                score++;
            }
        }

        // Provide feedback and results
        out.println("<html><body>");
        out.println("<h1>Your Score: " + score + " out of 10</h1>");
        out.println("<h2>Feedback:</h2>");
        
        // Providing detailed feedback for each question
        String[] questions = {
            "What does HTML stand for?",
            "Which programming language is known as the 'mother of all languages'?",
            "What is the purpose of CSS in web development?",
            "Which of the following is NOT a programming language?",
            "Which tag is used for creating a hyperlink in HTML?",
            "Which language is primarily used for web development?",
            "What does the 'var' keyword do in JavaScript?",
            "Which is the correct syntax for a Java method declaration?",
            "Which of the following is used to define a class in Python?",
            "What is the output of console.log(2 + '2') in JavaScript?"
        };

        for (int i = 0; i < questions.length; i++) {
            out.println("<p><strong>" + questions[i] + "</strong><br>");
            if (userAnswers[i] != null && userAnswers[i].equals(correctAnswers.get("q" + (i + 1)))) {
                out.println("Your answer: " + userAnswers[i] + " (Correct)</p>");
            } else {
                out.println("Your answer: " + userAnswers[i] + " (Incorrect)</p>");
            }
        }

        out.println("<br><a href='index.html'>Try Again</a>");
        out.println("</body></html>");
    }
}
