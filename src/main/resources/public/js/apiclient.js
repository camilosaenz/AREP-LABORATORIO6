var apiclient = (function (){

    var url = "https://localhost:5000";

	function login(){
        var usuario = {correo:document.getElementById("correo").value, password:document.getElementById("password").value};
        axios.post(url+"/login",usuario).then(res=>{
            window.location.href="response.html";
        })
    }

    return {
        login : login
    };
})();