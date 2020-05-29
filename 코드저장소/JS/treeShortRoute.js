
function solution(begin, target, words) {
    var answer = 0;
    //
    if (words.findIndex(ele => ele === begin) === -1) {
        words.push(begin)
    }
    let edges = makeTree2(words)
    edges = edges.sort().filter((ele, i) => i % 2 === 1)
    //[노드,노드]로되어있는 경로로 이루어진 edges
    //edges는 중복이 없음.
    answer = search(begin, target, edges, 0, [begin]);
    answer = answer === -1 ? 0 : answer;
    return answer;
}
//유사정도 반환 - 트리만들때 사용함 (필수 x)
function similarCheck(a, b) {
    let result = 0;
    for (let i = 0; i < a.length; i++) {
        if (a.charAt(i) !== b.charAt(i)) {
            result += 1;
        }
    }
    return result;
}
//단어 배열에서 similarCheck가 1인 것들을 짝지어서 리턴
//tree만들기 [[a,b],...] 형식,중복 있음
//순환이 되는 트리
function makeTree2(words) {
    let result = [];
    for (let i = 0; i < words.length; i++) {
        for (let j = 0; j < words.length; j++) {
            if (i !== j) {
                if (similarCheck(words[i], words[j]) === 1) {
                    let tmp = [words[i], words[j]];
                    tmp.sort()
                    result.push(tmp)
                }
            }
        }
    }
    return result;
}
//tree에서 word와 연결된 상대 word,위치index를 [[word,index],...]로 배열로 리턴한다.
function findWords(tree, word) {
    let result = [];
    tree.forEach((ele, i) => {
        if (ele[0] === word) {
            result.push([ele[1], i])
        } else if (ele[1] === word) {
            result.push([ele[0], i])
        }
    })
    return result;
}
//begin 시작글자, target 목표글자, tree 모든연결, step 단계, route 지나간 경로
//tree의 형식은 중복된게 없는 연결된 짝의 배열이다.
//ex [[a,b],[b,c],[d,c],...] - a-b, b-c,d-c짝을 배열로 만든거다.
//begin에서 target까지 경로가 존재하면 step을 반환한다.
//begin에서 target까지 단거리 step을 반환.
//이거 수정하면 모든 경로도 볼수 있음
function search(start, end, vertex, route, step) {
    //start에서 1번에 갈수 있는 모든경로 찾기
    //step을 반환
    let stepCheck = -1;
    if (start === end) {
        return step
    }
    let next = findNext(vertex, start)
    //제일 낮은 step을 반환
    if (next.length === 0) {
        return -1;//다음이 없다...
    } else {
        for (let i = 0; i < next.length; i++) {
            let routeTmp = [...route];
            if (routeTmp.findIndex((ele) => ele === next[i][0]) === -1) {//안간곳
                routeTmp.push(next[i][0])
                if (stepCheck === -1) {//처음 들름
                    stepCheck = search(next[i][0], end, vertex, routeTmp, step + 1);
                } else {
                    let stepTmp = search(next[i][0], end, vertex, routeTmp, step + 1);
                    if (stepTmp !== -1) {
                        if (stepTmp < stepCheck) {
                            stepCheck = stepTmp;
                        }
                    }
                }
            } else {//간곳
            }
        }
        return stepCheck;
    }
}
