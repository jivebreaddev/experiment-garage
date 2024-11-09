import http from 'k6/http';
import { check } from 'k6';
import { sleep } from "k6";
import { htmlReport } from "https://raw.githubusercontent.com/benc-uk/k6-reporter/main/dist/bundle.js"


export let options = {
    vus: 500,
    duration: '10m',
};

export default function () {

    const body = JSON.stringify({
        name: "HELLO",
        email: "heallo",
        phone: "123-123-1231"
    });
    const params = {
            headers: {
                'Content-Type': 'application/json',
            },
        };


    let response = http.post("http://3.34.77.61:8080/api/v1/user/", body, params);

    // 응답 확인
    check(response, {
        'is status 200': (r) => r.status === 200,
    }); //     command: run /test.js -e MY_HOSTNAME=43.201.169.49 --out json=test.json --out influxdb=http://localhost:8086/myk6db
//docker-compose exec k6-client run /test.js --out json=test.json --out influxdb=http://127.0.0.1:8086/myk6db
    sleep(0.5); // 유저당 8 반복/s  -> 8 * 500 * 60 * 10번 = 240_000번



}

//docker run --rm -e MY_HOSTNAME=3.34.77.61 -v ./test.js:/test.js -i grafana/k6 run --out influxdb=http://localhost:8086/myk6db -<test.js

//vi test.js
// docker run --rm -v ./value:/value -v ./test.js:/test.js -i grafana/k6 run --summary-trend-stats="med,p(95),p(99.9)" -<test.js
