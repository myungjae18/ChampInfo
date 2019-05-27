# Java SE Personal Project<br>
<h1>JSON을 활용한 리그오브레전드 챔피언 정보 프로그램</h1>
<h2>1. 프로그램 실행 시 출력되는 메인 화면</h2>
<img src="https://postfiles.pstatic.net/MjAxOTA1MDhfMjcg/MDAxNTU3MzIwNzcwNTA0.nMVJwvgiDNZ6OpGUODPOlvEJNEpy0rslf3rJbTWvJm0g.ivKEtQNimY8wtRWA6wVeYTE1QRLYFw7mVCwKWemuol4g.PNG.myungjae18/main_page.PNG?type=w773"/>
- 디자인<br>
(1) JPanel을 사용하여 영역 구분<br>
(2) JScrollPane을 이용하여 스크롤 추가<br>
(3) 다운로드 받은 이미지 부착<br>
-> 해당 이미지는 리그오브레전드 공식 홈페이지의 사진을 
- 로직<br>
(1) 이미지를 클릭했을 경우 그 이미지에 해당되는 챔피언 정보 페이지로 이동<br>
-> 메인 페이지를 처리하는 클래스에서 상세 정보 화면을 처리하는 클래스로 정보를 제공해줌
<hr>
<h2>2. 각 이미지 클릭 시 출력되는 챔피언 상세 정보 화면</h2>
<img src="https://postfiles.pstatic.net/MjAxOTA1MDlfMzgg/MDAxNTU3MzI4OTQ0Mjgy.tg2iCi8vYasOr5N3H3WfS3r0XTQSLVCYEP7YIBw-Lh0g.tlYVRkcC8U7kvhw9onKQ9e3saD2HxAdQT_-emp_QgbYg.PNG.myungjae18/detail_page.PNG?type=w773"/><br>
- 디자인<br>
(1) JPanel을 이용하여 크게 영역을 구분한 후 다시 세부적으로 구분<br>
(2) 표시할 챔피언 스토리의 총 글씨 수를 항상 동일하게 표시하기 위해 html 태그 및 subString 클래스 사용<br>
- 로직<br>
(1) 메인 화면 클래스로부터 받은 챔피언 이름 정보를 통해 JSON 객체 안의 있는 챔피언 정보를 검색하여 출력<br>
-> 해당 JSON 파일은 라이엇 게임즈의 개발자 지원 공식 api로부터 가져옴<br><hr>
(모든 리그오브레전드 관련 저작물들은 본인이 라이엇 게임즈에 문의하여 비영리 목적으로 개발된 이 프로그램에서의 사용 및 홈페이지 게시를 허락받았습니다)
