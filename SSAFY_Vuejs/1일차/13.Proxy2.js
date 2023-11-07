var arr = [1, 3, 5];

const proxy = new Proxy(arr, {
  get: function (target, key, receiver) {
    console.log("## get " + key);
    if (!target[key]) throw new Error(`존재하지 않는 속성(${key})입니다`);
    return target[key];
  },
  set: function (target, key, value) {
    console.log("## set " + key);
    if (!target[key]) throw new Error(`존재하지 않는 속성(${key})입니다`);
    target[key] = value;
  },
});

proxy[1] = 99;
proxy[2] = 100;     //오류발생
proxy.forEach(element => {
  console.log(element);
});
