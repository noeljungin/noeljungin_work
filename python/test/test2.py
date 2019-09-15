
#python 동일한 값 필터링 하기
import collections

#collections.Counter()
#컨테이너에 동일한 값이 몇개나 들어있는지 확인이 가능하다

a = [1, 1, 2, 3, 4, 5, 6, 7, 7]
b = [1, 2, 3, 4, 5, 6, 7]

#a 에서 b에 들어있는 중복값을 한번씩만 제거해주어야 한다
c = collections.Counter(a) - collections.Counter(b)

print(c)
#Counter({1: 1, 7: 1})

#dict 형태로 출력되기 때문에 필요한 키값만 출력해준다
print(c.keys())