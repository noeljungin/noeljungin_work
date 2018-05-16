from selenium import webdriver
from bs4 import BeautifulSoup

driver = webdriver.Chrome('/Users/noel/Downloads/chromedriver')

driver.implicitly_wait(3)
driver.get('http://nid.naver.com/nidlogin.login')

#insert id, password
driver.find_element_by_name('id').send_keys('shb221b')
driver.find_element_by_name('pw').send_keys('junginkim1!')

#push login btn
driver.find_element_by_xpath('//*[@id="frmNIDLogin"]/fieldset/input').click()

#into naver pay
driver.get('https://order.pay.naver.com/home')
html = driver.page_source
soup = BeautifulSoup(html, 'html.parser')
notices = soup.select('div.p_inr > div.p_info > a > span')

for n in notices:
    print(n.text.strip())
