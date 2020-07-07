
public class  BugTrackerRunner {
    public static void main(String[] args) {

/* LA CLASA


//        Session session = BugTrackerUtil.getSessionFactory().openSession();
//
//        Project project = session.find(Project.class, 1);
//        System.out.println(project)
//        session.close();

        System.out.println("------------------------");

        ProjectService ps = new ProjectService();
        Project projectById1 = ps.getProjectById(1);
        Project projectById2 = ps.getProjectById(2);

        System.out.println(projectById1);
        System.out.println(projectById2);

        System.out.println("----------------------------");

        // creare
//        Project newProj1 = ps.createProject("test1", "TST1");
//        Project newProj2 = ps.createProject("test2", "TST2");
//
//        System.out.println(newProj1);
//        System.out.println(newProj2);

        Project projectByName1 = ps.getProjectByName("test1");

        System.out.println(projectByName1);
    */



/*
        // USER TEST
        User userTest1 = new User();
        System.out.println(userTest1);

        User userTest2 = new User("Maria Matache");
        System.out.println(userTest2);

        User userTest3 = new User("Cristian Stanciu");
        User userTest4 = new User("Matei Constantin");
        User userTest5 = new User("Monica");

        UserService userService = new UserService();
//        userService.addUser(userTest2);
//        userService.addUser(userTest3);
//        userService.addUser(userTest4);
//        userService.addUser(userTest5);

        System.out.println(userService.showUser("Maria"));

        userService.editUserByName("Maria Popescu", "Maria Matache");

       // userService.deleteUser(userTest5);

       // userService.deleteUserByName("Matei Constantin");

 */

        BugTrackerUtil.shutdown();
    }
}
