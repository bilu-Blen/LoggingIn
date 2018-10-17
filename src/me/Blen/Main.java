package me.Blen;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
	// write your code here
        //creating a list of Roles and adding instance of roles to it
        Scanner scan = new Scanner(System.in);
        ArrayList<Role> rolesList = new ArrayList<>();
        ArrayList<User> usersList = new ArrayList<>();


        //manually adding a new role
        Role roleOne = new Role();
        roleOne.setId(1234);
        roleOne.setName("Admin");
        rolesList.add(roleOne);

        Role roleTwo = new Role();
        roleTwo.setId(4321);
        roleTwo.setName("Organization");
        rolesList.add(roleTwo);

        //manually adding a new user
        User userOne = new User();
        userOne.setId(12345);
        userOne.setUserName("Blen");
        userOne.setPassword("12345re");
        usersList.add(userOne);
        userOne.getRolesListForUser().add(roleOne);

        //give the user a choice to either to sign-up or login
        System.out.println("Hello, what do you want to do today? Sign-up/Login");
        String choice= scan.nextLine();

        if(choice.equalsIgnoreCase("Sign-up")){
            User user = new User();

            System.out.println("Enter your id");
            long userId = scan.nextLong();
            scan.nextLine();
            user.setId(userId);

            System.out.println("Enter a user name ");
            String userName = scan.nextLine();
            user.setUserName(userName);

            System.out.println("Create a password  ");
            String userPassword = scan.nextLine();
            user.setPassword(userPassword);

            System.out.println("Do you want to add your role? Y/N");
            String addRoleNowLater = scan.nextLine();
                if(addRoleNowLater.equalsIgnoreCase("y")){
                    addRoleMethod(user, rolesList, scan);
                    }

        }else if(choice.equalsIgnoreCase("login")){
            //enter a username
            System.out.println("Enter your username");
            String loginUserName = scan.nextLine();

            for(User userEach : usersList){
                if(loginUserName.equalsIgnoreCase(userEach.getUserName())){
                    System.out.println("Enter your password");
                    String loginPassword = scan.nextLine();
                    if(loginPassword.equalsIgnoreCase(userEach.getPassword())){
                        System.out.println("You are now logged in");
                        //show the user his/her roles after
                        for(Role role : userEach.getRolesListForUser()){
                            System.out.println("Your roles are: " + role.getName());
                        }

                        //give the user an option to add more roles
                        System.out.println("Do you want to add roles to the user");

                        //add new roles to the user
                        addRoleMethod(userEach,rolesList, scan);

                    }else{
                        System.out.println("The password you entered is incorrect");
                    }
                }else{
                    System.out.println("The user name you have entered is incorrect");
                }
            }
        }else{
            System.out.println("Your choice is invalid");
        }
    }

    public static void addRoleMethod(User user, ArrayList<Role> rolesList, Scanner scan){
        System.out.println("You can either add a role from existing roles or add a new role.\n Do you want add a new role?  Y/N");
        String newRole = scan.nextLine();
        if(newRole.equalsIgnoreCase("n")){
            System.out.println("You have chose to add a role from existing roles. The existing roles are:\n");
            for(Role roleEach : rolesList){
                System.out.println(roleEach.getName() + "\n" );

            }
            //user choosing the role they want
            System.out.println("which role do you choose? ");
            String userRoleChoice = scan.nextLine();

            for(Role roleEach : rolesList){
                if(userRoleChoice.equalsIgnoreCase(roleEach.getName())){
                    for (Role role : user.getRolesListForUser()){
                        if(role.getName().equalsIgnoreCase(userRoleChoice)){
                            System.out.println(userRoleChoice + "-   this role is already give to the user");
                        }else{
                            roleEach.getUsersListForRole().add(user);
                            user.getRolesListForUser().add(roleEach);

                            System.out.println(roleEach.getName() + " role as been added to " + user.getUserName() + " user");
                        }
                    }

                }
            }
        }else{
            //the user is adding a new role
            Role userNewRole = new Role();
            System.out.println(" You have chosen to add a new role for the user");

            System.out.println("What is the id of the Role");
            long idUserNewRole = scan.nextLong();
            scan.nextLine();
            userNewRole.setId(idUserNewRole);

            System.out.println("What is the name of the role");
            String nameUserNewRole = scan.nextLine();
            userNewRole.setName(nameUserNewRole);

            for (Role role : user.getRolesListForUser()) {
                if (role.getName().equalsIgnoreCase(userNewRole.getName())) {
                    System.out.println(userNewRole.getName() + " -   this role is already give to the user");
                } else {
                    rolesList.add(userNewRole);
                    user.getRolesListForUser().add(userNewRole);
                    userNewRole.getUsersListForRole().add(user);
                    System.out.println("You have successfully added the role to the user and the user to the role");
                }
            }



        }
    }
}
