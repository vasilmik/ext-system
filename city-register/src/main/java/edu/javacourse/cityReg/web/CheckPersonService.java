package edu.javacourse.cityReg.web;

import edu.javacourse.cityReg.dao.PersonCheckDao;
import edu.javacourse.cityReg.dao.PoolConnectionBuilder;
import edu.javacourse.cityReg.domain.PersonRequest;
import edu.javacourse.cityReg.domain.PersonResponse;
import edu.javacourse.cityReg.exception.PersonCheckException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.PostRemove;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.time.LocalDate;

@Path("/check")
public class CheckPersonService {

    private static final Logger logger = LoggerFactory.getLogger(CheckPersonService.class);
    private PersonCheckDao dao;

    /*
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public PersonResponse checkPerson(@PathParam("id") int simpleID,
                                      @QueryParam("name") String simpleName){
        return new PersonResponse();
    }
     */
    /*
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public PersonRequest checkPerson(){
        PersonRequest pr = new PersonRequest();
        pr.setSurName("Vasilev");
        pr.setGivenName("Michael");
        pr.setPatronymic("Vladimirovich");
        pr.setDateOfBitch(LocalDate.of(1990,03,31));
        pr.setBuilding("8");
        pr.setExtension("2");
        pr.setApartment("1");
        return pr;
    } */

    @PostConstruct
    public void init(){
        logger.info("START");
        logger.info("SERVLET is created");
        dao = new PersonCheckDao();
        dao.setConnectionBuilder(new PoolConnectionBuilder());
    }

    @PreDestroy
    public void destroy() {
        logger.info("FINISH");
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public PersonResponse checkPersonTwo(PersonRequest pr) throws PersonCheckException {
        logger.info(pr.toString());
        return dao.checkPerson(pr);
    }

}
