JavaEE 플랫폼 스펙 중 1개인 Servlet/JSP 학습

Servlet - 동적인 처리 수행 시 필요한 클래스, 객체
JSP - 화면에 결과 데이터를 파싱, 출력해주는 역할

초기에는 Servlet만으로 HTML, 동적인 처리를 모두 수행
JSP가 등장하면서 HTML파일에도 Java Code 작성이 가능해짐

JSP도 결과적으로는 Java 파일로 변환되기 때문에
Servlet없이 JSP만으로도 모든 구현이 가능은 함

-> 단점: 거꾸로 HTML 코드에 Java Code가 섞여서 디자이너/개발자 간
충돌 발생 가능

해소 방법: Java Code와 같은 동적인 처리는 최대한 Servlet에 작성하고,
화면에 결과 데이터를 출력해주는 처리는 JSP가 하도록
HTML과 Java Code를 최대한 분리

MVC
- Model - 결과 데이터를 바인딩, 캡슐화(model/Coffee.java)
- View - 화면 출력을 처리할 역할 (mouseList.jsp파일)
- Controller - 사용자 요청을 받아서 적합한 요청 경로에 맞는 처리를 담당하는
Service 클래스에게 요청을 전달

MVC 패턴도 방식이 크게 2가지
Model1 방식 - Servlet or JSP 둘 중 하나만 사용하던 방식
Model2 방식 - Servlet/JSP를 한 번에 사용하는 방식(Service클래스와는 관련x)

현재 우리 경로
http://localhost:8080/step05mvcproject/coffees

/coffees -> CoffeeListController

MouseServlet
CoffeListController
-> 둘 다 서블릿, 이름만 controller라고 바꾼 것 뿐

다른 접속 방법
http://localhost:8080/step05mvcproject/coffeeList.jsp
-> Controller를 거치지 않고 바로 jsp에 접근하는 방식이기 때문에, list의 data가 없기 때문에 데이터 반영이 X

동적인 처리를 거쳐야 의미있는 페이지들은 WEB-INF 폴더 내부에 넣어야 직접 접근이 X
-> coffeeList.jsp 를 WEB-INF에 넣으면 직접적으로 이 주소(http://localhost:8080/step05mvcproject/coffeeList.jsp)에서 접근이 안됨.











