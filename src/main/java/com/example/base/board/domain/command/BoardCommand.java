package com.example.base.board.domain.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@AllArgsConstructor
@Data
@NoArgsConstructor
public class BoardCommand {


    private String boardCode;
    private String title;
    private String content;
    private String writer;
    private int view_count;
    private String status;
    private String secretYn;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean pinned;
    private LocalDateTime pinnedAt;
    private String category;


    public static BoardCommand boardWrite(
        String boardCode,
        String title,
        String content,
        String writer,
        String category
    )
    {
        BoardCommand boardCommand = new BoardCommand();
        boardCommand.boardCode = boardCode;
        boardCommand.title = title;
        boardCommand.content = content;
        boardCommand.writer = writer;
        boardCommand.category = category;

        return boardCommand;
    }
}
/*

[왜 Entity에 Param을 직접 쓰면 안 되는가]
- Param은 웹 계층 객체다.
- Entity가 Param 타입을 알면 웹 계층에 의존하게 된다.
- 웹 변경이 도메인 수정으로 전파된다.

[Command를 쓰는 이유]
- create(title, content, ...) 방식은
  파라미터가 늘 때 모든 호출부를 수정해야 한다.
- create(Command) 방식은
  변경 시 Command 한 곳만 수정하면 된다.

[정리]
- Param: 웹 전용 입력 객체 (Entity ❌)
- Command: 파라미터 폭증 방지용 래퍼
- 목적: 코드 덜 고치기

참나 그냥 타입안맞으면 에러표시되는거 볼라고 쓰는거임.
강제로 누락 방지용 단순 보험임 (대규모 프로젝트나 협업에서는 쓸 가능성이 있을 수 있는데 실질적으로 거진 안쓸것같음)
그중에서 DDD/클린아키텍처 쪽에서 관용적으로 Command를 쓴 것뿐이다.
결국관리자가 관리 편의성 측면(컴파일 에러내버리기) 누락방지

아니다 생각해보니 에러를 표시해주는건 생각보다 유용해 변경누락을 방지할 수 있으니
유지보수 입장에서 예상치못한 에러 터지는걸 방지할수 있는거같아 변경에 대응이 편함(누락없이 변경가능)

command 는 엔티니 값VO가 아니기 때문에 static factory로 만들 필요 없음

- 메소드를 만들어서 파람을 받고 생성자에 바인딩하면 커맨드가 파람을 모르게할수 있음
 */




