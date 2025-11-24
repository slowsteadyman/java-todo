# 📝 simple terminal-todo-app 🖥️

---

- 터미널 기반으로 작동하는 간단한 todo app
- 프리코스 기간 동안 배웠던 개발 방법론을 통해 투두 앱을 만들고 지속적으로 개선시킨다
- 자바 자료구조가 아닌 데이터베이스를 통해 todo 목록을 관리한다

## 🔍 앱 사용법

- release 폴더에서 프로그램 실행 파일인 java-todo-1.0-SNAPSHOT-all.jar 파일을 다운받는다
- 다운받은 디렉토리에서 java -jar java-todo-1.0-SNAPSHOT-all.jar을 통해 파일을 실행시킨다
  - (컴퓨터에는 자바가 깔려있어야 한다)
 
<img width="648" height="379" alt="Image" src="https://github.com/user-attachments/assets/f698bed1-e91e-4da0-92a1-a1ea0edc3e30" />

- 프로그램 시작화면
  - 9가지 옵션 (할일 생성/조회/수정/삭제/완료, 완료된 할일 조회, 탭 생성/수정/삭제)과
  - 2가지 옵션 (프로그램 종료, 옵션 목록 보기) 중 하나를 선택할 수 있다
  
<img width="648" height="414" alt="Image" src="https://github.com/user-attachments/assets/8dc50b62-ba52-48f7-b007-39f44c85f05c" />

- 할일 생성 화면
  - 할일의 이름을 입력한다 (이름이기 때문에 빈 값은 안 된다)
  - 할일의 내용을 입력한다 (필수는 아니다)
  - 할일의 탭 분류를 입력한다 (입력하지 않을 시 프로그램 시작 시 기본으로 생성되는 탭인 '잡동사니 서랍(miscellaneous)'로 분류된다
  - 마감 기한을 입력한다 (필수는 아니다, 입력 시 오늘 이후의 날짜를 입력해야 한다)
  - 잘못된 값을 입력할 시 에러 메시지가 출력되며 값을 재입력 받는다

<img width="648" height="311" alt="Image" src="https://github.com/user-attachments/assets/7010820b-0e72-4373-b634-ea89791aea70" />

- 할일 조회 화면
  - 현재 존재하는 탭 목록을 보여준다
  - 탭 번호를 선택한다 (선택하지 않을 시 전체 할일 목록이 조회된다)
  - 잘못된 값을 입력할 시 에러 메시지가 출력되며 값을 재입력 받는다

<img width="648" height="498" alt="Image" src="https://github.com/user-attachments/assets/2861338e-ec82-4492-8569-b77f93688a18" />

- 할일 수정 화면
  - 전체 할일 목록을 보여준다
  - 수정하고 싶은 할일 번호를 선택한다 (0을 입력하면 수정하기를 종료한다)
  - 제목/설명/탭/마감기한 순서대로 기존의 내용이 출력되며 입력을 받는다
  - 기존의 내용에 덧붙이거나 기존의 내용을 지우고 새로 입력할 수 있다
  - 생성과 마찬가지로 똑같은 검증 절차가 있다

<img width="648" height="344" alt="Image" src="https://github.com/user-attachments/assets/5ed535a3-8edf-4d9e-a40f-3f1ea0e93427" />

- 할일 삭제 화면
  - 전체 할일 목록을 보여준다
  - 삭제하고 싶은 할일 번호를 선택한다 (0을 입력하면 삭제하기를 종료한다)

<img width="648" height="362" alt="Image" src="https://github.com/user-attachments/assets/3d45ce73-7366-4ba0-8cb0-91c9cad8d825" />

- 할일 수정/삭제에서 잘못된 값을 입력할 시 에러메시지가 출력된다
  - 0을 입력할 시 종료된다

<img width="648" height="327" alt="Image" src="https://github.com/user-attachments/assets/4d3b48fe-e2b9-457c-aa52-76e82cbfcc85" />

- 할일 완료 화면 & 완료된 할일 조회 화면
  - 전체 할일 목록을 보여준다
  - 완료하고 싶은 할일 번호를 선택한다 (0을 입력할 시 완료하기를 종료한다)
  - 완료된 할일을 조회할 시 방금 완료한 task1이 추가돼있는 것을 볼 수 있다
  
<img width="648" height="564" alt="Image" src="https://github.com/user-attachments/assets/c83e7b01-acb9-4738-8ab7-79a3c56f5768" />

- 탭 생성 화면
  - 기본으로 생성되는 miscellaneous 탭 이외로 새로운 탭을 생성할 수 있다
  - 탭 생성 후 할일 생성을 해보면 선택 가능한 탭이 늘어난 것을 볼 수 있다

<img width="648" height="427" alt="Image" src="https://github.com/user-attachments/assets/8cde1eb3-442f-4a39-9b47-f3072431cf9a" />

- 탭 이름 수정 화면
  - 기존에 존재하는 탭 목록을 보여준다
  - 수정하고 싶은 탭 번호를 입력받는다 (0을 입력할 시 탭 수정하기를 종료한다)
  - 기존의 탭 이름을 띄워주고, 지우거나 덧붙일 수 있다

<img width="648" height="207" alt="Image" src="https://github.com/user-attachments/assets/57d05e42-05dd-4454-9497-ba137041f571" />

- 탭 삭제 화면
  - 기존에 존재하는 탭 목록을 보여준다
  - 삭제하고 싶은 탭 번호를 입력받는다 (0을 입력할 시 탭 삭제하기를 종료한다)

**‼️😅 bug (뒤늦게 발견하여 수정하지 못한 것들이자 보완하고 싶은 사항)**
- 할일 조회 시 탭 번호 입력에서 한글을 입력할 경우 에러메시지가 출력되지 않는다
- 탭 업데이트/삭제 시 존재하지 않는 탭 번호를 입력할 경우 에러메시지가 출력되지 않는다
- 프로그램 실행 시 기본으로 생성되는 'miscellaneous'탭이 탭 삭제를 통해 삭제가 가능하다
- 프로그램 실행 시 기본으로 생성되는 'miscellaneous'탭이 탭 수정을 통해 이름 변경이 가능하다
- 할일 완료 시 탭 이름이 기존의 탭 이름에서 'done'으로 바뀌어버린다
- 탭을 삭제할 경우 그 탭에 존재하는 할일들이 조회되지 않는다
- autoincrement 지정 때문에 빈 할일 id가 있어도 계속 더 높은 id를 가진 할일이 생성된다

---

## ✅ 구현할 기능 목록

---

- [x] sqlite db 연동
- [x] 기본 환경 구성
  - [x] todo 테이블 생성
    - [x] ID / 이름 / 세부내용 / 탭ID / 마감기한
  - [x] tabs 테이블 생성
    - [x] ID / 이름
  - [x] 기본 탭 데이터 삽입 (done, miscellaneous)
- [x] 할 작업 옵션 선택
  - [x] 안내 메시지 출력
  - [x] option 입력 받기
  - [x] option 값 검증
- [x] 할일 추가
  - [x] 할일 이름
  - [x] 할일 내용
  - [x] 할일 탭
  - [x] 할일 데드라인
  - [x] db 저장
- [x] 할일 보기
  - [x] 전체 목록 보기
  - [x] 탭별로 보여주기
- [x] 할일 수정
- [x] 할일 삭제
- [x] 할일 완료
- [x] 간단한 터미널 UI
  - [x] 옵션 선택
  - [x] 할일 추가
  - [x] 할일 내용
  - [x] 할일 수정
  - [x] 할일 삭제
  - [x] 할일 완료
- [x] 탭 생성
- [x] 탭 수정
- [x] 탭 삭제
