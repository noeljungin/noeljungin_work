import requests
from bs4 import BeautifulSoup

# response = requests.get('http://movie.naver.com/movie/sdb/rank/rmovie.nhn?sel=cnt&date=20170714')
header = {
    'User-Agent': 'Mozilla/5.0',
    'referer': 'http://naver.com'}
host = 'https://news.naver.com/'
response = requests.get(host, headers=header)
html = response.text

soup = BeautifulSoup(html, 'html.parser')

test = soup.find(class_='newsnow_tx_inner')
#print(test)

test2 = soup.select('#text_today_main_news_428288 > li > div > a')[1]
for rows in test2:
    print(rows)

#//*[@id="text_today_main_news_428288"]/li[1]/div/a/strong
##text_today_main_news_428288 > li:nth-child(1) > div > a > strong
# test = soup.select('div.tit3 > a[href*=movie]')  # div[class=tit3]인 애들만
# print(test)
#
# test2 = soup.select('div.tit3 > a[href]')
# print(test2)
#
# test3 = soup.select('td.title .tit3')
# print(test3)
#text_today_main_news_428288 > li:nth-child(1) > div
#//*[@id="text_today_main_news_428288"]/li[1]/div
