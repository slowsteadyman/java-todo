package todo;

import java.util.Scanner;

public class View {
    public String chooseOption() {
        System.out.println("원하는 옵션을 선택해 주시기 바랍니다.\n"
            + "1. 할 일 추가\n"
            + "2. 할 일 조회\n"
            + "3. 할 일 수정\n"
            + "4. 할 일 삭제\n");

        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
