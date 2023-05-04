# Coin Pick ✔️

## 프로젝트 배경 

* `우리 FISA` 커리큘럼에서 **프론트엔드** 개발 지식(HTML, CSS, JavaScript, NodeJS)을 배운 것을 가지고 **3일** 동안 원하는 주제로 토이 프로젝트를 진행했습니다.

## 서비스 소개 🪙

<img width="1000" alt="completed" src="https://github.com/Fancy96/useless-coin-pick/blob/develop/img/completed.png">

<img width="1000" alt="completed_2" src="https://github.com/Fancy96/useless-coin-pick/blob/develop/img/completed_2.png">

<img width="1509" alt="스크린샷 2023-05-04 오전 9 58 24" src="https://user-images.githubusercontent.com/81675744/236117308-7da28ac3-1d8b-48ba-9c2a-e651577a388f.png">

* `업비트` Open API을 활용하여 코인 종목을 **랜덤**으로 뽑아서 `슬롯 머신`의 **잭팟**을 터트리는 서비스입니다.

### 1. 코인 슬롯 머신 

1. 코인 슬롯 머신 옆에 레버를 누릅니다.

2. 동일한 종목이 2개 혹은 3개 이상인 경우 잭팟이 터지면서, **코인왕 협회장**님으로부터 코인왕 상장을 수여받는 팝업 창이 뜨게 됩니다.

### 2. 코인 리스트 

1. 카테고리를 기준으로 업비트 거래소에 있는 종목들의 가격을 실시간 조회하여 조건에 맞는 종목명과 가격을 리스트로 추출합니다.

2. 실시간으로 종목의 가격이 바뀌기 때문에, 그에 따라 리스트에 있는 종목명과 가격도 바뀌게 됩니다.

## 기술스택 ⚙️

### 1. FrontEnd

#### Language
* JavaScript

<img src="https://user-images.githubusercontent.com/123453133/236110241-97c5471f-c94c-454a-af29-79ce66ef2394.png" alt="js" width="100" height="100">

* HTML

<img src="https://user-images.githubusercontent.com/123453133/236110663-8743d413-2ed9-4f46-b486-b95de82f9bd0.png" alt="html-5" width="100" height="100">

* CSS

<img src="https://user-images.githubusercontent.com/123453133/236110586-269126b4-e5f2-4ad8-a563-e237ffd6b923.png" alt="css-3" width="100" height="100">

### 2. BackEnd

#### Language
* JavaScript

<img src="https://user-images.githubusercontent.com/123453133/236110241-97c5471f-c94c-454a-af29-79ce66ef2394.png" alt="js" width="100" height="100">

### 3. Infra

#### Infra

* Heroku

<img src="https://user-images.githubusercontent.com/123453133/236110676-011d3caf-7474-422b-b553-236a3472875d.png" alt="heroku" width="100" height="100">

CORS 정책 (Cross-Origin Resource Sharing Policy) 위반을 해결하기 위함.  
출처(포트 번호)가 다른 두 애플리케이션을 소통하려 하기 때문에 공격에 취약해서 악의를 가진 사용자가 공격을 할 수 있기 때문에 미리 막아둔 정책이다.  
그래서 서버를 하나 만들어서 CORS 정책에 맞게 애플리케이션 사이에 두면 되는데, 서버를 당장 구축하기에는 어려움이 있었다.   
그래서 Heroku 라는 클라우드 서비스를 사용해서 서버는 Heroku가 구축하고 구축된 서버의 URL만 사용하면 되었다.  

#### CI/CD

* Git

<img src="https://user-images.githubusercontent.com/123453133/236111543-cc78162b-ef4b-4ab9-a519-21214a74413e.png" alt="git-logo" width="100" height="100">

## 팀원 소개 

|                                         Frontend                                         |                                          Frontend                                          |                                          Backend                                           |                                         Backend                                         |
| :--------------------------------------------------------------------------------------: | :----------------------------------------------------------------------------------------: | :----------------------------------------------------------------------------------------: | :-------------------------------------------------------------------------------------: |
| <img src="https://avatars.githubusercontent.com/u/81675744?v=4" width=400px alt="선주"/> | <img src="https://avatars.githubusercontent.com/u/98214919?v=4" width=400px alt="혜원"/> | <img src="https://avatars.githubusercontent.com/u/83820185?v=4" width=400px alt="준용"/> | <img src="https://avatars.githubusercontent.com/u/123453133?v=4" width=400px alt="승환"> |
|                            [선주](https://github.com/Jo-ormi)                             |                          [혜원](https://github.com/hyewon29)                          |                           [준용](https://github.com/Fancy96)                           |                           [승환](https://github.com/Cheon-Seunghwan)                            |
