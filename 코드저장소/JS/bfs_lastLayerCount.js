function solution(n, edge) {
    var answer = 0;
    edge.sort((a, b) => {
        if (a[0] - b[0] === 0) {
            return a[1] - b[1]
        }
        return a[0] - b[0]
    })
    //edge는 [노드,노드] 경로로 이루어진 배열, 중복 없음
    let allroute = [];
    allroute[1] = 1;
    let childList = conv2childList(edge);
    //노드랑 1단계로 연결된 모든 자식 노드를 배열로 가지는 형태
    //[노드]=[자식,자식,...]

    answer = bfs4(childList, allroute, [1], n)
    return answer;
}
//중복없는[[노드번호,노드번호],...]일때
//result[노드번호]=[노드번호,...] 해당 노드번호가 갈 수있는 모든 노드번호를 가지는 배열을 리턴

function conv2childList(edge) {
    let result = [];
    edge.forEach((ele, i) => {
        if (result[ele[0]] === undefined) {
            result[ele[0]] = [];
        }
        if (result[ele[1]] === undefined) {
            result[ele[1]] = [];
        }
        result[ele[0]].push(ele[1])
        result[ele[1]].push(ele[0])

    })
    return result;
}
//배열의 갯수를 샐수 있다.
//undefined가 들어있는 배열들을 제외해서 샐수있음
function check(array) {
    let sum = 0;
    array.forEach((ele, i) => {
        sum += 1;
    })
    return sum;
}
//childList - 노드번호에 연결된 노드번호들
//allroute - 지나간 루트
//thislayer - 현재 층에 있는 노드들
//n은 모든 노드 갯수
//마지막 layer의 노드 갯수를 return
//bfs형식으로 진행됨
function bfs4(childList, allroute, thisLayer, n) {
    // return count;
    let count = 0;//현재 층의 갯수
    let nextLayer = [];

    while (check(allroute) !== n) {//allroute의 갯수가 n일때 모든 경로 확인한것으로 판단.
        count = 0;
        nextLayer = [];//다음 레이어 노드들
        for (let i = 0; i < thisLayer.length; i++) {//현재 레이어의 노드 확인

            let next = childList[thisLayer[i]]//다음으로 가는 모든 경우

            for (let j = 0; j < next.length; j++) {
                if (allroute[next[j]] === undefined) {//지나간 경로에 없을때
                    allroute[next[j]] = 1;//그냥 1로 넣기
                    nextLayer.push(next[j])//다음레이어 노드에 넣기
                    count += 1;
                }
            }
        }
        thisLayer = nextLayer;
    }

    return count
}
