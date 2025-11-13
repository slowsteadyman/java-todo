package todo;

import java.util.function.Supplier;

public class View {
    public String chooseOption() {
        System.out.println("""
            원하는 옵션을 선택해 주시기 바랍니다.
            1. 할 일 추가
            2. 할 일 조회
            3. 할 일 수정
            4. 할 일 삭제
            """);
        return Helper.readLine();
    }

    Supplier<String> todoNameInput = () -> {
        System.out.println("할일 이름을 입력해 주시기 바랍니다.");
        return Helper.readLine();
    };

    public String todoDescriptionInput() {
        System.out.println("할일 설명을 입력해 주시기 바랍니다. 꼭 입력하지 않아도 됩니다.");
        return Helper.readLine();
    }
}
