from bs4 import BeautifulSoup
import requests
import datetime
import pymysql.cursors

class Scrap:
    def __init__(self):
        # today_date = datetime.date.today().ctime()[0:3]
        # if today_date in ['Tue', 'Wed', 'Thu', 'Fri']:
        #     self.input_date = str(datetime.date.today() - datetime.timedelta(days=1))
        # elif today_date == 'Mon':
        #     self.input_date = str(datetime.date.today() - datetime.timedelta(days=3))
        self.input_date = str(datetime.date.today() - datetime.timedelta(days=1))

        self.params = dict()
        self.params['ajax'] = 'true'
        self.params['tmpInqStrDt'] = self.input_date
        self.params['pbldDvCd'] = '0'
        self.params['inqStrDt'] = self.input_date.replace('-', '')
        self.params['requestTarget'] = 'searchContentDiv'

        r = requests.get('https://www.kebhana.com/cont/mall/mall15/mall1501/index.jsp', headers={'Cache-Control': 'no-cache'})
        self.cookies = r.cookies

    def request(self):
        r = requests.post('https://www.kebhana.com/cms/rate/wpfxd651_01i_01.do', data=self.params, cookies=self.cookies)
        soup = BeautifulSoup(r.text, 'html.parser')
        val = None
        nation_dict = {
            u'미국 USD': val,
            u'일본 JPY (100)': val,
            u'유로 EUR': val,
            u'중국 CNY': val,
            u'영국 GBP': val,
            u'태국 THB': val,
            u'호주 AUD': val,
            u'홍콩 HKD': val
        }

        for rows in soup.select('table.tblBasic > tbody > tr'):
            nation = rows.select('a[href*=HanaBank] > u')[0].text.strip()
            ex = rows.select('td')[1].text.strip().replace(',', '')

            for r in nation_dict.keys():
                if r == nation:
                    nation_dict[r] = ex

        print('date : {}, usd: {}, jpy: {}, eur: {}, cny: {}, gbp: {}, thb: {}, aud: {}, hkd: {}'.format
              (self.input_date,
               nation_dict[u'미국 USD'],
               nation_dict[u'일본 JPY (100)'],
               nation_dict[u'유로 EUR'],
               nation_dict[u'중국 CNY'],
               nation_dict[u'영국 GBP'],
               nation_dict[u'태국 THB'],
               nation_dict[u'호주 AUD'],
               nation_dict[u'홍콩 HKD']))

        conn = pymysql.connect(host='localhost',
                               user='root',
                               password='123456',
                               db='mysql',
                               charset='utf8mb4')

        try:
            with conn.cursor() as cursor:
                select = 'SELECT date FROM exchange_rate where date=%s'
                cursor.execute(select, (self.input_date))
                rows = cursor.fetchall()
                if len(rows) < 1:
                    sql = 'INSERT INTO exchange_rate(date, USD, JPY, EUR, CNY, GBP, THB, AUD, HKD) VALUES(%s, %s, %s, %s, %s, %s, %s, %s, %s)'
                    cursor.execute(sql, (
                    self.input_date,
                    nation_dict[u'미국 USD'],
                    nation_dict[u'일본 JPY (100)'],
                    nation_dict[u'유로 EUR'],
                    nation_dict[u'중국 CNY'],
                    nation_dict[u'영국 GBP'],
                    nation_dict[u'태국 THB'],
                    nation_dict[u'호주 AUD'],
                    nation_dict[u'홍콩 HKD']))

                    conn.commit()
        finally:
            conn.close()

test = Scrap()
test.request()