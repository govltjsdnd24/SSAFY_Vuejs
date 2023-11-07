
        // 객체의 인자를 호출한다
        var obj = {
            name: '홍길동',
            age: '21'
        }
        for (var key in obj) {
            console.log(key + " : " + obj[key]);
        }

        // 배열의 순환 for
        var arr = [1, 3, 5, 7, 9];
        for (var i of arr) {
            console.log(i);
        }
