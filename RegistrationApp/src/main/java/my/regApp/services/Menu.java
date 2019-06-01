package my.regApp.services;


import my.regApp.dao.RoleDAO;
import my.regApp.model.Roles;
import my.regApp.model.Users;
import my.regApp.dao.UsersDAO;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.Scanner;

public class Menu {
    int firstAction;

    public int firstWindow(){
        Scanner sc = new Scanner(System.in);
        System.out.println("press 1 to enter\npress 2 to register");
        while(!sc.hasNextInt()) {
            System.out.println("only numbers, try again");
            sc.nextLine();
        }
        firstAction=sc.nextInt();
        return firstAction;
    }

    public void logIn(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring.xml");
        UsersDAO usersDAO = context.getBean(UsersDAO.class);
        RoleDAO roleDAO = context.getBean(RoleDAO.class);
        Scanner sc = new Scanner(System.in);
        Users user = new Users();
        Roles role = new Roles();
        role.setRole("admin");
        System.out.println("enter login");
        user.setLogin(sc.next());
        System.out.println("enter password");
        String password = sc.next();

        user.setPassword(password);
            usersDAO.findUser(user);
            if(usersDAO.findUser(user)==null){
                System.out.println("---------------------------");
                System.out.println("no such user");
                System.out.println("---------------------------");
            }else if(usersDAO.findUser(user).getPassword().equals(password)){

                if(usersDAO.findUser(user).getRoles().equals(roleDAO.findRole(role))){
                    System.out.println("---------------------------");
                    System.out.println("welcome, admin, " + usersDAO.findUser(user).getName() + " !");
                    System.out.println("---------------------------");
                }else {
                    System.out.println("---------------------------");
                    System.out.println("welcome, user, " + usersDAO.findUser(user).getName() + " !");
                    System.out.println("---------------------------");
                }
            }
            context.close();
    }

    public void register(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring.xml");
        UsersDAO usersDAO = context.getBean(UsersDAO.class);
        Users user = new Users();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter login");
        String login = sc.next();
        user.setLogin(login);
        System.out.println("Enter password");
        String password = sc.next();
        user.setPassword(password);
        usersDAO.save(user);
        context.close();
    }

    public int getAction(){
        return this.firstAction;
    }

}
