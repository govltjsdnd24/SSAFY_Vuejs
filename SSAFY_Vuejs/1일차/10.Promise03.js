//프로미스 생성
const authorize = (b) => {
  return new Promise((resolve, reject) => {
    if (b) {
      resolve("인증됨");
    } else {
      reject("인증안됨");
    }
  });
};
//프로미스 실행
authorize(true)
  .then((result) => {
    console.log(result); //인증됨
  })
  .catch((err) => {
    console.log(err); //인증됨
  });
