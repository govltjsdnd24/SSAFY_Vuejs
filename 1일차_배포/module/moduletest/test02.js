import cal from './test02_module.js';
console.log(cal.title);
console.log(cal.add(20, 10));
console.log(cal.sub(20, 10));

const {createApp, ref, watch} = Vue
createApp({
  setup(){
    const num1 = ref(20);
    const num2 = ref(10);
    const op = ref('-');
    const result = ref(0);

    let doCal = function(){
      
      if (op.value === '+') {
        result.value = cal.add(num1.value, num2.value);
      } else {
        result.value = cal.sub(num1.value, num2.value);
      }      
    }
    watch(op,(newval,oldval)=>{
      if (newval === '+') {
        result.value = cal.add(num1.value, num2.value);
      } else {
        result.value = cal.sub(num1.value, num2.value);
      }
    })
    return{
      num1,num2,op,result,doCal
    }
  }
}).mount("#app")
