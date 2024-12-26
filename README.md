# 개요

## 목적
시간표를 짤때 많은 수업들 중에 원하는 수업이 많아 어려움을 겪을 때가 있다. 이때 자신이 원하는 공강일이나 원하는 수업으로 시간표를 자동으로 짜는 프로그램을 제작하게 되었습니다.
## 대상
주 고객층은 대학생이며 이외에도 스케줄을 짜야 할 경우에 사용 할 수 있다.

# 프로그램의 중요성 및 필요성

## 중요성
원하는 공강 요일이나 특정 시간을 고려 할 수 있을 뿐만 아니라, 같은 과목을 두번 넣어서 발생하는 경우를 줄일 수 있다.
## 필요성
원하는 수업을 넣고 이에 따라 시간표를 짜기 때문에 정해진 규칙에 맞춰 시간표를 빠르게 제작 할 수 있다.

# 프로그램 수행 절차

## 다이어그램
![aa](https://github.com/user-attachments/assets/7edafd01-de8a-46b7-8c15-1b895f57313d)

## 클래스 다이어그램
![p1](https://github.com/user-attachments/assets/7e77f7f8-cdb5-4e48-a1b3-e46d9190244b)


# 사용 방법
기본 실행 화면<br/>

![3](https://github.com/user-attachments/assets/2489b0ff-ae18-49b1-9ebe-62319495e6ca)<br/>

실행하면 기본적으로 저장된 시간표를 불러오게 된다. 시간표의 초기값은 모두 0으로 표현된다.

1. 가장먼저 수업을 추가한다.<br/>
과목명 : 추가하고 싶은 수업의 이름을 작성한다. 한글만 작성 가능하다.<br/>
요일 : 수업의 요일을 작성한다. ex) 월 , 화, 수<br/>
시한 : 해당 수업의 시작 교시를 작성한다 ex) 1, 2, 3<br/>
학점 : 해당 수업의 학점을 작성한다 ex) 1, 2, 3<br/>
이후에 수업을 추가하고 버튼을 눌러 넣고싶은 과목을 추가한다.

2. 수업을 추가 완료하였다면 필요에 따라 공강일을 추가한다.<br/>
원하는 공강 요일 : 원하는 날짜의 공강일을 작성한다 ex) 월, 화, 수<br/>

3. 시간표 완성하기 버튼을 누르면 작성한 시간표와 기존의 시간표를 바탕으로 시간표를 만들어 출력해준다.<br/>

4. 만약 시간표를 잘못만들었다면 시간표 리셋 버튼을 클릭한다.<br/>

# 느낌점
시간표 자동으로 짜주는 알고리즘을 작게 구현해 보았다. 적절한 규칙으로 자동으로 시간표를 짜주는 알고리즘을 개발하면서 다양한 조건에 따른 출력을 많이 신경써야 한다는 것을 알게되었다. 아직 부족한 부분이 많아 이후에 더 간결한 알고리즘 구현, 나눠서 하는 수업을 구현해보고자 한다.