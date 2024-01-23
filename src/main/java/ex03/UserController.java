package ex03;
@Controller
public class UserController {

    // /login
    @RequsetMapping(uri="/login")
    public void login() {
        System.out.println("로그인 호출됨");
    }

    // /join
    @RequsetMapping(uri="/join")
    public void join() {
        System.out.println("회원가입 호출됨");
    }

    @RequsetMapping(uri="/userinfo")
    public void userinfo() {
        System.out.println("유저정보 보기");
    }

    @RequsetMapping(uri="/update")
    public void updatePassword() {
        System.out.println("패스워드 수정하기");
    }
}

