package edu.javacourse.greet;

import edu.javacourse.net.Greetable;

public class Evening extends Greetable {

    @Override
    public String buildResponse(String userName) {
        return "Good evening, "+ userName;
    }

}
