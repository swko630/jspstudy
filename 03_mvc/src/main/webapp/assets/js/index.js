/**
 * 
 */
 const getContextPath = () => {
   const host = location.host; /* localhost:8080 */
   const url = location.href /* http://localhost:8080/mvc/getDate.do */
   const begin = url.indexOf(host) + host.length;
   const end = url.indexOf('/', begin + 1);
   return url.substring(begin, end);
   
 }

 const getDateTime = () => {
   const type = document.getElementById('type');
   if(type.value === 'date'){
     location.href = getContextPath() + '/getDate.do';
 } else if(type.value === 'time'){
   location.href = getContextPath() + '/getTime.do';
 } else if(type.value === 'datetime'){
   location.href = getContextPath() + '/getDateTime.do';
  }
 }
 // 같은 servlet이 받아야 mvc 패턴이다
 // 그러므로 같은 서블릿이 받게 요청하는 주소를 통일하는 방법 = suffix를 붙인다(.do)
 // servlet의 URL Mapping을 모두 지우고 *.do로 수정하면 성공
 
 document.getElementById('btn').addEventListener('click', getDateTime)
 
 
 
 
 
 
 
 
 
 
 
 
 
 