
    // property shorthand (단축 속성명)

    // 기존
    // const id = 'ssafy',
    //   name = '싸피',
    //   age = 3;
    // const user = {
    //   id: id,
    //   name: name,
    //   age: age,
    // };
    // console.log(user);

    // property shorthand
    // 객체를 정의 할 때 객체의 key값과 value의 값이 같으면, 각각 표기하지 않고 한번만 표기
    const id = 'ssafy',
      name = '싸피',
      age = 3;
    const user = {
      id,
      name,
      age,
    };
    console.log(user)
    console.log(user.name);
    console.log(user.id);
    console.log(user.age);
