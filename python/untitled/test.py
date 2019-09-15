import requests
from random import randint
import random
import json


host = "https://event.hpcnt.com/game/"


status_req = requests.get(host+'PaHbmY')
#print(status_req.text)

#PaHbmY jungin
kjy = {
    "email": "noelcoolblue@gmail.com",
    "phone_number": "01074950329",
    "username": "김정인"
}

#6wH8O1
kkr = {
    "email": "tenn6871@gmail.com",
    "phone_number": "01044887940",
    "username": "kimkiryeong"
}

#my_req = requests.post(host, json=test)

val = {
        "number": '8075'
    }
'''
0865 3strike
1865 down

'''
val_req = requests.post(host+"PaHbmY/submit/", json=val)
print(val_req.text)
status_req = requests.get(host+'PaHbmY')
print(status_req.text)


# status_req = requests.get(host+"d8H0w")
# randoms = [1,2,3,4,5,6,7,8,9,0]
# random.shuffle(randoms)
# test = []
# for i in randoms:
#     if len(test) <= 4:
#         test.append(i)
#     else:
#         pass


# js = {}
# js['is_pass'] = False
# randoms = [1, 2, 3, 4, 5, 6, 7, 8, 9, 0]
# asdf = []
# while js['is_pass'] == False:
#
#     random.shuffle(randoms)
#     test = []
#     for i in randoms:
#         if len(test) <= 3:
#             test.append(i)
#         else:
#             pass
#
#     vals = ""
#     for i in test:
#         vals += str(i)
#
#     val = {
#         "number": '8125'
#     }
#
#     val_req = requests.post(host+"d8H0w/submit/", json=val)
#     js = val_req.json()
#
#     if js['baseball']['strike']:
#         if js['baseball']['strike'] > 0:
#             asdf.append(test)
#
