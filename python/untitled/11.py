sum = 0
count = 0

while(1):
    i = input('insert here : ')
    j = i.split(',')
    for rows in j:
        sum += int(rows)
    count += 1
    if int(j[-1]) >= 100:
        break

print(sum)
print("%.2f"%round(float(sum/count)))

