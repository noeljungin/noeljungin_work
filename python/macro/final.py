# -*- encoding:utf8 -*-

from selenium import webdriver
from bs4 import BeautifulSoup
from urllib.request import urlretrieve
from PIL import Image
from PIL import ImageOps
import sys
from PyQt4.QtCore import *
from PyQt4.QtGui import *
from PyQt4 import QtGui, QtCore
import time
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.common.by import By

# 개발자 : 박건희, 오수빈 (수정 : 박건희)
# http://ticket.interpark.com/Ticket/Goods/GoodsInfo.asp?GoodsCode=19007538
# test 파일 만드는 함수
def makeTest(testStr):
    test = open("test.html", "w", encoding="utf-8")
    test.write(testStr)
    test.close()

# 이미지를 선명하게 바꿔주는 함수
def cleanImage(imagePath):
    image = Image.open(imagePath)
    image = image.point(lambda x: 0 if x < 180 else 220)
    borderImage = ImageOps.expand(image, border=0, fill='white')
    borderImage.save(imagePath)
    borderImage.close()

# 활동로그를 기록하는 함수
def log(logText):
    # 현재 시간을 구한다.
    now = time.localtime()
    nowTime = "%04d-%02d-%02d %02d:%02d:%02d" % (
        now.tm_year, now.tm_mon, now.tm_mday, now.tm_hour, now.tm_min, now.tm_sec)

    # 활동로그를 기록한다.
    log = open("log.txt", "a", encoding="utf-8")
    log.write("[" + nowTime + "] " + str(logText) + "\n")
    log.close()

# 사용자 정의 키보드 이벤트 : QWidget
def esc(event):
    if event.key() == QtCore.Qt.Key_Escape :
        # 활동로그
        log("프로그램 종료")
        sys.exit()
    event.accept()

# captcha 입력창 닫아주는 함수
def close_2():
    win.close()

# 경고창을 띄우는 함수
def msg(str):
    QMessageBox.information(win, "error!", str)

# main
if __name__ == '__main__':
# 프로그램 시작
    # 활동로그
    log("프로그램 시작")

# 매크로 시작
    for i in range(1, 10):
        try:
            userID = 'shb221b'
            userPW = 'sanzo103'
            userNum = '851003'
            #19011420
            userSearch = 'http://ticket.interpark.com/Ticket/Goods/GoodsInfo.asp?GoodsCode=19011420'
            QDate = "<span style=\\'color:#A90000\\'>선택된 날짜 : 2019년 8월 10일</span>"
            userTime = '1회차'
            userTicket = '일반'
            userBankq = 38052
            userDate = '20190810'
            cbCheck = [1, 1, 1, 1, 1]

        # 인터파크 화면 띄우기
            # 드라이브 객체 생성
            url = '/Users/noel/Documents/chromedriver'  # 드라이브가 있는 경로
            driver = webdriver.Chrome(url)

            driver.get("http://ticket.interpark.com/Ticket/Goods/GoodsInfo.asp?GoodsCode=19011420")

        # 공연 기간 정보 가져오기
            Dnow = driver.find_element_by_xpath('//p[@class="time"]').text
            Dnow = Dnow[Dnow.find('~ ') + 2:].replace('.', '')

        # 로그인
            # 로그인 페이지

            driver.get("https://accounts.interpark.com/authorize/ticket-pc?origin=https%3A%2F%2Fticket%2Einterpark%2Ecom%2FGate%2FTPLoginConfirmGate%2Easp%3FGroupCode%3D%26Tiki%3D%26Point%3D%26PlayDate%3D%26PlaySeq%3D%26HeartYN%3D%26TikiAutoPop%3D%26BookingBizCode%3D%26MemBizCD%3DWEBBR%26CPage%3DB%26GPage%3Dhttp%253A%252F%252Fticket%252Einterpark%252Ecom%252F&postProc=IFRAME")

            # ID, PW 입력하기
            driver.find_element_by_xpath('//*[@id="userId"]').send_keys(userID)  # ID 입력
            driver.find_element_by_xpath('//*[@id="userPwd"]').send_keys(userPW)  # PW 입력

            # 로그인 버튼 누르기
            btn = driver.find_element_by_xpath('//*[@id="btn_login"]')
            btn.click()

            driver.get(userSearch)

            try:
                element = WebDriverWait(driver, 10).until(EC.presence_of_element_located((By.ID, 'IDGoodsName')))
            except Exception as e:
                print(e, "로딩 안됐음")
                driver.get(userSearch)

            # 활동로그
            log("로그인 성공")

            # 페이지 로딩 대기
            time.sleep(0.5)

        # 예매하기_2
            # 예매창 열기
            driver.execute_script('javascript:fnNormalBooking();')

            # 활동로그
            log("예매창 띄우기")

            # 예매창 객체 받아오기
            driver.switch_to.window(driver.window_handles[1])

            # 맴버십이십니까? 일반회원입니다.
            try:
                driver.find_element_by_xpath("//img[@alt='일반회원 구매']").click()
                driver.switch_to.window(driver.window_handles[1])
            except:
                elem = ''

            # 닫기 버튼 누르기 (만 n세 미만)
            try:
                elem = driver.find_element_by_xpath("//span[@class='btn02']")
                elem.click()
            except:
                elem = ''

        # 관람일/회차선택 (1단계)
            try:
                # 날짜
                # 1단계 프레임 받아오기

                try:
                    element = WebDriverWait(driver, 10).until(EC.presence_of_element_located((By.ID, 'ifrmBookStep')))
                except Exception as e:
                    print(e, "로딩 안됐음")

                frame = driver.find_element_by_id('ifrmBookStep')
                driver.switch_to.frame(frame)

                # 달(月) 바꾸기
                driver.execute_script("javascript: fnChangeMonth('" + userDate[:6] + "');")

                # 날짜 선택하기
                try:
                    # 달력 정보가 존재할 경우
                    # 달력 정보 가져오기
                    #print(driver.page_source)
                    bs4 = BeautifulSoup(driver.page_source, "html.parser")
                    calender = bs4.findAll('a', id='CellPlayDate')
                    elem = calender[0]["onclick"]

                    # 사용자의 입력값과 일치하는 함수를 찾는다.
                    for i in range(0, len(calender)):
                        if "fnSelectPlayDate(" + str(i) + ", '" + userDate + "')" == calender[i]["onclick"]:
                            elem = calender[i]["onclick"]
                            break

                    # 해당 날짜 선택하기
                    driver.execute_script("javascript:" + elem)

                except:
                    # 달력 정보가 존재하지 않을 경우
                    # 공연가능한 마지막 달로 이동한다
                    driver.execute_script("javascript: fnChangeMonth('" + Dnow[:6] + "');")

                    # 달력 정보 가져오기
                    #print(driver.page_source)
                    bs4 = BeautifulSoup(driver.page_source, "html.parser")
                    calender = bs4.findAll('a', id='CellPlayDate')
                    Dnow = calender[len(calender) - 1]["onclick"]

                    # 해당 날짜 선택하기
                    driver.execute_script("javascript:" + Dnow)

                # 페이지 로딩 대기
                time.sleep(0.5)

                # 회차
                # 회차 정보 가져오기
                #print(driver.page_source)
                bs4 = BeautifulSoup(driver.page_source, "html.parser")
                timeList = bs4.find('div', class_='scrollY').find('span', id='TagPlaySeq').findAll('a', id='CellPlaySeq')

                # 회차 유효성 검사
                try:
                    if int(userTime[0]) <= len(timeList): elem = timeList[int(userTime[0]) - 1]["onclick"]
                    else: elem = timeList[0]["onclick"]
                except: elem = timeList[0]["onclick"]

                # 회차 선택하기
                driver.execute_script("javascript:" + elem)

                # 다음단계
                # 메인 프레임 받아오기
                driver.switch_to.default_content()

                # 2단계 넘어가기
                driver.execute_script("javascript:fnNextStep('P');")

                # 활동로그
                log("관람일/회차선택")

                # 페이지 로딩 대기
                time.sleep(0.2)

            except:
                # 관람일/회차선택 단계가 없을 경우
                elem=''

        # 좌석 선택 (2단계)
            # 안심 예매
            # 2단계 프레임 받아오기
            driver.switch_to.default_content()
            frame = driver.find_element_by_id('ifrmSeat')
            driver.switch_to.frame(frame)

            # Captcha 뚫기
            try:
                # Captcha가 있을 경우
                while (True):
                    # Captcha 사진 가져오기
                    bs4 = BeautifulSoup(driver.page_source, "html.parser")
                    Captcha = bs4.find('div', class_='capchaInner').find('img', id='imgCaptcha')['src']

                    # Captcha.jpg 만들기
                    urlretrieve(Captcha, "captcha.jpg")
                    cleanImage("captcha.jpg")

                    # Captcha 입력창 띄우기
                    app_2 = QtGui.QApplication(sys.argv)
                    win = QWidget()
                    win.keyPressEvent = esc

                    # 위젯 설정
                    # Captcha 이미지 띄우기
                    img = QLabel()
                    img.setAlignment(Qt.AlignCenter)
                    img.setPixmap(QPixmap("captcha.jpg"))

                    # Captcha 입력할 text 필드
                    captcha = QLineEdit(win)
                    captcha.setFocus()
                    captcha.setFont(QFont("consolas", 20))
                    captcha.setAlignment(Qt.AlignCenter)
                    captcha.editingFinished.connect(close_2)

                    # 입력완료 버튼
                    b2 = QPushButton("입력완료", win)
                    b2.toggle()
                    b2.setAutoDefault(True)
                    b2.clicked.connect(close_2)

                    # Layout에 추가하기
                    flo = QFormLayout()
                    flo.addRow(img)
                    flo.addRow(captcha)
                    flo.addRow(b2)

                    # 입력창 옵션 설정
                    win.setLayout(flo)
                    win.setWindowIcon(QIcon("interpark_icon.ico"))
                    win.setGeometry(830, 350, 200, 100)
                    win.setContentsMargins(2, 1, 2, 2)
                    win.setWindowTitle("captcha")
                    win.setFont(QFont("consolas"))
                    win.show()

                    # loop 경계선
                    app_2.exec_()

                    # Captcha 값 입력하기
                    #print(driver.page_source)
                    if captcha.text() == "": text = "ERROR"
                    else: text = captcha.text()
                    driver.find_element_by_xpath("//div[@class='validationTxt']//span").click()
                    driver.find_element_by_xpath("//input[@id='txtCaptcha']").send_keys(text)

                    # Captcha 입력완료
                    driver.execute_script("javascript:fnCheck();")

                    # 성공 여부 검사
                    bs4 = BeautifulSoup(driver.page_source, "html.parser")
                    Captcha_ch = bs4.find('div', class_='validationTxt alert')
                    if Captcha_ch == None:
                        # 성공했을 경우

                        # 활동로그
                        log("Captcha 입력 성공")

                        break
                    else:
                        # 실패했을 경우
                        # Captcha 새로고침
                        driver.execute_script("javascript:fnCapchaRefresh();")
                        continue
            except:
                # Captcha가 없을 경우
                elem = ''

        # 다양한 경우에 대한 빈 좌석 칮가
            # 2단계 프레임 받아오기
            driver.switch_to.default_content()
            frame = driver.find_element_by_id('ifrmSeat')
            driver.switch_to.frame(frame)

            # 미니맵 존재여부 검사
            try:
                frame = driver.find_element_by_id('ifrmSeatView')
                driver.switch_to.frame(frame)
                bs4 = BeautifulSoup(driver.page_source, "html.parser")
                elem = bs4.find('map')
            except:
                elem = None

            # 미니맵, 구역의 상태에 따라 동작을 다르게 한다.
            # 미니맵 = O, 구역 = O
            if elem != None :
                # 미니맵이 존재할 경우
                # 구역 리스트 받아오기
                areaList = bs4.findAll('area')
                print(areaList)
                # 빈 좌석 찾기
                seatch = False
                while seatch != True :
                    for i in range(0, len(bs4.findAll('area')) + 1) :
                        # 좌석 프레임 받아오기
                        driver.switch_to.default_content()
                        frame = driver.find_element_by_id('ifrmSeat')
                        print(i, frame)
                        driver.switch_to.frame(frame)
                        frame = driver.find_element_by_id('ifrmSeatDetail')
                        driver.switch_to.frame(frame)

                        # 좌석 정보를 읽어온다.
                        bs4 = BeautifulSoup(driver.page_source, "html.parser")
                        seatList = bs4.findAll('img', class_='stySeat')

                        # 좌석이 존재할 경우 error X -> except 실행 X
                        try:
                            # 좌석 등급 조건에 따른 가부
                            for i in range(0, len(seatList)):
                                seat = seatList[i]
                                text = seat['alt'][seat['alt'].find('[') + 1:]
                                if (text.find("VIP") != -1) & (cbCheck[0] == 1):
                                    seatch = True
                                    break
                                if (text.find("R") != -1) & (cbCheck[1] == 1):
                                    seatch = True
                                    break
                                if (text.find("S") != -1) & (cbCheck[2] == 1):
                                    seatch = True
                                    break
                                if (text.find("A") != -1) & (cbCheck[3] == 1):
                                    seatch = True
                                    break
                                if cbCheck[4] == 1:
                                    seatch = True
                                    break

                            # 좌석 유무를 검사한다.
                            if seatch == True:
                                # 좌석이 있을 경우
                                # 좌석 선택하기
                                driver.execute_script(seat['onclick'] + ";")

                                # 2단계 프레임 받아오기
                                driver.switch_to.default_content()
                                frame = driver.find_element_by_id('ifrmSeat')
                                driver.switch_to.frame(frame)

                                # 3단계 넘어가기
                                driver.execute_script("javascript:fnSelect();")

                                # 활동로그
                                log("빈좌석 찾기 성공")

                                # 페이지 로딩 대기
                                time.sleep(0.5)

                                # 반복문 종료
                                break
                        # 좌석이 존재하지 않을 경우 error O -> except 실행
                        except:
                            # 좌석이 없을 경우
                            # 미니맵 프레임 받아오기
                            driver.switch_to.default_content()
                            frame = driver.find_element_by_id('ifrmSeat')
                            driver.switch_to.frame(frame)
                            frame = driver.find_element_by_id('ifrmSeatView')
                            driver.switch_to.frame(frame)

                            # 구역 리스트 받아오기
                            bs4 = BeautifulSoup(driver.page_source, "html.parser")
                            areaList = bs4.findAll('area')

                            # 구역 바꾸기
                            if i == len(areaList) :
                                # 마지막 반복 단계
                                driver.execute_script(areaList[0]["href"])
                            else :
                                # 그 외
                                try:
                                    # 구역 리스트의 크기가 같을 경우
                                    driver.execute_script(areaList[i]["href"])
                                except:
                                    # 구역 리스트의 크기가 다를 경우
                                    driver.execute_script(areaList[0]["href"])

                            # 페이지 로딩 대기
                            time.sleep(0.5)

                            # 좌석을 불러오기 경고창 감지
                            try:
                                alert = driver.switch_to_alert()
                                alert.accept()
                                time.sleep(3)
                            except:
                                elem = ''
                    if i == len(bs4.findAll('area')):
                        break

        # 가격/할인선택 (3단계)
            # 3단계 프레임 받아오기
            driver.switch_to.default_content()
            frame = driver.find_element_by_id('ifrmBookStep')
            driver.switch_to.frame(frame)

            # 표 선택하기
            # 표 정보를 가져온다.
            #print(driver.page_source)
            bs4 = BeautifulSoup(driver.page_source, "html.parser")
            ticketList = bs4.findAll('select')

            # 사용자의 입력값과 일치하는 함수를 찾는다.
            for i in range(0, len(ticketList)):
                ticketStr = ticketList[i]["pricegradename"]
                if ticketStr.find(userTicket) != -1:
                    # 사용자의 입력값과 일치하는 선택지가 있다면
                    elem = ticketList[i]["index"]
                    break

            # 표 선택하기
            try: driver.find_element_by_xpath("//td[@class='taL']//select[@index='" + str(elem) + "']//option[@value='1']").click()
            except: driver.find_element_by_xpath("//td[@class='taL']//select[@pricegrade='01']//option[@value='1']").click()

            # 다음단계
            # 메인 프레임 받아오기
            driver.switch_to.default_content()

            # 4단계 넘어가기
            driver.execute_script("javascript:fnNextStep('P');")

            # 특수표 경고창 감지
            try:
                alert = driver.switch_to_alert()
                alert.accept()
            except:
                elem = ''

            # 활동로그
            log("가격/할인선택")

            # 페이지 로딩 대기
            time.sleep(0.5)

        # 배송선택/주문자확인 (4단계)
            # 4단계 프레임 받아오기
            frame = driver.find_element_by_id('ifrmBookStep')
            driver.switch_to.frame(frame)
            time.sleep(0.5)

            # 주문자 정보 입력 (주민번호 앞 6자리 : YYDDMM)
            #print(driver.page_source)
            driver.find_element_by_xpath("//td[@class='form']//input[@id='YYMMDD']").send_keys(userNum)  # 주민번호 입력

            # 이메일 정보를 받아온다.
            bs4 = BeautifulSoup(driver.page_source, "html.parser")
            userEmail = bs4.find('input', id='Email')["value"]

            # 다음단계
            # 메인 프레임 받아오기
            driver.switch_to.default_content()
            time.sleep(0.5)

            # 5단계 넘어가기
            driver.execute_script("javascript:fnNextStep('P');")

            # 활동로그
            log("배송선택/주문자확인")

            # 페이지 로딩 대기
            time.sleep(0.5)

        # 결제하기_1 (5-1단계)
            # 5-1단계 프레임 받아오기
            frame = driver.find_element_by_id('ifrmBookStep')
            driver.switch_to.frame(frame)

            # 결제 수단 선택 (무통장입금)
            #print(driver.page_source)
            elem = driver.find_element_by_xpath("//tr[@id='Payment_22004']//input[@name='Payment']")
            elem.click()

            # 은행 선택 (무통장입금)
            elem = driver.find_element_by_xpath("//select[@id='BankCode']//option[@value='" + str(userBank) + "']")
            elem.click()
            time.sleep(0.5)

            # 다음단계
            # 메인 프레임 받아오기
            driver.switch_to.default_content()

            # 5-2단계 넘어가기
            driver.execute_script("javascript:fnNextStep('P');")

            # 활동로그
            log("결제하기")

            # 페이지 로딩 대기
            time.sleep(0.5)

        # 결제하기 _2 (5-2단계)
            # 5-1단계 프레임 받아오기
            frame = driver.find_element_by_id('ifrmBookStep')
            driver.switch_to.frame(frame)

            # 약관 동의
            # 취소수수료/취소기한을 확인하였으며, 동의합니다.
            elem = driver.find_element_by_xpath("//input[@id='CancelAgree']")
            elem.click()

            # 제3자 정보제공 내용에 동의합니다.
            elem = driver.find_element_by_xpath("//input[@id='CancelAgree2']")
            elem.click()
            time.sleep(0.5)

            # 다음단계
            # 메인 프레임 받아오기
            driver.switch_to.default_content()

            # 5-2단계 넘어가기
            driver.execute_script("javascript:fnNextStep('P');")

            # 활동로그
            log("예매 완료")

            # 페이지 로딩 대기
            time.sleep(0.5)

        # 예매 정보 출력
            # 예매 완료 페이지 받아오기
            driver.switch_to.default_content()
            frame = driver.find_element_by_id('ifrmBookEnd')
            driver.switch_to.frame(frame)

            # 예매 정보를 기록할 파일을 만든다
            result = open("result.txt", "w", encoding="utf-8")

            # 상품정보
            result.write("___________ 상품정보 ___________\n")

            # 예약 번호
            text_1 = driver.find_element_by_xpath("//p[@class='tit']//span[1]").text
            text_2 = driver.find_element_by_xpath("//p[@class='tit']//span[2]").text
            result.write(text_1 + " : ")
            result.write(text_2 + "\n")

            # 상품
            text_1 = driver.find_element_by_xpath("//div[@class='contT']//table//tbody//tr[1]//th").text
            text_2 = driver.find_element_by_xpath("//div[@class='contT']//table//tbody//tr[1]//td").text
            result.write(text_1 + " : ")
            result.write(text_2 + "\n")

            # 장소
            text_1 = driver.find_element_by_xpath("//div[@class='contT']//table//tbody//tr[2]//th").text
            text_2 = driver.find_element_by_xpath("//div[@class='contT']//table//tbody//tr[2]//td").text
            result.write(text_1 + " : ")
            result.write(text_2 + "\n")

            # 일시
            text_1 = driver.find_element_by_xpath("//div[@class='contT']//table//tbody//tr[3]//th").text
            text_2 = driver.find_element_by_xpath("//div[@class='contT']//table//tbody//tr[3]//td").text
            result.write(text_1 + " : ")
            result.write(text_2 + "\n")

            # 좌석
            text_1 = driver.find_element_by_xpath("//div[@class='contT']//table//tbody//tr[4]//th").text
            text_2 = driver.find_element_by_xpath("//div[@class='contT']//table//tbody//tr[4]//td//div[@class='box_scroll']").text
            result.write(text_1 + " : ")
            result.write(text_2 + "\n")

            # 예매자 정보
            result.write("__________ 예매자 정보 __________\n")

            # 예매자
            text_1 = driver.find_element_by_xpath("//div[@class='contB']//table//tbody//tr[1]//th").text
            text_2 = driver.find_element_by_xpath("//div[@class='contB']//table//tbody//tr[1]//td").text
            result.write(text_1 + " : ")
            result.write(text_2 + "\n")

            # 예매자 연락처
            text_1 = driver.find_element_by_xpath("//div[@class='contB']//table//tbody//tr[2]//th").text
            text_2 = driver.find_element_by_xpath("//div[@class='contB']//table//tbody//tr[2]//td").text
            result.write(text_1 + " : ")
            result.write(text_2 + "\n")

            # 티켓수령방법
            text_1 = driver.find_element_by_xpath("//div[@class='contB']//table//tbody//tr[3]//th").text
            text_2 = driver.find_element_by_xpath("//div[@class='contB']//table//tbody//tr[3]//td").text
            result.write(text_1 + " : ")
            result.write(text_2 + "\n")

            # 결제정보
            result.write("___________ 결제정보 ___________\n")

            # 총 결제금액
            text_1 = driver.find_element_by_xpath("//table[@class='new_t']//thead//tr[1]//th").text
            text_2 = driver.find_element_by_xpath("//table[@class='new_t']//thead//tr[1]//td").text
            result.write(text_1 + " : ")
            result.write(text_2 + "\n")

            # 티켓금액
            text_1 = driver.find_element_by_xpath("//table[@class='new_t']//tbody//tr[1]//th").text
            text_2 = driver.find_element_by_xpath("//table[@class='new_t']//tbody//tr[1]//td").text
            result.write(text_1 + " : ")
            result.write(text_2 + "\n")

            # 수수료
            text_1 = driver.find_element_by_xpath("//table[@class='new_t']//tbody//tr[2]//th").text
            text_2 = driver.find_element_by_xpath("//table[@class='new_t']//tbody//tr[2]//td").text
            result.write(text_1 + " : ")
            result.write(text_2 + "\n")

            # 배송료
            text_1 = driver.find_element_by_xpath("//table[@class='new_t']//tbody//tr[3]//th").text
            text_2 = driver.find_element_by_xpath("//table[@class='new_t']//tbody//tr[3]//td").text
            result.write(text_1 + " : ")
            result.write(text_2 + "\n")

            # 취소기한
            text_1 = driver.find_element_by_xpath("//div[@class='completeL']//ul//li[1]").text
            result.write(text_1 + "\n")

            # 결제상세정보
            result.write("_________ 결제상세정보 _________\n")

            # 결제방법
            text_1 = driver.find_element_by_xpath("//div[@class='completeR']//table//tbody//tr[1]//th").text
            text_2 = driver.find_element_by_xpath("//div[@class='completeR']//table//tbody//tr[1]//td").text
            result.write(text_1 + " : ")
            result.write(text_2 + "\n")

            # 입금마감일시
            text_1 = driver.find_element_by_xpath("//div[@class='completeR']//table//tbody//tr[2]//th").text
            text_2 = driver.find_element_by_xpath("//div[@class='completeR']//table//tbody//tr[2]//td").text
            result.write(text_1 + " : ")
            result.write(text_2 + "\n")

            # 입금계좌
            text_1 = driver.find_element_by_xpath("//div[@class='completeR']//table//tbody//tr[3]//th").text
            text_2 = driver.find_element_by_xpath("//div[@class='completeR']//table//tbody//tr[3]//td").text
            result.write(text_1 + " : ")
            result.write(text_2 + "\n")

            # 예금주명
            text_1 = driver.find_element_by_xpath("//div[@class='completeR']//table//tbody//tr[4]//th").text
            text_2 = driver.find_element_by_xpath("//div[@class='completeR']//table//tbody//tr[4]//td").text
            result.write(text_1 + " : ")
            result.write(text_2 + "\n")

            # 예매 정보를 기록한 파일을 닫아준다.
            result.close()

            # 활동로그
            log("예매 정보 출력")

        # 예매창 닫기
            driver.close()

            # 활동로그
            log("예매창 닫기")

        # 마이페이지 접속
            # 기존 창으로 제어를 이동한다.
            driver.switch_to.window(driver.window_handles[0])

            # 마이페이지로 이동
            elem = driver.find_element_by_xpath('//li[@class="mypage"]/a')
            elem.click()

            # 활동로그
            log("마이페이지 접속")

        # 예매결과 확인
            # 예매내역 중 가장 최신 내역을 확인한다.
            driver.execute_script("javascript: fnPlayBookDetail(0);")

            # 활동로그
            log("예매결과 확인")

        except:
        # 에러 발생할 경우
            driver.quit()

            # 활동로그
            log("에러 발생")

    # 프로그램 종료
        # 활동로그
        log("프로그램 종료")

        driver.quit()