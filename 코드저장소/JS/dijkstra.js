
//5:34 11:07

//N은 의미없음
//road는 [[노드,노드,비용],...]으로 입력되어있으며, 양방향이라는 조건으로 입력되어있다.
//roadL은 roadL[노드]=[[노드,비용],...]으로 해당 노드에서 직접 연결된 노드들과 비용을 바로 얻을수 있다.
function solution(N, road, K) {
    var answer = 0;

    // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
    let roadL = getMap(road);
    let result = diji(N, roadL, K)
    result = result.filter(ele => ele <= K);
    answer = result.length;
    return answer;
}
function getMap(road) {
    let result = [];
    road.forEach((ele) => {
        if (result[ele[0]] === undefined) {
            result[ele[0]] = [];
        }
        if (result[ele[1]] === undefined) {
            result[ele[1]] = [];
        }
        result[ele[1]].push([ele[0], ele[2]])
        result[ele[0]].push([ele[1], ele[2]])
    })
    return result;
}
function diji(roadL) {
    //1 2 3 4 5
    // let result=Array(N).fill().map(ele=>0);
    let result = [];//다익스트라 업데이트되는 표
    result[1] = 0;//1은 0으로 고정
    let nextIndex = [];//다음 가야할 노드에 대한 정보[노드,거리]
    let index = 1;//현재 노드번호
    while (true) {
        let next = roadL[index];// index노드에서 다음으로 가는 경우들
        next.forEach(ele => {
            if (ele[0] !== 1) {//1로 가는 경우 제외하고 시작
                if (result[ele[0]] === undefined) {//가본적 없을때
                    result[ele[0]] = ele[1] + result[index];//index에서 ele[0]까지 가는 거리 + 1에서 index까지 가는 거리
                    nextIndex.push([ele[0], result[ele[0]]]);//다음 가야할 순서에 저장
                } else {
                    //index에서 
                    // console.log("1에서"+index+"로 가는 기존:"+result[index])
                    // console.log(index+"에서"+ele[0]+"로 가는 경우"+ele[1])
                    result[ele[0]] = (result[index] + ele[1]) < result[ele[0]] ? (result[index] + ele[1]) : result[ele[0]];
                    //다음 선택시 바뀐 정보 업데이트
                    //nextIndex에 ele[0]까지 가는 거리정보가 바뀌었으니 수정해준다.
                    let changeI = nextIndex.findIndex(eleF => eleF[0] === ele[0])
                    if (changeI !== -1) {
                        nextIndex[changeI] = [ele[0], result[ele[0]]];
                    }
                }
            }
        })
        if (nextIndex.length === 0) {//더이상 갈 곳이 없을때 종료
            break;
        }
        nextIndex.sort((a, b) => {//거리가 짧은거 부터 먼저 다익스트라 진행
            return a[1] - b[1]
        })

        index = nextIndex.shift()[0];//앞에꺼부터 진행
    }
    return result;
}
//가장 큰 합을 구하기
//대각선1만 가능