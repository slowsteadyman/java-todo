package todo;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

public class View {
    public static String chooseOption() {
        System.out.println("""
            원하는 옵션을 선택해 주시기 바랍니다.
            1. 할 일 추가
            2. 할 일 조회
            3. 할 일 수정
            4. 할 일 삭제
            """);
        return Helper.readLine();
    }

    public static Supplier<String> todoNameInput = () -> {
        System.out.println("할일 이름을 입력해 주시기 바랍니다.");
        return Helper.readLine();
    };

    public static String todoDescriptionInput() {
        System.out.println("할일 설명을 입력해 주시기 바랍니다. 꼭 입력하지 않아도 됩니다.");
        return Helper.readLine();
    }

    public static Function<HashMap<String, String>, String> todoTabIdInput = tabs -> {
        System.out.println("탭 번호를 입력해 주시기 바랍니다. 입력하지 않을 경우 '잡동사니 서랍' 탭으로 자동 분류됩니다.");
        for (Map.Entry<String, String> tab : tabs.entrySet()) {
            System.out.println(tab.getKey() + ". " + tab.getValue());
        }
        return Helper.readLine();
    };
}
