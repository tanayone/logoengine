function Cmpo(){

    let url = "http://localhost:8080/test";
   let data = fetch(url, {
        method : 'GET'
      }).then((res)=>res.json()).then((res)=>{
        return res.name;
      });

      return(
        <p>{data}</p>
      );
}

export default Cmpo;