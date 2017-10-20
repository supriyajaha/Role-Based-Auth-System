package com.locus.role_system.main;

import com.locus.role_system.main.exception.ValidationException;
import com.locus.role_system.request_response.AuthorizationResponse;
import com.locus.role_system.service.AuthorizationService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AuthorizationTest {

    private static AuthorizationService authorizationService;

    static {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml");
        authorizationService = (AuthorizationService) context.getBean("authorizationService");
    }

    public static void main(String[] args) {
        System.out.println("dylan_locus has admin role on all resources");
        printOnConsole("dylan_locus", "file_team_a", "Read");
        printOnConsole("dylan_locus", "file_team_a", "create");
        printOnConsole("dylan_locus", "file_team_b", "delete");
        System.out.println();

        System.out.println("robin_locus has guest role on all resources");
        printOnConsole("robin_locus", "file_team_a", "read");
        printOnConsole("robin_locus", "file_team_a", "create");
        printOnConsole("robin_locus", "file_team_b", "delete");
        System.out.println();

        System.out.println("manu_locus has belongs to team_a and has read/update access on file_a and only read access on file_b");
        printOnConsole("manu_locus", "file_team_a", "read");
        printOnConsole("manu_locus", "file_team_a", "create");
        printOnConsole("manu_locus", "file_team_b", "create");
        printOnConsole("manu_locus", "file_team_b", "update");
        System.out.println();

        System.out.println("sameer_locus has belongs to team_b and has read/update access on file_b and only read access on file_a");
        printOnConsole("sameer_locus", "file_team_a", "read");
        printOnConsole("sameer_locus", "file_team_a", "create");
        printOnConsole("sameer_locus", "file_team_b", "create");
        printOnConsole("sameer_locus", "file_team_b", "delete");

        System.out.println("Invalid Input: ");
        printOnConsole(null,"file_team_a","");
    }

    private static void printOnConsole(String username, String resource, String actionType) {
        System.out.println(username +" attempting to "+ actionType+" "+resource);
        AuthorizationResponse authorizationResponse = isAuthorized(username,resource,actionType);
        if(authorizationResponse!=null)
            System.out.println("authorized - "+authorizationResponse.getAuthorized());
    }

    public static AuthorizationResponse isAuthorized(String username, String resource, String actionType){
        AuthorizationResponse authorizationResponse=null;
        try {
            validate(username,resource,actionType);
            authorizationResponse = authorizationService.isAuthorized(username, resource, actionType);
        }catch (ValidationException e) {
            System.err.println(e.getMessage());
        }catch (Exception ex){
            System.err.println("Exception occurred during checking authorization, please try again");
        }
        return authorizationResponse;
    }

    private static void validate(String username, String resource, String actionType) throws ValidationException {
        if(username==null||username.isEmpty()||resource==null||resource.isEmpty()||actionType==null||actionType.isEmpty()){
            throw new ValidationException("Input cannot be empty or null");
        }
    }
}
