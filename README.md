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
![1_메인](https://user-images.githubusercontent.com/79852136/151715914-397d1813-0bcb-4fc9-8a16-2f30630e8da4.png)  

* 로그인
![2_로그인](https://user-images.githubusercontent.com/79852136/151715915-e6d4415f-a449-405e-984c-5b1fc98b6411.png)  

* 회원가입
![3_회원가입](https://user-images.githubusercontent.com/79852136/151715916-1888ef6b-0198-4672-9374-f547d1184601.png)  

* 회원 마이페이지
![4_회마페](https://user-images.githubusercontent.com/79852136/151715917-5b89bf12-e2d3-4d13-9f34-bb195c29c376.png)  

* 상품 내역
![5_상품리스트](https://user-images.githubusercontent.com/79852136/151715919-d51bd5e1-2225-4100-9fa8-bd9e976efa44.png)
![5_상품리스트2](https://user-images.githubusercontent.com/79852136/151715920-8af0fca3-8869-4255-890e-5aae5e4ef130.png)  

* 상품 상세
![6_상품상세페이지1](https://user-images.githubusercontent.com/79852136/151715921-46be4454-181c-441e-a668-de05bd940eb7.png)
![6_상품상세페이지2](https://user-images.githubusercontent.com/79852136/151716024-a6697f03-8a00-4736-8781-60633dc12d41.png)
![6_상품상세페이지3](https://user-images.githubusercontent.com/79852136/151716025-e79501f2-a974-4133-93e6-3ebe8b67537a.png)  

* 장바구니 
![7_장바구니](https://user-images.githubusercontent.com/79852136/151716026-893c6219-9f3e-451a-ad79-cb9b23af00cb.png)  

* 주문 
![8_주문](https://user-images.githubusercontent.com/79852136/151716027-cb10927e-1b74-470e-ac53-28ee8ddf81a5.png)  

* 주문 내역
![9_주문내역](https://user-images.githubusercontent.com/79852136/151716028-b7121038-4969-4f78-8dd3-bd4f911e25bd.png)  

* 주문 상세 내역
![9_주문상세내역](https://user-images.githubusercontent.com/79852136/151716029-89817575-8137-46d4-8335-7b0d0059d069.png)  

* 작성 가능한 리뷰
![10_작성가능한 리뷰1](https://user-images.githubusercontent.com/79852136/151716031-e9c44a0d-6aee-4c00-9bd0-1cbf0eee94d4.png)
![10_작성가능한 리뷰2](https://user-images.githubusercontent.com/79852136/151716032-04e816a5-c802-4e6f-9f55-aab079e72941.png)  

* 이미 작성한 리뷰
![11_이미작성한 리뷰1](https://user-images.githubusercontent.com/79852136/151716033-69a4c7b7-5e84-410f-babf-7d0f90a06ee9.png)

* 문의 게시판
![12_문의게시판1](https://user-images.githubusercontent.com/79852136/151716082-f8e52ca5-f1da-44cc-a98d-6fc78c7f95db.png)
![12_문의게시판2](https://user-images.githubusercontent.com/79852136/151716085-e62de236-e4af-4bb6-884c-7abb2bba879d.png)
![12_문의게시판3](https://user-images.githubusercontent.com/79852136/151716087-58cf6a95-8f24-4687-8aac-5c9b03710f7f.png)  

* 관리자 마이페이지
![13_관마페](https://user-images.githubusercontent.com/79852136/151716088-ce19ccdd-6677-47f2-9249-f223142a47f9.png)  

* 관리자 페이지 메인
![14_관메](https://user-images.githubusercontent.com/79852136/151716089-1b763e83-8797-4648-a0d0-a24ce758da15.png)  

* 카테고리 관리
![15_카테고리관리](https://user-images.githubusercontent.com/79852136/151716091-0e4789c9-dfed-4d6a-97cd-a22d3b83a6fb.png)  

* 상품 관리
![16_상품관리](https://user-images.githubusercontent.com/79852136/151716093-0d3c90d7-f4ff-4b68-be3b-0a0086fe64e4.png)  

* 주문 관리
![17_주문관리](https://user-images.githubusercontent.com/79852136/151716095-94569c22-0c92-4a43-ae96-86a25c3604bc.png)  

* 매출 관리
![18_매출관리](https://user-images.githubusercontent.com/79852136/151716097-2514f8c5-4320-46f6-9124-f9ec349611e8.png)  

* 회원 관리
![19_회원관리](https://user-images.githubusercontent.com/79852136/151716098-702234fb-ccda-410a-82d5-38dc2903182a.png)  

* 관리자 관리
![20_관리자관리](https://user-images.githubusercontent.com/79852136/151716100-e6ed83de-ac5b-480e-a84e-7788f129000b.png)  
