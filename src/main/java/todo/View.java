package todo;

import java.util.HashMap;
import java.util.Map;

public class View {
    public static String readOption() {
        System.out.println("""
            원하는 옵션을 선택해 주시기 바랍니다.
            1. 할 일 추가
            2. 할 일 조회
            3. 할 일 수정
            4. 할 일 삭제
            """);
        return Helper.readLine();
    }

    public static String readTodoName() {
        System.out.println("할일 이름을 입력해 주시기 바랍니다.");
        return Helper.readLine();
    }

    public static String readTodoDescription() {
        System.out.println("할일 설명을 입력해 주시기 바랍니다. 꼭 입력하지 않아도 됩니다.");
        return Helper.readLine();
    }

    public static String readTodoTabId(String message, HashMap<String, String> tabs) {
        System.out.println(message);
        for (Map.Entry<String, String> tab : tabs.entrySet()) {
            System.out.println(tab.getKey() + ". " + tab.getValue());
        }
        return Helper.readLine();
    }

    public static String readTodoDeadline() {
        System.out.println("마감 기한을 입력해 주시기 바랍니다(형식: yyyyMMdd). 꼭 입력하지 않아도 됩니다.");
        return Helper.readLine();
    }
}
