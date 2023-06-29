# Web

## Spec

- Java 11
- Web Servlet, JSP - tomcat 9(version)
- MySQL
- IntelliJ

## Web 설정

- 프로젝트 폴더 마우스 오른쪽 버튼 클릭 - `Add Framework Support` 클릭 -> Java EE 안의 `Web Application`(Versions: 4.0) 선택 후 Ok 버튼 클릭한다.

![](/code/backend/11.web/img/web-setting-web-application.png)

## Tomcat 설정

- 우측 상단에 `Edit Configurations` 클릭한다.

![](/code/backend/11.web/img/tomcat-setting-1.png)

- 좌측 상단에 `+` 버튼 클릭 - `Tomcat Server - local` 클릭한다.

![](/code/backend/11.web/img/tomcat-setting-2.png)

- Server 탭에서 `Application server:` 우측에 있는 `Configure...` 클릭한다.

- `+` 버튼 클릭해서 `Tomcat Home:` 에서 기존에 설치한 Tomcat version(9)의 위치를 찾은 다음에 `open` 버튼 클릭한다.

![](/code/backend/11.web/img/tomcat-setting-3.png)

![](/code/backend/11.web/img/tomcat-setting-4.png)

- 해당 Name인 `Tomcat 9.0.76`이 나오고 나서 `ok` 버튼을 클릭한다.

- 하단에 있는 `Fix`을 클릭한 뒤 ok 버튼을 클릭한다.

![](/code/backend/11.web/img/tomcat-setting-5.png)
