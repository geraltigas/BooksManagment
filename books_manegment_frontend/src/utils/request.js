import axios from "axios";

var request = {
  axios_int : axios.create({
    baseURL:"http://localhost:8081",
    timeout:1000
  }),
  findAll: function (){
    let data;
    return this.axios_int.get("/findall")
  },
  findByName: function (str){
    let data;
    return this.axios_int.get("/findbyname/" + str);
  },
  updateBook: function (obj){
    let data = new FormData();
    data.append("name",obj.name);
    data.append("author",obj.author);
    data.append("iSBN",obj.iSBN);
    return this.axios_int.post("/update", data);
  },
  insertBook: function (obj){
    let data = new FormData();
    data.append("name",obj.name);
    data.append("author",obj.author);
    data.append("iSBN",obj.iSBN);
    return this.axios_int.post("/insert",data);
  },
  deleteBook: function (str){
    let data;
    return this.axios_int.get("/deletebyname/" + str);
  },
}

export {request as request}
