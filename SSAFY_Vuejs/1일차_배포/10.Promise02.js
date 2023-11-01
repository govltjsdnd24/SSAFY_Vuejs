//프로미스 생성
const p = new Promise((resolve, reject) => {
  let b = true;
  //let b = false;
  if (b) {
    resolve("인증됨1");
  } else {
    reject("인증안됨");
  }
});

//프로미스 실행
p.then((result) => {
  console.log(result); //인증됨1
  return "인증됨2";
})
  .then((result) => {
    console.log(result); //인증됨2
    //throw new Error("에러발생");
    return "인증됨3";
  })
  .then((result) => {
    console.log(result); //인증됨3
  })
  .catch((err) => {
    console.log("catch : " + err); //에러발생
  });


  