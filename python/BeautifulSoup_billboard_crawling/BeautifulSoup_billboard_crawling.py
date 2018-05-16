from bs4 import BeautifulSoup
import urllib.request

url = "https://www.billboard.com/charts/hot-100"

def crll(url):
    src_cde = urllib.request.urlopen(url)
    soup = BeautifulSoup(src_cde, 'html.parser')
    
    li = soup.find_all('div', 'chart-row__container')
    n = 1
    for chart in li:
        print("%d 위" % (n))
        
        song = chart.find_all('h2', 'chart-row__song')
        print("song : ", end=" ")
        print(str(song)[str(song).find('">')+2:str(song).find('</')])
        
        artist = chart.find_all('span', 'chart-row__artist')
        if(artist != []) :
            print("artist : ", end=" ")
            print(str(artist)[str(artist).find('">')+3:str(artist).find('</')])
        else :
            artist = chart.find_all('a', 'chart-row__artist')
            print("artist : ", end="")
            print(str(artist)[str(artist).find('">')+3:str(artist).find('</')])
            
            n += 1
            print("\n")
    
    return 0

crll(url)
