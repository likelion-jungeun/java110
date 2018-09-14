# java110
비트캠프 **자바 110기** 실습 프로젝트

## v2.5 - 180914

- Spring IoC 컨테이너 도입
- 기존에 만들었던 ApplicationContext 대신에 Spring framwork에서 제공하는 ApplicationContext 사용하기
- 작업
  -> Spring IoC 컨테이너 라이브러리 추가(build.gradle 파일 편집)
     -> mvnrepository.com에서 spring context를 검색한다. 
     -> 명령창에서 gradle eclipse 실행
     -> 이클립스에서 프로젝트를 refresh한다.
  -> 스프링 설정 파일 추가(application-context.xml)
     -> bitcamp/java110/cms/conf/application-context.xml
  -> 기존의 ApplicationContext 클래스를 제거한다.

## v2.4 - 180914

- DB 커넥션 공유하기
- DB 연결 객체를 재사용하여 가비지를 줄이고, 실행 속도를 높이기 위함.

## v2.3 - 180913

- DAO에 JDBC 적용
- 작업
  -> Data Modeling과 forward engineering 수행
  -> 테이블 준비
  -> JDBC API 활용
  -> 트랜잭션 다루기

## v2.2 - 180912

- 예외처리 적용
- 예외처리 문법이 없던 시절, 리턴값으로 예외 상황을 호출자에게 알렸다.
  -> 문제 : 특정 타입의 값을 리턴하는 경우, 이 방법을 사용하기 곤란하다.
- 예외처리 문법이 등장
  -> 리턴 값이 아닌 별도의 경로로 예외 상황을 호출자에게 알린다.
  -> 이전 방식에 비해 메서드의 리턴 타입에 영향을 받지 않는다.
  -> 또한, 예외 상황을 자세하게 호출자에게 알릴 수 있다. 

## v2.1 - 180912

- 객체 Serialize/Deserialize 적용
- java.io.Serializable 인터페이스 활용
- transient modifier 사용법

## v2.0.1 - 180912

- 인터페이스와 구현체를 별도의 패키지로 분리하기

## v2.0 - 180911

- DAO에 파일 입출력 도입
- DAO에 인터페이스 적용
- 작업
  -> DAO에 데이터를 파일로 저장하고 읽는 기능 추가

## v1.9 - 180911

- IoC컨테이너가 객체 생성 후에 수행하는 작업을 별도의 클래스로 분리한다. 
- 향후 객체 생성 후에 또 다른 작업을 추가하기 쉽도록 한다.
- 작업 
  -> 객체 생성 후에 수행할 작업 별도의 클래스로 분리한다.

## v1.8 - 180911

- 의존 객체 주입하기
- 미니 IoC 컨테이너 개선
- 작업
  -> 의존 객체를 주입받을 수 있도록 setter를 준비한다.(App.~한것들 중 App을 다지움)
  -> IoC 컨테이너가 setter를 자동으로 호출하도록 애노테이션으로 표시한다.

## v1.7 - 180910

- DAO(Data Access Object) 도입하기
  -> 데이터를 저장하는 방식이 바뀌더라도 기존 클래스에 영향을 주지 않게 하려면,
     데이터를 다루는 부분을 List가 아니라 별도의 클래스로 정의해야 한다.
     즉, List를 통해 데이터를 메모리에 저장하는 대신에 파일이나 데이터베이스에 저장한다면, 기존 코드를 변경해야 하는
     문제가 발생하기 때문에 이러한 부분을 해결하기 위해 DAO를 사용한다.
- 작업
  -> 학생관리, 강사관리, 매니저관리 각각에 사용할 DAO 클래스를 정의한다.

## v1.6 - 180910

- Command 디자인 패턴 적용
- 컨트롤러 구조 변경 
- 작업
  -> 컨르롤러에서 명령을 처리하는 각각의 메서드를 별도의 클래스로 분리한다.
- 장점 : 유지보수가 편함. (ManagerUpdateController를 만들고 싶으면, 한 커맨드에 한 클래스를 만들어서 구현하면 끝)

## v1.5 - 180910

- 리플렉션 API 활용2
- 애노테이션 활용
- 미니 IoC 컨테이너 개선
- 작업
  -> 자동으로 생성되어야 할 객체에 붙일 애노테이션 정의
  -> 컨트롤러 객체에 애노테이션 적용
  -> 애노테이션이 붙은 클래스만 객체를 생성

## v1.4 - 180907

- 리플렉션 API 활용
- File 클래스로 디렉토리 및 파일 다루기
- 미니 IoC 컨테이너 작성

## v1.3 - 180907

- 인터페이스 활용
- APP클래스(호출자)와 Controller들 사이의 호출규칙(사용규칙)을 인터페이스로 정의한다.

## v1.2 - 180906

- 자바 컬렉션 API 사용
- 직접 제작한 List, ArrayList, LinkedList 대신에 자바에서 제공하는 Collection API를 사용한다.

## v1.1 - 180906

- 인터페이스 적용(인터페이스 : 호출자와 피 호출자 사이의 규칙)
- 의족 객체 주입 (DI) 적용
- 데이터 목록을 다룰 때 호출하는 메서드의 규칠을 정의한다.
    -> 다양한 방법으로 구현한 객체를 사용할 수 있다.
    -> 즉, 규칙을 따르기만 한다면 어떤 객체라도 대체할 수 있다.
- 인터페이스의 default 메서드의 활용

## v1.0 - 180906

- LinkedList 구동 원리 및 적용

## v0.9 - 180906

- 제네릭 활용법
- ArrayList에 제네릭 적용하기

## v0.8 - 180906

- 목록을 다루는 클래스들을 리팩토링하기
- 다형적 변수의 활용법
- 클래스 멤버(변수,메서드,블록)와 인스턴스 멤버의 차이점
- 생성자 사용
- StudentList, ManagerList, TeacherList 클래스를 한 클래스로 합친다.
- 다형적 변수를 사용하여 Student,Manager,Teacher 객체를 모두 저장할 수 있게 한다.

## tag: v0.7 - 180905

수업 관리 시스템 만들기

- 목록 다루기
- 배열에 항목을 추가하고 삭제하는 기능을 추가한다.
- 배열의 값 목록을 다루는 기능을 별도의 클래스로 분리한다.

## tag: v0.6 - 180905

- 패키지 활용 및 클래스의 접근 범위

## tag: v0.5 - 180905

- 조건문, 반복문, 메서드 활용
- 강사, 학생, 매니저를 구분하여 입력받고 출력한다.

## v0.4 - 180904

- 여러 속성의 값을 다루기 쉽도록 클래스를 이용하여 사용자 정의 데이터 타입을 만든다. 또한 그 데이터를 다룰 연산자를 정의한다.

## v0.3 - 180903

- 관련된 명령들을 재사용하기 쉽도록 메서드 블록으로 묶는다.

## v0.2 - 180903

- 배열을 이용하여 여러 회원의 정보를 저장하기

## v0.1 - 180903

- 반복문을 이용하여 여러 회원의 정보를 입력 받아 출력하기
- 작업
    - App.java 변경

## Initial Commit - 180903

- 자바 프로젝트 디렉토리 구성하기

```
1) 자바 프로젝트 디렉토리 구성하기
$ gradle init --type java-application

2) Gradle 설정 파일에 'eclipse' 플러그인 추가 
build.gradle 파일에 id 'eclipse' 추가 그리고 mavenContral 추가하기

3) 이클립스 설정 파일 생성
$ gradle eclipse

4) 이클립스에서 프로젝트를 임포트
```