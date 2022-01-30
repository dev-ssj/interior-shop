## 🏠인테리어 쇼핑몰  &lt;내일의 집>
* 개발기간 : 2021.10.01 ~ 2021.10.25
* 참여인원 : 5명

## 프로젝트 개요
사용자는 인테리어 쇼핑몰 &lt;내일의 집>에서 판매중인 상품들을 확인하고 구매할 수 있으며, <br> 
관리자는 관리자 페이지에서 상품관리, 회원관리 등 쇼핑몰 운영에 필요한 요소들을 관리 할 수 있다.
* [Back End](https://github.com/dev-ssj/interior-shop/tree/main/springProject/src/main/java/kr/spring/)
* [Front End](https://github.com/dev-ssj/interior-shop/tree/main/springProject/src/main/webapp/WEB-INF/views/)

## 구현 기능
* 회원가입
* 로그인, 로그아웃
* 아이디/비밀번호 찾기
* 마이페이지
  + 회원정보 확인
  + 회원정보 수정
  + 회원탈퇴
* 상품 페이지
  + 상품 목록 페이지
  + 상품 상세 페이지
* 상품평 기능
  + 상품평 확인
  + 상품평 작성
  + 상품평 수정
  + 상품평 삭제
* 장바구니 
* 주문
* 주문내역 페이지
  + 주문내역 확인
  + 주문 취소/반품신청/교환신청/구매확정
* QNA게시판(상품 문의, 배송 문의, 교환/환불 문의, 기타 문의)
  + 문의글 작성
  + 문의글 수정
  + 문의글 삭제
  + 문의글 답변 작성(관리자)
* 회원 관리
* 관리자 관리
* 상품 관리
* 카테고리 관리
* 매출 관리
* 주문 관리
* 배송 관리

## 맡은 역할
* 팀장

## 맡은 기능
* 상품 목록 페이지
* 상품 상세 페이지
* QNA게시판
* 상품평 기능
* 장바구니 페이지
* 주문 기능
* 주문내역 페이지
* 아이디/비밀번호 찾기
* 소셜 로그인 API(Kakao, 네아로)
* 메인페이지 디자인
* 공통 UI 디자인

## 개발환경 및 사용언어
* OS : Windows 10
* DBMS : Oracle Database 11g
* SERVER : Tomcat 9.0
* Tools : Eclipse IDE 4.19.0
* Front-End : HTML5, CSS3, BootStrap4, JavaScript, jQuery
* Back-End : JAVA, JSP, Spring Framework, Mybatis

## 시스템 설계
* ERD
![shop_20220111_153509](https://user-images.githubusercontent.com/79852136/148893830-9253170e-4535-4a4f-9b07-164dfbc83fc0.png)

## 구현화면
* 쇼핑몰 메인
![1_메인](https://user-images.githubusercontent.com/79852136/151716531-c8e7c8ba-7bac-4dc5-b2e7-df18af13f01a.png)

* 로그인
![2_로그인](https://user-images.githubusercontent.com/79852136/151716535-58fae745-6349-4122-9dbd-fd33e8653e7b.png)

* 회원가입
![3_회원가입](https://user-images.githubusercontent.com/79852136/151716536-62375133-58d7-4670-ac9a-5c2357e26b07.png)

* 회원 마이페이지
![4_회마페](https://user-images.githubusercontent.com/79852136/151716537-5cc8c523-4027-4386-9b26-181d903964a4.png)

* 상품 내역
![5_상품리스트](https://user-images.githubusercontent.com/79852136/151716538-15adeacf-2fff-406e-a896-fee75296afc9.png)
![5_상품리스트2](https://user-images.githubusercontent.com/79852136/151716539-08c454c1-80e0-4702-bed9-48eec6299696.png)

* 상품 상세
![6_상품상세페이지1](https://user-images.githubusercontent.com/79852136/151716540-3b67c349-5196-4717-a495-532add5d8cac.png)
![6_상품상세페이지2](https://user-images.githubusercontent.com/79852136/151716542-5d80ecf1-be7d-437b-825e-9aa6b83099d8.png)
![6_상품상세페이지3](https://user-images.githubusercontent.com/79852136/151716568-45ccf5ec-6d86-4dc7-9339-7076e7be1ff0.png)

* 장바구니 
![7_장바구니](https://user-images.githubusercontent.com/79852136/151716572-39a39e5c-38f3-4fe3-8003-3327308d2673.png)

* 주문 
![8_주문](https://user-images.githubusercontent.com/79852136/151716573-33ba67f8-1b6f-4d05-b433-60324c0bff78.png)

* 주문 내역
![9_주문내역](https://user-images.githubusercontent.com/79852136/151716575-29213c96-76f9-4e81-89c3-c4a32dd010fe.png)

* 주문 상세 내역
![9_주문상세내역](https://user-images.githubusercontent.com/79852136/151716576-2d135f17-820a-4fc0-ad81-8a21f8244d52.png)

* 작성 가능한 리뷰
![10_작성가능한 리뷰1](https://user-images.githubusercontent.com/79852136/151716577-679eb779-7d18-4296-9d0b-e5e9ff4bf9e5.png)
![10_작성가능한 리뷰2](https://user-images.githubusercontent.com/79852136/151716578-3669fe37-8521-41cb-a82b-8211c842948b.png)

* 이미 작성한 리뷰
![11_이미작성한 리뷰1](https://user-images.githubusercontent.com/79852136/151716579-183d6464-cc34-4749-9aa2-f2eb90259c4c.png)
![11_이미작성한 리뷰2](https://user-images.githubusercontent.com/79852136/151716580-53b18943-757b-4b24-a6ad-a22169aa4444.png)

* 문의 게시판
![12_문의게시판1](https://user-images.githubusercontent.com/79852136/151716602-77a39f3b-ab1d-4b0e-98a8-594724d2d36e.png)
![12_문의게시판2](https://user-images.githubusercontent.com/79852136/151716603-5ccbd326-205b-4f02-8a80-1370c87ad671.png)
![12_문의게시판3](https://user-images.githubusercontent.com/79852136/151716604-5cfc6856-e708-46dd-8df5-4bd184e0af79.png)

* 관리자 마이페이지
![13_관마페](https://user-images.githubusercontent.com/79852136/151716606-6b350cfe-ecc1-4982-a6e2-475ed0a021e5.png)

* 관리자 페이지 메인
![14_관메](https://user-images.githubusercontent.com/79852136/151716607-23585ef2-b888-4bce-bb3f-0706f3d6fc42.png)

* 카테고리 관리
![15_카테고리관리](https://user-images.githubusercontent.com/79852136/151716608-1c0f5fc3-ba6b-4521-95d0-ff72e77cdec6.png)

* 상품 관리
![16_상품관리](https://user-images.githubusercontent.com/79852136/151716611-4f013e0a-2e65-42ee-a68a-d0d2462b64d5.png)

* 주문 관리
![17_주문관리](https://user-images.githubusercontent.com/79852136/151716612-500d1236-4e99-405d-92dc-7f2f71c28451.png)

* 매출 관리
![18_매출관리](https://user-images.githubusercontent.com/79852136/151716614-1d90d6e7-99a0-45f4-b56a-c82bc0599cc4.png)

* 회원 관리
![19_회원관리](https://user-images.githubusercontent.com/79852136/151716616-32292ede-b7fa-45e0-887e-58541279c95f.png)

* 관리자 관리
![20_관리자관리](https://user-images.githubusercontent.com/79852136/151716617-c1c9f00d-9ac8-41b7-92a3-3c6330be446e.png)
