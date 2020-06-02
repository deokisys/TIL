//10:30  3:22 - 오래걸림...ㅎㄸ
//Nodeinfo=[[x1,y1],...]//x,y좌표가 들어있음 따로 번호가 없음
//전위, 후위순환은 구현하기
function solution(nodeinfo) {
    var answer = [[]];
    //준비작업
    //
    let tree = binary(nodeinfo)
    answer = [searchPre(tree, tree[0][0]), searchPost(tree, tree[0][0])]
    return answer;
}
//트리 만들기
function binary(nodeinfo) {
    nodeinfo = nodeinfo.map((ele, i) => {//번호주입
        return [...ele, i + 1]//
    })
    nodeinfo.sort((a, b) => {//y좌표는 높이, x좌표는 같은 높이의 노드들이므로 y는 내림차순, x는 올림차순으로 정렬
        if (a[1] == b[1]) {
            return a[0] - b[0]
        }
        return b[1] - a[1]
    })

    //같은 높이인 것들끼리 배열로 묶기
    //layer배열의 0번은 root가 된다.
    let tmp = [];
    let thisLayerN = 0;
    let layer = [];
    nodeinfo.forEach((ele, i) => {
        if (i === 0) {
            tmp.push([ele[0], ele[2]]);
            thisLayerN = ele[1];
        } else {
            if (thisLayerN === ele[1]) {
                tmp.push([ele[0], ele[2]])
            } else {
                layer.push(tmp);
                tmp = [[ele[0], ele[2]]];
                thisLayerN = ele[1];
            }
        }

        if (i === nodeinfo.length - 1) {
            layer.push(tmp);
        }
    })
    return layer;

}
function getLeft(tree, value) {
    return tree.reduce((acc, cur, i) => {
        if (i > 0) {
            let result = cur.filter((ele) => ele[0] < value[0])
            if (result.length !== 0)
                acc.push(result)
        }
        return acc;
    }, [])
}
function getRight(tree, value) {
    return tree.reduce((acc, cur, i) => {
        if (i > 0) {
            let result = cur.filter((ele) => ele[0] > value[0])
            if (result.length !== 0)
                acc.push(result)
        }
        return acc;
    }, [])
}
function searchPre(tree, value) {
    //다음 레이어층 여부 확인
    //return [현재값,다음나올값]
    if (tree.length === 1) {
        return [value[1]];
    }
    let left = getLeft(tree, value);
    let right = getRight(tree, value);
    //
    //
    let leftSide = [];
    if (left.length !== 0) {
        leftSide = [...searchPre(left, left[0][0])];
    }
    let rightSide = [];
    if (right.length !== 0) {
        rightSide = [...searchPre(right, right[0][0])];
    }
    return [value[1], ...leftSide, ...rightSide]
}
function searchPost(tree, value) {
    //다음 레이어층 여부 확인
    //return [현재값,다음나올값]
    if (tree.length === 1) {
        return [value[1]];
    }
    let left = getLeft(tree, value);
    let right = getRight(tree, value);
    //
    //
    let leftSide = [];
    if (left.length !== 0) {
        leftSide = [...searchPost(left, left[0][0])];
    }
    let rightSide = [];
    if (right.length !== 0) {
        rightSide = [...searchPost(right, right[0][0])];
    }
    return [...leftSide, ...rightSide, value[1]]
}