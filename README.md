# SWProj
2024-2 소프트웨어 공학 실습 과제
[작성자] macOS: B840006 김지수, windowsOS: C012024 나정윤

### git project 주소
https://github.com/nimo-my/SWProj.git


### 역할 분담 :
1. --- 김지수
새로운 브랜치 생성 (search_revision) 
ㄴ 새로운 함수 search_bs() 구현 
ㄴ 단위테스트 (JUNIT테스트 완료) 
-> git merge + main 브랜치 병합 

2. --- 나정윤
performance_test 브랜치 생성
ㄴ search & search_bs 성능 테스트 가능한 코드를 구현 -> git merge + main 브랜치에 병합 

3. 젠킨스 파이프라인 제작
- Mac OS 버전 : 김지수
- Windows OS 버전 : 나정윤
젠킨스 CI/CD 과정 구축 (공동) -> 병합된 코드를 체크아웃 -> 빌드 -> 성능 테스트하는 스테이지 구현 + 구동 (표준 아웃풋으로 나오는 성능 테스트 결과를 정해진 폴더에 저장하도록 젠킨스 과정을 정의)


### Jenkinsfile :

[설명]
A text file that contains the definition of a \
Jenkins Pipeline and is checked into source control.\
Jenkins Pipeline의 정의를 포함하는 source control을 \
체크할 수 있도록 만들어진 텍스트 파일입니다.

[단계] (1) Checkout (2) Pre-Build (3) Build (4) Test

[동작]
Jenkins와 연동하여 깃허브의 프로젝트를 클론하여 받아와 테스트를 실행하고, 해당 프로젝트의 실행파일을 .txt 파일로 출력합니다.

pipeline의 stage는 (1) Checkout (2) Pre-Build (3) Build (4) Test 로 구성되어 있습니다. 해당 테스트의 결과 출력은 junit_test_results.txt 파일을 통해 확인하실 수도 있고,
archiveArtifacts로 설정해 놓아서 jenkins 상에서도 확인 가능합니다.

- Pre-build: PrerformanceTest.java 에서 사용될 Book 클래스를 만듭니다.
- 실제 build와 test는 각각 (3) 과 (4) 단계에서 일어납니다.



### Error Log :

#### [ Window Jenkins Error ] 
1. 'Pre-Build' Stage Error : mkdir classes Error : 같은 디렉토리 내에 이미 동일 이름을 가진 하위 디렉토리나 파일이 있기 때문에 Pre-Build Stage에서 오류가 생겼습니다. 'if not exist ~ mkdir ~' 형태의 구문을 이용하여 동일한 이름을 가진 하위 디렉토리나 파일이 없을 경우에 해당 디렉토리를 생성하도록 하였습니다. 

2. 'Build' Stage Error : step의 script 구문 안에 'def encoding = 'UTF-8' 옵션을 사용했음에도 기존 테스트 코드인 Book.java 와 PerformanceTest.java 파일의 대부분의 코드에서 인코딩 문제가 생겼습니다. Build stage 안의 script 내부에서 def encoding = 'UTF-8' 을 사용하더라도 'bat "javac PerformanceTest.java"' 에서는 적용되지 않는다고 판단하여 'bat "javac -encoding UTF-8 PerformanceTest.java"' 와 같이 내부에 인코딩 옵션을 넣어 오류를 해결했습니다. 

3. UTF-8 Encoding Error : 파이프라인 groovy Jenkins 파일에서 'def encoding = 'UTF-8' 옵션을 사용하여 인코딩 문제를 해결하고 파일을 컴파일 할 수 있도록 수정하였습니다. 

#### [ MacOS Jenkins Error ] 
- 자세한 설명은 'Pull request'의 Jenkinsfile 파트 (MacOS) 완료! #6 파트 참고

1. jenkins workspace
jenkins에서는 자체적으로 .jenkins 파일안의 workspace를 만들어서 해당 파일들을 빌드 & 컴파일을 하더라고요!
그것도 모르고 계속해서 데스크톱에 있는 클론받은 파일을 통해서 빌드를 하려고 하니 계속해서 에러가 났던 것이었습니다..
그래서 이를 'SWProj/src/Book.java' 식으로 모두 간단하게 바꿔주었습니다!

2. 명령어 cd 역할을 하는 keyword (in jenkins) -> dir([경로])
sh 'cd [경로]' 를 통해서 빌드와 컴파일을 하려 했는데, 왜인지 계속해서 pwd를 통해 현재 경로를 확인해봐도 계속해서 .jenkins/workspace/SWProj 에서 벗어나지 않았습니다. 검색해본 결과 jenkinsfile 안에서는
```
dir([경로]){
    [경로 안에서 실행해야 될 것]
}
```
를 사용한다고 하더라고요! 그래서 해당 부분 또한 수정했습니다!
dir([경로]){[경로 안에서 실행해야 될 것]} == 명령어 cd 라고 생각하면 편할 것 같아요.
(이 또한 의도한 바대로 현재 정상작동 됨!)

3. git reset 후 변경사항을 git에 커밋하고 푸시하기
코드상 오류를 수정하고 있을 당시에, 파일들의 위치를 조정한 적이 있었는데 .project 와 jenkinsfile의 위치를 옮기다가 위치가 아예 꼬여버린 적이 있었습니다.. 그래서 github 안의 로그를 보면서 git reset 명령어를 이용하여 다행히 수정 이전으로 돌아갈 수 있었습니다. 이러한 상황이 언제 어떻게 있을 지 모르니, git commit 할 때에 메세지를 잘 작성해 놔야 될 것 같습니다!