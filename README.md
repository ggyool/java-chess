# 체스 요구사항

<br>

## 기능 명세

<br>

- 게임 시작 및 종료 입력 기능
    - start 게임 시작
    - end 게임 종료
- 체스판 초기화 기능
- 체스판 View에 보낼 수 있도록 DTO 생성 기능
- 체스 말 이동 기능 구현 
    - 예외: 보드를 나가는 경우
    - 예외: 자신의 이동 전략을 벗어나는 경우
    - 예외: 가는 길에 다른 말들이 있는 경우
    - 예외: 현재 위치로 이동 불가
    - 예외: 목적지에 아군이 있는 경우

<br>

## 이동 로직 정리
1. 초기에 거를 수 있는 예외
    - 예외: source 와 target이 같다면
    - 예외: source 과 target이 범위 내가 아니다. (Location에서 확인)
2. source에 말이 있는지 찾는다.
    - 예외: source에 말이 없다.
    - 예외: 현재 차례의 팀의 말이 아니다.
3. source 에 있는 기물에게 isCapable 메서드를 실행시켜서 target 위치에 이동가능 여부를 알아낸다.
    - 예외: target에 갈 수 없다.
4. target에 같은 팀의 말이 있는지 확인한다.
    - 예외: 같은 팀의 말이 있으면 갈 수 없다. 
5. target 까지 이동 경로에 말이 있는지 확인한다.
    - 예외: 경로에 무언가 있다.
6. [ ] 이동하기 전 현재 상황을 판단한다.
    - source가 킹인 경우
        - 예외: 이동하려는 위치가 체크인 경우
    - source가 킹이 아닌 경우
        - 예외: 현재 체크 상황인 경우 반드시 킹을 움직여야 한다.
        - 예외: 움직인 이후에 킹이 체크가 되면 움직일 수 없다.
7-1. 폰인 경우 이동
    - 예외: 직선으로 움직이는데 target위치에 적이 있는 경우
    - 예외: 대각선으로 움직이는데 target위치에 적이 없는 경우
7-2. 폰이 아닌경우 이동 
    - target 위치에 적의 기물이 있으면 공격한다.
8. [ ] 체크메이트이면 게임을 종료한다.


## 1단계 피드백 이후
- [x] indent 정리
- [x] State 제네릭 대신 사용할 Result (BoardResult, ScoreResult) 도메인 생성
- [x] State 리팩토링
- [x] ChessGame 도메인 생성
- [x] Board에서 점수에 대한 코드 분리
- [ ] 각각의 기물들이 초기 위치를 가지고 있도록 변경
- [ ] State 관련 중복 코드 정리
- [ ] Location 캐싱
- [ ] 빠진 테스트 추가
- [ ] 보드 출력을 보기 좋게 변경
