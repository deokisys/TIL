///크루스칼

//[[좌표1,좌표2,비용],...] , 좌표1<좌표2, 중복 없을경우 사용가능.
function kruskal(costs, n) {
    costs.sort((a, b) => {//배열 2번의값을 기준으로 오름차순 정렬
        let aV = a[2];
        let bV = b[2];
        return aV - bV;
    })
    //배열 만들기
    let connect = makeArray(n).map((ele, i) => makeArray(1, i));
    let bridge = 0;
    //크루스칼 적용
    let index = 0;
    while (connect.length !== 1) {
        let thisConnect = costs[index];
        let leftPos = -1;
        let rightPos = -1;
        //connect에 있는지 확인
        for (let i = 0; i < connect.length; i++) {
            if (connect[i].findIndex(ele => ele === thisConnect[0]) !== -1) {
                leftPos = i;
                break;
            }
        }
        for (let i = 0; i < connect.length; i++) {
            if (connect[i].findIndex(ele => ele === thisConnect[1]) !== -1) {
                rightPos = i;
                break;
            }
        }
        //leftPos와 rightpos가 같으면 연결된거
        if (leftPos !== rightPos) {//연결 안됨
            //삽입
            connect.push([...connect[leftPos], ...connect[rightPos]])
            //삭제
            if (leftPos < rightPos) {
                connect.splice(rightPos, 1)
                connect.splice(leftPos, 1)
            } else {
                connect.splice(leftPos, 1)
                connect.splice(rightPos, 1)
            }
            bridge += thisConnect[2];
        }
        index += 1;
    }

    return bridge;
}


//크루스칼?