    // Spread Syntax (전개 구문)
    const user1 = { id: 'ssafy1' };
    const user2 = { id: 'ssafy2' };

    const array = [user1, user2];

    // array copy
    const arrayCopy = [...array];
    console.log(array, arrayCopy);

    // 주의 : spread operator의 경우 값 복사가 아닌 주소를 가지고 오기 때문에 값을 바꿀경우 모두 변경(호이스팅)
    user1.id = 'ssafy5';

    // add
    const arrayAdd = [...array, { id: 'ssafy3' }];
    console.log(arrayAdd);

    // object copy
    const user3 = { ...user1 };
    console.log(user3);

    // array concat
    const team1 = ['대전', '광주'];
    const team2 = ['구미', '서울'];
    const team = [...team1, ...team2];
    console.log(team);

    // obejct merge(병합)
    const u1 = { id1: 'ssafy1' };
    const u2 = { id2: 'ssafy2' };
    const u = { ...u1, ...u2 };
    console.log(u);

    // 주의점 : key가 같은 obejct를 병합 하게 되면 마지막 obj가 기존 값을 덮어쓴다.
    const user = { ...user1, ...user2 };
    console.log(user);

    const us1 = {
        id: 'ssafy1',
        func() {
            console.log('11111');
        }
}
    
const arrayus1 = { ...us1 };
console.log(arrayus1);
arrayus1.func();