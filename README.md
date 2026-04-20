# 🔴⚫ My FC Seoul

> **"오직, FC서울 팬들만을 위한 직관 아카이브 프로젝트"**

<br/>

## 🔗 관련 링크

- **🚀 배포 URL**: [https://fc-raichu.vercel.app/](https://fc-raichu.vercel.app/)
- **📽 시연 영상**: [Google Drive Link](https://drive.google.com/file/d/1SaK4jr9wzXs0hiHtA1mv-TAqgKGzTz3f/view?usp=sharing)
- **📊 발표 자료**: [Figma Deck](https://www.figma.com/deck/4Sn9B5XIb6OVuX72xdNVyU)
<!-- - **Test ID**: `test@fcseoul.com` (예시)
- **Test PW**: `12341234` (예시) -->

<br/>

## 1. 프로젝트 소개

**My FC Seoul**은 직접 관람했던 경기를 쉽게 기록하고 한 눈에 모아볼 수 있도록 아카이빙을 돕는 서비스입니다.
<br/>
그날의 감정과 좋아하는 선수들의 사진을 기록하고 포인트를 얻을 수 있습니다.
<br/>
포인트로 좋아하는 선수에게 후원하고, 경기를 예측해 보세요!
<br/>


<br/>

## 2. 개발 전략

<!-- front, back 공통 개발 전략 -->

### **브랜치 전략 (Git-flow)**

- `main`: 배포 단계 브랜치
- `dev`: 개발 단계의 중심 브랜치
- `feature`: 기능 단위 독립 개발 브랜치 (작업 완료 후 merge 및 삭제)

### **MSW (Mock Service Worker)**

- **API 모듈화 및 병렬 개발**: 백엔드 API가 완성되기 전, MSW를 통해 네트워크 레벨에서 목업 API를 구현하여 프론트엔드 로직을 선행 개발하고 테스트 생산성을 높였습니다.

### **Keycloak 인증 시스템**

- **엔터프라이즈 수준의 보안**: 오픈 소스 ID 관리 솔루션인 Keycloak을 연동하여 안전한 사용자 인증 및 권한 관리를 구현했습니다.


<br/>

## 3. 채택한 개발 기술

- **Front-end**: `React`, `TypeScript`, `Vite`, `Tailwind CSS (v4)`
- **Back-end**: `Java`, `Spring Boot`, `Gradle`
- **DB**: `MySQL`
- **Security**: `Keycloak` (SSO 및 인증 관리)
- **Infrastructure**: `Vercel` (Frontend), `MSW` (Mock Service Worker), `EC2` (Backend), `Local PC Server` (Backend)
- **Design & Collaboration**: `Figma`, `Discord`, `Notion`, `Github Issues`


<!-- front, back 각각 따로 추가 기술 -->

## **Backend Core**

## Java 17 & Spring Boot
- 안정적인 생태계와 생산성을 바탕으로 견고한 서버 애플리케이션 구축

## Spring Data JPA
- 객체 지향적인 데이터 쿼리를 통해 MySQL과의 매핑 및 데이터 CRUD 효율화

## Database & Data Mapping
- MySQL 8.0: 서비스 데이터의 영속성 관리를 위한 관계형 데이터베이스 사용
- Querydsl: 복잡한 동적 쿼리를 타입 안정성을 보장하며 구현

## Authentication & Security
- Keycloak OAuth 2.1: 중앙 집중식 인증 서버를 통해 사용자 계정 관리 및 보안 강화



<br/>

## 4. 프로젝트 구조 (Backend)

```text
src/main/java/com/fcseoul
├── global                   # 공통 설정 및 유틸리티
│   ├── badword              # 부적절한 단어 처리
│   └── error                # 전역 에러 관리 
├── domain                   # 도메인별 비즈니스 로직
│   ├── admin                # 관리자용 서비스 로직
│   ├── auth                 # 인증/인가 토큰 관리
│   ├── bet                  # 경기 베팅 및 통계 관리
│   ├── donation             # 선수 후원 관리
│   ├── game                 # 경기 정보 조회 및 필터링
│   ├── image                # 이미지 저장 및 압축
│   ├── player               # 선수 정보 관리
│   ├── post                 # 직관 기록(아카이브) CRUD
│   ├── rank                 # 랭킹 계산 로직 및 조회
│   └── user                 # 로그인, 회원가입, 출석 관리
├── config                   # 공통 설정
│   ├── CacheConfig          # 캐시 설정
│   ├── QueryDSLConfig       # query dsl 설정
│   ├── SecurityConfig       # 보안 및 접근 제한 설정
│   ├── SwaggerConfig        # 테스트용 Swagger 설정
│   └── WebConfig            # 파일 업로드 설정
└── security                 # Security Context 관련 로직
    └── CurrentUserProvider  # 현재 로그인 유저 id 추출
```

<br/>

## 5. 역할 분담

|                                                                        **🍊 Frontend / Design**                                                                         |                                               **🎈 Backend**                                                |                                                 **😎 Backend**                                                  |
| :---------------------------------------------------------------------------------------------------------------------------------------------------------------------: | :---------------------------------------------------------------------------------------------------------: | :-------------------------------------------------------------------------------------------------------------: |
|                             <img src="https://github.com/kye1115z.png" width="120" height="120"><br/>[@김예은](https://github.com/kye1115z)                             | <img src="https://github.com/wvwwvv.png" width="120" height="120"><br/>[@강상민](https://github.com/wvwwvv) | <img src="https://github.com/inwoohub.png" width="120" height="120"><br/>[@황인우](https://github.com/inwoohub) |
| **UI/UX**: 전체 서비스 와이어프레임 설계 및 브랜드 디자인 시스템 구축<br/>**핵심 기능**: 직관 기록 CRUD, 아카이브 필터링, MSW 연동, SVG 애니메이션 구현, 선수 후원 기능 |                **기능**: 도메인 설계, 직관 게시글 CRUD, 선수, 랭킹, 경기, 베팅 API 구현, 데이터베이스 모델링                |              **기능**: Keycloak 인증 서버 구축 및 연동, 회원 정보 관리 API 개발, 보안 프로토콜설정              |

<br/>

## 6. 페이지별 주요 기능

|                                                                                                                                                                                                                                                                                                                                                                                                 **랜딩 페이지 (Landing)**                                                                                                                                                                                                                                                                                                                                                                                                 |                                                                                                                                                                                                                                                                                                                                                                                                  **로그인 (Login)**                                                                                                                                                                                                                                                                                                                                                                                                   |                                                                                                                                                                                                                                                                                                                                                                                                  **회원가입 (Signup)**                                                                                                                                                                                                                                                                                                                                                                                                  |
| :-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------: | :-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------: | :---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------: |
| ![랜딩페이지](https://private-user-images.githubusercontent.com/78716896/572218299-686af908-eeb6-4c76-bb6f-b2fa3d03b14d.GIF?jwt=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3NzUwMDQyNzYsIm5iZiI6MTc3NTAwMzk3NiwicGF0aCI6Ii83ODcxNjg5Ni81NzIyMTgyOTktNjg2YWY5MDgtZWViNi00Yzc2LWJiNmYtYjJmYTNkMDNiMTRkLkdJRj9YLUFtei1BbGdvcml0aG09QVdTNC1ITUFDLVNIQTI1NiZYLUFtei1DcmVkZW50aWFsPUFLSUFWQ09EWUxTQTUzUFFLNFpBJTJGMjAyNjA0MDElMkZ1cy1lYXN0LTElMkZzMyUyRmF3czRfcmVxdWVzdCZYLUFtei1EYXRlPTIwMjYwNDAxVDAwMzkzNlomWC1BbXotRXhwaXJlcz0zMDAmWC1BbXotU2lnbmF0dXJlPWNmNjQ2ODU0ZmY0ZmE4ZDY4OWUzMzZjMmQzNDY5Nzc2ZDRhYWVkMTczMjI5ZjI5N2ViYTA3NzhlMmM1NWM2YzAmWC1BbXotU2lnbmVkSGVhZGVycz1ob3N0In0.-3jSQDQiIadZRx68zsKgu9Gqlp7MxnYufyMPDuVp-lo) | ![로그인](https://private-user-images.githubusercontent.com/78716896/572218300-0c3928c3-d7b2-4215-a3c3-d7b4f5319573.GIF?jwt=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3NzUwMDQyNzYsIm5iZiI6MTc3NTAwMzk3NiwicGF0aCI6Ii83ODcxNjg5Ni81NzIyMTgzMDAtMGMzOTI4YzMtZDdiMi00MjE1LWEzYzMtZDdiNGY1MzE5NTczLkdJRj9YLUFtei1BbGdvcml0aG09QVdTNC1ITUFDLVNIQTI1NiZYLUFtei1DcmVkZW50aWFsPUFLSUFWQ09EWUxTQTUzUFFLNFpBJTJGMjAyNjA0MDElMkZ1cy1lYXN0LTElMkZzMyUyRmF3czRfcmVxdWVzdCZYLUFtei1EYXRlPTIwMjYwNDAxVDAwMzkzNlomWC1BbXotRXhwaXJlcz0zMDAmWC1BbXotU2lnbmF0dXJlPTA0MGZmYWJjYWM5OTk0NzgwMmUxNTE3NThlYzRiZWFlZTlhYjk0OTk0MDAxMzJjOTRkMjlkZTE3N2MwZTZjMTEmWC1BbXotU2lnbmVkSGVhZGVycz1ob3N0In0.JolbTcIRx1LW6kkANAzuiWbJH0odO3TRb4HhGYM9CSs) | ![회원가입](https://private-user-images.githubusercontent.com/78716896/572219561-bb7751ca-6a80-404b-8a75-ee28796d97d0.png?jwt=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3NzUwMDU5MjksIm5iZiI6MTc3NTAwNTYyOSwicGF0aCI6Ii83ODcxNjg5Ni81NzIyMTk1NjEtYmI3NzUxY2EtNmE4MC00MDRiLThhNzUtZWUyODc5NmQ5N2QwLnBuZz9YLUFtei1BbGdvcml0aG09QVdTNC1ITUFDLVNIQTI1NiZYLUFtei1DcmVkZW50aWFsPUFLSUFWQ09EWUxTQTUzUFFLNFpBJTJGMjAyNjA0MDElMkZ1cy1lYXN0LTElMkZzMyUyRmF3czRfcmVxdWVzdCZYLUFtei1EYXRlPTIwMjYwNDAxVDAxMDcwOVomWC1BbXotRXhwaXJlcz0zMDAmWC1BbXotU2lnbmF0dXJlPWYyN2M2Y2IzOTliZTM5ZDMyZGFkN2E1NjVhOGNmY2Q2NDM4NGJjN2Y0MDk3MjNjYmQwMDU4MjNkZjI4MGJhZjYmWC1BbXotU2lnbmVkSGVhZGVycz1ob3N0In0.FxCyBOUlOg8wXRFjIQZnUWyWdkYN1UeZFZY1gtV9Gk4) |
|                                                                                                                                                                                                                                                                                                                                                                                                  브랜드 애니메이션 제공                                                                                                                                                                                                                                                                                                                                                                                                   |                                                                                                                                                                                                                                                                                                                                                                                         K League 팀 로고 애니메이션 및 입력폼                                                                                                                                                                                                                                                                                                                                                                                         |                                                                                                                                                                                                                                                                                                                                                                                              이메, 비밀번호, 닉네임 입력                                                                                                                                                                                                                                                                                                                                                                                              |

|                                                                                                                                                                                                                                                                                                                                                                                                  **직관 기록(Record)**                                                                                                                                                                                                                                                                                                                                                                                                  |                                                                                                                                                                                                                                                                                                                                                                                                  **직관 상세(Detail)**                                                                                                                                                                                                                                                                                                                                                                                                   |                                                                                                                                                                                                                                                                                                                                                                                                 **경기 일정(Calendar)**                                                                                                                                                                                                                                                                                                                                                                                                  |
| :---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------: | :----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------: | :----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------: |
| ![직관기록](https://private-user-images.githubusercontent.com/78716896/572218804-5d9f6574-3047-4f50-9882-84a55081f652.png?jwt=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3NzUwMDU5MjksIm5iZiI6MTc3NTAwNTYyOSwicGF0aCI6Ii83ODcxNjg5Ni81NzIyMTg4MDQtNWQ5ZjY1NzQtMzA0Ny00ZjUwLTk4ODItODRhNTUwODFmNjUyLnBuZz9YLUFtei1BbGdvcml0aG09QVdTNC1ITUFDLVNIQTI1NiZYLUFtei1DcmVkZW50aWFsPUFLSUFWQ09EWUxTQTUzUFFLNFpBJTJGMjAyNjA0MDElMkZ1cy1lYXN0LTElMkZzMyUyRmF3czRfcmVxdWVzdCZYLUFtei1EYXRlPTIwMjYwNDAxVDAxMDcwOVomWC1BbXotRXhwaXJlcz0zMDAmWC1BbXotU2lnbmF0dXJlPWI5ZDBlOTdkODliYzY0MGM2ODY2NWQzM2UwYjRiMDMwMTE3ZTZkYWFmNmVkNjZiNjFlZmE0ZjA3YzQ2MTQyOGYmWC1BbXotU2lnbmVkSGVhZGVycz1ob3N0In0._lxm7RGS_y0hU4DQBZBFN3hna6x6e73BIGBOzqm5xOs) | ![직관 상세](https://private-user-images.githubusercontent.com/78716896/572218805-9f45c4c7-d65e-4716-8958-10a65941c74c.png?jwt=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3NzUwMDU5MjksIm5iZiI6MTc3NTAwNTYyOSwicGF0aCI6Ii83ODcxNjg5Ni81NzIyMTg4MDUtOWY0NWM0YzctZDY1ZS00NzE2LTg5NTgtMTBhNjU5NDFjNzRjLnBuZz9YLUFtei1BbGdvcml0aG09QVdTNC1ITUFDLVNIQTI1NiZYLUFtei1DcmVkZW50aWFsPUFLSUFWQ09EWUxTQTUzUFFLNFpBJTJGMjAyNjA0MDElMkZ1cy1lYXN0LTElMkZzMyUyRmF3czRfcmVxdWVzdCZYLUFtei1EYXRlPTIwMjYwNDAxVDAxMDcwOVomWC1BbXotRXhwaXJlcz0zMDAmWC1BbXotU2lnbmF0dXJlPWQ0ZGEyMTNlM2ZkOTQxZjU5Yzk5ZjEwYzlkOTc4YzRlM2IzM2YxYzA3OTBiMDYxYTYwODI3YzA1NTU0MWNjZjcmWC1BbXotU2lnbmVkSGVhZGVycz1ob3N0In0.K0SUnQdMI8OWUCWlzfJNPaHfMIj5ScLVQQK8qVpHUh0) | ![경기 일정](https://private-user-images.githubusercontent.com/78716896/572218802-2577f60f-5fcb-4781-bc2a-d11ab358c6ad.png?jwt=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3NzUwMDYxMTMsIm5iZiI6MTc3NTAwNTgxMywicGF0aCI6Ii83ODcxNjg5Ni81NzIyMTg4MDItMjU3N2Y2MGYtNWZjYi00NzgxLWJjMmEtZDExYWIzNThjNmFkLnBuZz9YLUFtei1BbGdvcml0aG09QVdTNC1ITUFDLVNIQTI1NiZYLUFtei1DcmVkZW50aWFsPUFLSUFWQ09EWUxTQTUzUFFLNFpBJTJGMjAyNjA0MDElMkZ1cy1lYXN0LTElMkZzMyUyRmF3czRfcmVxdWVzdCZYLUFtei1EYXRlPTIwMjYwNDAxVDAxMTAxM1omWC1BbXotRXhwaXJlcz0zMDAmWC1BbXotU2lnbmF0dXJlPWIzNzA1ODA0NGVhNjk0OGY5OGExZGNmMDliMDM4MDRjZjM4OTU5NTI0NTI1MTg3ZWRjNmY4YWNjMjkyNzI0ODgmWC1BbXotU2lnbmVkSGVhZGVycz1ob3N0In0.7BCV6Pnvc7SH1FLtb9TPj8oG0FzmofeHCbyc18PZaLQ) |
|                                                                                                                                                                                                                                                                                                                                                                                        경기 정보, 사진 등을 담은 직관 기록 작성                                                                                                                                                                                                                                                                                                                                                                                         |                                                                                                                                                                                                                                                                                                                                                                                           텍스트, 슬라이더 이미지로 구성한 UI                                                                                                                                                                                                                                                                                                                                                                                            |                                                                                                                                                                                                                                                                                                                                                                                       경기 일정 및 나의 직관 경기를 달력으로 제공                                                                                                                                                                                                                                                                                                                                                                                        |

|                                                                                                                                                                                                                                                                                                                                                                                                  **랭킹(Ranking)**                                                                                                                                                                                                                                                                                                                                                                                                  |                                                                                                                                                                                                                                                                                                                                                                                                 **선수 후원(Donation)**                                                                                                                                                                                                                                                                                                                                                                                                  |
| :-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------: | :----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------: |
| ![랭킹](https://private-user-images.githubusercontent.com/78716896/572218800-c590244e-47f6-43b2-8e33-3cec95c094eb.png?jwt=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3NzUwMDYzMTcsIm5iZiI6MTc3NTAwNjAxNywicGF0aCI6Ii83ODcxNjg5Ni81NzIyMTg4MDAtYzU5MDI0NGUtNDdmNi00M2IyLThlMzMtM2NlYzk1YzA5NGViLnBuZz9YLUFtei1BbGdvcml0aG09QVdTNC1ITUFDLVNIQTI1NiZYLUFtei1DcmVkZW50aWFsPUFLSUFWQ09EWUxTQTUzUFFLNFpBJTJGMjAyNjA0MDElMkZ1cy1lYXN0LTElMkZzMyUyRmF3czRfcmVxdWVzdCZYLUFtei1EYXRlPTIwMjYwNDAxVDAxMTMzN1omWC1BbXotRXhwaXJlcz0zMDAmWC1BbXotU2lnbmF0dXJlPTk2NTFkM2RjYTdjZGM1NTJmODhjYmFkYTE4NWU3NzNhMDAwNTYwMWJhYjc1ODE4ZjU5MDU2MTFhNDA1MTUwYTImWC1BbXotU2lnbmVkSGVhZGVycz1ob3N0In0.wJ04Z1rhqS6J5DBU_dAPjR24a2ZWUmYhNjIXRV0ilIU) | ![선수 후원](https://private-user-images.githubusercontent.com/78716896/572218298-a1a6dcc5-1eb3-49bb-b499-3ecf7b9f78f7.GIF?jwt=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3NzUwMDY1MzcsIm5iZiI6MTc3NTAwNjIzNywicGF0aCI6Ii83ODcxNjg5Ni81NzIyMTgyOTgtYTFhNmRjYzUtMWViMy00OWJiLWI0OTktM2VjZjdiOWY3OGY3LkdJRj9YLUFtei1BbGdvcml0aG09QVdTNC1ITUFDLVNIQTI1NiZYLUFtei1DcmVkZW50aWFsPUFLSUFWQ09EWUxTQTUzUFFLNFpBJTJGMjAyNjA0MDElMkZ1cy1lYXN0LTElMkZzMyUyRmF3czRfcmVxdWVzdCZYLUFtei1EYXRlPTIwMjYwNDAxVDAxMTcxN1omWC1BbXotRXhwaXJlcz0zMDAmWC1BbXotU2lnbmF0dXJlPTVmYjkyYTJkOTk4ODUwNzhlNDczNzhlZTA1MjExMzc1ZjFlNTI1NjNkZDM1Y2JjYjdlNzRmNjhlMWUzM2IyNjQmWC1BbXotU2lnbmVkSGVhZGVycz1ob3N0In0.w7ZdzYdu63BgdUknY0A3B2WBD9eEJ2iHv7MGfZlADo8) |
|                                                                                                                                                                                                                                                                                                                                                                                         직관 기록 및 승률 기반 랭킹 시스템                                                                                                                                                                                                                                                                                                                                                                                          |                                                                                                                                                                                                                                                                                                                                                                                             포인트로 좋아하는 선수에게 후원                                                                                                                                                                                                                                                                                                                                                                                              |

<br/>

## 7. 신경 쓴 부분 (Trouble Shooting)

### ✨ UI 애니메이션 최적화

> **문제 상황:** 서비스 진입 시 브랜드 로고 애니메이션이 불규칙하게 보여 사용자 경험 저하 유발
>
> **해결 방법:** 애니메이션 순서(F-S-C-E-O-U-L)와 지연 시간을 정밀하게 조정하고, `infinite loop` 설정을 통해 브랜드 아이덴티티를 지속적으로 노출했습니다.

### 🎨 디자인 시스템 일관성

- **Tailwind CSS v4**의 설정 기능을 활용하여 프로젝트 메인 컬러(#0046FF)와 폰트 스타일을 공통 변수화했습니다.
- 이를 통해 코드 중복을 30% 이상 줄이고, 전체 페이지에서 일관된 시각적 경험을 제공하도록 구현했습니다.

<!-- 추가 기술 -->

<br/>

## 8. 프로젝트 후기

### 김예은

> "협업 과정에서 프론트와 백엔드의 속도를 맞추기 위해 **MSW**를 적극 활용하며 소통의 효율성을 높였습니다. 특히 현대 오토에버 모빌리티 스쿨을 통해 실제 모빌리티 서비스가 지향하는 사용자 경험에 대해 고민해 볼 수 있는 뜻깊은 시간이었습니다. 팀원들과의 원활한 소통 덕분에 끝까지 즐겁게 마무리할 수 있었습니다. 모두 고생하셨습니다!"

### 강상민

> "!!"

### 황인우

> "!!"

<br/>
