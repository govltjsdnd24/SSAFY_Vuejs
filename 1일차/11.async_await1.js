        // async 함수는 프라미스를 반환하고, 프라미스가 아닌 것은 프라미스로 변환하여 반환한다.


        // 1
        // const authorize = function () {
        //     return Promise.resolve('인증됨1');
        // }

        // 2
        // const authorize = async function () {
        //     return Promise.reject('인증됨2');
        // }

        // 3
        const authorize = async function () {
            return '인증됨3';
        }

        console.log(authorize());

    authorize().then(n => console.log("then : " + n))
    .catch(n => console.log("catch : "+n));



