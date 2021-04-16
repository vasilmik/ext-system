package edu.javacourse.register;

import edu.javacourse.register.rest.MarriageController;
import edu.javacourse.register.view.MarriageRequest;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Starter {

    /*XML
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext(new String[] {"springContex.xml"});


        MarriageController controller = context.getBean("control", MarriageController.class);
        controller.findMarriageCertificate(new MarriageRequest());

    }*/

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext(new String[] {"springContexAnnotation.xml"});


        MarriageController controller = context.getBean(MarriageController.class);
        controller.findMarriageCertificate(new MarriageRequest());

    }


}
