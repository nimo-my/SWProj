# SWProj
2024-2 소프트웨어 공학 실습 과제



### Jenkinsfile :

[설명]
A text file that contains the definition of a \
Jenkins Pipeline and is checked into source control.\
Jenkins Pipeline의 정의를 포함하는 source control을 \
체크할 수 있도록 만들어진 텍스트 파일입니다.

[동작]
Jenkins와 연동하여 깃허브의 프로젝트를 클론하여 받아와 테스트를 실행하고, 해당 프로젝트의 실행파일을 .txt 파일로 출력합니다.

[단계] git clone -> build -> test -> post \
[작성자] macOS: B840006 김지수, windowsOS: C012024 나정윤


### Error Log :

[ Window Jenkins Error ] 
1. 'Pre-Build' Stage Error : mkdir classes Error : 같은 디렉토리 내에 이미 동일 이름을 가진 하위 디렉토리나 파일이 있기 때문에 Pre-Build Stage에서 오류가 생겼습니다. 'if not exist ~ mkdir ~' 형태의 구문을 이용하여 동일한 이름을 가진 하위 디렉토리나 파일이 없을 경우에 해당 디렉토리를 생성하도록 하였습니다. 

2. 'Build' Stage Error : step의 script 구문 안에 'def encoding = 'UTF-8' 옵션을 사용했음에도 기존 테스트 코드인 Book.java 와 PerformanceTest.java 파일의 대부분의 코드에서 인코딩 문제가 생겼습니다. Build stage 안의 script 내부에서 def encoding = 'UTF-8' 을 사용하더라도 'bat "javac PerformanceTest.java"' 에서는 적용되지 않는다고 판단하여 'bat "javac -encoding UTF-8 PerformanceTest.java"' 와 같이 내부에 인코딩 옵션을 넣어 오류를 해결했습니다. 

3. UTF-8 Encoding Error : 파이프라인 groovy Jenkins 파일에서 'def encoding = 'UTF-8' 옵션을 사용하여 인코딩 문제를 해결하고 파일을 컴파일 할 수 있도록 수정하였습니다. 
