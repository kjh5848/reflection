package ex03;

@Controller
public class BoardController {

    @RequsetMapping(uri="/w")
    public void write() {
        System.out.println("글쓰기 호출됨");
    }
}
