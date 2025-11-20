package todo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class View {
    public static String readOption() {
        System.out.println("""
            원하는 옵션을 선택해 주시기 바랍니다.
            1. 할 일 추가
            2. 할 일 조회
            3. 할 일 수정
            4. 할 일 삭제
            5. 할 일 완료
            6. 완료된 할일 조회
            ** 0. 프로그램 종료
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

    public static String readTodoTabIdForCreate(HashMap<Integer, String> tabs) {
        System.out.println("탭 번호를 입력해 주시기 바랍니다. 입력하지 않을 경우 '잡동사니 서랍'으로 분류됩니다.");
        for (Map.Entry<Integer, String> tab : tabs.entrySet()) {
            System.out.println(tab.getKey() + ". " + tab.getValue());
        }
        return Helper.readLine();
    }

    public static String readTodoDeadline() {
        System.out.println("마감 기한을 입력해 주시기 바랍니다(형식: yyyyMMdd). 꼭 입력하지 않아도 됩니다.");
        return Helper.readLine();
    }

    public static String readTodoTabIdForRead(HashMap<Integer, String> tabs) {
        System.out.println("탭 번호를 입력해 주시기 바랍니다. 입력하지 않을 경우 전체 목록을 조회합니다.");
        for (Map.Entry<Integer, String> tab : tabs.entrySet()) {
            System.out.println(tab.getKey() + ". " + tab.getValue());
        }
        return Helper.readLine();
    }

    public static void printTodos(List<TodoView> todos) {
        String description;
        String deadline;
        int index = 1;

        for (TodoView todoView : todos) {
            description = todoView.getDescription();
            deadline = todoView.getDeadline();

            System.out.printf("#%02d [%s] %s\n", index, todoView.getTabName(), todoView.getName());
            if (!description.isEmpty()) {
                System.out.printf("- %s ", description);
            }
            if (!deadline.isEmpty()) {
                System.out.printf("(%s까지)\n", Helper.toIsoLocalDate(deadline));
            }
            index++;
        }
    }

    public static String readTodoNum() {
        // 유효한 투두 아이디를 입력받아야 한다. 0을 입력할 경우, 수정하기를 종료한다.
        System.out.println("할일 번호를 입력해 주시기 바랍니다. 0을 입력할 경우 종료합니다.");
        return Helper.readLine();
    }

    public static String reaadAdjustedTodoName(TerminalManager terminalManager, String name) {
        System.out.println("할일 이름을 수정해 주시기 바랍니다.");
        return terminalManager.readLine(name);
    }

    public static String readTodoDescriptionForUpdate(TerminalManager terminalManager, String description) {
        System.out.println("할일 설명을 수정해 주시기 바랍니다. 꼭 입력하지 않아도 됩니다.");
        return terminalManager.readLine(description);
    }

    public static String readTodoTabIdForUpdate(TerminalManager terminalManager, int tabId, HashMap<Integer, String> tabs) {
        System.out.println("탭 번호를 입력해 주시기 바랍니다. 입력하지 않을 경우 '잡동사니 서랍' 탭으로 자동 분류됩니다.");
        for (Map.Entry<Integer, String> tab : tabs.entrySet()) {
            System.out.println(tab.getKey() + ". " + tab.getValue());
        }
        return terminalManager.readLine(String.format("%d", tabId));
    }

    public static String readTodoDeadlineForUpdate(TerminalManager terminalManager, String deadline) {
        System.out.println("마감 기한을 입력해 주시기 바랍니다(형식: yyyyMMdd). 꼭 입력하지 않아도 됩니다.");
        return terminalManager.readLine(deadline);
    }
}
