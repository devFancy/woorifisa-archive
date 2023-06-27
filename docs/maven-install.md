## Maven 설치

> 해당 글은 Mac 기반으로 작성했습니다.

- iTerm 또는 터미널 창을 열어서 아래의 명령어를 입력하고 실행한다.

```
brew install maven
```

![](/img/mvn-install.png)

- 설치가 완료되면, 환경설정을 해준다.

```
vi ~/.zshrc
```

- 맨 아래에 아래의 두 문장을 입력한다.

```
export M3_HOME=/usr/local/apache-maven-3.9.3 // 설치한 버전(3.9.3)
export PATH=$PATH:$M3_HOME/bin
```

- 저장후 닫는다.(:wq)

- 위의 두개의 문장을 적용하기 위해 아래의 명령어를 입력 후 실행한다.

```
source ~/.zshrc
```

- `mvn -version`을 확인하면 아래와 같이 출력된 것을 확인할 수 있다.

![](/img/mvn-version.png)
