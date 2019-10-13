//cluster
//싱글 스레드인 노드가 CPU코어를 모두 사용할 수 있게 해준다
//포트를 공유하는 노드 프로세스를 여러개 둘 수 있어 요청이 많이 들어왔을 때 병렬로 실행된 서버의 개수만큼 요청을 분산
//코어 하나당 노드 프로세스 하나가 돌아가게 할 수 있다
//세션 공유가 불가능하다 - Redis등의 서버를 도입하여 해결 가능

const cluster = require('cluster');
const http = require('http');
const numCPUs = require('os').cpus().length;

if (cluster.isMaster){
    console.log(`master process id: ${process.pid}`);
    for(let i=0; i < numCPUs; i += 1){
        cluster.fork();
    }
    cluster.on('exit', (worker, code, signal) => {
        console.log(`${worker.process.pid} worker end`);
    });
}else{
    http.createServer((req, res) => {
        res.write('<h1>hello</h1>');
        res.end('<p>cluster</p>');
        setTimeout(() => {
            process.exit(1);
        }, 1000);
    }).listen(8085);
    console.log(`${process.pid} worker submit`)
}