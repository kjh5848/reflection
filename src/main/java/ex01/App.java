package ex01;

public class App {
    public static void main(String[] args) {
        String path = "/lojin";


        UserController con = new UserController();

        if (path.equals("/login")) {
            con.login();
        } else if (path.equals("/join")) {
            con.join();
        }
    }
}
