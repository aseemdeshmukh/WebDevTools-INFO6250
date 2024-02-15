/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author aseem
 */
@WebServlet(name = "quiz", urlPatterns = "/quiz.htm")
public class QuizServlet extends HttpServlet {

    ArrayList<String> answers = new ArrayList<>();
    public void init(){
        answers.add("a");
        answers.add("b");
        answers.add("c");
        answers.add("d");
        answers.add("e");
        
    }
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        handle(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        handle(request, response);

    }

    private void handle(HttpServletRequest request, HttpServletResponse response) throws IOException {

//        Cookie c = new Cookie("name", "value");
//        response.addCookie(c);
        // Add a cookie before anything is printed bcoz the cookie will be sent to the headers
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(60 * 30);

        String ans;

        String question = request.getParameter("q");
        if (question == null) {
            question = "0";
        }

        ans = request.getParameter("ans");

        if (!question.equals("0")) {
            session.setAttribute(question, ans);
        }

        ans = request.getParameter("ans");
//        Cookie c = new Cookie(question, ans);
//        c.setMaxAge(60*60*24); // the expiry of cookie now is 1 day
//        response.addCookie(c);

        out.println("<html>");
        out.println("<body>");

        if (!question.equals("5")) {
            out.println("<form method = 'post' action = 'quiz.htm'>");
        }
        out.println("<h2>Welcome to the Quiz!</h2>");
        out.println("<h3>Session ID" + session.getId() + " </h3>");
        out.println("<h3>Last Accessed: " + session.getLastAccessedTime() + " </h3>");

        if (question.equals("0")) {

            // This is the 1st time we are accessing the quiz 
            out.println("<p>Question 1: Which is your favourite animal? </p>");
            out.println("<input type = 'radio' name='ans' value='a'> A) Dog <br>");
            out.println("<input type= 'radio' name= 'ans' value = 'b'> B) Cat <br>");
            out.println("<input type= 'radio' name= 'ans' value = 'c'> C) Panda <br>");
            out.println("<input type= 'radio' name= 'ans' value = 'd'> D) Tiger <br><br>");

            out.println("<input type='hidden' name='q' value='1'>");
        } else if (question.equals("1")) {
            // This means that the question 1 was submitted, the answer is shown and the question 2 is now displayed

//        ans = request.getParameter("ans");
            out.println("<p>Question 2: Which is your favourite colour? </p>");
            out.println("<input type = 'radio' name='ans' value='a'> A) Blue <br>");
            out.println("<input type= 'radio' name= 'ans' value = 'b'> B) Orange <br>");
            out.println("<input type= 'radio' name= 'ans' value = 'c'> C) Pink <br>");
            out.println("<input type= 'radio' name= 'ans' value = 'd'> D) Green <br><br>");

            out.println("<input type='hidden' name='q' value='2'>");

        } else if (question.equals("2")) {
            // This means that the question 2 was submitted, the answer is shown and the question 3 is now displayed

//        ans = request.getParameter("ans");
            out.println("<p>Question 3: Which is the largest state in USA? </p>");
            out.println("<input type = 'radio' name='ans' value='a'> A) Texas <br>");
            out.println("<input type= 'radio' name= 'ans' value = 'b'> B) Colorado <br>");
            out.println("<input type= 'radio' name= 'ans' value = 'c'> C) Alaska <br>");
            out.println("<input type= 'radio' name= 'ans' value = 'd'> D) Montana <br><br>");

            out.println("<input type='hidden' name='q' value='3'>");

        } else if (question.equals("3")) {
            // This means that the question 3 was submitted, the answer is shown and the question 4 is now displayed

//        ans = request.getParameter("ans");
            out.println("<p>Question 4: Which is the smallest state in USA?</p>");
            out.println("<input type = 'radio' name='ans' value='a'> A) Maine <br>");
            out.println("<input type= 'radio' name= 'ans' value = 'b'> B) Rhode Island <br>");
            out.println("<input type= 'radio' name= 'ans' value = 'c'> C) Connecticut <br>");
            out.println("<input type= 'radio' name= 'ans' value = 'd'> D) Vermont <br><br>");

            out.println("<input type='hidden' name='q' value='4'>");

        } else if (question.equals("4")) {
            // This means that the question 4 was submitted, the answer is shown and the question 5 is now displayed

//        ans = request.getParameter("ans");
            out.println("<p>Question 5: Which is the capital of India? </p>");
            out.println("<input type = 'radio' name='ans' value='a'> A) Mumbai <br>");
            out.println("<input type= 'radio' name= 'ans' value = 'b'> B) New Delhi <br>");
            out.println("<input type= 'radio' name= 'ans' value = 'c'> C) Bangalore <br>");
            out.println("<input type= 'radio' name= 'ans' value = 'd'> D) Hyderabad <br><br>");

            out.println("<input type='hidden' name='q' value='5'>");
        } else if (question.equals("5")) {
            // value ='5' indicates that we reached the final question, read answer 5 and display all the answers

            // GET THE COOKIES
//        Cookie[] cookies = request.getCookies();
            out.println("<h2>Here are all the answers.</h2>");
            out.println("<ul>");
//        for (Cookie co : cookies){
            out.println("<li Answer 1 : >" + session.getAttribute("1"));
            out.println("<li Answer 2 : >" + session.getAttribute("2"));
            out.println("<li Answer 3 : >" + session.getAttribute("3"));
            out.println("<li Answer 4 : >" + session.getAttribute("4"));
            out.println("<li Answer 5 : >" + session.getAttribute("5"));
            
            out.println("<h2>Here are the correct answers!</h2>");
            out.println("<ul>");
            out.println("<li Answer 1 : >" + answers.get(0));
            out.println("<li Answer 2 : >" + answers.get(1));
            out.println("<li Answer 3 : >" + answers.get(2));
            out.println("<li Answer 4 : >" + answers.get(3));
            out.println("<li Answer 5 : >" + answers.get(4));            

//        }
        }
        if (question == null || !question.equals("5")) {

            out.println("<input type= 'submit' value= 'Submit Answer' >");
            out.println("</form>");
        }

        out.println("</html>");
        out.println("</body>");

    }

}
